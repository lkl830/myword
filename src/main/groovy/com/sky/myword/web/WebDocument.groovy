package com.sky.myword.web

import com.sky.myword.file.Element
import com.sky.myword.file.MyDocument
import com.sky.myword.file.Paragraph

class WebDocument implements MyDocument{
    @Override
    List<Element> structContext(List<Paragraph> paragraphs) {
        Element xml=new XmlDTO()
        xml.list=new ArrayList<>()
        for (Paragraph paragraph in paragraphs){
            XmlDTO item=new XmlDTO()
            item.name=paragraph.type.toString()
            item.attributes=new HashMap<>()
            item.attributes.put("margin-top":paragraph.type.before)
            item.attributes.put("margin-bottom":paragraph.type.after)
//            item.attributes.put("padding":paragraph.type.rowPitch*lineHieht) //这里的行高是没有的
            item.context=paragraph.content
            xml.list.add(item)
        }
        return null
    }
}
