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
package com.sinosoft.one.mvc.web.impl.mapping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 *
 * 
 */
public class RegexMapping implements Mapping {

    /** 该映射代表的结点 */
    private MappingNode mappingNode;

    private final String definition;

    private final String paramName;

    private final Pattern pattern;

    private final String regex;

    public RegexMapping(String definition, String name, String regex) {
        this.definition = definition;
        this.paramName = name;
        this.regex = xx(regex);
        this.pattern = Pattern.compile("^" + this.regex);
    }

    private String xx(String regex) {
        if (regex == null || regex.length() == 0) {
            regex = "[^/]+";
        } else if ("+".equals(regex)) {
            regex = ".+";
        } else if ("?".equals(regex)) {
            regex = ".?";
        } else if ("*".equals(regex)) {
            regex = ".*";
        } else if ("n".equals(regex) || "number".equals(regex)) {
            regex = "[0-9]+";
        } else if ("w".equals(regex) || "word".equals(regex)) {
            regex = "\\w+";
        } else if ("id".equals(regex)) {
            regex = "[0-9a-zA-Z_-]+";
        }
        return regex;
    }

    public MappingNode getMappingNode() {
        return mappingNode;
    }

    public void setMappingNode(MappingNode mappingNode) {
        this.mappingNode = mappingNode;
    }

    public String getParameterName() {
        return paramName;
    }

    public String getDefinition() {
        return definition;
    }

    public MatchResult match(CharSequence path) {
        Matcher matcher = pattern.matcher(path);
        // TODO find? matches?
        if (!matcher.find()) {
            return null;
        }
        String value = matcher.group();
        while (value.length() > 0 && value.charAt(value.length() - 1) == '/') {
            value = value.substring(0, value.length() - 1);
        }
        MatchResultImpl mr = new MatchResultImpl(this.mappingNode, value);
        mr.setParameter(paramName);
        return mr;

    }

    public int compareTo(Mapping o) {
        if (o instanceof ConstantMapping) {
            return -((ConstantMapping) o).compareTo(this);
        }
        if (o instanceof RegexMapping) {
            RegexMapping t = (RegexMapping) o;
            if (regex.equals(t.regex) || definition.equals(t.definition)) {
                return 0;
            }
            // 以下是抽样性测试
            boolean thisIsDigit = this.pattern.matcher("123456").find();
            boolean thatIsDigit = t.pattern.matcher("123456").find();
            if (thisIsDigit && !thatIsDigit) {
                return -1;
            }
            if (!thisIsDigit && thatIsDigit) {
                return 1;
            }
            if (!this.pattern.matcher("/").find() && t.pattern.matcher("/").find()) {
                return -1;
            }
            if (this.pattern.matcher("/").find() && !t.pattern.matcher("/").find()) {
                return 1;
            }
            if (!this.pattern.matcher(".").find() && t.pattern.matcher(".").find()) {
                return -1;
            }
            if (this.pattern.matcher(".").find() && !t.pattern.matcher(".").find()) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "RegexMappingMapping[" + this.definition + ", regex=" + pattern + "]";
    }
}
