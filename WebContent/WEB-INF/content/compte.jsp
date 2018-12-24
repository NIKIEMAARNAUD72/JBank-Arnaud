<jsp:directive.include file="/WEB-INF/content/header.jsp" />

<body>

<div id="content">

<div id="membre"><jsp:directive.include file="/WEB-INF/content/session.jsp" /></div>
<jsp:directive.include file="/WEB-INF/content/menu.jsp" />


<br>
<table style="border:2px; border-top:5px;">
	<tr>
	<th>PROFILE</th>
	<th>ACCOUNT</th>
	</tr>
	<tr><td>Your fisrt name :<s:property value="#session.user.nom"/></td><td></td></tr>
	<tr><td>Your last name :<s:property value="#session.user.prenom"/></td><td></td></tr>
	<tr><td>Your email" :<s:property value="#session.user.email"/></td>
	
	<td>Your account number :<s:property value="#session.account.numero"/></td></tr>
	
	<tr><td>Your phone number :<s:property value="#session.user.numero"/></td>
	
	<td>Your money :<s:property value="#session.account.solde"/></td></tr>
	
	<tr><td>Your birthday :<s:property value="#session.user.naissance"  /></td></tr>
	<tr><td>Your country :<s:property  value="#session.user.nationalite"/></td><td></td></tr>
	<tr><td>Your username :<s:property  value="#session.user.username"/></td><td></td></tr>
	
	</tr>
</table>



</div>
</body>


<jsp:directive.include file="/WEB-INF/content/footer.jsp" />