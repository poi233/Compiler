package com.compiler.model.Util;

/**
 * Created by puyihao on 16/12/4.
 */

/**
 * 抛出语法分析中的异常
 */

public class SyntaxException extends Exception {
    public SyntaxException(String err) {
        super(err);
    }
}
