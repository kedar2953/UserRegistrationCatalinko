package CartServiceLambda.dao.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBVersionAttribute;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static CartServiceLambda.constants.TableConstants.CART_TABLE_ATTRIBUTE_ID;
import static CartServiceLambda.constants.TableConstants.CART_ID_INDEX;

@Builder
@ToString
@DynamoDBTable(tableName = "CartInfoStore")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class CartPojo {
    @DynamoDBHashKey(attributeName = CART_TABLE_ATTRIBUTE_ID)
    @DynamoDBIndexRangeKey(
            globalSecondaryIndexNames = {
                    CART_ID_INDEX
            }
    )
    private String cartId;

    @DynamoDBAttribute
    private String userId;

    @DynamoDBAttribute
    private String[] items;

    @DynamoDBAttribute
    private String status;

    @DynamoDBAttribute
    private String cartValue;
}
