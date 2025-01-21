# Employee Management System

## Overview
- The Employee Management System is a web application designed to manage employee records.
- It provides functionalities to add, update, view, and delete employee information.
- This project is built using Java, JDBC, and Servlet technologies.
- The system ensures data integrity and security.
- It also offers a user-friendly interface for ease of use.
- The project follows a modular design to enhance maintainability and scalability.

## Features
- Add new employee records
- Update existing employee records
- View details of employees
- Delete employee records
- List all employees

## Technologies Used
- Java
- JDBC (Java Database Connectivity)
- Servlet
- HTML/CSS (for the front-end)
- MySQL (or any other relational database)

## Prerequisites
- JDK 8 or higher
- Apache Tomcat 9 or higher
- MySQL Database
- IDE (Eclipse, IntelliJ IDEA, etc.)

## Setup Instructions

### Database Setup
1. Install MySQL and create a database named `employee_db`.
2. Execute the following SQL script to create the `employees` table:

```sql
CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    department VARCHAR(50) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);
```

## Project Structure
### Code
``` EmployeeManagementSystem/
│
├── src/
│   ├── com/example/employee/
│   │   ├── servlet/
│   │   │   ├── AddEmployeeServlet.java
│   │   │   ├── UpdateEmployeeServlet.java
│   │   │   ├── ViewEmployeeServlet.java
│   │   │   ├── DeleteEmployeeServlet.java
│   │   │   ├── ListEmployeeServlet.java
│   │   ├── dao/
│   │   │   ├── EmployeeDAO.java
│   │   ├── model/
│   │   │   ├── Employee.java
│   │   ├── util/
│   │   │   ├── DBConnection.java
│
├── web/
│   ├── index.html
│   ├── add_employee.html
│   ├── update_employee.html
│   ├── view_employee.html
│   ├── delete_employee.html
│   ├── list_employees.html
│
├── WEB-INF/
│   ├── web.xml
│
└── README.md
```
## Usage
### Add Employee:

Navigate to the "Add Employee" page.
Fill out the employee details and submit the form.
### Update Employee:

Navigate to the "Update Employee" page.
Enter the employee ID and fetch the current details.
Modify the details and submit the form.
### View Employee:

Navigate to the "View Employee" page.
Enter the employee ID to view the details.
### Delete Employee:

Navigate to the "Delete Employee" page.
Enter the employee ID and confirm the deletion.
### List Employees:

Navigate to the "List Employees" page to see all employee records.

## Contact
For any inquiries or issues, please contact [Nayanjyotisahu123@gmail.com].







