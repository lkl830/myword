package com.sky.myword.file

import org.springframework.stereotype.Service

@Service
class WordBufferedReader implements Document{
    @Override
    String readFile(String path) {
        String line=""
        BufferedReader reader=new BufferedReader(new FileReader(path))
        line=reader.readLine()
        while (line!=null){
            println line
            line=reader.readLine()
        }
        reader.close()
        return null
    }
}
