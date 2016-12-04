package com.compiler.model.Util;

/**
 * Created by puyihao on 16/11/29.
 */

/**
 * 抛出词法分析中的异常
 */
public class LexicalException extends Exception{
    public LexicalException(String err) {
        super(err);
    }
}
