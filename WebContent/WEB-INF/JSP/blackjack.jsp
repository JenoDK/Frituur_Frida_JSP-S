<%@ page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang="nl">
<head>
<c:import url="head.jsp">
	<c:param name='title' value='Spelbord' />
</c:import>
<link rel='stylesheet' href='<c:url value="/css/style.css"/>'>
</head>
<body>
	<vdab:menu/>
	
	<form method='post' action='<c:url value=""/>'>
		<input type="submit" name="newGame" value="Nieuw spel">
		<input type="submit" name="newCard" value="Nieuwe kaart">
		<input type="submit" name="stop" value="Stop">
	</form>
</body>
</html>