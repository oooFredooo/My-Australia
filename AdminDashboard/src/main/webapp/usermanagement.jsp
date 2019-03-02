<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.dashboard.entities.DashboardLogin" %>
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
    <link href="./build/css/custom.css" rel="stylesheet">
    
    <!-- data table -->
    <link href="./static/css/jquery.dataTables.min.css" rel="stylesheet" media="screen" />
    <link href="./static/css/jquery-ui.min.css" rel="stylesheet" media="screen"/>    
    <link href="./static/css/mainStyle.css" rel="stylesheet" media="screen"/>    
    <link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/favicon.ico">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.4.0/css/buttons.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.2.2/css/select.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="./css/editor.dataTables.min.css">

    <script src="./static/js/jquery-ui.min.js"></script>
    <script src="./static/js/functions.js" ></script>
    <script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.12.4.js">
    </script>
    <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js">
    </script>
    <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.4.0/js/dataTables.buttons.min.js">
    </script>
    <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/select/1.2.2/js/dataTables.select.min.js">
    </script>
    <script type="text/javascript" language="javascript" src="./js/dataTables.editor.js">
    </script>
    <script type="text/javascript" language="javascript" src="./resources/syntax/shCore.js">
    </script>
    <script type="text/javascript" language="javascript" src="./resources/demo.js">
    </script>
    <script type="text/javascript" language="javascript" src="./resources/editor-demo.js">
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

<script type="text/javascript" language="javascript" class="init">

var editor; // use a global for the submit and return data rendering in the examples

$(document).ready(function() {
	var authority = '<%= account.getAuthority()%>';
	if (authority == "Admin") {
		
	} else {
		$("ul li:eq(2)").remove();
	}
	
	$.fn.dataTable.ext.errMode = 'none';
	
	editor = new $.fn.dataTable.Editor( {
		table: "#example",
		fields:  [ {
			label: "UserName:",
			name: "userName"
		}, {
			label: "Password:",
			name: "password"
		}, {
			label: "Authority:",
			name: "authority"
		}
		],
		idSrc:  'userName'
	} );

	$('#example').DataTable( {
		"pageLength": 8,
		dom: "Bfrtip",
		ajax: "http://localhost:8088/RestfulApi/reports/DashboardUserService/users",
		columns: [
			{ data: "userName" },
			{ data: "password" },
			{ data: "authority" },
		],
		select: true,
		buttons: [
			{ extend: "create", editor: editor },
			{ extend: "edit",   editor: editor },
			{ extend: "remove", editor: editor }
		]
	} );
} );

var UserName;

$(document).ready(function() {
	
	//get UserName of clicked row
	$("#example").on("click", "tr", function() { 
		UserName = $(this).children(":first").text();
	});
	
	// update form
	$(document).on("click", "div.DTE_Action_Edit button", function() { 
		var UserName = $("#DTE_Field_userName").val();
		var Password = $("#DTE_Field_password").val();
		var Authority = $("#DTE_Field_authority").val();

		var data = "{"+"\"userName\":\""+UserName+"\"\,\"password\":\""+Password+"\"\,\"authority\":\""+Authority+"\"}";

		$.ajax({
			type: "PUT",
			async: true, 
			url: 'http://localhost:8088/RestfulApi/reports/DashboardUserService/user',
			data:data,
			contentType:"application/json; charset=utf-8",
			success: function(result) {
				
			}
		});//ajax
	}); 
	
	// create form
	$(document).on("click", "div.DTE_Action_Create button", function() { 
		var UserName = $("#DTE_Field_userName").val();
		var Password = $("#DTE_Field_password").val();
		var Authority = $("#DTE_Field_authority").val();

		var data = "{"+"\"userName\":\""+UserName+"\"\,\"password\":\""+Password+"\"\,\"authority\":\""+Authority+"\"}";
		$.ajax({
			type: "POST",
			async: true,
			url: 'http://localhost:8088/RestfulApi/reports/DashboardUserService/user',
			data:data,
			contentType:"application/json; charset=utf-8",
			success: function(result) {
			}
		});//ajax
		window.location.reload();
	}); 
	
	//delete
	$(document).on("click", "div.DTE_Action_Remove button", function() { 
		$.ajax({
			type: "DELETE",
			async: true, 
			url: 'http://localhost:8088/RestfulApi/reports/DashboardUserService/user/' + UserName,
			success: function(result) {
				
			}
		});//ajax
		
	}); 
});  
</script>

        <!-- page content -->
        <div class="right_col" role="main" style="background-color:white;">
          <div class="demo-html"></div>
          <table id="example" class="display" cellspacing="0" width="100%">
            <thead>
              <tr>
                <th>UserName</th>
                <th>Password</th>
                <th>Authority</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
                <th>UserName</th>
                <th>Password</th>
                <th>Authority</th>
              </tr>
            </tfoot>
          </table>
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
