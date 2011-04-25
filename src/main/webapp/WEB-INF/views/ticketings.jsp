<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Result</title>
    </head>
    <body>
        <table>
            <tr><th>Ticketings</th></tr>
                <c:forEach items="${ticketings}" var="x">
                <tr><td><c:out value="${x.id}"/></td>
                    <td><c:out value="${x.nbTickets}"/></td>
                    <td><c:out value="${x.band}"/></td></tr>
                </c:forEach>
        </table>

    </body>
</html>