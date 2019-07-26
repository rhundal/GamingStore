package com.Playloon.View.Controller;

import com.Playloon.Entities.*;


import com.Playloon.Exceptions.EntityNotFoundException;
import com.Playloon.Services.*;
import com.Playloon.View.util.Message;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;



public class UserServletController extends BaseController{


    private Service<User> uService;
    private Service<Stores> storesService;
    private Service<Sellers> sellersService;
    private Service<Category> categoryService;
    private Service<Product> productService;

    public void init() {

        uService = new UserService();
        storesService = new StoresService();
        sellersService = new SellersService();
        categoryService = new CategoryService();
        productService = new ProductService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String action = extractAction(request);

            switch (action) {

                case "/new":
                    showNewForm(request, response);
                    break;
                case "/prepareLogin":
                    showLoginForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (ServletException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    }

    private String extractAction(HttpServletRequest request) {

        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return "list";
        } else {
            return pathInfo;
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        List<User> listUser = uService.findAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/pages/user/UserList.jsp");  // set UserList Page
        dispatcher.forward(request, response);

        */
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/pages/user/signup.jsp");
        request.setAttribute("types", UserTypes.values());
        request.setAttribute("isNew", true);
        dispatcher.forward(request, response);
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/pages/user/loginForm.jsp");
        request.setAttribute("types", UserTypes.values());
        dispatcher.forward(request, response);
    }

    // Add new user
    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        User user;

        try {
            String id = UUID.randomUUID().toString();
            String fName = request.getParameter("FirstName");
            String lName = request.getParameter("LastName");
            String email = request.getParameter("emailField");
            String password = request.getParameter("password");
            String typeStr = request.getParameter("uType");

            user = new User(id, fName, lName, email, password, UserTypes.valueOf(typeStr));

            uService.add(user);
         //   request.setAttribute("message", Message.buildSuccessMessage("User added successfully"));
         //   listUser(request, response);

            request.setAttribute("nameUser",  email);

            if(typeStr.equals("ADMINISTRATOR"))
            {
                // req.setAttribute("message", Message.buildWarningMessage("ADMINISTRATOR"));

                List<Stores> storesList = storesService.findAll();
                request.setAttribute("storeLst", storesList);

                List<Sellers> sellersList = sellersService.findAll();     // redundant
                request.setAttribute("sellerLst", sellersList);

                List<Category> categoryList = categoryService.findAll();
                request.setAttribute("categoryLst", categoryList);

                List<Product> productList = productService.findAll();
                request.setAttribute("productLst", productList);

              //  request.setAttribute("storeLst", storesList);
               // request.setAttribute("sellerLst", sellersList);
                request.setAttribute("welcomeMssg", "Welcome " + email);


                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/pages/adminHome/admin.jsp");
                dispatcher.forward(request, response);
                //  resp.sendRedirect(req.getContextPath() + "pages/adminHome/admin.jsp");

            }
            else if(typeStr.equals("CUSTOMER"))
            {


                RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/customerHome/customerHome.jsp");
                dispatcher.forward(request, response);

                // req.setAttribute("message", Message.buildWarningMessage("CUSTOMER"));

              //  req.getRequestDispatcher("pages/customerHome/customerHome.jsp");
                ;
                // resp.sendRedirect(req.getContextPath() + "pages/customerHome/customerHome.jsp");
            }

        } catch (Exception e) {
            request.setAttribute("message", processException(e));
            request.setAttribute("types", UserTypes.values());

            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/user/signup.jsp");
            dispatcher.forward(request, response);
            /*
            if(user.getUserType().name() == "ADMINISTRATOR")
            {
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("pages/adminHome/admin.jsp");
                dispatcher.forward(request, response);
            }
            else if(user.getUserType().name() == "CUSTOMER")
            {
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("pages/customerHome/customerHome.jsp");
                dispatcher.forward(request, response);
            }
            */

        }
    }

    // Use these methods later

    // For Later
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            User existingUser = uService.findByID(id);
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/user/UserForm.jsp");
            request.setAttribute("types", UserTypes.values());
            request.setAttribute("user", existingUser);
            request.setAttribute("isEdit", true);
            dispatcher.forward(request, response);
        } catch (EntityNotFoundException e) {
            request.setAttribute("message", e.getMessage());
            listUser(request, response);
        }

    }

    // For Later
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = null;

        try {
            String id = request.getParameter("id");
            String fName = request.getParameter("FirstName");
            String lName = request.getParameter("LastName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            String typeStr = request.getParameter("type");

            user = new User(id, fName, lName, email, password, UserTypes.valueOf(typeStr));


            uService.update(user);
            request.setAttribute("message", Message.buildSuccessMessage("User updated successfully"));
            listUser(request, response);
        } catch (Exception e) {
            request.setAttribute("user", user);
            request.setAttribute("message", processException(e));
            request.setAttribute("isEdit", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/user/UserForm.jsp");
            dispatcher.forward(request, response);
        }
    }


    // For later
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            uService.remove(id);
            request.setAttribute("message", Message.buildSuccessMessage("User deleted successfully"));
        } catch (Exception e) {
            request.setAttribute("message", processException(e));
        }

        listUser(request, response);

    }


}



