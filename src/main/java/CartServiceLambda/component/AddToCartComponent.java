package CartServiceLambda.component;

import CartServiceLambda.constants.AddToCartRequest;
import CartServiceLambda.constants.AddToCartResponse;
import CartServiceLambda.builder.CartDDBBuilder;

public class AddToCartComponent {
    CartDDBBuilder cartDDBBuilder = new CartDDBBuilder();

    public AddToCartResponse addToCart(AddToCartRequest addToCartRequest) {
        System.out.println("Component:");

        AddToCartResponse addToCartResponse = cartDDBBuilder.addToCart(addToCartRequest);
        return addToCartResponse;
    }
}
