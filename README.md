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
- <a href="https://github.com/FredLin2/My-Australia/tree/master/RestfulApi/src/com/myaustralia/vo">com.myaustralia.vo</a>: Value Objects, used for front end.
- <a href="https://github.com/FredLin2/My-Australia/tree/master/RestfulApi/src/com/myaustralia/common">com.myaustralia.common</a>: common utilities and helper classes used by all
    - <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/com/myaustralia/common/Adapter.java">Adapter.java</a>: include two functions  
    (1) Convert JavaBeans reports to VO reports (2) Convert VO report to JavaBeans report
    - <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/com/myaustralia/common/DatabaseHelper.java">DatabaseHelper.java</a>: database connnection related functions  
    (1) Load database credentials from database.properties file (2) Get connection (3) Close connection
    - <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/com/myaustralia/common/Dictionary.java">Dictionary.java</a>: (1) Initialize Integer-String HashMap for report status, report stage and report priority. (2) Functions to get HashMap key from value and get HashMap value from key.  
    - <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/com/myaustralia/common/JsonHelper.java">JsonHelper.java</a>: return List<T> in JSON format, there are two different cases: (1) JSON with root element (format required by data table plugin) (2) JSON without root element  
- <a href="https://github.com/FredLin2/My-Australia/tree/master/RestfulApi/src/com/myaustralia/dao">com.myaustralia.dao</a>: Data Access Object that supports Generics  
- <a href="https://github.com/FredLin2/My-Australia/tree/master/RestfulApi/src/com/myaustralia/repositories">com.myaustralia.repositories</a>: Implementation of the functions to be used in the package com.myaustralia.services  
    - <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/com/myaustralia/repositories/ChartRepository.java">ChartRepository.java</a>: return the JSON data to be used by two charts  
    - <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/com/myaustralia/repositories/MapMarkerClusterRepository.java">MapMarkerClusterRepository.java</a>: return the JSON data to be used by Google Maps map marker cluster  
    - <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/com/myaustralia/repositories/MapMarkerRepository.java">MapMarkerRepository.java</a>: return the JSON data to be used by Google Maps map marker       
    - <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/com/myaustralia/repositories/ReportRepository.java">ReportRepository.java</a>: CRUD of report(s)  
    - <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/com/myaustralia/repositories/UserRepository.java">UserRepository.java</a>: CRUD of user(s)  
- <a href="https://github.com/FredLin2/My-Australia/tree/master/RestfulApi/src/com/myaustralia/services">com.myaustralia.services</a>: Calls the functions provided by repositories. Defines URL (Path), Verb (GET, POST, PUT, DELETE), MediaType for different RESTful web services to be consumed by front end  
    - <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/com/myaustralia/services/ImageService.java">ImageService.java</a>: return the image according to ReportId  
    - <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/com/myaustralia/services/ReportService.java">ReportService.java</a>: report related services  
    - <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/com/myaustralia/services/UserService.java">UserService.java</a>: user related services  
    - <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/com/myaustralia/services/VisualizationService.java">Visualization.java</a>: charts and Google Maps related services  
- <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/database.properties">database.properties</a>: contains database driver class, URL, credentials  
- <a href="https://github.com/FredLin2/My-Australia/blob/master/RestfulApi/src/params.properties">params.properties</a>: defines the max image size allowed (in Byte)  
