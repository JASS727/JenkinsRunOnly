package team.ninja.ds.algo.page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import team.ninja.ds.algo.driver.manager.DriverManager;

public class LandingPage {
private WebDriver driver=DriverManager.getDriver();
	
	
	@FindBy(xpath="//button[text()='Get Started']")
	WebElement getStarted_btn;
	
	@FindBy(xpath="//a[text()='NumpyNinja']")
	WebElement getTitle;
	
    public LandingPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    	
    }
    
    public HomePage click_Btn() throws InterruptedException
    {  
    	//Thread.sleep(3000);
    	driver.get("https://dsportalapp.herokuapp.com/");
		getStarted_btn.click();
		return HomePage.getInstance();    	
    }
    
    public String get_Title()
    {    	
    	return getTitle.getText();    			
    }
}
