<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import = "javaBeans.Product"%>
<%@page import = "java.util.*"%>
<%@page import = "javaBeans.Line"%>
<%@page import = "java.text.DecimalFormat"%>

<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/css; charset=UTF-8">
        <title>View Product Details</title>
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
       
            .margin {
                margin-bottom: 15px;
                margin-right: 25px;
                margin-left: 25px;
            }

            #content  {
                text-align: center;
            }
            .active {
                background-color: #357EC7;
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
        
        <div id="content">
            <jsp:useBean id="productList" class="javaBeans.ProductList" scope="request"/>
            <h1>View Product Details</h1>

                
            <table id="productTable" cellpadding="10" align="center">
                     <tr>
                        <th>Seller</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>ID</th>
                        
                    </tr>
                    
                    <%
                        
                        int totalQty = 0;
                        float price = 0;
                           
                        if (productList.isEmpty() == false) {
                            List prodList = productList;
                            
                            DecimalFormat decimalFormat = new DecimalFormat("#.00");
                            ArrayList <Float> priceFormatArray = new ArrayList<Float>();
                            
                            
                            
                            for (int i=0; i < prodList.size(); i++){
                                Line ln = (Line) prodList.get(i);
                                priceFormatArray.add(ln.getLineProduct().getProductPrice());
                                price = ln.getLineProduct().getProductPrice();
                                totalQty += ln.getLineQuantity();
                                String priceStr = decimalFormat.format(price);

                    %>
                     
                    
                    <tr>
                        <td>Andy Anderson</td>
                        <td><%=ln.getLineProduct().getProductName()%></td>
                        <td><%=ln.getLineQuantity()%></td>
                        <td>$<%=priceStr%></td>
                        <td><%=ln.getLineProduct().getProductID()%></td>
                        
                    </tr>
                    
                           
                       
                         <%
                            }
                        }
                        %>
            </table>  
        </div>
        
        <div style="float:bottom" class="footer">
            <script type="text/javascript" src="footer.js"></script>
        </div>       
    </body>
</html>
