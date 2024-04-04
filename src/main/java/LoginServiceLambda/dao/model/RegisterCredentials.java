package LoginServiceLambda.dao.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "UserCredentials") 

public class RegisterCredentials {

    @DynamoDBHashKey(attributeName = "userId")  
    private String userId; // UUIDs 

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private String emailId;

    @DynamoDBAttribute
    private String organisation;

    @DynamoDBAttribute
    private String password; 

    @DynamoDBAttribute
    private String state;

    @DynamoDBAttribute
    private String referralCode; 

    @DynamoDBAttribute
    private String phoneNumber; 
    
}
