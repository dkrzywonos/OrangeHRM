package pages.components;

import com.microsoft.playwright.Page;

public class SidebarComponent {
    // This class represents the sidebar component of the application
    private final Page page;

    // Locators
    public enum SidebarLocators {
        ADMIN_LINK("a[href='/web/index.php/admin/viewAdminModule']"),
        PIM_LINK("a[href='/web/index.php/pim/viewPimModule']"),
        LEAVE_LINK("a[href='/web/index.php/leave/viewLeaveModule']"),
        TIME_LINK("a[href='/web/index.php/time/viewTimeModule']"),
        RECRUITMENT_LINK("a[href='/web/index.php/recruitment/viewRecruitmentModule']"),
        MY_INFO_LINK("a[href='/web/index.php/pim/viewMyDetails']"),
        PERFORMANCE_LINK("a[href='/web/index.php/performance/viewPerformanceModule']"),
        DASHBOARD_LINK("a[href='/web/index.php/dashboard/index']"),
        DIRECTORY_LINK("a[href='/web/index.php/directory/viewDirectory']"),
        MAINTENANCE_LINK("a[href='/web/index.php/maintenance/viewMaintenanceModule']"),
        CLAIM_LINK("a[href='/web/index.php/claim/viewClaimModule']"),
        BUZZ_LINK("a[href='/web/index.php/buzz/viewBuzz']");


        private final String selector;

        SidebarLocators(String selector) {
            this.selector = selector;
        }

        public String getSelector() {
            return selector;
        }
    }

    private final String searchInput = "input[placeholder='Search']";


    // Constructor
    public SidebarComponent(Page page) {
        this.page = page;
    }

    // Action methods
    public void clickLink(SidebarLocators locator) {
        page.click(locator.getSelector());
    }

    public boolean isLinkVisible(SidebarLocators locator) {
        return page.isVisible(locator.getSelector());
    }

    public void search(String query) {
        page.fill(searchInput, query);
        page.press(searchInput, "Enter");
    }

    public void searchType(String query) {
        page.type(searchInput, query);
    }

    public String getSearchValue() {
        return page.inputValue(searchInput);
    }

    public void clearSearch() {
        page.fill(searchInput, "");
    }

}
