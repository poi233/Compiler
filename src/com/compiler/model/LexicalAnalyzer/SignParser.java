package com.compiler.model.LexicalAnalyzer;

import com.compiler.model.Util.CONST;
import com.compiler.model.Util.LexicalException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by puyihao on 16/12/6.
 */
public class SignParser {

    static boolean inCharSet(char c) {
        return CONST.signCharSet.contains(c);
    }

    static List<String> parse(String str) throws LexicalException {
        LinkedList<String> rsContainer = new LinkedList<String>();
        int startIndex = 0;
        while (startIndex < str.length()) {
            String matchStr = match(startIndex, str);
            if (matchStr == null) {
                throw new LexicalException(str.substring(startIndex));
            } else {
                rsContainer.add(matchStr);
                startIndex += matchStr.length();
            }
        }
        return rsContainer;
    }

    private static String match(int startIndex, String str) {
        String matchStr = null;
        int length = str.length() - startIndex;
        length = Math.min(length, CONST.MaxLength);
        if(length >= CONST.MinLength) {
            for(int i=length - CONST.MinLength; i>=0; i--) {
                int matchLength = i + CONST.MinLength;
                HashSet<String> signSet = CONST.signSetList.get(i);
                matchStr = str.substring(startIndex, startIndex + matchLength);
                if(signSet.contains(matchStr)) {
                    break;
                }
                matchStr = null;
            }
        }
        return matchStr;
    }
}
