package com.sinosoft.one.uiutil;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-24
 * Time: 上午9:59
 * To change this template use File | Settings | File Templates.
 */
public class Gridable<T> implements UIable {
    private String idField;
    private List<String> cellField;//@todo cellFields 还可以是 String "a,b,c" 和 String[] 类型的 需要提供重载方法。
    private Page page;//@todo content 可以使page 或者list page需要明确泛型

    public Gridable(Page page) {
        this.page = page;
    }

    public Gridable(String idField, List<String> cellField) {
        this.idField = idField;
        this.cellField = cellField;
    }
	//@todo
    public Render getRender() {
        return new TreeRender(new GridConverter(), this);
    }

    public String getIdField() {
        return idField;
    }

    public void setIdField(String idField) {
        this.idField = idField;
    }

    public List<String> getCellField() {
        return cellField;
    }

    public void setCellField(List<String> cellField) {
        this.cellField = cellField;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
