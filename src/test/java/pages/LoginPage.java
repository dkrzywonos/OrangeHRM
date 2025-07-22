package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    // This class represents the login page of the application
    private final Page page;

    // Locators
    private final String usernameInput = "#username";
    private final String passwordInput = "#password";
    private final String loginButton = "button[type='submit']";

    // Constructor
    public LoginPage(Page page) {
        this.page = page;
    }

    // Action methods
    // Navigate to the login page
    public void navigateToLoginPage() {
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // Fill in the username field
    public void fillUsername(String username) {
        page.fill(usernameInput, username);
    }

    // Fill in the password field
    public void fillPassword(String password) {
        page.fill(passwordInput, password);
    }

    // Click the login button
    public void clickLoginButton() {
        page.click(loginButton);
    }

    // Method to perform login
    public void login(String username, String password) {
        navigateToLoginPage();
        fillUsername(username);
        fillPassword(password);
        clickLoginButton();
    }

    // Method to check if login was successful by checking if the user is redirected to the dashboard
    public boolean isLoginSuccessful() {
        // You can implement a check here, for example by checking the URL or the presence of a specific element on the dashboard
        return page.url().contains("dashboard");
    }

}
