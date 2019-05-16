<%@page import="com.sliit.vsafms.model.Fuel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sliit.vsafms.service.impl.FuelServiceImpl"%>
<%@page import="com.sliit.vsafms.service.FuelService"%>
<%@page import="com.sliit.vsafms.service.impl.FuelPaymentServiceImpl"%>
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

            <br>
            <br>

            <h3 class="title" style="margin-left: 20px">Fuel Stoke</h3>


            <!--  -->

            <div class="row" style="margin-left:5px">
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="title">
                        <h4>Petrol Octane 92</h4>
                    </div>
                    <div class="card" style="background-color: rgb(38, 184, 81)">
                        <div class="card-body">
                      
                        	<form class="form" method="post" action="SearchFuelQuantityServlet">
                        	<input type="hidden" id="UpdateFuelQty" name="FuelName" value="Petrol Octane 92">
                            <h2 class="card-title"id="FuelQty">3300 Leaters</h2>
                            
                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-12" style="margin-left:0px;margin-top:-15px">
                        <form class="form" method="post" action="UpdateFuelStockServlet">
                            <select class="selectpicker" name="fuelQuentity" data-style="select-with-transition" title="Single Select"
                                data-size="7">
                                <option disabled>Choose Quantity</option>
                                <option value="3300">3300 Liters</option>
                                <option value="6600">6600 Liters</option>
                                <option value="13200">13200 Liters</option>
                            </select>                        
                        </div>
                        <div class="col-lg-8 col-md-4 col-sm-12">
                        	<input type="hidden" id="UpdateFuelQty" name="FuelName" value="Petrol Octane 92"/>
                            <button type="submit" class="btn btn-warning" style="margin-left: 52%">ADD</button>
                        </div>
                        </form>
                    </div>
                </div>
                <!-- </div>

    <div class="row" style="margin-left:5px"> -->
                <div class="col-lg-4 col-md-6 col-sm-12" style="margin-left:100px">
                    <div class="title">
                        <h4>Petrol Octane 95</h4>
                    </div>
                    <div class="card" style="background-color: rgb(231, 71, 31)">
                        <div class="card-body">
                            <h2 class="card-title">3300 Leaters</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-12" style="margin-left:0px;margin-top:-15px">
                        <form class="form" method="post" action="UpdateFuelStockServlet">
                            <select class="selectpicker" name="fuelQuentity" data-style="select-with-transition" title="Single Select"
                                data-size="7">
                                <option disabled>Choose Quantity</option>
                                <option value="3300">3300 Liters</option>
                                <option value="6600">6600 Liters</option>
                                <option value="13200">13200 Liters</option>
                            </select>
                        </div>
                        <div class="col-lg-8 col-md-4 col-sm-12">
                            <input type="hidden" id="UpdateFuelQty" name="FuelName" value="Petrol Octane 95"/>
                            <button type="submit" class="btn btn-warning" style="margin-left: 52%">ADD</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="row" style="margin-left:5px">
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="title">
                        <h4>Auto Diesel</h4>
                    </div>
                    <div class="card" style="background-color: rgba(62, 71, 80, 0.61)">
                        <div class="card-body">
                            <h2 class="card-title">3300 Leaters</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-12" style="margin-left:0px;margin-top:-15px">
                        <form class="form" method="post" action="UpdateFuelStockServlet">
                            <select class="selectpicker" name="fuelQuentity" data-style="select-with-transition" title="Single Select"
                                data-size="7">
                                <option disabled>Choose Quantity</option>
                                <option value="3300">3300 Liters</option>
                                <option value="6600">6600 Liters</option>
                                <option value="13200">13200 Liters</option>
                            </select>
                        </div>
                        <div class="col-lg-8 col-md-4 col-sm-12">
                            <input type="hidden" id="UpdateFuelQty" name="FuelName" value="Auto Diesel"/>
                            <button type="submit" class="btn btn-warning" style="margin-left: 52%">ADD</button>
                        </div>
                        </form>
                    </div>
                </div>
                <!-- </div>

                <div class="row" style="margin-left:5px"> -->
                <div class="col-lg-4 col-md-6 col-sm-12" style="margin-left:100px">
                    <div class="title">
                        <h4>Supper Diesel</h4>
                    </div>
                    <div class="card" style="background-color: rgba(16, 96, 201, 0.836)">
                        <div class="card-body">
                            <h2 class="card-title">3300 Leaters</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-12" style="margin-left:0px;margin-top:-15px">
                        <form class="form" method="post" action="UpdateFuelStockServlet">
                            <select class="selectpicker" name="fuelQuentity" data-style="select-with-transition" title="Single Select"
                                data-size="7">
                                <option disabled>Choose Quantity</option>
                                <option value="3300">3300 Liters</option>
                                <option value="6600">6600 Liters</option>
                                <option value="13200">13200 Liters</option>
                            </select>
                        </div>
                        <div class="col-lg-8 col-md-4 col-sm-12">
                            <input type="hidden" id="UpdateFuelQty" name="FuelName" value="Supper Diesel"/>
                            <button type="submit" class="btn btn-warning" style="margin-left: 52%">ADD</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="row" style="margin-left:5px">
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="title">
                        <h4>Kerosene</h4>
                    </div>
                    <div class="card" style="background-color:  rgba(247, 14, 14, 0.808)">
                        <div class="card-body">
                            <h2 class="card-title">3300 Leaters</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-12" style="margin-left:0px;margin-top:-15px">
                        <form class="form" method="post" action="UpdateFuelStockServlet">
                            <select class="selectpicker" name="fuelQuentity" data-style="select-with-transition" title="Single Select"
                                data-size="7">
                                <option disabled>Choose Quantity</option>
                                <option value="3300">3300 Liters</option>
                                <option value="6600">6600 Liters</option>
                                <option value="13200">13200 Liters</option>
                            </select>
                        </div>
                        <div class="col-lg-8 col-md-4 col-sm-12">
                            <input type="hidden" id="UpdateFuelQty" name="FuelName" value="Kerosene"/>
                            <button type="submit" class="btn btn-warning" style="margin-left: 52%">ADD</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>



            <!-- </div> -->
            <br>
            <br>
            <br>

        </div>
    </div>
    <div class="modal fade" id="noticeModal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-notice" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" style="margin-left: 50px">Search Excisting Customer</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <i class="material-icons">clear</i>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="instruction">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="row" style="margin-left: 20px">
                                    <div class="col-md-8">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Customer Name">
                                        </div>
                                    </div>
                                    <div class="col-md-2" style="margin-top: 22px;margin-left: -30px">
                                        <button type="button" class="btn btn-info btn-round">Search Customer</button>

                                    </div>
                                </div>


                            </div>
                            <br>
                            <br>

                            <div class="table-responsive" style="margin-left: 30px;">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th class="text-center">#</th>
                                            <th></th>
                                            <th>Customer NIC</th>
                                            <th>Name</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="text-center">1</td>
                                            <td class="text-center">

                                            </td>
                                            <td>Moleskine Agenda</td>
                                            <td>Office</td>

                                        </tr>
                                        <tr>
                                            <td class="text-center">2</td>
                                            <td class="text-center">

                                            </td>
                                            <td>Stabilo Pen</td>
                                            <td>Office</td>

                                        </tr>




                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                    <div class="instruction">
                        <div class="row">
                            <div class="col-md-8">

                            </div>
                            <div class="col-md-4">

                            </div>
                        </div>
                    </div>
                </div>
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
	
	<script type="text/javascript">
	$("#fuelQuentity").change(function(){
	    var x=$(this).val();
	});
	</script>
	
	<script type="text/javascript">
        window.onload = function () {
        document.myform.Submit1.click();
        }
    </script>
    
<!--     <script>
    $('#FuelQty').click(function () {
  	  var searchSupplier=$('#searchSup').val();
  	 
  	  $.ajax(
  		        {
  		            type: "post",
  		            url: "http://localhost:8083/VehicleServicesAndFuelManagementSystem/SearchFuelQuantityServlet",
  		            
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
    </script>    -->   
	
</body>
</html>