<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <form action="servlet-add" method="GET">
        <table id="crawler">
            <tr>
                <td>choose url</td>
                <td><input type="text" name="url"/></td>
                <td><input type="submit" value="add"/></td>
                <td><input type="button" value="crawl"/></td>
            </tr>
        </table>
    </form>
</div>
<a href="/search.jsp">Search</a>
</body>
</html>