package com.Playloon.View.Controller;

import com.Playloon.Entities.Category;
import com.Playloon.Services.CategoryService;

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

/*
public class CategoryServletController extends BaseController{

    private Service<Category> categoryService;

    public void init() {

        categoryService = new CategoryService();
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
                    insertCategory(request, response);
                    break;
                case "/delete":
                    deleteCategory(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateCategory(request, response);
                    break;
                default:
                    listCategory(request, response);
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

    private void listCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCategory = categoryService.findAll();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/pages/user/searchResults.jsp");  // set listCategory Page //
        dispatcher.forward(request, response);                      // This should be populated in homepage
                                                                    // and when editing
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)    // ask about this
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/pages/adminHome/admin.jsp");        // ask about this
        request.setAttribute("isNew", true);
        dispatcher.forward(request, response);
    }

    // Add new user
    private void insertCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Category category = new Category();  // call the constructor below (only for Test)

     /*   String productID, String itemID, double price, String description, String productName,
                String ImageURL, String category)  */ // Ask about whether to pass itemId or not

/*
        try {
            String id = UUID.randomUUID().toString();
            String categoryName = request.getParameter("categoryName");
            String productId = request.getParameter("productId");     // Not sure about this

            // Ask about productId

            category = new Category(id, categoryName);

            categoryService.add(category);
            //   request.setAttribute("message", Message.buildSuccessMessage("User added successfully"));
            //   listUser(request, response);
        } catch (Exception e) {
            //  request.setAttribute("user", user);
            //   request.setAttribute("message", processException(e));
            //    request.setAttribute("isNew", true);

            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");        // ask about this page
            dispatcher.forward(request, response);

        }
    }

    // How to call update form
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            Category existingCategory = categoryService.findByID(id);
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");   // ask about this page
            request.setAttribute("category", existingCategory);
            request.setAttribute("isEdit", true);
            dispatcher.forward(request, response);
        } catch (EntityNotFoundException e) {
            request.setAttribute("message", e.getMessage());
            listCategory(request, response);
        }

    }

    // For Later
    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Category category = new Category();  // call other constructor below

        try {
            String id = UUID.randomUUID().toString();
            String categoryName = request.getParameter("categoryName");
            String productId = request.getParameter("productId");     // Not sure about this


            category = new Category(id, categoryName);


            categoryService.update(category);

            request.setAttribute("message", Message.buildSuccessMessage("Product updated successfully"));
            listCategory(request, response);
        } catch (Exception e) {
            request.setAttribute("category", category);
            request.setAttribute("message", processException(e));
            request.setAttribute("isEdit", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/adminHome/admin.jsp");
            dispatcher.forward(request, response);
        }
    }


    // For later
    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            categoryService.remove(id);
            request.setAttribute("message", Message.buildSuccessMessage("Category deleted successfully"));
        } catch (Exception e) {
            request.setAttribute("message", processException(e));
        }

        listCategory(request, response);

    }




}
*/
