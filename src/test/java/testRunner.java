import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        plugin = {"pretty", "html:target/cucumber"},
        features = "src/test/features/",
        dryRun = false,
        tags = "@test")

public class testRunner {

}
