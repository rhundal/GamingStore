<Doctype! html>
<!-- saved from url=(0051)https://getbootstrap.com/docs/4.0/examples/sign-in/ -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title> PlayLoon - A Gaming Store </title>
        <meta charset="utf-8">
        <meta name="description" content="A Gaming Store Website" />
        <meta name="author" content="Rajdeep Hundal" />
        <meta name="viewport" content="width=deivce-width, initial-scale=1.0">


    <!-- Custom Style Sheet -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/storeStyle.css" />


    </head>
    <body>
        <header>
            <!-- search and buttons-->

            <table width="100%">
                <tr>
                    <td width="10%">
                            <div id="logo"> MyStore </div>
                    </td>
                    <td width="90%">
        
                
                            <a href="${pageContext.request.contextPath}/adminHome/login" value="button" value="Home" data-showdiv="content1" id="transp-btn"> Home </a>

                             <input type="label" name="welcomeMssg" value='Welcome ${nameUser}' data-showdiv="content7" id="welcome-mssg" />

                             <a href="${pageContext.request.contextPath}/logout" value="Logout" data-showdiv="content3" id="transp-btn-Logout">Logout</a>


                    </td>
                </tr>
            </table>  

        </header>


        <div class="outerContain">
            
            <div class="myContain">
                <h3 style="margin-top: -300px; color:black"> Admin Operations  </h3>  <!-- Display Products and Sorting, pagination, image bg effect, rating -->

                      <div class="containerWidth">

                      <!-- Three columns -->
                      <div class="row">
                        <div class="column" onclick="openTab('b1');" style="background: #FCBB60;">
                          Category
                        </div>
                        <div class="column" onclick="openTab('b2');" style="background: #D8737F;">
                          Product
                        </div>
                        <div class="column" onclick="openTab('b3');" style="background: #1f2a33;">
                          Seller
                        </div>
                         <div class="column" onclick="openTab('b4');" style="background: #685D79;">
                          Store
                        </div>
                      </div>
                      
                      <!-- Full-width columns: (hidden by default) -->
                      <div id="b1" class="containerTab" style="display:none;background: #FCBB60">
                        <span onclick="this.parentElement.style.display='none'" class="closebtn">&times;</span>

                        <div id="displayTables">

                                <div id="London" class="tabcontent">

                                     <form action="${pageContext.request.contextPath}/adminHome/insertCategory" method="post" role="form">

                                        <table style="width:80%; border: 1px solid white; margin-left: 50px; margin-top: 10px;">
                                                <tr>
                                                        <td style="width:30%; border: 1px solid white;">
                                                                <div class="labels"> 
                                                                        <h4 style="text-align: center;"> Add Category </h4>
                                                                </div>
                                                        </td>
                
                                                        <td style="width:40%; border: 1px solid white;">
                                                                <div class="labels" style="margin-left: 60px;"> 
                                                                        <input name="userInputCatN" type="text" style="width: 175px;" onfocus="this.value=''" value="Enter Category">

                                                                </div>
                                                        </td>
                
                                                        <td style="width:30%; border: 1px solid white;">
                                                                <div class="labels" style="margin-left: 50px;"> 
                                                                        <button class="btn warning" style="width: 100px;">Add </button>

                                                                </div>
                                                        </td>
                
                                                </tr>
                
                                        </table>
                                        </form>

                                </div>
                                
                                <div id="Paris" class="tabcontent">
                             
                                        <table style="width:80%; border: 1px solid white; margin-left: 50px; margin-top: 10px;">
                                               
        
                                                <tr>
                                                        <td style="width:30%; border: 1px solid white;">
                                                                <div class="labels"> 
                                                                        <h4 style="text-align: center;"> Update Category </h4>
                                                                </div>
                                                        </td>
                
                                                        <td style="width:40%; border: 1px solid white;">
                                                                <div class="labels" style="margin-left: 60px;"> 
                                                                        <input type="text" style="width: 175px;" onfocus="this.value=''" value="update Category">

                                                                </div>
                                                        </td>
                
                                                        <td style="width:30%; border: 1px solid white;">
                                                                <div class="labels" style="margin-left: 50px;"> 
                                                                        <button class="btn warning" style="width: 100px;">Update </button>

                                                                </div>
                                                        </td>
                                                </tr>
                                        </table>   

                                </div>
                                
                                <div id="Tokyo" class="tabcontent">

                                  <form action="${pageContext.request.contextPath}/adminHome/deleteCategory" method="post" role="form">


                                        <table style="width:80%; border: 1px solid white; margin-left: 50px; margin-top: 10px;">
                                              
                
                                                <tr>
                                                        <td style="width:30%; border: 1px solid white;">
                                                                <div class="labels"> 
                                                                        <h4 style="text-align: center;"> Delete Category </h4>
                                                                </div>
                                                        </td>
                
                                                        <td style="width:40%; border: 1px solid white;">
                                                               <div class="labels" style="margin-left: 30px;">

                                                                    <select name="categoryDel" class="form-control" style="height: 30px; width: 170px;">

                                                                         <c:forEach items="${categoryLst}" var="categoryDel">
                                                                             <option value="${categoryDel.categoryName}">${categoryDel.categoryName}</option>
                                                                         </c:forEach>

                                                                      </select>

                                                                </div>
                                                        </td>
                
                                                        <td style="width:30%; border: 1px solid white;">
                                                                <div class="labels" style="margin-left: 50px;"> 
                                                                        <button class="btn warning" style="width: 100px;">Delete </button>

                                                                </div>
                                                        </td>
                                                </tr>
                
                                        </table>

                                       </form>


                                </div>
        
                                <button class="tablink" onclick="openCity('London', this, '#547980')" id="defaultOpen">Add</button>
                                <button class="tablink" onclick="openCity('Paris', this, '#2D7A9C')">Update</button>
                                <button class="tablink" onclick="openCity('Tokyo', this, '#305F72')">Delete</button>

                                        
                        </div> 
               

                    </div><!-- end of b1 -->

                      <div id="b2" class="containerTab" style="display:none;background: #D8737F">
                        <span onclick="this.parentElement.style.display='none'" class="closebtn">&times;</span>
                       
                        <div id="displayTables">

                                <div id="London2" class="tabcontent">

                                  <form action="${pageContext.request.contextPath}/adminHome/insertProduct" method="post" role="form">

                                        <table style="width:100%; border: 1px solid white; margin-left: 5px; margin-top: -20px;">
                                                <tr>
                                                        <td style="width:20%; border: 1px solid white;">
                                                                <div class="labels"> 
                                                                        <h4 style="text-align: center;"> Enter Product Title </h4>
                                                                </div>
                                                        </td>

                                                         <td style="width:30%; border: 1px solid white;">

                                                            <div class="labels" style="margin-left: 30px;">
                                                                    <input type="text" name="userInputTitle" style="width: 175px;" onfocus="this.value=''" value="Enter Product Title" required>

                                                            </div>
                                                        </td>

                                                          <td style="width:20%; border: 1px solid white;">
                                                                   <div class="labels">
                                                                           <h4 style="text-align: center;"> Upload Image </h4>
                                                                   </div>
                                                           </td>

                                                           <td style="width:30%; border: 1px solid white;">
                                                                   <div class="labels">

                                                                           <input type="textarea" name="userInputFileImage" style="margin-left: 30px; width: 175px; height: 40px;" onfocus="this.value=''" value="Image URL" required>

                                                                    </div>
                                                           </td>

                                                 </tr>

                                                 <tr>

                                                        <td style="width:20%; border: 1px solid white;">
                                                                <div class="labels">
                                                                        <h4 style="text-align: center;"> Set Price </h4>
                                                                </div>
                                                        </td>

                                                         <td style="width:30%; border: 1px solid white;">
                                                              <div class="labels" style="margin-left: 30px;">
                                                                     <input type="number" step="0.01" name="userInputPrice" style="width: 175px;" onfocus="this.value=''" value="Enter Price" required>

                                                             </div>
                                                        </td>

                                                        <td style="width:20%; border: 1px solid white;">
                                                               <div class="labels">
                                                                       <h4 style="text-align: center;"> Set Sellers </h4>
                                                               </div>
                                                       </td>

                                                        <td style="width:30%; border: 1px solid white;">
                                                                <div class="labels">

                                                                        <h4>  </h4>
                                                                </div>
                                                        </td>


                                                 </tr>

                                                  <tr>

                                                         <td style="width:20%; border: 1px solid white;">
                                                                 <div class="labels">
                                                                         <h4 style="text-align: center;"> Set Description </h4>
                                                                 </div>
                                                         </td>

                                                          <td style="width:30%; border: 1px solid white;">
                                                               <div class="labels" style="margin-left: 30px;">
                                                                      <input type="textarea" name="userInputDescription" style="width: 175px; height: 40px;" onfocus="this.value=''" value="Product Description" required>

                                                              </div>
                                                         </td>

                                                         <td style="width:20%; border: 1px solid white;">
                                                                 <div class="labels">
                                                                 </div>
                                                         </td>

                                                          <td style="width:30%; border: 1px solid white;">
                                                                 <div class="labels" style="margin-left: 30px;">
                                                                      <button class="btn warning" style="width: 100px;">Add </button>

                                                                 </div>
                                                         </td>


                                                  </tr>

                                                  <tr>

                                                           <td style="width:20%; border: 1px solid white;">
                                                                   <div class="labels">
                                                                           <h4 style="text-align: center;"> Select Category </h4>
                                                                   </div>
                                                           </td>

                                                            <td style="width:30%; border: 1px solid white;">
                                                                   <div class="labels">

                                                                           <select name="categoryPP" class="form-control" style="height: 30px; width: 170px; margin-left: 30px;">

                                                                                <c:forEach items="${categoryLst}" var="categoryPP">
                                                                                    <option value="${categoryPP.categoryName}">${categoryPP.categoryName}</option>
                                                                                </c:forEach>

                                                                            </select>
                                                                   </div>
                                                           </td>

                                                    </tr>
                                        </table>   

                                </form>
                                </div>
                                
                                <div id="Paris2" class="tabcontent">
                             
                                        <table style="width:80%; border: 1px solid white; margin-left: 50px; margin-top: 10px;">
                                               
        
                                                <tr>
                                                        <td style="width:30%; border: 1px solid white;">
                                                                <div class="labels"> 
                                                                        <h4 style="text-align: center;"> Update Category </h4>
                                                                </div>
                                                        </td>
                
                                                        <td style="width:40%; border: 1px solid white;">
                                                                <div class="labels"> 
                                                                        <h4>  </h4>
                                                                </div>
                                                        </td>
                
                                                        <td style="width:30%; border: 1px solid white;">
                                                                <div class="labels"> 
                                                                       <p style="text-align: center;"> Button here </p>
                                                                </div>
                                                        </td>
                                                </tr>
                                        </table>   

                                </div>
                                
                                <div id="Tokyo2" class="tabcontent">

                                  <form action="${pageContext.request.contextPath}/adminHome/deleteProduct" method="post" role="form">


                                        <table style="width:80%; border: 1px solid white; margin-left: 50px; margin-top: 10px;">
                                              
                
                                                <tr>
                                                        <td style="width:30%; border: 1px solid white;">
                                                                <div class="labels"> 
                                                                        <h4 style="text-align: center;"> Delete Category </h4>
                                                                </div>
                                                        </td>
                
                                                        <td style="width:40%; border: 1px solid white;">
                                                                <div class="labels"> 
                                                                         <select name="productDel" class="form-control" style="height: 30px; width: 170px; margin-left: 30px;">

                                                                            <c:forEach items="${productLst}" var="productDel">
                                                                                <option value="${productDel.title}">${productDel.title}</option>
                                                                            </c:forEach>

                                                                        </select>
                                                                </div>
                                                        </td>
                
                                                        <td style="width:30%; border: 1px solid white;">
                                                                 <div class="labels" style="margin-left: 30px;">
                                                                      <button class="btn warning" style="width: 100px;">Delete </button>

                                                                 </div>
                                                        </td>
                                                </tr>
                
                                        </table>   

                                </form>
                                </div>
        
                                <button class="tablink" onclick="openCity('London2', this, '#547980')" id="defaultOpen">Add</button>
                                <button class="tablink" onclick="openCity('Paris2', this, '#2D7A9C')">Update</button>
                                <button class="tablink" onclick="openCity('Tokyo2', this, '#305F72')">Delete</button>


                        </div>
                    
                    </div> <!-- end of b2 -->
                      
                      <div id="b3" class="containerTab" style="display:none;background: #1f2a33">
                         <span onclick="this.parentElement.style.display='none'" class="closebtn">&times;</span>

                         <div id="displayTables">


                                 <div id="London3" class="tabcontent">


                                         <table style="width:100%; border: 1px solid white; margin-left: 5px; margin-top: 10px;">
                                               <form action="${pageContext.request.contextPath}/adminHome/insertSeller" method="post" role="form">

                                                 <tr>
                                                         <td style="width:20%; border: 1px solid white;">
                                                                 <div class="labels">
                                                                         <h4 style="text-align: center;"> Add Sellers </h4>
                                                                 </div>
                                                         </td>

                                                         <td style="width:30%; border: 1px solid white;">
                                                                 <div class="labels" style="margin-left: 30px;">
                                                                         <input type="text" name="userInputSellerN" style="width: 175px;" onfocus="this.value=''" value="Enter Seller Name" required>

                                                                 </div>
                                                         </td>

                                                         <td style="width:30%; border: 1px solid white;">
                                                                 <div class="labels" style="margin-left: 30px;">

                                                                         <select name="sellerDD" class="form-control" style="height: 30px; width: 170px;">

                                                                              <c:forEach items="${storeLst}" var="sellerDD">
                                                                                  <option value="${sellerDD.storeName}">${sellerDD.storeName}</option>
                                                                              </c:forEach>

                                                                          </select>

                                                                 </div>
                                                         </td>

                                                         <td style="width:20%; border: 1px solid white;">
                                                                 <div class="labels" style="margin-left: 30px;">
                                                                         <button class="btn warning" style="width: 100px;">Add </button>

                                                                 </div>
                                                         </td>


                                                 </tr>

                                                 </form>

                                                 <form action="${pageContext.request.contextPath}/adminHome/insertProdToSeller" method="post" role="form">


                                                  <tr>
                                                      <td style="width:20%; border: 1px solid white;">
                                                              <div class="labels">
                                                                      <h4 style="text-align: center;"> Add P To S </h4>
                                                              </div>
                                                      </td>

                                                      <td style="width:30%; border: 1px solid white;">
                                                              <div class="labels" style="margin-left: 30px;">

                                                                  <select name="sellerDA" class="form-control" style="height: 30px; width: 170px;">

                                                                       <c:forEach items="${sellerLst}" var="sellerDA">
                                                                           <option value="${sellerDA.sellerName}">${sellerDA.sellerName}</option>
                                                                       </c:forEach>

                                                                   </select>

                                                              </div>
                                                      </td>

                                                      <td style="width:30%; border: 1px solid white;">

                                                            <div class="labels" style="margin-left: 30px;">

                                                                 <select name="productAd" class="form-control" style="height: 30px; width: 170px;">

                                                                    <c:forEach items="${productLst}" var="productAd">
                                                                        <option value="${productAd.title}">${productAd.title}</option>
                                                                    </c:forEach>

                                                                </select>
                                                        </div>
                                                      </td>

                                                      <td style="width:20%; border: 1px solid white;">
                                                              <div class="labels" style="margin-left: 30px;">
                                                                      <button class="btn warning" style="width: 100px;">Add </button>

                                                              </div>
                                                      </td>


                                              </tr>

                                              </form>

                                         </table>
                                       </form>


                                 </div>

                                 <div id="Paris3" class="tabcontent">

                                         <table style="width:80%; border: 1px solid white; margin-left: 50px; margin-top: 10px;">


                                                 <tr>
                                                         <td style="width:30%; border: 1px solid white;">
                                                                 <div class="labels">
                                                                         <h4 style="text-align: center;"> Update Sellers </h4>
                                                                 </div>
                                                         </td>

                                                         <td style="width:40%; border: 1px solid white;">
                                                                 <div class="labels">
                                                                         <h4>  </h4>
                                                                 </div>
                                                         </td>

                                                         <td style="width:30%; border: 1px solid white;">
                                                                 <div class="labels" style="margin-left: 50px;">
                                                                         <button class="btn warning" style="width: 100px;">Update </button>

                                                                 </div>
                                                         </td>
                                                 </tr>
                                         </table>

                                 </div>

                                 <div id="Tokyo3" class="tabcontent">

                                     <form action="${pageContext.request.contextPath}/adminHome/deleteSeller" method="post" role="form">

                                         <table style="width:80%; border: 1px solid white; margin-left: 50px; margin-top: 10px;">


                                                 <tr>
                                                         <td style="width:30%; border: 1px solid white;">
                                                                 <div class="labels">
                                                                         <h4 style="text-align: center;"> Delete Sellers </h4>
                                                                 </div>
                                                         </td>

                                                         <td style="width:40%; border: 1px solid white;">
                                                                  <div class="labels" style="margin-left: 30px;">

                                                                      <select name="sellerDL" class="form-control" style="height: 30px; width: 170px;">

                                                                           <c:forEach items="${sellerLst}" var="sellerDL">
                                                                               <option value="${sellerDL.sellerName}">${sellerDL.sellerName}</option>
                                                                           </c:forEach>

                                                                       </select>

                                                                  </div>
                                                         </td>

                                                         <td style="width:30%; border: 1px solid white;">
                                                                 <div class="labels" style="margin-left: 50px;">
                                                                         <button class="btn warning" style="width: 100px;">Delete </button>

                                                                 </div>
                                                         </td>
                                                 </tr>

                                         </table>
                                       </form>


                                 </div>

                                 <button class="tablink" onclick="openCity('London3', this, '#547980')" id="defaultOpen">Add</button>
                                 <button class="tablink" onclick="openCity('Paris3', this, '#2D7A9C')">Update</button>
                                 <button class="tablink" onclick="openCity('Tokyo3', this, '#305F72')">Delete</button>


                         </div>
                         </div><!-- end of b3 -->

                        <div id="b4" class="containerTab" style="display:none;background: #685D79">
                                <span onclick="this.parentElement.style.display='none'" class="closebtn">&times;</span> 
                        
                              
                                <div id="displayTables">

                                        <div id="London4" class="tabcontent">

                                            <form action="${pageContext.request.contextPath}/adminHome/insertStore" method="post" role="form">

                                                <table style="width:80%; border: 1px solid white; margin-left: 50px; margin-top: 10px;">
                                                        <tr>
                                                                <td style="width:30%; border: 1px solid white;">
                                                                        <div class="labels"> 
                                                                                <h4 style="text-align: center;"> Add Store Name </h4>
                                                                        </div>
                                                                </td>
                        
                                                                <td style="width:40%; border: 1px solid white;">
                                                                        <div class="labels" style="margin-left: 60px;"> 
                                                                                <input type="text" name="userInputSN" style="width: 175px;" onfocus="this.value=''" value="Enter Store Name" required>
        
                                                                        </div>
                                                                </td>
                        
                                                                <td style="width:30%; border: 1px solid white;">
                                                                        <div class="labels" style="margin-left: 50px;"> 
                                                                                <button class="btn warning" style="width: 100px;">Add </button>
        
                                                                        </div>
                                                                </td>
                        
                                                               
                                                        </tr>
                        
                                                </table>

                                                 <c:if test="${message != null}">
                                                  <div class="alert <c:out value='${message.type.reference}' />">
                                                    <strong><c:out value='${message.text}' /></strong>
                                                  </div>
                                                  <center>
                                                      <div>
                                                          <span></span>
                                                      <div>
                                                  </center>
                                                </c:if>

                                              </form>
        
        
                                        </div>
                                        
                                        <div id="Paris4" class="tabcontent">
                                     
                                                <table style="width:80%; border: 1px solid white; margin-left: 50px; margin-top: 10px;">
                                                       
                
                                                        <tr>
                                                                <td style="width:30%; border: 1px solid white;">
                                                                        <div class="labels"> 
                                                                                <h4 style="text-align: center;"> Update Store </h4>
                                                                        </div>
                                                                </td>
                        
                                                                <td style="width:40%; border: 1px solid white;">
                                                                        <div class="labels"> 
                                                                                <h4>  </h4>
                                                                        </div>
                                                                </td>
                        
                                                                <td style="width:30%; border: 1px solid white;">
                                                                        <div class="labels" style="margin-left: 50px;">
                                                                             <button class="btn warning" style="width: 100px;"> Update </button>
                                                                       </div>
                                                                </td>
                                                        </tr>
                                                </table>   
        
                                        </div>
                                        
                                        <div id="Tokyo4" class="tabcontent">

                                             <form action="${pageContext.request.contextPath}/adminHome/deleteStore" method="post" role="form">

                                                <table style="width:80%; border: 1px solid white; margin-left: 50px; margin-top: 10px;">
                                                      
                        
                                                        <tr>
                                                                <td style="width:30%; border: 1px solid white;">
                                                                        <div class="labels"> 
                                                                                <h4 style="text-align: center;">  Select Store To Delete </h4>
                                                                        </div>
                                                                </td>
                        
                                                                <td style="width:40%; border: 1px solid white;">

                                                                        <div class="labels" style="margin-left: 50px;">
                                                                                  <select name="storeDD" class="form-control" style="height: 30px; width: 170px;">
                                                                                     <c:forEach items="${storeLst}" var="storeDD">
                                                                                         <option value="${storeDD.storeName}">${storeDD.storeName}</option>
                                                                                     </c:forEach>
                                                                                 </select>
                                                                        </div>

                                                                </td>
                        
                                                                <td style="width:30%; border: 1px solid white;">

                                                                     <div class="labels" style="margin-left: 50px;">
                                                                            <button class="btn warning" style="width: 100px;"> Delete </button>

                                                                    </div>

                                                                </td>
                                                        </tr>
                        
                                                </table>

                                              </form>
        
        
                                        </div>
                
                                        <button class="tablink" onclick="openCity('London4', this, '#547980')" id="defaultOpen">Add</button>
                                        <button class="tablink" onclick="openCity('Paris4', this, '#2D7A9C')">Update</button>
                                        <button class="tablink" onclick="openCity('Tokyo4', this, '#305F72')">Delete</button>


                                </div>

                        </div> <!-- end of b4 -->


                    </div>
                </div>  
                
        

        <footer>
            <p> &copy; 2019 - Rajdeep Hundal</p>
        </footer>

        <!-- JQuery -->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

        <script type = "text/javascript" language = "javascript">

         $(function () {
             $('.list-group.checked-list-box .list-group-item').each(function () {

                 // Settings
                 var $widget = $(this),
                     $checkbox = $('<input type="checkbox" class="hidden" />'),
                     color = ($widget.data('color') ? $widget.data('color') : "primary"),
                     style = ($widget.data('style') == "button" ? "btn-" : "list-group-item-"),
                     settings = {
                         on: {
                             icon: 'glyphicon glyphicon-check'
                         },
                         off: {
                             icon: 'glyphicon glyphicon-unchecked'
                         }
                     };

                 $widget.css('cursor', 'pointer')
                 $widget.append($checkbox);

                 // Event Handlers
                 $widget.on('click', function () {
                     $checkbox.prop('checked', !$checkbox.is(':checked'));
                     $checkbox.triggerHandler('change');
                     updateDisplay();
                 });
                 $checkbox.on('change', function () {
                     updateDisplay();
                 });


                 // Actions
                 function updateDisplay() {
                     var isChecked = $checkbox.is(':checked');

                     // Set the button's state
                     $widget.data('state', (isChecked) ? "on" : "off");

                     // Set the button's icon
                     $widget.find('.state-icon')
                         .removeClass()
                         .addClass('state-icon ' + settings[$widget.data('state')].icon);

                     // Update the button's color
                     if (isChecked) {
                         $widget.addClass(style + color + ' active');
                     } else {
                         $widget.removeClass(style + color + ' active');
                     }
                 }

                 // Initialization
                 function init() {

                     if ($widget.data('checked') == true) {
                         $checkbox.prop('checked', !$checkbox.is(':checked'));
                     }

                     updateDisplay();

                     // Inject the icon if applicable
                     if ($widget.find('.state-icon').length == 0) {
                         $widget.prepend('<span class="state-icon ' + settings[$widget.data('state')].icon + '"></span>');
                     }
                 }
                 init();
             });

             $('#get-checked-data').on('click', function(event) {
                 event.preventDefault();
                 var checkedItems = {}, counter = 0;
                 $("#check-list-box li.active").each(function(idx, li) {
                     checkedItems[counter] = $(li).text();
                     counter++;
                 });
                 $('#display-json').html(JSON.stringify(checkedItems, null, '\t'));
             });
         });

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
                


        function openCity(cityName,elmnt,color) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablink");
        for (i = 0; i < tablinks.length; i++) {
        tablinks[i].style.backgroundColor = "";
        }
        document.getElementById(cityName).style.display = "block";
        elmnt.style.backgroundColor = color;

        }
        // Get the element with id="defaultOpen" and click on it
        document.getElementById("defaultOpen").click();

        </script>

               
    </body>
</html>