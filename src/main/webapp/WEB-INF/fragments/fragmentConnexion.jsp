<div class="connexion">
<h2>Bienvenue Aventurier en herbe !!</h2>
	<form action="<%=request.getContextPath()%>/Connexion" method="post">
		<label for="pseudo">Comment voulez-vous appeler votre Héros ?</label>
		<input type="text" id="pseudo" name="pseudo">
		<input type="submit" value="Valider" name="co">
	</form>
</div>