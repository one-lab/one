<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>

<HEAD>

<TITLE>Hibernate Mappings - Entity Summary</TITLE>

<LINK REL ="stylesheet" TYPE="text/css" HREF="${docFileManager.getRef(docFile, docFileManager.getCssStylesDocFile())}" TITLE="Style">

</HEAD>

<BODY>

<H1>Hibernate Mapping Documentation</H1>

<#if graphsGenerated>
<p>
 <img src="entitygraph.png" usemap="#entitygraph"/>
  <map name="entitygraph">
  ${entitygrapharea}
 </map>
</p>
</#if>

<H2>List of Packages</H2>

<TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0">
	<THEAD>
		<TR>
			<TH COLSPAN="2" CLASS="MainTableHeading">
				Packages
			</TH>
		</TR>
	</THEAD>
	<TBODY>
<#foreach package in packageList>
		<TR>
			<TD>
				
				<A HREF='${docFileManager.getRef(docFile, docFileManager.getPackageSummaryDocFile(package))}' TARGET="generalFrame"><B>${package}</B></A>				
			</TD>
		</TR>
</#foreach>
	</TBODY>
</TABLE>


</BODY>