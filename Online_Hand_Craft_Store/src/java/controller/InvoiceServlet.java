 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.*;
import java.util.Set;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductListDB;
import model.DBCloseUtil;
import model.InvoiceDB;
import model.InvoiceLineDB;
import javaBeans.InvoiceLine;
import javaBeans.Cart;
import javaBeans.ProductList;
import javaBeans.Invoice;
import javaBeans.Product;
import javaBeans.Line;


public class InvoiceServlet extends HttpServlet 
{

    private ProductList productList;
    String address;
  
    DBCloseUtil dbUtil = new DBCloseUtil();
    ProductListDB productListDB = new ProductListDB();

    @Override
    public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
                    throws ServletException, IOException {
		
        String action = request.getParameter("action");
        
        InvoiceDB invoiceDB = new InvoiceDB();
        InvoiceLineDB invoiceLineDB = new InvoiceLineDB();
    
        if (action.equals("Confirm Checkout")) {
            try {
                
                address = "CheckoutConfirmed.jsp";
                // try to get a database connection
                if (dbUtil.getConnection()) {
                    Cart cartCheckout = CartServlet.getCart();
                    
                    Invoice invoice = new Invoice();
                    invoice.setInvoiceID(7);
                    invoice.setInvoiceUserID(4);
                    //InvoiceLine invoiceLine = new InvoiceLine(8, 7, 9, 2);
                   // invoiceDB.insertOneInvoice(invoice);
                    
                    for(int i = 0; i < cartCheckout.getProductList().size(); i++ ) { 
                        InvoiceLine invoiceLine = new InvoiceLine();
                        invoiceLine.setLineID1(invoice.getInvoiceID());
                        invoiceLine.setLineID2(cartCheckout.getProductList().getLine(i, cartCheckout.getProductList()).getLineProduct().getProductID());
                        invoiceLine.setInvoiceLineNum(i + 20);
                        invoiceLine.setLineQuantity(cartCheckout.getProductList().getLine(i, cartCheckout.getProductList()).getLineQuantity());
                        invoiceLine.setLineProduct(cartCheckout.getProductList().getLine(i, cartCheckout.getProductList()).getLineProduct());
                        
                        invoiceLineDB.insertOneInvoiceLine(invoiceLine);
                        invoice.setInvoiceLine(i, invoiceLine);
                      
                    } 
                    
                    invoice.isSaved(true);
                    request.setAttribute("invoice", invoice); 
                }
            }
            catch( Exception e )
            {
                System.out.println(e.getMessage());
                int x = 0;
            }// end for database connection try
        }
        else address = "Checkout.jsp";
            
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
                    throws ServletException, IOException 
    {
        doGet(request, response);
    }

}