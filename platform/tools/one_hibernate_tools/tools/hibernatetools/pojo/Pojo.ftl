${pojo.getPackageDeclaration()}
// Generated ${date} by One Data Tools ${version}

<#assign classbody>
<#include "PojoTypeDeclaration.ftl"/> {
<#if !pojo.isInterface()>
<#include "PojoFields.ftl"/>

<#include "PojoConstructors.ftl"/>
   
<#include "PojoPropertyAccessors.ftl"/>

<#include "PojoEqualsHashcode.ftl"/>

	@Override
	public String toString() {
		return ${pojo.importType("org.apache.commons.lang.builder.ToStringBuilder")}.reflectionToString(this);
	}
<#else>
<#include "PojoInterfacePropertyAccessors.ftl"/>

</#if>
<#include "PojoExtraClassCode.ftl"/>

}
</#assign>

${pojo.generateImports()}
${classbody}

