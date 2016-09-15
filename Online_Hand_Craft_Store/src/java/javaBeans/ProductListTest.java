package javaBeans;

import java.util.*;

public class ProductListTest extends ArrayList implements java.io.Serializable {

    private ArrayList productList;
    private ProductListTest prodListInProductList;
    private Product product;
    private Category category;

    public ProductListTest() {
        productList = new ArrayList();
    }

    public List getProductListTest() {
        return(productList);
    }

    public Product getProduct(int indx) {
        product = (Product) productList.get(indx);
        return(product);
    }

    public void setProduct(int indx, Product prod) {
        this.productList.add(indx, prod);
    }

    public Category getCategory(int indx) {
        category = (Category) productList.get(indx);
        return(category);
    }

    public void setCategory(int indx, Category cat) {
        this.productList.add(indx, cat);
    }
    
    public ProductListTest getProdListInProductList(int indx) {
        prodListInProductList = (ProductListTest) productList.get(indx);
        return(prodListInProductList);
    }
    
      public void setProdListInProductList(ProductListTest plt) {
        this.productList.add(plt);
    }
}