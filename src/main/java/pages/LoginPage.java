package pages;

public class LoginPage extends BasePage {
    public void login() {
        sendKeysToElement("login_email_input", "user_email");
        clickToElement("login_continue_button");
        sendKeysToElement("login_password_input", "user_password");
        clickToElement("login_submit_button");
    }

    public void logout() {
    }
}
