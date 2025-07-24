package pages.components;

import com.microsoft.playwright.Page;

public class SidebarComponent {
    // This class represents the sidebar component of the application
    private final Page page;

    // Locators
    private final String adminLink = "a[href='/admin/viewAdminModule']";
    private final String pimLink = "a[href='/pim/viewPimModule']";
    private final String leaveLink = "a[href='/leave/viewLeaveModule']";
    private final String timeLink = "a[href='/time/viewTimeModule']";
    private final String recruitmentLink = "a[href='/recruitment/viewRecruitmentModule']";
    private final String myInfoLink = "a[href='/pim/viewMyDetails']";
    private final String performanceLink = "a[href='/performance/viewPerformanceModule']";
    private final String dashboardLink = "a[href='/dashboard']";
    private final String directoryLink = "a[href='/directory/viewDirectory']";
    private final String maintenanceLink = "a[href='/maintenance/viewMaintenanceModule']";
    private final String claimLink = "a[href='/claim/viewClaimModule']";
    private final String buzzLink = "a[href='/buzz/viewBuzz']";

    private final String searchInput = "input[placeholder='Search']";


    // Constructor
    public SidebarComponent(Page page) {
        this.page = page;
    }

    // Action methods

}
