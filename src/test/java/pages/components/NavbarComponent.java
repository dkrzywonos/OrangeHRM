package pages.components;

import com.microsoft.playwright.Page;

public class NavbarComponent {
    // This class represents the navbar component of the application
    private final Page page;

    // Locators
    private final String upgradeButton = "//button[normalize-space()='Upgrade']";
    private final String profileDropdown = "//span[@class='oxd-userdropdown-tab']";
    private final String header = ".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module";

    public enum ProfileOptions {
        ABOUT("About", "//a[normalize-space()='About']"),
        SUPPORT("Support", "//a[normalize-space()='Support']"),
        CHANGE_PASSWORD("Change Password", "//a[normalize-space()='Change Password']"),
        LOGOUT("Logout", "//a[normalize-space()='Logout']");

        private final String label;
        private final String selector;

        ProfileOptions(String label, String selector) {
            this.label = label;
            this.selector = selector;
        }

        public String getLabel() {
            return label;
        }

        public String getSelector() {
            return selector;
        }
    }

    //Constructor
    public NavbarComponent(Page page) {
        this.page = page;
    }

    // Action methods
    public void clickUpgradeButton() {
        page.click(upgradeButton);
    }

    public void clickProfileDropdown() {
        page.click(profileDropdown);
    }

    public void selectProfileOption(ProfileOptions option) {
        // check if the profile dropdown is open
        if (!page.isVisible(profileDropdown)) {
            clickProfileDropdown();
        }
        // Click the appropriate option based on the input
        page.click(option.getSelector());
    }

    public String getHeaderText() {
        return page.locator(header).textContent();
    }
}
