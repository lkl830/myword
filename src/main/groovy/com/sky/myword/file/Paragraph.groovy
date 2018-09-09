package com.sky.myword.file

class Paragraph {

    /***
     * 段落类型
     *
     * 段落类型 是枚举值  暂时可以满足文件内容只读和相关属性默认值的需求。
     * 如果 段前段后行距 等自定义的时候。这里是需要改动的
     */
    ParagraphType type

    /***
     * 段落内容
     */
    String content
}
