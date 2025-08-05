package runner;

import io.cucumber.testng.CucumberOptions;
import stepDefinition.BaseClassForHooks;

@CucumberOptions(features= {"src/test/java/features"},
glue="stepDefinition",
publish = true)
public class runnerClassForHooks extends BaseClassForHooks{
}
