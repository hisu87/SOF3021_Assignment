# SOF3021_Assignment: Coffee Shop Management Application ☕

![Coffee Shop Banner](https://img.pikbest.com/origin/06/07/58/01cpIkbEsTjY9.jpg!w700.jpg "An example banner for a coffee shop application")

SOF3021_Assignment is a robust **Spring Boot application** designed for comprehensive **coffee shop management and operation**. This project provides a seamless experience for both **customers** looking to purchase their favorite brews online and **administrators** overseeing the daily operations, including product, user, and order management.

---

## ✨ Core Functionalities

### 🛍️ Customer Side

* **Browse & Purchase**: Explore a wide range of coffee products and make purchases online.
* **User Authentication**: Secure registration and login, with convenient **Google OAuth2** integration.
* **Order Management**: Easily place and track your orders.
* **Email Notifications**: Stay updated with real-time order status through email.

### ⚙️ Admin Side

* **Product Management**: Full **CRUD** (Create, Read, Update, Delete) operations for all coffee products.
* **User Management**: Efficiently manage user accounts.
* **Order Processing**: Streamlined order handling and processing.
* **Admin Dashboard**: Access comprehensive dashboards for insightful overviews.

---

## 🚀 Main Technologies Used

| Category       | Technology                                            |
| :------------- | :---------------------------------------------------- |
| **Backend** | Java, **Spring Boot** (MVC, Security, Mail, Data JPA) |
| **Database** | **SQL Server** (initialization script provided)       |
| **Build Tool** | **Maven** (with Maven Wrapper)                        |
| **Auth** | **Spring Security** with **Google OAuth2** |
| **Email** | **Gmail SMTP** for transactional emails               |
| **Config** | `application.properties`                              |

---

## 🌟 Significant Features & Modules

* **Modular Structure**: Follows a standard Maven project layout (`src/main/` for source, `src/test/` for tests).
* **Robust Security**: Implements secure authentication and authorization for both customer and admin roles.
* **Resource Management**: Configured MVC resource handlers for efficient static content and file uploads.
* **Data Persistence**: Utilizes **Spring Data JPA** for seamless ORM and data access.
* **Email Integration**: Sends timely notifications using Gmail's SMTP service.
* **Flexible Configuration**: All core settings (database, mail, OAuth2) are easily managed in external properties files.

---

## 🤝 Contributor & Community Information

* **Open Source**: This project is proudly open source, licensed under the **Apache License 2.0**.
    [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
* **Code of Conduct**: We adhere to an inclusive and welcoming **Code of Conduct**, encouraging contributions from all backgrounds.

---

## 💡 Getting Started (At a Glance)

* **Purpose**: A comprehensive platform for coffee shop management and online sales.
* **Tech Stack**: Built with **Java**, **Spring Boot**, **SQL Server**, and **Maven**.
* **Key Features**: Includes product, order, and user management, Google OAuth2 integration, and email notifications.
* **Ready to Run?**
    1.  Build the project using the **Maven Wrapper**.
    2.  Configure your settings in `application.properties`.
    3.  Initialize your database with `SOF3021_J5_CoffeeShop_Data.sql`.
    4.  Run the **Spring Boot application**!

 ---

 # SOF3021_Assignment: Ứng Dụng Quản Lý Quán Cà Phê ☕

![Coffee Shop Banner](https://img.pikbest.com/origin/06/07/58/01cpIkbEsTjY9.jpg!w700.jpg "Một ví dụ banner cho ứng dụng quản lý quán cà phê")

SOF3021_Assignment là một **ứng dụng Spring Boot** mạnh mẽ được thiết kế để **quản lý và vận hành toàn diện quán cà phê**. Dự án này mang đến trải nghiệm liền mạch cho cả **khách hàng** muốn mua sản phẩm trực tuyến và **quản trị viên** giám sát các hoạt động hàng ngày, bao gồm quản lý sản phẩm, người dùng và đơn hàng.

---

## ✨ Chức Năng Cốt Lõi

### 🛍️ Dành cho Khách Hàng

* **Duyệt & Mua sắm**: Khám phá nhiều loại sản phẩm cà phê và thực hiện mua hàng trực tuyến.
* **Xác thực người dùng**: Đăng ký và đăng nhập an toàn, với tích hợp **Google OAuth2** tiện lợi.
* **Quản lý đơn hàng**: Dễ dàng đặt và theo dõi các đơn hàng của bạn.
* **Thông báo qua Email**: Luôn cập nhật trạng thái đơn hàng theo thời gian thực qua email.

### ⚙️ Dành cho Quản Trị Viên

* **Quản lý Sản phẩm**: Đầy đủ các thao tác **CRUD** (Tạo, Đọc, Cập nhật, Xóa) cho tất cả sản phẩm cà phê.
* **Quản lý Người dùng**: Quản lý hiệu quả các tài khoản người dùng.
* **Xử lý Đơn hàng**: Xử lý đơn hàng được sắp xếp hợp lý.
* **Bảng điều khiển Admin**: Truy cập các bảng điều khiển toàn diện để có cái nhìn tổng quan sâu sắc.

---

## 🚀 Công Nghệ Chính Được Sử Dụng

| Hạng mục        | Công nghệ                                             |
| :-------------- | :---------------------------------------------------- |
| **Backend** | Java, **Spring Boot** (MVC, Security, Mail, Data JPA) |
| **Cơ sở dữ liệu** | **SQL Server** (cung cấp script khởi tạo)           |
| **Công cụ Build** | **Maven** (với Maven Wrapper)                         |
| **Xác thực** | **Spring Security** với tích hợp **Google OAuth2** |
| **Email** | **Gmail SMTP** cho các email giao dịch                |
| **Cấu hình** | `application.properties`                              |

---

## 🌟 Các Tính Năng & Mô-đun Nổi Bật

* **Cấu trúc Modular**: Tuân theo bố cục dự án Maven tiêu chuẩn (`src/main/` cho mã nguồn, `src/test/` cho các bài kiểm tra).
* **Bảo mật Mạnh mẽ**: Thực hiện xác thực và phân quyền an toàn cho cả vai trò khách hàng và quản trị viên.
* **Quản lý Tài nguyên**: Cấu hình các trình xử lý tài nguyên MVC để quản lý nội dung tĩnh và tải lên tệp hiệu quả.
* **Lớp Cơ sở dữ liệu**: Sử dụng **Spring Data JPA** để ORM (Ánh xạ đối tượng quan hệ) và truy cập dữ liệu liền mạch.
* **Tích hợp Email**: Gửi thông báo kịp thời bằng dịch vụ SMTP của Gmail.
* **Cấu hình Linh hoạt**: Tất cả các cài đặt cốt lõi (cơ sở dữ liệu, email, OAuth2) đều được quản lý dễ dàng trong các tệp thuộc tính bên ngoài.

---

## 🤝 Thông tin Cộng tác viên & Cộng đồng

* **Mã nguồn Mở**: Dự án này tự hào là mã nguồn mở, được cấp phép theo **Giấy phép Apache 2.0**.
    [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
* **Quy tắc Ứng xử**: Chúng tôi tuân thủ **Quy tắc Ứng xử** toàn diện và thân thiện, khuyến khích sự đóng góp từ mọi nền tảng.

---

## 💡 Bắt đầu (Tổng quan nhanh)

* **Mục đích**: Một nền tảng toàn diện để quản lý quán cà phê và bán hàng trực tuyến.
* **Công nghệ**: Được xây dựng bằng **Java**, **Spring Boot**, **SQL Server** và **Maven**.
* **Các tính năng chính**: Bao gồm quản lý sản phẩm, đơn hàng, người dùng, tích hợp Google OAuth2 và thông báo email.
* **Sẵn sàng chạy?**
    1.  Build dự án bằng **Maven Wrapper**.
    2.  Cấu hình các cài đặt của bạn trong `application.properties`.
    3.  Khởi tạo cơ sở dữ liệu của bạn với `SOF3021_J5_CoffeeShop_Data.sql`.
    4.  Chạy ứng dụng **Spring Boot**!
