${pojo.getPackageDeclaration()}
// Generated ${date} by Hibernate Tools ${version}

<#assign classbody>
<#assign entityClass = pojo.importType(pojo.qualifiedDeclarationName)>@${pojo.importType("javax.ejb.Local")}
public interface ${pojo.shortName}Finder {

   public String findFirstPage();
   public String findNextPage();
   public String findPreviousPage();
   
   public boolean isNextPage();
   public boolean isPreviousPage();
   
   public void refresh();
   
   public int getPageSize();
   public void setPageSize(int size);
   
   public String clear();
   
   public ${entityClass} getSelection();
   
   public void destroy();
   
   public ${pojo.importType(pojo.qualifiedDeclarationName)} getExample();
   
   public String reorder();
    
}
</#assign>

${pojo.generateImports()}
${classbody}
