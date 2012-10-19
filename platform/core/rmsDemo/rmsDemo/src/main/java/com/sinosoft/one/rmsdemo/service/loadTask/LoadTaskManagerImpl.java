package com.sinosoft.one.rmsdemo.service.loadTask;

import com.google.common.collect.Lists;
import com.sinosoft.one.rmsdemo.model.FunctionList;
import com.sinosoft.one.rmsdemo.model.LoadTask;
import com.sinosoft.one.util.TreeNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ .
 * User: selineIDEA
 * Date: 12-9-24
 * Time: 上午11:05
 * To change this template use File | Settings | File Templates.
 */
@Service
public class LoadTaskManagerImpl implements LoadTaskManager {
    private final Map<String, LoadTask> loadTaskMap = new ConcurrentHashMap<String, LoadTask>();
    private final Map<String, FunctionList> functionListMap = new ConcurrentHashMap<String, FunctionList>();
    private final AtomicLong idValue = new AtomicLong();

    private static List<TreeNode> COMLIST;

    static {
        COMLIST = new ArrayList<TreeNode>();
        TreeNode node = new TreeNode("id_1","0","{\"id\": \"id_1\"}","财产保险公司北京分公司");
        node.getChildren().add(new TreeNode("","","{\"id\": \"id_1_1\"}","Only child"));
        node.getChildren().add(new TreeNode("","","{\"id\": \"id_1_2\"}","Long format demo"));
        TreeNode node1 = new TreeNode("id_2","1","{\"id\":\"id_2\"}","财产保险公司上海分公司");
        node1.getChildren().add(new TreeNode("","","{\"id\":\"id_2_1\"}","Only child"));
        node1.getChildren().add(new TreeNode("","","{\"id\":\"id_2_2\":\"id_one\"}","Long format demo"));
        TreeNode node2 = new TreeNode("id_3","2","{\"id\": \"id_1\"}","财产保险公司山东分公司");
        node2.getChildren().add(new TreeNode("","","{\"id\": \"id_3_1\"}","济南营业厅"));
        node2.getChildren().add(new TreeNode("","","{\"id\": \"id_3_2\"}","青岛营业厅"));
        node2.getChildren().add(new TreeNode("","","{\"id\": \"id_3_3\"}","威海营业厅"));
        TreeNode node3 = new TreeNode("id_4","3","{\"id\": \"id_1\"}","财产保险公司天津分公司");
        node3.getChildren().add(new TreeNode("","","{\"id\": \"id_4_1\"}","Only child"));
        node3.getChildren().add(new TreeNode("","","{\"id\": \"id_4_2\"}","Long format demo"));
        TreeNode node4 = new TreeNode("id_5","4","{\"id\": \"id_1\"}","财产保险公司天津分公司");
        node4.getChildren().add(new TreeNode("","","{\"id\": \"id_5_1\"}","Only child"));
        node4.getChildren().add(new TreeNode("","","{\"id\":\"id_5_2\":\"id_one\"}","Long format demo"));
        TreeNode node5 = new TreeNode("id_6","5","{\"id\": \"id_1\"}","财产保险公司河北分公司");
        node5.getChildren().add(new TreeNode("","","{\"id\": \"id_6_1\"}","Only child"));
        node5.getChildren().add(new TreeNode("","","{\"id\":\"id_6_2\":\"id_one\"}","Long format demo"));

        COMLIST.add(node);
        COMLIST.add(node1);
        COMLIST.add(node2);
        COMLIST.add(node3);
        COMLIST.add(node4);
        COMLIST.add(node5);
    }

    public LoadTaskManagerImpl(){
        super();
    }
    public String addLoadTask(LoadTask loadTask) {
        loadTask.setId(String.valueOf(idValue.getAndIncrement()));
        loadTaskMap.put(loadTask.getId(),loadTask);
        return loadTask.getId();
    }

    public void modifyLoadTask(LoadTask loadTask) {
        loadTaskMap.put(loadTask.getId(),loadTask);
    }

    public List<LoadTask> findAllLoadTask() {
        return Lists.newArrayList(loadTaskMap.values());
    }

    public List<FunctionList> findAllFunctionList() {
        functionListMap.put("大连分公司",new FunctionList("大连分公司","1号营业厅"));
        functionListMap.put("济南分公司",new FunctionList("济南分公司","2号营业厅"));
        return Lists.newArrayList(functionListMap.values());
    }

    public List<TreeNode> getAllTreeNodeList() {
        return COMLIST;
    }
}
