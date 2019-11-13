<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.dashboard.beans.DashboardLogin" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Admin Dashboard</title>

    <!-- Bootstrap -->
    <link href="./vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="./vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="./vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="./vendors/iCheck/skins/flat/green.css" rel="stylesheet">
	
    <!-- bootstrap-progressbar -->
    <link href="./vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="./vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="./vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="./build/css/custom.min.css" rel="stylesheet">
    <link href="./static/css/jquery-ui.min.css" rel="stylesheet" media="screen"/>    
    <link href="./static/css/mainStyle.css" rel="stylesheet" media="screen"/>
    <link href="./css/custom.css" rel="stylesheet"/> 
    
    <script type="text/javascript" language="javascript" src="./js/echarts.js"></script>
    <script src="./static/js/jquery-ui.min.js"></script>
    <script src="./static/js/functions.js" ></script>
    <script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.12.4.js">
    </script>
    <script type="text/javascript" language="javascript" src="./resources/syntax/shCore.js">
    </script>
    <script type="text/javascript" language="javascript" src="./resources/demo.js">
    </script>
    <script type="text/javascript" language="javascript" src="./resources/editor-demo.js">
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCpB-kmj8ZpVUTJDHFlrM3il97skUyvoNc&language=en-za"></script>
    <script src="https://cdn.rawgit.com/googlemaps/v3-utility-library/master/infobox/src/infobox.js"></script>
    <script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
    </script>
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
            </div>
            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
              </div>
              <div class="profile_info" style="color:#fff">
                <span>Welcome,</span>
                <%
                  DashboardLogin account = (DashboardLogin)session.getAttribute("account");
                %>
                <%= account.getUsername()%>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />
<script>
$(document).ready(function() {
	var authority = '<%= account.getAuthority()%>';
	if (authority == "Admin") {
		$("#sidebar-menu ul li:eq(1)").after("<li><a href=\"usermanagement.jsp\"><i class=\"fa fa-table\"></i>User Management</a></li>");
	} else {
		
	}
})
</script>        
    
            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a href="./report.jsp"><i class="fa fa-edit"></i> Report </a>
                  </li>
                  <li><a href="analytics.jsp"><i class="fa fa-bar-chart-o"></i> Analytics </a>
                  </li>
                </ul>
              </div>
            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="index.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>
              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <%= account.getUsername()%>
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="index.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->
        
        <!-- page content -->
        <div class="right_col" role="main" style="background-color:white;">

<script>

function renderGoogleMap() {
	var start_point = new google.maps.LatLng(0, 0);

	// Creating a new map
	var map = new google.maps.Map(document.getElementById("locations-map"), {
		center: start_point,
		zoom: 6,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	});

	// Creating a global infoWindow object that will be reused by all markers
	var infoWindow = new google.maps.InfoWindow();

	function setMarkerPoints(map, marker) {
		var bounds = new google.maps.LatLngBounds();

		$.ajax({
			type: "GET",
			url: 'http://localhost:8088/RestfulApi/reports/visualization/getmapmarkers/' + '<%= account.getAuthority()%>',
			dataType: "json",
			success: function(data) {
				if (data.length !== 0) {
					$.each(data, function(marker, data) {
						var latLng = new google.maps.LatLng(data.lat, data.lng);
						bounds.extend(latLng);

						// Creating a marker and putting it on the map
						var marker = new google.maps.Marker({
							position: latLng,
							map: map,
							title: data.title
						});

						var windowContent = '<h3>' + data.title + '</h3>' +
							'<p>' + data.description + '</p>';

						// Attaching a click event to the current marker
						infobox = new InfoBox({
							content: infoWindow.setContent(windowContent),
							alignBottom: true,
							pixelOffset: new google.maps.Size(-160, -45)
						});

						google.maps.event.addListener(marker, 'click', function() {
							// Open this map's infobox
							infobox.open(map, marker);
							infobox.setContent(windowContent);
							map.panTo(marker.getPosition());
							infobox.show();
						});
						
						google.maps.event.addListener(map, 'click', function() {
							infobox.setMap(null);
						});
          			});
					map.fitBounds(bounds);
        		}
      		},
			error: function(data) {
				console.log('Please refresh the page and try again');
			}
		});
    	//END MARKER DATA
    	
    // end loop through json
  	}
  setMarkerPoints(map);
}

