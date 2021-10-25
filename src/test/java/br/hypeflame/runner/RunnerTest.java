package br.hypeflame.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/features/blog/blog.feature",
		glue = "br.hypeflame.acceptance",
		tags = "@acceptance",
		plugin = { "pretty"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,		
		dryRun = false
)


public class RunnerTest {

	@BeforeClass
	public static void chromeBrowser() {
		
		System.out.println("Start Test");

	}

	@AfterClass
	public static void closeBrowser() {

		System.out.println("Close Test");

	}

}
