package CartServiceLambda.dao.accessor;

import CartServiceLambda.constants.AddToCartRequest;
import CartServiceLambda.constants.AddToCartResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;

public class CartDDBAccessor {

    private AmazonDynamoDB amazonDynamoDB;

    private String DYNAMODB_TABLE_NAME = "CartInfoStore";
    private String REGION = "ap-south-1";

    public AddToCartResponse addToCart(AddToCartRequest addToCartRequest) throws ConditionalCheckFailedException {
        this.initDynamoDbClient();

        Map<String, AttributeValue> attributesMap = new HashMap<>();

        //TODO: other attributes, append etc.
        attributesMap.put("userId", new AttributeValue(addToCartRequest.getUserId()));
        attributesMap.put("items", new AttributeValue(Arrays.asList(addToCartRequest.getItems())));

        // compute cart value
        String cartValue = "134233";
        attributesMap.put("cartValue", new AttributeValue(cartValue));

        amazonDynamoDB.putItem(DYNAMODB_TABLE_NAME, attributesMap);

        AddToCartResponse addToCartResponse = new AddToCartResponse();
        addToCartResponse.setMessage("Saved Successfully!!!");
        return addToCartResponse;
    }

    private void initDynamoDbClient() {
        this.amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withRegion(REGION)
                .build();
    }
}
