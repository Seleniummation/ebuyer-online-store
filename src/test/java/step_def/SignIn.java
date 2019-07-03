package step_def;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.base.BasePage;
import pages.CustomerAccount;
import pages.LandingPage;

import static org.junit.Assert.assertEquals;

public class SignIn {

    @Given("Customers are on {string} home page")
    public void customersAreOnHomePage(String arg0) {

        LandingPage lp = new  LandingPage();
        lp.launchUrl();
    }

    @And("Customer clicks {string} link")
    public void customerClicksLink(String arg0) {

        BasePage bp =  new BasePage();
        bp.clickSignInLink();
    }

    @And("Customer enters {string} and {string}")
    public void customerEntersAnd(String email_address, String password) {

        CustomerAccount  cus = new  CustomerAccount();
        cus.setEmail(email_address);
        cus.setPassword(password);

    }

    @When("Customer clicks sign in")
    public void customerClicksSignIn() {

        CustomerAccount  cus = new  CustomerAccount();
        cus.submitForm();
    }

    @Then("Username of customer is displayed")
    public void usernameOfCustomerIsDisplayed() {

        String username = BasePage.getUserName();
        assertEquals(username, BasePage.getUserName());
        System.out.println("Customer username is displayed as "  +  BasePage.getUserName());
    }

    @Then("Sign in or register text is displayed")
    public void signInOrRegisterTextIsDisplayed() {

        String expected = "Sign In or Register";
        assertEquals(expected, CustomerAccount.getSignInOrRegisterText());
        System.out.println("Text is displayed as "  +  CustomerAccount.getSignInOrRegisterText());
    }
}
