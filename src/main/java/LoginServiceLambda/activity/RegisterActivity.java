package LoginServiceLambda.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import LoginServiceLambda.component.RegisterComponent;
import LoginServiceLambda.constants.AppSyncRequest;
import LoginServiceLambda.constants.RegisterUserRequest;
import LoginServiceLambda.constants.RegisterUserResponse;

import java.util.Map;

public class RegisterActivity implements RequestHandler<Map<String, Object>, RegisterUserResponse> {

    private RegisterComponent registerComponent = new RegisterComponent();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public RegisterUserResponse handleRequest(Map<String, Object> event, Context context) {
        System.out.println("Activity:");
        System.out.println("Extracted User Details:");
        
        String jsonString = gson.toJson(event);
        System.out.println("Event: " + jsonString);
        AppSyncRequest payload = gson.fromJson(jsonString, AppSyncRequest.class);
        
        Map<String, Object> arguments = payload.getArguments();
        Map<String, Object> inputMap = (Map<String, Object>) arguments.get("input");

        // Extract user details from inputMap
        String name = (String) inputMap.get("name");
        String emailId = (String) inputMap.get("emailId");
        String organisation = (String) inputMap.get("organisation");
        String password = (String) inputMap.get("password");
        String state = (String) inputMap.get("state");
        String phoneNumber = (String) inputMap.get("phoneNumber");
        String referralCode = (String) inputMap.get("referralCode"); // Optional

        // Print extracted user details individually
        System.out.println("Name: " + name);
        System.out.println("Email: " + emailId);
        System.out.println("Organisation: " + organisation);
        System.out.println("Password: " + password);
        System.out.println("State: " + state);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Referral Code: " + referralCode);
        
        RegisterUserRequest registerUserRequest = new RegisterUserRequest(
                name, emailId, organisation, password, state,phoneNumber, referralCode);

        RegisterUserResponse registerUserResponse = registerComponent.register(registerUserRequest);

        return registerUserResponse;
    }
}
