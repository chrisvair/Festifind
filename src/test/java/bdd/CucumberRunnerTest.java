package bdd;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
public class CucumberRunnerTest {
    // This class should be empty, it is used as a holder for the annotations
    // Indicates how to run the Cucumber tests

    // With this name we call launch the tests with the command:
    // mvn test
}