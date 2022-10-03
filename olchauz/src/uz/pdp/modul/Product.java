package uz.pdp.modul;

public class Product extends  Base {
    private double price;
    private String infoProduct;
    private int count;
    private int  categoryId;
    public Product() {
    }
    public Product(String name, double price, int count, String infoProdact,int  categoryId) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.infoProduct = infoProdact;
        this.categoryId=categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfoProduct() {
        return infoProduct;
    }

    public void setInfoProduct(String infoProduct) {
        this.infoProduct = infoProduct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", infoProduct='" + infoProduct + '\'' +
                ", count=" + count +
                '}';
    }
}
