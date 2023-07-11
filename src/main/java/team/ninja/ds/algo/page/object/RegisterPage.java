package team.ninja.ds.algo.page.object;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import team.ninja.ds.algo.driver.manager.DriverManager;
import team.ninja.ds.algo.utilities.ConfigReader;
import team.ninja.ds.algo.utilities.DsAlgoTestLogger;

public class RegisterPage {
	private WebDriver driver = DriverManager.getDriver();
	private String registerurl = ConfigReader.registerPage();
	private String error = "";
	private String msg;

	@FindBy(xpath = "//input[@value ='Register']")
	private WebElement registerBtn;
	@FindBy(name = "username")
	private WebElement username;
	@FindBy(name = "password1")
	private WebElement password;
	@FindBy(xpath = "//input[@name='password2']")
	private WebElement confirm_password;
	@FindBy(xpath = "//a[text()=' Register ']")
	private WebElement register_corner;
	@FindBy(xpath = "//a[text()='Sign in']")
	private WebElement signin_corner;
	@FindBy(xpath = "//div[contains(@class,'alert ')]")
	private WebElement mismatchError;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String register_topcorner() {
		register_corner.click();
		String reg_url = driver.getCurrentUrl();
		return reg_url;
	}

	public String signin_topcorner() {
		signin_corner.click();
		String signin_url = driver.getCurrentUrl();
		return signin_url;
	}

	public String clickregister() {
		// new
		// WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(registerBtn));
		registerBtn.click();
		error = username.getAttribute("validationMessage");
		return error;
	}

	public String clickregisterWith_username(String usrnme) throws InterruptedException {
		//Thread.sleep(3000);
		// new
		// WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(registerBtn));
		username.sendKeys(usrnme);
		System.out.println(usrnme);
		registerBtn.click();
		error = password.getAttribute("validationMessage");
		return error;
	}

	public String printerror() {
		DsAlgoTestLogger.info("Error Message #:" + error);
		return error;
	}

	public void getRegisterUrl() {
		driver.get(registerurl);
	}

	public String login_entry(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		registerBtn.click();
		error = confirm_password.getAttribute("validationMessage");
		return error;
	}

	public String clickregisterWith_pwd(String pwd1) {
		password.sendKeys(pwd1);
		registerBtn.click();
		error = username.getAttribute("validationMessage");
		return error;

	}

	public String clickregisterWithconfirm_pwd(String pwd1) {
		confirm_password.sendKeys(pwd1);
		registerBtn.click();
		error = username.getAttribute("validationMessage");
		return error;
	}

	public String invalidDataCredentials(String un, String pwd, String cpwd) throws InterruptedException {
		//Thread.sleep(3000);
		username.sendKeys(un);
		password.sendKeys(pwd);
		confirm_password.sendKeys(cpwd);
		registerBtn.click();
		if (mismatchError.isDisplayed()) {
			error = mismatchError.getText();
		}
		return error;
	}

	public LoginPage validDataCredentials(String uname, String pwd, String cpwd) throws InterruptedException {

		//Thread.sleep(3000);
		String s = RandomStringUtils.randomAlphanumeric(6);
		username.sendKeys(s + "@Numpyninja");
		// username.sendKeys(uname);
		password.sendKeys(pwd);
		confirm_password.sendKeys(cpwd);
		registerBtn.click();
		if (mismatchError.isDisplayed()) {
			msg = mismatchError.getText();
			System.out.println(msg);
		}
		return LoginPage.getInstance();
	}

}
