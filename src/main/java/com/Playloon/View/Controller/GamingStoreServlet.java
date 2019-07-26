package com.Playloon.View.Controller;

import com.Playloon.Entities.*;
import com.Playloon.Exceptions.EntityNotFoundException;
import com.Playloon.Services.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import com.Playloon.View.util.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GamingStoreServlet extends BaseController {


    private Service<Product> productService;
    private List<Product> productList;
    private HttpSession session;

    public void init() {

        productService = new ProductService();
        productList = new ArrayList<Product>();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         session = req.getSession();

        productList = productService.findAll();
        session.setAttribute("productLst", productList);
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String action = extractAction(request);

            switch (action) {

                case "/GamingStore":
                    indexPage(request, response);       // homepage products
                    break;

                default:
                    listProducts(request, response);    // show results products
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


    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        List<Stores> storesList = storesService.findAll();
        request.setAttribute("storeDD", storesList);
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/pages/adminHome/admin.jsp");  // set sellersList Page
        dispatcher.forward(request, response);
*/
    }


    private void indexPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        System.out.println("size" + productList.size());

        for (Product product: productList) {

            session.setAttribute("productImage", product.getImage());
            session.setAttribute("productDescription", product.getDescription());
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");  //
        dispatcher.forward(request, response);


    }




}
