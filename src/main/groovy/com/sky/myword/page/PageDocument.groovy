package com.sky.myword.page

import com.sky.myword.file.Element
import com.sky.myword.file.MyDocument
import com.sky.myword.file.Paragraph

class PageDocument implements MyDocument {

    /***
     *
     * 通过页面宽度，确定每行可放置的字符数。
     * 从而确定每段落可以分为几行
     * 每一页，按个添加段落，若当前页放不下完整段落，怎段落拆分在两页里
     *
     * @param paragraphs
     * @return
     */
    @Override
    public List<Element> structContext(List<Paragraph> paragraphs) {
        List<Element> pages=new ArrayList<Page>()


        return null;
    }
}