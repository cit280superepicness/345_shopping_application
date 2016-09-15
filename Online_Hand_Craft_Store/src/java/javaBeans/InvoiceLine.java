/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaBeans;


public class InvoiceLine extends Line {
    
    private int invoiceLineID, 
            invoiceLineProductID,
            invoiceLineNum,
            invoiceLineQuantity;
    
    public InvoiceLine() {
        this.invoiceLineID = 0;
        this.invoiceLineProductID = 0;
        this.invoiceLineNum = 0;
        this.invoiceLineQuantity = 0;
    }
    
    public InvoiceLine(int invoiceLnID, int invoiceLnProdID, int invoiceLnNum,
            int invoiceLnQty, Product prod) {
        
        super.setLineID1(invoiceLnID);
        super.setLineID2(invoiceLnProdID);
        setInvoiceLineNum(invoiceLnNum);
        super.setLineQuantity(invoiceLnQty);
        super.setLineProduct(prod);
        
    }
    
    public int getInvoiceLineID() {
        return super.getLineID1();
    }
    
    public int getInvoiceLineProductID() {
        return super.getLineID2();
    }
    
    public final void setInvoiceLineNum(int invLiNum) {
        this.invoiceLineNum = invLiNum;
    }
    
    public int getInvoiceLineQuantity() {
        return super.getLineQuantity();
    }

    public int getInvoiceLineNum() {
        return(invoiceLineNum);
    }
}
