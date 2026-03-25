<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/hello.tld" prefix="h"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:page title="Company">
    <c:if test="${name != null}">
        <h1>
            <h:hello name="${name}"/>
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
</t:page>