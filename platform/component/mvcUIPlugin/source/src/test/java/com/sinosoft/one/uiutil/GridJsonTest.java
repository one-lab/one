package com.sinosoft.one.uiutil;

import com.sinosoft.one.uiutil.exception.ConverterException;
import com.sinosoft.one.uiutil.model.TestEmployee;
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
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-24
 * Time: 下午5:48
 * To change this template use File | Settings | File Templates.
 */

public class GridJsonTest {
    private Long id;
    private String name;
    private BigDecimal employeeNo;
    private String company;
    private String organization;
    private String operation;
    private List<TestEmployee> testEmployeeList = new ArrayList<TestEmployee>();
    private List<String> testEmployeeAttributes = new ArrayList<String>();

    @Before
    public void setUp() {
        for (int i = 1; i < 12; i++) {
            id = Long.valueOf(i);
            employeeNo = BigDecimal.valueOf(1000 + i);
            name = "张三" + i;
            company = "山东分公司" + i;
            organization = "机构";
            operation = "权限";
            TestEmployee testEmployee = new TestEmployee(id, employeeNo, name, company, organization, operation);
            testEmployeeList.add(testEmployee);
        }
    }

    @Test
    public void testGridConvertToJsonWithNullObject() throws ConverterException {
        String gridJson = null;
        Page page = null;
        Gridable<TestEmployee> gridable = new Gridable<TestEmployee>(page);
        gridable.setIdField("id");
        testEmployeeAttributes.add("employeeNo");
        testEmployeeAttributes.add("name");
        testEmployeeAttributes.add("company");
        testEmployeeAttributes.add("organization");
        testEmployeeAttributes.add("operation");
        gridable.setCellListStringField(testEmployeeAttributes);
        AbstractRender abstractRender = (GridRender) UIUtil.with(gridable).as(UIType.Json);
        assertEquals(gridJson, abstractRender.getResultForTest());
    }

    @Test
    public void testGridConvertToJsonWithNullAttribute() throws ConverterException {
        List<TestEmployee> testEmployeeList = new ArrayList<TestEmployee>();
        String gridJson = "{\"rows\":[{\"cell\":[1001,\"张三\",\"山东分公司\",null,\"权限\"],\"id\":\"1\"}],\"total\":1}";
        TestEmployee testEmployee = new TestEmployee(1L, BigDecimal.valueOf(1001), "张三", "山东分公司", null, "权限");
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
        AbstractRender abstractRender = (GridRender) UIUtil.with(gridable).as(UIType.Json);
        assertEquals(gridJson, abstractRender.getResultForTest());
    }

    @Test
    public void testGridConvertToJsonWithEmptyAttribute() throws ConverterException {
        List<TestEmployee> testEmployeeList = new ArrayList<TestEmployee>();
        String gridJson = "{\"rows\":[{\"cell\":[1001,\"张三\",\"山东分公司\",\"\",\"权限\"],\"id\":\"1\"}],\"total\":1}";
        TestEmployee testEmployee = new TestEmployee(1L, BigDecimal.valueOf(1001), "张三", "山东分公司", "", "权限");
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
        AbstractRender abstractRender = (GridRender) UIUtil.with(gridable).as(UIType.Json);
        assertEquals(gridJson, abstractRender.getResultForTest());
    }

    @Test
    public void testGridConvertToJsonWithOneData() throws ConverterException {
        List<TestEmployee> testEmployeeList = new ArrayList<TestEmployee>();
        String gridJson = "{\"rows\":[{\"cell\":[1001,\"张三\",\"山东分公司\",\"机构\",\"权限\"],\"id\":\"1\"}],\"total\":1}";
        TestEmployee testEmployee = new TestEmployee(1L, BigDecimal.valueOf(1001), "张三", "山东分公司", "机构", "权限");
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
        AbstractRender abstractRender = (GridRender) UIUtil.with(gridable).as(UIType.Json);
        assertEquals(gridJson, abstractRender.getResultForTest());
    }

