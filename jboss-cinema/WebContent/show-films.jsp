<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des films</title>
</head>
<body>
<h1>Liste de nos films</h1>
<c:forEach items = "${films}" var="film">
<div>Le film ${film.titre} a été réalisé par ${film.realisateur}, est sortie le ${film.dateSortie} et a une durée de ${film.duree} min. Ce film est au prix de ${film.prixHT * 1.1} €. <a href="AjouterAuPanierServlet?id=${film.id}">Ajouter au panier</a></div>
</c:forEach>
<a href="index.jsp">Accueil</a>
<a href="AfficherPanierServlet">Afficher votre panier</a>
</body>
</html>