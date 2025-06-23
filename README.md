SOF3021_Assignment: Coffee Shop Management Application ☕
SOF3021_Assignment is a robust Spring Boot application designed for comprehensive coffee shop management and operation. This project provides a seamless experience for both customers looking to purchase their favorite brews online and administrators overseeing the daily operations, including product, user, and order management.

✨ Core Functionalities
🛍️ Customer Side
Browse & Purchase: Explore a wide range of coffee products and make purchases online.
User Authentication: Secure registration and login, with convenient Google OAuth2 integration.
Order Management: Easily place and track your orders.
Email Notifications: Stay updated with real-time order status through email.
⚙️ Admin Side
Product Management: Full CRUD (Create, Read, Update, Delete) operations for all coffee products.
User Management: Efficiently manage user accounts.
Order Processing: Streamlined order handling and processing.
Admin Dashboard: Access comprehensive dashboards for insightful overviews.
🚀 Main Technologies Used
Category	Technology
Backend	Java, Spring Boot (MVC, Security, Mail, Data JPA)
Database	SQL Server (initialization script provided)
Build Tool	Maven (with Maven Wrapper)
Auth	Spring Security with Google OAuth2
Email	Gmail SMTP for transactional emails
Config	application.properties

Export to Sheets
🌟 Significant Features & Modules
Modular Structure: Follows a standard Maven project layout (src/main/ for source, src/test/ for tests).
Robust Security: Implements secure authentication and authorization for both customer and admin roles.
Resource Management: Configured MVC resource handlers for efficient static content and file uploads.
Data Persistence: Utilizes Spring Data JPA for seamless ORM and data access.
Email Integration: Sends timely notifications using Gmail's SMTP service.
Flexible Configuration: All core settings (database, mail, OAuth2) are easily managed in external properties files.
🤝 Contributor & Community Information
Open Source: This project is proudly open source, licensed under the Apache License 2.0.
Code of Conduct: We adhere to an inclusive and welcoming Code of Conduct, encouraging contributions from all backgrounds.
💡 Getting Started (At a Glance)
Purpose: A comprehensive platform for coffee shop management and online sales.
Tech Stack: Built with Java, Spring Boot, SQL Server, and Maven.
Key Features: Includes product, order, and user management, Google OAuth2 integration, and email notifications.
Ready to Run?
Build the project using the Maven Wrapper.
Configure your settings in application.properties.
Initialize your database with SOF3021_J5_CoffeeShop_Data.sql.
Run the Spring Boot application!
