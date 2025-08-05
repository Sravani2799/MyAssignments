package runner;

import io.cucumber.testng.CucumberOptions;
import stepDefinition.BaseClassStaticCucumber;

@CucumberOptions(features= {"src/main/java/features/editAccountStaticCucumber.feature"},
glue="stepDefinition",
publish=true, 
tags="@EditAccount")

public class RunnerStaticCucumber extends BaseClassStaticCucumber{

}