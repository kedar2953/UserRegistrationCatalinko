package LoginServiceLambda.constants;

public class VerifyOTPResponse {

    private String message;
    private String userId;  // Optional: Include userId upon successful verification

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
