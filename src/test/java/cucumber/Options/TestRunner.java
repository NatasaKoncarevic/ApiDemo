package cucumber.Options;
import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\nako2508\\Desktop\\Udemy\\Workspace2\\MyAPIFramework\\src\\test\\java\\features",plugin="json:target/jsonReports/cucumber-report.json", glue = "stepDefinations"/*
																																					 * ,tags=
																																					 * {"@DeletePlace"}
																																					 */)
public class TestRunner extends AbstractTestNGCucumberTests {

	//Extend with this AbstractTestNGCucumberTests class in order to run the TestNG



}





