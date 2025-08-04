package tests.admin;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.AdminPage;
import pages.LoginPage;
import utils.EnvConfig;

public class UserManagementTest extends BaseTest {
    // This class will contain tests for user management functionality
    // It will use the AdminPage class to perform actions and assertions

    // Example test method
     @Test
     void test() {
         LoginPage loginPage = new LoginPage(page);
         loginPage.login(EnvConfig.getUsername(), EnvConfig.getPassword());
         AdminPage adminPage = new AdminPage(page);
         adminPage.openFromSidebar();

         adminPage.clickTab(AdminPage.AdminLocators.USER_MANAGEMENT);
         adminPage.clickTab(AdminPage.AdminLocators.USERS);

         adminPage.clickTabWithParent(AdminPage.AdminLocators.EMPLOYMENT_STATUS);
     }
}
