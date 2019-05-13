import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        features = "src/test/java/ru/riskmarket/features",
        glue = "ru/riskmarket/steps",
        tags = "@smoketest")
public class Runner {


        @BeforeClass
        static public void setupTimeout()
        {
            Configuration.timeout = 10000;
        }
    }

