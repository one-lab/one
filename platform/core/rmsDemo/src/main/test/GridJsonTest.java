import com.sinosoft.one.model.Employee;
import com.sinosoft.one.model.Test1Date;
import com.sinosoft.one.model.TestEmployee;
import com.sinosoft.one.uiUtils.*;
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

import static org.junit.Assert.assertArrayEquals;
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
    private Employee firstEmployee,secondEmployee,thirdEmployee,fourthEmployee,fiveEmployee,sixthEmployee,seventhEmployee;
    private List<Employee> employeeList=new ArrayList<Employee>();
    private List<TestEmployee> testEmployeeList=new ArrayList<TestEmployee>();
    private List<Test1Date> test1DateList = new ArrayList<Test1Date>();
    private List<String> employeeAttributes=new ArrayList<String>();
    private List<String> testEmployeeAttributes=new ArrayList<String>();

    @Before
    public void setUp(){

/*        for (int i=1;i<12;i++){
            id=1L+i;
            name="张三"+i;
            age=Integer.valueOf(20)+i;
            gender="male"+i;
            birthday = new Date(Long.valueOf(19800101+i));
            Employee employee=new Employee(id,name,age,gender,birthday);
            employeeList.add(employee);
        }*/
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
    public void testGridConverToJsonWithNullObj(){
        List<TestEmployee> testEmployees=new ArrayList<TestEmployee>();
        TestEmployee testEmployee = new TestEmployee();
        testEmployees.add(testEmployee);
        String grid = null;
        Page page = new PageImpl(testEmployees);
        Gridable<Test1Date> gridable = new Gridable<Test1Date>(page);
        gridable.setIdField("id");
        testEmployeeAttributes.add("employeeNo");
        testEmployeeAttributes.add("name");
        testEmployeeAttributes.add("company");
        testEmployeeAttributes.add("organization");
        testEmployeeAttributes.add("operation");
        gridable.setCellField(employeeAttributes);
        AbstractRender abstractRender = (AbstractRender) UIUtil.with(gridable).as(UIType.Json);
        String str = abstractRender.getResult();
        assertEquals(grid , str);
    }
    @Test
    public void testGridConvertTojsonWithOneData(){
        Test1Date test1Date = new Test1Date(1L,"张张", 21);
        test1DateList.add(test1Date);
        String grid = "{\"rows\":[{\"cell\":[\"张张\",21],\"id\":\"1\"}],\"total\":1}";
        Page page = new PageImpl(test1DateList);
        Gridable<Test1Date> gridable = new Gridable<Test1Date>(page);
        gridable.setIdField("id");
        employeeAttributes.add("name");
        employeeAttributes.add("age");
        gridable.setCellField(employeeAttributes);
        AbstractRender abstractRender = (AbstractRender) UIUtil.with(gridable).as(UIType.Json);
        String str = abstractRender.getResult();
        assertEquals(grid , str);
    }
    @Test
    public void testGridConverToJsonWithNull(){
        String grid = "{\"rows\":[{\"cell\":[\"销售\",null],\"id\":\"1\"}],\"total\":1}";
        Test1Date test1Date = new Test1Date(1L,"销售",null);
        test1DateList.add(test1Date);
        Page page = new PageImpl(test1DateList);
        Gridable<Test1Date> gridable = new Gridable<Test1Date>(page);
        gridable.setIdField("id");
        employeeAttributes.add("name");
        employeeAttributes.add("age");
        gridable.setCellField(employeeAttributes);
        AbstractRender abstractRender= (AbstractRender) UIUtil.with(gridable).as(UIType.Json);
        String str = abstractRender.getResult();
        assertEquals(grid,str);

    }
    @Test
    public void testGridConverToJsonWithEmpty(){
        String grid ="{\"rows\":[{\"cell\":[\"\",21],\"id\":\"1\"}],\"total\":1}";
        Test1Date test1Date = new Test1Date(1L,"",21);
        test1DateList.add(test1Date);
        Page page = new PageImpl(test1DateList);
        Gridable<Test1Date> gridable = new Gridable<Test1Date>(page);
        gridable.setIdField("id");
        employeeAttributes.add("name");
        employeeAttributes.add("age");
        gridable.setCellField(employeeAttributes);
        AbstractRender abstractRender= (AbstractRender) UIUtil.with(gridable).as(UIType.Json);
        String str = abstractRender.getResult();
        assertEquals(grid,str);
    }

    @Test
    public void testGridConvertToJson2(){
        String grid3 = "{\"rows\":[{\"cell\":[1001,\"LiSi1\",\"山东分公司1\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"2\"},{\"cell\":[1002,\"LiSi2\",\"山东分公司2\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"3\"},{\"cell\":[1003,\"LiSi3\",\"山东分公司3\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"4\"},{\"cell\":[1004,\"LiSi4\",\"山东分公司4\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"5\"},{\"cell\":[1005,\"LiSi5\",\"山东分公司5\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"6\"},{\"cell\":[1006,\"LiSi6\",\"山东分公司6\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"7\"},{\"cell\":[1007,\"LiSi7\",\"山东分公司7\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"8\"},{\"cell\":[1008,\"LiSi8\",\"山东分公司8\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"9\"},{\"cell\":[1009,\"LiSi9\",\"山东分公司9\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"10\"},{\"cell\":[1010,\"LiSi10\",\"山东分公司10\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"11\"},{\"cell\":[1011,\"LiSi11\",\"山东分公司11\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"12\"},{\"cell\":[1012,\"LiSi12\",\"山东分公司12\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"13\"},{\"cell\":[1013,\"LiSi13\",\"山东分公司13\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"14\"},{\"cell\":[1014,\"LiSi14\",\"山东分公司14\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"15\"},{\"cell\":[1015,\"LiSi15\",\"山东分公司15\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"16\"},{\"cell\":[1016,\"LiSi16\",\"山东分公司16\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"17\"},{\"cell\":[1017,\"LiSi17\",\"山东分公司17\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"18\"},{\"cell\":[1018,\"LiSi18\",\"山东分公司18\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"19\"},{\"cell\":[1019,\"LiSi19\",\"山东分公司19\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"20\"},{\"cell\":[1020,\"LiSi20\",\"山东分公司20\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"21\"},{\"cell\":[1021,\"LiSi21\",\"山东分公司21\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"22\"},{\"cell\":[1022,\"LiSi22\",\"山东分公司22\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"23\"},{\"cell\":[1023,\"LiSi23\",\"山东分公司23\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"24\"},{\"cell\":[1024,\"LiSi24\",\"山东分公司24\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"25\"},{\"cell\":[1025,\"LiSi25\",\"山东分公司25\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"26\"},{\"cell\":[1026,\"LiSi26\",\"山东分公司26\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"27\"},{\"cell\":[1027,\"LiSi27\",\"山东分公司27\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"28\"},{\"cell\":[1028,\"LiSi28\",\"山东分公司28\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"29\"},{\"cell\":[1029,\"LiSi29\",\"山东分公司29\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"30\"},{\"cell\":[1030,\"LiSi30\",\"山东分公司30\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"31\"},{\"cell\":[1031,\"LiSi31\",\"山东分公司31\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"32\"},{\"cell\":[1032,\"LiSi32\",\"山东分公司32\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"33\"},{\"cell\":[1033,\"LiSi33\",\"山东分公司33\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"34\"},{\"cell\":[1034,\"LiSi34\",\"山东分公司34\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"35\"},{\"cell\":[1035,\"LiSi35\",\"山东分公司35\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"36\"},{\"cell\":[1036,\"LiSi36\",\"山东分公司36\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"37\"},{\"cell\":[1037,\"LiSi37\",\"山东分公司37\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"38\"},{\"cell\":[1038,\"LiSi38\",\"山东分公司38\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"39\"},{\"cell\":[1039,\"LiSi39\",\"山东分公司39\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"40\"},{\"cell\":[1040,\"LiSi40\",\"山东分公司40\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"41\"},{\"cell\":[1041,\"LiSi41\",\"山东分公司41\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"42\"},{\"cell\":[1042,\"LiSi42\",\"山东分公司42\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"43\"},{\"cell\":[1043,\"LiSi43\",\"山东分公司43\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"44\"},{\"cell\":[1044,\"LiSi44\",\"山东分公司44\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"45\"},{\"cell\":[1045,\"LiSi45\",\"山东分公司45\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"46\"},{\"cell\":[1046,\"LiSi46\",\"山东分公司46\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"47\"},{\"cell\":[1047,\"LiSi47\",\"山东分公司47\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"48\"},{\"cell\":[1048,\"LiSi48\",\"山东分公司48\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"49\"},{\"cell\":[1049,\"LiSi49\",\"山东分公司49\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"50\"},{\"cell\":[1050,\"LiSi50\",\"山东分公司50\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"51\"},{\"cell\":[1051,\"LiSi51\",\"山东分公司51\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"52\"},{\"cell\":[1052,\"LiSi52\",\"山东分公司52\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"53\"},{\"cell\":[1053,\"LiSi53\",\"山东分公司53\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"54\"},{\"cell\":[1054,\"LiSi54\",\"山东分公司54\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"55\"},{\"cell\":[1055,\"LiSi55\",\"山东分公司55\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"56\"},{\"cell\":[1056,\"LiSi56\",\"山东分公司56\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"57\"},{\"cell\":[1057,\"LiSi57\",\"山东分公司57\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"58\"},{\"cell\":[1058,\"LiSi58\",\"山东分公司58\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"59\"},{\"cell\":[1059,\"LiSi59\",\"山东分公司59\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"60\"},{\"cell\":[1060,\"LiSi60\",\"山东分公司60\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"61\"},{\"cell\":[1061,\"LiSi61\",\"山东分公司61\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"62\"},{\"cell\":[1062,\"LiSi62\",\"山东分公司62\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"63\"},{\"cell\":[1063,\"LiSi63\",\"山东分公司63\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"64\"},{\"cell\":[1064,\"LiSi64\",\"山东分公司64\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"65\"},{\"cell\":[1065,\"LiSi65\",\"山东分公司65\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"66\"},{\"cell\":[1066,\"LiSi66\",\"山东分公司66\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"67\"},{\"cell\":[1067,\"LiSi67\",\"山东分公司67\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"68\"},{\"cell\":[1068,\"LiSi68\",\"山东分公司68\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"69\"},{\"cell\":[1069,\"LiSi69\",\"山东分公司69\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"70\"},{\"cell\":[1070,\"LiSi70\",\"山东分公司70\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"71\"},{\"cell\":[1071,\"LiSi71\",\"山东分公司71\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"72\"},{\"cell\":[1072,\"LiSi72\",\"山东分公司72\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"73\"},{\"cell\":[1073,\"LiSi73\",\"山东分公司73\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"74\"},{\"cell\":[1074,\"LiSi74\",\"山东分公司74\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"75\"},{\"cell\":[1075,\"LiSi75\",\"山东分公司75\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"76\"},{\"cell\":[1076,\"LiSi76\",\"山东分公司76\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"77\"},{\"cell\":[1077,\"LiSi77\",\"山东分公司77\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"78\"},{\"cell\":[1078,\"LiSi78\",\"山东分公司78\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"79\"},{\"cell\":[1079,\"LiSi79\",\"山东分公司79\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"80\"},{\"cell\":[1080,\"LiSi80\",\"山东分公司80\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"81\"},{\"cell\":[1081,\"LiSi81\",\"山东分公司81\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"82\"},{\"cell\":[1082,\"LiSi82\",\"山东分公司82\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"83\"},{\"cell\":[1083,\"LiSi83\",\"山东分公司83\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"84\"},{\"cell\":[1084,\"LiSi84\",\"山东分公司84\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"85\"},{\"cell\":[1085,\"LiSi85\",\"山东分公司85\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"86\"},{\"cell\":[1086,\"LiSi86\",\"山东分公司86\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"87\"},{\"cell\":[1087,\"LiSi87\",\"山东分公司87\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"88\"},{\"cell\":[1088,\"LiSi88\",\"山东分公司88\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"89\"},{\"cell\":[1089,\"LiSi89\",\"山东分公司89\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"90\"},{\"cell\":[1090,\"LiSi90\",\"山东分公司90\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"91\"},{\"cell\":[1091,\"LiSi91\",\"山东分公司91\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"92\"},{\"cell\":[1092,\"LiSi92\",\"山东分公司92\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"93\"},{\"cell\":[1093,\"LiSi93\",\"山东分公司93\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"94\"},{\"cell\":[1094,\"LiSi94\",\"山东分公司94\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"95\"},{\"cell\":[1095,\"LiSi95\",\"山东分公司95\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"96\"},{\"cell\":[1096,\"LiSi96\",\"山东分公司96\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"97\"},{\"cell\":[1097,\"LiSi97\",\"山东分公司97\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"98\"},{\"cell\":[1098,\"LiSi98\",\"山东分公司98\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"99\"},{\"cell\":[1099,\"LiSi99\",\"山东分公司99\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"100\"},{\"cell\":[1100,\"LiSi100\",\"山东分公司100\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"101\"},{\"cell\":[1101,\"LiSi101\",\"山东分公司101\",\"<a href='#' class='agency' onclick='openWindow()'></a>\",\"<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据 set</a>\"],\"id\":\"102\"}],\"total\":101}";
        Page page=new PageImpl(testEmployeeList);
        Gridable<TestEmployee> gridable=new Gridable<TestEmployee>(page);
        gridable.setIdField("id");
        testEmployeeAttributes.add("employeeNo");
        testEmployeeAttributes.add("name");
        testEmployeeAttributes.add("company");
        testEmployeeAttributes.add("organization");
        testEmployeeAttributes.add("operation");
        gridable.setCellField(testEmployeeAttributes);
        AbstractRender abstractRender = (AbstractRender) UIUtil.with(gridable).as(UIType.Json);
        String str = abstractRender.getResult();
        assertEquals(grid3,str);
    }
}
