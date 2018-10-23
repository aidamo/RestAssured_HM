import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.TestNG;

@CucumberOptions(
        features = "arc/test/resources",
        glue = "stepdefs",
        plugin = "{pretty}")
public class RunCucumberTest extends AbstractTestNGCucumberTests {

}
