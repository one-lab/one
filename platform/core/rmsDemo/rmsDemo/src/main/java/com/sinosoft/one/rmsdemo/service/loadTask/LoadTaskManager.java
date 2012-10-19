package com.sinosoft.one.rmsdemo.service.loadTask;

import com.sinosoft.one.rmsdemo.model.FunctionList;
import com.sinosoft.one.rmsdemo.model.LoadTask;
import com.sinosoft.one.util.TreeNode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-9-24
 * Time: 上午11:05
 * To change this template use File | Settings | File Templates.
 */
public interface LoadTaskManager {
    String addLoadTask(LoadTask loadTask);
    void modifyLoadTask(LoadTask loadTask);
    List<LoadTask> findAllLoadTask();
    List<FunctionList>findAllFunctionList();
    List<TreeNode> getAllTreeNodeList();
}
