<%@page import="fr.cdh.ldvh.bo.Page"%>
<%@page import="fr.cdh.ldvh.bo.Creature"%>
<%@page import="fr.cdh.ldvh.bo.Malefique"%>
<%@page import="fr.cdh.ldvh.bo.Benefique"%>
<div class="pagebox">
<div class="page">
	<h2><%= currentPage.toString() %></h2>
	<p><%= currentPage.getTexte() %></p>
	<% for (Creature c : currentPage.getCreatures()) {
		
		if (c instanceof Benefique && c.getName()!="null") {
			%>
			<p><%= ((Benefique) c).toString() %></p>
			<p><%= ((Benefique) c).getEnigme() %></p>
			<%
		} else if (c instanceof Malefique && c.getName()!=null) {
		%>
		<p><%= ((Malefique) c).toString() %></p>
		<%
		}
	}
		%>
	
	
	<% for (Page destination : currentPage.getDestinations()) {
		
		%> 
			<form action="<%=request.getContextPath()%>/AfficherPage">
				<input type="submit" value="<%= destination.getNumPage() %>" name="destination">
			</form>
		<%
	}
		%>
	</div>

</div>