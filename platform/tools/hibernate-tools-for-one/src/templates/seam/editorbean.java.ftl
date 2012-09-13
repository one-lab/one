${pojo.getPackageDeclaration()}
// Generated ${date} by Hibernate Tools ${version}

<#assign classbody>
<#assign entityEditor = pojo.shortName.toLowerCase() + "Editor">
<#assign entityFinder = pojo.shortName.toLowerCase() + "Finder">
<#assign entityList = pojo.shortName.toLowerCase() + "List">
<#assign entity = pojo.shortName.toLowerCase()>
<#assign entityClass = pojo.importType(pojo.qualifiedDeclarationName)>
@${pojo.importType("org.jboss.seam.annotations.Name")}("${entityEditor}")
@${pojo.importType("javax.ejb.Stateful")}
@${pojo.importType("javax.interceptor.Interceptors")}(${pojo.importType("org.jboss.seam.ejb.SeamInterceptor")}.class)
public class ${pojo.shortName}EditorBean implements ${pojo.shortName}Editor {

    @${pojo.importType("org.jboss.seam.annotations.In")}(create=true)
    private ${pojo.importType("javax.persistence.EntityManager")} entityManager;

    @${pojo.importType("org.hibernate.validator.Valid")}
    private ${entityClass} instance = new ${entityClass}();
    @${pojo.importType("javax.ejb.TransactionAttribute")}(${pojo.staticImport("javax.ejb.TransactionAttributeType", "NOT_SUPPORTED")})
    public ${entityClass} getInstance() {
       return instance;
    }
    public void setInstance(${entityClass} instance) {
       this.instance = instance;
    }

    private boolean isNew = true;
    @${pojo.importType("javax.ejb.TransactionAttribute")}(${pojo.staticImport("javax.ejb.TransactionAttributeType", "NOT_SUPPORTED")})
    public boolean isNew() {
       return isNew;
    }
    public void setNew(boolean isNew) {
       this.isNew = isNew;
    }

    private String doneOutcome = "find";
    public void setDoneOutcome(String outcome) {
    	doneOutcome = outcome;
    }

    @${pojo.importType("org.jboss.seam.annotations.In")}(required=false)
    private transient ${pojo.shortName}Finder ${entityFinder};

    @${pojo.importType("org.jboss.seam.annotations.In")}(create=true)
    private transient ${pojo.importType("java.util.Map")} messages;
    
    @${pojo.importType("org.jboss.seam.annotations.Begin")}(join=true)
    @${pojo.importType("org.jboss.seam.annotations.IfInvalid")}(outcome=${pojo.importType("org.jboss.seam.annotations.Outcome")}.REDISPLAY)
    public String create() {
<#if pojo.identifierProperty.value.identifierGeneratorStrategy == "assigned">
       if ( entityManager.find(${entityClass}.class, instance.${pojo.getGetterSignature(pojo.identifierProperty)}())!=null )
       {
          ${pojo.importType("javax.faces.context.FacesContext")}.getCurrentInstance().addMessage(null, 
                new ${pojo.importType("javax.faces.application.FacesMessage")}(
                      messages.get("${pojo.shortName}_${pojo.identifierProperty.name}") + " " +
                      messages.get("AlreadyExists")
                   )
             );
          return null;
       }
</#if>       entityManager.persist(instance);
       isNew = false;
<#foreach property in pojo.getAllPropertiesIterator()>
 <#if c2h.isManyToOne(property)>
 <#assign getter = "get" + pojo.getPropertyName(property)>
       if (instance.${getter}()!=null) {
          instance.${getter}().get${pojo.shortName}s().add(instance);
       }
 </#if>
</#foreach>
       refreshFinder();
       return "edit${pojo.shortName}";
    }

    @${pojo.importType("org.jboss.seam.annotations.IfInvalid")}(outcome=${pojo.importType("org.jboss.seam.annotations.Outcome")}.REDISPLAY)
    public String update() {
       refreshFinder();
       return null;
    }

