            # POC Document
                                    Title : ComplatableFuturePOC Documentation
Introduction:

ComplatableFuturePOC is a Proof of Concept (POC) application that demonstrates the usage of CompletableFuture in a Java application. This document provides instructions on how to set up and run the POC, including the installation of MySQL 8, and Java 17, Gradle build tool and running the required services. It also outlines the steps to test the POC using HTTP clients like Postman.

Prerequisites:

Before proceeding with the POC setup, ensure that the following prerequisites are met:

MySQL database is installed on your local system. Java 17 is installed. HTTP client (e.g., Postman) is installed for testing the POC. Gradle build tool

Setting up the POC:

Follow the steps below to set up the ComplatableFuturePOC:

Step 1: Clone CMS (student-service) the Repository Clone the repository https://github.com/sushilv3/cms_poc_backend/tree/master Follow the application.properties file to create db name with mydb

Run the CMS service using the following steps: Navigate to the CMS service directory. Build the CMS service using the provided build script or build tool. Start the CMS service using the appropriate command or IDE. Running the CMS Service Get All Students : http://localhost:7777/api/student Post(save student) http://localhost:7777/api/student/ Post(save List) http://localhost:7777/api/student/save Get (findStudentByCity) http://localhost:5555/api/completableFuture/synchronousCalled/findStudentByCity/agra

Step 2: Clone course-service the Repository Clone the repository https://github.com/sushilv3/course_poc_backend/tree/master Follow the application.properties file to create db name with mydb

Run the courseservice using the following steps: Navigate to the course service directory. Build the course service using the provided build script or build tool. Start the course service using the appropriate command or IDE. Running the course Service Port : http://localhost:6666/api/course

Step 3: Clone the ComplatableFuturePOC repository from the source code repository. https://github.com/sushilv3/poc_completablefuture/tree/master Running the CompletableFuture Service Run the CompletableFuture service using the following steps:

Navigate to the CompletableFuture service directory. Build the CompletableFuture service using the provided build script or build tool. Start the CompletableFuture service using the appropriate command or IDE. Testing the POC: Once all the services are up and running, you can test the ComplatableFuturePOC using HTTP clients like Postman. Follow the steps below: Asynchronous Request

Open Postman or any other HTTP client Send a POST request to the following Asynchronous Request URL:http://localhost:5555/api/completableFuture/asynchronousCalled/findStudentByCity/agra

Open Postman or any other HTTP client Send a POST request to the following Synchronous Request URL:http://localhost:5555/api/completableFuture/synchronousCalled/findStudentByCity/agra

Examine the response received from the CompletableFuture service.
