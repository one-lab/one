----------------------------------------------------------------------------------------------------------------------
1、需要在application.properties中设置log配置相关信息如下示例：该properties文件一定要被spring加载
----------------------------------------------------------------------------------------------------------------------
#log setting
#environment  PRODUCT>TEST>DEVLEOP
log.environment=DEVLEOP
#记录日志中应用名称
log.appname=yjx
#log使用的jdbc信息
log.jdbc.driverClassName=com.mysql.jdbc.Driver
log.jdbc.url=jdbc:mysql://localhost:3306/test?characterEncoding=utf8
log.jdbc.username=root
log.jdbc.password=root
#log批量保存阀值大小设置，做测试的时候请注意该参数的作用是共计条数至多少后才保存，所以累计到10条后才会保存
log.batchSize=10
----------------------------------------------------------------------------------------------------------------------
2、需要在spring配置文件中配置如下相关信息，注意根据应用来调整切面的表达式
----------------------------------------------------------------------------------------------------------------------
    <!-- log切面-->
	<bean id="logTraceAspect" class="com.sinosoft.ebusiness.log.LogTraceAspect">
        <property name="environment" value="${log.environment}" />
    </bean>

    <aop:config>
        <aop:aspect id="logAop" ref="logTraceAspect">
            <aop:pointcut  id="traceAspectCut" expression="execution( * com.sinosoft.ebusiness..*.*(..))"/>
            <aop:around pointcut-ref="traceAspectCut" method="logAgroundClassAndInterface"/>
        </aop:aspect>
    </aop:config>
----------------------------------------------------------------------------------------------------------------------
3、在需要进行日志追踪的地方加上注解
----------------------------------------------------------------------------------------------------------------------
@LogTraced(description="你好",env = Environment.TEST)
可以在接口中增加，也可以在class中增加,同时可以记录你想需要的参数 LogTraced的env属性默认为TEST。
description支持format表达式，其中${}包裹的是参数信息，告知log此处是参数，如：${[0]},[?]代表是获取的方法上的第?个参数，整个表达式支持多
个包裹形式，如果参数是Object，想获取其中的属性，请使用以下方式如:${[0]:name}，则是获取第一个参数的Object的属性为name的值，当然必须满足
javaBean的规范也就是必须有getName方法，如果是Collection，那请用此种方式:${[0]:user[0].name},那既是获取user这个集合当中第一条的name值
，以上介绍的所有用法与Apache BeanUtils的方式保持一致，请参考，
举例："测试一下${[0]}，再继续测试下${[1]}"
     测试一下${[0]:name}，再继续测试下${[0]:b.sex}
----------------------------------------------------------------------------------------------------------------------
4、在需要记录日志的时候请配置相关获取用户信息的接口
----------------------------------------------------------------------------------------------------------------------
实现com.sinosoft.ebusiness.log.User该接口的实现类用于获取用户信息且在spring配置文件配置相关bean
    <bean id="logUser" class="com.sinosoft.ebusiness.log.UserImpl" />
并将logTraceAspect调整为如下信息：
    <bean id="logTraceAspect" class="com.sinosoft.ebusiness.log.LogTraceAspect">
        <property name="environment" value="${log.environment}" />
        <property name="user" ref="logUser"/>
    </bean>