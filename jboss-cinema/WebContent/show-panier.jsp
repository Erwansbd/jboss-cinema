<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${cpt} articles - (${prix}€)</h3>
<c:forEach items = "${films}" var="film">
<div>Le film ${film.titre} a été réalisé par ${film.realisateur}, est sortie le ${film.dateSortie} et a une durée de ${film.duree} min. <a href="RetirerFilmPanierServlet?id=${film.id }">Supprimer du panier</a></div>
</c:forEach>
<a href="index.jsp">Accueil</a> <a href="valider-panier.jsp">Valider votre commande</a>
</body>
</html>