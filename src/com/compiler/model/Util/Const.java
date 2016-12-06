package com.compiler.model.Util;

/**
 * Created by puyihao on 16/11/29.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 记录程序中的常量
 */
public class Const {

    public static final HashSet<String> keywordsSet = new HashSet<String>();//保留字符
    public static final HashMap<Character, Character> StringTMMap = new HashMap<Character, Character>();//转义字符
    public final static List<HashSet<String>> signSetList;//根据运算符长度分开储存的 List。具体来说，如果运算符对应的字符串最短的 length 是 n，最长的是 m。那么 List 的索引范围从 0 到 (m - n) 分别储存字符 length 从 n 到 m 的所有运算符。
    public final static HashSet<Character> signCharSet;//所有运算符中可能出现的字符集合
    public final static int MaxLength, MinLength;//运算符中字符串 length 的最小和最大长度

    static {
        keywordsSet.add("if");
        keywordsSet.add("when");
        keywordsSet.add("elseif");
        keywordsSet.add("else");
        keywordsSet.add("while");
        keywordsSet.add("begin");
        keywordsSet.add("until");
        keywordsSet.add("for");
        keywordsSet.add("do");
        keywordsSet.add("try");
        keywordsSet.add("catch");
        keywordsSet.add("finally");
        keywordsSet.add("end");
        keywordsSet.add("def");
        keywordsSet.add("var");
        keywordsSet.add("this");
        keywordsSet.add("null");
        keywordsSet.add("throw");
        keywordsSet.add("break");
        keywordsSet.add("continue");
        keywordsSet.add("return");
        keywordsSet.add("operator");
    }

    static {
        StringTMMap.put('\"', '\"');
        StringTMMap.put('\'', '\'');
        StringTMMap.put('\\', '\\');
        StringTMMap.put('b', '\b');
        StringTMMap.put('f', '\f');
        StringTMMap.put('t', '\t');
        StringTMMap.put('r', '\r');
        StringTMMap.put('n', '\n');
    }

    static {
        String[] signArray = new String[] {
                "+", "-", "*", "/", "%",
                ">", "<", ">=", "<=", "=", "!=", "==", "=~",
                "+=", "-=", "*=", "/=", "%=",
                "&&", "||", "!", "^",
                "&&=", "||=", "^=",
                "<<", ">>", "->", "<-",
                "?", ":",
                ".", ",", ";", "..",
                "(", ")", "[", "]", "{", "}",
                "@", "@@", "$",
        };

        int maxLength = Integer.MIN_VALUE,
                minLength = Integer.MAX_VALUE;

        signCharSet = new HashSet<Character>();
        for(String sign:signArray) {
            int length = sign.length();
            if(length > maxLength) {
                maxLength = length;
            }
            if(length < minLength) {
                minLength = length;
            }
            for(int i=0; i<length; ++i) {
                signCharSet.add(sign.charAt(i));
            }
        }
        signSetList = new ArrayList<HashSet<String>>(maxLength - minLength + 1);
        for(int i=0; i< maxLength - minLength + 1; ++i) {
            signSetList.add(new HashSet<String>());
        }
        for(String sign:signArray) {
            int length = sign.length();
            HashSet<String> signSet = signSetList.get(length - minLength);
            signSet.add(sign);
        }
        MaxLength = maxLength;
        MinLength = minLength;
    }
}
