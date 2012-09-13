<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
  <title>Main Menu</title>
  <style type="text/css" media="all">
    @import "style/default/screen.css";
  </style>
 </head>
 <body>
   <h1>Main Menu</h1>
   <p>Welcome to the generated <a href="http://jboss.com/products/seam">JBoss Seam</a> application,
   created by <a href="http://tools.hibernate.org">Hibernate Tools</a> on ${date}.</p>
   <p>(These pages look best in Firefox.)</p>
   <h3>Select a task</h3>
   <table>
<#foreach entity in c2j.getPOJOIterator(cfg.getClassMappings())>     <tr><td><b>${entity.shortName} tasks:</b></td><td><a href="find${entity.shortName}.jsf">Search for existing ${entity.shortName} records</a></td><td><a href="edit${entity.shortName}.jsf">Create a new ${entity.shortName} record</a></td></tr>
</#foreach>   </table>
 </body>
</html>