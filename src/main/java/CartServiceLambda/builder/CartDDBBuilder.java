package CartServiceLambda.builder;

import CartServiceLambda.constants.AddToCartRequest;
import CartServiceLambda.constants.AddToCartResponse;
import CartServiceLambda.dao.accessor.CartDDBAccessor;

public class CartDDBBuilder {
    CartDDBAccessor cartDDBAccessor = new CartDDBAccessor();

    public AddToCartResponse addToCart(AddToCartRequest addToCartRequest) {
        System.out.println("Builder:");

        return cartDDBAccessor.addToCart(addToCartRequest);
    }
}
