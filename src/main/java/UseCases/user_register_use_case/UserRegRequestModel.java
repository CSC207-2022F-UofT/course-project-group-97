package UseCases.user_register_use_case;

public class UserRegRequestModel {
    /**
     * this class will hold all the info the user inputted to register a new account
     */
    private final String name;
    private final String password;
    private final String repeatPassword;

    /**
     * this method contains getters and setters for the info the new User inputted
     */
    public UserRegRequestModel(String name, String password, String repeatPassword) {
        this.name = name;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    /**
     * Getter for the username
     * @return the name the User wants to use
     */
    public String getName() {

        return this.name;
    }

    /**
     * Getter for the password
     * @return the password the User wants to use
     */
    public String getPassword() {

        return this.password;
    }

    /**
     * Getter for the repeated password
     * @return the repeated password the User wants to use
     */
    public String getRepeatPassword() {

        return this.repeatPassword;
    }
}