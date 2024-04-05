package LoginServiceLambda.dao.accessor;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;

import LoginServiceLambda.constants.RegisterUserRequest;
import LoginServiceLambda.constants.RegisterUserResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class RegisterDDBAccessor {

    private AmazonDynamoDB amazonDynamoDB;
    private String DYNAMODB_TABLE_NAME = "UserCredentials";
    private String REGION = "ap-south-1";

    public RegisterDDBAccessor() {
        this.amazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withRegion(REGION).build();
    }

    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        System.out.println("Accessor:");
        System.out.println(registerUserRequest);

        // Generate a unique userId
        String userId = UUID.randomUUID().toString();

        

        // Prepare the item to be put into the DynamoDB table
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("userId", new AttributeValue(userId));
        item.put("timestampCreated", new AttributeValue().withN(String.valueOf(registerUserRequest.getTimestampCreated().getTime())));
        item.put("userType", new AttributeValue(registerUserRequest.getUserType()));
        item.put("status", new AttributeValue().withBOOL(registerUserRequest.getStatus()));
        item.put("name", new AttributeValue(registerUserRequest.getName()));
        item.put("businessName", new AttributeValue(registerUserRequest.getBusinessName()));
        item.put("phoneNumber", new AttributeValue(registerUserRequest.getPhoneNumber()));
        item.put("emailAddress", new AttributeValue(registerUserRequest.getEmailId()));
        item.put("address", new AttributeValue(registerUserRequest.getAddress()));
        item.put("kycStatus", new AttributeValue().withBOOL(registerUserRequest.isKycStatus()));
        item.put("GSTIN", new AttributeValue(registerUserRequest.getGSTIN()));

        Map<String, AttributeValue> onboardingDocsForBuyerAttribute = new HashMap<>();
        for (Map.Entry<String, String> entry : registerUserRequest.getOnboardingDocsForBuyer().entrySet()) {
            onboardingDocsForBuyerAttribute.put(entry.getKey(), new AttributeValue(entry.getValue()));
        }
    
        Map<String, AttributeValue> onboardingDocsForSellerAttribute = new HashMap<>();
        for (Map.Entry<String, String> entry : registerUserRequest.getOnboardingDocsForSeller().entrySet()) {
            onboardingDocsForSellerAttribute.put(entry.getKey(), new AttributeValue(entry.getValue()));
        }

        item.put("onboardingDocsForBuyer", new AttributeValue().withM(onboardingDocsForBuyerAttribute));
        item.put("onboardingDocsForSeller", new AttributeValue().withM(onboardingDocsForSellerAttribute));
        // Create a PutItemRequest
        PutItemRequest putItemRequest = new PutItemRequest(DYNAMODB_TABLE_NAME, item);

        // Put the item into the DynamoDB table
        amazonDynamoDB.putItem(putItemRequest);

        // Prepare and return the response object
        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("User registered successfully! Please continue to login.");
        return response;
    }
}


