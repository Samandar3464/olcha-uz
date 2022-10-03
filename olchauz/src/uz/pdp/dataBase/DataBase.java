package uz.pdp.dataBase;

import uz.pdp.modul.*;

import java.util.ArrayList;
import java.util.List;

public interface DataBase {
     List<User> users = new ArrayList<>();
     List<Product> products = new ArrayList<>();
     List<Basket> listBasket =new ArrayList();
     List<Category> categories=new ArrayList<>();
     List<Order> orders=new ArrayList<>();
}
