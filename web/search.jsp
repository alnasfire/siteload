<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <form action="servlet-parameters" method="GET">
        <table id="search">
            <tr>
                <td>search</td>
                <td><input type="text" name="url"/></td>
                <td><input type="submit" name="search" value="GO"/></td>
            </tr>
            <tr>
                <td></td>
                <td align="center">results</td>
            </tr>
            <tr>
                <td>
                    <div id="results"></div>
                </td>
            </tr>
        </table>
    </form>
</div>
<a href="/index.jsp">Home</a>
</body>
</html>