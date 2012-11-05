${pojo.getPackageDeclaration().substring(0,pojo.getPackageDeclaration().lastIndexOf("."))}.repository;
// Generated ${date} by One Data Tools ${version}
<#assign classbody>
<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
<#assign entityName = declarationName?uncap_first>

public interface ${declarationName}Dao extends ${pojo.importType("org.springframework.data.repository.PagingAndSortingRepository")}<${declarationName}, ${pojo.getJavaTypeName(clazz.identifierProperty, true)}> {
}
</#assign>

${pojo.generateImports()}
import ${pojo.getQualifiedDeclarationName()};
<#if pojo.getJavaTypeName(clazz.identifierProperty, true).contains(declarationName)>
import ${pojo.getQualifiedDeclarationName().substring(0,pojo.getQualifiedDeclarationName().lastIndexOf("."))}.${pojo.getJavaTypeName(clazz.identifierProperty, true)};
</#if>
${classbody}
