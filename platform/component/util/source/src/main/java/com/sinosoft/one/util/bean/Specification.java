package com.sinosoft.one.util.bean;

/**
 * 属性处理，T为当前处理的属性类型
 * User: cq
 * Date: 13-1-6
 * Time: PM3:53
 */
public interface Specification<T> {


     T deal(T t);

}
