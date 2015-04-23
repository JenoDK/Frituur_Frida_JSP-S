<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value='Ingredi&#235;nten' />
</c:import>
</head>
<body>
	<vdab:menu/>
	<h1>Sauzen met ingrdiënt</h1>
	<form>
		<label> Ingrediënt: <input name='ingrediënt'
			value='${param.ingrediënt}' type='text' min='0' autofocus>
		</label> <input type='submit' value='Zoeken'>
	</form>
	<c:if test='${not empty sausIngrediënten}'>
		<ul class='zebra'>
			<c:forEach var='saus' items='${sausIngrediënten}'>
				<li><c:out value='${saus.naam}' />:
					<c:forEach
						var='ingrediënten' items='${saus.ingrediënten}' varStatus='status'>					
					${ingrediënten}<c:if test='${not status.last}'>, </c:if>
					</c:forEach></li>
			</c:forEach>
		</ul>
	</c:if>
	<c:if test='${not empty fout}'>
		<h2>${fout}</h2>
	</c:if>	
</body>
</html>