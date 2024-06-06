#SOF3021_Assignment
##Description
###This is a Spring Boot project named "SOF3021_Assignment". It appears to be a web application that uses JSP for its views. The application is configured to connect to a SQL Server database named "SOF3021_J5_CoffeeShop".

###Project Structure
The project follows the standard Maven project structure with source code located in the src/main/ directory and test code in the src/test/ directory. The project uses a Maven Wrapper, which allows users to build the project without having Maven installed on their system.

###Configuration
The application's configuration is located in the application.properties file in src/main/resources/ and target/classes/. This file contains settings for the Spring MVC view resolver, file upload limits, data source, JPA, mail server, and OAuth2 client registration for Google.

###Building the Project
The project can be built using the Maven Wrapper script located in the root directory of the project. Run the following command in your terminal:

###Running the Project
After building the project, you can run it using the following command:

###Dependencies
The project's dependencies are managed by Maven and are defined in the pom.xml file. The parent POM is the spring-boot-starter-parent, which provides dependency management for Spring Boot applications.

###Database
The project uses a SQL Server database. The SQL script SOF3021_J5_CoffeeShop_Data.sql in the db/ directory might be used to initialize the database.

###Email Configuration
The application is configured to send emails using Gmail's SMTP server. The email credentials are stored in the application.properties file.

###Security
The application uses Spring Security and is configured for OAuth2 with Google.

Please note that this is a high-level overview based on the provided information. For a more detailed documentation, you would need to dive deeper into the codebase, outlining the functionality of each component, the endpoints exposed by the application, the data model, etc.