    @Test
    public void testGridConvertToJsonWithListData() throws ConverterException {
        String gridJson = "{\"rows\":[{\"cell\":[1001,\"张三\",\"山东分公司1\",\"机构\",\"权限\"],\"id\":\"1\"},{\"cell\":[1002,\"张三2\",\"山东分公司\",\"机构\",\"权限\"],\"id\":\"2\"},{\"cell\":[1003,\"张三3\",\"山东分公司\",\"机构\",\"权限\"],\"id\":\"3\"},{\"cell\":[1004,\"张三4\",\"山东分公司\",\"机构\",\"权限\"],\"id\":\"4\"},{\"cell\":[1005,\"张三5\",\"山东分公司\",\"机构\",\"权限\"],\"id\":\"5\"},{\"cell\":[1006,\"张三6\",\"山东分公司\",\"机构\",\"权限\"],\"id\":\"6\"},{\"cell\":[1007,\"张三7\",\"山东分公司\",\"机构\",\"权限\"],\"id\":\"7\"},{\"cell\":[1008,\"张三8\",\"山东分公司\",\"机构\",\"权限\"],\"id\":\"8\"},{\"cell\":[1009,\"张三9\",\"山东分公司\",\"机构\",\"权限\"],\"id\":\"9\"},{\"cell\":[1010,\"张三10\",\"山东分公司\",\"机构\",\"权限\"],\"id\":\"10\"},{\"cell\":[1011,\"张三11\",\"山东分公司\",\"机构\",\"权限\"],\"id\":\"11\"}],\"total\":11}";
        Page page = new PageImpl(testEmployeeList);
        Gridable<TestEmployee> gridable = new Gridable<TestEmployee>(page);
        gridable.setIdField("id");
        testEmployeeAttributes.add("employeeNo");
        testEmployeeAttributes.add("name");
        testEmployeeAttributes.add("company");
        testEmployeeAttributes.add("organization");
        testEmployeeAttributes.add("operation");
        gridable.setCellListStringField(testEmployeeAttributes);
        UIUtil.with(gridable).as(UIType.Json);
    }

    @Test
    public void testGridConvertToJsonWithCellStringArray() throws ConverterException {
        String[] cellStringArray = new String[]{"employeeNo", "name", "company", "organization", "operation"};
        List<TestEmployee> testEmployeeList = new ArrayList<TestEmployee>();
        String gridJson = "{\"rows\":[{\"cell\":[1001,\"张三\",\"山东分公司\",\"机构\",\"权限\"],\"id\":\"1\"}],\"total\":1}";
        TestEmployee testEmployee = new TestEmployee(1L, BigDecimal.valueOf(1001), "张三", "山东分公司", "机构", "权限");
        testEmployeeList.add(testEmployee);
        Page page = new PageImpl(testEmployeeList);
        Gridable<TestEmployee> gridable = new Gridable<TestEmployee>(page);
        gridable.setIdField("id");
        gridable.setCellStringArrayField(cellStringArray);
        AbstractRender abstractRender = (GridRender) UIUtil.with(gridable).as(UIType.Json);
        assertEquals(gridJson, abstractRender.getResultForTest());
    }

    @Test
    public void testGridConvertToJsonWithCellString() throws ConverterException {
        //属性名是字符串时，属性名之间使用逗号分隔
        String cellString = new String("employeeNo,name,company,organization,operation");
        List<TestEmployee> testEmployeeList = new ArrayList<TestEmployee>();
        String gridJson = "{\"rows\":[{\"cell\":[1001,\"张三\",\"山东分公司\",\"机构\",\"权限\"],\"id\":\"1\"}],\"total\":1}";
        TestEmployee testEmployee = new TestEmployee(1L, BigDecimal.valueOf(1001), "张三", "山东分公司", "机构", "权限");
        testEmployeeList.add(testEmployee);
        Page page = new PageImpl(testEmployeeList);
        Gridable<TestEmployee> gridable = new Gridable<TestEmployee>(page);
        gridable.setIdField("id");
        gridable.setCellStringField(cellString);
        AbstractRender abstractRender = (GridRender) UIUtil.with(gridable).as(UIType.Json);
        assertEquals(gridJson, abstractRender.getResultForTest());
    }
}