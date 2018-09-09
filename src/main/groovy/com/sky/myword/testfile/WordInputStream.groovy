package com.sky.myword.testfile

import org.springframework.stereotype.Service

/***
 * FileInputStream 按字节读取，tempbytes 的取值不合适容易造成输出乱码
 */
@Service
class WordInputStream implements Document{

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
        InputStream inputStream=new  FileInputStream(new File(path))
        return inputStream.readLines()
    }
}
