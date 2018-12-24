
<h1 style="color: blue; text-align: center;">Welcome to JBank</h1>

	<s:if test="#session.user">

Bienvenue <b><s:property value="#session.user.nom" />
		<s:property value="#session.user.prenom" /></b>
<br>Solde : <b><s:property value="#session.account.solde" /></b>
		<br><s:a action="logout" id="membre" >Logout</s:a>

	</s:if>

	<s:else>

		<s:a action="login">Login Required</s:a>

	</s:else>
