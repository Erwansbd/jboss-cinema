<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validation panier</title>
</head>
<body>
	<h3>Merci de renseigner ces champs</h3>
	<form action="ValiderPanierServlet">
		<div>
			<label for="nom"></label> <input name="nom" id="nom" type="text"
				placeholder="Votre nom" required />
		</div>
		<div>
			<label for="prenom"></label> <input name="prenom" id="prenom"
				type="text" placeholder="Votre prénom" required />
		</div>
		<div>
			<label for="email"></label> <input name="email" id="email"
				type="email" placeholder="Votre email" required />
		</div>
		<input type="submit" value="Valider votre achat"/>
	</form>
</body>
</html>