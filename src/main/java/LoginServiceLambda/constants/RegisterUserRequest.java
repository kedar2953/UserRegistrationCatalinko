package LoginServiceLambda.constants;

public class RegisterUserRequest {

    private String name;
    private String emailId;
    private String organisation;
    private String password;
    private String state;
    private String phoneNumber;
    private String referralCode; // Optional
    

    public RegisterUserRequest(String name, String emailId, String organisation, String password, String state,String phoneNumber, String referralCode) {
        this.name = name;
        this.emailId = emailId;
        this.organisation = organisation;
        this.password = password;
        this.state = state;
        this.phoneNumber=phoneNumber;
        this.referralCode = referralCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }
}
