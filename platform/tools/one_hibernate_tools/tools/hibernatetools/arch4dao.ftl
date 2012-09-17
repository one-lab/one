${pojo.getPackageDeclaration().substring(0,pojo.getPackageDeclaration().lastIndexOf("."))}.dao;
// Generated ${date} by One Data Tools ${version}
<#assign classbody>
<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
<#assign entityName = declarationName?uncap_first>
<#--@${pojo.importType("org.springframework.stereotype.Repository")}-->
public interface ${declarationName}Dao extends ${pojo.importType("org.springframework.data.repository.Repository")}<${declarationName}, ${pojo.getJavaTypeName(clazz.identifierProperty, true)}> {
}
</#assign>

${pojo.generateImports()}
import ${pojo.getQualifiedDeclarationName()};

${classbody}
