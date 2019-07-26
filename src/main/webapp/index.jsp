<%@ page contentType="text/html; charset=iso-8859-1" language="java" %>
<!DOCTYPE html>

<!-- saved from url=(0050)https://getbootstrap.com/docs/4.0/examples/album/# -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html lang="en">

<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/favicon.ico">

    <title> GameLoon Store</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/album/">

    <!-- Bootstrap core CSS -->
    <link href="static/css/test_files/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="static/css/test_files/album.css" rel="stylesheet">
    <link href="static/css/myStyle.css" rel="stylesheet">
  </head>

  <body style="background-color: #8474A1;">

    <header>
      <div class="bg-dark collapse" id="navbarHeader">
        <div class="container">
          <div class="row">
            <div class="col-sm-8 col-md-7 py-4">
              <h4 class="text-white">About</h4>
              <p class="text-muted"> Gaming Store has all the new games available online. </p>
            </div>
            <div class="col-sm-4 offset-md-1 py-4">
              <h4 class="text-white">Contact</h4>
              <ul class="list-unstyled">
                <li><a href="https://getbootstrap.com/docs/4.0/examples/album/#" class="text-white">Follow on Twitter</a></li>
                <li><a href="https://getbootstrap.com/docs/4.0/examples/album/#" class="text-white">Like on Facebook</a></li>
                <li><a href="https://getbootstrap.com/docs/4.0/examples/album/#" class="text-white">Email me</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <a href="#" class="navbar-brand d-flex align-items-center">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mr-2"><path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path><circle cx="12" cy="13" r="4"></circle></svg>
            <strong> PlayLoon</strong>
          </a>

          <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
      </div>
    </header>

    <main role="main">

      <div class="topContainer">
          

        <table style="margin-left: 70px;">
          <tr>
            <td style="width: 35%;">
                <div id="containerStyle1">

                    <a class="nav-link dropdown-toggle ddstyle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Categories</a>
                      <div class="dropdown-menu" aria-labelledby="dropdown01">
                        <a class="dropdown-item" href="#">Nintendo</a>
                        <a class="dropdown-item" href="#">PlayStation</a>
                        <a class="dropdown-item" href="#">Xbox</a>
                        <a class="dropdown-item" href="#">Accessories</a>
                        <a class="dropdown-item" href="#">Wii</a>
                        <a class="dropdown-item" href="#">Pc</a>
                        <a class="dropdown-item" href="#">Mac</a>

                      </div>
                    </div>


            </td>
            <td style="width: 65%;">
                <div id="containerStyle2">

                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Search">
                    <div class="input-group-append">
                      <button class="btn btn-success" type="submit">Go</button> 
                    </div>
                  </div>
                  </div>
            </td>
          </tr>
       
            </table>
      </div>

      <section class="jumbotron text-center" style="background-color: #8474A1;">
        <div class="container">
          <h1 class="jumbotron-heading"> Latest Games </h1>
          <p class="lead"> New games in our store. We add new products everyday.</p>
          <p>
            <a href="${pageContext.request.contextPath}/user/prepareLogin" class="btn btn-primary my-2"> Login </a>
            <a href="${pageContext.request.contextPath}/user/new" class="btn btn-danger my-2"> Sign Up</a>
          </p>
        </div>
      </section>

      <div class="album py-5" style="background-color: #FFC98B;">
        <div class="container">
          <% for(int j = 0; j < 3; j++) { %>
           <div class="row">

                    <% for(int i = 0; i < 3; i++) { %>
                       <div class="col-md-4">
                         <div class="card mb-4 box-shadow">
                           <img class="card-img-top" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="${pageContext.request.contextPath}/indexPage/${product.getImage()}}" data-holder-rendered="true">
                           <div class="card-body">
                             <p class="card-text"> <a href="${pageContext.request.contextPath}/${productDescription}}"> </a> </p>
                             <div class="d-flex justify-content-between align-items-center">
                               <div class="btn-group">
                                 <button type="button" class="btn btn-sm btn-outline-secondary"> <a href="productDetail.html"> View </a></button>
                               </div>
                               <small class="text-muted"> 5 Stars</small>
                             </div>
                           </div>
                         </div>
                       </div>
                  <% } %>
            </div>
           <% } %>
      </div>
      </div>

    </main>

    <footer>
      <div class="container">
        <p class="float-right">
          <a href="#">Back to top</a>
        </p>
        <p style="text-align: center; font-weight: bold;"> Webpage Footer </p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="static/css/test_files/jquery-3.2.1.slim.min.js.download" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="static/css/test_files/popper.min.js.download"></script>
    <script src="static/css/test_files/bootstrap.min.js.download"></script>
    <script src="static/css/test_files/holder.min.js.download"></script>
  

<svg xmlns="http://www.w3.org/2000/svg" width="348" height="226" viewBox="0 0 348 226" preserveAspectRatio="none" style="display: none; visibility: hidden; position: absolute; top: -100%; left: -100%;"><defs><style type="text/css"></style></defs><text x="0" y="17" style="font-weight:bold;font-size:17pt;font-family:Arial, Helvetica, Open Sans, sans-serif">Thumbnail</text></svg></body></html>