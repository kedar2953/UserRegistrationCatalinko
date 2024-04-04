package LoginServiceLambda.builder;

import LoginServiceLambda.constants.SendOTPRequest;
import LoginServiceLambda.constants.SendOTPResponse;
import LoginServiceLambda.constants.VerifyOTPRequest;
import LoginServiceLambda.constants.VerifyOTPResponse;
import LoginServiceLambda.dao.accessor.LoginDDBAccessor;

public class LoginDDBBuilder {
    LoginDDBAccessor LoginDDBAccessor = new LoginDDBAccessor();

    public SendOTPResponse sendOTP(SendOTPRequest sendOTPRequest) {
        System.out.println("Builder:");

        return LoginDDBAccessor.sendOTP(sendOTPRequest);
    }
    public VerifyOTPResponse verifyOTP(VerifyOTPRequest veriOtpRequest) {
        System.out.println("Builder:");

        return LoginDDBAccessor.verifyOTP(veriOtpRequest);
    }
}
