/**
${pojo.getClassJavaDoc(pojo.getDeclarationName() + ".", 0)}
<#if clazz.table.comment?exists>* ${clazz.table.comment}</#if>
 */
<#include "Ejb3TypeDeclaration.ftl"/>
${pojo.getClassModifiers()} ${pojo.getDeclarationType()} ${pojo.getDeclarationName()} ${pojo.getExtendsDeclaration()} ${pojo.getImplementsDeclaration()}