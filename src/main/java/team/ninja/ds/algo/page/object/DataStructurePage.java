package team.ninja.ds.algo.page.object;

import static team.ninja.ds.algo.utilities.DsAlgoUtil.snooze;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import team.ninja.ds.algo.driver.manager.DriverManager;
import team.ninja.ds.algo.utilities.ConfigReader;

public class DataStructurePage {

	ConfigReader cr = new ConfigReader();
	String homeurl = cr.homePage();
	String alertText;

	@FindBy(xpath = "//a[@href ='data-structures-introduction']")
	private WebElement getStartedDSintro_link;
	@FindBy(xpath = "//a[@href='time-complexity']")
	private WebElement timecomplexity_link;
	@FindBy(xpath = "//a[@href='/tryEditor']")
	private WebElement tryEditor_link;
	@FindBy(xpath = "//form/div/div/div/textarea")
	private WebElement textEditor;
	@FindBy(xpath = "//button[text()='Run']")
	private WebElement runBtn;
	private WebDriver driver;

	public DataStructurePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getStarted_DS() {
		getStartedDSintro_link.click();
	}

	public void clickOnTimeComplexitylink() {
		timecomplexity_link.click();

	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void tryEditorlink() {
		tryEditor_link.click();
	}

	public void enterCode(String pythonCode) throws InterruptedException {
		System.out.println("Debug URL = "+DriverManager.getDriver().getCurrentUrl());
		try {
			textEditor.sendKeys(pythonCode);
		}catch(Exception e ){
			e.printStackTrace();
			snooze(5);
			textEditor.sendKeys(pythonCode);
		}
	}

	public void clickRunBtn() throws InterruptedException {
		//Thread.sleep(1000);
		runBtn.click();
		driver.navigate().to(homeurl);
	}

	public void alertRunBtnHandle() throws InterruptedException {
		//Thread.sleep(1000);
		runBtn.click();
		String alerttext = isAlertPresent();
		System.out.println(alerttext);
		driver.navigate().to(homeurl);
	}

	public String isAlertPresent() {
		boolean presentFlag = false;
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

}
