<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>

<HEAD>

<TITLE>Hibernate Mappings - Entity List</TITLE>

<LINK REL ="stylesheet" TYPE="text/css" HREF="${docFileManager.getRef(docFile, docFileManager.getCssStylesDocFile())}" TITLE="Style">

</HEAD>

<BODY>

<TABLE BORDER="0" WIDTH="100%" SUMMARY="">
	<TR>
		<TD NOWRAP>
			<FONT CLASS="ListTitleFont">
				<A HREF='${docFileManager.getRef(docFile, docFileManager.getPackageSummaryDocFile(title))}' TARGET="generalFrame">${title}</A>
			</FONT>
			<BR>
		</TD>
	</TR>	
<#if (classList.size()>0)>
	<TR>
		<TD>
			Entities
			<BR>
<#foreach class in classList>
				<A HREF='${docFileManager.getRef(docFile, docFileManager.getEntityDocFile(class))}' TARGET="generalFrame">${class.declarationName}</A>
								
			<BR>
</#foreach>
		</TD>
	</TR>
</#if>

</TABLE>

</BODY>

</HTML>