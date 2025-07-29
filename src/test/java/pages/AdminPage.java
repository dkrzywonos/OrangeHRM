    package pages;

    import com.microsoft.playwright.Page;
    import pages.components.NavbarComponent;
    import pages.components.SidebarComponent;

    public class AdminPage {
        // This class represents the admin page of the application
        private final Page page;
        private final SidebarComponent sidebar;
        private final NavbarComponent navbar;

        // Locators
        // --- User Management ---
        private final String userManagementTab = ".oxd-topbar-body-nav-tab-item:has-text('User Management')";
        private final String usersTab = ".oxd-topbar-body-nav-tab-link:has-text('Users')";
        // --- Job ---
        private final String jobTab = ".oxd-topbar-body-nav-tab-item:has-text('Job')";
        private final String jobTitlesTab = ".oxd-topbar-body-nav-tab-link:has-text('Job Titles')";
        private final String payGradesTab = ".oxd-topbar-body-nav-tab-link:has-text('Pay Grades')";
        private final String employmentStatusTab = ".oxd-topbar-body-nav-tab-link:has-text('Employment Status')";
        private final String jobCategoriesTab = ".oxd-topbar-body-nav-tab-link:has-text('Job Categories')";
        private final String workShiftsTab = ".oxd-topbar-body-nav-tab-link:has-text('Work Shifts')";



        // Constructor
        public AdminPage(Page page) {
            this.page = page;
            this.sidebar = new SidebarComponent(page);
            this.navbar = new NavbarComponent(page);
        }

        // Action methods
        public void openFromSidebar() {
            sidebar.clickLink(SidebarComponent.SidebarLocators.ADMIN_LINK);
        }

        // --- User Management ---
        public void clickUserManagementTab() {
            page.click(userManagementTab);
        }

        public void clickUsersTab() {
            page.click(usersTab);
        }

        // --- Job ---
        public void clickJobTab() {
            page.click(jobTab);
        }

        public void clickJobTitlesTab() {
            page.click(jobTitlesTab);
        }

        public void clickPayGradesTab() {
            page.click(payGradesTab);
        }

        public void clickEmploymentStatusTab() {
            page.click(employmentStatusTab);
        }

        public void clickJobCategoriesTab() {
            page.click(jobCategoriesTab);
        }

        public void clickWorkShiftsTab() {
            page.click(workShiftsTab);
        }





    }
