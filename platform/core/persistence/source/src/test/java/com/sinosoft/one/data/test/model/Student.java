package com.sinosoft.one.data.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-8-6
 * Time: 下午2:11
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_student")
public class Student {
    private String id;
    private String name;

    public Student() {

    }
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
