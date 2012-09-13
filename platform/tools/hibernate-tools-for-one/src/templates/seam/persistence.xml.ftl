<entity-manager>
   <persistence-unit name="entityManager">
   <provider>org.hibernate.ejb.HibernatePersistence</provider>
   <jta-data-source>java:/DefaultDS</jta-data-source>
   <properties>
      <property name="hibernate.dialect" value="org.hibernate.dialect.HSQLDialect"/>
      <property name="hibernate.transaction.manager_lookup_class" value="org.hibernate.transaction.JBossTransactionManagerLookup"/>
      <property name="hibernate.transaction.flush_before_completion" value="true"/>
      <property name="hibernate.hbm2ddl.auto" value="create-drop"/>
      <property name="hibernate.show_sql" value="true"/>
      <property name="jboss.entity.manager.factory.jndi.name" value="java:/${seam_shortname}EntityManagerFactory"/>
   </properties>
   </persistence-unit>
</entity-manager>