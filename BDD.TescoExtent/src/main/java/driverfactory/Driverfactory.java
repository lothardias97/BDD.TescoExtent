package driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driverfactory {
    public static ThreadLocal<WebDriver> tsLocal = new ThreadLocal<>();


    public WebDriver init_browser(String browser) {
        System.out.println("The browser name is " + browser);
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tsLocal.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tsLocal.set(new FirefoxDriver());
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            tsLocal.set(new EdgeDriver());
        } else if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            tsLocal.set(new OperaDriver());
        } else {
            System.out.println("Give browser name " + browser);
        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);
        getDriver().manage().deleteAllCookies();
        return getDriver();
    }

    public static WebDriver getDriver() {
        return tsLocal.get();
    }

}
