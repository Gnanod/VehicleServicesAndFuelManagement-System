<%@page import="java.util.ArrayList"%>
<%@page import="com.sliit.vsafms.model.Vehicle"%>
<%@page import="com.sliit.vsafms.service.impl.VehicleServiceImpl"%>
<%@page import="com.sliit.vsafms.service.VehicleService"%>
<%@page import="com.sliit.vsafms.model.Customer"%>
<%@page import="com.sliit.vsafms.service.CustomerService"%>
<%@page import="com.sliit.vsafms.service.impl.CustomerServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

 <% //response.addHeader("Refresh","10;http://localhost:8081/VehicleServicesAndFuelManagementSystem/addJobShedule.jsp"); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VehicleServicesAndFuelManagement</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- Material Kit CSS -->
  <link href="assets/css/material-kit.min1036.css?v=2.0.5" rel="stylesheet" />

        <style>

        </style>
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
                    <a href="index.jsp " class="nav-link" >
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
                    <a href="payment.jsp" class="nav-link" >
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

            <h1>Add New Job Order </h1>



          </div>
        </div>

      </div>
    </div>
  </div>
  <div class="main main-raised">
    <div class="container">

        <br>
        <br>
        <h3 class="title" style="margin-left: 20px">Customer Details</h3>
        <div class="col-lg-4 col-md-6">
            <div class="row">

                <div class="col-md-5">
                    <button class="btn btn-primary btn-round" data-toggle="modal" data-target="#noticeModal">
                        <i class="material-icons">info_outline</i> Excisting Customer
                    </button>
                </div>
                <div class="col-md-2"></div>
                <div class="col-md-5">
                    <button class="btn btn-primary btn-round"  id="btnNewCustomer">
                        <i class="material-icons">info_outline</i> New Customer
                    </button>
                </div>
            </div>
        </div>
        



        <div class="row" style="margin-left: 0px">
            <div class="col-md-6">

                  <div class="form-group">
                        <label for="name" class="">Customer First Name</label>
                        <input type="text" class="form-control" id="name" name="name">
                    </div>
                    <div class="form-group">
                        <label for="Lname" class="">Customer Second Name</label>
                        <input type="text" class="form-control" id="Lname" name="Lname">
                    </div>
                    <div class="form-group">
                        <label for="nic" class="">CustomerNIC</label>
                        <input type="text" class="form-control" id="nic">
                    </div>
                    <div class="form-group">
                        <label for="address" class="">CustomerAddress</label>
                        <input type="text" class="form-control" id="address">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmails" class="">Email address</label>
                        <input type="email" class="form-control" id="email">
                        <span class="bmd-help">We'll never share your email with anyone else.</span>
                    </div>
                    <div class="form-group">
                        <label for="phone" class="">Phone</label>
                        <input type="text" class="form-control" id="phone">
                    </div>


               
            </div>

        </div>

        <br>
        <br>
        <h3 class="title" style="margin-left: 20px">Vehicle Details</h3>
        <div class="col-lg-4 col-md-6">
            <div class="row">

                <div class="col-md-5">
                    <div class="btn btn-primary btn-round" data-toggle="modal" data-target="#noticeModal2">
                        <i class="material-icons">info_outline</i> Excisting Vehicle
                    </div>
                </div>
                <div class="col-md-2"></div>
                <div class="col-md-5">
                    <div class="btn btn-primary btn-round" id="newVehicle" >
                        <i class="material-icons">info_outline</i> New Vehicle
                    </div>
                </div>
            </div>
        </div>
       

        <div class="row" style="margin-left: 0px">
            <div class="col-md-6">

               
                	<div class="form-group">
                        <label for="name" class="">Vehicle Number</label>
                        <input type="text" class="form-control" id="vehicleNumber">
                    </div>
                    <div class="form-group">
                        <label for="name" class="">Engine number</label>
                        <input type="text" class="form-control" id="EngineNumber">
                    </div>
                    
                    <div class="form-group">
                        <label for="Lname" class="">Vehicle class</label>
                        <input type="text" class="form-control" id="VehicleClass">
                    </div>
                    <div class="form-group">
                        <label for="nic" class="">Brand</label>
                        <input type="text" class="form-control" id="brand">
                    </div>
                    <div class="form-group">
                        <label for="nic" class="">Model</label>
                        <input type="text" class="form-control" id="Model">
                    </div>
                    <div class="form-group">
                        <label for="address" class="">Year of manufacture</label>
                        <input type="text" class="form-control" id="Yearofmanufacture">
                    </div>

                    <div class="form-group">
                        <label for="phone" class="">Date of registration</label>
                        <input type="text" class="form-control" id="Dateofregistration">
                    </div>
                    <div class="form-group">
                        <label for="phone" class="" name="BreakDownServices">Fuel type</label>
                        <input type="text" class="form-control" id="Fueltype">
                    </div>


                
            </div>
            
            <div id="script" style="display:none">
            </div>

        </div>

        <br>
        <br>
        <div class="row">
            <div class="col-lg-8 col-md-12">
                <ul class="nav nav-pills nav-pills-icons chooseButton" role="tablist">
                    <!--
                                    color-classes: "nav-pills-primary", "nav-pills-info", "nav-pills-success", "nav-pills-warning","nav-pills-danger"
                                -->
                    <li class="nav-item">
                        <a class="nav-link active" href="#schedule-1" role="tab" data-toggle="tab" >
                            <i class="material-icons">schedule</i> BreakDown Services
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="#schedule-2" role="tab" data-toggle="tab" name="SpecialServices">
                            <i class="material-icons">schedule</i> Special Services
                        </a>
                    </li>

                </ul>
                <div class="tab-content tab-space">
                    <div class="tab-pane active" id="schedule-1">

                     
                            <div class="form-group label-floating">
                                <label class="form-control-label bmd-label-floating" for="message">Details Of BreakDown Service</label>
                                <textarea class="form-control" rows="6" id="message"></textarea>
                            </div>
                        

                        <button  class="btn btn-primary" style="margin-left: 600px" id="BreakDownService">Save Details</button>
                        
                    </div>
                    <div class="tab-pane" id="schedule-2">
                        <div class="form-check">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" value="Auto Body, Collision Repair and Paint" name="check1">Auto Body, Collision Repair and Paint
                                <span class="form-check-sign">
                                    <span class="check"></span>
                                </span>
                                <h5>                                    Auto body, collision repair, and paint services are designed for motorists who need assistance after a vehicle receives damage...
                                </h5>
                            </label>
                        </div>
                        <br>

                        <div class="form-check">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" value="Brake Repair" name="check1">Brake Repair
                                <span class="form-check-sign">
                                    <span class="check"></span>
                                </span>
                                <h5>
                                    A fully functioning brake system is crucial to your safety, the safety of your passengers, and the safety of other drivers on the road...
                                </h5>
                            </label>
                        </div>
                        <br>

                        <div class="form-check">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" value="Cooling System Repair" name="check1">Cooling System Repair
                                <span class="form-check-sign">
                                    <span class="check"></span>
                                </span>
                                <h5>
                                    The cooling system consists of a cooling fan, water pump, thermostat, radiator, heater core, heater valve, and various other parts...
                                </h5>
                            </label>
                        </div>
                        <br>
                        <div class="form-check">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" value="Starting, Charging & Batteries" name="check1">Starting, Charging & Batteries
                                <span class="form-check-sign">
                                    <span class="check"></span>
                                </span>
                                <h5>
                                    Your vehicle’s starting and charging system is involved in regulating multiple electrical processes to start your vehicle's engine...
                                </h5>
                            </label>
                        </div>
                        <br>
                        <button type="submit" class="btn btn-primary" style="margin-left: 600px" id="specialService">Save Details</button>
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
<div class="modal fade" id="noticeModal" tabindex="-1" role="dialog" >
    <div class="modal-dialog modal-notice" role="document" >
        <div class="modal-content" style="width: 600px;">
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
                      <!--    <form action="" method="post">--> 
                            <div class="row" style="margin-left: 20px">
                           
                           <%
                           	
                           %>
                            
                            	<div class="col-md-8">
                                
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="First Name Or Second Name Or NIC" name="searchName" id="searchName">
                                    </div>
                                </div>
                                
                                <div class="col-md-2" style="margin-top: 22px;margin-left: -30px">
                                    <button type="submit" class="btn btn-info btn-round" name="searchCustomerButton" id="btnSearchCustomer">Search Customer</button>
									
                                </div>
                                
                           
                                
                                
                            </div>

 					<!-- 	</form> -->
                        </div>
                        <br>
                        <br>

                        <div class="table-responsive" style="margin-left: 30px;">
                            <table class="table table-striped" id="customerTable">
                                <thead>
                                <tr>
                                  
                  
                                    <th class="text-center">First Name</th>
                                    <th class="text-center">Second Name</th>
									<th class="text-center">Phone Number</th>
									<th class="text-center">NIC</th>
									<th class="text-center">Email</th>
									<th class="text-center">Address</th>
                                </tr>
                                </thead>
                                
                                <tbody id="tableID">
  
                                <%
                                
                                CustomerService customerService= new CustomerServiceImpl();
                               
                                ArrayList<Customer> list = customerService.getAllCustomer();
                         
                                	for(Customer c:list){
										%>
										 <tr>
		                                
		                              
		                                  
		                                    <td class="text-center"><%=c.getCustomerFName() %></td>
											 <td class="text-center"><%=c.getCustomerLName() %></td>
											  <td class="text-center"><%=c.getCustomerPhone() %></td>
											   <td class="text-center"><%=c.getCustomerNic()%></td>
											    <td class="text-center"><%=c.getCustomerEmail() %></td>
											 <td class="text-center"><%=c.getCustomerAddress() %></td>
		                                </tr>
									<% 
                                	}
                               
                              			%>
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


