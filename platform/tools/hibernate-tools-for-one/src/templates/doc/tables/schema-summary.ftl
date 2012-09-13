<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>

<HEAD>

<TITLE>Hibernate Mappings - Table Summary</TITLE>

<LINK REL ="stylesheet" TYPE="text/css" HREF="${docFileManager.getRef(docFile, docFileManager.getCssStylesDocFile())}" TITLE="Style">

</HEAD>

<BODY>

<H1>Hibernate Mapping Documentation</H1>

<H2>List of Tables for Schema: ${schema}</H2>

<TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0">
	<THEAD>
		<TR>
			<TH COLSPAN="2" CLASS="MainTableHeading">
				Tables
			</TH>
		</TR>
	</THEAD>
<#foreach table in dochelper.tablesBySchema.get(schema)>
	<TBODY>
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
								${column.name}
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

</BODY>