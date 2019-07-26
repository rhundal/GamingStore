package com.Playloon.View.Controller;


import com.Playloon.Entities.*;
import com.Playloon.Services.*;
import com.Playloon.View.util.Message;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginServletController extends BaseController{

    private UserService userService;
    private StoresService storesService;
    private SellersService sellersService;
    private CategoryService categoryService;
    private ProductService productService;

    private AuthenticationService authenticationService;

    public void init(){
        userService = new UserService();
        authenticationService = new AuthenticationService();
        storesService = new StoresService();
        sellersService = new SellersService();
        categoryService = new CategoryService();
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("userEmail");
        String password = req.getParameter("userPassword");
        String typeStr = req.getParameter("uType");

        //&& typeStr == user.getUsrType()

        try {

            User user = userService.findByEmail(email);


            List<Stores> storesList = storesService.findAll();
            List<Sellers> sellersList = sellersService.findAll();
            List<Category> categoryList = categoryService.findAll();
            List<Product> productList = productService.findAll();

            if (authenticationService.verifyUserPassword(password, user.getPassword()) ) {


                HttpSession session = req.getSession();
                session.setAttribute("loggedUser", user);
                session.setAttribute("nameUser", user.getEmail());
                session.setAttribute("typeUser", typeStr);

                for (Stores str : storesList) {

                    session.setAttribute("storeLst", str.getStoreName());

                }

                for (Sellers slr : sellersList) {

                    session.setAttribute("sellerLst", slr.getSellerName());

                }

                for (Category cat : categoryList) {

                     session.setAttribute("categoryLst", cat.getCategoryName());

                }

                for (Product prod : productList) {

                    session.setAttribute("productLst", prod.getProductID());

                }


                //     RequestDispatcher dispatcher = req.getRequestDispatcher("pages/adminHome/admin.jsp");
           //     dispatcher.forward(req, resp);

                // resp.sendRedirect(req.getContextPath() + "pages/adminHome/admin.jsp");



                if(typeStr.equals("ADMINISTRATOR"))
                {
                   // req.setAttribute("message", Message.buildWarningMessage("ADMINISTRATOR"));
                    req.setAttribute("storeLst", storesList);
                    req.setAttribute("sellerLst", sellersList);
                    req.setAttribute("categoryLst", categoryList);
                    req.setAttribute("productLst", productList);

                    req.setAttribute("welcomeMssg", "Welcome " + email);


                    RequestDispatcher dispatcher = req.getRequestDispatcher("pages/adminHome/admin.jsp");
                    dispatcher.forward(req, resp);
                    //  resp.sendRedirect(req.getContextPath() + "pages/adminHome/admin.jsp");

                }
                else if(typeStr.equals("CUSTOMER"))
                {
                    RequestDispatcher dispatcher = req.getRequestDispatcher("pages/customerHome/customerHome.jsp");
                    dispatcher.forward(req, resp);

                   // req.setAttribute("message", Message.buildWarningMessage("CUSTOMER"));

                    req.getRequestDispatcher("pages/customerHome/customerHome.jsp");
                     // resp.sendRedirect(req.getContextPath() + "pages/customerHome/customerHome.jsp");
                }


            } else {
                req.setAttribute("message", Message.buildWarningMessage("The email or password are not correct!"));
                req.setAttribute("types", UserTypes.values());

                //  RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/user/loginForm.jsp");
              //  dispatcher.forward(req, resp);

            }
        }catch (Exception e){
            req.setAttribute("message", processException(e));
            req.setAttribute("types", UserTypes.values());
         //   RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/user/loginForm.jsp");
         //   dispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
