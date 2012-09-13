<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>

<HEAD>

<TITLE>Hibernate Mappings - Table Info</TITLE>

<LINK REL ="stylesheet" TYPE="text/css" HREF="${docFileManager.getRef(docFile, docFileManager.getCssStylesDocFile())}" TITLE="Style">

</HEAD>

<BODY>

<H3>Table: ${table.name}</H3>
<H4>Schema: ${dochelper.getQualifiedSchemaName(table)}</H4>

<p>${table.comment?if_exists}</p>

<A NAME="column_summary"></A>
<TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0">
	<THEAD>
		<TR>
			<TH COLSPAN="9" CLASS="MainTableHeading">
				Column Summary
			</TH>
		</TR>
		<TR>
			<TH WIDTH="14%">
				Name
			</TH>
			<TH WIDTH="14%">
				SqlType
			</TH>
			<TH WIDTH="14%">
				Length
			</TH>
			<TH WIDTH="14%">
				Precision
			</TH>
			<TH WIDTH="14%">
				Scale
			</TH>
			<TH WIDTH="14%">
				Nullable
			</TH>
			<TH WIDTH="14%">
				Unique
			</TH>
		</TR>
	</THEAD>
	<TBODY>
<#foreach column in table.columnIterator>		<TR>
			<TD>
				<A HREF='#column_detail_${column.name}'>
					${column.name}
				</A>
			</TD>
			<TD>
				${dochelper.getSQLTypeName(column)}
			</TD>
			<TD ALIGN="RIGHT">
				${column.length}
			</TD>
			<TD ALIGN="RIGHT">
				${column.precision}
			</TD>
			<TD ALIGN="RIGHT">
				${column.scale}
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

<P>

<#-- SHOW THE PRIMARY KEY
-->
<A NAME="primary_key"></A>
<TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0">
	<THEAD>
		<TR>
			<TH COLSPAN="2" CLASS="MainTableHeading">
				Primary Key
			</TH>
		</TR>
    </THEAD>
	<TBODY>
<#if table.hasPrimaryKey()>
		<TR>
			<TD WIDTH="50%">
<#if table.primaryKey.name?has_content>
				${table.primaryKey.name}
<#else>
				Name not specified
</#if>			</TD>
			<TD WIDTH="50%">
<#list table.primaryKey.columnIterator() as column>
				<A HREF='#column_detail_${column.name}'>
					${column.name}<BR>
				</A>
</#list>
			</TD>
		</TR>
<#else>		<TR>
			<TD>
				No Primary Key
			</TD>
		</TR>
</#if>	</TBODY>
</TABLE>

<#-- SHOW THE FOREIGN KEYS -->
<#if table.foreignKeyIterator.hasNext()><P>

<A NAME="foreign_keys"></A>
<TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0">
	<THEAD>
		<TR>
			<TH COLSPAN="3" CLASS="MainTableHeading">
				Foreign Keys
			</TH>
		</TR>
		<TR>
			<TH WIDTH="33%">
				Name
			</TH>
			<TH WIDTH="33%">
				Referenced Table
			</TH>
			<TH WIDTH="33%">
				Columns
			</TH>
		</TR>
	</THEAD>
	<TBODY>
<#foreach foreignKey in table.foreignKeyIterator>
		<TR>
			<TD>
				${foreignKey.name?default("Name not specified")}
			</TD>
			<TD>
				<A HREF='${docFileManager.getRef(docFile, docFileManager.getTableDocFile(foreignKey.referencedTable))}' TARGET="generalFrame">
					${foreignKey.referencedTable.name}
				</A>
			</TD>
			<TD>
<#foreach column in foreignKey.getColumnIterator()>
				<A HREF='#column_detail_${column.name}'>
					${column.name}<BR>
				</A>
</#foreach>
			</TD>
		</TR>
</#foreach>	</TBODY>
</TABLE>
</#if>
<#-- SHOW THE UNIQUE KEYS
-->
<#if table.uniqueKeyIterator.hasNext()>
<P>

<A NAME="unique_keys"></A>
<TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0">
	<THEAD>
		<TR>
			<TH COLSPAN="2" CLASS="MainTableHeading">
				Unique Keys
			</TH>
		</TR>
		<TR>
			<TH WIDTH="50%">
				Name
			</TH>
			<TH WIDTH="50%">
				Columns
			</TH>
		</TR>
	</THEAD>
	<TBODY>
<#foreach uniqueKey in table.getUniqueKeyIterator()>
		<TR>
			<TD>
                    ${uniqueKey.name?default("Name not specified")}
			</TD>
			<TD>
<#foreach column in uniqueKey.getColumnIterator()>
				<A HREF='#column_detail_${column.name}'>
					${column.name}<BR>
				</A>
</#foreach>
			</TD>
		</TR>
</#foreach>	
    </TBODY>
</TABLE>
</#if>
<#-- SHOW THE TABLE INDEXES-->
<#if table.indexIterator.hasNext()><P>

<A NAME="indexes"></A>
<TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0">
	<THEAD>
		<TR>
			<TH COLSPAN="2" CLASS="MainTableHeading">
				Indexes
			</TH>
		</TR>
		<TR>
			<TH WIDTH="50%">
				Name
			</TH>
			<TH WIDTH="50%">
				Columns
			</TH>
		</TR>
	</THEAD>
	<TBODY>
<#foreach index in table.indexIterator>
		<TR>
			<TD>
				${index.name?default("Name not specificed")}
			</TD>
			<TD>
<#foreach column in index.columnIterator>
				<A HREF='#column_detail_${column.name}'>
					${column.name}<BR>
				</A>
</#foreach>
			</TD>
		</TR>
</#foreach>	</TBODY>
</TABLE>
</#if>
<#if table.columnIterator.hasNext()>
<P>

<A NAME="column_detail"></A>
<TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0">
	<THEAD>
		<TR>
			<TH CLASS="MainTableHeading">
    			Column Detail
    		</TH>
		</TR>
	</THEAD>
</TABLE>

<#foreach column in table.columnIterator>
<A NAME='column_detail_${column.name}'></A>
<H3>${column.name}</H3>

<UL>
	<LI><B>Type: </B>${dochelper.getSQLTypeName(column)}</LI>
	<LI><B>Length: </B>${column.length}</LI>
	<LI><B>Precision: </B>${column.precision}</LI>
	<LI><B>Scale: </B>${column.scale}</LI>
	<LI><B>Nullable: </B>${column.nullable?string}</LI>
	<LI><B>Unique: </B>${column.unique?string}</LI>
	<LI><B>Comment: </B>${column.comment?if_exists}</LI>
</UL>

<P>

<#--
<H4>Mappings:</H4>

#foreach($property in $dochelper.getProperties($table, $column))
$property.persistentClass.className - $property.name
#end
-->

<HR>
</#foreach>
</#if>
</BODY>

</HTML>