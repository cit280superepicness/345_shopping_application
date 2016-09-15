<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import = "javaBeans.Product"%>
<%@page import = "javaBeans.InvoiceLine"%>
<%@page import = "java.util.*"%>
<%@page import = "java.text.DecimalFormat"%>


<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/css; charset=UTF-8">
        <title>Checkout</title>
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
            <jsp:useBean id="invoice" class="javaBeans.Invoice" scope="request"/>
            <h1>Checkout</h1>
            

            <form action="invoiceServlet" method=post>
                       
                <br /><br />
                
                <table cellpadding="5" class="margin" style="text-align:left">                  

                    <% 

                    if (invoice.getInvoiceList().isEmpty() == false) {

                    %>
                    <tr>
                        <th><h3 style="color:red">Payment successful! Invoice successfully added to database!</h3></th>
                    <%
                    }
                    %>
                    
                </table>         
                
            </form>
        </div>
        
        <div style="float:bottom" class="footer">
            <script type="text/javascript" src="footer.js"></script>
        </div>       
    </body>
</html>
