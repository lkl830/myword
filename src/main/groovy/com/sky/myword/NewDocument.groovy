package com.sky.myword

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
