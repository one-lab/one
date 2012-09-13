<?xml version="1.0"?>

<project name="${seam_appname}" default="deploy" basedir=".">


    <!-- Allow this to be overriden by others importing this project. -->
    <dirname property="imported.basedir" file="${r"${ant.file.Seam}"}"/>

    <!-- Give user a chance to override without editing this file or typing -D -->
    <property file="${r"${imported.basedir}"}/build.properties"/>

    <!-- Name of project and version, used to create filenames -->
    <property name="Name"               value="${seam_appname}"/>
    <property name="name"               value="${seam_shortname}"/>

    <!-- set global properties for this build -->
    <property name="build.dir"          value="build"/>
    <property name="classes.dir"        value="${r"${build.dir}"}/classes"/>

    <property name="src.java.dir"       value="src"/>
    <property name="lib.dir"            value="lib"/>

    <property name="deploy.dir"         value="${r"${jboss.home}"}/server/default/deploy"/>

    <property name="javac.debug"        value="true"/>
    <property name="javac.deprecation"  value="false"/>

    <!-- WAR -->
    <zipfileset id="war.docroot"
               dir="resources/jsp">
        <include name="**/*"/>
    </zipfileset>
    <zipfileset id="war.webinf"
            prefix="WEB-INF"
               dir="resources/WEB-INF" >
        <patternset refid="meta.files"/>
     </zipfileset>
    <zipfileset id="war.webinf.lib"
            prefix="WEB-INF/lib"
               dir="resources/WEB-INF/lib">
        <include name="*.jar"/>
    </zipfileset>

    <!-- EJB3 -->
    <fileset id="ejb3.root"
            dir="resources">
        <include name="import.sql"/>
        <include name="seam.properties"/>
        <include name="META-INF/persistence.xml"/>
    </fileset>
    <fileset id="ejb3.lib" dir="lib">
        <include name="jboss-seam.jar"/>
    </fileset>
  
    <!-- EAR -->
    <zipfileset id="ear.resources"
            prefix="META-INF"
               dir="resources/META-INF">
        <include name="*"/>
        <exclude name="persistence.xml"/>
    </zipfileset>

    <!-- Deploy -->
    <fileset id="deploy"
            dir="resources">
        <include name="_NONE_"/>
    </fileset>

    <!-- Undeploy -->
    <patternset id="undeploy">
        <include name="_NONE_"/>
    </patternset>

    <path id="build.classpath">
        <fileset dir="${r"${lib.dir}"}">
            <include name="**/*.jar"/>
        </fileset>
    </path>

    <patternset id="meta.files">
        <include name="**/*.dtd"/>
        <include name="**/*.xml"/>
        <include name="**/*.xslt"/>
        <include name="**/*.properties"/>
    </patternset>

    <patternset id="src.files">
        <!-- include everything we want in the src directory
            that we didn't want in the jar itself -->
        <include name="**/*.java"/>
    </patternset>

    <target name="clean"
            description="Cleans up the build directory">
        <delete dir="${r"${build.dir}"}"/>
    </target>

    <target name="init"
            description="Initialize the build">
        <echo message="Build ${r"${Name}"}"/>
        <mkdir dir="${r"${classes.dir}"}"/>
        <copy todir="${r"${classes.dir}"}">
            <fileset dir="${r"${src.java.dir}"}">
                <patternset refid="meta.files"/>
            </fileset>
        </copy>
    </target>

    <target name="compile" depends="init"
            description="Compile the Java source code">
        <javac
            destdir="${r"${classes.dir}"}"
            classpathref="build.classpath"
            debug="${r"${javac.debug}"}"
            deprecation="${r"${javac.deprecation}"}"
            nowarn="on">
            <src path="${r"${src.java.dir}"}"/>
        </javac>

    </target>

    <target name="war" depends="compile">
        <jar destfile="${r"${build.dir}/${name}"}.war">
            <zipfileset refid="war.docroot"/>
            <zipfileset refid="war.webinf"/>
            <zipfileset refid="war.webinf.lib"/>
        </jar>
    </target>

    <target name="ejb3" depends="compile">
        <jar jarfile="${r"${build.dir}/${name}"}.ejb3">
            <fileset dir="${r"${imported.basedir}"}">
                <include name="${r"${name}"}.jar"/>
            </fileset>
            <fileset dir="${r"${classes.dir}"}">
                <include name="**/*.class"/>
            	<exclude name="**/test/*.class"/>
            </fileset>
            <fileset refid="ejb3.root"/>
            <fileset refid="ejb3.lib"/>
        </jar>
    </target>

    <target name="ear" depends="ejb3, war">
        <jar destfile="${r"${build.dir}/${name}"}.ear">
            <zipfileset dir="${r"${build.dir}"}">
                <include name="${r"${name}"}.ejb3"/>
            </zipfileset>
            <zipfileset dir="${r"${build.dir}"}">
                <include name="${r"${name}"}.war"/>
            </zipfileset>
            <zipfileset refid="ear.resources"/>
        </jar>
    </target>

    <target name="deploy" depends="ear">
        <property name="unit.ext" value="ear"/>
        <fail unless="jboss.home">jboss.home MUST be set. Update build.properties to point to a valid JBoss installation.</fail>
        <copy todir="${r"${deploy.dir}"}">
            <fileset refid="deploy"/>
        </copy>
        <copy file="${r"${build.dir}/${name}.${unit.ext}"}" todir="${r"${deploy.dir}"}"/>
    </target>

    <target name="undeploy">
        <property name="unit.ext" value="ear"/>
        <delete file="${r"${deploy.dir}/${name}.${unit.ext}"}"/>
        <delete>
            <fileset dir="${r"${deploy.dir}"}">
                <patternset refid="undeploy"/>
            </fileset>
        </delete>
    </target>

    <target name="cleandb">
        <delete dir="${r"${deploy.dir}"}/../data/hypersonic"/>
    </target>


</project>

