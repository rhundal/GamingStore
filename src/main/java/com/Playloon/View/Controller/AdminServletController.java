package com.Playloon.View.Controller;

import com.Playloon.Entities.*;
import com.Playloon.Exceptions.EntityNotFoundException;
import com.Playloon.Services.*;

import com.Playloon.View.Controller.StoresServletController;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.Playloon.View.util.Message;
import java.util.List;
import java.util.Optional;
import java.util.UUID;



/* Add products, category, stores, sellers */


public class AdminServletController  extends BaseController{

/* call separate controllers and direct to specific pages */

    private Service<User> userService;
    private Service<Stores> storesService;
    private Service<Sellers> sellersService;
    private Service<Category> categoryService;
    private Service<Product> productService;
    private Service<SellerProduct> sellerProductService;

    public void init() {

        userService = new UserService();
        storesService = new StoresService();
        sellersService = new SellersService();
        categoryService = new CategoryService();
        productService = new ProductService();
        sellerProductService = new SellerProductService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);

        List<Stores> storesList = storesService.findAll();
        req.setAttribute("storeLst", storesList);

        List<Sellers> sellersList = sellersService.findAll();     // redundant
        req.setAttribute("sellerLst", sellersList);

        List<Category> categoryList = categoryService.findAll();
        req.setAttribute("categoryLst", categoryList);

        List<Product> productList = productService.findAll();
        req.setAttribute("productLst", productList);


       // req.setAttribute("nameUser", );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String action = extractAction(request);

            switch (action) {

                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insertStore":
                    insertStore(request, response);
                    break;
                case "/deleteStore":
                    deleteStore(request, response);
                    break;
                case "/editStore":
                    showEditForm(request, response);
                    break;
                case "/updateStore":
                    updateStore(request, response);
                    break;
                case "/insertSeller":
                    insertSeller(request, response);
                    break;
                case "/insertProduct":
                    insertProduct(request, response);
                    break;
                case "/deleteProduct":
                    deleteProduct(request, response);
                    break;
                case "/insertProdToSeller":
                    insertProdToSeller(request, response);
                    break;

                case "/insertCategory":
                    insertCategory(request, response);
                    break;
                case "/deleteSeller":
                    deleteSeller(request, response);
                    break;
                case "/deleteCategory":
                    deleteCategory(request, response);
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


    private void showNewForm(HttpServletRequest request, HttpServletResponse response)    // ask about this
            throws ServletException, IOException {

                List<Stores> storesList = storesService.findAll();
               // List<Sellers> sellersList = sellersService.findAll();   // redundant
                request.setAttribute("storeDD", storesList);
           //     request.setAttribute("sellerDL", sellersList);
                RequestDispatcher dispatcher = request
                .getRequestDispatcher("/pages/adminHome/admin.jsp");
                request.setAttribute("isNew", true);
                dispatcher.forward(request, response);
    }

    private void insertStore(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        Stores store;  // call the constructor below (only for Test)


        try {

            String id = UUID.randomUUID().toString();
            String storeName = request.getParameter("userInputSN");

            store = new Stores(id, storeName);
            storesService.add(store);

            List<Stores> storesList = storesService.findAll();
            request.setAttribute("storeLst", storesList);
            List<Category> categoryList = categoryService.findAll();
            request.setAttribute("categoryLst", categoryList);
            List<Sellers> sellersList = sellersService.findAll();     // redundant
            request.setAttribute("sellerLst", sellersList);

            List<Product> productList = productService.findAll();
            request.setAttribute("productLst", productList);

            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");
            dispatcher.forward(request, response);

            request.setAttribute("message", Message.buildSuccessMessage("Store added successfully"));

            //   listUser(request, response);
        } catch (Exception e) {
           //   request.setAttribute("user", user);
            request.setAttribute("message", processException(e));

            //    request.setAttribute("isNew", true);

            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");   // ask about what page to call
            dispatcher.forward(request, response);

        }

    }


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


    private void deleteStore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {

            String storeN = request.getParameter("storeDD");

            Optional<Stores> storeToDelete = storesService.findByCriteria("storeName", storeN); //StoreName - database column

            String storeId = storeToDelete.get().getStoreID();

            request.setAttribute("selectedStoreId", storeId);

            storesService.remove(storeId);

            List<Stores> storesList = storesService.findAll();
            request.setAttribute("storeLst", storesList);

            List<Sellers> sellersList = sellersService.findAll();     // redundant
            request.setAttribute("sellerLst", sellersList);

            List<Category> categoryList = categoryService.findAll();
            request.setAttribute("categoryLst", categoryList);

            List<Product> productList = productService.findAll();
            request.setAttribute("productLst", productList);

            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");
            dispatcher.forward(request, response);
            request.setAttribute("message", Message.buildSuccessMessage("Store deleted successfully"));

        } catch (Exception e) {
            request.setAttribute("message", processException(e));
        }

       // listStores(request, response);

    }


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

