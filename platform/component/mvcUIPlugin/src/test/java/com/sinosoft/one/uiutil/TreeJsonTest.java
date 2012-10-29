package com.sinosoft.one.uiutil;

import com.sinosoft.one.uiutil.model.Course;
import com.sinosoft.one.uiutil.model.NodeEntity;
import com.sinosoft.one.uiutil.model.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TreeJsonTest {
    private NodeEntity firstNodeEntity,secondNodeEntity,thirdNodeEntity,fourthNodeEntity,fiveNodeEntity,sixthNodeEntity,seventhNodeEntity,
            eigheNodeEntity;
    private List<NodeEntity> nodeEntityList1=new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList2=new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList3=new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList4=new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList5 = new ArrayList<NodeEntity>();

    private Course firstCourse,secondeCourse,thireCourse,fourCourse,fiveCourse,sixCourse,seventhCourse;
    private Student firstStrudent,secondStudent,thirdStudent,fourStudent,fiveStudent,sixStudent,seventhStudent;
    private List<Course> nodeCourse = new ArrayList<Course>();
    private List<Student> nodeStudentList1 = new ArrayList<Student>();
    private List<Student> nodeStudentList2 = new ArrayList<Student>();
    private List<Student> nodeStudentList3 = new ArrayList<Student>();
    private List<Student> nodeStudentList4 = new ArrayList<Student>();

    @Before
    public void setUp(){
        sixthNodeEntity = new NodeEntity("31","A2 de zi jie dian A2_1","classA2_1","www.baiduA2_1.com","close");
        seventhNodeEntity = new NodeEntity("32","A2 de zi jie dian A2_2","classA2_2","www.baidu.comA2_2","close");
        nodeEntityList4.add(sixthNodeEntity ) ;
        nodeEntityList4.add(seventhNodeEntity ) ;
        firstNodeEntity = new NodeEntity("11","A de zi jie dian A1","classA1","www.baidu.comA1","close");
        secondNodeEntity = new NodeEntity("12","A de zi jie dian A2","classA2","www.baidu.comA2","close",nodeEntityList4);
        nodeEntityList1.add(firstNodeEntity);
        nodeEntityList1.add(secondNodeEntity);
        thirdNodeEntity = new NodeEntity("1","A jie dian","classA","www.baidu.comA","close",nodeEntityList1);
        fourthNodeEntity = new NodeEntity("21","B de zi jie dian B1","classB1","www.baidu.comB1","close");
        nodeEntityList2.add(fourthNodeEntity);
        fiveNodeEntity = new NodeEntity("2","B jie dian","classB","www.baidu.comB","close",nodeEntityList2);
        nodeEntityList3.add(thirdNodeEntity);
        nodeEntityList3.add(fiveNodeEntity );
        eigheNodeEntity = new NodeEntity("31","A2 de zi jie dian A2_1","","www.baiduA2_1.com","close");
        nodeEntityList5.add(eigheNodeEntity);
    }
    @Before
    public  void setUp2(){
        firstStrudent = new Student("31","测试","classA2_1","","close");
        secondStudent = new Student("32","A2 ","classA2_2","","close",nodeCourse);
        firstCourse = new Course("A1","第一个子节点","",null,"");
        secondeCourse = new Course("A2","第二个子节点","","","");
        nodeCourse.add(firstCourse);
        nodeCourse.add(secondeCourse);
        nodeStudentList1.add(firstStrudent);
        nodeStudentList1.add(secondStudent);
    }
    @Test
    public void testConvertToJson(){
        Treeable<NodeEntity> treeable=new Treeable<NodeEntity>(nodeEntityList3);
        treeable .setIdField("id");
        treeable .setTitleField("title");
        treeable.setClassField("classTag");
        treeable .setUrlField("url");
        treeable .setStateField("state");
        treeable .setChildrenField("children");
        UIUtil.with(treeable ).as(UIType.Json);

    }
    @Test
    public void testConverToJson2(){
        Treeable<Student> treeable = new Treeable<Student>(nodeStudentList1);
        treeable .setIdField("id");
        treeable .setTitleField("title");
        treeable.setClassField("classTag");
        treeable .setUrlField("url");
        treeable .setStateField("state");
        treeable .setChildrenField("children");
        UIUtil.with(treeable ).as(UIType.Json);
    }
    @Test
    public void  testConvertToJson2(){}

}