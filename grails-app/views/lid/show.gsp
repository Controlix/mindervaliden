
<%@ page import="be.strombeek.mindervaliden.Lid" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lid.label', default: 'Lid')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-lid" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-lid" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list lid">
			
				<g:if test="${lidInstance?.naam}">
				<li class="fieldcontain">
					<span id="naam-label" class="property-label"><g:message code="lid.naam.label" default="Naam" /></span>
					
						<span class="property-value" aria-labelledby="naam-label"><g:fieldValue bean="${lidInstance}" field="naam"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lidInstance?.voornaam}">
				<li class="fieldcontain">
					<span id="voornaam-label" class="property-label"><g:message code="lid.voornaam.label" default="Voornaam" /></span>
					
						<span class="property-value" aria-labelledby="voornaam-label"><g:fieldValue bean="${lidInstance}" field="voornaam"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lidInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="lid.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${lidInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lidInstance?.geboortedatum}">
				<li class="fieldcontain">
					<span id="geboortedatum-label" class="property-label"><g:message code="lid.geboortedatum.label" default="Geboortedatum" /></span>
					
						<span class="property-value" aria-labelledby="geboortedatum-label"><g:formatDate date="${lidInstance?.geboortedatum}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${lidInstance?.id}" />
					<g:link class="edit" action="edit" id="${lidInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					<g:link class="print" action="print" id="${lidInstance?.id}"><g:message code="default.button.print.label" default="Print" /></g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
