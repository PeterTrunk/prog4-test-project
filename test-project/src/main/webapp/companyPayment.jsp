<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test project</title>
</head>
<body>
<%--    <%--%>
<%--        if(request.getAttribute("name") != null--%>
<%--            && !request.getAttribute("name").equals("") ) {--%>
<%--    %>--%>
<%--    <h1>Hello ${name}</h1>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>
    <c:if test="${name != null}">
        <h1>
            <c:out value="Hello ${name}"/>
        </h1>
    </c:if>
    <form method="post">
        <table>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name"/>
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td>
                    <input type="text" address="address"/>
                </td>
            </tr>
            <tr>
                <td>Tax Number</td>
                <td>
                    <input type="text" taxNumber="taxNumber"/>
                </td>
            </tr>
        </table>
        <input type="submit"/>
    </form>
</body>
</html>