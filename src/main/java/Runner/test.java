package Runner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\GS-2397\\Documents\\FileBeat UI Automation\\src\\main\\java\\Features\\FileBeat.feature"}
        //,tags = {"@tag3"}// @map @notExecute @compose @always1,@always @notExecute1 @logout
        // ,dryRun = true
        ,strict = true
        ,monochrome=true
        ,format= {"pretty","html:test-outout","json:json_output/sample.json"}
        ,glue= {"StepDefinition"})






public class test {
}
