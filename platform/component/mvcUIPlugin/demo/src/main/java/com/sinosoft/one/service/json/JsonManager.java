package com.sinosoft.one.service.json;

import com.sinosoft.one.model.Group;
import com.sinosoft.one.model.NodeEntity;
import com.sinosoft.one.model.TestEmployee;
import com.sinosoft.one.uiutil.Gridable;
import com.sinosoft.one.uiutil.Treeable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 安全相关实体的管理类,包括用户和权限组.
 *
 * @author calvin
 */
//Spring Bean的标识.
@Component
//默认将类中的所有public函数纳入事务管理.
@Transactional(readOnly = true)
public class JsonManager {

    private static Logger logger = LoggerFactory.getLogger(JsonManager.class);
    private Long id;
    private String name;
    private String groupName;
    private String position;
    private Date createDate;
    private Date  updateDate;
    private BigDecimal employeeNo;
    private String company;
    private String organization;
    private String operation;
    private List<TestEmployee> testEmployeeList = new ArrayList<TestEmployee>();
    private List<Group> testGroupList = new ArrayList<Group>();
    private List<String> testEmployeeAttributes = new ArrayList<String>();

    private NodeEntity firstNodeEntity, secondNodeEntity, thirdNodeEntity, fourthNodeEntity, fiveNodeEntity, sixthNodeEntity, seventhNodeEntity;
    private List<NodeEntity> nodeEntityList1 = new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList2 = new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList3 = new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList4 = new ArrayList<NodeEntity>();

    public Gridable getGridableData() {
        for (int i = 1; i < 102; i++) {
            id = 1L + i;
            employeeNo = BigDecimal.valueOf(1000 + i);
            name = "王五" + i;
            company = "山东分公司" + i;
            organization = "<a href='#' class='agency' onclick='openWindow()'></a>";
            operation = "<a href='javascript:;' class='set' onclick='openQX();'>权限</a><a href='#' title='no operation' class='set dis'>数据设置</a>";
            TestEmployee testEmployee = new TestEmployee(id, employeeNo, name, company, organization, operation);
            testEmployeeList.add(testEmployee);
        }
        Page page = new PageImpl(testEmployeeList);
        Gridable<TestEmployee> gridable = new Gridable<TestEmployee>(page);
        gridable.setIdField("id");
        testEmployeeAttributes.add("employeeNo");
        testEmployeeAttributes.add("name");
        testEmployeeAttributes.add("company");
        testEmployeeAttributes.add("organization");
        testEmployeeAttributes.add("operation");
        gridable.setCellListStringField(testEmployeeAttributes);
        return gridable;
    }

    public Gridable getTreeableDataForGroup(){
        for (int i = 1; i < 102; i++) {
            id = 1L + i;
            groupName = "经理用户组" + i;
            position = "经理级别" + i;
            createDate = new Date(2012-04-16);
            updateDate = new Date(2012-05-23);
            operation = "<a href='javascript:;' class='set' onclick='openQX();'>修改</a><a href='#' title='no operation' class='set dis'>删除</a>";
            Group group = new Group(id, groupName, position, createDate, updateDate, operation);
            testGroupList.add(group);
        }
        Page page = new PageImpl(testGroupList);
        Gridable<Group> gridable = new Gridable<Group>(page);
        gridable.setIdField("id");
        testEmployeeAttributes.add("groupName");
        testEmployeeAttributes.add("position");
        testEmployeeAttributes.add("createDate");
        testEmployeeAttributes.add("updateDate");
        testEmployeeAttributes.add("operation");
        gridable.setCellListStringField(testEmployeeAttributes);
        return gridable;
    }

    public Treeable getTreeableData() {
        sixthNodeEntity = new NodeEntity("31", "大屯路营业厅", "classA2_1", "www.baiduA2_1.com", "close");
        seventhNodeEntity = new NodeEntity("32", "北苑路营业厅", "classA2_2", "www.baidu.comA2_2", "close");
        nodeEntityList4.add(sixthNodeEntity);
        nodeEntityList4.add(seventhNodeEntity);
        firstNodeEntity = new NodeEntity("11", "海淀分公司", "classA1", "www.baidu.comA1", "close");
        secondNodeEntity = new NodeEntity("12", "朝阳分公司", "classA2", "www.baidu.comA2", "close", nodeEntityList4);
        nodeEntityList1.add(firstNodeEntity);
        nodeEntityList1.add(secondNodeEntity);
        thirdNodeEntity = new NodeEntity("1", "财产保险公司北京分公司", "classA", "www.baidu.comA", "close", nodeEntityList1);
        fourthNodeEntity = new NodeEntity("21", "浦东分公司", "classB1", "www.baidu.comB1", "close");
        nodeEntityList2.add(fourthNodeEntity);
        fiveNodeEntity = new NodeEntity("2", "财产保险公司上海分公司", "classB", "www.baidu.comB", "close", nodeEntityList2);
        nodeEntityList3.add(thirdNodeEntity);
        nodeEntityList3.add(fiveNodeEntity);

        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList3, "id", "title", "children" ,"state").classField("classTag").urlField("url").builder();
        return treeable;
    }

}
