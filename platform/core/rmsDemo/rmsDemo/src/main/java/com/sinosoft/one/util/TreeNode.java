package com.sinosoft.one.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-9-26
 * Time: 上午11:49
 * To change this template use File | Settings | File Templates.
 */
public class TreeNode {

    private String id;
    private String  pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    private String attr;
    private String data;
    private List<TreeNode> children = new ArrayList<TreeNode>();
    private String state = "close";

    public TreeNode(String id,String pid,String attr,String data){
        this.id = id;
        this.pid = pid;
        this.attr = attr;
        this.data = data;
    }

    public String getId() {
        return id;
    }

//    public String getPid() {
//        return pid;
//    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
