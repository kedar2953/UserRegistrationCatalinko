## Introduction
Each buyer will have a cart. Users should be able to add, remove(modify) and move items to the watchlist from cart. When a user requests for cart details, it will show all items and total cost of cart. For items in cart, users can increase or decrease quantity.

## Features
- Add items to cart
- Modify item quantity in cart
- View cart details
- Remove items from cart

## Endpoints

Cart schema
{ “cartId”: <>, “User_id”: <>, “metadata”: {[ “Seller_id”: <Seller_id>, “products”: [ { “<product_id>”: { Count: 2, Price: 3214.323 } } ] ]} }

GET /cart/{userId} This call should return the active cart for the user.

POST /cart/addItem This function will take a list of items in the payload. Payload schema as follows:

{ “userId”: <user_id>, “products”: [ { “seller_id”: <seller_id>, “product_id”: “23fdst4tfdgr6yrtfdbvr576ytre”, “count”: 3, “price”: } ] }

This will add a new item in the cart with count. PUT /cart/{cartId} This function will take a list of items in the payload. Payload schema as follow:

{ “products”: [ { “Seller_id”: <seller_id>, “product_id”: “23fdst4tfdgr6yrtfdbvr576ytre”, “Count”: <>, “price”:<>, } ]

This will remove products from the cart or if an item already exists, increase the count by provided item count.
