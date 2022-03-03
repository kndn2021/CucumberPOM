package whitehatRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "C:\\Users\\Bhushan\\eclipse-workspace\\CucumberPOM\\src\\main\\java\\whitehatFeature\\whitehatRegistration.feature",
		glue = "whitehatStepDefination",
		plugin = {"pretty", "json:target/Cucumber/Report.json"},
		monochrome = true,
		dryRun = false
		
		)

public class WhitehatRunner {

}
