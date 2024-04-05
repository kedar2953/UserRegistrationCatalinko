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
        String phoneNumber = (String) inputMap.get("phoneNumber");
        String userType = (String) inputMap.get("userType");
        String businessName = (String) inputMap.get("businessName");
        String address = (String) inputMap.get("address");
        boolean kycStatus = (boolean) inputMap.get("kycStatus");
        boolean status = (boolean) inputMap.get("status");
        String GSTIN = (String) inputMap.get("GSTIN");
        Map<String, String> onboardingDocsForBuyer = (Map<String, String>) inputMap.get("onboardingDocsForBuyer");
        Map<String, String> onboardingDocsForSeller = (Map<String, String>) inputMap.get("onboardingDocsForSeller");
        // boolean status = false; // Set the status as default

        // Print extracted user details individually
        System.out.println("Name: " + name);
        System.out.println("Email: " + emailId);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("User Type: " + userType);
        System.out.println("Business Name: " + businessName);
        System.out.println("Address: " + address);
        System.out.println("KYC Status: " + kycStatus);
        System.out.println("GSTIN: " + GSTIN);
        System.out.println("Onboarding Docs For Buyer: " + onboardingDocsForBuyer);
        System.out.println("Onboarding Docs For Seller: " + onboardingDocsForSeller);
        System.out.println("Status: " + status);
        
        // Create RegisterUserRequest object
        RegisterUserRequest registerUserRequest = new RegisterUserRequest(
                null, null, userType, status, name, businessName, phoneNumber, emailId, address, kycStatus, GSTIN, onboardingDocsForBuyer, onboardingDocsForSeller);

        // Register user using RegisterComponent
        RegisterUserResponse registerUserResponse = registerComponent.register(registerUserRequest);

        return registerUserResponse;
    }
}
