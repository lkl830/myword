package com.sky.myword

class NewDocument {
    String content

    NewDocument(String path) {
        File file=new File(path)
        content=file.text
    }

    void replaceChars(String contentChars, String targetChars) {
        content=content.replaceAll(contentChars,targetChars)
    }
}
