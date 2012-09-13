${pojo.getPackageDeclaration()}
// Generated ${date} by Hibernate Tools ${version}

<#assign classbody>
<#assign entityFinder = pojo.shortName.toLowerCase() + "Finder">
<#assign entityList = pojo.shortName.toLowerCase() + "List">
<#assign entityvar = pojo.shortName.toLowerCase()>
<#assign entityClass = pojo.importType(pojo.qualifiedDeclarationName)>
@${pojo.importType("org.jboss.seam.annotations.Name")}("${entityFinder}")
@${pojo.importType("javax.ejb.Stateful")}
@${pojo.importType("org.jboss.seam.annotations.Scope")}(${pojo.importType("org.jboss.seam.ScopeType")}.SESSION)
@${pojo.importType("javax.interceptor.Interceptors")}(${pojo.importType("org.jboss.seam.ejb.SeamInterceptor")}.class)
public class ${pojo.shortName}FinderBean implements ${pojo.shortName}Finder {
    
    private ${entityClass} example = new ${entityClass}();
    public ${entityClass} getExample() {
        return example;
    }
    
    private int pageNumber = 0;
    private int pageSize = 25;
    public void setPageSize(int size) {
        pageSize = size;
    }
    public int getPageSize() {
        return pageSize;
    }
    
    public boolean isPreviousPage() {
        return ${entityvar}List!=null && pageNumber>0;
    }
    public boolean isNextPage() {
        return ${entityvar}List!=null && ${entityvar}List.size()==pageSize;
    }
    
    @${pojo.importType("org.jboss.seam.annotations.datamodel.DataModel")}
    private ${pojo.importType("java.util.List")}<${entityClass}> ${entityvar}List;

    @${pojo.importType("org.jboss.seam.annotations.datamodel.DataModelSelection")}
    private ${entityClass} selected${pojo.shortName};
    
    @${pojo.importType("org.jboss.seam.annotations.In")}(create=true)
    private ${pojo.importType("javax.persistence.EntityManager")} entityManager;
    
    private void executeQuery() {
        ${pojo.importType("java.util.Map")}<String, Object> parameters = new ${pojo.importType("java.util.HashMap")}<String, Object>();
        StringBuffer queryString = new StringBuffer();
<#foreach property in pojo.getAllPropertiesIterator()>
<#assign valueMethod = pojo.getGetterSignature(property) + "()">
<#assign type = c2j.getJavaTypeName(property, true)>
<#if type == "java.lang.String">
        if ( example.${valueMethod} != null && example.${valueMethod}.length() > 0 ) {
           queryString.append(" and ${entityvar}.${property.name} like :${property.name}");
           parameters.put( "${property.name}", '%' + example.${valueMethod} + '%' );
        }
<#elseif type == "boolean">
        queryString.append(" and ${entityvar}.${property.name} = :${property.name}");
        parameters.put( "${property.name}", example.${valueMethod} );
<#elseif type == "long" || type == "int" || type == "short" || type == "byte">
        if ( example.${valueMethod} != 0 ) {
           queryString.append(" and ${entityvar}.${property.name} = :${property.name}");
           parameters.put( "${property.name}", example.${valueMethod} );
        }
<#elseif type == "float" || type == "double">
        if ( example.${valueMethod} != 0.0 ) {
           queryString.append(" and ${entityvar}.${property.name} = :${property.name}");
           parameters.put( "${property.name}", example.${valueMethod} );
        }
<#elseif !c2h.isCollection(property) && !c2h.isManyToOne(property)>
        if ( example.${valueMethod} != null ) {
           queryString.append(" and ${entityvar}.${property.name} = :${property.name}");
           parameters.put( "${property.name}", example.${valueMethod} );
        }
</#if>
</#foreach>
        if ( queryString.length()==0 ) {
           queryString.append("select ${entityvar} from ${pojo.shortName} ${entityvar}");
        }
        else {
           queryString.delete(0, 4).insert(0, "select ${entityvar} from ${pojo.shortName} ${entityvar} where");
        }
        
        if ( order!=null ) {
           queryString.append(" order by ${entityvar}.").append(order);
           if (descending) queryString.append(" desc");
        }
        
        ${pojo.importType("javax.persistence.Query")} query = entityManager.createQuery(queryString.toString());
        for (${pojo.importType("java.util.Map.Entry")} <String, Object> param: parameters.entrySet()) {
            query.setParameter( param.getKey(), param.getValue() );
        }
        ${entityvar}List = (List<${entityClass}>) query.setMaxResults(pageSize)
                .setFirstResult(pageSize*pageNumber)
                .getResultList();
    }
    
    public String findFirstPage() {
        pageNumber=0;
        executeQuery();
        return null;
    }
    
    public String findNextPage() {
        pageNumber++;
        executeQuery();
        return null;
    }
    
    public String findPreviousPage() {
        pageNumber--;
        executeQuery();
        return null;
    }
    
    public void refresh() {
        if (${entityvar}List!=null) executeQuery();
    }
    
    public String clear() {
        ${entityvar}List=null;
        example = new ${entityClass}();
        return null;
    }
    
    public ${entityClass} getSelection() {
        return entityManager.merge( selected${pojo.shortName} );
    }
        
    @${pojo.importType("org.jboss.seam.annotations.Destroy")} @${pojo.importType("javax.ejb.Remove")}
    public void destroy() {}
    
    private String order;
    private boolean descending = false;
    
    @${pojo.importType("org.jboss.seam.annotations.RequestParameter")}
    private String orderBy;

    public String reorder() {
        if (orderBy.equals(order)) {
            descending = !descending;
        }
        else {
            descending = false;
        }
        order = orderBy;
        executeQuery();
        return null;
    }
    
}
</#assign>

${pojo.generateImports()}
${classbody}
