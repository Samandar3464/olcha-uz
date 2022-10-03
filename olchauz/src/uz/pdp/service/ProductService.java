package uz.pdp.service;

import uz.pdp.Constants;
import uz.pdp.dataBase.DataBase;
import uz.pdp.modul.Base;
import uz.pdp.modul.Category;
import uz.pdp.modul.Product;

public class ProductService extends Base implements DataBase, Constants, BaseService {


    public boolean addProduct(Product product) {
        for (Product product1 : products) {
            if (product1 != null) {
                if (product1.getName().equals(product.getName())) {
                    return false;
                }
            }
        }
        for (Category category : categories) {
            if (category.getId() == product.getCategoryId() && getById(product.getCategoryId()) == null) {
                products.add(product);
                return true;
            }
        }
        return false;
    }

    public void showList(){
        for (Product product : products) {
            if (product!=null){
                System.out.println(product);
            }
        }
    }
    @Override
    public boolean delete(int productId) {
        for (Product product : products) {
            if (product!=null){
                if (product.getId()==productId){
                    products.remove(product);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
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

public  void productsEnterCategory(int categoryId){
    for (Product product : products) {
        if (product!=null){
            if (product.getCategoryId()==categoryId){
                System.out.println(product);
            }
        }
    }
}

}
