package team.ninja.ds.algo.page.object;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import team.ninja.ds.algo.utilities.ConfigReader;

import static team.ninja.ds.algo.constants.DsAlgoConstant.*;
import static team.ninja.ds.algo.utilities.DsAlgoUtil.snooze;

public class GraphPage {

	// private static final String graphUrl = null;

	private WebDriver driver;

//	@FindBy(xpath = "//button[text()='Get Started']")
//	private WebElement get_started_btn;
	@FindBy(xpath = "//a[text()='Data Structures']")
	private WebElement menudropdown;

	@FindBy(xpath = "//div[@class='dropdown-menu']//a")
	private WebElement dropdown_btn;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Graph']")
	private WebElement dropdown_graph_btn;
	@FindBy(xpath = "(//a[text()='Graph'])[2]")
	private WebElement graph_link;
	@FindBy(xpath = "//a[text()='Try here>>>']")
	private WebElement tryHere;
	@FindBy(xpath = "//form/div/div/div/textarea")
	private WebElement editorInput;
	@FindBy(xpath = "//button[text()='Run']")
	private WebElement runBtn;
	@FindBy(id = "output")
	private WebElement output;
	@FindBy(xpath = "//a[text()='Graph Representations']")
	private WebElement graphRepresentations_Link;
	@FindBy(xpath = "//a[@class='list-group-item list-group-item-light text-info']")
	private WebElement PracticeQuestions;

	public GraphPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	public void clickOnGetStarted_Graph() {
//		get_started_btn.click();
//}

	public void clickOnDropdnMenu() {
		dropdown_btn.click();
	}

	public void clickOnGraphItem() {
		snooze(1);
		menudropdown.click();
		dropdown_graph_btn.click();
	}

//	public void navigateToGraphLink() {
//		driver.navigate().to("graph_link");
//	}

	public void clickOnDropdownGraphlink() {
		dropdown_graph_btn.click();

	}

	public void navigateToGraphDSPage() {
		driver.get(graphUrl);
	}

	public void clickOnGraphlink() {
		graph_link.click();

	}

	public void navigateToGraphPage() {
		driver.get(graphLink);
	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void clickOnTryHerelink() {
		tryHere.click();
	}

	public void clickOnGraphRepresentationLink() {
		graphRepresentations_Link.click();
	}

	public void clickRunBtn() {
		runBtn.click();
	}

	public void clickLink(String string) {
		if ("Graph".equals(string)) {
			graph_link.click();
		} else if ("Graph Representations".equals(string)) {
			graphRepresentations_Link.click();
		}

	}

	public void navigateToPracticeQuestionLink() {
		driver.get(graphPracticeQs);
	}

	public void clickOnPracticeQlink() {
		PracticeQuestions.click();

	}

	public String getActualResult() {
		return output.getText();
	}

	public String getAlertMessage() {
		String alertText = null;
		try {
			// Check the presence of alert
			Alert alert = driver.switchTo().alert();
			// Alert present; set the flag
			alertText = alert.getText();
			alert.accept();
			// ( Now, click on ok or cancel button )

		} catch (NoAlertPresentException ex) {
			// Alert not present
			ex.printStackTrace();
		}
		return alertText;
	}

	public void sendPythonCode(String pythonCode) {
		editorInput.sendKeys(pythonCode);

	}
//	public void clickLink(String string) {
//		if("Implementation of Queue in Python".equals(string)) {
//			ImplementationQueuePython.click();
//		} else if("Implementation using collections.deque".equals(string)) {
//			ImplementationCollectionsDeque.click();
//		}
//		else if("Implementation using array".equals(string)) {
//			ImplementationUsingArray.click();
//		}
//		else if("Queue Operations".equals(string)) {
//			QueueOperations.click();
//		}

}
