package com.sky.myword.file

import org.springframework.stereotype.Service

@Service
class WordFileReader implements Document ,Serializable{

    @Override
    String readFile(String path) {

        int c=0
        FileReader reader=new FileReader(path)
        c=reader.read()
        while (-1 != c){
            println c as char
            c=reader.read()
        }
        reader.close()
        return null
    }
}
