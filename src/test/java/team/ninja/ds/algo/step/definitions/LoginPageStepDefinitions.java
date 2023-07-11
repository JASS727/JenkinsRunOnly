package team.ninja.ds.algo.step.definitions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import team.ninja.ds.algo.page.object.LandingPage;
import team.ninja.ds.algo.driver.manager.DriverManager;
import team.ninja.ds.algo.page.object.HomePage;
import team.ninja.ds.algo.page.object.RegisterPage;
import team.ninja.ds.algo.page.object.LoginPage;
import team.ninja.ds.algo.utilities.ConfigReader;

public class LoginPageStepDefinitions {
	private LandingPage landingPage=new LandingPage(DriverManager.getDriver());
	private HomePage homePage=HomePage.getInstance();
	private LoginPage loginPage=LoginPage.getInstance();
	private RegisterPage registerPage=new RegisterPage(DriverManager.getDriver());
	private WebDriver driver=DriverManager.getDriver();
	private ConfigReader config=new ConfigReader();
	private SoftAssert softAssert=new SoftAssert();
	private static String error;
	private static String result;
	private static String msg;
	
	
	@Given("User is on Login page")
	public void user_is_on_login_page() {
	   loginPage=homePage.signin_Btn();
	   
	   System.out.println("User should be on login page "+driver.getCurrentUrl());	  
	}
	@When("User clicks on login button with all empty field")
	public void user_clicks_on_login_button_with_all_empty_field() {
	    error= loginPage.login_click();
	    System.out.println("empty field error chek  "+error);
	 
	}
	
	@Then("User verify the message at username as {string}")
	public void user_verify_the_message_at_username_as(String string) {
		  Assert.assertEquals(error, string, "Please fill out this field.");
	}
	
	
	
	@When("User enters invalid username as {string} and password as {string} and gets the result {string}")
	public void user_enters_invalid_username_as_and_password_as_and_gets_the_result(String uname, String pwd, String Result) {
	  loginPage.login_entry(uname, pwd);
	  result=Result;
	}
	
	@When("User clicks login button")
	public void user_clicks_login_button() {
	   loginPage.logBtn_click();
	   
	}
	
	@Then("User verify the message as {string}")
	public void user_verify_the_message_as(String string) {
	   System.out.println(result);
	   System.out.println(string);
	}
	
	
	
	
	
	@When("User enters valid username {string} and password {string}")
	public void user_enters_username_and_password(String uname, String pwd) {
		System.out.println("username is" + uname );
		
	  loginPage.valid_login(uname, pwd);
	}
	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		result=loginPage.success_login();
	}
	@Then("It should navigate to the home page with a message {string}")
	public void it_should_navigate_to_the_home_page_with_a_message(String string) {
		//SoftAssert.assertEquals(result,string)
	   System.out.println("logged message sholuf cod"+result+string);
	}
	
	
	@When("User clicks on signout")
	public void user_clicks_on_signout() throws InterruptedException {
		/*
		 * loginPage=homePage.signin_Btn();
		 * //System.out.println(driver.getCurrentUrl()); String
		 * uname=config.getUserName(); String pwd=config.getPassword();
		 * //System.out.println(uname +pwd); loginPage.valid_login(uname, pwd);
		 * result=loginPage.success_login();
		 */		// System.out.println(result);
		  msg=loginPage.success_logout();
		  
	}
	@Then("Message displayed LoggedOut Successfully")
	public void message_displayed_logged_out_successfully() throws InterruptedException {
	  //  String msg=loginPage.success_logout();
	     System.out.println(msg);
	}
	@When("User clicks on login button with username as {string} only")
	public void user_clicks_on_login_button_with_username_as_only(String string) {
	  error=loginPage.username_login(string);
	  	}
	@Then("User verify the message at password as {string}")
	public void user_verify_the_message_at_password_as(String string) {
		Assert.assertTrue(error.equals(string));
	  	}
	
	@When("User clicks on login button with password as {string} only")
	public void user_clicks_on_login_button_with_password_as_only(String string) {
	  error=loginPage.password_login(string);
	  	}
	@Then("User verify the message at user as {string}")
	public void user_verify_the_message_at_user_as(String string) {
		Assert.assertTrue(error.equals(string));
	}

}
