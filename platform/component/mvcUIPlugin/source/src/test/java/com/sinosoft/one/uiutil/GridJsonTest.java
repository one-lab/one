package com.sinosoft.one.uiutil;

import com.sinosoft.one.uiutil.model.Employee;
import com.sinosoft.one.uiutil.model.TestEmployee;
import com.sinosoft.one.uiutil.model.UserInfo;
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

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-24
 * Time: 下午5:48
 * To change this template use File | Settings | File Templates.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
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
    private Employee firstEmployee,secondEmployee,thirdEmployee,fourthEmployee,fiveEmployee,sixthEmployee,seventhEmployee;
    private List<Employee> employeeList=new ArrayList<Employee>();
    private List<TestEmployee> testEmployeeList1=new ArrayList<TestEmployee>();
    private List<TestEmployee> testEmployeeList2=new ArrayList<TestEmployee>();
    private List<UserInfo> userInfoList = new ArrayList<UserInfo>();
    private List<String> employeeAttributes=new ArrayList<String>();
    private List<String> testEmployeeAttributes=new ArrayList<String>();

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
            testEmployeeList2.add(testEmployee);
        }
    }
    @Test
    public void testGridConvertToJsonWithOneData(){
        List<TestEmployee> testEmployeeList=new ArrayList<TestEmployee>();
        String gridJson="{\"rows\":[{\"cell\":[1001,\"张三\",\"山东分公司\",\"机构\",\"权限\"],\"id\":\"1\"}],\"total\":1}";
        TestEmployee testEmployee = new TestEmployee(1L,BigDecimal.valueOf(1001), "张三","山东分公司","机构","权限");
        testEmployeeList.add(testEmployee);
        Page page = new PageImpl(testEmployeeList);
        Gridable<TestEmployee> gridable = new Gridable<TestEmployee>(page);
        gridable.setIdField("id");
        testEmployeeAttributes.add("employeeNo");
        testEmployeeAttributes.add("name");
        testEmployeeAttributes.add("company");
        testEmployeeAttributes.add("organization");
        testEmployeeAttributes.add("operation");
        gridable.setCellListStringField(testEmployeeAttributes);
        AbstractRender abstractRender=(GridRender)UIUtil.with(gridable).as(UIType.Json);
        assertEquals(gridJson, abstractRender.getResultForTest());
    }

    @Test
    public void testGridConvertToJsonWithNullObject(){
        String gridJson = null;
        Page page = new PageImpl(null);
        Gridable<TestEmployee> gridable = new Gridable<TestEmployee>(page);
        gridable.setIdField("id");
        testEmployeeAttributes.add("employeeNo");
        testEmployeeAttributes.add("name");
        testEmployeeAttributes.add("company");
        testEmployeeAttributes.add("organization");
        testEmployeeAttributes.add("operation");
        gridable.setCellListStringField(testEmployeeAttributes);
        AbstractRender abstractRender=(GridRender)UIUtil.with(gridable).as(UIType.Json);
        assertEquals(gridJson,abstractRender.getResultForTest());

    }

    @Test
    public void testGridConvertToJsonWithNullAttribute(){
        List<TestEmployee> testEmployeeList=new ArrayList<TestEmployee>();
        String gridJson = "{\"rows\":[{\"cell\":[1001,\"张三\",\"山东分公司\",null,\"权限\"],\"id\":\"1\"}],\"total\":1}";
        TestEmployee testEmployee = new TestEmployee(1L,BigDecimal.valueOf(1001), "张三","山东分公司",null,"权限");
        testEmployeeList.add(testEmployee);
        Page page = new PageImpl(testEmployeeList);
        Gridable<TestEmployee> gridable = new Gridable<TestEmployee>(page);
        gridable.setIdField("id");
        testEmployeeAttributes.add("employeeNo");
        testEmployeeAttributes.add("name");
        testEmployeeAttributes.add("company");
        testEmployeeAttributes.add("organization");
        testEmployeeAttributes.add("operation");
        gridable.setCellListStringField(testEmployeeAttributes);
        AbstractRender abstractRender=(GridRender)UIUtil.with(gridable).as(UIType.Json);
        assertEquals(gridJson,abstractRender.getResultForTest());

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
        gridable.setCellListStringField(employeeAttributes);
        AbstractRender abstractRender=(GridRender)UIUtil.with(gridable).as(UIType.Json);
    }

    @Test
    public void testGridConvertToJson2(){
        Page page=new PageImpl(testEmployeeList2);
        Gridable<TestEmployee> gridable=new Gridable<TestEmployee>(page);
        gridable.setIdField("id");
        testEmployeeAttributes.add("employeeNo");
        testEmployeeAttributes.add("name");
        testEmployeeAttributes.add("company");
        testEmployeeAttributes.add("organization");
        testEmployeeAttributes.add("operation");
        gridable.setCellListStringField(testEmployeeAttributes);
        UIUtil.with(gridable).as(UIType.Json);
    }
}
