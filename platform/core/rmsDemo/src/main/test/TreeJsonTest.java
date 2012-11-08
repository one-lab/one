import com.sinosoft.one.model.Course;
import com.sinosoft.one.model.NodeEntity;

import com.sinosoft.one.model.Student;
import com.sinosoft.one.uiUtils.*;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TreeJsonTest {
    private NodeEntity firstNodeEntity,secondNodeEntity,thirdNodeEntity,fourthNodeEntity,fiveNodeEntity,sixthNodeEntity,seventhNodeEntity,
            eigheNodeEntity;
    private List<NodeEntity> nodeEntityList1=new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList2=new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList3=new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList4=new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList5 = new ArrayList<NodeEntity>();
    private  Course firstCourse,secondeCourse,thireCourse,fourCourse,fiveCourse,sixCourse,seventhCourse;
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
        firstStrudent = new Student("31","测试","classA2_1","","close");
        secondStudent = new Student("32","A2 ","classA2_2","","close",nodeCourse);
        firstCourse = new Course("A1","第一个子节点","","","");
        secondeCourse = new Course("A2","第二个子节点","","","");
        thireCourse = new Course("A3","第三个子节点",null,"","");
        nodeCourse.add(firstCourse);
        nodeCourse.add(secondeCourse);
        nodeCourse.add(thireCourse);
        nodeStudentList1.add(firstStrudent);
        nodeStudentList1.add(secondStudent);
        thirdStudent = new Student("3","A3节点","","www.baiduA2_1.com","close",nodeCourse);
        fourStudent = new Student("4","A4节点","classA2_1","","close",nodeCourse);

        nodeStudentList2.add(thirdStudent);
        nodeStudentList2.add(fourStudent);
    }
    @Test
    public void testConvertToJson(){
        String tree = "[{\"attr\":{\"id\":\"1\"},\"children\":[{\"attr\":{\"id\":\"11\"},\"data\":{\"attr\":{\"class\":\"classA1\",\"href\":\"www.baidu.comA1\"},\"title\":\"A de zi jie dian A1\"},\"state\":\"close\"},{\"attr\":{\"id\":\"12\"},\"children\":[{\"attr\":{\"id\":\"31\"},\"data\":{\"attr\":{\"class\":\"classA2_1\",\"href\":\"www.baiduA2_1.com\"},\"title\":\"A2 de zi jie dian A2_1\"},\"state\":\"close\"},{\"attr\":{\"id\":\"32\"},\"data\":{\"attr\":{\"class\":\"classA2_2\",\"href\":\"www.baidu.comA2_2\"},\"title\":\"A2 de zi jie dian A2_2\"},\"state\":\"close\"}],\"data\":{\"attr\":{\"class\":\"classA2\",\"href\":\"www.baidu.comA2\"},\"title\":\"A de zi jie dian A2\"},\"state\":\"close\"}],\"data\":{\"attr\":{\"class\":\"classA\",\"href\":\"www.baidu.comA\"},\"title\":\"A jie dian\"},\"state\":\"close\"},{\"attr\":{\"id\":\"2\"},\"children\":[{\"attr\":{\"id\":\"21\"},\"data\":{\"attr\":{\"class\":\"classB1\",\"href\":\"www.baidu.comB1\"},\"title\":\"B de zi jie dian B1\"},\"state\":\"close\"}],\"data\":{\"attr\":{\"class\":\"classB\",\"href\":\"www.baidu.comB\"},\"title\":\"B jie dian\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable=new Treeable<NodeEntity>(nodeEntityList3);
        treeable .setIdField("id");
        treeable .setTitleField("title");
        treeable.setClassField("classTag");
        treeable .setUrlField("url");
        treeable .setStateField("state");
        treeable .setChildrenField("children");
        AbstractRender abstractRender= (AbstractRender) UIUtil.with(treeable).as(UIType.Json);
        String str=abstractRender.getResult();
        assertEquals(tree,str);

    }



    //测试不同对象
    @Test
    public void testConverToJsonDiffObj(){
        String tree2 = "[{\"attr\":{\"id\":\"31\"},\"data\":{\"attr\":{\"class\":\"classA2_1\",\"href\":\"javascript:void(0);\"},\"title\":\"测试\"},\"state\":\"close\"},{\"attr\":{\"id\":\"32\"},\"children\":[{\"attr\":{\"id\":\"A1\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"第一个子节点\"},\"state\":\"\"},{\"attr\":{\"id\":\"A2\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"第二个子节点\"},\"state\":\"\"},{\"attr\":{\"id\":\"A3\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"第三个子节点\"},\"state\":\"\"}],\"data\":{\"attr\":{\"class\":\"classA2_2\",\"href\":\"javascript:void(0);\"},\"title\":\"A2 \"},\"state\":\"close\"}]";
        Treeable<Student> treeable = new Treeable<Student>(nodeStudentList1);
        treeable .setIdField("id");
        treeable .setTitleField("title");
        treeable.setClassField("classTag");
        treeable .setUrlField("url");
        treeable .setStateField("state");
        treeable .setChildrenField("children");
       AbstractRender abstractRender = (AbstractRender) UIUtil.with(treeable).as(UIType.Json);
        String str = abstractRender.getResult();
        assertEquals(tree2,str);
    }
    //当其中class为null的情况
    @Test
    public void  testConvertToJsonWithNullAttr(){
        String tree3 = "[{\"attr\":{\"id\":\"31\"},\"data\":{\"attr\":{\"class\":\"classA2_1\",\"href\":\"javascript:void(0);\"},\"title\":\"测试\"},\"state\":\"close\"},{\"attr\":{\"id\":\"32\"},\"children\":[{\"attr\":{\"id\":\"A1\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"第一个子节点\"},\"state\":\"\"},{\"attr\":{\"id\":\"A2\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"第二个子节点\"},\"state\":\"\"},{\"attr\":{\"id\":\"A3\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"第三个子节点\"},\"state\":\"\"}],\"data\":{\"attr\":{\"class\":\"classA2_2\",\"href\":\"javascript:void(0);\"},\"title\":\"A2 \"},\"state\":\"close\"}]";
        Treeable<Student> treeable = new Treeable<Student>(nodeStudentList1);
        treeable .setIdField("id");
        treeable .setTitleField("title");
        treeable.setClassField("classTag");
        treeable .setUrlField("url");
        treeable .setStateField("state");
        treeable .setChildrenField("children");
        AbstractRender abstractRender = (AbstractRender) UIUtil.with(treeable).as(UIType.Json);
        String str = abstractRender.getResult();
        assertEquals(tree3,str);
    }
    //当某项或者多项值为空的情况下
    @Test
    public void testConverToJsonWithEmptyAttr(){
        String tree4 = "[{\"attr\":{\"id\":\"3\"},\"children\":[{\"attr\":{\"id\":\"A1\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"第一个子节点\"},\"state\":\"\"},{\"attr\":{\"id\":\"A2\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"第二个子节点\"},\"state\":\"\"},{\"attr\":{\"id\":\"A3\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"第三个子节点\"},\"state\":\"\"}],\"data\":{\"attr\":{\"class\":\"\",\"href\":\"www.baiduA2_1.com\"},\"title\":\"A3节点\"},\"state\":\"close\"},{\"attr\":{\"id\":\"4\"},\"children\":[{\"attr\":{\"id\":\"A1\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"第一个子节点\"},\"state\":\"\"},{\"attr\":{\"id\":\"A2\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"第二个子节点\"},\"state\":\"\"},{\"attr\":{\"id\":\"A3\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"第三个子节点\"},\"state\":\"\"}],\"data\":{\"attr\":{\"class\":\"classA2_1\",\"href\":\"javascript:void(0);\"},\"title\":\"A4节点\"},\"state\":\"close\"}]";
        Treeable<Student> treeable = new Treeable<Student>(nodeStudentList2);
        treeable .setIdField("id");
        treeable .setTitleField("title");
        treeable.setClassField("classTag");
        treeable .setUrlField("url");
        treeable .setStateField("state");
        treeable .setChildrenField("children");
        AbstractRender abstractRender = (AbstractRender) UIUtil.with(treeable).as(UIType.Json);
        String str = abstractRender.getResult();
        assertEquals(tree4,str);
    }
}