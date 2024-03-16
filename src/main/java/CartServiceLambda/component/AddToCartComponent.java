package CartServiceLambda.component;

import CartServiceLambda.constants.AddToCartRequest;
import CartServiceLambda.constants.AddToCartResponse;
import CartServiceLambda.builder.CartDDBBuilder;

public class AddToCartComponent {
    CartDDBBuilder cartDDBBuilder;

    public AddToCartResponse addToCart(AddToCartRequest addToCartRequest) {
        AddToCartResponse addToCartResponse = cartDDBBuilder.addToCart(addToCartRequest);
        return addToCartResponse;
    }
}
