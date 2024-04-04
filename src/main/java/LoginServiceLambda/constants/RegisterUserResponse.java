package LoginServiceLambda.constants;

public class RegisterUserResponse {

    private String message;

    public RegisterUserResponse() {
    }

    public RegisterUserResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
