package com.sky.myword

class NewDocument {
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
}