<div class="modal fade" id="noticeModal2" tabindex="-1" role="dialog" >
    <div class="modal-dialog modal-notice" role="document" >
        <div class="modal-content" style="width: 900px;margin-left:-100px">
            <div class="modal-header" >
                <h5 class="modal-title" style="margin-left: 50px">Search Excisting Vehicle</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <i class="material-icons">clear</i>
                </button>
            </div>
            <div class="modal-body" >
                <div class="instruction">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="row" style="margin-left: 20px ;">
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Vehicle Reg Number Or Customer Name" id="inputSearchVehicle">
                                    </div>
                                </div>
                                <div class="col-md-2" style="margin-top: 22px;margin-left: -30px">
                                    <button type="button" class="btn btn-info btn-round" id="SearchVehicle">Search Vehicle</button>

                                </div>
                            </div>


                        </div>
                        <br>
                        <br>

                        <div class="table-responsive" style="margin-left: 30px;">
                            <table class="table table-striped" id="vehicleTable">
                                <thead>
                                <tr>
                                 	<th class="text-center">Vehicle Number</th>
                                    <th class="text-center">Engine Number</th>
                                    <th class="text-center">Vehicle Class</th>
                                    <th class="text-center">Brand</th>
                                    <th class="text-center">Model</th>
									<th class="text-center">Year Of Manufacture</th>
									<th class="text-center">Date Of Manufacture</th>
									<th class="text-center">Fuel Type</th>
									<th class="text-center">Delete</th>
                                </tr>
                                </thead>
                                
                                <tbody id="Tblvehicle">
                                    <%
                                
                            	VehicleService vehicleService = new VehicleServiceImpl();
                                
                                ArrayList<Vehicle> vehicleList = vehicleService.getAllVehicles();
                                	for(Vehicle v:vehicleList){
									%>
                                <tr>
                                	
                                     <td class="text-center"><%=v.getVehicleNumber() %></td>
                                    <td class="text-center"><%=v.getEngineNumber() %></td>
                                    <td class="text-center"><%=v.getVehicleClass()%></td>
									<td class="text-center"><%=v.getVehicleBrand()%></td>
									<td class="text-center"><%=v.getVehicleModel()%></td>
									<td class="text-center"><%=v.getYearOfManufacture()%></td>
									<td class="text-center"><%=v.getDateOfRegistration()%></td>
									<td class="text-center"><%=v.getFuelType()%></td>
									
									<td class="text-center">
												<form action="DeleteVehicleServlet" method="post">
														<input type="hidden" id="DeleteVehicleInput" name="deleteVehicle" value="<%=v.getVehicleId()%>"/>
														<input type="submit" id="DeleteVe" value= "DeleteVehicle" class="btn btn-danger" /> 
												</form>
											
									  
									</td>
						
                                </tr>
                          
                          	<%
                                	}
                          	%>
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

