package com.sky.myword.file

import org.springframework.stereotype.Service

@Service
class DocumentImpl implements Document{
    @Override
    List<String> readFile(String path) {
        InputStream inputStream=new  FileInputStream(new File(path))
        return inputStream.readLines()
    }

    @Override
    List<Paragraph> read(String filepath) {
        List<Paragraph> paragraphList=new ArrayList<>()
        readFile(filepath).each {it->
            if (it){
                if (it.startsWith("#")){
                    //暂时不处理标记字符了
                    paragraphList.add(new Paragraph(content: it,type: ParagraphType.TITLE))
                } else if (it.startsWith("*")){
                    paragraphList.add(new Paragraph(content: it,type: ParagraphType.LISTING))
                }else {
                    paragraphList.add(new Paragraph(content: it,type: ParagraphType.SECTION))
                }
            }
        }

        paragraphList.remove(null)
        return paragraphList
    }
}
