package javaBeans;

// NOTE TO SELF: MAKE CATEGORY EXTEND CATEGORY CLASS NAME, ID, DESCRIPTION AFTER GET WORKING WITHOUT INHEIRTANCE
public class Category implements java.io.Serializable {
    private int categoryID = 0;
    private String categoryName = "";
    private String categoryDescription = "";
  

    public Category() {}

    public Category(int cID, String cName, String cDescrip) {
        setCategoryID(cID);
        setCategoryName(cName);
        setCategoryDescription(cDescrip);
    }
  
    public int getCategoryID() {
        return(categoryID);
    }
  
    public final void setCategoryID(int catID) {
        categoryID = catID;
    }
  
    public String getCategoryName() {
        return(categoryName);
    }
  
    public final void setCategoryName(String catName) {
        categoryName = catName;
    }

    public String getCategoryDescription() {
        return(categoryDescription);
    }
  
    public final void setCategoryDescription(String catDescription) {
        categoryDescription = catDescription;
    }
}
