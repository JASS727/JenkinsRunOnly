package team.ninja.ds.algo.step.definitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import team.ninja.ds.algo.driver.manager.DriverManager;
import team.ninja.ds.algo.page.object.DataStructurePage;
import team.ninja.ds.algo.page.object.HomePage;
import team.ninja.ds.algo.page.object.LoginPage;
public class DataStructurePageStepDefinitions {
	

	private DataStructurePage dataStructurePage=new  DataStructurePage(DriverManager.getDriver());
	private HomePage homePage=HomePage.getInstance();
	private LoginPage loginPage= LoginPage.getInstance();
	private WebDriver driver=DriverManager.getDriver();
	private SoftAssert softAssert=new SoftAssert();
	private static String actualAlertText;
	
	
	@When("user clicks on datastructure getstarted")
	public void user_clicks_on_datastructure_getstarted() {
		dataStructurePage.getStarted_DS();
	 
	}

	
	@When("The user is logged in with valid user id and password")
	public void The_user_is_logged_in_with_valid_user_id_and_password() {
		if(!loginPage.isUserLoggedin()) {
			loginPage.loginUser();
		}
	 
	}

	@Then("user redirected to page with title {string}")
	public void user_redirected_to_page_with_title(String actualTitle) {
		 String expectedTitle=dataStructurePage.getTitle();
		 assertEquals(actualTitle,expectedTitle);	 	
	    
	}

	@When("user click on Time Complexity")
	public void user_click_on_time_complexity() {
		dataStructurePage.clickOnTimeComplexitylink();
	    
	}

	@Then("It should navigate to corresponding page with title {string}")
	public void it_should_navigate_to_corresponding_page_with_title(String actualTitle) {
		String expectedTitle= dataStructurePage.getTitle();
		 assertEquals(actualTitle,expectedTitle);	
	}

	@When("user click on Try here")
	public void user_click_on_try_here() {
		dataStructurePage.tryEditorlink();
	    
	}

	@When("user enter the Python code")
	public void user_enter_the_python_code(io.cucumber.datatable.DataTable pythonCode) throws InterruptedException {
			
		List<String> data=pythonCode.asList();
		dataStructurePage.enterCode(data.get(0));
	}

	@When("user clicks run button and goes to home page")
	public void user_clicks_run_button_and_goes_to_home_page() throws InterruptedException {
		dataStructurePage.clickRunBtn();	
	
	}
	
	@When("user enter the invalid Python code")
	public void user_enter_the_invalid_python_code(DataTable invalidcode) throws InterruptedException {
		List<String> data=invalidcode.asList();
		 dataStructurePage.enterCode(data.get(0));
	}
	
	@When("user clicks run button")
	public void user_clicks_run_button() throws InterruptedException {
		dataStructurePage.alertRunBtnHandle();
	}
	@Then("user should get the alert message with text {string}")
	public void user_should_get_the_alert_message_with_text(String expectedAlertText) {
	   softAssert.assertEquals(actualAlertText, expectedAlertText, "Success");
	}
	@And("user accepts the error")
	public void user_accepts_the_error() {
	   
	    System.out.println(driver.getCurrentUrl());
	}
	
	


	


}
