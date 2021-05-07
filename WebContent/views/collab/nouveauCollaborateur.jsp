<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
		<title>sgpV1 - App</title>
	</head>
	<body>
		<h1>Nouveau collaborateur</h1>
		<form method="post" action="nouveauCollaborateur">
			<label for="nom">Nom : </label>
			<input type="text" id="nom" name="nom">${collab.nom} </input>
			<br>
			<label for="prenom">Prenom : </label>
			<input type="text" id="prenom" name="prenom" />
			<br>
			<label for="dateDeNaissance">Date De Naissance : </label>
			<input type="text" id="dateDeNaissance" name="dateDeNaissance" />
			<br>
			<label for="adresse">Adresse : </label>
			<input type="text" id="adresse" name="adresse" />
			<br>
			<label for="numDeSecu">numéro de securité sociale : </label>
			<input type="text" id="numDeSecu" name="numDeSecu" />
			<br>
			<input type="submit" value="créér" />
		</form>
	
	</body>
</html>