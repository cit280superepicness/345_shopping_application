<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import = "javaBeans.Product"%>
<%@page import = "javaBeans.Line"%>
<%@page import = "java.util.*"%>
<%@page import = "java.text.DecimalFormat"%>

<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/css; charset=UTF-8">
        <title>View Cart</title>
        <style>
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
            }

            li {
                float: left;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover:not(.active) {
                background-color: #111;
            }
            
            footer  {
                text-align: center;
                bottom:4px;
                height:30px;
                width:100%;

            }
            
            hr  {
                width: 75%;
            }
            
            #content  {
                text-align: center;
            }
           
            
            #item   {
                align: center;
            }
            .active {
                background-color: #357EC7;
            }

            .margin {
                margin-bottom: 15px;
                margin-left:auto; 
                margin-right:auto;

            }
        </style>                  
    </head>
      
    <body>
        <ul>
            <li><a href="Login.jsp">Click here to Login or Logout</a></li>
            <li><a href="Shop.jsp">Shop</a></li>
            <li><a href="ManageInventory.jsp">Manage Inventory</a></li>
            <li><a href="ViewShoppingCart.jsp">View Cart</a></li>
            <li style="float:right"><a class="active" href="AboutContactUs.jsp">Contact / About</a></li>
        </ul>
        
        <div id="content" style="float:top">
            <jsp:useBean id="productList" class="javaBeans.ProductList" scope="request"/>
            <h1>View Cart</h1>
            

            <form action="cartServlet" method=post>
                        
                <input type="submit" name=action value="View My Cart" />
                <br /><br />
                
                <table cellpadding="5" class="margin" style="text-align:center">
                     <tr>
                        <th>Item</th>
                         <th>Quantity</th>
                         <th>Price</th>
                         <th>Product ID</th>
                    </tr>
                    
                
                       <%
                        
                        int totalQty = 0;
                        float totalPrice = 0;
                           
                        if (productList.isEmpty() == false) {
                            List prodList = productList;
                            
                            DecimalFormat decimalFormat = new DecimalFormat("#.00");
                            ArrayList <Float> priceFormatArray = new ArrayList<Float>();
                            
                            
                            
                            for (int i=0; i < prodList.size(); i++){
                                Line ln = (Line) prodList.get(i);
                                priceFormatArray.add(ln.getLineProduct().getProductPrice());
                                totalPrice = totalPrice + (priceFormatArray.get(i) * ln.getLineQuantity());
                                totalQty += ln.getLineQuantity();
                                String priceStr = decimalFormat.format(priceFormatArray.get(i));
                    %>
                     
                    
                    <tr>
                        
                        <td><%=ln.getLineProduct().getProductName()%></td>
                        <td><%=ln.getLineQuantity()%></td>
                        <td>$<%=priceStr%></td>
                        <td><%=ln.getLineProduct().getProductID()%></td>
                        <td></td>
                    </tr>
                    <tr>
                        
                        <%  
                            
                            if (i == (prodList.size() -1)) {
                                
                                String totalPriceStr = decimalFormat.format(totalPrice);
                        %>
                         <th>Total:</th>
                         <td><%=totalQty%> item(s) in cart</td>
                         <th>Total Price:</th>
                         <td>$<%=totalPriceStr%></td>
                       
                         <%      }
                            }
                        }
                        %>
                </table>
               
                
                <p><input type="submit" name=action value="Remove"><input type="text" style="width: 300px;" name=pIDToRemove value="Enter product ID of product to remove.">
                <p><input type="submit" name=action value="Update Quantity"><input type="text" style="width: 300px;" name=pIDToUpdateQty value="Enter product ID of product update its quantity.">
                    <input type="text" style="width: 300px;" name=qtyAddSub value="Enter quantity to add or subtract."></p>
                
                <input type="submit" name=action value="Proceed to Checkout">
            </form>
        </div>
        
        <div style="float:bottom" class="footer">
            <script type="text/javascript" src="footer.js"></script>
        </div>       
    </body>
</html>
