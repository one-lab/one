package com.sinosoft.one.uiutil;

import com.sinosoft.one.uiutil.exception.ConverterException;
import com.sinosoft.one.uiutil.model.NodeEntity;
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
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TreeJsonTest {
    private NodeEntity firstNodeEntity, secondNodeEntity, thirdNodeEntity, fourthNodeEntity, fiveNodeEntity, sixthNodeEntity, seventhNodeEntity;
    private List<NodeEntity> nodeEntityList1 = new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList2 = new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList3 = new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList4 = new ArrayList<NodeEntity>();

    @Before
    public void setUp() {
        sixthNodeEntity = new NodeEntity("31", "A2_1", "classA2_1", "www.A2_1.com", "close");
        seventhNodeEntity = new NodeEntity("32", "A2_2", "classA2_2", "www.A2_2.com", "close");
        nodeEntityList4.add(sixthNodeEntity);
        nodeEntityList4.add(seventhNodeEntity);
        firstNodeEntity = new NodeEntity("11", "A1", "classA1", "www.A1.com", "close");
        secondNodeEntity = new NodeEntity("12", "A2", "classA2", "www.A2.com", "close", nodeEntityList4);
        nodeEntityList1.add(firstNodeEntity);
        nodeEntityList1.add(secondNodeEntity);
        thirdNodeEntity = new NodeEntity("1", "A", "classA", "www.A.com", "close", nodeEntityList1);
        fourthNodeEntity = new NodeEntity("21", "B1", "classB1", "www.B1.com", "close");
        nodeEntityList2.add(fourthNodeEntity);
        fiveNodeEntity = new NodeEntity("2", "B", "classB", "www.B.com", "close", nodeEntityList2);
        nodeEntityList3.add(thirdNodeEntity);
        nodeEntityList3.add(fiveNodeEntity);
    }

    @Test
    public void testConvertToJsonWithNullObject() throws ConverterException {
        String treeJson = null;
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(null, "id", "title", "children", "state").classField("classTag").urlField("url").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithNullAttribute() throws ConverterException {
        List<NodeEntity> nodeEntityList = new ArrayList<NodeEntity>();
        nodeEntityList.add(new NodeEntity("1", "A jie dian", null, null, "close", null));
        String treeJson = "[{\"attr\":{\"id\":\"1\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"A jie dian\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList, "id", "title", "children", "state").classField("classTag").urlField("url").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithEmptyAttribute() throws ConverterException {
        List<NodeEntity> nodeEntityList = new ArrayList<NodeEntity>();
        nodeEntityList.add(new NodeEntity("1", "A jie dian", "", "", "close", null));
        String treeJson = "[{\"attr\":{\"id\":\"1\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"A jie dian\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList, "id", "title", "children", "state").classField("classTag").urlField("url").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithEmptyAttributeNoChildren() throws ConverterException {
        List<NodeEntity> nodeEntityList = new ArrayList<NodeEntity>();
        nodeEntityList.add(new NodeEntity("1", "A jie dian", "", "", "close"));
        String treeJson = "[{\"attr\":{\"id\":\"1\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"A jie dian\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList, "id", "title", "children", "state").classField("classTag").urlField("url").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithOneOptionAttribute() throws ConverterException {
        List<NodeEntity> nodeEntityList = new ArrayList<NodeEntity>();
        nodeEntityList.add(new NodeEntity("1", "A jie dian", "", "close"));
        String treeJson = "[{\"attr\":{\"id\":\"1\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"A jie dian\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList, "id", "title", "children", "state").urlField("url").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithNecessaryAttribute() throws ConverterException {
        NodeEntity childNodeEntity1 = new NodeEntity("31", "A2_1", "close");
        NodeEntity childNodeEntity2 = new NodeEntity("32", "A2_2", "close");
        List<NodeEntity> childNodeEntityList = new ArrayList<NodeEntity>();
        childNodeEntityList.add(childNodeEntity1);
        childNodeEntityList.add(childNodeEntity2);
        NodeEntity nodeEntity = new NodeEntity("12", "A2", "close", childNodeEntityList);
        List<NodeEntity> nodeEntityList = new ArrayList<NodeEntity>();
        nodeEntityList.add(nodeEntity);
        String treeJson = "[{\"attr\":{\"id\":\"12\"},\"children\":[{\"attr\":{\"id\":\"31\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"A2_1\"},\"state\":\"close\"},{\"attr\":{\"id\":\"32\"},\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"A2_2\"},\"state\":\"close\"}],\"data\":{\"attr\":{\"class\":\"\",\"href\":\"javascript:void(0);\"},\"title\":\"A2\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList, "id", "title", "children", "state").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithFullAttribute() throws ConverterException {
        String treeJson = "[{\"attr\":{\"id\":\"1\"},\"children\":[{\"attr\":{\"id\":\"11\"},\"data\":{\"attr\":{\"class\":\"classA1\",\"href\":\"www.A1.com\"}," +
                "\"title\":\"A1\"},\"state\":\"close\"},{\"attr\":{\"id\":\"12\"},\"children\":[{\"attr\":{\"id\":\"31\"}," +
                "\"data\":{\"attr\":{\"class\":\"classA2_1\",\"href\":\"www.A2_1.com\"},\"title\":\"A2_1\"},\"state\":\"close\"}," +
                "{\"attr\":{\"id\":\"32\"},\"data\":{\"attr\":{\"class\":\"classA2_2\",\"href\":\"www.A2_2.com\"},\"title\":\"A2_2\"}," +
                "\"state\":\"close\"}],\"data\":{\"attr\":{\"class\":\"classA2\",\"href\":\"www.A2.com\"},\"title\":\"A2\"},\"state\":\"close\"}]," +
                "\"data\":{\"attr\":{\"class\":\"classA\",\"href\":\"www.A.com\"},\"title\":\"A\"},\"state\":\"close\"},{\"attr\":{\"id\":\"2\"}," +
                "\"children\":[{\"attr\":{\"id\":\"21\"},\"data\":{\"attr\":{\"class\":\"classB1\",\"href\":\"www.B1.com\"},\"title\":\"B1\"}," +
                "\"state\":\"close\"}],\"data\":{\"attr\":{\"class\":\"classB\",\"href\":\"www.B.com\"},\"title\":\"B\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList3, "id", "title", "children", "state").classField("classTag").urlField("url").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        assertEquals(treeJson, abstractRender.getResultForTest());
    }
}