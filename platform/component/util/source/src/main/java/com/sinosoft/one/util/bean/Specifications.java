package com.sinosoft.one.util.bean;

import org.apache.commons.lang.StringUtils;

/**
 * Specification的处理集合类
 * User: cq
 * Date: 13-1-8
 * Time: PM2:54
 */
public abstract class Specifications {

    /**
     * 去除右边空格
     * @return
     */
    public static Specification<String>  TrimRight(){
       return new Specification<String>() {
              public String deal(String o) {
                  return StringUtils.stripEnd(o, null);
              }
          };
    }
}
