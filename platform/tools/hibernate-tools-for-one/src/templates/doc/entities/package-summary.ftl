<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>

<HEAD>

<TITLE>Hibernate Mappings - Entity Summary</TITLE>

<LINK REL ="stylesheet" TYPE="text/css" HREF="${docFileManager.getRef(docFile, docFileManager.getCssStylesDocFile())}" TITLE="Style">

</HEAD>

<BODY>

<H1>Hibernate Mapping Documentation</H1>

<H2>Package ${package}</H2>

<P>
<#if (classList.size()>0)>
<TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0">
	<THEAD>
		<TR>
			<TH COLSPAN="2" CLASS="MainTableHeading">
				Entities Summary
			</TH>
		</TR>
	</THEAD>
	<TBODY>
<#foreach class in classList>
		<TR>
			<TD WIDTH="30%">
				<A HREF='${docFileManager.getRef(docFile, docFileManager.getEntityDocFile(class))}' TARGET="generalFrame">
					<B>${class.declarationName}</B>
				</A>
			</TD>
			<TD WIDTH="70%">

&nbsp;${class.getMetaAsString("class-description")}

			</TD>

		</TR>
</#foreach>
	</TBODY>
</TABLE>
</#if>
</BODY>