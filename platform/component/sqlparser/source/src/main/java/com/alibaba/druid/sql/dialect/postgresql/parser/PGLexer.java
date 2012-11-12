/*
 * Copyright 1999-2011 Alibaba Group Holding Ltd.
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
package com.alibaba.druid.sql.dialect.postgresql.parser;

import static com.alibaba.druid.sql.parser.Token.LITERAL_CHARS;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.druid.sql.parser.Keywords;
import com.alibaba.druid.sql.parser.Lexer;
import com.alibaba.druid.sql.parser.Token;

public class PGLexer extends Lexer {

    public final static Keywords DEFAULT_PG_KEYWORDS;

    static {
        Map<String, Token> map = new HashMap<String, Token>();

        map.putAll(Keywords.DEFAULT_KEYWORDS.getKeywords());

        map.put("CASCADE", Token.CASCADE);
        map.put("CONTINUE", Token.CONTINUE);
        map.put("CURRENT", Token.CURRENT);
        map.put("FETCH", Token.FETCH);
        map.put("FIRST", Token.FIRST);

        map.put("IDENTITY", Token.IDENTITY);
        map.put("LIMIT", Token.LIMIT);
        map.put("NEXT", Token.NEXT);
        map.put("NOWAIT", Token.NOWAIT);
        map.put("OF", Token.OF);

        map.put("OFFSET", Token.OFFSET);
        map.put("ONLY", Token.ONLY);
        map.put("OVER", Token.OVER);
        map.put("RECURSIVE", Token.RECURSIVE);
        map.put("RESTART", Token.RESTART);

        map.put("RESTRICT", Token.RESTRICT);
        map.put("RETURNING", Token.RETURNING);
        map.put("ROW", Token.ROW);
        map.put("ROWS", Token.ROWS);
        map.put("SHARE", Token.SHARE);

        map.put("USING", Token.USING);
        map.put("WINDOW", Token.WINDOW);
        map.put("WITH", Token.WITH);

        DEFAULT_PG_KEYWORDS = new Keywords(map);
    }

    public PGLexer(String input){
        super(input);
        super.keywods = DEFAULT_PG_KEYWORDS;
    }
    
    protected void scanString() {
        np = bp;
        boolean hasSpecial = false;

        for (;;) {
            if (bp >= buflen) {
                lexError(tokenPos, "unclosed.str.lit");
                return;
            }

            ch = buf[++bp];

            if (ch == '\\') {
                scanChar();
                if (!hasSpecial) {
                    System.arraycopy(buf, np + 1, sbuf, 0, sp);
                    hasSpecial = true;
                }

                switch (ch) {
                    case '\0':
                        putChar('\0');
                        break;
                    case '\'':
                        putChar('\'');
                        break;
                    case '"':
                        putChar('"');
                        break;
                    case 'b':
                        putChar('\b');
                        break;
                    case 'n':
                        putChar('\n');
                        break;
                    case 'r':
                        putChar('\r');
                        break;
                    case 't':
                        putChar('\t');
                        break;
                    case '\\':
                        putChar('\\');
                        break;
                    case 'Z':
                        putChar((char) 0x1A); // ctrl + Z
                        break;
                    default:
                        putChar(ch);
                        break;
                }
                scanChar();
            }

            if (ch == '\'') {
                scanChar();
                if (ch != '\'') {
                    token = LITERAL_CHARS;
                    break;
                } else {
                    System.arraycopy(buf, np + 1, sbuf, 0, sp);
                    hasSpecial = true;
                    putChar('\'');
                    continue;
                }
            }

            if (!hasSpecial) {
                sp++;
                continue;
            }

            if (sp == sbuf.length) {
                putChar(ch);
            } else {
                sbuf[sp++] = ch;
            }
        }

        if (!hasSpecial) {
            stringVal = new String(buf, np + 1, sp);
        } else {
            stringVal = new String(sbuf, 0, sp);
        }
    }
}