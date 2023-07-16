package com.vitamojo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features"}, 
				glue = {"com.vitamojo.stepdefs", "com.vitamojo.runner.Hooks"},
				plugin = {
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"pretty", "html:reports/cucumber/index.html"
						},
				monochrome = true,
		        publish = false)   
public class CucumberRunner extends AbstractTestNGCucumberTests{}