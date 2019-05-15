<%@page import="com.sliit.vsafms.model.Supplier"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sliit.vsafms.service.SupplierService"%>
<%@page import="com.sliit.vsafms.service.impl.SupplierServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">

<head>
    <title>VehicleServicesAndFuelManagement</title>
    <!-- Required meta tags -->
    <meta charset="ISO-8859-1">
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css"
        href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- Material Kit CSS -->
    <link href="assets/css/material-kit.min1036.css?v=2.0.5" rel="stylesheet" />

</head>



<body>
    <nav class="navbar navbar-color-on-scroll bg-white navbar-transparent fixed-top  navbar-expand-lg  "
        color-on-scroll="100" id="sectionsNav">

        <div class="container">
            <div class="navbar-translate">
                <a class="navbar-brand" href=" ">
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="navbar-toggler-icon"></span>
                    <span class="navbar-toggler-icon"></span>
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item pad">
                        <a href="index.html" class="nav-link">
                            <i class="material-icons">home</i> Home
                        </a>
                    </li>

                    <li class="nav-item pad">
                        <a href="Movies.html" class="nav-link">
                            <i class="material-icons">business_center</i> Shedule
                        </a>
                    </li>
                    <li class="nav-item pad">
                        <a href="#" class="nav-link">
                            <i class="material-icons">business_center</i> Parts
                        </a>
                    </li>
                    <li class="nav-item pad">
                        <a href="FuelManagementHome.jsp" class="nav-link">
                            <i class="material-icons">business_center</i> Fuel
                        </a>
                    </li>


                    <li class="button-container nav-item iframe-extern pad" style="right: 100px;">
                        <a href="login.html" target="_blank" class="btn  btn-rose   btn-round btn-block">
                            <i class="material-icons">fingerprint</i> LOGIN
                        </a>
                    </li>
                    <li class="dropdown nav-item">
                        <a href="#pablo" class="profile-photo dropdown-toggle nav-link" data-toggle="dropdown">
                            <div class="profile-photo-small">
                                <img src="./assets/img/faces/avatar.jpg" alt="Circle Image"
                                    class="rounded-circle img-fluid">
                            </div>
                        </a>
                        <div class="dropdown-menu dropdown-menu-left">

                            <a href="#pablo" class="dropdown-item">ViewProfile</a>
                            <a href="#pablo" class="dropdown-item">EditProfile</a>
                            <a href="#pablo" class="dropdown-item">LogOut</a>
                        </div>
                    </li>

                </ul>
            </div>
        </div>
    </nav>
    <div class="page-header header-filter" data-parallax="true"
        style="background-image: url('assets/images/fuelManagement.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-md-8 ml-auto mr-auto">
                    <div class="brand text-center">

                        <h1> Fuel Management </h1>



                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="main main-raised">
        <div class="container">

            <br/>
            <br/>

            <h3 class="title" style="margin-left: 20px">Supplier Details</h3>
            <div class="col-lg-6 col-md-12">
                <div class="row">

                    <div class="col-md-5">
                        <button class="btn btn-primary btn-round" data-toggle="modal" data-target="#noticeModal">
                            <i class="material-icons">info_outline</i> Add New Supplier
                        </button>
                    </div>
                    <div class="col-md-2"></div>
                    <div class="col-md-5">
                        <div class="row">
                        	<!--  <form action="DeleteFuelSupplierServlet"></form> -->
                            	<input type="text" class="form-control" name="searchSupplier" placeholder="Search" style="margin-top: -20px" id="searchSup">
                            	<button type="submit" class="btn btn-white btn-raised btn-fab btn-round"
                               	 	style="margin: 10px" id = "searchFuelSup">
                                	<i class="material-icons">search</i>
                            	</button>
                           
                        </div>
                    </div>
                </div>
            </div>



            <!--  -->
            <table class="table" style="width:100%">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th class="text-center">Name</th>
                        <th class="text-center">Organization</th>
                        <th class="text-center">Contact</th>
                        <th class="text-center">Email</th>
                    </tr>
                </thead>
                <tbody id="printFuelSup">
                <%
             
                 SupplierService supplierServie = new SupplierServiceImpl();
            
              	 ArrayList<Supplier> list = supplierServie.getAllSupplier();
                                 
                    for(Supplier s:list){
                %>
                <tr>
                        <td><%=s.getsID() %></td>
                        <td class="text-center"><%=s.getsName() %></td>
                        <td class="text-center"><%=s.getsAddress() %></td>
                        <td class="text-center"><%=s.getsPhone() %></td>
                        <td class="text-center"><%=s.getsEmail() %></td>
                        <td class="td-actions" style="width:30px">
                        	<form action="updateSupplier" method="post">
                            	<button type="submit" class="btn btn-warning">UPDATE</button>
                            </form>
                        </td>
                            
                         <td class="td-actions" style="width:30px"> 
                            <form action="DeleteFuelSupplierServlet" method="post">
                            	<input type="hidden" id="DeleteSupplierInput" name="deleteSupplier" value="<%=s.getsID()%>"/>
                            	<button type="submit" class="btn btn-danger">DELETE</button>
                            </form>
                        </td>
                    </tr>
                    <%
                    } 
                    %>              
                                    
                 </tbody>
            </table>


            <!--  -->



            <!--  -->
            <br>
            <br>
            <br>

        </div>
    </div>
    <div class="modal fade" id="noticeModal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-notice" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" style="margin-left: 25%">Add New Supplier</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <i class="material-icons">clear</i>
                    </button>

                </div>

				<form class="form" method="post" action="AddFuelSupplierServlet" name="form1">
                <div class="row" style="margin-left: 10px; margin-right: 10px">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="bmd-label-floating">Supplier ID</label>
                            <input type="text" name="supId" class="form-control" data-toggle="popover" data-container="body" data-original-title="You must input ID through this method" 
                            data-content="ID must be begin with 'FU' and with three Integers...!    ex:(FU000)" data-color="primary">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="bmd-label-floating">Name</label>
                            <input type="text" name="supName" class="form-control">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="bmd-label-floating">Organization</label>
                            <input type="text" name="supOrg" class="form-control">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="bmd-label-floating">Contact</label>
                            <input type="text" name="supContact" class="form-control">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="bmd-label-floating">Email</label>
                            <input type="email" name="supEmail" class="form-control">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group" style="margin:15px 15px">
                            <button type="submit" class="btn btn-primary" onclick="allLetter(document.form1.supId)">ADD Supplier</button>
                        </div>
                    </div>
                </div>
                </form>


                <div class="modal-footer text-center">
                </div>
            </div>
        </div>
    </div>

    <footer class="footer footer-default">
        <div class="container">
            <nav class="float-left" id="footerStyle">
                <ul>
                    <li>
                        <a href="#" class="footStyle">
                            ABOUT US
                        </a>
                    </li>
                    <li>
                        <a href="#" class="footStyle">
                            CONTACT US
                        </a>
                    </li>
                    <li>
                        <a href="#" class="footStyle">
                            FAQ
                        </a>
                    </li>
                    <li>
                        <a href="#" class="footStyle" id="register">
                            Register
                        </a>
                    </li>
                </ul>
            </nav>
            <div class="copyright float-right" id="copyright">
                &copy;
                <script>
                    document.write(new Date().getFullYear())
                </script>,
                made with <i class="material-icons">favorite</i> by
                <a href="https://www.creative-tim.com/" target="_blank">PHGH</a> for a better web.

            </div>
            <div id="social">
                <button class="btn btn-just-icon btn-twitter">
                    <i class="fa fa-twitter"></i>
                </button>
                <button class="btn btn-just-icon  btn-facebook">
                    <i class="fa fa-facebook"> </i>
                </button>

                <button class="btn btn-just-icon  btn-google">
                    <i class="fa fa-google"> </i>
                </button>

                <button class="btn btn-just-icon  btn-linkedin">
                    <i class="fa fa-linkedin"></i>
                </button>
            </div>
        </div>
    </footer>



    <!--   Core JS Files   -->
    <script src="assets/js/core/jquery.min.js" type="text/javascript"></script>
    <script src="assets/js/core/popper.min.js" type="text/javascript"></script>
    <script src="assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
    <script src="assets/js/plugins/moment.min.js"></script>
    <!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
    <script src="assets/js/plugins/bootstrap-datetimepicker.js" type="text/javascript"></script>
    <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
    <script src="assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
    <!--  Google Maps Plugin    -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDGat1sgDZ-3y6fFe6HD7QUziVC6jlJNog"></script>
    <!-- Place this tag in your head or just before your close body tag. -->
    <script async defer src="../../buttons.github.io/buttons.js"></script>
    <!--	Plugin for Sharrre btn -->
    <script src="assets/js/plugins/jquery.sharrre.js" type="text/javascript"></script>
    <!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
    <script src="assets/js/plugins/bootstrap-tagsinput.js"></script>
    <!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
    <script src="assets/js/plugins/bootstrap-selectpicker.js" type="text/javascript"></script>
    <!--	Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
    <script src="assets/js/plugins/jasny-bootstrap.min.js" type="text/javascript"></script>
    <!--	Plugin for Small Gallery in Product Page -->
    <script src="assets/js/plugins/jquery.flexisel.js" type="text/javascript"></script>
    <!-- Plugins for presentation and navigation  -->
    <script src="assets/demo/modernizr.js" type="text/javascript"></script>
    <script src="assets/demo/vertical-nav.js" type="text/javascript"></script>
    <!-- Place this tag in your head or just before your close body tag. -->
    <script async defer src="../../buttons.github.io/buttons.js"></script>
    <!-- Js With initialisations For Demo Purpose, Don't Include it in Your Project -->
    <script src="assets/demo/demo.js" type="text/javascript"></script>
    <!-- Control Center for Material Kit: parallax effects, scripts for the example pages etc -->
    <script src="assets/js/material-kit.min1036.js?v=2.1.1" type="text/javascript"></script>
    
    <script>
    $('#searchFuelSup').click(function () {
  	  var searchSupplier=$('#searchSup').val();
  	 
  	  $.ajax(
  		        {
  		            type: "post",
  		            url: "http://localhost:8083/VehicleServicesAndFuelManagementSystem/SearchFuelSupplierServlet",
  		            
  		            data: {
  		            	searchSupplier: searchSupplier,
  		                
  		            },
  		            success: function (response) {
  						 $('#printFuelSup').html(response);
  		            },
  		            error: function () {

  		            }
  		        }
  		    );
  	  
    });
    </script>
    
  <!-- <script>
      function allLetter(inputtxt) {
        var letterNumber = /^(([F]+)(\.[U]+)(\.[0-9]+)(\.[0-9]+)(\.[0-9]+))+$/;
        if (inputtxt.value.match(letterNumber)) {
          window.location = '/FMSupplier.jsp';
          return true;
        }
        else {
          alert('Invalid Supplier ID ! \nID must be begin with "FU" and with three Integers \nex:(FU000)');
          window.location = '/FMSupplier.jsp';
          return false;
        }
      }
    </script> -->

</body>
</html>
