package hooks;

import driverfactory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utiles.Configreader;

import java.io.IOException;
import java.util.Properties;

public class Hooks {

    private Driverfactory driverfactory;
    private WebDriver driver;

    private Configreader configReader;

    private Properties prop;

    @Before(order = 0)
    public void getProperty() throws IOException {
        configReader = new Configreader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void openBrowser() {
        String browserName = prop.getProperty("browser");
        driverfactory = new Driverfactory();
        driver = driverfactory.init_browser(browserName);
    }

    @After(order = 0)
    public void tearDown() {
        driver.quit();
    }

    @After(order = 1)
    public void screenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            String name = scenario.getName();
            byte[] path = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(path, "imag/png", name);

        }
    }
}