package team.ninja.ds.algo.step.definitions;

import static org.testng.Assert.assertEquals;
import static team.ninja.ds.algo.constants.DsAlgoConstant.XL_QDATA_FILE_PATH;
import static team.ninja.ds.algo.constants.DsAlgoConstant.graphPracticeQs;
import static team.ninja.ds.algo.constants.DsAlgoConstant.graphUrl;
import static team.ninja.ds.algo.utilities.DsAlgoUtil.snooze;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import team.ninja.ds.algo.page.object.HomePage;
import team.ninja.ds.algo.driver.manager.DriverManager;
import team.ninja.ds.algo.page.object.GraphPage;
import team.ninja.ds.algo.utilities.ExcelReader;

public class GraphPageStepDefinitions {

	private GraphPage gPage = new GraphPage(DriverManager.getDriver());
	private HomePage homePage = HomePage.getInstance();
	String expectedResult = null;
	WebDriver driver = DriverManager.getDriver();

	@Given("The user on homepage for graph")
	public void the_user_on_homepage_for_graph() {
		homePage.homepage();
	}

	@When("The user clicks the graph item from the drop down menu")
	public void the_user_clicks_the_graph_item_from_the_drop_down_menu() {
		gPage.clickOnGraphItem();
		gPage.clickOnDropdownGraphlink();
	}

	@Then("The user be directed to Graph Data Structure Page")
	public void the_user_be_directed_to_graph_data_structure_page() {
		String actualURL = DriverManager.getDriver().getCurrentUrl();
		System.out.println("actualURL  = " + actualURL);
		assertEquals(actualURL, graphUrl);
	}

	@Given("The user is on the Graph page after logged in")
	public void the_user_is_on_the_graph_page_after_logged_in() {
		gPage.navigateToGraphPage();
	}

	@When("User clicks {string} link for graph")
	public void user_clicks_link_for_graph(String string) {
		gPage.clickLink(string);
	}

	@Then("User directed to {string} page for graph")
	public void user_directed_to_page_for_graph(String string) {
		String title = DriverManager.getDriver().getTitle();
		System.out.println("Title = " + title);
		snooze(2);
		assertEquals(title, string);
	}

	@Given("The user is in a {string} page for graph having an tryEditor with a Run button to test")
	public void the_user_is_in_a_page_for_graph_having_an_try_editor_with_a_run_button_to_test(String string) {
		gPage.navigateToGraphPage();
		gPage.clickLink(string);
		gPage.clickOnTryHerelink();
	}

	@When("The user enter valid python code in tryEditor for graph from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_for_graph_from_sheet_and(String Sheetname,
			Integer RowNumber) {
		ExcelReader excel = ExcelReader.getInstance();
		try {

			List<Map<String, String>> list = excel.getData(XL_QDATA_FILE_PATH, Sheetname);
			Map<String, String> dataMap = list.get(RowNumber);
			String pythonCode = dataMap.get("pythonCode");
			expectedResult = dataMap.get("Result");
			System.out.println("expected = " + expectedResult);
			gPage.sendPythonCode(pythonCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("The user clicks on run button for graph")
	public void the_user_clicks_on_run_button_for_graph() {
		gPage.clickRunBtn();
	}

	@Then("The user should be presented with Run result for graph")
	public void the_user_should_be_presented_with_run_result_for_graph() {
		String actualResult = gPage.getActualResult();
		System.out.println("actualResult = " + actualResult);
		assertEquals(actualResult, expectedResult);
	}

	@When("The user enter python code with invalid syntax in tryEditor  for graph from sheet {string} and {int}")
	public void the_user_enter_python_code_with_invalid_syntax_in_try_editor_for_graph_from_sheet_and(String Sheetname,
			Integer RowNumber) {
		ExcelReader excel = ExcelReader.getInstance();
		List<Map<String, String>> list = excel.getData(XL_QDATA_FILE_PATH, Sheetname);
		Map<String, String> dataMap = list.get(RowNumber);
		String pythonCode = dataMap.get("pythonCode");
		expectedResult = dataMap.get("Result");
		gPage.sendPythonCode(pythonCode);
	}

	@Then("The user should be presented with error message for graph")
	public void the_user_should_be_presented_with_error_message_for_graph() {
		String errorMessage = gPage.getAlertMessage();
		System.out.println("errorMessage = " + errorMessage);
		System.out.println("driver.getTitle() = " + DriverManager.getDriver().getTitle());
		assertEquals(errorMessage, expectedResult);
	}

	@Given("The user is on Editor page and navigates to Graph Representations page")
	public void the_user_is_on_editor_page_and_navigates_to_graph_representations_page() {
		gPage.navigateToGraphPage();
		gPage.clickOnGraphRepresentationLink();
	}

	@When("the user will click on Practice Questions for graph")
	public void the_user_will_click_on_practice_questions_for_graph() {
		gPage.clickOnPracticeQlink();
	}

	@Then("The user will be directed to Practice page for graph")
	public void the_user_will_be_directed_to_practice_page_for_graph() {
		Assert.assertTrue(driver.getCurrentUrl().contains(graphPracticeQs));
	}

}
