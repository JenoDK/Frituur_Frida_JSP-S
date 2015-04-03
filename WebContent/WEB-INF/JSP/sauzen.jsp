<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value="Sauzen" />
</c:import>
</head>
<body>
	<c:import url='/WEB-INF/JSP/menu.jsp' />
	<h1>Sauzen</h1>
	<form method='post' id='verwijderform' action="<c:url value='/sauzen/verwijderen.htm'/>">
		<ul>
			<c:forEach var='saus' items='${sauzen}'>
				<li><label> <input type='checkbox' name='nummer'
						value='${saus.nummer }'>
				</label> ${saus.nummer}:<c:out value='${saus.naam}' /><br /> Ingrediënten:
					<c:forEach var='ingrediënten' items='${saus.ingrediënten}'
						varStatus='status'>					
				${ingrediënten}<c:if test='${not status.last}'>, </c:if>
					</c:forEach><br /> <img src="images/${saus.naam}.png" alt="${saus.naam} saus" />
				</li>
			</c:forEach>
	</ul> <input type='submit' value='Aangevinkte sauzen verwijderen'
		id='verwijderknop'>
</form>

</body>
</html>