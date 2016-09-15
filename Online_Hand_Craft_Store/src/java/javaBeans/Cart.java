/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaBeans;
import java.util.ArrayList;


/**
 *
 * @author theNextThing
 */
public class Cart {
 
    private ProductList prodInCartList;
    private int userID = 0;
    String errorMessage = "";
    int maxQty = 0;
    
    public Cart(int usID) {
        ///this(setUserID(usID));
        prodInCartList = new ProductList();
        setUserID(usID);
    }
    
    public final void setUserID(int uID) {
        this.userID = uID;
    }
    
    private int findProductInCart(int prodID)
    {
        //Line line = new Line(prodID);
        for (int i = 0; i < this.prodInCartList.size(); i++) {

            if (this.prodInCartList.getLine(i, prodInCartList).getLineID2() == prodID) {
                return i;
            }
        }
        
        return -1;
    }
    
    private Line findLineInCart(int prodID)
    {
        //Line line = new Line(prodID);
        for (int i = 0; i < this.prodInCartList.size(); i++) {

            if (this.prodInCartList.getLine(i, prodInCartList).getLineID2() == prodID) {
                return this.prodInCartList.getLine(i, prodInCartList);
            }
        }
        
        return null;
    }
    
    private boolean cartIsEmpty() {
        return prodInCartList.isEmpty();        
    }
    
    public int addProductToCart(int prodToAddID, Product prod){//, User userID) {
        int prodIndex = -1;
        int lnIndx = 0;
        if (this.findProductInCart(prodToAddID) == -1) {
            // Grab product with id from database or if not there, add to database, add product to cart
            Line ln = new Line(userID, prodToAddID, 1, 1, prod);
            this.prodInCartList.add(ln);
            lnIndx = this.prodInCartList.indexOf(ln);
        }
        else {
            prodIndex = this.findProductInCart(prodToAddID);

           if (this.prodInCartList.getLine(prodIndex, prodInCartList).getLineQuantity() >= 1) {
                // create sepearte method to increase qty in cart
                int tempQty = prodInCartList.getLine(prodIndex, prodInCartList).getLineQuantity() + 1;
                this.prodInCartList.getLine(prodIndex, prodInCartList).setLineQuantity(tempQty);
           }
               
        } 
        return lnIndx;
    }
    
    public void updateCartQty (int prodToUpdateID, int qty) {
        
        int prodIndex = findProductInCart(prodToUpdateID);
        int currentQty = 0;
        
        if (prodIndex != -1) {
            currentQty = this.prodInCartList.getLine(prodIndex, prodInCartList).getLineQuantity();
            currentQty += qty;
            this.prodInCartList.getLine(prodIndex, prodInCartList).setLineQuantity(currentQty);  
            if (currentQty < 1)
                this.removeProductFromCart(prodToUpdateID);
            
        }
    }
    
    public void removeProductFromCart (int prodToDeleteID) {
        
        int prodIndex = findProductInCart(prodToDeleteID);
        
        if (prodIndex != -1) {
            this.prodInCartList.remove(prodIndex);
        }
    }
    
    public ProductList getProductList() {
        return this.prodInCartList;
    }
}