    private void listStores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Stores> storesList = storesService.findAll();
        request.setAttribute("storeDD", storesList);
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/pages/adminHome/admin.jsp");  // set sellersList Page
        dispatcher.forward(request, response);

    }


    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        Product product;  // call the constructor below (only for Test)

        try {

            String id = UUID.randomUUID().toString();
            double price = Double.valueOf(request.getParameter("userInputPrice"));
            String descrp = request.getParameter("userInputDescription");
            String title = request.getParameter("userInputTitle");
            String imageURL = request.getParameter("userInputFileImage");
            String category = request.getParameter("categoryPP");
            Optional<Category> catSelected = categoryService.findByCriteria("CategoryName", category);
            String catId = catSelected.get().getcategoryID();
            request.setAttribute("selectedCategoryId", catId);

            // select sellers
            // item id

            product = new Product(id, price, descrp, title, imageURL, catId, null);

            productService.add(product);

            List<Stores> storesList = storesService.findAll();
            request.setAttribute("storeLst", storesList);

            List<Sellers> sellersList = sellersService.findAll();
            request.setAttribute("sellerLst", sellersList);

            List<Category> categoryList = categoryService.findAll();
            request.setAttribute("categoryLst", categoryList);

            List<Product> productList = productService.findAll();
            request.setAttribute("productLst", productList);

            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");
            dispatcher.forward(request, response);

            request.setAttribute("message", Message.buildSuccessMessage("Store added successfully"));

            //   listUser(request, response);
        } catch (Exception e) {
            //   request.setAttribute("user", user);
            request.setAttribute("message", processException(e));

            //    request.setAttribute("isNew", true);

            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");   // ask about what page to call
            dispatcher.forward(request, response);

        }

    }

    private void insertProdToSeller(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        SellerProduct sp;
        try {


            String sellerN = request.getParameter("sellerDA");
            Optional<Sellers> sellerToAdd = sellersService.findByCriteria("FullName", sellerN);
            String sellerId = sellerToAdd.get().getSellerID();
            request.setAttribute("selectedSellerId", sellerId);

            String productN = request.getParameter("productAd");
            Optional<Product> productToAdd = productService.findByCriteria("Title", productN); //Product Title - database column
            String productId = productToAdd.get().getProductID();
            request.setAttribute("selectedProduct", productId);


            sp = new SellerProduct(sellerId, productId);

            sellerProductService.add(sp);

            List<Stores> storesList = storesService.findAll();
            request.setAttribute("storeLst", storesList);

            List<Sellers> sellersList = sellersService.findAll();
            request.setAttribute("sellerLst", sellersList);

            List<Category> categoryList = categoryService.findAll();
            request.setAttribute("categoryLst", categoryList);

            List<Product> productList = productService.findAll();
            request.setAttribute("productLst", productList);

            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");
            dispatcher.forward(request, response);

            request.setAttribute("message", Message.buildSuccessMessage("Store added successfully"));

            //   listUser(request, response);
        } catch (Exception e) {
            //   request.setAttribute("user", user);
            request.setAttribute("message", processException(e));

            //    request.setAttribute("isNew", true);

            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");   // ask about what page to call
            dispatcher.forward(request, response);

        }


    }


    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {

            String productN = request.getParameter("productDel");

            Optional<Product> productToDelete = productService.findByCriteria("Title", productN); //Product Title - database column

            String productId = productToDelete.get().getProductID();

            request.setAttribute("selectedProduct", productId);

            productService.remove(productId);

            List<Stores> storesList = storesService.findAll();
            request.setAttribute("storeLst", storesList);

            List<Sellers> sellersList = sellersService.findAll();     // redundant
            request.setAttribute("sellerLst", sellersList);

            List<Category> categoryList = categoryService.findAll();
            request.setAttribute("categoryLst", categoryList);

            List<Product> productList = productService.findAll();
            request.setAttribute("productLst", productList);


            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");
            dispatcher.forward(request, response);
            request.setAttribute("message", Message.buildSuccessMessage("Product deleted successfully"));

        } catch (Exception e) {
            request.setAttribute("message", processException(e));
        }

        // listStores(request, response);

    }

    private void insertSeller(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        Sellers seller;

        /*

        1. create UI for drop down checkboxes
        2. seller_prod services
        3. seller_prod repository
        4. productsList (setAttribute)
         */

        try {

            String id = UUID.randomUUID().toString();
            String sellerN = request.getParameter("userInputSellerN");
            String storeName = request.getParameter("sellerDD");
            Optional<Stores> storeSelected = storesService.findByCriteria("storeName", storeName);
            String storeId = storeSelected.get().getStoreID();
            request.setAttribute("selectedStoreId", storeId);

            seller = new Sellers(id, sellerN, storeId);
            sellersService.add(seller);


            /*
            for(every product in list) -> add sellerId and productId
            seller_product = new SellerProduct(id, productsList);
            sellersService.add(seller);
            SellerProductService.add(seller_product);
            */

            List<Stores> storesList = storesService.findAll();
            request.setAttribute("storeLst", storesList);

            List<Sellers> sellersList = sellersService.findAll();     // redundant
            request.setAttribute("sellerLst", sellersList);

            List<Category> categoryList = categoryService.findAll();
            request.setAttribute("categoryLst", categoryList);

            List<Product> productList = productService.findAll();
            request.setAttribute("productLst", productList);


            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");
            dispatcher.forward(request, response);

            request.setAttribute("message", Message.buildSuccessMessage("Seller added successfully"));

            //   listUser(request, response);
        } catch (Exception e) {
            //   request.setAttribute("user", user);
            request.setAttribute("message", processException(e));

            //    request.setAttribute("isNew", true);

        }


    }

    private void deleteSeller(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        try {

            String sellerN = request.getParameter("sellerDL");
            Optional<Sellers> sellerToDelete = sellersService.findByCriteria("FullName", sellerN);
            String sellerId = sellerToDelete.get().getSellerID();
            request.setAttribute("selectedSellerId", sellerId);

            sellersService.remove(sellerId);

            List<Stores> storesList = storesService.findAll();
            request.setAttribute("storeLst", storesList);

            List<Sellers> sellersList = sellersService.findAll();     // redundant
            request.setAttribute("sellerLst", sellersList);

            List<Category> categoryList = categoryService.findAll();
            request.setAttribute("categoryLst", categoryList);

            List<Product> productList = productService.findAll();
            request.setAttribute("productLst", productList);

             RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");
            dispatcher.forward(request, response);

            request.setAttribute("message", Message.buildSuccessMessage("Seller deleted successfully"));

        } catch (Exception e) {
            request.setAttribute("message", processException(e));
        }


    }

    private void insertCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        Category category;

        try {

            String id = UUID.randomUUID().toString();
            String categoryName = request.getParameter("userInputCatN");

            category = new Category(id, categoryName);
            categoryService.add(category);

            List<Stores> storesList = storesService.findAll();
            request.setAttribute("storeLst", storesList);

            List<Sellers> sellersList = sellersService.findAll();     // redundant
            request.setAttribute("sellerLst", sellersList);

            List<Category> categoryList = categoryService.findAll();
            request.setAttribute("categoryLst", categoryList);

            List<Product> productList = productService.findAll();
            request.setAttribute("productLst", productList);

            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");
            dispatcher.forward(request, response);

            request.setAttribute("message", Message.buildSuccessMessage("Seller added successfully"));

            //   listUser(request, response);
        } catch (Exception e) {
            //   request.setAttribute("user", user);
            request.setAttribute("message", processException(e));

            //    request.setAttribute("isNew", true);

        }


    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        try {

            String categoryN = request.getParameter("categoryDel");
            Optional<Category> categoryToDelete = categoryService.findByCriteria("categoryName", categoryN);
            String categoryId = categoryToDelete.get().getcategoryID();
            request.setAttribute("selectedCategoryId", categoryId);

            categoryService.remove(categoryId);

            List<Stores> storesList = storesService.findAll();
            request.setAttribute("storeLst", storesList);

            List<Sellers> sellersList = sellersService.findAll();     // redundant
            request.setAttribute("sellerLst", sellersList);

            List<Category> categoryList = categoryService.findAll();
            request.setAttribute("categoryLst", categoryList);

            List<Product> productList = productService.findAll();
            request.setAttribute("productLst", productList);

            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");
            dispatcher.forward(request, response);

            request.setAttribute("message", Message.buildSuccessMessage("Seller deleted successfully"));

        } catch (Exception e) {
            request.setAttribute("message", processException(e));
        }




    }


}

