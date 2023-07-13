package team.ninja.ds.algo.test.runner;

	import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;

	@io.cucumber.testng.CucumberOptions(
	plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, //reporting purpose
	monochrome=false,  //console output color
	 //tags from feature file
	features = {"src/test/resources/Features"}, 
	//tags = " @Test_G2",	
	//tags={"@Login"}, //location of feature files (should be in src/test/reso
	glue={"team.ninja.ds.algo.step.definitions","team.ninja.ds.algo.hooks"})//location of  step definition files
	public class TestRunner  extends AbstractTestNGCucumberTests{
		
		@Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
					
			return super.scenarios();
	    }
	}	
	
	
	
	
	
	
	
	
	

	//features = {"classpath:Features/BHomePage.feature:pageno."},// to run specific scenarion from line no
	//"src/main/resources/publish", tags="@Login, @Sendemail", (using tags to run specific sceanrion file)
	//tags = {"@currentTest"},//(add multiple tags to run like this)
