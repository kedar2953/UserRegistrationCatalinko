package CartServiceLambda.constants;

public class AddToCartRequest {
    private String userId;
    private String[] itemIDs;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getItems() {
        return itemIDs;
    }

    public void setItemIDs(String[] itemIDs) {
        this.itemIDs = itemIDs;
    }
}
