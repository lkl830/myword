package com.sky.myword.test1125

class FileOperate {

    ViFile2 file

    CursorV2 cursor

    FileOperate() {
        this.file=new ViFile2()
        this.cursor=new CursorV2()
    }

    void newFile() {
        this.setFlieCursor(0,0)
    }

    void insert(char c) {
        if (c){
            file.insertChar(this.cursor.y,this.cursor.x,c)
            cursor.moveRight()
        }
    }

    void newLine() {
        file.newLine(this.cursor.y+1)
        def x=this.cursor.x
        cursor.moveDown()
        for (int i = 0; i < x; i++) {
            cursor.moveLeft()

        }
    }

    void nextLine() {
        def x=this.cursor.x
        def nextlineLength=this.file.texts[this.cursor.y+1].length()
        if (x>nextlineLength){
            for (int i = nextlineLength; i < x; i++) {
                cursor.moveLeft()
            }
        }
        cursor.moveDown()
    }

    void setFlieCursor(int x, int y) {
        this.cursor.x=x
        this.cursor.y=y
    }
}
