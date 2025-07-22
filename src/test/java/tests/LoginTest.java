package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.EnvConfig;

class LoginTest extends BaseTest {
    // This class will contain tests for the login functionality
    // It will use the LoginPage class to perform actions and assertions

    @Test
    void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login(EnvConfig.getUsername(), EnvConfig.getPassword());
        Assertions.assertTrue(loginPage.isLoginSuccessful());
    }

    @Test
    void loginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("invalidUser", "invalidPassword");
        Assertions.assertTrue(loginPage.isLoginFailed());
    }
}
