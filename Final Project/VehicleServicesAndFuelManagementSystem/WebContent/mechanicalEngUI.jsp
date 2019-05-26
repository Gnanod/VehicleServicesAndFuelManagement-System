<%@page import="com.sliit.vsafms.model.Part"%>
<%@page import="com.sliit.vsafms.service.impl.PartServiceImpl"%>
<%@page import="com.sliit.vsafms.service.PartService"%>
<%@page import="com.sliit.vsafms.model.JobOrderDetails"%>
<%@page import="com.sliit.vsafms.model.JobOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sliit.vsafms.service.JobOrderService"%>
<%@page import="com.sliit.vsafms.service.impl.JobOrderServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%

String  logSession = (String)session.getAttribute("Login");

if (session.getAttribute("Login")!="Logged" && session.getAttribute("position")!="mechanicalEngineer") {
	response.sendRedirect("login.jsp");
}


%>

<!doctype html>
<html lang="en">
<meta charset="ISO-8859-1">
<head>
    <title>VehicleServicesAndFuelManagement</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- Material Kit CSS -->
    <link href="assets/css/material-kit.min1036.css?v=2.0.5" rel="stylesheet" />

</head>



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

                    <h1>Job Order Details</h1>

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
            
        <br>
        <div class="alert alert-info">
        	<div class="container">
        	<div class="alert-icon">
        	<i class="material-icons">info-outline</i>
        	</div>
        <h3 class="title" style="margin-left: 20px">Job Order</h3>
			</div>
			</div>
			
      
         <table class="table" style="width: 100%;" id="JbTable">
                <thead>
                    <tr>
                    
                        <th  class="text-center">Job Order ID</th>
                        <th  class="text-center">Job Order Description</th> 
                        <th  class="text-center">Job Order Status</th>         
                    </tr>
                    
                </thead>
                <tbody>
                  <%JobOrderService Jb = new JobOrderServiceImpl();
                  ArrayList<JobOrder> list = Jb.getAllJobOrder(); 
                  
                  for(JobOrder j :list){
                  
                  %>
                   <tr >
                    
                        <th  class="text-center" id="Jbid"><%=j.getJobOrderID()%></th>
                        <th  class="text-center"><%=j.getJobOrderDescription()%></th> 
                        <th  class="text-center"><%=j.getJobOrderStatus()%></th>         
                    </tr>
                    
                    <%
                    }
                  
                //  JobOrderDetails jo = (JobOrderDetails)request.getAttribute("JobOrderDetails");
                 // if(jo!=null){
                	  
                  
                  
                    %>
                </tbody>
            </table>
        <br><br>
        
        
            <div class="row" >
                
                <table class="table" style="width: 100%;" id="JbDetailTable">
                <thead>
                    <tr>
                    
                        <th  class="text-center">Customer Name </th>
                        <th  class="text-center">Registration Number</th> 
                        <th  class="text-center">Vehicle Model</th>     
                        <th  class="text-center">Brand of the Vehicle</th>  
                        <th  class="text-center">Problem Description</th>            
					          
						                    
                    </tr>
                    
                </thead>
                <tbody id="jobOrder">
                  
                </tbody>
            </table>
                        
                        
                
            </div>


         <br>
         <br>
         <div class="alert alert-info">
        	<div class="container">
        	<div class="alert-icon">
        	<i class="material-icons">info-outline</i>
        	</div>
         <h3 class="title" style="margin-left: 20px">Add Parts to the Job Order</h3>
         </div>
         </div>
         <br>
	     <div class="row">  
        <div class="col-md-6" >
         <b>Search Parts </b>
         
                
                <div class="form-group no-border">
                <input type="text" class="form-control"  name="partId"placeholder="partId" id="textPart">
                
                
                </div>
                <button type="submit" value="Serach" name="Search" class="btn btn-white btn-just-icon btn-round" >
                <i class="material-icons" id="searchPart">search</i>
                </button>
                
              
                
          
            
            
            <table class="table" style="width: 100%;">
                <thead>
                    <tr>
                    
                        <th  class="text-center">PartID</th>
                        <th  class="text-center">Part</th> 
                        <th  class="text-center">Add</th>          
                                
                    </tr>
                </thead>
                <tbody id="partTableId">
                    
                </tbody>
            </table>
            <br>
            <br>
            <div class="card card-pricing card-raised bg-rose">
            <div class="card-body">
         <div class="job_ord">
         	<form action="AddUpdateJobOrderDetails" method="post">
         	
         	
                <b>Job Order ID: </b>
                <input type="text" class="job_ord" id="job_ord" name="id"><br>
                <br>
                <b>Job Order Description: </b>
                <textarea rows="4" cols="50" id="jobOrderDescription" name="jobOrderDescription">
                </textarea>
                <br>
                <br>
                <b>Parts ID: </b>
                <textarea rows="4" cols="50" id="parts_id" name="parts_id">
                </textarea>
                <br>
                <button class="btn btn-primary">Save</button>
                 
             </form>
         </div>
         </div>
         </div>
            <br>
            <br>
            <input type="hidden" id="jobOrderId">
            
		</div>
         <br>
         <br>
         <div class="col-md-6" >
            
            <table class="table" style="width: 100%;">
                <thead>
                    <tr>
                    
                        <th  class="text-center">Parts names</th>
                        <th  class="text-center">Photo</th> 
                        <th  class="text-center">Remove</th>          
             
                        
                    </tr>
                </thead>
                <tbody >
                <%
                	PartService pt = new PartServiceImpl();
                	ArrayList<Part> plist = pt.getAllParts();
                
                for(Part p:plist){
                %>
                    <tr>
                    	
		                 <td class="text-center"><%=p.getPartName() %></td>
						<td class="text-center"><img src="<%=p.getPhoto()%>" style="width:100px;height:100px"></td>
						<form action="RemovePartServlet" method="post">
							<input type="hidden" name="remove"value="<%=p.getPartId()%>">
						  <td class="text-center"> <input type="submit" class="btn btn-primary" class="btn btn_success" value="Remove"></td>
                    	</form>
                    </tr>
                    
                    
                    <%} %>
                </tbody>
                
                
            </table>
    </div>
    </div>
   
         <br>
    
 
    </div>
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




