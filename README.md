# MotorPH Payroll Management System

**MotorPH Payroll Management System** is a desktop application designed to streamline payroll processing and employee management for MotorPH. The system provides a user-friendly interface to manage employee data, view pay periods, and support HR administrative tasks efficiently.

---

## Overview

This project delivers a comprehensive payroll management solution that aligns with the MotorPH branding and functional requirements. It streamlines key HR tasks such as managing employee records, navigating pay periods, and processing payroll coverage, based on specifications from the MPHCR01, MPHCR02 and MPHCR03 change requests.

---

## Folder Structure
```
/project-root
│── src/
|   ├── icons/
│   ├── model/
│   │   ├── EmployeeDetails.java
│   │   ├── EmployeeTimeLogs.java
│   │   ├── MenuHandler.java
│   │   ├── User.java
│   ├── repository/
│   │   ├── DataHandler.java
│   ├── service/
│   │   ├── EmployeeService.java
│   │   ├── PayrollService.java
│   ├── ui/
│   │   ├── components/
│   │   │   ├── CustomFont.java
│   │   │   ├── Menu.java
│   │   │   ├── MenuAnimation.java
│   │   │   ├── MenuItem.java
│   │   │   ├── MyRender.java
│   │   │   ├── RoundedPanel.java
│   │   ├── main/
│   │   │   ├── App.java
│   │   ├── AddEmployee.java
│   │   ├── Attendance.java
│   │   ├── Dashboard.java
│   │   ├── DisplayEmployeeInfo.java
│   │   ├── EmployeePanel.java
│   │   ├── HomePanel.Java
│   │   ├── LoginScreen.java
│   │   ├── Payroll.java
│   │   ├── Undermaintenance.java
|   ├── utils/
│   │   │   ├──EmployeeDataUtil.java
│── fonts/
│   ├── NeuePlakExtendedBold.ttf
│   ├── NeuePlakExtendedRegular.ttf
|   ├── NeuePlakSemiBold.ttf
```
## Features
✅ Employee Record Management
- Add new employees
- Edit existing employee details
- Delete employee records with confirmation

📅 Payroll Period Handling
- Dynamic display of current pay periods based on system date

🔍 Search
- Search bar for quick employee record lookup

💡 Modern Interface
- Clean and consistent GUI using Java Swing
- Aligned with MotorPH’s branding and visual identity

📁 CSV Data Integration
- Employee records are read from and written to CSV files using OpenCSV
- Supports persistent data updates after add/edit/delete actions



## How to Download and Run

1. Click **Code** button on this repository page.
2. Open the project in your IDE/editor and run the application.
3. When the Login Screen appears, use the following credentials to log in:
   - **Email:** `admin123@gmail.com`
   - **Password:** `admin`
