package team.ninja.ds.algo.page.object;

import static team.ninja.ds.algo.constants.DsAlgoConstant.*;
import static team.ninja.ds.algo.utilities.DsAlgoUtil.snooze;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QueuePage {
	WebDriver driver;

	@FindBy(xpath = "//a[@href ='queue']")
	private WebElement getStarted_QueueIntro;
	@FindBy(xpath = "//a[text()='Data Structures']")
	private WebElement menudropdown;

	@FindBy(xpath = "//div[@class='dropdown-menu']//a")
	private WebElement dropdown_btn;
	@FindBy(xpath = "//a[normalize-space()='Queue']")
	private WebElement dropdown_queue_btn;
	@FindBy(xpath = "//a[normalize-space()='Implementation of Queue in Python']")
	private WebElement ImplementationQueuePython;
	@FindBy(xpath = "//a[text()='Try here>>>']")
	private WebElement tryHere;

	@FindBy(xpath = "//a[text()='Implementation using collections.deque']")
	private WebElement ImplementationCollectionsDeque;
	@FindBy(xpath = "//a[@href='Implementation-array']")
	private WebElement ImplementationUsingArray;
	@FindBy(xpath = "//a[@href='QueueOp']")
	private WebElement QueueOperations;
	@FindBy(xpath = "//a[@class='list-group-item list-group-item-light text-info']")
	private WebElement PracticeQuestions;
	@FindBy(xpath = "//form/div/div/div/textarea")
	private WebElement editorInput;
	@FindBy(xpath = "//button[text()='Run']")
	private WebElement runBtn;
	@FindBy(id = "output")
	private WebElement output;


	public QueuePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnGetStartedQueue() {
		getStarted_QueueIntro.click();
	}

	public void clickOnDropdnBtn() {
		dropdown_btn.click();
	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;

	}

	public void clickOnQueueItem() {
		snooze(1);
		menudropdown.click();
		dropdown_queue_btn.click();
	}

	public void navigateToQueuePage() {
		driver.get(queueUrl);

	}

	public void sendPythonCode(String pythonCode) {
		editorInput.sendKeys(pythonCode);

	}

	public void clickOnImplementationQueuePythonLink() {
		ImplementationQueuePython.click();
	}

	public void navigateToImplementationQueuePythonLink() {
		driver.get(impOfQPython);
	}

	public void clickOnTryHereLink() {
		tryHere.click();

	}

	public void clickOnRunButton() {
		runBtn.click();

	}

	public String getActualResult() {

		return output.getText();
	}
	public String getAlertMessage() {
		String alertText=null;
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

	public void clickOnImpUsingCollLink() {
		driver.get(impColDeq);
		ImplementationCollectionsDeque.click();

	}

	public void clickOnImplementationUsingArray() {
		ImplementationUsingArray.click();
	}

	public void navigateToQueueOperationsLink() {
		driver.get(queueOp);
	}

	public void clickOnQueueOperationsLink() {
		QueueOperations.click();
	}

	public void navigateToPracticeQuestionsLink() {
		driver.get(practiceQs);
	}

	public void clickOnPracticeQuestionsLink() {
		PracticeQuestions.click();
	}

	public void navigateToImplementationCollectionsDeque() {
		driver.get(impColDeq);
	}

	public void navigateToImplementationUsingArray() {
		driver.get(impUsingArray);
	}

	public void navigateToEditorinputLink() {
		driver.get(tryEditor);
	}

	public void clickLink(String string) {
		if("Implementation of Queue in Python".equals(string)) {
			ImplementationQueuePython.click();
		} else if("Implementation using collections.deque".equals(string)) {
			ImplementationCollectionsDeque.click();
		}
		else if("Implementation using array".equals(string)) {
			ImplementationUsingArray.click();
		}
		else if("Queue Operations".equals(string)) {
			QueueOperations.click();
		}
	}
}
