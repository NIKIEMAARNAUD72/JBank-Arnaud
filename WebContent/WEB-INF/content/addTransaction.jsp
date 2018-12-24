
<jsp:directive.include file="/WEB-INF/content/header.jsp" />

<body>
<div id="content">
<div id="membre"><jsp:directive.include file="/WEB-INF/content/session.jsp" /></div>
<jsp:directive.include file="/WEB-INF/content/menu.jsp" />


<div id="form">
	<s:form action="operation" method="POST" style="text-align: center;">
		<s:label>Your account number is </s:label><s:property  value="#session.account.numero" />
		<s:textfield label="Your account" name="emetteur" type="text"></s:textfield>
		<s:textfield label="Money" name="montant" type="number" requiredLabel="true"></s:textfield>
		<s:textfield label="Other account" name="recepteur" type="text" requiredLabel="true"></s:textfield>
		<br>
	<s:submit value="Envoyer" style="text-align: center;"></s:submit>
		
	</s:form>
</div>

</div>
</body>