google.maps.event.addDomListener(window, 'load', renderGoogleMap);
// renderGoogleMap();
</script>
   
        <div class="row">
          <div class="col-md-8 col-sm-8 col-xs-12">
            <div class="x_panel">
              <div class="x_title">
              <h2>Report location</h2>
              <ul class="nav navbar-right panel_toolbox">
                <li>
                  <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                </li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                  <ul class="dropdown-menu" role="menu">
                    <li>
                      <a href="#">Settings 1</a>
                    </li>
                    <li>
                      <a href="#">Settings 2</a>
                    </li>
                  </ul>
                </li>
                <li>
                  <a class="close-link"><i class="fa fa-close"></i></a>
                </li>
              </ul>
              <div class="clearfix"></div>
              </div>
              <div class="x_content">
                <div id="locations-map"></div>
              </div>
            </div>
          </div>
        </div>
         
        <div class="col-md-8 col-sm-8 col-xs-12">
          <div class="x_panel">
            <div class="x_title">
              <h2>Report location cluster</h2>
              <ul class="nav navbar-right panel_toolbox">
                <li>
                  <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                </li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                  <ul class="dropdown-menu" role="menu">
                    <li>
                      <a href="#">Settings 1</a>
                    </li>
                    <li>
                      <a href="#">Settings 2</a>
                    </li>
                  </ul>
                </li>
                <li>
                  <a class="close-link"><i class="fa fa-close"></i></a>
                </li>
              </ul>
              <div class="clearfix"></div>
            </div>
            <div class="x_content">
              <div id="map2" style="width: 670px;height:600px;"></div>
            </div>  
	      </div> 
        </div> 
        
