<%@page import="com.sliit.vsafms.service.impl.FuelServiceImpl"%>
<%@page import="com.sliit.vsafms.service.FuelService"%>
<%@page import="com.sliit.vsafms.model.Fuel"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <title>VehicleServicesAndFuelManagement</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta charset="ISO-8859-1">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- Material Kit CSS -->
    <link href="assets/css/material-kit.min1036.css?v=2.0.5" rel="stylesheet" />

</head>

<%

String  logSession = (String)session.getAttribute("Login");

if (session.getAttribute("Login")!="Logged" && session.getAttribute("position")!="Reception") {
	response.sendRedirect("login.jsp");
}


%>


<body>
<nav class="navbar navbar-color-on-scroll bg-white navbar-transparent fixed-top  navbar-expand-lg  " color-on-scroll="100" id="sectionsNav">

    <div class="container">
        <div class="navbar-translate">
            <a class="navbar-brand" href=" ">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="sr-only">Toggle navigation</span>
                <span class="navbar-toggler-icon"></span>
                <span class="navbar-toggler-icon"></span>
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item pad">
                    <a href="index.html" class="nav-link" >
                        <i class="material-icons">home</i> Home
                    </a>
                </li>



                <li class="dropdown nav-item">
                    <a href="#pablo" class="profile-photo dropdown-toggle nav-link" data-toggle="dropdown">
                        <i class="material-icons">business_center</i> Shedule
                    </a>
                    <div class="dropdown-menu dropdown-menu-left">
                        <a href="addJobShedule.jsp" class="dropdown-item">JobOrder</a>
                        <a href="payment.jsp" class="dropdown-item">Payment</a>
                        <a href="#pablo" class="dropdown-item">Parts</a>
                    </div>
                </li>
                <li class="nav-item pad">
                    <a href="#" class="nav-link" >
                        <i class="material-icons">business_center</i> Parts
                    </a>
                </li>
                <li class="nav-item pad">
                    <a href="#" class="nav-link" >
                        <i class="material-icons">business_center</i> Fuel
                    </a>
                </li>


<% 
                if (session.getAttribute("Login")=="Logged") {
	



%>
				<li class="dropdown nav-item">
                    <a href="#pablo" class="profile-photo dropdown-toggle nav-link" data-toggle="dropdown">
                        <div class="profile-photo-small">
                            <img src="./assets/img/faces/avatar.jpg" alt="Circle Image" class="rounded-circle img-fluid" >
                        </div>
                    </a>
                    <div class="dropdown-menu dropdown-menu-left">

                        <!--  <a href="#pablo" class="dropdown-item">ViewProfile</a>-->
                        <!--  <a href="#pablo" class="dropdown-item">EditProfile</a>-->
                        <a href="LogOut" class="dropdown-item">LogOut</a>
                    </div>
                </li>
 <%
}else{
 %>

                <li class="button-container nav-item iframe-extern pad" style="right: 100px;">
                    <a href="login.jsp" target="_blank" class="btn  btn-rose   btn-round btn-block" >
                        <i class="material-icons">fingerprint</i>  LOGIN
                    </a>
                </li>
                
 <%} %>  
            </ul>
        </div>
    </div>
</nav>
<div class="page-header header-filter" data-parallax="true" style="background-image: url('assets/images/HomeBanner.jpg')">
    <div class="container">
        <div class="row">
            <div class="col-md-8 ml-auto mr-auto">
                <div class="brand text-center">

                    <h1>Vehicle </h1>
                    <h1>&</h1>
                    <h1> Fuel Management </h1>
                    <h3 class="title text-center">Sample Template</h3>


                </div>
            </div>

        </div>
    </div>