<!-- Ajax Script -->

  <script>
  
  var valu=null;
  $(".chooseButton li a ").click(function() {
	    var optionValue = $(this).prop("href");
	    //console.log('kkkkkk'+optionValue);
	    valu=optionValue.split('#')[1];
	    console.log(valu);
	});
  
  $(document).ready(function(){
	  
	  $("#name").prop('disabled',true);
	  $("#Lname").prop('disabled',true);
	  $("#nic").prop('disabled', true);
	  $("#address").prop('disabled',true);
	  $("#email").prop('disabled',true);
	  $("#phone").prop('disabled',true);
	   
	  $("#vehicleNumber").prop('disabled', true);
	  $("#EngineNumber").prop('disabled', true);
	  $("#VehicleClass").prop('disabled', true);
	  $("#brand").prop('disabled', true);
	  $("#Model").prop('disabled', true);
	  $("#Yearofmanufacture").prop('disabled', true);
	  $("#Dateofregistration").prop('disabled', true);
	  $("#Fueltype").prop('disabled', true);
	  
 });
  
  
  $('#newVehicle').click(function() {
	  $("#vehicleNumber").prop('disabled', false);
	  $("#EngineNumber").prop('disabled', false);
	  $("#VehicleClass").prop('disabled', false);
	  $("#brand").prop('disabled', false);
	  $("#Model").prop('disabled', false);
	  $("#Yearofmanufacture").prop('disabled', false);
	  $("#Dateofregistration").prop('disabled', false);
	  $("#Fueltype").prop('disabled', false);
	 
});
  
  $('#btnNewCustomer').click(function() {
	  $("#name").prop('disabled',false);
	  $("#Lname").prop('disabled', false);
	  $("#nic").prop('disabled', false);
	  $("#address").prop('disabled', false);
	  $("#email").prop('disabled', false);
	  $("#phone").prop('disabled', false);
	 
});
	  
  
  
  
  $('#btnSearchCustomer').click(function () {
	  console.log('ggggggg');
	  var searchName=$('#searchName').val();
	  console.log(searchName);
  
	  $.ajax(
		        {
		            type: "post",
		            url: "http://localhost:8081/VehicleServicesAndFuelManagementSystem/searchCustomerAjax",
		            
		            data: {
		                searchName: searchName,
		                
		            },
		            success: function (response) {
						 $('#tableID').html(response);
		            },
		            error: function () {

		            }
		        }
		    );
	  
  });
  
  
  $('#SearchVehicle').click(function () {
	  var searchName=$('#inputSearchVehicle').val();
	  $.ajax(
		        {
		            type: "post",
		            url: "http://localhost:8081/VehicleServicesAndFuelManagementSystem/searchVehicleAjaxServlet",
		            
		            data: {
		                searchName: searchName,
		                
		            },
		            success: function (response) {
						 $('#Tblvehicle').html(response);
		            },
		            error: function () {

		            }
		        }
		    );
	  
  });
  
  
 
  $('#specialService').click(function(){
	  var fname=$('#name').val();
	  var lname =$('#Lname').val();
	  var nic =$('#nic').val();
	  var address =$('#address').val();
	  var email =$('#email').val();
	  var phone =$('#phone').val();
	  var vehicleNumber =$('#vehicleNumber').val();
	  var EngineNumber =$('#EngineNumber').val();
	  var VehicleClass =$('#VehicleClass').val();
	  var brand =$('#brand').val();
	  var Model =$('#Model').val();
	  var Yearofmanufacture =$('#Yearofmanufacture').val();
	  var Dateofregistration =$('#Dateofregistration').val();
	  var Fueltype =$('#Fueltype').val();
	  var message =$('#message').val();
	  var favorite ;
      $.each($("input[name='check1']:checked"), function(){   
    	  favorute +=favourite;0.32
          favorite.push($(this).val());
          console.log($(this).val());
      });
    //  JSON.stringify(favorite);
     // cosole.log( Json.stringify(favorite));
    //  console.log("My favourite sports are: " + favorite.join(", "));
      
      $.ajax(
		        {
		            type: "post",
		            url: "http://localhost:8081/VehicleServicesAndFuelManagementSystem/AddSpecialJobOrderServlet",
		            
		            data: {
		            	fname: fname,
		            	lname:lname,
		            	nic:nic,
		            	address:address,
		            	email:email,
		            	phone:phone,
		            	vehicleNumber:vehicleNumber,
		            	EngineNumber:EngineNumber,
		            	VehicleClass:VehicleClass,
		            	brand:brand,
		            	Model:Model,
		            	Yearofmanufacture:Yearofmanufacture,
		            	Dateofregistration:Dateofregistration,
		            	Fueltype:Fueltype,
		            
		            	favorite:favorite,
		            },
		            success: function (response) {
						console.log(response);
		            	 $('#script').html(response);
		            },
		            error: function () {

		            }
		        }
		    );
      
	  
  });
  
  $('#BreakDownService').click(function () {
	
	  var fname=$('#name').val();
	  var lname =$('#Lname').val();
	  var nic =$('#nic').val();
	  var address =$('#address').val();
	  var email =$('#email').val();
	  var phone =$('#phone').val();
	  var vehicleNumber =$('#vehicleNumber').val();
	  var EngineNumber =$('#EngineNumber').val();
	  var VehicleClass =$('#VehicleClass').val();
	  var brand =$('#brand').val();
	  var Model =$('#Model').val();
	  var Yearofmanufacture =$('#Yearofmanufacture').val();
	  var Dateofregistration =$('#Dateofregistration').val();
	  var Fueltype =$('#Fueltype').val();
	  var message =$('#message').val();
	  
     
	  $.ajax(
		        {
		            type: "post",
		            url: "http://localhost:8081/VehicleServicesAndFuelManagementSystem/AddJobOrderServlet",
		            
		            data: {
		            	fname: fname,
		            	lname:lname,
		            	nic:nic,
		            	address:address,
		            	email:email,
		            	phone:phone,
		            	vehicleNumber:vehicleNumber,
		            	EngineNumber:EngineNumber,
		            	VehicleClass:VehicleClass,
		            	brand:brand,
		            	Model:Model,
		            	Yearofmanufacture:Yearofmanufacture,
		            	Dateofregistration:Dateofregistration,
		            	Fueltype:Fueltype,
		            	message:message,
		            },
		            success: function (response) {
						console.log(response);
		            	 $('#script').html(response);
		            },
		            error: function () {

		            }
		        }
		    );
	  
  });
  
  var table = document.getElementById('customerTable');
  for(var i = 1; i < table.rows.length; i++){
      //for(var j=1;j<table.column.longth;j++){
          table.rows[i].onclick = function()
          {
              //rIndex = this.rowIndex;
              document.getElementById("name").value = this.cells[0].innerHTML;
              document.getElementById("Lname").value = this.cells[1].innerHTML;
              document.getElementById("nic").value = this.cells[3].innerHTML;
              document.getElementById("address").value =this.cells[5].innerHTML;
              document.getElementById("email").value=this.cells[4].innerHTML;
              document.getElementById("phone").value=this.cells[2].innerHTML;
              $("#name").prop('disabled', true);
        	  $("#Lname").prop('disabled', true);
        	  $("#nic").prop('disabled', true);
        	  $("#address").prop('disabled', true);
        	  $("#email").prop('disabled', true);
        	  $("#phone").prop('disabled', true);
              //  document.getElementById("age").value = this.cells[2].innerHTML;
          };
      //}
  
     
  }
  
  
