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
@DynamoDBTable(tableName = "LoginTable") 

public class LoginCredentials {
    @DynamoDBHashKey(attributeName = "phoneNumber")
    private String phoneNumber;

    @DynamoDBAttribute
    private String otp;  

    @DynamoDBAttribute
    private Long otpExpiryTime;  

    
}
