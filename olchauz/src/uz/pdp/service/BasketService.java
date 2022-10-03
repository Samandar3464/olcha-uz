package uz.pdp.service;

import uz.pdp.dataBase.DataBase;
import uz.pdp.modul.Basket;
import uz.pdp.modul.Product;

public class BasketService implements DataBase {
public  boolean addProducsBasket(int basketId, int  productId){
    for (Basket basket : listBasket) {
        if (basket!=null){
            if (basket.getId()==basketId){
                basket.setProduct((Product) getById(productId));
                listBasket.add(basket);
                return true;
            }
        }
    }
    return false;
}
    public Object getById(int productId) {
        for (Product product : products) {
            if (product!=null){
                if (product.getId()==productId){
                    return product;
                }
            }
        }
        return null;
    }
        public void listAddedProductsInBasket(int userId){
            for (Basket o : listBasket) {
                if (o!=null) {
                   if (o.getUserId() == userId) {
                        System.out.println(o);
                    }
                }
                //System.out.println(" Basket list is empty ");
            }
        }

//        public boolean buyProductFromBasket(int basketId,){
//
//        }
    }

