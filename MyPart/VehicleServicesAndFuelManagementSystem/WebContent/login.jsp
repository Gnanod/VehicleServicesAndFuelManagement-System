<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

    <title>VehicleServicesAndFuelManagement</title>
 <!-- Required meta tags -->
  	<meta charset="ISO-8859-1">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- Material Kit CSS -->
    <link href="assets/css/material-kit.min1036.css?v=2.0.5" rel="stylesheet" />

    <style>

        .pad{
            padding: 10px;
        }
        #sliitLogo{
            margin-left: 20px;
            width: 306px;
            height: 117px;
            margin-top: 290px;
        }

        .boader:focus {
            border-color: orangered;
        }
        #loginTitle{
            margin-left: 380px
        }
        #secondRow{
            width:100%; height: 100px; margin-top: 95px
        }
        #loginDetails{
            margin-left: 50px;
            margin-top: -10px;
        }
        #background{
            background-image: url('assets/images/VehicleParts.jpg');
            background-size: cover;
            background-position: top center;
            width: 100%;
            height: 540px;
        }
        #forgetPassword{
            margin-left: 250px;
            /*color: orangered;*/
        }
        #acuntYet{
            margin-left: 40px;
            margin-top: -10px;
        }
        #social{
            margin-left: -750px;
            margin-top:40px;
        }

        #marsLogo{
            height:72px;
            width:200px;
            margin-top: -20px;
        }

        @media screen and (max-width: 414px) {
            /*.col-25, .col-75, input[type=submit] {*/
            /*width: 100%;*/
            /*margin-top: 0;*/
            /*}*/
            #sliitLogo{

                width: 300px;
                height: 100px;
                margin-left: 30px;
                filter: brightness(1.0);
            }
            #loginTitle{
                margin-left: 50px;

            }
            #nameLoging{
                font-size: 45px;
            }
            #loginDetails{
                margin-left: 20px;
                margin-top:130px;
                width: 350px;
            }
            #background{
                height:700px;
            }
            #forgetPassword{
                margin-left: 160px;
            }
            #acuntYet{
                margin-left: 10px;
            }

            #footerStyle{
                margin-left: 30px;
            }

            #copyright{
                position: absolute;
                margin-top: 50px;
                margin-left: 30px;
            }
            #social{
                margin-left: 20px;
                margin-top:100px;
            }

            #marsLogo{
                height:52px;
                width:150px;
                margin-top: -10px;
            }
        }
        @media screen and (max-width: 375px) {


            #marsLogo{
                height:52px;
                width:150px;
                margin-top: -10px;
            }
            #sliitLogo{

                margin-top: -20px;
                width: 250px;
                height: 75px;
                margin-left: 60px;
                filter: brightness(1.0);

            }
            #loginTitle{

                margin-left: 70px;

            }
            #nameLoging{
                font-size: 36px;
            }
            #loginDetails{
                margin-left: 5px;
                margin-top:100px;
                width: 330px;
            }
            /*#background{*/
            /*height:700px;*/
            /*}*/
            #forgetPassword{
                margin-left: 140px;
            }
            /*#acuntYet{*/
            /*margin-left: 10px;*/
            /*}*/

            #footerStyle{
                margin-left: -10px;
                /*font-size: 10px;*/
            }
            .footStyle{
                font-size: 14px;
            }

            #copyright{
                position: absolute;
                margin-top: 100px;
                margin-left: 5px;
            }

            #social{
                margin-left: 20px;
                margin-top:170px;
            }
            #register{
                margin-left: 20px;
            }
        }

        @media screen and (max-width: 320px) {


            #marsLogo{
                height:52px;
                width:150px;
                margin-top: -10px;
            }
            #sliitLogo{

                margin-top: -20px;
                width: 250px;
                height: 75px;
                margin-left: 40px;
                filter: brightness(1.0);

            }
            #loginTitle{

                margin-left: 60px;

            }
            #nameLoging{
                font-size: 30px;
            }
            #loginDetails{
                margin-left: 5px;
                margin-top:80px;
                width: 280px;
            }
            /*#background{*/
            /*height:700px;*/
            /*}*/
            #forgetPassword{
                margin-left: 95px;
            }
            /*#acuntYet{*/
            /*margin-left: 10px;*/
            /*}*/

            #footerStyle{
                margin-left: -30px;
                /*font-size: 10px;*/
            }
            .footStyle{
                font-size: 12px;
            }

            #copyright{
                position: absolute;
                margin-top: 100px;
                margin-left: 0px;
            }

            #social{
                margin-left: 20px;
                margin-top:170px;
            }
            #register{
                margin-left: 20px;
            }
        }


    </style>
</head>

<body>

<nav class="navbar navbar-color-on-scroll bg-white navbar-transparent fixed-top  navbar-expand-lg  " color-on-scroll="100" id="sectionsNav">

    <div class="container">
        <div class="navbar-translate">
            <a class="navbar-brand" href="https://demos.creative-tim.com/material-kit/index.html">
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
                    <a href="index.jsp" class="nav-link" >
                        <i class="material-icons">home</i> Home
                    </a>
                </li>

                
               
                

                <li class="button-container nav-item iframe-extern pad" style="right: 100px;">
                    <a href="login.html" target="_blank" class="btn  btn-rose   btn-round btn-block" >
                        <i class="material-icons">fingerprint</i>  LOGIN
                    </a>
                </li>


            </ul>
        </div>
    </div>
</nav>

<div class="page-header header-filter" id="background" >



    <div class="container">


        <div class="row"  style="margin-top: 200px;">
            <!--<img src="images/sliitlogo.png" style=" ">-->
            <div class="col-lg-5 col-md-6 col-sm-8 ml-auto mr-auto" >
                <form class="form" method="post" action="LoginServlet">
                    <div class="card card-login card-hidden" id="loginDetails">

                        <div class="card-body " >

              <span class="bmd-form-group">
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="material-icons">NIC</i>
                      </span>
                    </div>
                    <input type="text"  name="nic" class="form-control" placeholder="Nic...">
                  </div>
                </span>
                            <span class="bmd-form-group">
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="material-icons">lock_outline</i>
                      </span>
                    </div>
                    <input type="password" name="password" class="form-control" placeholder="Password...">
                  </div>
              </span>
                            <a href="examples/login-page.html" class="btn btn-link btn-primary " target="_blank" id="forgetPassword">Forget Password ?</a>

                        </div>
                        <div class="card-footer justify-content-center">

                            <!--<a href="#pablo" class="btn btn-rose btn-link btn-lg">Lets Go</a>-->
                            <a href="#pablo"  ><button class="btn btn-primary btn-round" style="width: 200px; margin-top: -10px ">Login</button></a>
                        </div>



                    </div>
                </form>
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

<%

if (session.getAttribute("UserNIC")=="Nic is Invalid") {
	
%>
<script>
			$(document).ready(function(){
			swal ( 'You are not' ,  'Registered !' ,  'error' );
			});
</script>
			
	<%
}
	%>
	
<%
if (session.getAttribute("UserPassword")=="Password is Invalid") {
	
%>
<script>
			$(document).ready(function(){
			swal ( 'Password' ,  'is Invalid !' ,  'error' );
			});
</script>
			
	<%
}
	%>	
	
</body>

</html>