package com.Playloon;

import com.Playloon.Entities.User;
import com.Playloon.Entities.UserTypes;
import com.Playloon.Services.UserService;

import java.util.UUID;

public class Main {



    public static void main(String[] args) {
	// write your code here

        String email, password, firstName, lastName;
        String userSelection = "";

        /*
         Users myUsers = new Users(UserTypes.ADMINISTRATOR);

        Customer customer = new Customer();

        // populate DataList with UserTypes  (User Interface) - Step 1

        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter Email");
      //  email = myObj.nextLine();
        myUsers.setEmail(myObj.nextLine());    // Step 2 - User enters email

        System.out.println("Enter password");
      //  password = myObj.nextLine();
        myUsers.setPassword(myObj.nextLine());      // Step 3 - User enters password

        System.out.println("Enter firstName");
        myUsers.setFirstName(myObj.nextLine());      // setting first name
      //  firstName = myObj.nextLine();

        System.out.println("Enter lastName");
        myUsers.setLastName(myObj.nextLine());      // setting first name
      //  lastName = myObj.nextLine();

        System.out.println("Select User Type");     // Step 4 - User selects user type from drop down
        userSelection = myObj.nextLine();
        myUsers.setType(userSelection);

*/
            UUID userUUID = UUID.randomUUID();       //1. create object with UUID
            User myUser = new User(userUUID.toString(), "Jeena", "Mason", "JMason@gmail.com", "pass", UserTypes.CUSTOMER);
            UserService uService = new UserService();
            uService.add(myUser);

       //     uService.remove("4e0fe76c-05f0-4fe8-9483-c0cf40d67f1e");  // testing remove from db


        //User user2 = new User("4e0fe76c-05f0-4fe8-9483-c0cf40d67f1e", "Curtis", "Thacker", "c.thacker@gmail.com", "passmein", UserTypes.ADMINISTRATOR);

     //   uService.update(user2);   // not working

        /*
        System.out.println("--- > " + uService.findByID("4e0fe76c-05f0-4fe8-9483-c0cf40d67f1e").getFirstName());

       if(uService.findByID("4e0fe76c-05f0-4fe8-9483-c0cf40d67f1e") != null)
       {
           System.out.println("User Found");
       }

       List<User> myList = new ArrayList<User>();

       myList = uService.findAll(uService.findByID("4e0fe76c-05f0-4fe8-9483-c0cf40d67f1e"));

       System.out.println("N# of users found " + myList.size());

*/

        /*
        if(myUsers.getType(userSelection).equals(UserTypes.ADMINISTRATOR.name()))      // check against Enum Value
        {
            // Login To Admin Home  - Admin will call its own Login

            //2. call UsersService - add - which call UserRepository
            //3. call sql in UserRepository - save user to database

     //       myUsers = new Administrator(userUUID, myUsers.getFirstName(), myUsers.getLastName(), myUsers.getEmail(), myUsers.getPassword(), myUsers.getUserType());


            // call UserService

            UserService uService = new UserService();
            uService.add(myUsers);

            //   adminUser.Login(UserTypes.ADMINISTRATOR);           // calling specific function


            /////////////////////////////////////////////

            //// Admin adds products //// - done via services class and repository class for products


            List<Product> products = new ArrayList<Product>();  // make an ArrayList of Customer Order

            Product product1 = new Product(3, 11, 25.20, "Little Big Planet", "Arcade");
            Product product2 = new Product(4, 13, 135.20, "Division 2", "Playstation");
            Product product3 = new Product(8, 12, 245.20, "Counter Strike", "Adventure");
            Product product4 = new Product(6, 15, 345.20, "Mario", "Puzzle");
         //   Product product5 = new Product(5 , 17, 655.20, "Game 5", "Action");

            // create stores - done via services and repository class for stores

            Stores store1 = new Stores("Microsoft");
            Stores store2 = new Stores("Nintendo");
            Stores store3 = new Stores("Ubisoft");
            Stores store4 = new Stores("Rockstar");

            List<Sellers> sellers = new ArrayList<Sellers>();    // done via services and repository class for sellers

            Sellers seller1 = new Sellers("Alan", "Hudson", 333, products, "Microsoft");
            Sellers seller2 = new Sellers("faxy", "pole", 444, products, "Nintendo");
            Sellers seller3 = new Sellers("goomy", "kaur", 555, products, "Ubisoft");
            Sellers seller4 = new Sellers("bob", "marcy", 666, products, "Rockstar");

            product1.setSellers(sellers);
            product2.setSellers(sellers);
            product3.setSellers(sellers);
            product4.setSellers(sellers);
          //  product5.setSellers(sellers);  // M 2 M

            products.add(product1); // add products in arraylist
            products.add(product2);
            products.add(product3);
            products.add(product4);
         //   products.add(product5);

            seller1.setProduct(products);
            seller2.setProduct(products);
            seller3.setProduct(products);
            seller4.setProduct(products);

            sellers.add(seller1);
            sellers.add(seller2);
            sellers.add(seller3);
            sellers.add(seller4);

            store1.setSellers(sellers);
            store2.setSellers(sellers);
            store3.setSellers(sellers);
            store4.setSellers(sellers);



            System.out.println("Available products - > category - > price - > quantity -> sellersName -> storeName ");

            int i = 0;
            for (Product prod: products){

                System.out.println(prod.getpName() + " " + prod.getCategory() + " " + prod.getPrice() + " " + prod.getQuantity() + " " + prod.getSellers().get(i).getfName() + " " + prod.getSellers().get(i).getStoreName());
                i++;
            }


            //    myUsers.Login(Users.ADMINISTRATOR);

        }
        else if(myUsers.getType(userSelection).equals(UserTypes.CUSTOMER.name()))        // check against Enum Value
        {
            // Login To Customer Home - Customer will call its own Login

            Users custUser = new Customer();
            myUsers.Login(UserTypes.CUSTOMER);

           // customer = new Customer();     // make a new customer
            List<Customer_Order> cust_order = new ArrayList<Customer_Order>();  // make an ArrayList of Customer Order

            Customer_Order o1 = new Customer_Order("Order1");   // make new customer_order
            Customer_Order o2 = new Customer_Order("Order2");

            o1.setCustomer(customer);   // set customer_order for customer
            o2.setCustomer(customer);

            cust_order.add(o1);     // adding orders to ArrayList
            cust_order.add(o2);

            customer.setCustomerOrder(cust_order);  // pass ArrayList of orders to Customer object

            ///////////////// Alex way //////////////

          //  customer.getCustomerOrder().add(o1);   // instead of setCustomer you can use this
          //  customer.getCustomerOrder().add(o2);

            // later make interface to get credentials

        }
        else
        {
            System.out.println("Please select a user type");
        }


        /*
        System.out.println("Enter firstName");
        myUsers.setFirstName(myObj.nextLine());      // setting first name

        System.out.println("Enter lastName");
        myUsers.setLastName(myObj.nextLine());      // setting first name

        */


        // Print User Information
     //   System.out.println();

        /*

        System.out.println("Your User Information is as follows: ********* ");

        System.out.println("User Type Name is: " + myUsers.getType(userSelection));

        System.out.println("User First Name is: " + myUsers.getFirstName());

        System.out.println("User Last Name is: " + myUsers.getLastName());

        System.out.println("User Email is: " + myUsers.getEmail());

        System.out.println("User Password is: " + myUsers.getPassword());

        System.out.println();

*/
        System.out.println("********* Your Order Details ************");

        if(userSelection == "CUSTOMER")
        {
           // customer.printOrders();

        }




    }
}
