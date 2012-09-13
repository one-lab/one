${pojo.getPackageDeclaration()}
// Generated ${date} by Hibernate Tools ${version}

<#assign classbody>
<#assign entityClass = pojo.importType(pojo.qualifiedDeclarationName)>@${pojo.importType("javax.ejb.Local")}
public interface ${pojo.shortName}Selector {

   public String select();
   public String selectNone();
     
   public String getButtonLabel();
   public String getPageTitle();
     
   public String cancel();
            
   public boolean isCreateEnabled();

<#assign entityEditor = pojo.shortName.toLowerCase() + "Editor">
<#assign entitySelector = pojo.shortName.toLowerCase() + "Selector">
<#assign entityFinder = pojo.shortName.toLowerCase() + "Finder">
   @${pojo.importType("javax.ejb.Stateless")}
   @${pojo.importType("org.jboss.seam.annotations.Name")}("${entitySelector}")
   @${pojo.importType("javax.interceptor.Interceptors")}(${pojo.importType("org.jboss.seam.ejb.SeamInterceptor")}.class)
   public static class Default${pojo.shortName}Selector implements ${pojo.shortName}Selector {
   
      @${pojo.importType("org.jboss.seam.annotations.In")}(create=true)
      private transient ${pojo.importType("java.util.ResourceBundle")} resourceBundle;
    
      @${pojo.importType("org.jboss.seam.annotations.In")}(create=true)
      private transient ${pojo.shortName}Editor ${entityEditor};
      
      @${pojo.importType("org.jboss.seam.annotations.In")}(create=true)
      private transient ${pojo.shortName}Finder ${entityFinder};
      
      @${pojo.importType("org.jboss.seam.annotations.Begin")}
      public String select() {
         ${entityEditor}.setInstance( ${entityFinder}.getSelection() );
         ${entityEditor}.setNew(false);
         return "edit${pojo.shortName}";
      }
      
      public String selectNone() {
         throw new UnsupportedOperationException();
      }
      
      public String getButtonLabel() {
         return resourceBundle.getString("View");
      }
      
      public String cancel() {
         throw new UnsupportedOperationException();
      }
      
      public String getPageTitle() {
          return resourceBundle.getString("Find") + " " + 
                  resourceBundle.getString("${pojo.shortName}");
      }
      
      public boolean isCreateEnabled() {
         return true;
      }
      
   }
   
<#foreach property in pojo.getAllPropertiesIterator()>
<#if c2h.isOneToManyCollection(property)>
<#assign childPojo = c2j.getPOJOClass(property.value.element.associatedClass)>
<#assign childEditor = childPojo.shortName.toLowerCase() + "Editor">
<#assign childSelector = childPojo.shortName.toLowerCase() + pojo.shortName + "Selector">
   @${pojo.importType("javax.ejb.Stateless")}
   @${pojo.importType("org.jboss.seam.annotations.Name")}("${childSelector}")
   @${pojo.importType("org.jboss.annotation.ejb.LocalBinding")}(jndiBinding="${childPojo.qualifiedDeclarationName}${pojo.shortName}Selector")
   @${pojo.importType("org.jboss.seam.annotations.JndiName")}("${childPojo.qualifiedDeclarationName}${pojo.shortName}Selector")
   @${pojo.importType("javax.interceptor.Interceptors")}(${pojo.importType("org.jboss.seam.ejb.SeamInterceptor")}.class)
   public static class ${childPojo.shortName}${pojo.shortName}Selector implements ${pojo.shortName}Selector {
      
      @${pojo.importType("org.jboss.seam.annotations.In")}
      private transient ${pojo.importType("java.util.ResourceBundle")} resourceBundle;
    
      @${pojo.importType("org.jboss.seam.annotations.In")}(create=true)
      private transient ${pojo.shortName}Finder ${entityFinder};

      @${pojo.importType("org.jboss.seam.annotations.In")}
      private transient ${childPojo.shortName}Editor ${childEditor};
      
      private void completed() {
         ${pojo.staticImport("org.jboss.seam.ScopeType", "CONVERSATION")}.getContext().remove("${entitySelector}");
      }
      
      public String select() {
         ${childEditor}.getInstance().set${pojo.shortName}( ${entityFinder}.getSelection() );
         //TODO: add child to collection on instance!!
         completed();
         return "edit${childPojo.shortName}";
      }
      
      public String selectNone() {
         ${childEditor}.getInstance().set${pojo.shortName}(null);
         completed();
         return "edit${childPojo.shortName}";
      }
      
      public String cancel() {
         completed();
         return "edit${childPojo.shortName}";
      }

      public String getButtonLabel() {
         return resourceBundle.getString("Select");
      }
      
      public String getPageTitle() {
          return resourceBundle.getString("Select") + " " +
                  resourceBundle.getString("${pojo.shortName}") + " " +
                  resourceBundle.getString("For") + " " + 
                  resourceBundle.getString("${childPojo.shortName}");
      }
   
      public boolean isCreateEnabled() {
         return false;
      }
   
   }
   
</#if>
</#foreach>}
</#assign>

${pojo.generateImports()}
${classbody}
