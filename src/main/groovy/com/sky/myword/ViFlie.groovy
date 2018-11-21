package com.sky.myword

class ViFlie {

    Cursor cursor
    String content

    ViFlie() {
        this.cursor = new Cursor()
        this.content=''
    }

    static ViFlie openFile() {
        return new ViFlie()
    }

    def insert(String s) {
        if (this.cursor.x>=this.content.length()){
            this.content=this.content+s
        }else {
            this.content=this.content.substring(0,this.cursor.x)+s+this.content.substring(this.cursor.x)
        }
        //todo
        //修改字符串
        //修改光标
        movingCusor(s)

    }


    def movingCusor(String s){
        for (int i=0;i<s.length();i++){
            this.cursor.remove("right")
        }
    }

    def newLine() {
        this.content=this.content+'''
'''
        this.cursor.remove("down")
        this.cursor.x=0


    }
}
