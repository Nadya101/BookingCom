package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class HotelSteps {
    public static final String baseURL = "https://www.booking.com";

    @Given("User opens Booking.com page")
    public void userOpensBookingComPage() {
        open(baseURL + "/searchresults.en-gb.html");
    }

    @And("User type {string} in search field")
    public void userTypeHotelInSearchField(String hotel) {
        $(By.id("ss")).clear();
        $(By.id("ss")).sendKeys(hotel);
        $(By.id("ss")).click();
    }

    @When("User click on Search button")
    public void userClickOnSearchButton() {
        $(By.cssSelector(".sb-searchbox__button")).click();
    }

    @Then("Hotel {string} should be on the first page")
    public void hotelShouldBeOnTheFirstPage(String hotel) {
        ArrayList<String> hotelsNames = new ArrayList<>();
        for (SelenideElement element : $$(By.xpath("//*[@data-testid='title']"))) {
            hotelsNames.add(element.getText());
        }
        Assert.assertTrue(hotelsNames.contains(hotel));
    }


    @And("Hotel {string} rating is {string}")
    public void hotelRatingIsRating(String hotel, String rating) {
        String ratingXpath = "//*[contains(text(), '" + hotel + "')]/ancestor::div[@data-testid='property-card']//div[contains(@aria-label,'Scored')] ";
        String getRating = $(By.xpath(ratingXpath)).getText();
        Assert.assertEquals(getRating, rating);
    }

}