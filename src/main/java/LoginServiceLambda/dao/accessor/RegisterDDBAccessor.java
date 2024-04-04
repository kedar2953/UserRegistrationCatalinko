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

import org.mindrot.jbcrypt.BCrypt; 

public class RegisterDDBAccessor {

    private AmazonDynamoDB amazonDynamoDB;
    private String DYNAMODB_TABLE_NAME = "UserCredentials"; 
    private String REGION = "ap-south-1";

    private void initDynamoDbClient() {
        System.out.println("Accessor:");

        try {
            this.amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                    .withRegion(REGION)
                    .build();
        } catch (Exception e) {
            System.out.println("Error in initdb client"+ e.getMessage());
        }
    }

    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        this.initDynamoDbClient();
        System.out.println(registerUserRequest);    
        String userId = UUID.randomUUID().toString(); 
        String name = registerUserRequest.getName();
        String emailId = registerUserRequest.getEmailId();
        String organisation = registerUserRequest.getOrganisation();
        String password = registerUserRequest.getPassword(); 
        String state = registerUserRequest.getState();
        String phoneNumber = registerUserRequest.getPhoneNumber();
        String referralCode = registerUserRequest.getReferralCode(); // Optional
    
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
        
        Map<String, AttributeValue> attributesMap = new HashMap<>();
        attributesMap.put("userId", new AttributeValue().withS(userId)); // String attribute
        attributesMap.put("name", new AttributeValue().withS(name)); // String attribute
        attributesMap.put("emailId", new AttributeValue().withS(emailId)); // String attribute
        attributesMap.put("organisation", new AttributeValue().withS(organisation)); // String attribute
        attributesMap.put("password", new AttributeValue().withS(hashedPassword)); // String attribute
        attributesMap.put("state", new AttributeValue().withS(state)); // String attribute
        attributesMap.put("phoneNumber", new AttributeValue().withS(phoneNumber)); // String attribute
        attributesMap.put("referralCode", new AttributeValue().withS(referralCode)); // Optional String attribute
    
        PutItemRequest putItemRequest = new PutItemRequest(DYNAMODB_TABLE_NAME, attributesMap);
        amazonDynamoDB.putItem(putItemRequest);
    
        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("User registered successfully! Please continue to login.");
        return response;
    }
    
}
