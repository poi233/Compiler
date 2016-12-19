package com.compiler;

import com.compiler.model.SyntaxAnalyzer.AnalyseList;
import com.compiler.view.LexFrame;

import javax.swing.*;

/**
 * Created by puyihao on 16/12/18.
 */
public class Driver {
    public static void main(String[] args){
        LexFrame lexframe = new LexFrame();
        lexframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lexframe.setResizable(false);
        lexframe.setVisible(true);
        AnalyseList.getInstace().setAnalyseList();
    }
}
