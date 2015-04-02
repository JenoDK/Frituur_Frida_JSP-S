<%-- Een welkom pagina --%> 
<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%> 
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html> 
<html lang='nl'>
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value='Frituur Frida' />
</c:import>
</head>
<head><title>Pizza Luigi</title></head>
<body><h1>We zijn ${openGesloten}</h1>
	<img src="images/${openGesloten}.png" alt="${openGesloten}"/>
	<dl>
	<dt>Straat</dt><dd>${adres.straat}</dd>
	<dt>huisnr</dt><dd>${adres.huisNr}</dd>
	<dt>gemeente</dt><dd>${adres.gemeente.naam} ${adres.gemeente.postcode}</dd>
	</dl>
</body>
</html>