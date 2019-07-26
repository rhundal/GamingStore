
package com.Playloon.View.Controller;

import com.Playloon.Entities.Stores;
import com.Playloon.Services.StoresService;

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

/** Not being used **/

public class StoresServletController extends BaseController{



    private Service<Stores> storesService;

    public void init() {

        storesService = new StoresService();
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
                case "/insert/store":
                    insertStore(request, response);
                    break;
                case "/delete":
                    deleteStore(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateStore(request, response);
                    break;
                default:
                    listStores(request, response);
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

    private void listStores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Stores> storesList = storesService.findAll();
        request.setAttribute("storesList", storesList);
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
    private void insertStore(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Stores store;  // call the constructor below (only for Test)

        try {


            String id = UUID.randomUUID().toString();
            String storeName = request.getParameter("userInputSN");

            store = new Stores(id, storeName);

            storesService.add(store);
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
            Stores existingStore = storesService.findByID(id);
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");
            request.setAttribute("store", existingStore);
            request.setAttribute("isEdit", true);
            dispatcher.forward(request, response);
        } catch (EntityNotFoundException e) {
            request.setAttribute("message", e.getMessage());
            listStores(request, response);
        }

    }

    // For Later
    private void updateStore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Stores storeToUpdate =  null;  // call other constructor below


        try {

            String id = request.getParameter("StoreId");
            String storeName = request.getParameter("userInputSN");
            // update sellers also in future

            storeToUpdate = new Stores(id, storeName);

            storesService.update(storeToUpdate);
            request.setAttribute("message", Message.buildSuccessMessage("Product updated successfully"));
            listStores(request, response);
        } catch (Exception e) {
            request.setAttribute("store", storeToUpdate);
            request.setAttribute("message", processException(e));
            request.setAttribute("isEdit", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/adminHome/admin.jsp");
            dispatcher.forward(request, response);
        }
    }


    // For later
    private void deleteStore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            storesService.remove(id);
            request.setAttribute("message", Message.buildSuccessMessage("Product deleted successfully"));
        } catch (Exception e) {
            request.setAttribute("message", processException(e));
        }

        listStores(request, response);

    }



}







