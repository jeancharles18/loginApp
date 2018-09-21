<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
    <title>Login</title>
</head>
<body>
   <form action="login" method="post">
       Username   <input type="text" name="username" value="${cookie.user.value}"/> <br/>
       Password  <input type="password" name="password"/> <br/>
   <input type="submit" value="Login"/> <br/>
       Remember me <input type="checkbox"    <c:if test="${cookie.containsKey('user')}">checked </c:if>  name="remember" value="yes"/>
   </form>

   <span style="color:#ff0000" > ${error} </span>

</body>
</html>
