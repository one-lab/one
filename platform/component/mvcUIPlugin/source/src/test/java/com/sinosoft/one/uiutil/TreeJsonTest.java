package com.sinosoft.one.uiutil;

import com.sinosoft.one.uiutil.exception.ConverterException;
import com.sinosoft.one.uiutil.model.NodeEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TreeJsonTest {
    private NodeEntity firstNodeEntity, secondNodeEntity, thirdNodeEntity, fourthNodeEntity, fiveNodeEntity, sixthNodeEntity, seventhNodeEntity;
    private List<NodeEntity> nodeEntityList1 = new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList2 = new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList3 = new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList4 = new ArrayList<NodeEntity>();

    @Before
    public void setUp() {
        sixthNodeEntity = new NodeEntity("31", "A2_1", "close","classA2_1", "www.A2_1.com");
        seventhNodeEntity = new NodeEntity("32", "A2_2", "close","classA2_2", "www.A2_2.com");
        nodeEntityList4.add(sixthNodeEntity);
        nodeEntityList4.add(seventhNodeEntity);
        firstNodeEntity = new NodeEntity("11", "A1", "close", "classA1", "www.A1.com");
        secondNodeEntity = new NodeEntity("12", "A2",nodeEntityList4, "close","classA2", "www.A2.com");
        nodeEntityList1.add(firstNodeEntity);
        nodeEntityList1.add(secondNodeEntity);
        thirdNodeEntity = new NodeEntity("1", "A", nodeEntityList1, "close","classA", "www.A.com");
        fourthNodeEntity = new NodeEntity("21", "B1", "close","classB1", "www.B1.com");
        nodeEntityList2.add(fourthNodeEntity);
        fiveNodeEntity = new NodeEntity("2", "B", nodeEntityList2, "close", "classB", "www.B.com");
        nodeEntityList3.add(thirdNodeEntity);
        nodeEntityList3.add(fiveNodeEntity);
    }

    @Test
    public void testConvertToJsonWithNullObject() throws ConverterException {
        String treeJson = null;
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(null, "id", "title", "children", "state").classField("classField").urlField("urlField").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithNullAttribute() throws ConverterException {
        List<NodeEntity> nodeEntityList = new ArrayList<NodeEntity>();
        nodeEntityList.add(new NodeEntity("1", "A jie dian", null, "close", null, null));
        String treeJson = "[{\"attr\":{\"class\":\"\",\"id\":\"1\"},\"data\":{\"attr\":{\"href\":\"javascript:void(0);\"},\"title\":\"A jie dian\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList, "id", "title", "children", "state").classField("classField").urlField("urlField").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithEmptyAttribute() throws ConverterException {
        List<NodeEntity> nodeEntityList = new ArrayList<NodeEntity>();
        nodeEntityList.add(new NodeEntity("1", "A jie dian", null, "close","", ""));
        String treeJson = "[{\"attr\":{\"class\":\"\",\"id\":\"1\"},\"data\":{\"attr\":{\"href\":\"javascript:void(0);\"},\"title\":\"A jie dian\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList, "id", "title", "children", "state").classField("classField").urlField("urlField").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithEmptyAttributeNoChildren() throws ConverterException {
        List<NodeEntity> nodeEntityList = new ArrayList<NodeEntity>();
        nodeEntityList.add(new NodeEntity("1", "A jie dian", "close", "", ""));
        String treeJson = "[{\"attr\":{\"class\":\"\",\"id\":\"1\"},\"data\":{\"attr\":{\"href\":\"javascript:void(0);\"},\"title\":\"A jie dian\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList, "id", "title", "children", "state").classField("classField").urlField("urlField").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithOneOptionAttribute() throws ConverterException {
        List<NodeEntity> nodeEntityList = new ArrayList<NodeEntity>();
        NodeEntity nodeEntity=new NodeEntity("1", "A jie dian", "close");
        nodeEntity.setUrlField("");
        nodeEntityList.add(nodeEntity);
        String treeJson = "[{\"attr\":{\"class\":\"\",\"id\":\"1\"},\"data\":{\"attr\":{\"href\":\"javascript:void(0);\"},\"title\":\"A jie dian\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList, "id", "title", "children", "state").urlField("urlField").builder();
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
        NodeEntity nodeEntity = new NodeEntity("12", "A2", childNodeEntityList, "close");
        List<NodeEntity> nodeEntityList = new ArrayList<NodeEntity>();
        nodeEntityList.add(nodeEntity);
        String treeJson = "[{\"attr\":{\"class\":\"\",\"id\":\"12\"},\"children\":[{\"attr\":{\"class\":\"\",\"id\":\"31\"},\"data\":{\"attr\":{\"href\":\"javascript:void(0);\"},\"title\":\"A2_1\"},\"state\":\"close\"},{\"attr\":{\"class\":\"\",\"id\":\"32\"},\"data\":{\"attr\":{\"href\":\"javascript:void(0);\"},\"title\":\"A2_2\"},\"state\":\"close\"}],\"data\":{\"attr\":{\"href\":\"javascript:void(0);\"},\"title\":\"A2\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList, "id", "title", "children", "state").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithFullAttribute() throws ConverterException {
        String treeJson = "[{\"attr\":{\"class\":\"classA\",\"id\":\"1\"},\"children\":[{\"attr\":{\"class\":\"classA1\",\"id\":\"11\"},\"data\":{\"attr\":{\"href\":\"www.A1.com\"},\"title\":\"A1\"},\"state\":\"close\"},{\"attr\":{\"class\":\"classA2\",\"id\":\"12\"},\"children\":[{\"attr\":{\"class\":\"classA2_1\",\"id\":\"31\"},\"data\":{\"attr\":{\"href\":\"www.A2_1.com\"},\"title\":\"A2_1\"},\"state\":\"close\"},{\"attr\":{\"class\":\"classA2_2\",\"id\":\"32\"},\"data\":{\"attr\":{\"href\":\"www.A2_2.com\"},\"title\":\"A2_2\"},\"state\":\"close\"}],\"data\":{\"attr\":{\"href\":\"www.A2.com\"},\"title\":\"A2\"},\"state\":\"close\"}],\"data\":{\"attr\":{\"href\":\"www.A.com\"},\"title\":\"A\"},\"state\":\"close\"},{\"attr\":{\"class\":\"classB\",\"id\":\"2\"},\"children\":[{\"attr\":{\"class\":\"classB1\",\"id\":\"21\"},\"data\":{\"attr\":{\"href\":\"www.B1.com\"},\"title\":\"B1\"},\"state\":\"close\"}],\"data\":{\"attr\":{\"href\":\"www.B.com\"},\"title\":\"B\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList3, "id", "title", "children", "state").classField("classField").urlField("urlField").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithEmptyTypeAttribute() throws ConverterException {
        NodeEntity childNodeEntity1 = new NodeEntity("31", "A3_1", "close","classA3_1","www.test31.com");
        //节点有type属性，生成的json数据就有type属性
        childNodeEntity1.setTypeField("");
        //节点没有type属性，生成的json数据就没有type属性
        NodeEntity childNodeEntity2 = new NodeEntity("32", "A3_2", "close","classA3_2","www.test32.com");
        List<NodeEntity> childNodeEntityList = new ArrayList<NodeEntity>();
        childNodeEntityList.add(childNodeEntity1);
        childNodeEntityList.add(childNodeEntity2);
        NodeEntity nodeEntity = new NodeEntity("2", "A2", childNodeEntityList, "close","classA2","www.test2.com");
        nodeEntity.setTypeField("");
        List<NodeEntity> nodeEntityList = new ArrayList<NodeEntity>();
        nodeEntityList.add(nodeEntity);
        String treeJson = "[{\"attr\":{\"class\":\"classA2\",\"id\":\"2\"},\"children\":[{\"attr\":{\"class\":\"classA3_1\",\"id\":\"31\"},\"data\":{\"attr\":{\"href\":\"www.test31.com\"},\"title\":\"A3_1\"},\"state\":\"close\"},{\"attr\":{\"class\":\"classA3_2\",\"id\":\"32\"},\"data\":{\"attr\":{\"href\":\"www.test32.com\"},\"title\":\"A3_2\"},\"state\":\"close\"}],\"data\":{\"attr\":{\"href\":\"www.test2.com\"},\"title\":\"A2\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList, "id", "title", "children", "state").classField("classField").urlField("urlField").typeField("typeField").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        System.out.println(abstractRender.getResultForTest().toString());
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithNullTypeAttribute() throws ConverterException {
        NodeEntity childNodeEntity1 = new NodeEntity("31", "A3_1", "close","classA3_1","www.test31.com");
        //节点有type属性，生成的json数据就有type属性
        childNodeEntity1.setTypeField(null);
        //节点没有type属性，生成的json数据就没有type属性
        NodeEntity childNodeEntity2 = new NodeEntity("32", "A3_2", "close","classA3_2","www.test32.com");
        List<NodeEntity> childNodeEntityList = new ArrayList<NodeEntity>();
        childNodeEntityList.add(childNodeEntity1);
        childNodeEntityList.add(childNodeEntity2);
        NodeEntity nodeEntity = new NodeEntity("2", "A2", childNodeEntityList, "close","classA2","www.test2.com");
        nodeEntity.setTypeField(null);
        List<NodeEntity> nodeEntityList = new ArrayList<NodeEntity>();
        nodeEntityList.add(nodeEntity);
        String treeJson = "[{\"attr\":{\"class\":\"classA2\",\"id\":\"2\"},\"children\":[{\"attr\":{\"class\":\"classA3_1\",\"id\":\"31\"},\"data\":{\"attr\":{\"href\":\"www.test31.com\"},\"title\":\"A3_1\"},\"state\":\"close\"},{\"attr\":{\"class\":\"classA3_2\",\"id\":\"32\"},\"data\":{\"attr\":{\"href\":\"www.test32.com\"},\"title\":\"A3_2\"},\"state\":\"close\"}],\"data\":{\"attr\":{\"href\":\"www.test2.com\"},\"title\":\"A2\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList, "id", "title", "children", "state").classField("classField").urlField("urlField").typeField("typeField").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        System.out.println(abstractRender.getResultForTest().toString());
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithTypeAttribute() throws ConverterException {
        NodeEntity childNodeEntity1 = new NodeEntity("31", "A3_1", "close","classA3_1","www.test31.com");
        //节点有type属性，生成的json数据就有type属性
        childNodeEntity1.setTypeField("民用飞机");
        //节点没有type属性，生成的json数据就没有type属性
        NodeEntity childNodeEntity2 = new NodeEntity("32", "A3_2", "close","classA3_2","www.test32.com");
        List<NodeEntity> childNodeEntityList = new ArrayList<NodeEntity>();
        childNodeEntityList.add(childNodeEntity1);
        childNodeEntityList.add(childNodeEntity2);
        NodeEntity nodeEntity = new NodeEntity("2", "A2", childNodeEntityList, "close","classA2","www.test2.com");
        nodeEntity.setTypeField("飞机类型");
        List<NodeEntity> nodeEntityList = new ArrayList<NodeEntity>();
        nodeEntityList.add(nodeEntity);
        String treeJson = "[{\"attr\":{\"class\":\"classA2\",\"id\":\"2\",\"type\":\"飞机类型\"},\"children\":[{\"attr\":{\"class\":\"classA3_1\",\"id\":\"31\",\"type\":\"民用飞机\"},\"data\":{\"attr\":{\"href\":\"www.test31.com\"},\"title\":\"A3_1\"},\"state\":\"close\"},{\"attr\":{\"class\":\"classA3_2\",\"id\":\"32\"},\"data\":{\"attr\":{\"href\":\"www.test32.com\"},\"title\":\"A3_2\"},\"state\":\"close\"}],\"data\":{\"attr\":{\"href\":\"www.test2.com\"},\"title\":\"A2\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList, "id", "title", "children", "state").classField("classField").urlField("urlField").typeField("typeField").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        System.out.println(abstractRender.getResultForTest().toString());
        assertEquals(treeJson, abstractRender.getResultForTest());
    }

    @Test
    public void testConvertToJsonWithNullAndEmptyTypeAttribute() throws ConverterException {
        NodeEntity childNodeEntity1 = new NodeEntity("31", "A3_1", "close","classA3_1","www.test31.com");
        //节点有type属性，生成的json数据就有type属性
        childNodeEntity1.setTypeField(null);
        //节点没有type属性，生成的json数据就没有type属性
        NodeEntity childNodeEntity2 = new NodeEntity("32", "A3_2", "close","classA3_2","www.test32.com");
        childNodeEntity2.setTypeField("");
        List<NodeEntity> childNodeEntityList = new ArrayList<NodeEntity>();
        childNodeEntityList.add(childNodeEntity1);
        childNodeEntityList.add(childNodeEntity2);
        NodeEntity nodeEntity = new NodeEntity("2", "A2", childNodeEntityList, "close","classA2","www.test2.com");
        nodeEntity.setTypeField("飞机类型");
        List<NodeEntity> nodeEntityList = new ArrayList<NodeEntity>();
        nodeEntityList.add(nodeEntity);
        String treeJson = "[{\"attr\":{\"class\":\"classA2\",\"id\":\"2\",\"type\":\"飞机类型\"},\"children\":[{\"attr\":{\"class\":\"classA3_1\",\"id\":\"31\"},\"data\":{\"attr\":{\"href\":\"www.test31.com\"},\"title\":\"A3_1\"},\"state\":\"close\"},{\"attr\":{\"class\":\"classA3_2\",\"id\":\"32\"},\"data\":{\"attr\":{\"href\":\"www.test32.com\"},\"title\":\"A3_2\"},\"state\":\"close\"}],\"data\":{\"attr\":{\"href\":\"www.test2.com\"},\"title\":\"A2\"},\"state\":\"close\"}]";
        Treeable<NodeEntity> treeable = new Treeable.Builder<NodeEntity>(nodeEntityList, "id", "title", "children", "state").classField("classField").urlField("urlField").typeField("typeField").builder();
        AbstractRender abstractRender = (TreeRender) UIUtil.with(treeable).as(UIType.Json);
        System.out.println(abstractRender.getResultForTest().toString());
        assertEquals(treeJson, abstractRender.getResultForTest());
    }
}