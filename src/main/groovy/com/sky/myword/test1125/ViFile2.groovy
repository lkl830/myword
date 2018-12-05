package com.sky.myword.test1125

class ViFile2 {

    List<String> texts

    String content

    ViFile2() {
        this.texts = new ArrayList<>()
        this.content = ''
    }

    String getContent() {
        if (texts) {
            return texts.join(',')
        }
        return content
    }

    void insertChar(int line, int column, char c) {
        def lineStr = ''
        if (this.texts.size() > line) {
            lineStr = this.texts[line]
        }

        if (column >= lineStr.length()) {
            lineStr += c
        } else {
            lineStr = lineStr.substring(0, column) + c + lineStr.substring(column)
        }

        this.texts[line] = lineStr
    }

    void newLine(int nextNum) {
        if (this.texts.size() == nextNum) {
            this.texts << ''
        } else if (this.texts.size() > nextNum) {

            for (int i = this.texts.size(); i >= nextNum; i--) {
                if (i > nextNum) {
                    this.texts[i] = this.texts[i - 1]
                } else {
                    this.texts[i] = ''
                }
            }

        } else {
            //todo
        }
    }
}
