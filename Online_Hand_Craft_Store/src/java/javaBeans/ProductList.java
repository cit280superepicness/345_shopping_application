package javaBeans;

import java.util.*;

public class ProductList extends ArrayList implements java.io.Serializable {
    
    private ArrayList productList;
    private ProductList prodListInProductList;
    private Product product;
    private Category category;
    private Line line;

    public ProductList() {
        productList = new ArrayList();
    }

    public List getProductList() {
        return(this.productList);
    }

    public Line getLine(int lnIndex, ProductList pl) {
        line = (Line) pl.get(lnIndex);
        return(line);
    }
    
    public int getLineIndex(ProductList pl) {
        int lineIndx = pl.indexOf(pl);
        return(lineIndx);
    }
    
   /** public Line getLine(int lnIndex) {
        line = (Line) productList.get(lnIndex);
        return(line);
    }**/

    public void setLine(int lnIndex, Line ln, ProductList pl) {
        pl.add(lnIndex, ln);
    }
 
    public void setLine(int lnIndex, Line ln) {
        productList.add(lnIndex, ln);
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
    
    public ProductList getProdListInProductList(int indx) {
        prodListInProductList = (ProductList) productList.get(indx);
        return(prodListInProductList);
    }
    
      public void setProdListInProductList(ProductList plt) {
        this.productList.add(plt);
    }
}
