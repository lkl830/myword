package com.sky.myword

import spock.lang.Specification

class vi20181116Spock extends Specification{
    //打开文件，文件内容空白，光标在开始位置，输入字符到文件里，光标随追加的字符向后移动
    def "插入 abc 到空白文档，检查光标位置和文件内容"(){
        given:
        def vifile=ViFlie.openFile()
        vifile.insert('abc')
        expect:
        vifile.content=='abc'
        vifile.cursor.x==3
        vifile.cursor.y==0
    }


    def "连续插入字符串，检查光标位置和文件内容"(){
        given:
        def vifile=ViFlie.openFile()
        vifile.insert('abc')
        vifile.insert('def')
        expect:
        vifile.content=='abcdef'
        vifile.cursor.x==6
        vifile.cursor.y==0
    }


    def "定点插入字符 a"(){
        given:
        def vifile=ViFlie.openFile()
        vifile.insert('abc')
        vifile.cursor=new Cursor(x: 1,y: 0)
        vifile.insert('a')
        expect:
        vifile.content=='aabc'
        vifile.cursor.x==2
        vifile.cursor.y==0
    }

    def "插入换行"(){
        given:
        def vifile=ViFlie.openFile()
        vifile.cursor=new Cursor(x: 3,y: 4)
        vifile.newLine()
        expect:
        vifile.cursor.x==0
        vifile.cursor.y==5
    }

}
