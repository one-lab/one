<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>

<HEAD>

<TITLE>Hibernate Mappings - Table Summary</TITLE>

<LINK REL ="stylesheet" TYPE="text/css" HREF="${docFileManager.getRef(docFile, docFileManager.getCssStylesDocFile())}" TITLE="Style">

</HEAD>

<BODY>

<H1>Hibernate Mapping Documentation</H1>

<#if graphsGenerated>
<p>
 <img src="tablegraph.png" usemap="#tablegraph"/>
 <map name="tablegraph">
  ${tablegrapharea}
 </map>
</p>
</#if>

<H2>List of Tables by Schema</H2>

<#foreach schema in dochelper.tablesBySchema.keySet()>
<TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0">
	<THEAD>
		<TR>
			<TH COLSPAN="2" CLASS="MainTableHeading">
				${schema}
			</TH>
		</TR>
	</THEAD>
	<TBODY>
<#foreach table in dochelper.getTables(schema)>
		<TR>
			<TD>
				<A HREF='${docFileManager.getRef(docFile, docFileManager.getTableDocFile(table))}' TARGET="generalFrame">
					<B>${table.name}</B>
				</A>
			</TD>
			<TD>
				<TABLE BORDER="1" CELLPADDING="3" CELLSPACING="0">
					<THEAD>
						<TR>
							<TH WIDTH="50%">
								Name
							</TH>
							<TH WIDTH="30%">
								SQL Type
							</TH>
							<TH WIDTH="15%">
								Nullable
							</TH>
							<TH WIDTH="15%">
								Unique
							</TH>
						</TR>
					</THEAD>
					<TBODY>
<#foreach column in table.columnIterator>
						<TR>
							<TD>
								<A HREF='${docFileManager.getRef(docFile, docFileManager.getTableDocFile(table))}#column_detail_${column.name}' TARGET="generalFrame">
									${column.name}
								</A>
							</TD>
							<TD>
								${dochelper.getSQLTypeName(column)}
							</TD>
							<TD ALIGN="CENTER">
								${column.nullable?string}
							</TD>
							<TD ALIGN="CENTER">
								${column.unique?string}
							</TD>
						</TR>
</#foreach>
					</TBODY>
				</TABLE>
			</TD>
		</TR>
</#foreach>
	</TBODY>
</TABLE>
</#foreach>
</BODY>