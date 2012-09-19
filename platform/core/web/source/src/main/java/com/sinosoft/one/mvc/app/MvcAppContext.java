/*
* Copyright 2007-2009 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.sinosoft.one.mvc.app;

/**
 * <strong>此类将在2010-06-01删除</strong>，请现在立即改使用另外一个package的同名类
 * {@link com.sinosoft.one.mvc.scanning.context.MvcAppContext}
 * <p>
 * 
 * @deprecated
 * 
 *
 * @author han.liao [in355hz@gmail.com]
 */
@Deprecated
public class MvcAppContext extends com.sinosoft.one.mvc.scanning.context.MvcAppContext {

    /**
     * 创建 MvcAppContext.
     * 
     */
    public MvcAppContext() {
        super();
    }

    /**
     * 创建 MvcAppContext.
     * 
     * @param packages - "com.xiaonei.yourapp, com.xiaonei.myapp" ... <br>
     *        表示加载这些package所在的jar或根class目录的/applicationContext*.xml文件
     */
    public MvcAppContext(String packages, boolean refresh) {
        super(packages, refresh);
    }

}
