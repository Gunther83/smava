# JBehave Selenium Project for Smava Selenium WebDriver Task

Simple project based on the JBehave and Selenium

## Project structure 

1. src/main/java/smava/test/Stories.java is the entry-point that JBehave uses to run the stories.
2. src/main/stories contains the stories run by JBehave via Stories.java.
3. src/main/java/smava/test/steps/Steps.java contains the steps mapped to the textual steps.
4. src/main/java/smava/test/pages contains the Java page-objects used by steps to abstract in a more manageable and maintainable way the interaction with the web pages via Selenium WebDriver.
5. src/main/resources/smavatest-steps.xml contains the Spring configuration for composition the steps


## Prerequisites

* JDK 6+
* Maven 2+
* Firefox 25+


## Linux configuration

Is similar to Windows one.
Simply make sure that:
* JAVA\_HOME and M2\_HOME system variables are properly set.
* folder with Firefox binary is in your $PATH system variable


## Add a new user story

Create a new text file with '.story' extension in the src/main/stories folder.
Then write down the body of the user story you want to run.


## Running a single story in IDE

Go to the 'RunSingleStory.java' method 'runTest' and change the name of the user story you want to run.
Remember that the story name has to be exactly the same as the story filename but without the '.story' extension.

## Running stories from the command line

This will run the build and (after a minute or so) Firefox will open and run the tests:

    mvn clean install

This will run a single story (one contained in a searchFromHomePage.story file):

    mvn clean install -DstoryFilter=searchFromHomePage

This will run a suite based on the meta filters in the three story files:

    mvn clean install -Dmeta.filter="+page home"

## Viewing the results

After each run new report can be found in target/jbehave/view. 
Report file is named: 'reports.html'
There should be a row for each story.
The story reports are clickable to via links on the right-most column.