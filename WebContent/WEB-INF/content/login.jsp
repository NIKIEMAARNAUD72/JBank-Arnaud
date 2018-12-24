
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="html" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
* {
	margin:0px;
	padding:4px;
}

body {
	background-color:#000000;
	font-family:arial;
}

#content {
	width:500px;
	background-color:#DDDDDD;
	margin:120px auto;
	text-align:center;
	border-radius:10px;
	position:relative;
	-webkit-border-radius:10px;
	-moz-border-radius:50px;
	padding:30px;
}


h1 {
	background-color:#DDDDDD;
	padding-bottom:20px;
}

label{
	display:block;
	float:left;
	width:120px;
	/*position:absolute;*/
	left:1px;
}

input {
	border:1px solid #000000;
	border-radius:5px;
	-webkit-border-radius:5px;
	-moz-border-radius:5px;
	width:200px;
	padding-left:10px;
	/*margin-left:1px;*/
	text-align:center;
}

input[type="submit"] {
	background-color:#000000;
	color:#FFFFFF;
	width:100px;
	margin-left:120px;
}
</style>

<title>Welcome to JBank</title>
</head>



<body>


<div id="content">

<h1 style="color: blue; text-align: center;" >Welcome to JBank</h1>
<h3 style="color: blue; text-align: center;">Login</h3>
<s:form action="verified" method="POST">
	<s:textfield name="username" label="Username" type="text" requiredLabel="true"></s:textfield>
	<s:textfield name="password" label="Password" type="password" requiredLabel="true" ></s:textfield>
	<s:submit value="Login"></s:submit>
</s:form>
<br>
<s:a action="cancel" style="text-align: center;">BACK</s:a>
<br><br>Copyright � <strong>JBank</strong> 2018 �

</div>

</body>

<jsp:directive.include file="/WEB-INF/content/footer.jsp" />
