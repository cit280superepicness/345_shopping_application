<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
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
            
            table   {
                align: center;
            }
            
            label   {
                text-align: left;
            }
            
            #content  {
                text-align: center;
            }
            
            .active {
                background-color: #357EC7;
            }
            
            .button {
                position: relative;
                align: center;
            }
            
            #wrap {
                width:700px;
                height:500px;
                margin:0 auto;
                
            }
            #left_col {
                float:left;
                width:350px;
                text-align: right;
            }
            #right_col {
                float:right;
                width:350px;
                text-align: right;
            }

        </style>

    </head>
    <body>
        <ul>
            <li><a href="Login.jsp">Login</a></li>
            <li><a href="Shop.jsp">Shop</a></li>
            <li><a href="ManageInventory.jsp">Manage Inventory</a></li>
            <li><a href="ViewShoppingCart.jsp">View Cart</a></li>
            <li style="float:right"><a class="active" href="AboutContactUs.jsp">Contact / About</a></li>
        </ul>
            
        <form action = "userServlet" method=post>
            <h1>Sign Up</h1>
            
            <div id="wrap">
                <div id="left_col">
                    <h2>User Information</h2>
                    <label>Username: <input type="text" name="username" value="asd"/></label>
                    <br><br>
                    <label>Password: <input type="password" name="password" value="asd"/></label>
                    <br><br>
                    <label>Confirm Password: <input type="password" name="confirm" value="asd"/></label>
                    <br><br>
                    <label>Are you a vendor?<input type="checkbox" name="is_vendor"/></label>
                </div>
                <div id="right_col">
                    <h2>Billing Information</h2>
                    <label>First name: <input type="text" name="fname" value="asd"/></label>
                    <br><br>
                    <label>Initial: <input type="text" name="initial" value="asd"/></label>
                    <br><br>
                    <label>Last name: <input type="text" name="lname" value="asd"/></label>
                    <br><br>
                    <label>DOB: <input type="date" name="dob" value="01/25/1993"></label>
                    <br><br>
                    <label>Credit Card Number: <input type="text" name="card_number" value="asd"/></label>
                    <br><br>
                    <label>Address: <input type="text" name="address" value="asd"/></label>
                    <br><br>
                    <label>City: <input type="text" name="city" value="asd"/></label>
                    <br><br>
                    <label>State/Province: <input type="text" name="state_province" value="as"/></label>
                    <br><br>
                    <label>Country: <input type="text" name="country" value="asd"/></label>
                    <br><br>
                    <label>Phone: <input type="text" name="phone" value="48357"/></label>
                    <br><br>
                    <label>ZIP: <input type="text" name="zip" value="123"/></label>
                    <br><br>
                    <label>Area Code: <input type="text" name="area_code" value="12345"/></label>
                    <br><br>
                </div>
            </div>
                <input class="button" type="submit" value="Register" name="action" />
        </form>    
        
        <div style="float:bottom" class="footer">
            <script type="text/javascript" src="footer.js"></script>
        </div>  
    </body>
</html>
