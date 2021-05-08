# Java,TestNG and RestAssured based API Test Automation Framework.

## Description:
This API test automation framework was created with the purpose of test some NASA GET requests from: <https://api.nasa.gov/index.html#getting-started> 
as an assessment for the Deviget hiring process.

This framework is based on the following technologies:
* Java
* RestAssured
* TestNG
* Gradle

## Technology Stack Explanation:
Using Gradle which is the build automation tool chosen, the technology dependencies are downloaded to the solution that allows us to import the RestAssured 
and TestNG libraries. RestAssured  is a Java-based library that is used to test RESTful Web Services. This library behaves like a headless Client to build, 
consume and retrieve REST web services request and responses bodies for Java which is the programing language used in this case. 
In another hand, TestNG is a testing framework for Java inspired by JUnit and NUnit that provides us annotations to perform unit, integration and functional testing.


## How does this solution work?
I have created only two classes for this, the GetRequestsBuilder.class which is the main class where I'm building, consuming and retrieving the response body
as a list of objects and the GetRequestsTestSuite.class which is using the list of objects sent by the previous class to perform assertions and verifications 
over these objects which are the API responses gotten.

## Preconditions to be able to use this solution:
* Java Development Kit 8 or higher.
* IntelliJ as the IDE.
* Git to clone this repo.


Finally, if there are questions or doubts, please contact me: Eliecer Cordero <eliecer.cm@hotmail.com>.