var table = document.getElementById('vehicleTable');
  for(var i = 1; i < table.rows.length; i++){
      //for(var j=1;j<table.column.longth;j++){
          table.rows[i].onclick = function()
          {
              //rIndex = this.rowIndex;
              document.getElementById("vehicleNumber").value = this.cells[0].innerHTML;
              document.getElementById("EngineNumber").value = this.cells[1].innerHTML;
              document.getElementById("VehicleClass").value = this.cells[2].innerHTML;
              document.getElementById("brand").value =this.cells[3].innerHTML;
              document.getElementById("Model").value=this.cells[4].innerHTML;
              document.getElementById("Yearofmanufacture").value=this.cells[5].innerHTML;
              document.getElementById("Dateofregistration").value=this.cells[6].innerHTML;
              document.getElementById("Fueltype").value=this.cells[7].innerHTML;
              
              $("#vehicleNumber").prop('disabled', true);
        	  $("#EngineNumber").prop('disabled', true);
        	  $("#VehicleClass").prop('disabled', true);
        	  $("#brand").prop('disabled', true);
        	  $("#Model").prop('disabled', true);
        	  $("#Yearofmanufacture").prop('disabled', true);
        	  $("#Dateofregistration").prop('disabled', true);
        	  $("#Fueltype").prop('disabled', true);
        	  
              //  document.getElementById("age").value = this.cells[2].innerHTML;
          };
      //}
      
      //var data =$('.nav-pills-icons li.active a').prop("href");
     // console.log(data);
      
    
     
  }
  $('#DeleteVehicle').click(function () {
	  var deleteVehicle=$('# DeleteVehicleInput').val();
	 console.log('GGGGGGG');
	  $.ajax(
		        {
		            type: "post",
		            url: "http://localhost:8081/VehicleServicesAndFuelManagementSystem/DeleteVehicleServlet",
		            
		            data: {
		            	deleteVehicle: deleteVehicle,
		                
		            },
		            success: function (response) {
						 //$('#Tblvehicle').html(response);
		            },
		            error: function () {

		            }
		        }
		    );
	  
  });
  
 
  </script>
</body>

</html>