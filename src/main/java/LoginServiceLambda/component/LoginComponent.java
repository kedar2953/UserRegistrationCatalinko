package LoginServiceLambda.component;

import LoginServiceLambda.builder.LoginDDBBuilder;
import LoginServiceLambda.constants.SendOTPRequest;
import LoginServiceLambda.constants.SendOTPResponse;
import LoginServiceLambda.constants.VerifyOTPRequest;
import LoginServiceLambda.constants.VerifyOTPResponse;

public class LoginComponent {
    LoginDDBBuilder loginDDBBuilder = new LoginDDBBuilder();

    public SendOTPResponse sendOTP(SendOTPRequest sendOTPRequest) {
        System.out.println("Component:");

        SendOTPResponse sendOTPResponse = loginDDBBuilder.sendOTP(sendOTPRequest);
        return sendOTPResponse;
    }
    public VerifyOTPResponse verifyOTP(VerifyOTPRequest verifyOTPRequest) {
        System.out.println("Component:");

        VerifyOTPResponse verifyOTPResponse = loginDDBBuilder.verifyOTP(verifyOTPRequest);
        return verifyOTPResponse;
    }
    
}
