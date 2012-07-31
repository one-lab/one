/*
 * Copyright 2007-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sinosoft.one.mvc.web.portal.impl;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.sinosoft.one.mvc.web.portal.Window;
import com.sinosoft.one.mvc.web.portal.WindowRender;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * 
 *
 * 
 */
public class DefaultPipeRender implements WindowRender {

    public void render(Writer out, Window window) throws IOException {

        JSONObject json = new JSONObject();
        json.put("content", window.getContent());
        json.put("id", window.getName());

        // javascript
        JSONArray js = getAttributeAsArray(window, PipeImpl.WINDIW_JS);
        if (js != null && js.size() > 0) {
            json.put("js", js);
        }
        // css
        JSONArray css = getAttributeAsArray(window, PipeImpl.WINDOW_CSS);
        if (css != null && css.size() > 0) {
            json.put("css", css);
        }
        out.append("<script type=\"text/javascript\">");
        out.append("mvcpipe.addWindow(");
        out.append(json.toString());
        out.append(");");
        out.append("</script>");
        out.append('\n');
    }

    public static JSONArray getAttributeAsArray(Window window, String key) {
        Object value = window.get(key);
        if (value == null) {
            return null;
        }
        if (value instanceof Collection) {
        	ArrayList<Object> list = new ArrayList<Object>();
        	list.addAll((Collection<?>)value);
            return new JSONArray(list);
        } else if (!(value instanceof Object[])) {
            ArrayList<Object> list = new ArrayList<Object>();
            list.add(value);
            return new JSONArray(list);
        }
        ArrayList<Object> list = new ArrayList<Object>();
        list.addAll(Arrays.asList((Object[]) value));
        return new JSONArray(list);
    }
}
