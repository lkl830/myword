package com.sky.myword

import com.sky.myword.test1125.CursorV2
import com.sky.myword.test1125.FileOperate
import spock.lang.Specification

class test1125Spock extends Specification {

    def "插入 a 到空白文档，检查光标位置和文件内容"() {
        given:
        def fileOperate = new FileOperate()
        fileOperate.newFile()
        fileOperate.insert('a' as char)
        expect:
        fileOperate.file.content == 'a'
        fileOperate.cursor.x == 1
        fileOperate.cursor.y == 0

    }


    def "连续插入字符串，检查光标位置和文件内容"() {
        given:
        def fileOperate = new FileOperate()
        fileOperate.newFile()
        fileOperate.insert('a' as char)
        fileOperate.insert('a' as char)

        expect:
        fileOperate.file.content == 'aa'
        fileOperate.cursor.x == 2
        fileOperate.cursor.y == 0
    }


    def "定点插入字符 a"() {
        given:
        def fileOperate = new FileOperate()
        fileOperate.newFile()
        fileOperate.insert('a' as char)
        fileOperate.insert('b' as char)
        fileOperate.cursor = new CursorV2(x: 1, y: 0)
        fileOperate.insert('a' as char)
        expect:
        fileOperate.file.content == 'aab'
        fileOperate.cursor.x == 2
        fileOperate.cursor.y == 0
    }

    def "插入换行"() {
        given:
        def fileOperate = new FileOperate()
        fileOperate.newFile()
        fileOperate.insert('a' as char)
        fileOperate.insert('b' as char)
        fileOperate.newLine()
        expect:
        fileOperate.cursor.x == 0
        fileOperate.cursor.y == 1
    }

    def "换行输入字符，验证"() {
        given:
        def fileOperate = new FileOperate()
        fileOperate.newFile()
        fileOperate.insert('a' as char)
        fileOperate.insert('b' as char)
        fileOperate.insert('c' as char)
        fileOperate.newLine()
        fileOperate.insert('d' as char)
        fileOperate.insert('e' as char)
        fileOperate.insert('f' as char)
        fileOperate.insert('g' as char)

        String exp = 'abc,defg'
        expect:
        fileOperate.file.content == exp
        fileOperate.cursor.x == 4
        fileOperate.cursor.y == 1

    }

    def "多行：在第一行后，插入新的一行"() {
        given:
        def fileOperate = new FileOperate()
        fileOperate.newFile()
        fileOperate.insert('a' as char)
        fileOperate.insert('b' as char)
        fileOperate.insert('c' as char)
        fileOperate.newLine()
        fileOperate.insert('d' as char)
        fileOperate.insert('e' as char)
        fileOperate.insert('f' as char)
        fileOperate.insert('g' as char)

        fileOperate.setFlieCursor(3, 0)
        fileOperate.newLine()
        def exp = 'abc,,defg'
        expect:
        fileOperate.file.content == exp

    }

    def "多行：在第一行后插入新的一行，内容为abc"() {
        given:
        def fileOperate = new FileOperate()
        fileOperate.newFile()
        fileOperate.insert('a' as char)
        fileOperate.insert('b' as char)
        fileOperate.insert('c' as char)
        fileOperate.newLine()
        fileOperate.insert('d' as char)
        fileOperate.insert('e' as char)
        fileOperate.insert('f' as char)
        fileOperate.insert('g' as char)

        fileOperate.setFlieCursor(3, 0)
        fileOperate.newLine()
        fileOperate.insert('a' as char)
        fileOperate.insert('b' as char)
        fileOperate.insert('c' as char)
        def exp = 'abc,abc,defg'
        expect:
        fileOperate.file.content == exp

    }

    def "移动光标 (5,0)->(3,1)"() {
        given:
        def fileOperate = new FileOperate()
        fileOperate.newFile()
        fileOperate.insert('a' as char)
        fileOperate.insert('a' as char)
        fileOperate.insert('a' as char)
        fileOperate.insert('a' as char)
        fileOperate.insert('a' as char)
        fileOperate.newLine()
        fileOperate.insert('b' as char)
        fileOperate.insert('b' as char)
        fileOperate.insert('b' as char)


        fileOperate.cursor=new CursorV2(x: 5,y: 0)
        fileOperate.nextLine()


        expect:
        fileOperate.cursor.x == 3
        fileOperate.cursor.y == 1

    }
    def "移动光标 (5,0)->(3,1)-v2"() {
        given:
        def fileOperate = new FileOperate()
        fileOperate.newFile()
        fileOperate.insert('a' as char)
        fileOperate.insert('a' as char)
        fileOperate.insert('a' as char)
        fileOperate.insert('a' as char)
        fileOperate.insert('a' as char)
        fileOperate.newLine()
        fileOperate.insert('b' as char)
        fileOperate.insert('b' as char)
        fileOperate.insert('b' as char)

        fileOperate.setFlieCursor(5, 0)
        fileOperate.nextLine()

        expect:
        fileOperate.cursor.x == 3
        fileOperate.cursor.y == 1

    }

    /*def "单行：获取光标后面2个字符"() {
        given:
        expect:

    }

    def "多行：获取光标后面2个字符"() {
        given:
        expect:
    }*/


}
