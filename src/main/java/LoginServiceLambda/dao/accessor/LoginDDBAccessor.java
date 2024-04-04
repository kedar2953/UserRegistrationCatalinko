package LoginServiceLambda.dao.accessor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.HttpResponse;


import LoginServiceLambda.constants.SendOTPRequest;
import LoginServiceLambda.constants.SendOTPResponse;
import LoginServiceLambda.constants.VerifyOTPRequest;
import LoginServiceLambda.constants.VerifyOTPResponse;



public class LoginDDBAccessor {

    private AmazonDynamoDB amazonDynamoDB;
    private String DYNAMODB_TABLE_NAME = "LoginTable";
    private String REGION = "ap-south-1";

    

    private String generateRandomOTP() {
        Random random = new Random();
        StringBuilder otpBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            otpBuilder.append(random.nextInt(10));
        }
        return otpBuilder.toString();
    }

    private void initDynamoDbClient() {
        System.out.println("Accessor:");

        try {
            this.amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                    .withRegion(REGION)
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public SendOTPResponse sendOTP(SendOTPRequest sendOTPRequest) {
        this.initDynamoDbClient();
        String phoneNumber = sendOTPRequest.getPhoneNumber();

        String otp = generateRandomOTP();
        try {
            HttpResponse<String> response = Unirest.post("https://control.msg91.com/api/v5/otp")
                    .header("Content-Type", "application/json")
                    .queryString("template_id", "66065406d6fc05500f09b212")
                    .queryString("mobile", phoneNumber)
                    .queryString("authkey", "419082AxtdnI0xvo6605ca3fP1")
                    .queryString("otp_expiry", "5")
                    .body("{\"OTP\": \"" + otp + "\"}")
                    .asString();

            if (response.getStatus() == 200) {
                // OTP sent successfully
                SendOTPResponse otpResponse = new SendOTPResponse();
                otpResponse.setMessage("OTP sent successfully!");
                return otpResponse;
            } else {
                // Handle API error response
                System.out.println("Failed to send OTP. API response: " + response.getBody());
                throw new RuntimeException("Failed to send OTP.");
            }
        } catch (UnirestException e) {
            // Handle Unirest exception
            System.out.println("Error occurred while sending OTP: " + e.getMessage());
            throw new RuntimeException("Failed to send OTP.");
        }
        
    }

    public VerifyOTPResponse verifyOTP(VerifyOTPRequest verifyOTPRequest) throws ConditionalCheckFailedException {
        this.initDynamoDbClient();
        String phoneNumber = verifyOTPRequest.getPhoneNumber();
        String providedOTP = verifyOTPRequest.getOtp();

        // OTP and expiry time from DynamoDB
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("phoneNumber", new AttributeValue(phoneNumber));
        Map<String, AttributeValue> item = amazonDynamoDB.getItem(DYNAMODB_TABLE_NAME, key).getItem();

        if (item == null) {
            throw new IllegalArgumentException("Invalid phone number or OTP not sent");
        }

        String storedOTP = item.get("otp").getS();
        long otpExpiryTime = Long.parseLong(item.get("otpExpiryTime").getS());

        // OTP validity
        if (!providedOTP.equals(storedOTP) || System.currentTimeMillis() > otpExpiryTime) {
            throw new IllegalArgumentException("Invalid OTP or OTP expired");
        }

        // OTP verified, remove OTP details from DynamoDB (optional)
        amazonDynamoDB.deleteItem(DYNAMODB_TABLE_NAME, key);

        VerifyOTPResponse response = new VerifyOTPResponse();
        response.setMessage("Welcome User!");
        return response;
    }
}
