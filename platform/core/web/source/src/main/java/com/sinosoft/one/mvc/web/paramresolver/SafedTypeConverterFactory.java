/*
 * Copyright 2007-2010 the original author or authors.
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
package com.sinosoft.one.mvc.web.paramresolver;

import java.util.Date;

import com.sinosoft.one.mvc.web.paramresolver.ResolverFactoryImpl.DateEditor;

import org.springframework.beans.SimpleTypeConverter;

/**
 * 
 *
 * 
 */
public class SafedTypeConverterFactory {

    public static SimpleTypeConverter getCurrentConverter() {
        return simpleTypeConverters.get();
    }

    private static ThreadLocal<SimpleTypeConverter> simpleTypeConverters = new ThreadLocal<SimpleTypeConverter>() {

        @Override
        protected SimpleTypeConverter initialValue() {
            // simpleTypeConverter is not for concurrency!
            SimpleTypeConverter simpleTypeConverter = new SimpleTypeConverter();
            simpleTypeConverter.useConfigValueEditors();
            simpleTypeConverter.registerCustomEditor(Date.class, new DateEditor(Date.class));
            simpleTypeConverter.registerCustomEditor(java.sql.Date.class, new DateEditor(
                    java.sql.Date.class));
            simpleTypeConverter.registerCustomEditor(java.sql.Time.class, new DateEditor(
                    java.sql.Time.class));
            simpleTypeConverter.registerCustomEditor(java.sql.Timestamp.class, new DateEditor(
                    java.sql.Timestamp.class));
            return simpleTypeConverter;
        }
    };
}
