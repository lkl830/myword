package com.sky.myword.file

import org.springframework.stereotype.Service

/***
 *  FileReader
 */
@Service
class WordFileReader implements Document ,Serializable{

    @Override
    List<Page> readFileToPage(String filepath) {
        return null
    }

    @Override
    List<Line> splitLine(Paragraph paragraph) {
        return null
    }

    @Override
    List<Paragraph> read(String filepath) {
        return null
    }

    @Override
    List<String> readFile(String path) {

        FileReader reader=new FileReader(path)
        return reader.readLines()

    }
}
