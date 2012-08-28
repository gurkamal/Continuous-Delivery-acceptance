package com.ishisystems.cd.domain;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 8/6/12
 * Time: 4:55 PM
 * To change this template use File | Settings | File Templates.
 */

import org.openqa.selenium.By;

public class ArtifactPageObject {



    private final SharedDriver webDriver;
    private String groupId;
    private String artifactId;
    private String version;
    private String packaging;


    public ArtifactPageObject(SharedDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void navigateToPage()
    {
        webDriver.getURL("/artifact/form.html");
    }

    public void saveArtifactDetails(String groupId, String artifactId, String version, String packaging)
    {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.packaging = packaging;
        webDriver.findElement(By.id("groupId")).sendKeys(String.valueOf(groupId));
        webDriver.findElement(By.id("artifactId")).sendKeys(String.valueOf(artifactId));
        webDriver.findElement(By.id("version")).sendKeys(String.valueOf(version));
        webDriver.findElement(By.id("packaging")).sendKeys(String.valueOf(packaging));
        webDriver.findElement(By.id("artifact")).submit();
    }

    public boolean matchSavedArtifactDetails(String confirmationMessage)
    {
        if(webDriver.getPageSource().contains(confirmationMessage)){
            if(webDriver.findElement(By.id("groupId")).getAttribute("value").equals(groupId) &&
                    webDriver.findElement(By.id("artifactId")).getAttribute("value").equals(artifactId)
                    && webDriver.findElement(By.id("version")).getAttribute("value").equals(version)
                     && webDriver.findElement(By.id("packaging")).getAttribute("value").equals(packaging))
            {
                return true;
            }
        }
        return false;
    }

}
