import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.rmsdemo.model.Employee;
import com.sinosoft.one.rmsdemo.model.Test1Date;
import com.sinosoft.one.rmsdemo.model.TestEmployee;
import com.sinosoft.one.rmsdemo.uiUtils.Gridable;
import com.sinosoft.one.rmsdemo.uiUtils.UIType;
import com.sinosoft.one.rmsdemo.uiUtils.UIUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-24
 * Time: 下午5:48
 * To change this template use File | Settings | File Templates.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class GridJsonTest {
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private Date birthday;
    private BigDecimal employeeNo;
    private String company;
    private String organization;
    private String operation;
    /*    private Long id=1L;
 private String name="zhangsan";
 private Integer age=Integer.valueOf(20);
 private String gender="male";
 private Date birthday=new Date(Long.valueOf(19800101));*/
    private Employee firstEmployee,secondEmployee,thirdEmployee,fourthEmployee,fiveEmployee,sixthEmployee,seventhEmployee;
    private List<Employee> employeeList=new ArrayList<Employee>();
    private List<TestEmployee> testEmployeeList=new ArrayList<TestEmployee>();
    private List<Test1Date> test1DateList = new ArrayList<Test1Date>();
    private List<String> employeeAttributes=new ArrayList<String>();
    private List<String> testEmployeeAttributes=new ArrayList<String>();

    @Before
    public void setUp1(){
        id = 1L;
        name = "张张";
        age = 21;
        Test1Date test1Date = new Test1Date(id,name, age);
        test1DateList.add(test1Date);
    }
    @Before
    public void setUp(){
        for (int i=0;i<12;i++){
            id=1L+i;
            name="张三"+i;
            age=Integer.valueOf(20)+i;
            gender="male"+i;
            birthday = new Date(Long.valueOf(19800101+i));
            Employee employee=new Employee(id,name,age,gender,birthday);
            employeeList.add(employee);
        }
        for (int i=1;i<102;i++){
            id=1L+i;
            employeeNo=BigDecimal.valueOf(1000+i);
            name="LiSi"+i;
            company="山东分公司"+i;
            organization="<a href='#' class='agency' onclick='openWindow()'></a>";
            operation = "<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>";
            TestEmployee testEmployee=new TestEmployee(id,employeeNo,name,company,organization,operation);
            testEmployeeList.add(testEmployee);
        }
    }
    @Test
    public void testGridConvertTojson1Date(){
        Page page = new PageImpl(test1DateList);
        Gridable<Test1Date> gridable = new Gridable<Test1Date>(page);
        gridable.setIdField("id");
        employeeAttributes.add("name");
        employeeAttributes.add("age");
        gridable.setCellField(employeeAttributes);
        UIUtil.with(gridable).as(UIType.Json);
    }
    @Test
    public void testGridConvertToJson1(){
        Page page=new PageImpl(employeeList);
        Gridable<Employee> gridable=new Gridable<Employee>(page);
        gridable.setIdField("id");
        employeeAttributes.add("name");
        employeeAttributes.add("age");
        employeeAttributes.add("gender");
        employeeAttributes.add("birthday");
        gridable.setCellField(employeeAttributes);
        UIUtil.with(gridable).as(UIType.Json);
    }

    @Test
    public void testGridConvertToJson2(){
        Page page=new PageImpl(testEmployeeList);
        Gridable<TestEmployee> gridable=new Gridable<TestEmployee>(page);
        gridable.setIdField("id");
        testEmployeeAttributes.add("employeeNo");
        testEmployeeAttributes.add("name");
        testEmployeeAttributes.add("company");
        testEmployeeAttributes.add("organization");
        testEmployeeAttributes.add("operation");
        gridable.setCellField(testEmployeeAttributes);
        UIUtil.with(gridable).as(UIType.Json);
    }
}
