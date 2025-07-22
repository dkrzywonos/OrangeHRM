package base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    private static Playwright pw;
    private static Browser browser;
    private BrowserContext context;
    protected Page page;

    protected void launchBrowser(String type) {
        if (pw != null) {
            pw.close();
            pw = null;
            browser = null;
        }
        pw = Playwright.create();
        switch (type) {
            case "firefox":
                browser = pw.firefox().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(1000));
                break;
            case "webkit":
                browser = pw.webkit().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(1000));
                break;
            default:
                browser = pw.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(1000));
        }
        context = browser.newContext();
        page = context.newPage();
    }

    @BeforeEach
    void beforeEach() {
        // by default launch Chromium if launchBrowser was not called in the test
        if (pw == null || browser == null || context == null || page == null) {
            launchBrowser("chromium");
        }
    }

    @AfterEach
    void afterEach() {
        if (context != null) {
            context.close();
            context = null;
            page = null;
        }
    }

    @AfterAll
    static void afterAll() {
        if (browser != null) {
            browser.close();
            browser = null;
        }
        if (pw != null) {
            pw.close();
            pw = null;
        }
    }
}
