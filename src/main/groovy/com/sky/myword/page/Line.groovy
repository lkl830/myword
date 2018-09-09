package com.sky.myword.page

class Line {

    /***
     * 假设字体大小为10 ，段落设置为单倍行距，则行高为20，
     * 字体大小 的取值为 该行字号最大的字符的大小。 该功能暂未实现，默认好大小为20
     */
    int height

    /***
     * 行内容最大字号
     */
    int lineMaxWordSize=20

    /***
     * 行内容
     */
    String content
}
