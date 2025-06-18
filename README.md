# MotorPH Payroll Management System

**MotorPH Payroll Management System** is a desktop application designed to streamline payroll processing and employee management for MotorPH. The system provides a user-friendly interface to manage employee records, process payrolls, and view detailed payslips.

---

## Overview

This system is built to support HR and payroll operations by handling employee records, pay period coverage, payslip generation, and more. It incorporates specifications from the following change requests:
- **MPHCR01** – Core employee data management
- **MPHCR02** – Pay period processing and automation
- **MPHCR03** – Payslip view panel and payroll breakdown logic

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
│   │   ├── DisplayPayruns.java
│   │   ├── EmployeePanel.java
│   │   ├── HomePanel.Java
│   │   ├── LoginScreen.java
│   │   ├── PayrollVer2.java
│   │   ├── PayslipViewPanel.java
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

📄 Payslip View Panel
- Breakdown of deductions (SSS, PhilHealth, Pag-IBIG, Tax)
- Displays net pay and total compensation
- Integrated with time logs and deduction calculations

🔍 Quick Employee Search
- Search bar in employee panel for fast lookup

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
