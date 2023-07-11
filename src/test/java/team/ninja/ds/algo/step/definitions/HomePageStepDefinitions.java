package team.ninja.ds.algo.step.definitions;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import team.ninja.ds.algo.page.object.LandingPage;
import team.ninja.ds.algo.driver.manager.DriverManager;
import team.ninja.ds.algo.page.object.HomePage;
import team.ninja.ds.algo.page.object.RegisterPage;
import team.ninja.ds.algo.page.object.LoginPage;
import team.ninja.ds.algo.utilities.ConfigReader;

public class HomePageStepDefinitions {
	private LandingPage landingPage = new LandingPage(DriverManager.getDriver());
	private HomePage homePage = HomePage.getInstance();
	private LoginPage loginPage = LoginPage.getInstance();
	private WebDriver driver = DriverManager.getDriver();
	private ConfigReader reader = new ConfigReader();
	String expected = null;
	Properties prop;
	WebDriverWait wait;
	String actual_PageUrl, expected_PageUrl;

	@Given("user opens the dsalgo portal link") // Assertion to check whether the page landed on the landing page
	public void user_opens_the_dsalgo_portal_link() {
		String landingPage = DriverManager.getDriver().getCurrentUrl();
		String expectedLandingPage = "https://dsportalapp.herokuapp.com/";
		assertEquals(landingPage, expectedLandingPage);
	}

	@When("user clicks on {string} button") // Clicks the get Started button
	public void user_clicks_on_button(String getStarted) throws InterruptedException {
		landingPage = new LandingPage(DriverManager.getDriver());
		landingPage.click_Btn();
		System.out.println("User Clicks on the " + getStarted + "button on the application");
	}

	@Then("user redirected to home page and the Title on the HomePage is {string}") // Checking the Title on the
																					// HomePage
	public void user_redirected_to_home_page(String actualTitle) {
		String expectedTitle = landingPage.get_Title();
		assertEquals(actualTitle, expectedTitle);
	}

	@Given("user is on Home Page")
	public void user_is_on_home_page() throws InterruptedException {
		 homePage.homepage();
		// homePage=landingPage.click_Btn();
		System.out.println("from homePage :  " + DriverManager.getDriver().getCurrentUrl());
	}

	@When("The user clicks on data structure dropdown before signin")
	public void the_user_clicks_on_data_structure_dropdown_before_signin() throws InterruptedException {
		System.out.println("User Clicks on Drop Down DataStructures Button");
		// System.out.println("before drop down click
		// "+DriverFactory.getDriver().getCurrentUrl());
	}

	@Then("The user select any dropdown menu {string}")
	public void The_user_select_any_dropdown_menu(String menuoption) throws InterruptedException {
		// System.out.println("before drop down check
		// "+DriverFactory.getDriver().getCurrentUrl());
		homePage.dropDownList(menuoption);
	}

	@Then("The user should get the error message {string}")
	public void The_user_should_get_the_error_message(String actual_ErrorMsg) {
		String expected_ErrorMsg = homePage.getErr_msg();
		assertEquals(expected_ErrorMsg, actual_ErrorMsg);
	}

	@When("The user click any of the Get started link before signin {string} in home page")
	public void the_user_click_any_of_the_get_started_link_before_signin_in_home_page(String string) {
		homePage.getStartBtn_click();
	}

	@When("user clicks on SignIn button he is directed to login page")
	public void user_clicks_on_sign_in_link() {
		loginPage = homePage.signin_Btn();
		System.out.println(driver.getCurrentUrl());
	}

	@Then("user validates the login page")
	public void user_validates_the_login_page() {
		actual_PageUrl = driver.getCurrentUrl();
		expected_PageUrl = "https://dsportalapp.herokuapp.com/login";
		assertEquals(actual_PageUrl, expected_PageUrl);
		System.out.println("Login page check " + actual_PageUrl);
	}

	@When("user clicks on Register button he is directed to register page")
	public void user_clicks_on_register_link() throws InterruptedException {
		homePage.register_Btn();
		actual_PageUrl = driver.getCurrentUrl();
		expected_PageUrl = "https://dsportalapp.herokuapp.com/register";
	}

	@Then("user validates the register page")
	public void user_validates_the_register_page() {
		actual_PageUrl = driver.getCurrentUrl();
		expected_PageUrl = "https://dsportalapp.herokuapp.com/register";
		assertEquals(actual_PageUrl, expected_PageUrl);
	}

	@When("The user click any of the Get started link after signin {string} in home page")
	public void the_user_click_any_of_the_get_started_link_after_signin_in_home_page(String string) {
		if(!loginPage.isUserLoggedin()) {
			loginPage.goToLoginPage();
			loginPage.loginUser();
		} else {
			homePage.homepage();
		}
		homePage.getStartBtn_click(string);
		expected = string;

	}

	@Then("The user should able to goto its respective page")
	public void the_user_should_able_to_goto_its_respective_page() {
		String title = DriverManager.getDriver().getTitle();
		assertEquals(title, expected);
		if("Graph".equals(expected)) {
			loginPage.sign_out();
		}
	}

}