<script>
function initMap() {

	var locations;
	
	$.ajax({
		async: false,
		type: "GET",
		url: 'http://localhost:8088/RestfulApi/reports/visualization/getmapmarkerclusters/' + '<%= account.getAuthority()%>',
		dataType: "json",
		success: function(data) {
			locations=data;
		}
	});
      
	var map2 = new google.maps.Map(document.getElementById('map2'), {
		zoom: 3,
		center: {lat: -28.024, lng: 140.887}
	});

	// Add some markers to the map.
	// Note: The code uses the JavaScript Array.prototype.map() method to
	// create an array of markers based on a given "locations" array.
	// The map() method here has nothing to do with the Google Maps API.
	var markers = locations.map(function(location, i) {
		return new google.maps.Marker({
			position: location
		});
	});
	
	// Add a marker clusterer to manage the markers.
	var markerCluster = new MarkerClusterer(map2, markers,
		{imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
}
</script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCpB-kmj8ZpVUTJDHFlrM3il97skUyvoNc&callback=initMap&language=en-za"></script>  
     
        <div class="col-md-8 col-sm-8 col-xs-12">
          <div class="x_panel">
            <div class="x_title">
              <h2>Suburbs with most reports (top 10)</h2>
              <ul class="nav navbar-right panel_toolbox">
                <li>
                  <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                </li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                    <ul class="dropdown-menu" role="menu">
                      <li>
                        <a href="#">Settings 1</a>
                      </li>
                      <li>
                        <a href="#">Settings 2</a>
                      </li>
                    </ul>
                </li>
                <li>
                  <a class="close-link"><i class="fa fa-close"></i></a>
                </li>
              </ul>
              <div class="clearfix"></div>
            </div>
            <div class="x_content">
              <div id="HowManyReportsEachSuburb" style="width: 670px;height:400px;"></div>
            </div>
            
<script type="text/javascript">
        
	var myChartHowManyReportsEachSuburb = echarts.init(document.getElementById('HowManyReportsEachSuburb'));

	var option = {
		title: {
			text: 'Suburbs with most reports (top 10)'
		},
		tooltip: {},
		xAxis: {
			data: []
		},
		yAxis: {
			name: 'Number of reports'
		},
		grid: {
			x: 100,
			y2: 100
		},
		dataZoom: [
			{   
				type: 'slider', 
				start: 0,      
				end: 100         
			}
		],
		series: [{
			name: 'Number of reports',
			type: 'bar',
			data: []
		}],
		toolbox: {
			show: true,
			feature: {
				dataView: {readOnly: false},
				magicType: {type: ['line', 'bar']},
				restore: {},
				saveAsImage: {}
			}
		}
	};

	myChartHowManyReportsEachSuburb.setOption(option);
		
	function HowManyReportsEachSuburb() {
		$.ajax({
			type: "get",
			async: true, 
			url: "http://localhost:8088/RestfulApi/reports/visualization/getsuburbcount/" + '<%= account.getAuthority()%>',
			dataType: "json", 
			success: function(result) {
				var suburb = [];
				var count = [];
				$.each(result,function(i,p) {
					suburb[i] = p['suburb'];
					count[i] = p['count'];
				});
				myChartHowManyReportsEachSuburb.hideLoading();
				myChartHowManyReportsEachSuburb.setOption({
					xAxis: {
						axisLabel :{
							show: true, 
							interval: 0,
							rotate: 30
						},
						name: 'Suburb',
						data: suburb
					},
					series: [{
						name: 'Number of reports',
						data: count
					}]
				});
			}
		});
	}
	HowManyReportsEachSuburb();
</script>		
                   
          </div>
        </div>
        
        <!-- Routes with most reports (top 10) -->
        <div class="col-md-8 col-sm-8 col-xs-12">
          <div class="x_panel">
            <div class="x_title">
              <h2>Routes with most reports (top 10)</h2>
                <ul class="nav navbar-right panel_toolbox">
                  <li>
                    <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                  </li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                    <ul class="dropdown-menu" role="menu">
                      <li>
                        <a href="#">Settings 1</a>
                      </li>
                      <li>
                        <a href="#">Settings 2</a>
                      </li>
                    </ul>
                  </li>
                  <li>
                    <a class="close-link"><i class="fa fa-close"></i></a>
                  </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
              <div id="HowManyReportsEachRoute" style="width: 670px;height:400px;"></div>
            </div>
            
<script type="text/javascript">
       
	var myChartHowManyReportsEachRoute = echarts.init(document.getElementById('HowManyReportsEachRoute'));

	var option = {
		title: {
			text: 'Routes with most reports (top 10)'
		},
		tooltip: {},
		xAxis: {
			data: []
		},
		yAxis: {
			name: 'Number of reports'
		},
		grid: {
			x: 100,
			y2: 100
		},
		dataZoom: [
			{   
				type: 'slider', 
				start: 0,      
				end: 100         
			}
		],
		series: [{
			name: 'Number of reports',
			type: 'bar',
			data: []
		}],
		toolbox: {
			show: true,
			feature: {
				dataView: {readOnly: false},
				magicType: {type: ['line', 'bar']},
				restore: {},
				saveAsImage: {}
			}
		}
	};

	myChartHowManyReportsEachRoute.setOption(option);
	
	function HowManyReportsEachRoute() {
		$.ajax({
			type: "get",
			async: true, 
			url: "http://localhost:8088/RestfulApi/reports/visualization/getroutecount/" + '<%= account.getAuthority()%>',
			dataType: "json", 
			success: function(result) {
				var suburb = [];
				var count = [];
				$.each(result, function(i, p) {
					suburb[i] = p['suburb'];
					count[i] = p['count'];
				});
			myChartHowManyReportsEachRoute.hideLoading();
			myChartHowManyReportsEachRoute.setOption({
				xAxis: {
					axisLabel :{
						show: true, 
						interval: 0,
						rotate: 30
					},
					name: 'Route',
					data: suburb
				},
				series: [{
					name: 'Number of reports',
					data: count
				}]
			});
		}
	});
	}
	HowManyReportsEachRoute();
</script>
		
          </div>
        </div>
      </div>
    </div>
    <!-- /page content -->

    <!-- footer content -->
    <footer>
      <div class="pull-right">
      </div>
      <div class="clearfix"></div>
    </footer>
    <!-- /footer content -->
  </div>
</div>

    <!-- Bootstrap -->
    <script src="./vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="./vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="./vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="./vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="./vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="./vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="./vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="./vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="./vendors/Flot/jquery.flot.js"></script>
    <script src="./vendors/Flot/jquery.flot.pie.js"></script>
    <script src="./vendors/Flot/jquery.flot.time.js"></script>
    <script src="./vendors/Flot/jquery.flot.stack.js"></script>
    <script src="./vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="./vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="./vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="./vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="./vendors/DateJS/build/date.js"></script>
    <!-- JQVMap -->
    <script src="./vendors/jqvmap/dist/jquery.vmap.js"></script>
    <script src="./vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script src="./vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="./vendors/moment/min/moment.min.js"></script>
    <script src="./vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="./build/js/custom.min.js"></script>
	
  </body>
</html>
