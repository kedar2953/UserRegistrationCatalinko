package LoginServiceLambda.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import LoginServiceLambda.component.LoginComponent;
import LoginServiceLambda.constants.AppSyncRequest;
import LoginServiceLambda.constants.SendOTPRequest;
import LoginServiceLambda.constants.SendOTPResponse;
import LoginServiceLambda.constants.VerifyOTPRequest;
import LoginServiceLambda.constants.VerifyOTPResponse;

import java.util.List;
import java.util.Map;

public class VerifyOTPActivity implements RequestHandler<Map<String,Object>, VerifyOTPResponse> {
    LoginComponent loginComponent = new LoginComponent();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public VerifyOTPResponse handleRequest(Map<String,Object> event, Context context) {
        System.out.println("Activity:");

        String jsonString = gson.toJson(event);
        AppSyncRequest payload = gson.fromJson(jsonString, AppSyncRequest.class);

        Map<String, Object> arguments = payload.getArguments();
        Map<String, Object> identity = payload.getIdentity();
        String fieldName = payload.getFieldName();

        String inputJson = gson.toJson(arguments.get("input"));
        Map<String, Object> inputMap = gson.fromJson(inputJson, new TypeToken<Map<String, Object>>(){}.getType());
        // Extract userId and itemIds from the input map
        String phoneNumber = (String) inputMap.get("phoneNumber");
        String otp = (String) inputMap.get("otp");
        String otpExpiryTime = (String) inputMap.get("otpExpiryTime");
        

      

        VerifyOTPRequest verifyOTPRequest = new VerifyOTPRequest();
        verifyOTPRequest.setOtp(otp);
        verifyOTPRequest.setPhoneNumber(phoneNumber);
        

        System.out.println("Request:" +gson.toJson(verifyOTPRequest));

        // SendOTPResponse sendOTPResponse  = loginComponent.sendOTP(sendOTPRequest);
        VerifyOTPResponse verifyOTPResponse  = loginComponent.verifyOTP(verifyOTPRequest);


        return verifyOTPResponse;
    }
    

}
     