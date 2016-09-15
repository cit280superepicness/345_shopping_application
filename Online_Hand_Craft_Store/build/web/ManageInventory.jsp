<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "javaBeans.Product"%>
<%@page import = "javaBeans.Category"%>
<%@page import = "java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Inventory</title>
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
            <jsp:useBean id="tempList" class="javaBeans.ProductListTest" scope="request"/>
            <h1>Manage Inventory</h1>    
        
            <form action="testServlet" method=post>
                <input id="hidden_submit" type="submit" name=action value="View All Products in Inventory" /><br><br>
                
                <table id="manageInventory" cellpadding="5" border="1"  class="margin" style="text-align:center">
                    <tr>
                        <td></td>
                        <td><b>Product</b></td>
                        <td><b>Category</b></td>
                        <td><b>Quantity</b></td>
                    </tr>
                    
                    <%
                        
                        if (tempList.getProductListTest().isEmpty() == false) {

                            List invList = tempList.getProdListInProductList(0).getProductListTest();
                            for (int i=0; i < invList.size(); i++){
                                Product pb = (Product) invList.get(i);
                            
                    %>
                   
                   
                    <tr>
                        <td><input type="button" name=action value="Edit"></td> <!-- ***SEND TO EDIT PRODUCT PAGE*** -->
                        <td><%=pb.getProductName()%></td>
                        <td><%=pb.getProductCategoryID()%></td>
                        <td>1</td>
                    </tr>
                    
                    <%      }
                        }
                    %>
                </table>
                
            </form>
            
            <input type="button" name="add_product" value="Add Product"/>&nbsp;&nbsp;
            <input type="button" name="delete_product" value="Delete Product"/>
 
        </div>  
        
        <div style="float:bottom" class="footer">
            <script type="text/javascript" src="footer.js"></script>
        </div>    
    </body>
</html>
