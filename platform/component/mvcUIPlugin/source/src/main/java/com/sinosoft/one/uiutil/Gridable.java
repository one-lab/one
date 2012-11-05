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
    //@todo String[],String
    private String cellStringField;
    private String[] cellStringArrayField;
    private List<String> cellListStringField;

    private Page page;

    public Gridable(Page page) {
        this.page = page;
    }

    public Gridable(String idField, List<String> cellListStringField) {
        this.idField = idField;
        this.cellListStringField = cellListStringField;
    }

    public Gridable(String idField, String[] cellStringArrayField) {
        this.idField = idField;
        this.cellStringArrayField = cellStringArrayField;
    }

    public Gridable(String idField, String cellStringField) {
        this.idField = idField;
        this.cellStringField = cellStringField;
    }

    public Render getRender() {
        return new GridRender(new GridConverter(), this);
    }

    public String getIdField() {
        return idField;
    }

    public void setIdField(String idField) {
        this.idField = idField;
    }

    public String getCellStringField() {
        return cellStringField;
    }

    public void setCellStringField(String cellStringField) {
        this.cellStringField = cellStringField;
    }

    public String[] getCellStringArrayField() {
        return cellStringArrayField;
    }

    public void setCellStringArrayField(String[] cellStringArrayField) {
        this.cellStringArrayField = cellStringArrayField;
    }

    public List<String> getCellListStringField() {
        return cellListStringField;
    }

    public void setCellListStringField(List<String> cellListStringField) {
        this.cellListStringField = cellListStringField;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
