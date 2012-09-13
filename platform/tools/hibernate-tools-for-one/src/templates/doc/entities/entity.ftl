<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>

<HEAD>

<TITLE>Hibernate Mappings - Entity Info</TITLE>

 <LINK REL ="stylesheet" TYPE="text/css" HREF="${docFileManager.getRef(docFile, docFileManager.getCssStylesDocFile())}" TITLE="Style">


</HEAD>

<BODY>

<H4>${class.packageName}</H4>
<H3>Entity : ${class.getShortName()} </H3>

<#if class.isInterface()>Interface Name : 
<#else>Class Name : 
</#if>
${class.qualifiedDeclarationName}
<BR>
<#if class.getMetaAsString("class-description")?has_content><HR>
<BR>
 ${class.getMetaAsString("class-description")}
<BR> 
</#if><HR>

<#if class.hasIdentifierProperty()><#assign propertyIdentifier = class.getIdentifierProperty()><P>
<A NAME="identifier_summary"></A>
<TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0">
	<THEAD>
		<TR>
			<TH COLSPAN="9" CLASS="MainTableHeading">
				Identifier Summary
			</TH>
		</TR>	
		<TR>
			<TH WIDTH="14%">
				Name
			</TH>
			<TH WIDTH="14%">
				Column
			</TH>
			<TH WIDTH="14%">
				Type
			</TH>	
			<TH WIDTH="58%">
				Description
			</TH>			
		</TR>		
	</THEAD>
	
<#if dochelper.getComponentPOJO(propertyIdentifier)?exists>
 <#assign compoclass = dochelper.getComponentPOJO(propertyIdentifier)>
 <#foreach property in compoclass.allPropertiesIterator>
   <#assign columnIterator = property.getValue().columnIterator>
   <#assign rowspan = property.getValue().getColumnSpan()>
		<TR>
			<TD WIDTH="14%" ROWSPAN="${rowspan}">
				<A HREF='#field_summary'>
					${property.name}
				</A>		
			</TD>
			

   <#if (rowspan>0)>
     <#assign column = columnIterator.next()>
     <#if column.isFormula()>
       			<TD WIDTH="14%" >
    				&nbsp;
    			</TD>   
     <#else>
       			<TD WIDTH="14%" >
    				<A HREF='#property_summary'>
                     ${column.getName()}
    				</A>
     </#if>			
                </TD>

   <#else>
      			<TD WIDTH="14%" >
    				&nbsp;
    			</TD>
   </#if>
  			<TD WIDTH="14%" ROWSPAN="${rowspan}">
			
   <#if dochelper.getComponentPOJO(property)?exists>
  				&nbsp; 
				<A HREF='${docFileManager.getRef(docFile, docFileManager.getEntityDocFileByDeclarationName(dochelper.getComponentPOJO(property)))}' TARGET="generalFrame">
					${compoclass.getJavaTypeName(property, jdk5)}
				</A>
   <#else>				
                &nbsp; ${compoclass.getJavaTypeName(property, jdk5)}
   </#if>				
			</TD>

			<TD WIDTH="44%" ROWSPAN="${rowspan}">
				&nbsp;
   <#if compoclass.hasFieldJavaDoc(property)?exists>
                ${compoclass.getFieldDescription(property)}
   </#if>
  			</TD>
		</TR>
   <#if (rowspan>1)>
    <#foreach column in columnIterator>
 		<TR>
			<TD>
				<A HREF='#property_summary'>
				${column.name}
				</A>
			</TD>
		</TR>
    </#foreach>
  </#if>
 </#foreach>	
<#else>		<TR>
			<TD WIDTH="14%">
				<A HREF='#field_summary'>
					${propertyIdentifier.name}
				</A>		
			</TD>
			<TD WIDTH="14%">
				Column
			</TD>
			<TD WIDTH="14%">
				&nbsp; ${class.getJavaTypeName(propertyIdentifier, jdk5)}
			</TD>	
			<TD WIDTH="58%">
				&nbsp;
				<#if class.hasFieldJavaDoc(propertyIdentifier)>
						${class.getFieldDescription(propertyIdentifier)}
				</#if>			</TD>			
			
		</TR>
</#if>	<TBODY>

	</TBODY>
</TABLE>
</#if>
<P>
<A NAME="property_summary"></A>
<TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0">
	<THEAD>
		<TR>
			<TH COLSPAN="9" CLASS="MainTableHeading">
				Property Summary
			</TH>
		</TR>
		<TR>
			<TH WIDTH="14%">
				Name
			</TH>
			<TH WIDTH="14%">
				Column
			</TH>
			<TH WIDTH="14%">
				Access
			</TH>	
			<TH WIDTH="14%">
				Type
			</TH>	
			<TH WIDTH="44%">
				Description
			</TH>			
		</TR>
	</THEAD>
	<TBODY>

<#foreach property in class.allPropertiesIterator>
<#assign columnIterator = property.getValue().columnIterator>
<#assign rowspan = property.getValue().getColumnSpan()>
		<TR>
			<TD WIDTH="14%" ROWSPAN="${rowspan}">
				<A HREF='#field_summary'>
					${property.name}
				</A>		
			</TD>
			

<#if (rowspan>0)>
<#assign column = columnIterator.next()>
   <#if column.isFormula()>    			<TD WIDTH="14%" >
    				&nbsp;
    			</TD>   
   <#else>    			<TD WIDTH="14%" >
    				<A HREF='#property_summary'>
    ${column.getName()}
    				</A>
   </#if>			</TD>

<#else>    			<TD WIDTH="14%" >
    				&nbsp;
    			</TD>
	
</#if>					
			<TD WIDTH="14%" ROWSPAN="${rowspan}">
				${property.getPropertyAccessorName()} (<A HREF='#property_summary'>get</A> / <A HREF='#property_summary'>set</A>)
			</TD>					
			
			<TD WIDTH="14%" ROWSPAN="${rowspan}">
			
<#if dochelper.getComponentPOJO(property)?exists>				&nbsp; 
				<A HREF='${docFileManager.getRef(docFile, docFileManager.getEntityDocFileByDeclarationName(dochelper.getComponentPOJO(property)))}' TARGET="generalFrame">
					${class.getJavaTypeName(property, jdk5)}
				</A>
<#else>				&nbsp; ${class.getJavaTypeName(property, jdk5)}
</#if>				
			</TD>

			<TD WIDTH="44%" ROWSPAN="${rowspan}">
				&nbsp;
<#if class.hasFieldJavaDoc(property)>${class.getFieldDescription(property)}
</#if>			</TD>
		</TR>
<#if (rowspan>1)><#foreach column in columnIterator>		<TR>
			<TD>
				<A HREF='#property_summary'>
				${column.name}
				</A>
			</TD>
		</TR>
</#foreach></#if></#foreach>
	</TBODY>
</TABLE>
<P>
 
</BODY>

</HTML>