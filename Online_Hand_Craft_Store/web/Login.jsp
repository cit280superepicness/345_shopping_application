<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "javaBeans.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
            <li style="float:right"><a class="active" href="AboutContactUs.jsp">Contact / About</a></li>
        </ul>
        <div id="content">
            
            <jsp:useBean id="user" class="javaBeans.User" scope="request"/>
            <h1>Login</h1>
            <form action = "userServlet" method=post>
                
                
                <%
                    User u = user;
                    if(u.getLoggedIn() == false) {
                        
                    
                %>
                <label>Username: <input type="text" name="username"/></label>
                <br><br>
                <label>Password: <input type="password" name="password"/></label>
                <br><br>
                <label>Are you a vendor?<input type="checkbox" name="is_vendor"/></label>
                <br><br>
                <input type=submit name=action value="Login">
                <br><br>
                <a href="SignUp.jsp">Not registered? Sign up here!</a>
                <%
                    
                    }
                    else {
                %>
                
                <br><br>
                <input type=submit name=action value="Logout">
                <br><br>
                    
                <%
                    }
                %>
            </form>
        </div>
        <div style="float:bottom" class="footer">
            <script type="text/javascript" src="footer.js"></script>
        </div>  
    </body>
</html>
