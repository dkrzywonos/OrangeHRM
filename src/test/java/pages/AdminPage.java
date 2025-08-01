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
        public enum AdminLocators {
            // --- User Management ---
            USER_MANAGEMENT(".oxd-topbar-body-nav-tab-item:has-text('User Management')"),
            USERS(".oxd-topbar-body-nav-tab-link:has-text('Users')"),
            // --- Job ---
            JOB(".oxd-topbar-body-nav-tab-item:has-text('Job')"),
            JOB_TITLES(".oxd-topbar-body-nav-tab-link:has-text('Job Titles')"),
            PAY_GRADES(".oxd-topbar-body-nav-tab-link:has-text('Pay Grades')"),
            EMPLOYMENT_STATUS(".oxd-topbar-body-nav-tab-link:has-text('Employment Status')"),
            JOB_CATEGORIES(".oxd-topbar-body-nav-tab-link:has-text('Job Categories')"),
            WORK_SHIFTS(".oxd-topbar-body-nav-tab-link:has-text('Work Shifts')"),
            // --- Organization ---
            ORGANIZATION(".oxd-topbar-body-nav-tab-item:has-text('Organization')"),
            GENERAL_INFORMATION(".oxd-topbar-body-nav-tab-link:has-text('General Information')"),
            LOCATIONS(".oxd-topbar-body-nav-tab-link:has-text('Locations')"),
            STRUCTURE(".oxd-topbar-body-nav-tab-link:has-text('Structure')");


            private final String selector;

            AdminLocators(String selector) {
                this.selector = selector;
            }

            public String getSelector() {
                return selector;
            }

            public enum Section {
                USER_MANAGEMENT,
                JOB,
                ORGANIZATION
            }

            public Section getSection() {
                switch (this) {
                    case USER_MANAGEMENT, USERS:
                        return Section.USER_MANAGEMENT;
                    case JOB, JOB_TITLES, PAY_GRADES, EMPLOYMENT_STATUS, JOB_CATEGORIES, WORK_SHIFTS:
                        return Section.JOB;
                    case ORGANIZATION, GENERAL_INFORMATION, LOCATIONS,STRUCTURE:
                        return Section.ORGANIZATION;
                    default:
                        throw new IllegalArgumentException("Unknown section for locator: " + this);
                }
            }

        }

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

        public void clickTab(AdminLocators locator) {
            page.click(locator.getSelector());
        }

        public void clickTabWithParent(AdminLocators locator) {
            // Click the parent tab first
            switch (locator.getSection()) {
                case USER_MANAGEMENT -> clickTab(AdminLocators.USER_MANAGEMENT);
                case JOB -> clickTab(AdminLocators.JOB);
                case ORGANIZATION -> clickTab(AdminLocators.ORGANIZATION);
            }
            // Then click the specific tab
            clickTab(locator);
        }

    }
