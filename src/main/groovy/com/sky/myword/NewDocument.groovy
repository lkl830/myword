package com.sky.myword

import com.sky.myword.test1116.Cursor

class NewDocument implements Cloneable {
    String content

    NewDocument(String path) {
        File file=new File(path)
        content=file.text
    }

    NewDocument() {
    }

    void replaceChars(String contentChars, String targetChars) {
        content=content.replaceAll(contentChars,targetChars)
    }

    void contentAppend(String appendString) {
        content=content.concat(appendString)
    }

    def insertChars(Cursor cursor, char[] insertChars) {


    }
}
