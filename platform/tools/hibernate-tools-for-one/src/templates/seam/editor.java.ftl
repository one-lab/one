${pojo.getPackageDeclaration()}
// Generated ${date} by Hibernate Tools ${version}

<#assign classbody>
<#assign entityClass = pojo.importType(pojo.qualifiedDeclarationName)>
@${pojo.importType("javax.ejb.Local")}
public interface ${pojo.shortName}Editor {
   public boolean isNew();
   public void setNew(boolean isNew);
   
   public ${entityClass} getInstance();
   public void setInstance(${entityClass} instance);
   
   public void setDoneOutcome(String outcome);

   public String update();
   public String delete();
   public String create();

<#foreach property in pojo.getAllPropertiesIterator()>
<#if c2h.isManyToOne(property)>
<#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
   public String ${property.name}();
   public String select${parentPojo.shortName}();
    
</#if>
<#if c2h.isOneToManyCollection(property)>
<#assign childPojo = c2j.getPOJOClass(property.value.element.associatedClass)>
   public String create${childPojo.shortName}();
   public String select${childPojo.shortName}();
<#if property.value.key.nullable>   
   //public String remove${childPojo.shortName}();
</#if>   
</#if>
</#foreach>
   public String done();
   
   public void destroy();
}
</#assign>

${pojo.generateImports()}
${classbody}
