package team.ninja.ds.algo.step.definitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import team.ninja.ds.algo.page.object.LinkedListPage;
import team.ninja.ds.algo.driver.manager.DriverManager;
import team.ninja.ds.algo.page.object.HomePage;
import team.ninja.ds.algo.page.object.LoginPage;
import team.ninja.ds.algo.utilities.ConfigReader;
import team.ninja.ds.algo.utilities.PageUtils;

public class LinkedListpageStepDefinitions {
	private HomePage homePage=HomePage.getInstance();
	private LoginPage loginPage=LoginPage.getInstance();
	private LinkedListPage linkedListPage=new LinkedListPage(DriverManager.getDriver());
	private WebDriver driver=DriverManager.getDriver();
	private ConfigReader config=new ConfigReader();
	private SoftAssert softAssert=new SoftAssert();
	private PageUtils pageUtil=new PageUtils();
	private static String actualAlertText;
	private static String errormsg;
	private static String outputresult;
	
	
	
	@Given("user clicks the Linked List getstart link")
	public void user_selects_the_linked_list_getstartitem() throws InterruptedException {
	   linkedListPage=  homePage.ll_getStart();		
	   System.out.println(driver.getCurrentUrl());
	}

	@Then("user is on the Linked List Page")
	public void user_should_be_in_the_linked_list_page() throws InterruptedException {
	   String url=driver.getCurrentUrl();
	   System.out.println(url);
	   Assert.assertTrue(url.contains("/linked-list/"));	
	}

	@Then("user checks for the title {string} in the Linked List page")
	public void user_checks_for_the_title_in_the_linked_list_page(String title) {	 
		   String url=driver.getCurrentUrl();
		   System.out.println(url);
		   Assert.assertTrue(url.contains("/linked-list/"));	
	       Assert.assertEquals(driver.getTitle(),title);
	}

	
	@When("The user select all option {string} and Verifies the tryeditor Page with the valid python code for each option  {string} and {int}")
	public void the_user_select_any_dropdown_menu_and_verifies_the_tryeditor_page_with_the_valid_python_code_for_each_option_and(String option, String sheetName, Integer rownumber) throws InvalidFormatException, IOException, InterruptedException {
		String pCode=pageUtil.getPythonCodefromExcel(sheetName,rownumber);
		String options=option;
		outputresult=linkedListPage.validPythonCode(pCode,options);		
	}
	
	@Then("user should be presented with the run result")
	public void user_should_be_presented_with_the_run_result()
	{
		System.out.println(outputresult);
	}
	
	@When("The user select all option {string} and Verifies the tryeditor Page with the Invalid python code for each option  {string} and {int}")
	public void the_user_select_any_dropdown_menu_and_verifies_the_tryeditor_page_with_the_invalid_python_code_for_each_option_and(String option, String sheetName, Integer rownumber) throws InvalidFormatException, IOException, InterruptedException {
		    String pCode=pageUtil.getPythonCodefromExcel(sheetName,rownumber);
			String options=option;
			outputresult=linkedListPage.inValidPythonCode(pCode,options);	
	}
	
   @Then("user should get the {string}")
   public void user_should_get_the_erroroutput(String output)
   {   System.out.println(outputresult);
   if(outputresult!=null)
	   Assert.assertTrue(outputresult.contains(output));
   else System.out.println("outputresult is null");
   }

   
   @Then("The user select all option {string}")
   public void the_user_select_any_dropdown_menu(String menuItem) {
     linkedListPage.drop_downClick(menuItem);
     System.out.println(driver.getCurrentUrl());
   }
   @Then("The User is on the {string} page")
   public void the_user_is_on_the_page(String menuitem) {
       System.out.println("current title exoepctiing linked list page:  " +driver.getTitle());
       System.out.println(driver.getCurrentUrl());
   }
   
   @When ("The user clicks Practice Questions {string} link")
   public void the_user_clicks_Practice_Questions_link(String practice)
   {
	  linkedListPage.practice_link(practice);
	 System.out.println( driver.getCurrentUrl());
   }
   
   @Then("The user should be redirected to {string} page and verifies the Url {string}")
   public void the_user_should_be_redirected_to_page_and_verifies_the_url(String string, String url) {
    try {
	   if(url!=null)
     {	 System.out.println(driver.getCurrentUrl());
	     Assert.assertTrue(driver.getCurrentUrl().contains(url));}}
	   catch(Exception e) {
		  System.out.println(e);		  
	   }
      
   }

}