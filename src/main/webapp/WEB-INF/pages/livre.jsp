<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/fragments/fragmentHead.jsp"%>
<body>
	<%@include file="/WEB-INF/fragments/fragmentHeader.jsp"%>
	<section>
		<%@page import="fr.cdh.ldvh.bo.Aventurier"%>
		<%@page import="fr.cdh.ldvh.bo.Page"%>
		<%@page import="fr.cdh.ldvh.bo.Creature"%>
		<%@page import="fr.cdh.ldvh.bo.Benefique"%>
		<%@page import="fr.cdh.ldvh.bo.Malefique"%>
		<%@page import="fr.cdh.ldvh.bo.Objet"%>
		<%
		Page currentPage = (Page) session.getAttribute("page");
		Aventurier heros = currentPage.getAventurier();
		session.setAttribute("heros", heros);
		%>

		<%@include file="/WEB-INF/fragments/fragmentStats.jsp"%>
		<%@include file="/WEB-INF/fragments/fragmentPage.jsp"%>

	</section>
	<%@include file="/WEB-INF/fragments/fragmentFooter.jsp"%>
</body>
</html>