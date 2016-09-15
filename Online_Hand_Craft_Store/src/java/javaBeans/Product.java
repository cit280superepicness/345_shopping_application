package javaBeans;

// NOTE TO SELF: MAKE PRODUCT EXTEND CATEGORY CLASS NAME, ID, DESCRIPTION AFTER GET WORKING WITHOUT INHEIRTANCE
public class Product implements java.io.Serializable {
    private int productID = 0;
    private int productCategoryID = 0;
    private String productName = "";
    private float productPrice = 0;
    private String productDescription = "";


    public Product() {}

    public Product(int p_id, int p_c_id, String p_name, float p_price, String p_descrip) {
        setProductID(p_id);
        setProductCategoryID(p_c_id);
        setProductName(p_name);
        setProductPrice(p_price);
        setProductDescription(p_descrip);
    }

    public int getProductID() {
        return(productID);
    }

    public final void setProductID(int prodID) {
        productID = prodID;
    }
    
     public int getProductCategoryID() {
        return(productCategoryID);
    }

    public final void setProductCategoryID(int prodCatID) {
        productCategoryID = prodCatID;
    }

    public String getProductName() {
        return(productName);
    }

    public final void setProductName(String prodName) {
        productName = prodName;
    }

    public float getProductPrice() {
        return(productPrice);
    }

    public final void setProductPrice(float prodPrice) {
        productPrice = prodPrice;
    }

    public String getProductDescription() {
        return(productDescription);
    }

    public final void setProductDescription(String prodDescription) {
        productDescription = prodDescription;
    }
}
