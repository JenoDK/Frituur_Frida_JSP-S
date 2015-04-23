<%-- Een welkom pagina --%>
<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<fmt:setBundle basename='resourceBundles.teksten' />
<!doctype html>
<html lang='nl'>
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value='Frituur Frida' />
</c:import>
</head>
<head>
<title>Pizza Luigi</title>
</head>
<body>
	<vdab:menu />
	<c:choose>
		<c:when test='${openGesloten == "gesloten"}'>
			<h1>
				<fmt:message key='titelGesloten' />
			</h1>
			<img src="images/<fmt:message key='pictureGesloten' />.png"
				alt="${openGesloten}" />
		</c:when>
		<c:when test='${openGesloten == "open"}'>
			<h1>
				<fmt:message key='titelOpen' />
			</h1>
			<img src="images/<fmt:message key='pictureOpen' />.png"
				alt="${openGesloten}" />
		</c:when>
	</c:choose>
	<dl>
		<dt>
			<fmt:message key='straat' />
		</dt>
		<dd>${adres.straat}</dd>
		<dt>
			<fmt:message key='huisnr' />
		</dt>
		<dd>${adres.huisNr}</dd>
		<dt>
			<fmt:message key='gemeente' />
		</dt>
		<dd>${adres.gemeente.naam}${adres.gemeente.postcode}</dd>
	</dl>
</body>
</html>