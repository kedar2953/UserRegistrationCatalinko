package LoginServiceLambda.component;

import LoginServiceLambda.builder.RegisterDDBBuilder;
import LoginServiceLambda.constants.RegisterUserRequest;
import LoginServiceLambda.constants.RegisterUserResponse;


public class RegisterComponent {

    private RegisterDDBBuilder registerDDBBuilder = new RegisterDDBBuilder();

    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        System.out.println("Component:"); // Optional for logging or debugging

        return registerDDBBuilder.register(registerUserRequest);
    }
}
