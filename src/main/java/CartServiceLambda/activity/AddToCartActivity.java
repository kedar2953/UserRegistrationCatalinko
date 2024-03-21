package CartServiceLambda.activity;

import CartServiceLambda.constants.AddToCartRequest;
import CartServiceLambda.constants.AddToCartResponse;
import CartServiceLambda.component.AddToCartComponent;
import CartServiceLambda.constants.AppSyncRequest;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

public class AddToCartActivity implements RequestHandler<Map<String,Object>, AddToCartResponse> {
    AddToCartComponent addToCartComponent = new AddToCartComponent();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public AddToCartResponse handleRequest(Map<String,Object> event, Context context) {
        System.out.println("Activity:");

        String jsonString = gson.toJson(event);
        AppSyncRequest payload = gson.fromJson(jsonString, AppSyncRequest.class);

        Map<String, Object> arguments = payload.getArguments();
        Map<String, Object> identity = payload.getIdentity();
        String fieldName = payload.getFieldName();

        String inputJson = gson.toJson(arguments.get("input"));
        Map<String, Object> inputMap = gson.fromJson(inputJson, new TypeToken<Map<String, Object>>(){}.getType());

        // Extract userId and itemIds from the input map
        String userId = (String) inputMap.get("userId");
        List <String> itemIds = (List<String>) inputMap.get("itemIDs");
        String[] itemIDs = itemIds.toArray(new String[0]);

        AddToCartRequest addToCartRequest = new AddToCartRequest();
        addToCartRequest.setUserId(userId);
        addToCartRequest.setItemIDs(itemIDs);
        System.out.println("Request: " + gson.toJson(addToCartRequest));

        AddToCartResponse addToCartResponse = addToCartComponent.addToCart(addToCartRequest);
        return addToCartResponse;
    }
}
