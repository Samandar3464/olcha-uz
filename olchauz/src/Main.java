import uz.pdp.Constants;
import uz.pdp.dataBase.DataBase;
import uz.pdp.modul.Basket;
import uz.pdp.modul.Category;
import uz.pdp.modul.Product;
import uz.pdp.modul.User;
import uz.pdp.service.*;

import java.util.Scanner;

public class Main implements DataBase, Constants {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerint = new Scanner(System.in);
    static UserService userService = new UserService();
    static CategoryService categoryService = new CategoryService();
    static ProductService productService = new ProductService();
    static BasketService basketService = new BasketService();

    public static void main(String[] args) {


        User user1 = new User("admin", "admin", "12345", "admin", ADMIN);
        users.add(user1);

        int var = 10;
        while (var != 0) {
            System.out.println(REGISTRATION + " " + LOGIN + " " + PRODUCTS + " " + EXIT);
            var = scannerint.nextInt();
            switch (var) {
                case 1 -> {
                    System.out.print("enter phoneNumber ");
                    String telNumber = scannerStr.nextLine();
                    registratsiya(telNumber);
                    userService.listUsers();  //userlar
                }
                case 2 -> {

                    System.out.print("enter name ");
                    String name = scannerStr.nextLine();
                    System.out.print("enter password ");
                    String password = scannerStr.nextLine();
                    User checkedUser = userService.login(name, password);
                    if (checkedUser.getRole().equals(ADMIN)) {  // admin panel
                        int var1 = 10;
                        while (var1 != 0) {
                            System.out.println(CATEGORY_AND_PRODUCT + " " + SEE_ORDERS_LIST + " " + BACK);
                            var1 = scannerint.nextInt();
                            switch (var1) {
                                case 1 -> { // category
                                    categoryAndProduct();
                                }
                                case 3 -> {// orders

                                }
                                case 0 -> {
                                }
                            }
                        }
                    }
                    // user panel
                    else {
                        int var2 = 10;
                        while (var2 != 0) {
                            System.out.println(KATIGORI_PRODUCTS + " " + ALL_PRODUCT + " " + BASKET + " " + SITTING_PROFEL);
                            var2 = scannerint.nextInt();
                            switch (var2) {
                                case 1 -> { //KATIGORI_PRODUCTS
                                    categoryService.showParentCategoriesforUser();
                                    int var7 = 10;
                                    while (var7 != 0) {
                                        System.out.println("enter catecoryId" + " " + BACK);
                                        var7 = scannerint.nextInt();
                                        productService.productsEnterCategory(var7);
                                        categoryService.showSubCategoriesForUser(var7);
                                        addProductBasket();

                                    }
                                }
                                case 2 -> {//ALL_PRODUCT
                                    for (Product product : products) {
                                        System.out.println(product);
                                    }
                                    addProductBasket();  // maxsulotni basketga qoshadi
                                }
                                case 3 -> {//BASKET
                                    basket();
                                }
                                case 4 -> { // user malumotlarini yangilash
                                    userUpdate(checkedUser);
                                }
                                case 0 -> {
                                }
                            }
                        }
                    }
                }
                case 3 -> { // ALL PRODUCTS
                    categoryService.showAllCategories();
                }
                case 0 -> {
                    return;
                }
            }
        }
    }

    private static void forAdminCategory() {
        int var5 = 10;
        while (var5 != 0) {
            System.out.println(ADD_CATEGORY + " " + LIST_CATEGORY + " " + DETETE_CATEGORY);
            var5 = scannerint.nextInt();
            switch (var5) {
                case 1 -> { //add categori
                    Category category = new Category();
                    System.out.print("enter name ");
                    category.setName(scannerStr.nextLine());
                    System.out.print("enter parentId ");
                    category.setParentId(scannerint.nextInt());
                    System.out.println(categoryService.addCategory(category));
                }
                case 2 -> {// list category
                    categoryService.showParentCategoriesforAdmin();
                    int var7 = 10;
                    while (var7 != 0) {
                        System.out.println("enter catecoryId" + " " + BACK);
                        var7 = scannerint.nextInt();
                        productService.productsEnterCategory(var7);
                        categoryService.showSubCategoriesForAdmin(var7);
//
                    }
                }
                case 3 -> {
                    System.out.println("enter categottId");
                    int categoryId = scannerint.nextInt();
                    System.out.println(categoryService.delete(categoryId));
                }
                case 0 -> {
                }
            }
        }
    }

