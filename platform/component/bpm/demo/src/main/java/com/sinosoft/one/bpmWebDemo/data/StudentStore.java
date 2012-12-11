package com.sinosoft.one.bpmWebDemo.data;

import com.sinosoft.one.bpmWebDemo.domain.Student;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-8-16
 * Time: 下午3:06
 * To change this template use File | Settings | File Templates.
 */

public interface StudentStore{
    public void saveStudent(Student student);
    public Student findStudent(String id);
}