</div>
<div class="main main-raised">
    <div class="container">

        <div class="col-md-10 ml-auto mr-auto">
            <!--<h2 class="title"></h2>-->
            <br>

            <div class="select">
            <div class="row">
                <div class="col-md-6">
                    <div class="tim-typo" style="margin-left: -150px">
                        <h3 class="title">Fuel Payment</h3>
                    </div>
                    <div class="row" style="margin-left: -170px">
                        <div class="col-lg-5 col-md-6 col-sm-12">
                            <div class="title">
                                <h4>Fuel Type</h4>
                            </div>
                        </div>
                        <div class="col-lg-5 col-md-6 col-sm-12" style="margin-left: -100px;margin-top:15px">
                            <select class="selectpicker" data-style="select-with-transition" data-size="4" id="fuel">
                                
                                
                                <%
 								FuelService fuelService = new FuelServiceImpl();                              
                                ArrayList<Fuel> fuelList = fuelService.getFuelName();
                         			
                                
                                	for(Fuel c:fuelList){
                                %>
                                <option value="<%=c.getFuleName() %>" id="firstValue"><%=c.getFuleName() %></option>
                                <%
                                	}
                                %>
                            </select>
                        </div>

                    </div>
                    <div class="row" style="margin-left: -170px">
                        <div class="col-lg-5 col-md-6 col-sm-12">
                            <div class="title">
                                <h4>Price</h4>
                            </div>
                        </div>
                        <div class="col-lg-5 col-md-6 col-sm-12" style="margin-left: -100px;margin-top:15px" id="price">
                            
                        </div>

                    </div>

                    <div class="row" style="margin-left: -170px">
                        <div class="col-lg-5 ">
                            <div class="title">
                                <h4>Volume</h4>
                            </div>
                        </div>
                        <div class="col-lg-5 " style="margin-left: -100px;margin-top:15px">
                            <input type="text" class="form-control" id="volume">
                        </div>
                        <div class="col-lg-2 " >
                            <button class="btn btn-primary" style="margin-top: 10px" id="btnTotal">Total</button>
                        </div>
                    </div>

                    <div class="row" style="margin-left: -170px">
                        <div class="col-lg-5 ">
                            <div class="title">
                                <h4>Total</h4>
                            </div>
                        </div>
                        <div class="col-lg-5 " style="margin-left: -100px;margin-top:15px">
                            <input type="text" class="form-control" id="totalPrice">
                        </div>
                        <div class="col-lg-2 " >
                            <button class="btn btn-primary" style="margin-top: 10px" id="prinBill">PrintBill</button>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="tim-typo" style="margin-left: 0px">
                        <h3 class="title">Services</h3>
                    </div>
                    <div class="row" >
                        <div class="col-lg-5 col-md-6 col-sm-12">
                            <div class="title" style="margin-left: -10px">
                                <h4>Job OrderId</h4>
                            </div>
                        </div>
                        <div class="col-lg-5 col-md-6 col-sm-12" style="margin-left: -100px;margin-top:15px">
                            <input type="text" class="form-control" id="jobOrderId">
                        </div>

                        <div class="col-lg-2 " >
                            <button class="btn btn-primary" style="margin-top: 20px ;height:35px">Search</button>
                        </div>
                    </div>

                </div>
                
                <div id="Message">
                </div>
            </div>
        </div>

        </div>
        <!--</div>-->
        <br>
        <br>
        <br>

    </div>
</div>

<footer class="footer footer-default"  >
    <div class="container" >
        <nav class="float-left" id="footerStyle">
            <ul>
                <li >
                    <a href="#" class="footStyle">
                        ABOUT US
                    </a>
                </li>
                <li >
                    <a href="#" class="footStyle" >
                        CONTACT US
                    </a>
                </li>
                <li >
                    <a href="#" class="footStyle">
                        FAQ
                    </a>
                </li>
                <li >
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
            <button class="btn btn-just-icon btn-twitter" >
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

<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>

<script>

var fuelName=null;

$('#btnTotal').click(function(){
	
	var volume = $('#volume').val();
	var price = $('#input').val();
	var total = volume*price;
	document.getElementById("totalPrice").value = total;
	
});

$('#prinBill').click(function(){
	var volume = $('#volume').val();
	var price = $('#input').val();
	var total = $('#totalPrice').val();
	
	 $.ajax(
		        {
		            type: "post",
		            url: "http://localhost:8081/VehicleServicesAndFuelManagementSystem/AddPaymentServlet",
		            data: {
		            	
		            	total:total,
		            	price:price,
		            	volume:volume,
		            	fuelName:fuelName,
		                
		            },
		            success: function (response) {
						$('#Message').html(response);
						document.getElementById("totalPrice").value =null;
						document.getElementById("volume").value =null;
		            },
		            error: function () {

		            }
		        }
		    );
	
});
$(document).ready(function(){
	
	
        var selectedType = $('#fuel').children("option:selected").val();
       
        fuelName=selectedType;
        $.ajax(
		        {
		            type: "post",
		            url: "http://localhost:8081/VehicleServicesAndFuelManagementSystem/PaymentServlet",
		            data: {
		            	
		            	selectedType: selectedType,
		                
		            },
		            success: function (response) {
						$('#price').html(response);
		            },
		            error: function () {

		            }
		        }
		    );
    
});

$(document).ready(function(){
    $("#fuel").change(function(){
        var selectedType = $(this).children("option:selected").val();
        fuelName=selectedTpe;
        $.ajax(
		        {
		            type: "post",
		            url: "http://localhost:8081/VehicleServicesAndFuelManagementSystem/PaymentServlet",
		            
		            data: {
		            	
		            	selectedType: selectedType,
		                
		            },
		            success: function (response) {
						$('#price').html(response);
		            },
		            error: function () {

		            }
		        }
		    );
    });
});


</script>

</body>



</html>