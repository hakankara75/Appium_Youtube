package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber.json",
        },
        features = "src/test/java/resources/features",
        glue = {"stepDefinitions","runner"},
        tags = "@puzzle",
        dryRun = false
)
public class Runner {



}
