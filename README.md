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
### Architecture of back end server:
- <a href="https://github.com/FredLin2/My-Australia/tree/master/RestfulApi/src/com/myaustralia/beans">com.myaustralia.beans</a>: JavaBeans, used for back end.
- com.myaustralia.vo: Value Objects, used for front end.
- com.myaustralia.common: common utilities and helper classes used by all
    - Adapter.java: include two functions  
    (1) Convert JavaBeans reports to VO reports (2) Convert VO report to JavaBeans report
    - DatabaseHelper.java: database connnection related functions  
    (1) Load database credentials from database.properties file (2) Get connection (3) Close connection
    - Dictionary.java: (1) Initialize Integer-String HashMap for report status, report stage and report priority. (2) Functions to get HashMap key from value and get HashMap value from key.  
    - JsonHelper.java: return List<T> in JSON format, there are two different cases: (1) JSON with root element (format required by data table plugin) (2) JSON without root element  
- com.myaustralia.dao: Data Access Object that supports Generics  
- com.myaustralia.repositories: Implementation of the functions to be used in the package com.myaustralia.services  
    - ChartRepository.java: return the JSON data to be used by two charts  
    - MapMarkerClusterRepository.java: return the JSON data to be used by Google Maps map marker cluster  
    - MapMarkerRepository.java: return the JSON data to be used by Google Maps map marker       

