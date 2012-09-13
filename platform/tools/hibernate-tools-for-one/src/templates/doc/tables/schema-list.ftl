<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>

<HEAD>

<TITLE>Hibernate Mappings - Schema List</TITLE>

<LINK REL ="stylesheet" TYPE="text/css" HREF="${docFileManager.getRef(docFile, docFileManager.getCssStylesDocFile())}" TITLE="Style">

</HEAD>

<BODY>

<TABLE BORDER="0" WIDTH="100%" SUMMARY="">
	<TR>
		<TD NOWRAP>
			<FONT CLASS="ListTitleFont">
				${title}
			</FONT>
			<BR>
				<A HREF="${docFileManager.getRef(docFile, docFileManager.getAllTablesDocFile())}" TARGET="tablesFrame">all tables</A>
			<BR>
<#foreach schema in schemaList>
				<A HREF="${docFileManager.getRef(docFile, docFileManager.getSchemaTableListDocFile(schema))}" TARGET="tablesFrame">${schema}</A>
			<BR>
</#foreach>
		</TD>
	</TR>
</TABLE>

</BODY>

</HTML>