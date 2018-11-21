package com.sky.myword

import spock.lang.Specification

class vi20181116Spock extends Specification{
    //打开文件，文件内容空白，光标在开始位置，输入字符到文件里，光标随追加的字符向后移动
    def "插入 abc 到空白文档，检查光标位置和文件内容"(){
        given:
        def vifile=ViFlie.openFile()
        vifile.insert('a' as char)
        expect:
        vifile.content=='a'
        vifile.cursor.x==1
        vifile.cursor.y==0
    }


    def "连续插入字符串，检查光标位置和文件内容"(){
        given:
        def vifile=ViFlie.openFile()
        vifile.insert('a' as char)
        vifile.insert('b' as char)
        expect:
        vifile.content=='ab'
        vifile.cursor.x==2
        vifile.cursor.y==0
    }


    def "定点插入字符 a"(){
        given:
        def vifile=ViFlie.openFile()
        vifile.insert('a' as char)
        vifile.insert('b' as char)
        vifile.cursor=new Cursor(x: 1,y: 0)
        vifile.insert('a' as char)
        expect:
        vifile.content=='aab'
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


    def "单行：获取光标后面2个字符"(){
        given:
        def vifile=ViFlie.openFile()
        vifile.insert('a' as char)
        vifile.insert('b' as char)
        vifile.insert('c' as char)
        vifile.insert('d' as char)
        vifile.insert('e' as char)
        vifile.insert('f' as char)
        vifile.insert('g' as char)

        vifile.cursor=new Cursor(x: 3,y: 0)
        char[] chars=vifile.copyCharsOnCursor(2)
        char[] exp= ['d', 'e']
        expect:
        chars == exp

    }


    def "换行输入字符，验证"(){
        given:
        def vifile=ViFlie.openFile()
        vifile.insert('a' as char)
        vifile.insert('b' as char)
        vifile.insert('c' as char)
        vifile.newLine()
        vifile.insert('d' as char)
        vifile.insert('e' as char)
        vifile.insert('f' as char)
        vifile.insert('g' as char)

        String exp= 'abc,defg'
        expect:
        vifile.content==exp
        vifile.cursor.x==4
        vifile.cursor.y==1

    }

    def "多行：获取光标后面2个字符"(){
        given:
        def vifile=ViFlie.openFile()
        vifile.insert('a' as char)
        vifile.insert('b' as char)
        vifile.insert('c' as char)
        vifile.newLine()
        vifile.insert('d' as char)
        vifile.insert('e' as char)
        vifile.insert('f' as char)
        vifile.insert('g' as char)

        vifile.cursor=new Cursor(x: 3,y: 1)
        char[] chars=vifile.copyCharsOnCursor(2)
        char[] exp= ['g']
        expect:
        chars == exp

    }

    def "多行：在第一行后，插入新的一行"(){
        given:
        def vifile=ViFlie.openFile()
        vifile.insert('a' as char)
        vifile.insert('b' as char)
        vifile.insert('c' as char)
        vifile.newLine()
        vifile.insert('d' as char)
        vifile.insert('e' as char)
        vifile.insert('f' as char)
        vifile.insert('g' as char)

        vifile.cursor=new Cursor(x: 3,y: 0)
        vifile.newLine()
        def exp= 'abc,,defg'
        expect:
        vifile.content == exp

    }


}
