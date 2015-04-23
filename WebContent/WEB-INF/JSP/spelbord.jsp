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
	<h2>Plaats de bal op de middenstip! (een beetje rechts ervan)</h2>
	<form method='post' action='<c:url value=""/>'>
		<input type="submit" name="nieuwSpel" value="Nieuw spel">
		<input type="submit" name="left" value="left">
		<input type="submit" name="right" value="right">
		<input type="submit" name="up" value="up">
		<input type="submit" name="down" value="down">
	</form>
	<c:if test='${not empty bericht}'>
		<h2>${bericht}</h2>
	</c:if>	
	<div id="field">
		<img src='<c:url value="/images/bal.png"/>' alt='bal' style='margin-left:<c:out value="${spelbord.coordX}"/>em;margin-top:<c:out value="${spelbord.coordY}"/>em;width:5%'/>
	</div>
	
</body>
</html>