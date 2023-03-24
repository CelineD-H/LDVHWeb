<%@page import="fr.cdh.ldvh.bo.Objet"%>
<div class="statsbox">
	<div class ="stats">

		<h2><%=heros.toString()%></h2>
		
		<div class="statsinfos">
			<p>Santé : <%=heros.getPdV()%></p>
			<p>Attaque : <%=heros.getpAtt()%></p>
			<p>Défense : <%=heros.getpDef()%></p>
			<p><%=heros.getOr()%></p>
			<!-- <p><a href="">Besace =></a> -->
		</div>
	</div>
	<div class="besace">
		<h2>Besace <button id="btnAffiche">V</button></h2>
		<div class="content">
		<ul class="statsinfos">
			<% for (Objet o : heros.getBesace()) { %>
			<li><%= o.toString() %></li>
			<%
			}
			%>
		</ul>
		</div>
	</div>
</div>