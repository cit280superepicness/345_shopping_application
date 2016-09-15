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
            <li><a href="Login.jsp">Click here to Login or Logout</a></li>
            <li style="float:right"><a class="active" href="AboutContactUs.jsp">Contact / About</a></li>
        </ul>
        <div id="content">
            <h1>Sign Up</h1>
            <form action = "userServlet" method=post>
            <div id="wrap">
                <div id="left_col">
                    <h2>User Information</h2>
                    <label>Username: <input type="text" name="username"/></label>
                    <br><br>
                    <label>Password: <input type="password" name="password"/></label>
                    <br><br>
                    <label>Confirm Password: <input type="password" name="password"/></label>
                    <br><br>
                    <label>Are you a vendor?<input type="checkbox" name="is_vendor"/></label>
                </div>
                <div id="right_col">
                    <h2>Billing Information</h2>
                    <label>First name: <input type="text" name="fname"/></label>
                    <br><br>
                    <label>Initial: <input type="text" name="initial"/></label>
                    <br><br>
                    <label>Last name: <input type="text" name="lname"/></label>
                    <br><br>
                    <label>DOB: <input type="date" name="dob"></label>
                    <br><br>
                    <label>Credit Card Number: <input type="text" name="card_number"/></label>
                    <br><br>
                    <label>Address: <input type="text" name="address"/></label>
                    <br><br>
                    <label>City: <input type="text" name="city"/></label>
                    <br><br>
                    <label>State/Province: <input type="text" name="state_province"/></label>
                    <br><br>
                    <label>Country: <input type="text" name="country"/></label>
                    <br><br>
                    <label>ZIP: <input type="text" name="zip"/></label>
                    <br><br>
                    <label>Area Code: <input type="text" name="area_code"/></label>
                    <br><br>
                </div>
            </div>
                <input class="button" type="submit" value="Register" name="action" />
            </form>
        </div>
        <div style="float:bottom" class="footer">
            <script type="text/javascript" src="footer.js"></script>
        </div>  
    </body>
</html>
