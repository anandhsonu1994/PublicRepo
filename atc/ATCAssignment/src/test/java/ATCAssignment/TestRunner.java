package ATCAssignment;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src\\test\\java\\ATCAssignment\\featureFiles",
 monochrome = true
 )
 
public class TestRunner {
 
}