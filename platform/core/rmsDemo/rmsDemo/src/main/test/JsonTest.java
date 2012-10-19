import com.sinosoft.one.rmsdemo.model.NodeEntity;

import com.sinosoft.one.rmsdemo.uiUtils.Treeable;
import com.sinosoft.one.rmsdemo.uiUtils.UIType;
import com.sinosoft.one.rmsdemo.uiUtils.UIUtil;

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
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JsonTest{
    private NodeEntity firstNodeEntity,secondNodeEntity,thirdNodeEntity,fourthNodeEntity,fiveNodeEntity;
    private List<NodeEntity> nodeEntityList1=new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList2=new ArrayList<NodeEntity>();
    private List<NodeEntity> nodeEntityList3=new ArrayList<NodeEntity>();;

    @Before
    public void setUp(){
        firstNodeEntity = new NodeEntity("11","A1_NODE",null,"close");
        secondNodeEntity = new NodeEntity("12","A2_NODE",null,"close");
        nodeEntityList1.add(firstNodeEntity);
        nodeEntityList1.add(secondNodeEntity);
        thirdNodeEntity = new NodeEntity("1","A_NODE",null,"close",nodeEntityList1);
        fourthNodeEntity = new NodeEntity("21","B1_NODE",null,"close");
        nodeEntityList2.add(fourthNodeEntity);
        fiveNodeEntity = new NodeEntity("2","B_NODE",null,"close",nodeEntityList2);
        nodeEntityList3.add(thirdNodeEntity);
        nodeEntityList3.add(fiveNodeEntity );
    }
    @Test
        public void testConvertToJson(){
        Treeable<NodeEntity> treeable=new Treeable<NodeEntity>(nodeEntityList3);
        treeable .setIdField("id");
        treeable .setTitleField("title");
        treeable .setUrlField("url");
        treeable .setStateField("state");
        treeable .setChildrenField("children");
        UIUtil.with(treeable ).as(UIType.Json);

    }
}