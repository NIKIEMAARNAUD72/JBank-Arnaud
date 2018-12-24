
<jsp:directive.include file="/WEB-INF/content/header.jsp" />

<body>

	<s:form action="registerClient" method="POST" >
		<s:textfield label="Your fisrt name" name="nom" type="text"></s:textfield>
		<s:textfield label="Your last name" name="prenom" type="text"></s:textfield>
		<s:textfield label="Your email" name="email" type="email"></s:textfield>
		<s:textfield label="Your phone number" name="numero" type="number"></s:textfield>
		<s:textfield label="Your birthday" name="naissance" type="text" />
		<s:textfield label="Your country" name="nationalite" type="text"></s:textfield>
		<s:textfield label="Your username" name="username" type="text"></s:textfield>
		<s:submit value="Submit"></s:submit>
	</s:form>


</body>

<jsp:directive.include file="/WEB-INF/content/footer.jsp" />
