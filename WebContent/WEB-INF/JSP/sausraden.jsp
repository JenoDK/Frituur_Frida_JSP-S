
<%@ page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang="nl">
<head>
<c:import url="head.jsp">
	<c:param name='title' value='Zoek de friet' />
</c:import>
</head>
<body>
	<c:import url='/WEB-INF/JSP/menu.jsp' />
	Te raden saus:
	<c:forEach items='${sausRadenSpel.teradenSausChar}'
		var='teradenSausChar' varStatus="status">
		${teradenSausChar}
	</c:forEach>
	
	<form method='post' action='<c:url value=""/>'>
		<label>Letter: 
			<input name='letter' type='text' size='1' autocomplete='off' autofocus required>
		</label>
		<input type="submit" name="raden" value="Raden">
		Fouten: '${sausRadenSpel.fouten}'
	</form> 
	<form method='post' action='<c:url value=""/>'>
		<input type="submit" name="nieuwSpel" value="Nieuw spel">
	</form>
	<c:if test='${sausRadenSpel.fouten == 10 || sausRadenSpel.geraden}'>
		<h2>${sausRadenSpel.teradenSausNaam}</h2>
	</c:if>
	<img src='<c:url value="/images/${sausRadenSpel.fouten}.png"/>' alt='galgje' />
	
</body>
</html>
