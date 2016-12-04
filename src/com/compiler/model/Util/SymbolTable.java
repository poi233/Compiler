package com.compiler.model.Util;

/**
 * Created by puyihao on 16/12/4.
 */

/**
 *  1、编译过程中编译程序不断汇集和反复查证出现在源程序中各种名字的属性和特征信息等有关信息。
 *  这些信息通常记录在一张或几张符号表中。
 *  2、符号表的每一项有两部分：
 *  一部分是名字（标识符）；
 *  一部分是名字属性（标识符的有关信息）。
 *  3、编译过程中，每当扫描器（词法分析器）识别出一个名字后，编译程序就查阅符号表，看其是否在符号表中。
 *  如果它是一个新名字就将它填进表里。
 *  它的有关信息将在词法分析和语法－语义分析过程中陆续填入表中。
 *  4、编译器开始时，符号表或者是空的，或者预先存放了一些保留字和标准函数名的有关信息。
 */
public class SymbolTable {
}
