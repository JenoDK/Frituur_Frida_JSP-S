<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value='Meisje Jongen' />
</c:import>

</head>

<body class="${cookie.meisjesjongens.value}">
	<vdab:menu/>
	<form method="post"><input type="submit" name="meisjesjongens"
		value="meisjes"> <input type="submit" name="meisjesjongens"
		value="jongens"></form>
</body>
</html>