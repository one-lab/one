<?xml version="1.0" encoding="UTF-8"?>
<components>

    <component name="org.jboss.seam.core.init">
        <property name="myFacesLifecycleBug">true</property>
        <property name="jndiPattern">${seam_shortname}/${'#'}{ejbName}/local</property>
    </component>
  
    <component name="entityManager" class="org.jboss.seam.core.ManagedPersistenceContext">
        <property name="persistenceUnitJndiName">java:/${seam_shortname}EntityManagerFactory</property>
    </component>

    <!--
    <component name="org.jboss.seam.core.manager">
        <property name="conversationTimeout">120000</property>
    </component>

    <component class="org.jboss.seam.core.Ejb" installed="false"/>
    -->
    
</components>