<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 <f:view>
 <f:loadBundle basename="messages" var="msg"/>
<#assign entityEditor = pojo.shortName.toLowerCase() + "Editor">  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
   <title>
     <h:outputText value="${'#'}{msg.Create} ${'#'}{msg.${pojo.shortName}}" rendered="${'#'}{${entityEditor}.new}"/>
     <h:outputText value="${'#'}{msg.Update}/${'#'}{msg.Delete} ${'#'}{msg.${pojo.shortName}}" rendered="${'#'}{!${entityEditor}.new}"/>
   </title>
   <style type="text/css" media="all">
    @import "style/default/screen.css";
   </style>
  </head>
  <body>
   <h:form>
   
     <h1>
         <h:outputText value="${'#'}{msg.Create} ${'#'}{msg.${pojo.shortName}}" rendered="${'#'}{${entityEditor}.new}"/>
         <h:outputText value="${'#'}{msg.Update}/${'#'}{msg.Delete} ${'#'}{msg.${pojo.shortName}}" rendered="${'#'}{!${entityEditor}.new}"/>
     </h1>
     
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
       <legend><h:outputText value="${'#'}{msg.${pojo.shortName}} ${'#'}{msg.Attributes}"/></legend>
       
       <span class="rvgInputs">
         <span class="rvgMessage"><h:messages globalOnly="true"/></span>
<#foreach field in pojo.getAllPropertiesIterator()>
<#if !c2h.isCollection(field) && !c2h.isManyToOne(field)>
         <h:outputLabel value="${'#'}{msg.${pojo.shortName}_${field.name}}" for="${field.name}">
<#if field.equals(pojo.identifierProperty)>
<#if field.value.identifierGeneratorStrategy == "assigned">
           <h:inputText value="${'#'}{${entityEditor}.instance.${field.name}}" id="${field.name}" disabled="${'#'}{!${entityEditor}.new}"/>
</#if>
<#else>
<#if field.value.typeName == "date">
           <h:inputText value="${'#'}{${entityEditor}.instance.${field.name}}" id="${field.name}">
               <f:convertDateTime type="date" dateStyle="short"/>
           </h:inputText>
<#elseif field.value.typeName == "time">
           <h:inputText value="${'#'}{${entityEditor}.instance.${field.name}}" id="${field.name}">
               <f:convertDateTime type="time"/>
           </h:inputText>
<#elseif field.value.typeName == "timestamp">
           <h:inputText value="${'#'}{${entityEditor}.instance.${field.name}}" id="${field.name}">
               <f:convertDateTime type="both" dateStyle="short"/>
           </h:inputText>
<#elseif field.value.typeName == "boolean">
           <h:selectBooleanCheckbox value="${'#'}{${entityEditor}.instance.${field.name}}" id="${field.name}"/>
<#else>
           <h:inputText value="${'#'}{${entityEditor}.instance.${field.name}}" id="${field.name}"/>
</#if>
</#if>
           <span class="rvgMessage"><h:message for="${field.name}"/></span>
         </h:outputLabel>
</#if>
</#foreach>
       </span>

       <span class="rvgActions">
         <h:commandButton type="submit" value="${'#'}{msg.Create}" action="${'#'}{${entityEditor}.create}" rendered="${'#'}{${entityEditor}.new}"/>
         <h:commandButton type="submit" value="${'#'}{msg.Update}" action="${'#'}{${entityEditor}.update}" rendered="${'#'}{!${entityEditor}.new}"/>
         <h:commandButton type="submit" value="${'#'}{msg.Delete}" action="${'#'}{${entityEditor}.delete}" rendered="${'#'}{!${entityEditor}.new}"/>
         <h:commandButton type="submit" value="${'#'}{msg.Done}" action="${'#'}{${entityEditor}.done}"/>
       </span>
     
     </fieldset>
     </div>
    
<#foreach property in pojo.getAllPropertiesIterator()>
<#if c2h.isManyToOne(property)>
<#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
        <div class="rvgResults">
           <h2><h:outputText value="${'#'}{msg.${pojo.shortName}_${property.name}}"/></h2>
           <h:outputText value="${'#'}{msg.No} ${'#'}{msg.${pojo.shortName}_${property.name}}" rendered="${'#'}{${entityEditor}.instance.${property.name} == null}"/>
           <h:dataTable var="parent" value="${'#'}{${entityEditor}.instance.${property.name}}" 
                   rendered="${'#'}{${entityEditor}.instance.${property.name} != null}"  rowClasses="rvgRowOne,rvgRowTwo">
