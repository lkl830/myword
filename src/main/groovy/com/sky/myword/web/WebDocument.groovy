package com.sky.myword.web

import com.sky.myword.file.Element
import com.sky.myword.file.MyDocument
import com.sky.myword.file.Paragraph

class WebDocument implements MyDocument{
    @Override
    List<Element> structContext(List<Paragraph> paragraphs) {
        return null
    }
}
