import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:build/cucmber-html-report"}, 
    features = "src/test/resources") 
//glue = "")

public class MoveTest {

}
