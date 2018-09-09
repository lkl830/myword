package com.sky.myword.testfile

import org.springframework.stereotype.Service

@Service
class WordBufferedReader implements Document{
    @Override
    List<Page> readFileToPage(String filepath) {
        List<Line> lines=read(filepath).collectMany { paragraph->
            splitLine(paragraph)
        }.flatten()

        Page page=new Page();
        page.content=lines

        return [page] as List
    }

    @Override
    List<Line> splitLine(Paragraph paragraph) {
        List<Character> characterList=paragraph.content.toCharArray().toList()  //这里由简单类型转为了包装类型，感觉是没有必要的，我再想下有没有其他的方案
        return characterList.collate(15).collect {new String(it.toArray() as char[]);}.collect {line->new Line(content:line )}
    }

    @Override
    List<Paragraph> read(String filepath) {
        return readFile(filepath).collect {new Paragraph(content: it)}
    }

    @Override
    List<String> readFile(String path) {
        List<String> lines=new ArrayList<>()
        System.out.println()
        BufferedReader reader=new BufferedReader(new FileReader(path))
        String line=reader.readLine()
        while (line!=null){
            lines.add(line)
            line=reader.readLine()
        }
        reader.close()
        return lines
    }
}
