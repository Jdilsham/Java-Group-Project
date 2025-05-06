-----Sea of Sri Lanka-----

A desktop travel information and booking system built using Java Swing and MySQL, developed by Jayani Anuththara Dahanayaka.

Project Overview

Sea of Sri Lanka is a Java desktop application that allows users to:
-  Search beach destinations based on region
-  View details about destinations
-  Book travel destinations

The GUI is implemented with Java Swing, and data is managed using MySQL through JDBC.

 Technologies Used

- Java (Swing)
- MySQL (via XAMPP)
- JDBC (Database Connectivity)
- NetBeans


 Class Overview

Class Name               Description 
DBConnection         Handles connection to the MySQL database 
ResultController     Retrieves destination results based on region 
ViewDestination      Displays details of a selected destination 
CheckDestination     Checks destination availability or data 
BookDestination      Manages destination booking process 
ViewDetails          UI to show details of a destination
Book (UI class)      UI for booking interface 
Search               Main window to search regions and view results 



Database Setup (XAMPP)

1. Start XAMPP and run MySQL.
2. Create a database named: 'travel'
3. Import your SQL file (travel_database.sql) into the database using phpMyAdmin
4. Make sure the database credentials match this in 'DBConnection.java':
    DriverManager.getConnection("jdbc:mysql://localhost/travel", "root", "");
