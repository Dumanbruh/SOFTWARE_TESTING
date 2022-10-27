package tests.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Catalog.feature",
        glue = "tests.stepDefinitions")
public class CatalogPageRunner{

}
