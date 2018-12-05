package com.sky.myword

import spock.lang.Specification

class SpockSpec extends Specification {

    def "my first spock test should run!"() {
        given:
        def a = 1

        expect:
        a == 1
    }

    def "read hello world file"(){
        given:
        def document=new NewDocument(SpockSpec.class.classLoader.getResource("test.txt").path)

        expect:
        document.content=="hello world"

    }

    def "document should read large countent"(){
        given:
        def document=new NewDocument(SpockSpec.class.classLoader.getResource("test2.txt").path)

        expect:
        document.content.startsWith("another")

    }

    def "尝试用其他方法生产NewDocument对象"(){
        given:
        DocumentFactory documentFactory=new DocumentFactoryFilePathImpl()
        def document=documentFactory.creatDocument(SpockSpec.class.classLoader.getResource("test2.txt").path)
        expect:
        document.content.startsWith("another")

    }


    def "edit replace another with 另一个"(){
        given:
        def document=new NewDocument(SpockSpec.class.classLoader.getResource("test2.txt").path)
        document.replaceChars("another","另一个")
        expect:
        document.content.startsWith("另一个")

    }

    /*def "获取文件最后一行数据"(){
        given:
        def document
        expect:
        document.lastLine

    }*/

}
