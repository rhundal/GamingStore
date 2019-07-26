/*
package com.Playloon.View.Controller;

import com.Playloon.Entities.Sellers;
import com.Playloon.Services.SellersService;

import com.Playloon.Exceptions.EntityNotFoundException;
import com.Playloon.Services.UserService;
import com.Playloon.Services.Service;
import com.Playloon.View.util.Message;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class SellerServletController extends BaseController {


    private Service<Sellers> sellersService;

    public void init() {

        sellersService = new SellersService();
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
                case "/insert":
                    insertSeller(request, response);
                    break;
                case "/delete":
                    deleteSeller(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateSeller(request, response);
                    break;
                default:
                    listSeller(request, response);
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

    private void listSeller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sellers> sellersList = sellersService.findAll();
        request.setAttribute("sellersList", sellersList);
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/pages/adminHome/admin.jsp");  // set sellersList Page
        dispatcher.forward(request, response);                     // Ask what page to call
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)    // ask about this
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/pages/adminHome/admin.jsp");
        request.setAttribute("isNew", true);
        dispatcher.forward(request, response);
    }

    // Add new user
    private void insertSeller(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Sellers seller;  // call the constructor below (only for Test)

     /*  String productID, String itemID, double price, String description, String productName,
                String ImageURL, String category)  */ // Ask about whether to pass itemId or not
/*
        try {


            String id = UUID.randomUUID().toString();
            String storeID = request.getParameter("StoreID");   // how to get this id
            String fullName = request.getParameter("FullName");     // Not sure about this

            seller = new Sellers(id, storeID, fullName);

            sellersService.add(seller);
            //   request.setAttribute("message", Message.buildSuccessMessage("User added successfully"));
            //   listUser(request, response);
        } catch (Exception e) {
            //  request.setAttribute("user", user);
            //   request.setAttribute("message", processException(e));
            //    request.setAttribute("isNew", true);

            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");   // ask about what page to call
            dispatcher.forward(request, response);

        }
    }

    // How to call update form
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            Sellers existingSeller = sellersService.findByID(id);
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");
            request.setAttribute("seller", existingSeller);
            request.setAttribute("isEdit", true);
            dispatcher.forward(request, response);
        } catch (EntityNotFoundException e) {
            request.setAttribute("message", e.getMessage());
            listSeller(request, response);
        }

    }

    // For Later
    private void updateSeller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Sellers product = new Sellers();  // call other constructor below

        try {
            String id = UUID.randomUUID().toString();
            String description = request.getParameter("Description");
            String itemId = request.getParameter("ItemId");     // Not sure about this
            //   double price = request.getParameter("Price");
            String productName = request.getParameter("ProductName");
            String imgURL = request.getParameter("ImageURL");
            String category = request.getParameter("CategoryName");

            //    product = new Product(id, itemId, price, description, productName, imgURL, category);


            productService.update(product);
            request.setAttribute("message", Message.buildSuccessMessage("Product updated successfully"));
            listProduct(request, response);
        } catch (Exception e) {
            request.setAttribute("product", product);
            request.setAttribute("message", processException(e));
            request.setAttribute("isEdit", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/adminHome/admin.jsp");
            dispatcher.forward(request, response);
        }
    }


    // For later
    private void deleteSeller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            productService.remove(id);
            request.setAttribute("message", Message.buildSuccessMessage("Product deleted successfully"));
        } catch (Exception e) {
            request.setAttribute("message", processException(e));
        }

        listProduct(request, response);

    }




}

*/