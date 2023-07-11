
package team.ninja.ds.algo.step.definitions;

import java.io.IOException;
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
import team.ninja.ds.algo.driver.manager.DriverManager;
import team.ninja.ds.algo.page.object.HomePage;
import team.ninja.ds.algo.page.object.LoginPage;
import team.ninja.ds.algo.page.object.StackPage;
import team.ninja.ds.algo.page.object.TreePage;
import team.ninja.ds.algo.utilities.ExcelReader;

public class TreePageStepDefinitions {
	private HomePage homepage=HomePage.getInstance();
	private LoginPage loginpage=LoginPage.getInstance();
	private TreePage treePage=new TreePage(DriverManager.getDriver());
	private String code;
	private String actualresult;;
	private String expectedresult;
	WebDriver driver=DriverManager.getDriver();
	
	@Given("The user is on the {string} tree page after logged in")
	public void the_user_is_on_the_page_after_logged_in(String string) {
		homepage.homepage();
		treePage=homepage.tree_getstart();
	}
	@When("The user clicks {string} button in tree page")
	public void the_user_clicks_button_in_stack_page(String option) {
		treePage.treemenu_click(option);
		}

	@And("The user clicks tryEditor with a Run button to test on tree page")
	public void the_user_clicks_tryEditor_with_a_Run_button_to_test_on_stack_page() throws InterruptedException {
	treePage.tryedit_click();
	}
	@Given("The user is in a {string} tree page having an tryEditor with a Run button to test")
	public void the_user_is_in_a_page_having_an_try_editor_with_a_run_button_to_test(String option) {
		homepage.homepage();
		treePage=homepage.tree_getstart();
		treePage.treemenu_click(option);
		treePage.tryedit_click();
	}
	@When("The user enter valid python code in tree tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_stack_try_editor_from_sheet_and(String SheetName, Integer rowno) throws InvalidFormatException, IOException, InterruptedException{
		ExcelReader reader=ExcelReader.getInstance();	
		List<Map<String, String>> rdata = reader.getData("src/test/resources/Test_Data/programdata.xlsx",SheetName);
		code=rdata.get(rowno).get("Pythoncode");
		expectedresult=rdata.get(rowno).get("Result");
		treePage.enter_code(code);
	}
	@And("The user clicks on tree run button")
	public void the_user_clicks_on_run_button() throws InterruptedException {
		treePage.click_run();
	}
	
	@Then("The user should be presented with Run result of tree")
	public void the_user_should_be_presented_with_run_result() {
		actualresult=treePage.present_result();
		Assert.assertEquals(actualresult, expectedresult);
	}
	@When("The user enter python code with invalid syntax in tree tryEditor from sheet {string} and {int}")
	public void the_user_enter_python_code_with_invalid_syntax_in_try_editor_from_sheet_and(String SheetName, Integer rowno) throws InvalidFormatException, IOException, InterruptedException{
		 ExcelReader reader=ExcelReader.getInstance();
		 List<Map<String, String>> rdata = reader.getData("src/test/resources/Test_Data/programdata.xlsx",SheetName);
		 code=rdata.get(rowno).get("Pythoncode");
		 expectedresult=rdata.get(rowno).get("Result");
		 treePage.enter_code(code);   
	}

@Then("The user should be presented with error message in tree page")
public void the_user_should_be_presented_with_error_message() {
		actualresult=treePage.present_invalidmsg();
		Assert.assertEquals(actualresult, expectedresult);
}
@Given("The user is on the type of tree after logged in")
public void The_user_is_on_the_type_of_tree_after_logged_in() {
	homepage.homepage();
	treePage=homepage.tree_getstart();
	treePage.typeoftree_click();
}  

@When("The user clicks tree Practice Questions link")
public void the_user_clicks_practice_questions_link() {
	treePage.practice_click();
}

@Then("The user should be redirected to {string} page in tree")
public void the_user_should_be_redirected_to_practice_page(String string) {
   Assert.assertTrue(driver.getCurrentUrl().contains(string));

}

}