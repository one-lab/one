package com.sinosoft.one.model;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-10-26
 * Time: 上午11:06
 * To change this template use File | Settings | File Templates.
 */
public class Test1Date {
    private Long id;
    private String name;
    private Integer age;

    public Test1Date(Long id, String name, Integer age) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
