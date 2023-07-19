package searchpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
    public class Searchpage {

        private WebDriver driver;
        private By cookies = By.cssSelector("span[class='base-components__BaseElement-sc-1mosoyj-0 styled__TextSpan-rsekm1-4 dZOmBy kpsign beans-button__text']");
        private By searchbox= By.cssSelector("input[type='search']");
        private By searchbutton= By.cssSelector("[class='styled__SVG-xxa4wh-1 LaUBK beans-desktop-search__icon beans-icon__svg']");

        private By pizzatext= By.cssSelector(".heading-label");

        public Searchpage(WebDriver driver) {
            // PageFactory.initElements(driver,this);
            this.driver = driver;
        }

        public void setCookies() {
            driver.findElement(cookies).click();}
        public void setSearchbox(String product){driver.findElement(searchbox).sendKeys(product);}
        public void setSearchbutton(){driver.findElement(searchbutton).click();}

        public String setpizzatext() { return driver.findElement(pizzatext).getText();
        }
        public String getUrl(){return driver.getCurrentUrl();}
}
