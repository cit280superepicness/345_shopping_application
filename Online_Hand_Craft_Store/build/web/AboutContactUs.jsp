<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact / About</title>
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
            <h1>About</h1>
            <p>
                We are here for all of your craft related needs!<br>
                Proudly serving the craft community since 2016.
            </p>
            <h1>Contact</h1>
            <p>
                Justin Taormina & Renee Wise<br>
                128 Data St, Database, MI<br>
                contact@craftstore.com<br>
                (248)555-1234
            </p>
        </div>
        <div style="float:bottom" class="footer">
            <script type="text/javascript" src="footer.js"></script>
        </div>  
    </body>
</html>
