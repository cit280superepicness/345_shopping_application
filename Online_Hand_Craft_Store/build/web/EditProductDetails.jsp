<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

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
            <h1>Edit Product Details</h1>

            <form action="testServlet" method=post>               
                <table id="categoryTable" cellpadding="10" align="center">     
                    <tr>
                        <th>Quantity</th>
                        <td><input type="text" id="updateQty" name="updateQty" value=""/></td>
                       
                    </tr>
                    <tr>
                        <th>Price</th>
                        <td><input type="text" id="updatePrice" name="updatePrice" value=""/></td>                    
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td><textarea rows="4" cols="25" id="updateDescrip" name="updateDescrip"/></textarea></td>   
                    </tr>
      
                </table>  
                
                <br/><input type="submit" name=action value="Update" style="font-size:15px"/>
                <br /><br />
            </form>
                   
        </div>
        
        <div style="float:bottom" class="footer">
            <script type="text/javascript" src="footer.js"></script>
        </div>       
    </body>
</html>
