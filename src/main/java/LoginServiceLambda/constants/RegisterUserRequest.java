package LoginServiceLambda.constants;

import java.util.Map;
import java.util.Date;

public class RegisterUserRequest {

    private String userId; // Added
    private Date timestampCreated; // Added
    private String userType;
    private boolean status;
    private String name;
    private String businessName;
    private String phoneNumber;
    private String emailId;
    private String address;
    private boolean kycStatus;
    private String GSTIN;

    private Map<String, String> onboardingDocsForBuyer;
    private Map<String, String> onboardingDocsForSeller;

    public RegisterUserRequest(String userId, Date timestampCreated, String userType, boolean status, String name, String businessName, String phoneNumber, String emailId, String address, boolean kycStatus, String GSTIN, Map<String, String> onboardingDocsForBuyer, Map<String, String> onboardingDocsForSeller) {
        this.userId = userId;
        this.timestampCreated = timestampCreated;
        this.userType = userType;
        this.status = status;
        this.name = name;
        this.businessName = businessName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.address = address;
        this.kycStatus = kycStatus;
        this.GSTIN = GSTIN;
      
        this.onboardingDocsForBuyer = onboardingDocsForBuyer;
        this.onboardingDocsForSeller = onboardingDocsForSeller;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(Date timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(boolean kycStatus) {
        this.kycStatus = kycStatus;
    }

    public String getGSTIN() {
        return GSTIN;
    }

    public void setGSTIN(String GSTIN) {
        this.GSTIN = GSTIN;
    }


    public Map<String, String> getOnboardingDocsForBuyer() {
        return onboardingDocsForBuyer;
    }

    public void setOnboardingDocsForBuyer(Map<String, String> onboardingDocsForBuyer) {
        this.onboardingDocsForBuyer = onboardingDocsForBuyer;
    }

    public Map<String, String> getOnboardingDocsForSeller() {
        return onboardingDocsForSeller;
    }

    public void setOnboardingDocsForSeller(Map<String, String> onboardingDocsForSeller) {
        this.onboardingDocsForSeller = onboardingDocsForSeller;
    }
}
