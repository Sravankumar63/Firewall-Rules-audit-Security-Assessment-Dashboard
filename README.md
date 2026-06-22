# Firewall Rules Audit & Security Assessment Dashboard Project


## Overview

The Firewall Security Assessment Dashboard is a web-based cybersecurity application that analyzes firewall configurations, identifies security risks, and evaluates network exposure.
Built with Spring Boot, React, and MySQL, it helps manage firewall rules, calculate security scores, classify risks, and generate security assessment reports through an interactive dashboard.

## Features

* Firewall rule management
* Security risk assessment
* High, Medium, and Low risk classification
* Security score calculation
* Interactive dashboard visualization
* Firewall gap analysis
* PDF report generation
* REST API integration
* MySQL database connectivity

## Technology Stack

### Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Maven

### Frontend

* React JS
* Axios
* Chart.js

### Database

* MySQL

### Testing Tools

* Postman

### Security Environment

* Ubuntu WSL
* iptables

## System Architecture

React Dashboard → Spring Boot REST APIs → MySQL Database

The frontend communicates with backend APIs to retrieve firewall rules, perform security assessments, and generate reports. The backend processes firewall data and stores configurations in MySQL.

## Implementation

The application was developed using a layered architecture consisting of Controller, Service, Repository, and Model components. Firewall rules are stored in the database and retrieved through REST APIs. The dashboard performs security analysis based on firewall configurations and displays findings through charts and summary cards.

## Key Functionalities

### Firewall Rule Management

* Create firewall rules
* Retrieve firewall rules
* View firewall inventory

### Security Assessment

* Analyze target IP addresses
* Detect risky services
* Generate security scores

### Reporting

* Executive summary
* Risk findings
* Recommendations
* Firewall inventory
* PDF export

## Sample Risk Classification

| Port | Service | Risk Level |
| ---- | ------- | ---------- |
| 21   | FTP     | High       |
| 23   | Telnet  | High       |
| 3389 | RDP     | High       |
| 80   | HTTP    | Medium     |
| 22   | SSH     | Low        |
| 443  | HTTPS   | Low        |

## Results

The system successfully performs firewall assessments and provides meaningful security insights. Risk classifications, security scores, and recommendations are dynamically generated based on the selected target configuration. PDF reports can be exported for audit and compliance purposes.

## Screenshots

### Dashboard Home Page

![Dashboard Home](screenshots/dashboard-home.png)

### Security Assessment Results

![Assessment Results](screenshots/assessment-results.png)

### Risk Distribution Chart

![Risk Distribution](screenshots/risk-chart.png)

### Firewall Gap Analysis

![Gap Analysis](screenshots/gap-analysis.png)

### Firewall Rules Inventory

![Firewall Rules](screenshots/firewall-rules.png)

### Generated PDF Report

![PDF Report](screenshots/pdf-report.png)

## Future Enhancements

* Real-time firewall monitoring
* Nmap integration
* User authentication and authorization
* Email alert notifications
* Cloud deployment
* Advanced vulnerability assessment integration

## Learning Outcomes

* Spring Boot REST API Development
* React Frontend Development
* MySQL Database Integration
* API Testing with Postman
* Firewall Security Concepts
* Risk Assessment Techniques
* PDF Report Generation



