package searchsteps;

import driverfactory.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.hamcrest.Matchers;
import org.junit.Assert;
import searchpage.Searchpage;

public class Searchsteps {

    Searchpage searchPage = new Searchpage(Driverfactory.getDriver());

    @Given("User is on Tesco page")
    public void user_is_on_tesco_page() {
        Driverfactory.getDriver().get("https://www.tesco.com/");
        String actual = searchPage.getUrl();
        Assert.assertThat(actual, Matchers.endsWith("https://www.tesco.com/"));

    }

    @When("User accepts cookies")
    public void user_accepts_cookies() {
        searchPage.setCookies();

    }


    @When("User searches for {string} in the search box")
    public void user_searches_for_in_the_search_box(String product) {
        searchPage.setSearchbox(product);

    }

    @When("User clicks on search button")
    public void user_clicks_on_search_button() {
        searchPage.setSearchbutton();

    }

    @Then("User verifies pizza items")
    public void user_verifies_pizza_items() {
        String actual = searchPage.setpizzatext();
        Assert.assertThat(actual, Matchers.equalTo("Results for “pizza”"));
    }

}
