package bdd.configurations;

import edu.depinfo.apiweb.webproject.WebprojectApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.springframework.boot.test.context.SpringBootTest;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@CucumberContextConfiguration
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "cucumber")
@SpringBootTest(classes = WebprojectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) // RANDOM_PORT ?
public class CucumberSpringConfiguration {
}
