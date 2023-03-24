<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/fragments/fragmentHead.jsp"%>
<body>
	<%@include file="/WEB-INF/fragments/fragmentHeader.jsp"%>
	<section>

		<%@page import="fr.cdh.ldvh.bo.Aventurier"%>
		<%
		Aventurier heros = (Aventurier) session.getAttribute("heros");
		%>
		<%
		if (heros == null) {
		%>
			<%@include file="/WEB-INF/fragments/fragmentConnexion.jsp"%>
		<%
		} else {
		%>
			<%@include file="/WEB-INF/fragments/fragmentStats.jsp"%>
		<%
		} 
		%>

	</section>

	<%@include file="/WEB-INF/fragments/fragmentFooter.jsp"%>
</body>
</html>