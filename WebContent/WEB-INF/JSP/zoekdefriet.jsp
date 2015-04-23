<%@ page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang="nl">
<head>
<c:import url="head.jsp">
	<c:param name='title' value='Zoek de friet' />
</c:import>
</head>
<body>
<vdab:menu/>
	<h1>Zoek de friet</h1>
	<form method='post' action='<c:url value=""/>'>
		<c:forEach items='${zoekDeFrietSpel.deurIsOpen}' var='deurIsOpen'
			varStatus="status">
			<button type='submit' name='volgnummer' value='${status.index}'>
				<c:choose>
					<c:when test='${deurIsOpen}'>
						<c:choose>
							<c:when test='${status.index == zoekDeFrietSpel.deurMetFriet}'>
								<img src='<c:url value="/images/gevonden.png"/>' alt='gevonden' />
							</c:when>
							<c:otherwise>
								<img src='<c:url value="/images/deuropen.png"/>' alt='deur open' />
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<img src='<c:url value="/images/deurtoe.png"/>' alt='deur toe' />
					</c:otherwise>
				</c:choose>
			</button>
		</c:forEach>
	
		<input type="submit" name="nieuwSpel" value="Nieuw spel">
	</form>
</body>
</html>