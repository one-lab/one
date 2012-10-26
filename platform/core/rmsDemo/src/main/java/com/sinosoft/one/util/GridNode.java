package com.sinosoft.one.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-10-11
 * Time: 上午11:21
 * To change this template use File | Settings | File Templates.
 */
public class GridNode {
    private String id;
    private String pid;
    private String total;
    private String rows;
    private List<GridNode> cell = new ArrayList<GridNode>();

    public  GridNode(String id,String pid,String total,String rows){
        this.id = id;
        this.pid = pid;
        this.rows = rows;
        this.total = total;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public List<GridNode> getCell() {
        return cell;
    }

    public void setCell(List<GridNode> cell) {
        this.cell = cell;
    }
}
