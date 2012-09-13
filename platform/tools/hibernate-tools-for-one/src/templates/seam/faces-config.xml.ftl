<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE faces-config 
PUBLIC "-//Sun Microsystems, Inc.//DTD JavaServer Faces Config 1.0//EN"
                            "http://java.sun.com/dtd/web-facesconfig_1_0.dtd">
<faces-config>

<#foreach entity in c2j.getPOJOIterator(cfg.getClassMappings())>
	<!-- navigation rules for ${entity.qualifiedDeclarationName} -->
	
	<navigation-rule>
        <navigation-case>
			<from-outcome>edit${entity.shortName}</from-outcome>
			<to-view-id>/edit${entity.shortName}.jsp</to-view-id>
        </navigation-case>
        <navigation-case>
			<from-outcome>select${entity.shortName}</from-outcome>
			<to-view-id>/find${entity.shortName}.jsp</to-view-id>
        </navigation-case>
        <navigation-case>
			<from-outcome>find${entity.shortName}</from-outcome>
			<to-view-id>/find${entity.shortName}.jsp</to-view-id>
        </navigation-case>
	</navigation-rule>

	<navigation-rule>
		<from-view-id>/edit${entity.shortName}.jsp</from-view-id>
		<navigation-case>
			<from-outcome>find</from-outcome>
			<to-view-id>/find${entity.shortName}.jsp</to-view-id>
		</navigation-case>
	</navigation-rule>
    
</#foreach>
	<!-- Same for all Seam applications -->
	
	<application>
		<variable-resolver>org.jboss.seam.jsf.SeamVariableResolver</variable-resolver>
	</application>
	
	<lifecycle>
		<phase-listener>org.jboss.seam.jsf.SeamExtendedManagedPersistencePhaseListener</phase-listener>
	</lifecycle>

</faces-config>