<#foreach parentProperty in parentPojo.getAllPropertiesIterator()>
<#if !c2h.isCollection(parentProperty) && !c2h.isManyToOne(parentProperty)>
               <h:column>
                 <f:facet name="header"><h:outputText value="${'#'}{msg.${parentPojo.shortName}_${parentProperty.name}}"/></f:facet>
                 <h:outputText value="${'#'}{parent.${parentProperty.name}}"/>
               </h:column>
</#if>
<#if c2h.isManyToOne(parentProperty)>
<#assign parentParentPojo = c2j.getPOJOClass(cfg.getClassMapping(parentProperty.value.referencedEntityName))>
               <h:column>
		         <f:facet name="header">
		           <h:outputText value="${'#'}{msg.${parentPojo.shortName}_${parentProperty.name}} ${'#'}{msg.${parentParentPojo.shortName}_${parentParentPojo.identifierProperty.name}}"/>
		         </f:facet>
			     <h:outputText value="${'#'}{parent.${parentProperty.name}.${parentParentPojo.identifierProperty.name}}"/>
			   </h:column>
</#if>
</#foreach>
               <h:column>
                 <f:facet name="header"><h:outputText value="${'#'}{msg.Action}"/></f:facet>
                 <h:commandButton action="${'#'}{${entityEditor}.${property.name}}" value="${'#'}{msg.View} ${'#'}{msg.${parentPojo.shortName}}"/>
               </h:column>
           </h:dataTable>

          <span class="rvgPage">
            <h:commandButton type="submit" value="${'#'}{msg.Select} ${'#'}{msg.${parentPojo.shortName}}" action="${'#'}{${entityEditor}.select${parentPojo.shortName}}" />
          </span>

        </div>
        
</#if>
<#if c2h.isOneToManyCollection(property)>
        <div class="rvgResults">
          <h2><h:outputText value="${'#'}{msg.${pojo.shortName}_${property.name}}"/></h2>
          
<#assign childList = property.name + "List">
<#assign childPojo = c2j.getPOJOClass(property.value.element.associatedClass)>
          <h:outputText value="${'#'}{msg.No} ${'#'}{msg.${pojo.shortName}_${property.name}}" rendered="${'#'}{${childList}.rowCount==0}"/>
          <h:dataTable value="${'#'}{${childList}}" var="child" rendered="${'#'}{${childList}.rowCount>0}" rowClasses="rvgRowOne,rvgRowTwo">
<#foreach childProperty in childPojo.getAllPropertiesIterator()>
<#if !c2h.isCollection(childProperty) && !c2h.isManyToOne(childProperty)>
            <h:column>
              <f:facet name="header"><h:outputText value="${'#'}{msg.${childPojo.shortName}_${childProperty.name}}"/></f:facet>
              <h:outputText value="${'#'}{child.${childProperty.name}}"/>
            </h:column>
</#if>
</#foreach>
            <h:column>
              <f:facet name="header"><h:outputText value="${'#'}{msg.Action}"/></f:facet>
              <h:commandButton action="${'#'}{${entityEditor}.select${childPojo.shortName}}" value="${'#'}{msg.View} ${'#'}{msg.${childPojo.shortName}}"/>
<#if property.value.key.nullable>
<!--              <h:commandButton action="${'#'}{${entityEditor}.remove${childPojo.shortName}}" value="${'#'}{msg.Remove} ${'#'}{msg.${childPojo.shortName}}"/>  -->
</#if>
            </h:column>
          </h:dataTable>

          <span class="rvgPage">
            <h:commandButton type="submit" value="${'#'}{msg.Create} ${'#'}{msg.${childPojo.shortName}}" action="${'#'}{${entityEditor}.create${childPojo.shortName}}" 
              rendered="${'#'}{!${entityEditor}.new}"/>
          </span>

        </div>

</#if>
</#foreach>       
   </h:form>

  </body>
 </f:view>
</html>