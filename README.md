# InLoop
Cross browser Parallel testing

Developer : Asit
email : asitishere@yahoo.com

Before you run the test :

Note : The test is executing in MAC ( iOS) but added check for Windows and extra check can ne added for Linux

Install and set path Java 1.8 or higher
Install maven 3.3.2 or higher and set to path

Open the project in Intellij Idea or Eclipse ( Maven will auto impport the dependancies)

Config Change for Environment 

1: Select any browser (Chrome and Firefox and provisioned now and can be extended to IE and safari) change the "browser_config.properties" file


The test run in Parallel threads , its upto the executor to select how many browser instance we want to spin up.This can be controlled by changing the 
below parameters in POM .xml. Later we can pass as a property flag during execution.

                <configuration>
                    <forkCount>4</forkCount>
                    <testFailureIgnore>true</testFailureIgnore>
                </configuration>
  
  
 To execute test please use command " mvn clean verify"
 
 to check the report after execution open /target folder and open the report html file from below location
 
 ${project.build.directory}/LanternPay-Automation-report
 
 
                

