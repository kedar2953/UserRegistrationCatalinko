package CartServiceLambda.builder;

import CartServiceLambda.constants.AddToCartRequest;
import CartServiceLambda.constants.AddToCartResponse;
import CartServiceLambda.dao.accessor.CartDDBAccessor;

public class CartDDBBuilder {
    CartDDBAccessor cartDDBAccessor;

    public AddToCartResponse addToCart(AddToCartRequest addToCartRequest) {
        return cartDDBAccessor.addToCart(addToCartRequest);
    }
}
