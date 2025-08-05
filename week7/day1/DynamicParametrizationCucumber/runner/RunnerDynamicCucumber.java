package runner;

import io.cucumber.testng.CucumberOptions;
import stepDefinition.BaseClassDynamicCucumber;

@CucumberOptions(features= {"src/main/java/features/createAccountDynamicCucumber.feature"},
glue = "stepDefinition", 
publish = true, 
tags="@CreateAccount")

public class RunnerDynamicCucumber extends BaseClassDynamicCucumber{
}