/*



 private void insertSeller(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        Sellers seller;

        try {

            String id = UUID.randomUUID().toString();
            String sellerN = request.getParameter("userInputSellerN");
            String storeName = request.getParameter("sellerDD");
            Optional<Stores> storeSelected = storesService.findByCriteria("storeName", storeName);
            String storeId = storeSelected.get().getStoreID();
            request.setAttribute("selectedStoreId", storeId);

            seller = new Sellers(id, sellerN, storeId);
            sellersService.add(seller);

            List<Stores> storesList = storesService.findAll();
            request.setAttribute("storeLst", storesList);

            List<Sellers> sellersList = sellersService.findAll();     // redundant
            request.setAttribute("sellerLst", sellersList);

            List<Category> categoryList = categoryService.findAll();
            request.setAttribute("categoryLst", categoryList);

            List<Product> productList = productService.findAll();
            request.setAttribute("productLst", productList);


            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/pages/adminHome/admin.jsp");
            dispatcher.forward(request, response);

            request.setAttribute("message", Message.buildSuccessMessage("Seller added successfully"));

            //   listUser(request, response);
        } catch (Exception e) {
            //   request.setAttribute("user", user);
            request.setAttribute("message", processException(e));

            //    request.setAttribute("isNew", true);

        }


    }
 */