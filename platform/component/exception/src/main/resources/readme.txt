----------------------------------------------------------------------------------------------------------------------
1、需要在application.properties中设置exception配置相关信息如下示例：该properties文件一定要被spring加载
----------------------------------------------------------------------------------------------------------------------
# exception settings
# exception使用的jdbc信息
exception.jdbc.driverClassName=oracle.jdbc.driver.OracleDriver
exception.jdbc.url=jdbc:oracle:thin:@127.0.0.1:1521:orcl
exception.jdbc.username=testaccount
exception.jdbc.password=testpassword
# exception 配置的xml文件的路径设置
exception.config.path=config/ExceptionConfig-test.xml
# exception 队列的大小设置
exception.queue.size=1000
# 记录异常中的应用名称
exception.appName=epicc
# 异常信息保存阀值设置
# 做测试的时候请注意该参数的作用是共计条数至多少后才保存，所以累计到10条后才会保存
exception.batch.size=1
# exception 方法切面的表达式
exception.aspect.expression=execution (* com.sinosoft..service..spring.*SpringImpl.*(..)))


# 监控的客户端的配置
monitor.ip=127.0.0.1
monitor.port=8080
monitor.appName=epicc
