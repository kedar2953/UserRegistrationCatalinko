package LoginServiceLambda.constants;

public class SendOTPResponse {

    private String message;  // Can be used to indicate success, failure, or additional information

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
