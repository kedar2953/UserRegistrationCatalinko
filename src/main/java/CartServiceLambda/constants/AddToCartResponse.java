package CartServiceLambda.constants;
import com.google.gson.Gson;

public class AddToCartResponse {
    private String message;

    // standard getters and setters
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
