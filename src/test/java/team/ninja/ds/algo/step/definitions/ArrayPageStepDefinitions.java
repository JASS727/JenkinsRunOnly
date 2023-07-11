package team.ninja.ds.algo.step.definitions;



import java.io.IOException;
//import java.sql.Driver;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import team.ninja.ds.algo.page.object.LandingPage;
import team.ninja.ds.algo.page.object.HomePage;
import team.ninja.ds.algo.page.object.LoginPage;
import team.ninja.ds.algo.driver.manager.DriverManager;
import team.ninja.ds.algo.page.object.ArrayPage;
import team.ninja.ds.algo.utilities.ExcelReader;

public class ArrayPageStepDefinitions {
private HomePage homepage=HomePage.getInstance();
private LoginPage loginpage=LoginPage.getInstance();
private ArrayPage arrPage=new ArrayPage(DriverManager.getDriver());
private String code;
private String actualresult;
private String expectedresult;
WebDriver driver=DriverManager.getDriver();

@Given("The user is on the {string} after logged in")
public void the_user_is_on_the_after_logged_in(String string) {
	homepage.homepage();
	arrPage=homepage.array_getstart();
}

@Then("The user in  {string} page")
public void the_user_in_page(String string) {
	System.out.println(driver.getTitle());
	Assert.assertEquals(driver.getTitle(),string);
}

@When("The user clicks {string} button")
public void the_user_clicks_button(String option) {
    arrPage.arrymenu_click(option);
}

@Given("The user is in a {string} page having an tryEditor with a Run button to test")
public void the_user_is_in_a_page_having_an_try_editor_with_a_run_button_to_test(String option) {
	homepage.homepage();
	arrPage=homepage.array_getstart();
	arrPage.arrymenu_click(option);
	arrPage.tryedit_click();
}

@When("The user enter valid python code in tryEditor from sheet {string} and {int}")
public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String SheetName, Integer rowno) throws InvalidFormatException, IOException, InterruptedException{
	ExcelReader reader=ExcelReader.getInstance();	
	List<Map<String, String>> rdata = reader.getData("src/test/resources/Test_Data/programdata.xlsx",SheetName);
	code=rdata.get(rowno).get("Pythoncode");
	expectedresult=rdata.get(rowno).get("Result");
	 System.out.println("Code:"+code);
	arrPage.enter_code(code, SheetName);
}

@And("The user clicks on run button")
public void the_user_clicks_on_run_button() throws InterruptedException {
	arrPage.click_run();
}

@Then("The user should be presented with Run result")
public void the_user_should_be_presented_with_run_result() {
	actualresult=arrPage.present_result();
	Assert.assertEquals(actualresult, expectedresult);
}

@When("The user enter python code with invalid syntax in tryEditor from sheet {string} and {int}")
public void the_user_enter_python_code_with_invalid_syntax_in_try_editor_from_sheet_and(String SheetName, Integer rowno) throws InvalidFormatException, IOException, InterruptedException{
	 ExcelReader reader=ExcelReader.getInstance();
	 List<Map<String, String>> rdata = reader.getData("src/test/resources/Test_Data/programdata.xlsx",SheetName);
	 code=rdata.get(rowno).get("Pythoncode");
	 expectedresult=rdata.get(rowno).get("Result");
	 arrPage.enter_code(code, SheetName);   
}
@Then("The user should be presented with error message")
public void the_user_should_be_presented_with_error_message() {
		actualresult=arrPage.present_invalidmsg();
		Assert.assertEquals(actualresult, expectedresult);
}

@Given("The user is on the Arrays in Python after logged in")
public void the_user_is_on_the_arrays_in_python_after_logged_in() {
	homepage.homepage();
	arrPage=homepage.array_getstart();
	arrPage.arrayinpython_click();
}
@When("The user clicks Practice Questions link")
public void the_user_clicks_practice_questions_link() {
	arrPage.practice_click();
}

@Then("The user should be redirected to {string} page")
public void the_user_should_be_redirected_to_practice_page(String string) {
   Assert.assertTrue(driver.getCurrentUrl().contains(string));
}
@And("The user should redirect to {string} practice question page")
public void the_user_should_redirect_to_practice_question_page(String string)
{
	arrPage.practicemenu_click(string);
}


@Given("The user is in a {string}  practice page having an tryEditor with a Run button to test")
public void the_user_is_in_a_practice_page_having_an_try_editor_with_a_run_button_to_test(String option) {
	homepage.homepage();
	arrPage=homepage.array_getstart();
	arrPage.arrayinpython_click();
	arrPage.practice_click();
	arrPage.practicemenu_click(option);
	}
@When("The user clicks on submit")
public void the_user_clicks_on_submit() {
   arrPage.click_submit();
}



}

