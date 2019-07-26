<!DOCTYPE html>
<!-- saved from url=(0051)https://getbootstrap.com/docs/4.0/examples/sign-in/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/favicon.ico">

    <title>Gaming Store - Admin Home</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/login_files/login_files/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/static/css/login_files/login_files/signin.css" rel="stylesheet">

    <!-- Custom Style Sheet -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/storeStyle.css" />

  </head>

  <body class="text-center">

    <header>

         <!-- search and buttons-->

        <table width="100%">
            <tr>
                <td width="10%">
                        <div id="logo"> MyStore </div>
                </td>
                <td width="90%">

                <input type="button" value="Home" data-showdiv="content1" id="transp-btn" onclick="" />

                <input type="text" value="Welcome User" data-showdiv="content7" id="welcome-mssg" onclick="" />

                <input type="button" value="Logout" data-showdiv="content3" id="transp-btn-Logout" onclick="" />

                </td>
            </tr>
        </table>


        <!-- add jquery to slide down header for admin login -->
        <!-- add jquery to slide below for search results -->
    </header>

            <div class="outerContain">

                <div class="myContain">
                    <h3 style="margin-top: -300px; color:black"> Admin Operations  </h3>  <!-- Display Products and Sorting, pagination, image bg effect, rating -->

                          <div class="containerWidth">

                          <!-- Three columns -->
                          <div class="row">
                            <div class="column" onclick="openTab('b1');" style="background: #60a5da;">
                              Add
                            </div>
                            <div class="column" onclick="openTab('b2');" style="background: #5e7385;">
                              Update
                            </div>
                            <div class="column" onclick="openTab('b3');" style="background: #1f2a33;">
                              Delete
                            </div>
                          </div>

                          <!-- Full-width columns: (hidden by default) -->
                          <div id="b1" class="containerTab" style="display:none;background: #60a5da">
                            <span onclick="this.parentElement.style.display='none'" class="closebtn">&times;</span>

                            <table style="width:90%; border: 1px solid white; margin-left: 50px; margin-top: 25px;">
                                    <tr>
                                            <td style="width:30%; border: 1px solid white;">
                                                    <div class="labels">
                                                            <h4> Add Product </h4>
                                                    </div>
                                            </td>

                                            <td style="width:40%; border: 1px solid white;">
                                                    <div class="labels">
                                                            <h4> Stuff here </h4>
                                                    </div>
                                            </td>

                                            <td style="width:20%; border: 1px solid white;">
                                                    <div class="labels">
                                                            <h4> Stuff here </h4>
                                                    </div>
                                            </td>
                                    </tr>

                                    <tr>
                                            <td style="width:30%; border: 1px solid white;">
                                                    <div class="labels">
                                                            <h4> Add Category </h4>
                                                    </div>
                                            </td>
                                    </tr>

                                    <tr>
                                            <td style="width:30%; border: 1px solid white;">
                                                    <div class="labels">
                                                            <h4> Add Store </h4>
                                                    </div>
                                            </td>
                                    </tr>

                                    <tr>
                                            <td style="width:30%; border: 1px solid white;">
                                                    <div class="labels">
                                                            <h4> Add Seller </h4>
                                                        </div>
                                            </td>
                                    </tr>

                                    <tr>
                                            <td style="width:30%; border: 1px solid white;">
                                                    <div class="labels">
                                                            <h4> Add Image </h4>
                                                    </div>
                                            </td>
                                    </tr>
                            </table>

                        </div>

                          <div id="b2" class="containerTab" style="display:none;background: #5e7385">
                            <span onclick="this.parentElement.style.display='none'" class="closebtn">&times;</span>
                            <table style="width:80%; border: 1px solid white; margin-left: 50px; margin-top: 25px;">
                                    <tr>
                                            <td style="width:40%;">
                                                    <div class="labels">
                                                            <h4> Update Products </h4>
                                                    </div>
                                            </td>
                                    </tr>

                                    <tr>
                                            <td style="width:40%;">
                                                    <div class="labels">
                                                            <h4> Update Category </h4>
                                                    </div>
                                            </td>
                                    </tr>

                                    <tr>
                                            <td style="width:40%;">
                                                    <div class="labels">
                                                            <h4> Update Stores </h4>
                                                    </div>
                                            </td>
                                    </tr>

                                    <tr>
                                            <td style="width:40%;">
                                                    <div class="labels">
                                                            <h4> Update Products </h4>
                                                        </div>
                                            </td>
                                    </tr>

                                    <tr>
                                            <td style="width:40%;">
                                                    <div class="labels">
                                                            <h4> Update Image </h4>
                                                    </div>
                                            </td>
                                    </tr>
                            </table>
                        </div>

                          <div id="b3" class="containerTab" style="display:none;background: #1f2a33">
                            <span onclick="this.parentElement.style.display='none'" class="closebtn">&times;</span>

                            <table style="width:80%; border: 1px solid white; margin-left: 50px; margin-top: 25px;">
                                    <tr>
                                            <td style="width:40%;">
                                                    <div class="labels">
                                                            <h4> Delete Products </h4>
                                                    </div>
                                            </td>
                                    </tr>

                                    <tr>
                                            <td style="width:40%;">
                                                    <div class="labels">
                                                            <h4> Delete Category </h4>
                                                    </div>
                                            </td>
                                    </tr>

                                    <tr>
                                            <td style="width:40%;">
                                                    <div class="labels">
                                                            <h4> Delete Stores </h4>
                                                    </div>
                                            </td>
                                    </tr>

                                    <tr>
                                            <td style="width:40%;">
                                                    <div class="labels">
                                                            <h4> Delete Products </h4>
                                                        </div>
                                            </td>
                                    </tr>

                                    <tr>
                                            <td style="width:40%;">
                                                    <div class="labels">
                                                            <h4> Delete Image </h4>
                                                    </div>
                                            </td>
                                    </tr>
                            </table>

                            </div>

                        </div>
                    </div>


                </div>

            </div>

           <footer class="text-muted">
                 <div class="container">
                   <p class="float-right">
                     <a href="#">Back to top</a>
                   </p>
                   <p style="text-align: center; font-weight: bold;"> Webpage Footer </p>
                 </div>
            </footer>

            <!-- JQuery -->

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

            <script type = "text/javascript" language = "javascript">


            /* Search Slider */

            $(document).ready(function(){
    		$(".searchResults").hide();
            });


            $(document).ready(function(){

                    $("#transp-btnSearch").click(function(){

                            if($(".loginScreen").is(':visible'))
                            {
                                    $(".loginScreen").slideToggle("slow");
                            }
                            if($(".signUpScreen").is(':visible'))
                            {
                                    $(".signUpScreen").slideToggle("slow");
                            }
                                    $(".searchResults").slideToggle("slow");
                });

            });

            /* Login Slider */


            $(document).ready(function(){
    				$(".loginScreen").hide();

            });

            $(document).ready(function(){

    		$("#transp-btn-Login").click(function(){

                            if($(".searchResults").is(':visible'))
                            {
                                    $(".searchResults").slideToggle("slow");
                            }
                            if($(".signUpScreen").is(':visible'))
                            {
                                    $(".signUpScreen").slideToggle("slow");
                            }

    				$(".loginScreen").slideDown("slow");

                });

            });


            /* Signup Slider */


            $(document).ready(function(){
    				$(".signUpScreen").hide();
            });

            $(document).ready(function(){

    			$("#transp-btn-Signup").click(function(){

                                    if($(".searchResults").is(':visible'))
                                    {
                                            $(".searchResults").slideToggle("slow");
                                    }
                                    if($(".loginScreen").is(':visible'))
                                    {
                                            $(".loginScreen").slideToggle("slow");
                                    }

    				$(".signUpScreen").slideDown("slow");
                });

            });

            function openTab(tabName) {
            var i, x;
            x = document.getElementsByClassName("containerTab");
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            document.getElementById(tabName).style.display = "block";
            }

            </script>


</body>
</html>