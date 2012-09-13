<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<f:view>
<f:loadBundle basename="messages" var="msg"/>
<#assign entityFinder = pojo.shortName.toLowerCase() + "Finder">
<#assign entitySelector = pojo.shortName.toLowerCase() + "Selector">
<#assign entityList = pojo.shortName.toLowerCase() + "List">
<#assign entityvar = pojo.shortName.toLowerCase()>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
  <title><h:outputText value="${'#'}{${entitySelector}.pageTitle}"/></title>
  <style type="text/css" media="all">
	@import "style/default/screen.css";
  </style>
 </head>
 <body>
 
  <h1><h:outputText value="${'#'}{${entitySelector}.pageTitle}"/></h1>
 
   <h:form>

     <div class="rvgSwitch">
       <h:selectOneMenu value="${'#'}{switcher.conversationIdOrOutcome}">
<#foreach entity in c2j.getPOJOIterator(cfg.getClassMappings())>
         <f:selectItem itemLabel="Create ${entity.shortName}" itemValue="edit${entity.shortName}"/>
</#foreach>
<#foreach entity in c2j.getPOJOIterator(cfg.getClassMappings())>
         <f:selectItem itemLabel="Find ${entity.shortName}" itemValue="find${entity.shortName}"/>
</#foreach>
         <f:selectItems value="${'#'}{switcher.selectItems}"/>
       </h:selectOneMenu>
       <h:commandButton action="${'#'}{switcher.select}" value="Switch"/>
     </div>
	
     <div class="rvgFind">
       <fieldset class="rvgFieldSet">
         <legend><h:outputText value="${'#'}{msg.${pojo.shortName}} ${'#'}{msg.SearchCriteria}"/></legend>
         
         <span class="rvgInputs">
<#foreach field in pojo.getAllPropertiesIterator()>
<#if !c2h.isCollection(field) && !c2h.isManyToOne(field)>
           <h:outputLabel value="${'#'}{msg.${pojo.shortName}_${field.name}}" for="${field.name}">
<#if field.value.typeName == "date">
             <h:inputText value="${'#'}{${entityFinder}.example.${field.name}}" id="${field.name}">
               <f:convertDateTime type="date" dateStyle="short"/>
             </h:inputText>
<#elseif field.value.typeName == "time">
             <h:inputText value="${'#'}{${entityFinder}.example.${field.name}}" id="${field.name}">
               <f:convertDateTime type="time"/>
             </h:inputText>
<#elseif field.value.typeName == "timestamp">
             <h:inputText value="${'#'}{${entityFinder}.example.${field.name}}" id="${field.name}">
               <f:convertDateTime type="both" dateStyle="short"/>
             </h:inputText>
<#elseif field.value.typeName == "boolean">
             <h:selectBooleanCheckbox value="${'#'}{${entityFinder}.example.${field.name}}" id="${field.name}"/>
<#else>
             <h:inputText value="${'#'}{${entityFinder}.example.${field.name}}" id="${field.name}"/>
</#if>
           </h:outputLabel>
</#if>
</#foreach>
           <h:outputLabel value="${'#'}{msg.PageSize}" for="pageSize">
             <h:inputText value="${'#'}{${entityFinder}.pageSize}" id="pageSize"/>
           </h:outputLabel>
         </span>
         
         <span class="rvgActions">
           <h:commandButton type="submit" value="${'#'}{msg.Clear}" action="${'#'}{${entityFinder}.clear}"/>
           <h:commandButton type="submit" value="${'#'}{msg.Find}" action="${'#'}{${entityFinder}.findFirstPage}"/>
	     </span>
	     
       </fieldset>
     </div>
	 
	 <div class="rvgResults">
     
	 <span class="rvgResultsNone">
	   <h:outputText value="${'#'}{msg.EnterSearchCriteria}" rendered="${'#'}{${entityList}==null}"/>
	   <h:outputText value="${'#'}{msg.No} ${'#'}{msg.${pojo.shortName}} ${'#'}{msg.MatchedSearchCriteria}" rendered="${'#'}{${entityList}.rowCount==0 && !${entityFinder}.previousPage}"/>
	 </span>
	 
	 <h:dataTable value="${'#'}{${entityList}}" var="${entityvar}" rendered="${'#'}{${entityList}.rowCount>0}" 
	       rowClasses="rvgRowOne,rvgRowTwo" headerClass="rvgOrder">
<#foreach property in pojo.getAllPropertiesIterator()>
<#if !c2h.isCollection(property) && !c2h.isManyToOne(property)>
		<h:column>
			<f:facet name="header">
			    <h:commandLink value="${'#'}{msg.${pojo.shortName}_${property.name}}" action="${'#'}{${entityFinder}.reorder}">
			       <f:param name="orderBy" value="${property.name}"/>
			    </h:commandLink>
			</f:facet>
			<h:outputText value="${'#'}{${entityvar}.${property.name}}"/>
		</h:column>
</#if>
<#if c2h.isManyToOne(property)>
<#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
		<h:column>
			<f:facet name="header">
			   <h:outputText value="${'#'}{msg.${pojo.shortName}_${property.name}} ${'#'}{msg.${parentPojo.shortName}_${parentPojo.identifierProperty.name}}"/>
			</f:facet>
			<h:outputText value="${'#'}{${entityvar}.${property.name}.${parentPojo.identifierProperty.name}}"/>
		</h:column>
</#if>
</#foreach>
		<h:column>
			<f:facet name="header"><h:outputText value="${'#'}{msg.Action}"/></f:facet>
			<h:commandButton action="${'#'}{${entitySelector}.select}" value="${'#'}{${entitySelector}.buttonLabel}"/>
		</h:column>
	 </h:dataTable>

	 <span class="rvgPage">
	   <h:commandButton action="${'#'}{${entityFinder}.findPreviousPage}" value="${'#'}{msg.PreviousPage}" disabled="${'#'}{!${entityFinder}.previousPage}" />
	   <h:commandButton action="${'#'}{${entityFinder}.findNextPage}" value="${'#'}{msg.NextPage}" disabled="${'#'}{!${entityFinder}.nextPage}" />
	   <h:commandButton action="edit${pojo.shortName}" value="${'#'}{msg.Create}" rendered="${'#'}{${entitySelector}.createEnabled}"/>
	   <h:commandButton action="${'#'}{${entitySelector}.selectNone}" value="${'#'}{msg.SelectNone}" rendered="${'#'}{!${entitySelector}.createEnabled}"/>
	   <h:commandButton action="${'#'}{${entitySelector}.cancel}" value="${'#'}{msg.Cancel}" rendered="${'#'}{!${entitySelector}.createEnabled}"/>
	 </span>
	 
	 </div>
	
   </h:form>
   
 </body>
</f:view>
</html>