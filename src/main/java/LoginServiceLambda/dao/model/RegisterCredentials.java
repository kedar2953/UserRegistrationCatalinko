package LoginServiceLambda.dao.model;

import java.util.Date;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
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
    private String userId;

    @DynamoDBRangeKey(attributeName = "timestampCreated")
    private Date timestampCreated;

    @DynamoDBAttribute(attributeName = "userType")
    private String userType;

    @DynamoDBAttribute(attributeName = "status")
    private boolean status;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "businessName")
    private String businessName;

    @DynamoDBIndexHashKey(attributeName = "phoneNumber", globalSecondaryIndexName = "PhoneNumberIndex")
    private String phoneNumber;

    @DynamoDBIndexHashKey(attributeName = "emailId", globalSecondaryIndexName = "EmailIdIndex")
    private String emailId;

    @DynamoDBAttribute(attributeName = "address")
    private String address;

    @DynamoDBAttribute(attributeName = "kycStatus")
    private boolean kycStatus;

    @DynamoDBAttribute(attributeName = "GSTIN")
    private String GSTIN;

    @DynamoDBAttribute(attributeName = "onboardingDocsForBuyer")
    private Map<String, String> onboardingDocsForBuyer;

    @DynamoDBAttribute(attributeName = "onboardingDocsForSeller")
    private Map<String, String> onboardingDocsForSeller;
}
