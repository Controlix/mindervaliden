<%@ page import="be.strombeek.mindervaliden.Lid" %>



<div class="fieldcontain ${hasErrors(bean: lidInstance, field: 'naam', 'error')} required">
	<label for="naam">
		<g:message code="lid.naam.label" default="Naam" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="naam" maxlength="50" required="" value="${lidInstance?.naam}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lidInstance, field: 'voornaam', 'error')} ">
	<label for="voornaam">
		<g:message code="lid.voornaam.label" default="Voornaam" />
		
	</label>
	<g:textField name="voornaam" maxlength="50" value="${lidInstance?.voornaam}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lidInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="lid.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${lidInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lidInstance, field: 'geboortedatum', 'error')} ">
	<label for="geboortedatum">
		<g:message code="lid.geboortedatum.label" default="Geboortedatum" />
		
	</label>
	<g:datePicker name="geboortedatum" precision="day"  value="${lidInstance?.geboortedatum}" default="none" noSelection="['': '']" />
</div>

