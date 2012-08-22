/*
 * Copyright 2007-2009 the original author or authors.
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

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sinosoft.one.mvc.util.MvcStringUtil;

/**
 * 
 *
 * 
 */
public enum MatchMode {

    STARTS_WITH {

        public MappingPattern compile(final String conf, boolean regex) {
            if (regex) {
                return new MappingPattern() {

                    final Pattern pattern = Pattern.compile("^" + conf + "($|/)");


                    public java.util.regex.MatchResult match(CharSequence path) {
                        Matcher matcher = pattern.matcher(path);
                        return matcher.find() ? matcher : null;
                    }


                    public String toString() {
                        return pattern.toString();
                    }
                };

            } else {
                return new MappingPattern() {

                    private final SimpleMatchResult simpleMatchResult = new SimpleMatchResult(conf);


                    public java.util.regex.MatchResult match(CharSequence path) {
                        boolean matched = MvcStringUtil.startsWith(path, conf);
                        if (!matched
                                || (path.length() > conf.length() && path.charAt(conf.length()) != '/')) {
                            return null;
                        }
                        return simpleMatchResult;
                    }

                    @Override
                    public String toString() {
                        return conf;
                    }
                };
            }
        }
    },

    EQUALS {

        @Override
        public MappingPattern compile(final String conf, boolean regex) {
            if (regex) {
                return new MappingPattern() {

                    final Pattern pattern = Pattern.compile("^" + conf + "/?$");


                    public java.util.regex.MatchResult match(CharSequence path) {
                        Matcher matcher = pattern.matcher(path);
                        return matcher.find() ? matcher : null;
                    }

                    @Override
                    public String toString() {
                        return pattern.toString();
                    }
                };
            } else {
                return new MappingPattern() {

                    private final SimpleMatchResult simpleMatchResult = new SimpleMatchResult(conf);


                    public java.util.regex.MatchResult match(CharSequence inputPath) {
                        if (inputPath.length() > conf.length()) {
                            if (inputPath.length() == conf.length() + 1) {
                                boolean matched = MvcStringUtil.startsWith(inputPath, conf);
                                if (!matched || inputPath.charAt(conf.length()) != '/') {
                                    return null;
                                }
                                return simpleMatchResult;
                            } else {
                                return null;
                            }
                        }
                        return conf.equals(inputPath) ? simpleMatchResult : null;
                    }


                    public String toString() {
                        return conf;
                    }
                };
            }
        }

    };

    /**
     * 
     * @param conf
     * @param regex
     * @return
     */
    public abstract MappingPattern compile(final String conf, boolean regex);

    private static class SimpleMatchResult implements MatchResult {

        private final String conf;

        public SimpleMatchResult(String conf) {
            this.conf = conf;
        }


        public String group() {
            return conf;
        }


        public String group(int group) {
            return conf;
        }


        public int end() {
            return 0;
        }


        public int end(int group) {
            return 0;
        }


        public int groupCount() {
            return 0;
        }


        public int start() {
            return 0;
        }


        public int start(int group) {
            return 0;
        }
    }

}