    private static void productForAdmin() {
        int var8 = 10;
        {
            System.out.println(ADD_PRODUCT + " " + DELETE_PRODUCT + " " + SHOW_PRODUCT_LIST);
            var8 = scannerint.nextInt();
            switch (var8) {
                case 1 -> {
                    Product product = new Product();
                    System.out.print("enter name ");
                    product.setName(scannerStr.nextLine());
                    System.out.print("enter price ");
                    product.setPrice(scannerint.nextDouble());
                    System.out.print("enter count ");
                    product.setCount(scannerint.nextInt());
                    System.out.print("enter infoProduct ");
                    product.setInfoProduct(scannerStr.nextLine());

                    categoryService.showAllCategories();
                    System.out.print("enter CategoryId ");
                    product.setCategoryId(scannerint.nextInt());
                    System.out.println(productService.addProduct(product));
                }
                case 2 -> {
                    System.out.print("enter productId ");
                    productService.delete(scannerint.nextInt());
                }
                case 3 -> {
                    productService.showList();
                }
                case 0 -> {
                }
            }
        }
    }

    private static void categoryAndProduct() {
        int var9 = 10;
        System.out.println("1. CATEGORY 2. PRODUCT");
        var9 = scannerint.nextInt();
        switch (var9) {
            case 1 -> {
                forAdminCategory();
            }
            case 2 -> {
                productForAdmin();
            }
            case 3 -> {
            }
        }

    }

    private static void registratsiya(String telNum) {

        if (userService.checkTelefon(telNum) != null) {
            System.out.print("enter name ");
            String name = scannerStr.nextLine();
            System.out.print("enter surName ");
            String surname = scannerStr.nextLine();
            System.out.print("enter password ");
            String password = scannerStr.nextLine();
            User newUser = userService.registration(name, surname, telNum, password);
            users.add(newUser);
        }
    }

    private static void userUpdate(User user) {
        System.out.print("new name ");
        String name = scannerStr.nextLine();
        System.out.print("new surname ");
        String surName = scannerStr.nextLine();
        System.out.print("new telNumber ");
        String telNum = scannerStr.nextLine();
        System.out.print("new password ");
        String password = scannerStr.nextLine();
        System.out.print("new age ");
        int age = scannerint.nextInt();
        System.out.print("new card number ");
        String cardNumber = scannerStr.nextLine();
        System.out.print("amount ");
        double amount = scannerint.nextDouble();
        userService.upToDateUserInfo(user, name, surName, telNum, password, age, cardNumber, amount);

    }

    static int userbasketId = 0;

    private static void newBasket() {
        Basket basket = new Basket();
        System.out.print("enter name ");
        String name = scannerStr.nextLine();
        basket.setName(name);
        basket.setUserId(userService.dafaultUserId);
        listBasket.add(basket);
        System.out.println(basket);
        userbasketId = basket.getId();
    }

    private static void addProductBasket() {
        System.out.println("enter productId for add basket");
        int productId = scannerint.nextInt();
        basketService.addProducsBasket(userbasketId, productId);

    }

    private static void basket() {
        int var = 10;
        while (var != 0) {
            System.out.println("1.Add basket 2. Products added basket ");
            var = scannerint.nextInt();
            switch (var) {
                case 1 -> {
                    newBasket();
                }
                case 2 -> {
                    basketService.listAddedProductsInBasket(userService.dafaultUserId);
                }
                case 0 -> {
                }
            }
        }
    }
}
