package com.sky.myword.file

enum ParagraphType {

    TITLE(0,0,2), //标题
    SECTION(0,0,1), //段落
    LISTING(0,0,1) //列表

    /**
     * 段前
     */
    int before=0

    /***
     * 段后
     */
    int after=0

    /**
     * 行间距设置：
     * 设置方式有两种：
     * 多倍行距： 单倍、1.5倍、3倍。。。
     * 固定值：最小值，自定义值  暂不实现
     */
    int  rowPitch=1

    ParagraphType(int before, int after, int rowPitch) {
        this.before = before
        this.after = after
        this.rowPitch = rowPitch
    }
}
