package team.ninja.ds.algo.page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import team.ninja.ds.algo.driver.manager.DriverManager;
import team.ninja.ds.algo.utilities.ConfigReader;

public class LoginPage {
	private WebDriver driver = DriverManager.getDriver();
	String error;
	String msg;
	private static LoginPage loginPage = null;
	private boolean isUserLoggedin = false;
	private ConfigReader reader=new ConfigReader();

	@FindBy(xpath = "//input[@id='id_username']")
	private WebElement username;
	@FindBy(xpath = "//input[@id='id_password']")
	private WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginbtn;
	@FindBy(xpath = "//div[contains(text(),'Invalid Username and Password')]")
	private WebElement alertMsg;
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/a[1]")
	private WebElement registerlink;
	@FindBy(xpath = "//div[contains(text(),'You are logged in')]")
	private WebElement successLogin;
	@FindBy(xpath = "//a[contains(text(),'Sign out')]")
	private WebElement signout;
	@FindBy(xpath = "//div[contains(text(),'Logged out successfully')]")
	private WebElement successLogout;
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	private WebElement alert;

	private LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static LoginPage getInstance() {
		if(loginPage==null) {
			loginPage = new LoginPage(DriverManager.getDriver());
		} 
		
		return loginPage;
	}

	public String login_click() {
		username.sendKeys("");
		password.sendKeys(" ");
		loginbtn.click();
		error = username.getAttribute("validationMessage");
		return error;

	}
	public boolean isUserLoggedin() {
		return isUserLoggedin;
	}
	
	public void loginUser() {
		loginPage.goToLoginPage();
		loginPage.login_entry(reader.getUserName(), reader.getPassword());
		loginPage.success_login();
		isUserLoggedin = true;
	}
	
	public void login_entry(String uname, String pwd) {
		username.clear();
		username.sendKeys(uname);
		password.clear();
		password.sendKeys(pwd);

	}

	public String logBtn_click() {
		loginbtn.click();
		if (alertMsg.isDisplayed())
			msg = "Invalid Username and Password";
		return msg;

	}

	public void sign_out()  {
		//Thread.sleep(3000);
		signout.click();
		isUserLoggedin = false;

	}

	public String success_logout() throws InterruptedException {
		sign_out();
		String successlogout = successLogout.getText();
		return successlogout;
	}

	public void valid_login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
	}

	public String success_login() {
		System.out.println("success_login");
		loginbtn.click();
		if (successLogin.isDisplayed())
			msg = "You are logged in";
		else
			msg = "you are no logged in";
		return msg;
	}

	public String username_login(String un) {
		username.clear();
		username.sendKeys(un);
		loginbtn.click();
		error = password.getAttribute("validationMessage");
		return error;
	}

	public String password_login(String un) {
		password.clear();
		password.sendKeys(un);
		loginbtn.click();
		error = username.getAttribute("validationMessage");
		return error;
	}

	public void goToLoginPage() {

		driver.get("https://dsportalapp.herokuapp.com/login");
	}
}
