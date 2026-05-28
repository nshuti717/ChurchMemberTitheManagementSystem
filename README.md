# Church Member & Tithe Management System

## Academic Information
- **Student:** NSHUTI SANO Delphin
- **Student ID:** 27903
- **Course:** INSY 7312 — Java Programming
- **University:** Adventist University of Central Africa (AUCA)
- **Semester:** April 2025-2026 (2)
- **Instructors:** Dr. SEBAGENZI Jason & Jeremie U. Tuyisenge
- **Grade:** 38/40

## Project Description
A distributed Java desktop application for managing church 
members, cell groups, tithe contributions, and church services.

## Technologies Used
- Java RMI — client-server communication
- Java Swing — graphical user interface
- Hibernate ORM — database persistence
- PostgreSQL — relational database
- iText — PDF report generation
- Apache POI — Excel report generation
- ActiveMQ — message broker notifications
- JavaMail — OTP email delivery
- MVC Design Pattern
- DAO Design Pattern

## Project Structure
- ChurchMemberTitheServer — RMI server + Hibernate + PostgreSQL
- ChurchMemberTitheClient — Swing GUI client

## Features
- Role-based access control (Admin and Member roles)
- OTP two-factor authentication via Gmail
- Member self-registration
- CRUD operations for Members, Cell Groups, 
  Services, Contributions, Users
- PDF and Excel report export
- ActiveMQ notification broker
- Input validation (5 business + 5 technical rules) 
