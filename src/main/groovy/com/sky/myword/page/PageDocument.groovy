package com.sky.myword.page

import com.sky.myword.file.Element
import com.sky.myword.file.MyDocument
import com.sky.myword.file.Paragraph
import com.sky.myword.file.ParagraphType

class PageDocument implements MyDocument {

    //假设字符长宽都为15
    public static final int CHAR_LENGTH=15

    /***
     *
     * 通过页面宽度，确定每行可放置的字符数。
     * 从而确定每段落可以分为几行
     * 每一页，按个添加段落，若当前页放不下完整段落，怎段落拆分在两页里
     *
     *
     * 暂时设定为 文档每一页的页面设置都是一样的： 页面大小，页面设置等
     * 暂时页面默认设置为A4  数据没有查证现实中的数据
     * 目前涉及到的所有数据单位都为同一单位，数据计量单位暂时未定义，以数据值衡量相对大小
     *
     * @param paragraphs
     * @return
     */
    @Override
    public List<Element> structContext(List<Paragraph> paragraphs) {
        PageSetting pageSetting=new PageSetting()
        int height=0
        int lineCharNumbers=0
        if (Direction.TRANSVERSE.toString() == pageSetting.direction.toString()){
            height=PAPER.A4.height-pageSetting.up-pageSetting.down
            lineCharNumbers=(PAPER.A4.width-pageSetting.left-pageSetting.right)/CHAR_LENGTH
        }else {
            height=PAPER.A4.width-pageSetting.up-pageSetting.down
            lineCharNumbers=(PAPER.A4.height-pageSetting.left-pageSetting.right)/CHAR_LENGTH
        }

        List<PageParagraph> pageParagraphs=new ArrayList<>()
        for (Paragraph paragraph in paragraphs){
            PageParagraph pageParagraph=new PageParagraph()
            pageParagraph.before=paragraph.type.before
            pageParagraph.after=paragraph.type.after

            List<Character> characterList=paragraph.content.toCharArray().toList()
            pageParagraph.lines=characterList.collate(lineCharNumbers).collect {new String(it.toArray() as char[]);}.collect {line->
                new Line(content:line,height: paragraph.type.rowPitch*CHAR_LENGTH,lineMaxWordSize: CHAR_LENGTH )

                // 本意是 Line.height = paragraph.type.rowPitch * lineMaxWordSize  现在的设计结构并不能体现出来
            }
            pageParagraphs.add(pageParagraph)
        }

        List<Element> pages=new ArrayList<Page>()
        newPage(pages)
        int pageHeight=height
        for (PageParagraph pageParagraph in pageParagraphs){
            if (pageHeight<0||pageHeight<pageParagraph.before){
                newPage(pages)
                pageHeight = height
            }
            pageHeight=pageHeight-pageParagraph.before
            int paragraphHeight=pageParagraph.lines.collect {it.height}.sum () as int
            if (pageHeight< paragraphHeight){
                //todo
                //当前段落需要跨页
                // 将当前段落划分为 当前页段落和 另一段落
                // 保存当前页的段落内容
                // 剩余内容下一页可以存储
                // 剩余内容仍需要分多页存储
            }
            pageHeight=pageHeight-paragraphHeight
            pageHeight=pageHeight-pageParagraph.after
            pages.last().content.add(pageParagraph)
        }

        return pages;
    }

    private void newPage(ArrayList<Page> pages) {
        Page page = new Page()
        pages.add(page)
    }
}