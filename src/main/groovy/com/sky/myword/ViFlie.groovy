package com.sky.myword

class ViFlie {

    Cursor cursor
    String content

    List<String> texts

    ViFlie() {
        this.cursor = new Cursor()
        this.content=''
        this.texts=new ArrayList<>()
    }

    static ViFlie createBlankFile() {
        return new ViFlie()
    }

    String getContent() {
        if (texts){
            return texts.join(',')
        }
        return content
    }

    def insert(char s) {
        def lineStr=''
        if (this.texts.size()>this.cursor.y){
            lineStr=this.texts[this.cursor.y]
        }

        if (this.cursor.x>=lineStr.length()){
            lineStr += s
        }else {
            lineStr=lineStr.substring(0,this.cursor.x)+s+lineStr.substring(this.cursor.x)
        }

        this.texts[this.cursor.y]=lineStr
        movingCusor('right')

    }


    def movingCusor(String direction){
        this.cursor.move(direction)
    }

    def newLine() {
        if (this.texts.size()==(this.cursor.y+1)){
            this.texts<<''
        }else if (this.texts.size()>(this.cursor.y+1)){

            for (int i=this.texts.size();i >=this.cursor.y+1;i--){
                if (i>this.cursor.y+1){
                    this.texts[i]=this.texts[i-1]
                }else {
                    this.texts[i]=''
                }
            }

        }else {
            //todo
        }


        movingCusor('down')
        this.cursor.x=0


    }

    char[] copyCharsOnCursor(int length) {
        def lineStr=''
        if (this.texts.size()>this.cursor.y){
            lineStr=this.texts[this.cursor.y]
        }
        if (lineStr!=''){
            if (lineStr.length()>this.cursor.x+length){
                return  lineStr.substring(this.cursor.x,this.cursor.x+length).toCharArray()
            }else {
                return  lineStr.substring(this.cursor.x).toCharArray()
            }
        }else {
            return []
        }

    }

    void cursorToNextLine() {
        def currentCursorx=this.cursor.x
        def currentCursory=this.cursor.y

        def nextLineStr=this.texts[currentCursory+1]
        if (nextLineStr.length()<currentCursorx){
            this.cursor=new Cursor(x: nextLineStr.length(),y:currentCursory+1)
        }
    }
}
