
<jsp:directive.include file="/WEB-INF/content/header.jsp" />

<body>
<div id="content">

<h3 style="color: blue; text-align: center;" >Welcome to JBank</h3>
<br>
<jsp:directive.include file="/WEB-INF/content/menu.jsp" />
<h3 style="text-align: center;" >Registration</h3>
<div id="form">
	<s:form action="registerClient" method="POST" style="text-align: center;">
		<s:textfield label="Your fisrt name" name="nom" type="text" requiredLabel="true"></s:textfield>
		<s:textfield label="Your last name" name="prenom" type="text" requiredLabel="true"></s:textfield>
		<s:textfield label="Your email" name="email" type="email" requiredLabel="true"></s:textfield>
		<s:textfield label="Your phone number" name="numero" type="number" requiredLabel="true"></s:textfield>
		<s:textfield label="Your birthday" name="naissance" type="text" requiredLabel="true"  ></s:textfield>
		<s:textfield label="Your country" name="nationalite" type="text" requiredLabel="true"></s:textfield>
		<s:textfield label="Your username" name="username" type="text" requiredLabel="true"></s:textfield>
		<br>
	<s:submit value="Submit" style="text-align: center;"></s:submit>
		
	</s:form>
</div>
<s:a action="cancel" style="text-align: center;">BACK</s:a>

</div>
</body>

<jsp:directive.include file="/WEB-INF/content/footer.jsp" />
