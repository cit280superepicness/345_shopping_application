/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductListDB;
import model.DBCloseUtil;
import javaBeans.Product;
import javaBeans.Line;
import javaBeans.ProductList;

public class ProductServlet extends HttpServlet 
{

    private ProductList productList;
    private Line lineItem;
    String address;
  
    DBCloseUtil dbUtil = new DBCloseUtil();
    ProductListDB productListDB = new ProductListDB();

    public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
                    throws ServletException, IOException {
		
        String action   = request.getParameter("action");

        DBCloseUtil dbUtil = new DBCloseUtil();
        ProductListDB productListDB = new ProductListDB();
     
        if (action.equals("Buy")) {
            // try to get a database connection
            if (dbUtil.getConnection()) {
                address = "Shop.jsp";
                productList = new ProductList();
                //productListDB.selectAll(productList);
                request.setAttribute("productList", productList); 
            }// end for database connection try
            else address = "BuyOrSell.jsp";

        }// end if ViewAll requested

        else if (action.equals("ViewProduct")) {
            int productID = 0;
            try {
                productID = Integer.parseInt(request.getParameter("productID"));
                if (dbUtil.getConnection()) {
                    address = "ViewProductDetails.jsp";
                    //productList = productListDB.selectOne(productID);
                    request.setAttribute("productList", productList);
                }// end for database connection try
                else address = "index.jsp";
            }
            catch( Exception e )
            {
                address = "index.jsp";
            }
        }// end if SelectOne
         else if (action.equals("Sell")) {
            int productID = 0;
            try {
                productID = Integer.parseInt(request.getParameter("productID"));
                if (dbUtil.getConnection()) {
                    productList = new ProductList();
                    //productListDB.selectAll(productList, productID);
                    request.setAttribute("productList", productList);
                }// end for database connection try
                else address = "index.jsp";
            }
            catch( Exception e )
            {
                address = "index.jsp";
            }
        }// end if SelectOne
        else if (action.equals("InsertOneProduct")) {
            int productID = 0;
            try {
                lineItem = new Line();
                lineItem.setLineID2(Integer.parseInt(request.getParameter("productID")));
               // lineItem.setLineNum(request.getParameter("productName"));
                //lineItem.setProductPrice(Integer.parseInt(request.getParameter("productPrice")));
                //lineItem.setProductDescription(request.getParameter("productDescription"));

                if (dbUtil.getConnection()) {
                    //productList = productListDB.insertOne(lineItem);
                    request.setAttribute("productList", productList);
                }// end for database connection try
                else address = "index.jsp";
            }
            catch(Exception e)
            {
                address = "index.jsp";
            }
        }// end if SelectOne
        else if (action.equals("UpdateOneProduct")) {
            int productID = 0;
            try {
                /**lineItem.setProductID(Integer.parseInt(request.getParameter("productID")));
                lineItem.setProductName(request.getParameter("productName"));
                lineItem.setProductPrice(Integer.parseInt(request.getParameter("productPrice")));
                lineItem.setProductDescription(request.getParameter("productDescription"));**/

                if (dbUtil.getConnection()) {
                    //productList = productListDB.updateOne(lineItem);
                    request.setAttribute("productList", productList);
                }// end for database connection try

                else address = "index.jsp";
            }
            catch( Exception e )
            {
                address = "index.jsp";
            }
        }// end if SelectOne

        else if (action.equals("DeleteOneProduct")) {
            int productID = 0;
            try {
                productID = Integer.parseInt(request.getParameter("productID"));
                if (dbUtil.getConnection()) {
                    //productListDB.deleteOne(productID);
                    productList = new ProductList();
                    //productListDB.selectAll(productList);
                    request.setAttribute("productList", productList);
               }// end for database connection try
                else address = "index.jsp";
            }
            catch( Exception e )
            {
                address = "index.jsp";
            }
        }// end if SelectOne
        else address = "index.jsp";

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