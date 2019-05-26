<!doctype html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sliit.vsafms.model.Part"%>
<%@page import="com.sliit.vsafms.service.impl.PartManagementImpl"%>
<%@page import="com.sliit.vsafms.service.PartManagement"%>
<html lang="en">


<%
		String  logSession = (String)session.getAttribute("Login");
		
		if (session.getAttribute("Login")!="Logged" && session.getAttribute("position")!="partmanager") {
			
			response.sendRedirect("login.jsp");
			
		}
%>


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

    <style>
         
    </style>

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
                    <a href="addPart.jsp" class="nav-link" >
                        <i class="material-icons">business_center</i> Parts
                    </a>
                </li>
                <li class="nav-item pad">
                    <a href="FuelManagementHome.jsp" class="nav-link" >
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
<div class="page-header header-filter" data-parallax="true" style="background-image: url('assets/images/VehicleParts.jpg')">
    <div class="container">
        <div class="row">
            <div class="col-md-8 ml-auto mr-auto">
                <div class="brand text-center"> 

                    
                    <h1> Vehicle Parts </h1>
                    <h3 class="title text-center"></h3>


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

            <!-- 111111111111111111111111111111111111111111111111111111 -->


             
            <ul class="nav nav-pills nav-pills-primary" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" data-toggle="tab" href="#link1" role="tablist" aria-expanded="true">
                        New
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#link2" role="tablist" aria-expanded="false">
                        Search
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#link3" role="tablist" aria-expanded="false">
                       Update 
                    </a>
                </li>
            </ul>
            <!-- One -->
            <div class="tab-content tab-space">
                <div class="tab-pane active" id="link1" aria-expanded="true">
                        <div class="tim-typo">
                                <h2 class="title">
                                  <span class="tim-note"></span>Add Vehicle Parts</h2>
                              </div>
                            <form action="AddPartServlet" method="post">
                            <div class="form-group bmd-form-group">
                                <label class="bmd-label-static">Name</label>
                                <input type="text" class="form-control" placeholder="Enter Part Name" name="pname">
                              </div>
                
                              <div class="form-group bmd-form-group">
                                <label class="bmd-label-static">Quantity</label>
                                <input type="text" class="form-control" placeholder="Enter Quntity" name="qty">
                              </div>
                
                              <div class="form-group bmd-form-group">
                                <label class="bmd-label-static">Price</label>
                                <input type="text" class="form-control" placeholder="Enter Price" name="price">
                              </div>

                              <div class="form-group">
                                <label for="exampleFormControlSelect1">Brand</label>
                                <select class="form-control selectpicker" data-style="btn btn-link" id="exampleFormControlSelect1" name="brand">
                                  <option>Toyota</option>
                                  <option>Mazda</option>
                                  <option>Honda</option>
                                  <option>Nissan</option>
                                  <option>Suzuki</option>
                                </select>
                              </div>
                              <!-- model button -->
                              
                            <!--  -->
                              <div class="form-group">
                                <label for="exampleFormControlSelect1">Model</label>
                                <select class="form-control selectpicker" data-style="btn btn-link" id="exampleFormControlSelect1" name="model">
                                  <option>Land cruiser</option>
                                  <option>Axela</option>
                                  <option>NSX</option>
                                  <option>Xtrail</option>
                                  <option>Alto</option>
                                </select>
                              </div>
                              
                              <br>
                              <br>
                              <br>

                              <div class="form-group bmd-form-group">
                                <label class="bmd-label-static">Photo</label>
                                <input type="text" class="form-control" placeholder="Enter Link Of Photo" name="photo">
                              </div>
                              
                              <br>
                              <button type="submit" class="btn btn-primary" name="save">Submit</button>
                              </form>
                </div>

                <!-- two -->

                <div class="tab-pane" id="link2" aria-expanded="false">

               <!--     <form class="form-inline ml-auto" action="SearchPartServlet" method="post">-->
                        <div class="form-group no-border">
                          <input type="text" class="form-control" placeholder="Search" name="search" id="inputSearch" >
                        </div>
                        <button type="submit" class="btn btn-white btn-just-icon btn-round" id="btnSearch">
                            <i class="material-icons">search</i>
                        </button>
                <!--    </form> --> 
                        <div class="table-responsive">
                                <table class="table table-shopping">
                                    <thead>
                                        <tr>
                                        	 <th class="th-description">Id</th>
                                            <th class="text-center">Photo</th>
                                            <th>Product</th>
                                            <th class="th-description">Brand</th>
                                            <th class="th-description">Model</th>
                                            <th class="text-right">qty</th>
                                            <th class="text-right">Price</th>
                                             
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody id="parttbody">
                                     
                                     <%
                                     	PartManagement pm = new PartManagementImpl();
                                		
                                		ArrayList<Part> pl = pm.getAllParts();
                                		
                                		for(Part p : pl){
                                     %>
                                         <tr>
                                            <td ><%=p.getPartId() %></td>
                                            <td >
                                            <img src="<%=p.getPhoto()%>" class="rounded img-fluid">
                                              
                                               
                                            </td>
                                            <td class="td-name">
                                               <%=p.getPartName() %>
                                            </td>
                                            <td>
                                               <%=p.getBrand() %>
                                            </td>
                                       		<td> <%=p.getModel() %></td>
                                       		 <td class="td-number">
                                                <%=p.getQty() %>
                                            </td>
                                            <td class="td-number">
                                                <%=p.getPrice() %>
                                            </td>
                                            <td class="td-actions">
                                            <form action="DeletePartServlet" method="post">
                                                 <input type="hidden" name="delete" value=" <%=p.getPartId() %> ">
                                                <input type="submit" class="btn btn-danger"title="Remove item" value="Delete"> 
                                                </form>
                                            </td>
                                           
                                        </tr> 
                                        <%} %>
                                    </tbody>
                                    
                                </table>
                              </div>

                   </div>

                <!-- three -->
                <div class="tab-pane" id="link3" aria-expanded="false">

                   
                    <div class="alert alert-info">
                        <div class="container">
                          <div class="alert-icon">
                            <i class="material-icons">info_outline</i>
                          </div>
                          <h4>Update Prices Of Parts</h4>  
                        </div>
                      </div>
                      <strong><br></strong>
                    <table class="table">
                        <thead>
                            <tr>
                            
                                <th class="text-center">ID</th>
                                <th>Name</th>
                                <th class="text-center">Price</th>
                                <th class="text-center">New Price</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                         			 <%
                                     	PartManagement price = new PartManagementImpl();
                                		
                                		ArrayList<Part> pp = price.getPartPrice();
                                		
                                		for(Part p : pp){
                                     %>
                            <tr>
                            
                                <td class="text-center"><%=p.getPartId() %></td>
                                <td><%=p.getPartName() %></td>
                                <td class="text-center"><%=p.getPrice() %></td>
                                
                                <td>
                                    <form class="form" action="UpdetePartPriceServlet" method="post">
                                    <div class="form-row">
                                      <div >
                                        <input type="text" class="form-control" placeholder="Enter new Price"name="updatePrice" id="price">
                                      </div>
                                    </div>
                                 
                                  
                                    	       <input type="hidden" name="UpdatePartPrice" value="<%=p.getPartId() %>">
                                    	
                                    	
                                    	
                                    	                                     <input type="submit" class="btn btn-success" value="Update" class="text-center" onclick="setPrice()">
                                  </form>
                                  
                                </td>
                                 
                            </tr>
                            <%} %>    
                        </tbody>
                    </table>
            </div>


 
            <!-- 111111111111111111111111111111111111111111111111111111 -->

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
$('#btnSearch').click(function () {
	  var searchPartName=$('#inputSearch').val();
	  $.ajax(
		        {
		        	
		            type: "post",
		            url: "http://localhost:8081/VehicleServicesAndFuelManagementSystem/SearchPartServlet",
		            
		            data: {
		            	searchPartName: searchPartName,
		                
		            },
		            success: function (response) {
					 $('#parttbody').html(response);
		            },
		            error: function () {

		            }
		        }
		    );
	  
});
</script>
<script type="text/javascript">
function setPrice(){
	var value = $("#price").val();
	console.log('hhh'+value);
}
</script>
</body>

</html>