<script>
var table = document.getElementById('JbTable');
console.log(table);
for(var i=1;i<table.rows.length;i++){
	table.rows[i].onclick = function()
	{
		job_ord
		
        document.getElementById("jobOrderId").value = this.cells[0].innerHTML;
		 document.getElementById("job_ord").value = this.cells[0].innerHTML;
        document.getElementById("jobOrderDescription").value = this.cells[1].innerHTML;
        var value = document.getElementById("jobOrderId").value ;
        
        
        console.log("value"+value);
        
        $.ajax(
        		
		        {
		        	
		        
		            type: "post",
		            url: "http://localhost:8081/VehicleServicesAndFuelManagementSystem/GetJobOrderServlet",
		            
		            data: {
		            	 value: value,
		                
		            },
		            success: function (response) {
						 $('#jobOrder').html(response);
		            },
		            error: function () {

		            }
		        }
		    );

	}
}

$('#searchPart').click(function(){
	var part = $('#textPart').val();

	
	 $.ajax(
     		
		        {
		        
		            type: "post",
		            url: "http://localhost:8081/VehicleServicesAndFuelManagementSystem/SearchManageServlet",
		            
		            data: {
		            	 part: part,
		                
		            },
		            success: function (response) {
						 $('#partTableId').html(response);
		            },
		            error: function () {

		            }
		        }
	);
	
});

var arr=[];
function AddProductIdfunction(id){
	

	console.log("YYYYYY"+id);
	var textValue=$('parts_id').val();
	arr.push(id);
	document.getElementById("parts_id").value=arr;
}




</script>
</body>

</html>