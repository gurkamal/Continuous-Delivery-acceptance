package com.ishisystems.cd.domain;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = "json:target/cucumber.json", tags = "~@ignore")
public class RunCukesTest {
}
