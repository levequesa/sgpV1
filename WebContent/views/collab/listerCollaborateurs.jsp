<%@page import="wsc.sgpV1.entite.Collaborateur"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.taglibs.standard.tag.el.core.ForEachTag"%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>sgpV1 - appli</title>
	</head>
	<body>
	
		<h1>les collaborateurs</h1>
		<ul>
			<%
				List<Collaborateur> listCollaborateurs= (List<Collaborateur>) request.getAttribute("listCollab");
				for (Collaborateur c : listCollaborateurs) {
			%>
					<li> <%=c.getNom()%></li>
			<%
				}
			%>	
		</ul>

	</body>
</html>