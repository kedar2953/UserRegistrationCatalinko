package LoginServiceLambda.builder;

import LoginServiceLambda.constants.RegisterUserRequest;
import LoginServiceLambda.constants.RegisterUserResponse;
import LoginServiceLambda.dao.accessor.RegisterDDBAccessor;

public class RegisterDDBBuilder {

    private RegisterDDBAccessor registerDDBAccessor = new RegisterDDBAccessor();

    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        System.out.println("Builder:"); // Optional for logging or debugging

        return registerDDBAccessor.registerUser(registerUserRequest);
    }
}
