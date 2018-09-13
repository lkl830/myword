package com.sky.myword.web

import com.sky.myword.file.Element


//TODO  暂时还没想好怎么定义
/***
 * 原计划 直接返回 html的字符串，但是考虑到字符串可能过长
 */
class XmlDTO extends Element{

    /***
     *  元素名称
     */
    String name

    /***
     *  元素属性
     */
    Map<String,String> attributes

    /***
     * 内容
     */
    String context

    /***
     * 其他的 Element
     */
    List<XmlDTO> list
}
