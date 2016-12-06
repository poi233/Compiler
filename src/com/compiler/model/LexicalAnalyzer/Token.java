package com.compiler.model.LexicalAnalyzer;

import com.compiler.model.Util.Const;

/**
 * Created by puyihao on 16/12/6.
 * 记录词素与类型
 */
public class Token {
    public static enum Type {
        Keyword, Number, Identifier, Sign, Annotation,
        String, RegEx, Space, NewLine, EndSymbol;
    }

    public final Type type;
    public final String value;

    public Token(Type type, String value) {
        if (type == Type.Identifier) {
            char firstChar = value.charAt(0);
            if (firstChar >= '0' & firstChar <= '9') {
                type = Type.Number;
                for (int i = 0; i < value.length(); i++) {
                    if (!(value.charAt(i) >= '0' & value.charAt(i) <= '9')) {
                        type = Type.Identifier;
                        break;
                    }
                }
            } else if (Const.keywordsSet.contains(value)) {
                type = Type.Keyword;
            }
        } else if (type == Type.Annotation) {
            value = value.substring(1);
        } else if (type == Type.String) {
            value = value.substring(1, value.length() - 1);
        } else if (type == Type.RegEx) {
            value = value.substring(1, value.length() - 1);
        } else if (type == Type.EndSymbol) {
            value = null;
        }
        this.type = type;
        this.value = value;
    }
}
