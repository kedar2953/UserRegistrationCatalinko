package CartServiceLambda.activity;

import CartServiceLambda.constants.AddToCartRequest;
import CartServiceLambda.constants.AddToCartResponse;
import CartServiceLambda.component.AddToCartComponent;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class AddToCartActivity implements RequestHandler<AddToCartRequest, AddToCartResponse> {
    AddToCartComponent addToCartComponent;

    public AddToCartResponse handleRequest(AddToCartRequest addToCartRequest, Context context) {
        AddToCartResponse addToCartResponse = addToCartComponent.addToCart(addToCartRequest);
        return addToCartResponse;
    }
}
