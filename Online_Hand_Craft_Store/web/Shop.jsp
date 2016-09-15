<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import = "javaBeans.Product"%>
<%@page import = "javaBeans.Category"%>
<%@page import = "javaBeans.Line"%>
<%@page import = "java.util.*"%>
<%@page import = "java.text.DecimalFormat"%>

<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/css; charset=UTF-8">
        <title>Shop</title>
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
        
        <div id="content" style="float:top">
            <jsp:useBean id="tempList" class="javaBeans.ProductList" scope="request"/>
            <h1>Shop</h1>
            

            <form action="cartServlet" method=post>
                        
                <input id="hidden_submit" type="submit" name=action value="View All Products for Sale" />
                <br /><br />
                
                <table id="categoryTable" cellpadding="5" border="1"  class="margin" style="float:left">
                     <tr>
                        
                         <td colspan="3"><h2>Filter by Product Category</h2></td>
                     </tr>
                     <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>ID</th>
                    </tr>
                    
                    <%
                        
                        if (tempList.getProductList().isEmpty() == false) {
                            List catList = tempList.getProdListInProductList(1).getProductList();
                            int cID = 0;
                            
                            for (int i=0; i < catList.size(); i++){
                                Category pb = (Category) catList.get(i);
                                cID = pb.getCategoryID();;
                            
                    %>
                    
                    <tr>
                        <td><%=pb.getCategoryName()%></td>
                        <td><%=pb.getCategoryDescription()%></td> 
                        <td>To filter, click the category by its ID:<a href="Shop.jsp"><input type="submit" name=filterByCategory value="<%=pb.getCategoryID()%>"></a></td>
                    </tr>
                    

                    <%      }
                        }
                    %>
                </table>
                
                <table id="productTable" cellpadding="5" border="1"  class="margin" style="float:top">
                    
                    <tr>                       
                          <td colspan="5"><h2>Products for Sale</h2></td>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <th># in Stock</th>
                        <th>Seller</th>
                        <th>Price</th>
                        <th>Add to Cart</th>
                    </tr>
                    
                    <%
                        
                        if (tempList.getProductList().isEmpty() == false) {
                            
                            int pID = 0;
                            int pQty = 0;
                            DecimalFormat decimalFormat = new DecimalFormat("#.00");
                            
                            List catList = tempList.getProdListInProductList(0).getProductList();
                            for (int i=0; i < catList.size(); i++){
                                Line ln = (Line) catList.get(i);
                                pID = ln.getLineProduct().getProductID();
                                pQty = ln.getLineQuantity();
                                
                                if (ln.getLineQuantity() > 0) {
                        %>
                            
            
                    
                    <tr>                      
                        <td>Click the button to view product details for 
                            <input type="submit" name=viewProductDetails value="<%=ln.getLineProduct().getProductName()%>"></td>
                        <td><input type="hidden" name=shopCurrentQty value="<%=pQty%>"><%=pQty%></td>
                        <td>Andy Anderson</td>
                        <td>$<%=decimalFormat.format(ln.getLineProduct().getProductPrice())%></td>
                        <td>
                            Click button to add <%=ln.getLineProduct().getProductName()%> with product ID: <input type="submit" name="addToCart" value="<%=pID%>"> to cart
                        </td>   
                    
                    </tr>
                    
                    <%
                                }
                            }
                        }
                    %>
                </table><br>   
            </form>
        </div>
        
        <div style="float:bottom" class="footer">
            <script type="text/javascript" src="footer.js"></script>
        </div>       
    </body>
</html>
