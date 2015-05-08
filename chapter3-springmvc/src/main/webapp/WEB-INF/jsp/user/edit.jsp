<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
</head>
<body>
	<p><b>User</b></p>
	<sf:form method="POST" modelAttribute="user">
		<p>Username: <sf:input path="username" size="15" /><sf:errors path="username"/></p>
		<p>Email: <sf:input path="email" size="30" /><sf:errors path="email"/></p>
		<p>Password: <sf:input path="password" showPassword="true" size="30" /><sf:errors path="password"/></p>
		<p><input type="submit" value="保存" /></p>
	</sf:form>
</body>
</html>