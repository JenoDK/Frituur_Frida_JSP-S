<%@ page contentType='text/html' pageEncoding='UTF-8'%>
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
	<form method='post' id='spelForm'>
		<c:forEach var='friet' items='${alleFrieten}'>

			<button type='submit' name='volgnummer' value='${friet.key}'>
				<img src='<c:url value="/images/${friet.value}.png"/>'
					alt='${friet.value}' />
			</button>
		</c:forEach>
		<input type='submit' name ='volgnummer' value='Nieuw spel' id='nieuwspelknop'>
	</form>
	<c:if test='${not empty fout}'>
		<div class='fout'>${fout}</div>
	</c:if>
</body>
</html>