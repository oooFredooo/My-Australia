# My-Australia
## Introduction
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
An admin dashboard for report management, user management and providing statistics/analytics of the captured reports. Reports come from an android app for citizens to share and report infrastructure issues (pothole on road, broken chair, etc) with different departments (NSW transport, WaterNSW, etc.). <br/>
<a href="https://www.youtube.com/watch?v=tWexso5tLnI&feature=youtu.be"> Demo video </a>
## Technologies
Java, Jersey (RESTful Web Services framework), Maven, JSP, Servlet, jQuery, JavaScript, ECharts, Google Maps JavaScript API, MySQL, HTML, CSS, DataTables Table plug-in for jQuery, AJAX, JSON, GitHub, Apache Tomcat, Postman
## Project structure
In order to decouple, front end and back end are separate Java maven projects.  
<a href="https://github.com/FredLin2/My-Australia/tree/master/AdminDashboard">AdminDashboard</a> project contains front end code.  
<a href="https://github.com/FredLin2/My-Australia/tree/master/RestfulApi">RestfulApi</a> project contains back end code.
Architecture of back end server:
- [Installation](#installation)
    - [TER](#typo3-extension-repository)
    - [Composer](#composer)
