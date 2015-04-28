<%@ page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang="nl">
<head>
<c:import url="head.jsp">
	<c:param name='title' value='Spelbord' />
</c:import>
<link rel='stylesheet' href='<c:url value="/css/blackjack.css"/>'>
<link rel='stylesheet' href='<c:url value="/css/style.css"/>'>
</head>
<body>
	<vdab:menu />
	<img id='carddeckBackground'
	src='<c:url value="/images/blackjack/b1fv.png"/>' alt='Card deck' />
	<form id='gameForm' method='post' action='<c:url value=""/>'><div
		id='gameMenu'><input type="submit" name="newGame"
			value="New game"> <c:if test='${empty gameMsg}'>
				<input type="submit" name="newCard" value="New card">
				<input type="submit" name="stop" value="Stop">
			</c:if></div>
		<h2>Your score: ${score}</h2>
		<h2>Game ${game}</h2> <input type="submit" name="resetGame"
		value="Reset Game counter and score"></form>

	<div id='cardsMenu'>
		<ul id="cards">
			<c:forEach var='card' items='${cards}'>
				<li><img id='card' src="images/blackjack/${card}.png"
					alt="${card}" /> <c:if
						test="${card == '1' or card == '2' or card == '3' or card == '4'}">
						<form id='gameForm' method='post' action='<c:url value=""/>'><input
							type="submit" name="changeValue" value="Change value of ace"></form>
					</c:if></li>
			</c:forEach>
	</ul>
		<h2>Value of hand: ${value}</h2>
</div>
	<br />
	<c:if test='${not empty gameMsg}'>
		<h2>${gameMsg}</h2>
	</c:if>
</body>
</html>