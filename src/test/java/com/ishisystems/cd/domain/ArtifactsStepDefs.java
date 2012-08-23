package com.ishisystems.cd.domain;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 8/17/12
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
import static org.junit.Assert.assertTrue;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;

public class ArtifactsStepDefs {
    ArtifactPageObject artifactPageObject = null;

    public ArtifactsStepDefs(SharedDriver webDriver) {
        this.artifactPageObject = new ArtifactPageObject(webDriver);
    }

    @Given("^I am on the front page$")
    public void I_am_on_the_front_page() throws Throwable {
        artifactPageObject.navigateToPage();
    }

    @When("^Valid artifact details are submitted$")
    public void valid_artifact_details_are_submitted() throws Throwable {
        artifactPageObject.saveArtifactDetails("com.yt.ishisystems", "continuousDelivery", "1.0", "war");
    }

    @Then("^A confirmation page should show the artifact saved$")
    public void a_confirmation_page_should_show_the_artifact_saved() throws Throwable {
        assertTrue(artifactPageObject.matchSavedArtifactDetails());
        //Do appropriate assertions "The artifact has been saved" "<td>com.ishisystems</td><td>cicd</td><td>1.0</td><td>war</td>"
    }
}
