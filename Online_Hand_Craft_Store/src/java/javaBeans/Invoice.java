package javaBeans;
         // To create a date format (I.e. mm-dd-yyyy)
import java.util.Calendar;
import java.time.*;
import java.util.*;

public class Invoice extends ArrayList implements java.io.Serializable {
    private int invoiceID;
    private int invoiceUserID;
    private java.sql.Date invoiceDate;
    private java.sql.Time invoiceTime;
    private boolean isSaved;
    private InvoiceLine invoiceLine;
    private ArrayList invoiceList;
    
    // get current dat with calendar
    
    public Invoice() {
        this.invoiceID = 0;
        this.invoiceUserID = 0;
        invoiceList = new ArrayList();
        
        LocalDate invcDate;
        LocalTime invcTime;
        
        try {
            invcDate = LocalDate.now();
            invcTime = LocalTime.now();
            this.invoiceDate = java.sql.Date.valueOf( invcDate );
            this.invoiceTime = java.sql.Time.valueOf(invcTime);
            isSaved = false;
            //invoiceDate.
            /**SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            this.invoiceDate = dateFormat.parse("01-01-2000");
            this.invoiceTime = timeFormat.parse("00:00:00");**/
        } 
        catch(Exception e){
            System.out.println("Problem applying date format to date.");
        }
    }

    public Invoice(int iID, int iUserID, LocalDate iDate, LocalTime iTime) {
        
        
        invoiceList = new ArrayList();
        
        setInvoiceID(iID);
        setInvoiceUserID(iUserID);
        
        try {
            iDate = LocalDate.now();
            iTime = LocalTime.now();
            setInvoiceDate(java.sql.Date.valueOf(iDate));
            setInvoiceTime(java.sql.Time.valueOf(iTime));
            isSaved = false;
        } 
        catch(Exception e){
            System.out.println("Problem applying date format to date." + e.getMessage());
        }
    }
    
    public int getInvoiceID() {
        return(invoiceID);
    }

    public final void setInvoiceID(int invcID) {
        invoiceID = invcID;
    }

    public int getInvoiceUserID() {
        return(invoiceUserID);
    }

    public final void setInvoiceUserID(int invcUserID) {
        invoiceUserID = invcUserID;
    }

    public java.sql.Date getInvoiceDate() {
        return(invoiceDate);
    }

    public final void setInvoiceDate(java.sql.Date invcDate) {
        invoiceDate = invcDate;
    }

    public java.sql.Time getInvoiceTime() {
        return(invoiceTime);
    }

    public final void setInvoiceTime(java.sql.Time invcTime) {
        invoiceTime = invcTime;
    }
    
    public final void isSaved (boolean save) {
        isSaved = save;
    }
    
    public boolean getIsSaved() {
        return(isSaved);
    }
    
    public final void setInvoiceLine(int indx, InvoiceLine invLn) {
        this.invoiceList.add(indx, invLn);
    }
    
    public InvoiceLine getInvoiceLine(int indx) {
        invoiceLine = (InvoiceLine) invoiceList.get(indx);
        return(invoiceLine);
    }
  
    public InvoiceLine getInvoiceLine(int indx, Invoice il) {
        invoiceLine = (InvoiceLine) il.get(indx);
        return(invoiceLine);
    }

    public void setInvoiceList(ProductList iList) {
        this.invoiceList = iList;
    }
        
    public List getInvoiceList() {
        return(this.invoiceList);
    }
}