    @${pojo.importType("org.jboss.seam.annotations.End")}(ifOutcome="find")
    public String delete() {
       entityManager.remove(instance);
<#foreach property in pojo.getAllPropertiesIterator()>
 <#if c2h.isManyToOne(property)>
 <#assign getter = "get" + pojo.getPropertyName(property)>
       instance.${getter}().get${pojo.shortName}s().remove(instance);
 </#if>
</#foreach>
       refreshFinder();
       return doneOutcome;
    }

    @${pojo.importType("org.jboss.seam.annotations.End")}(ifOutcome="find")
    public String done() {
       if (!isNew) entityManager.refresh(instance);
       return doneOutcome;
    }
    
    private void refreshFinder() {
       if (${entityFinder}!=null) ${entityFinder}.refresh();
    }

    @${pojo.importType("org.jboss.seam.annotations.Destroy")} @${pojo.importType("javax.ejb.Remove")}
    public void destroy() {}

<#foreach property in pojo.getAllPropertiesIterator()>
 <#assign getter = "get" + pojo.getPropertyName(property)>
 <#if c2h.isManyToOne(property)>
  <#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
  <#assign parentEditor = parentPojo.shortName.toLowerCase() + "Editor">    
    @${pojo.importType("org.jboss.seam.annotations.In")}(create=true)
    private transient ${parentPojo.shortName}Editor ${parentEditor};
    
    public String ${property.name}() {
       ${parentEditor}.setNew(false);
       ${parentEditor}.setInstance( instance.${getter}() );
       ${parentEditor}.setDoneOutcome("edit${pojo.shortName}");
       return "edit${parentPojo.shortName}";
    }

<#assign entitySelector = parentPojo.shortName.toLowerCase() + "Selector"><#assign childSelector = pojo.shortName.toLowerCase() + parentPojo.shortName + "Selector">
    @${pojo.importType("org.jboss.seam.annotations.Begin")}(join=true)
    public String select${parentPojo.shortName}() {
    	${pojo.staticImport("org.jboss.seam.ScopeType", "CONVERSATION")}.getContext().set("${entitySelector}",
    	      ${pojo.importType("org.jboss.seam.Component")}.getInstance("${childSelector}", true) );
        return "select${parentPojo.shortName}";
    }
    
</#if>
<#if c2h.isOneToManyCollection(property)>
 <#assign childPojo = c2j.getPOJOClass(property.value.element.associatedClass)>
 <#assign childEditor = childPojo.shortName.toLowerCase() + "Editor">
    @${pojo.importType("org.jboss.seam.annotations.datamodel.DataModel")}
    public ${pojo.importType("java.util.List")} ${getter}List() {
       return instance == null || instance.${getter}()==null ?
             null : new ${pojo.importType("java.util.ArrayList")}( instance.${getter}() );
    }

    @${pojo.importType("org.jboss.seam.annotations.datamodel.DataModelSelection")}("${property.name}List")
    private ${childPojo.shortName} selected${childPojo.shortName};

    @${pojo.importType("org.jboss.seam.annotations.In")}(create=true)
    private transient ${childPojo.shortName}Editor ${childEditor};
    
    public String create${childPojo.shortName}() {
       ${childEditor}.setNew(true);
       ${childEditor}.setInstance( new ${childPojo.shortName}() );
       ${childEditor}.getInstance().set${pojo.shortName}(instance);
       ${childEditor}.setDoneOutcome( "edit${pojo.shortName}" );
       return "edit${childPojo.shortName}";
    }

    public String select${childPojo.shortName}() {
       ${childEditor}.setNew(false);
       ${childEditor}.setInstance( selected${childPojo.shortName} );
       ${childEditor}.setDoneOutcome( "edit${pojo.shortName}" );
       return "edit${childPojo.shortName}";
    }
    
 <#if property.value.key.nullable>
    /*public String remove${childPojo.shortName}() {
       instance.${getter}.remove( selected${childPojo.shortName} );
       selected${childPojo.shortName}.set${pojo.shortName}(null);
       return "edit";
    }*/
 </#if>
</#if>
</#foreach>
}
</#assign>

${pojo.generateImports()}
${classbody}
