package com.sky.myword

import spock.lang.Specification

class Spock1101Test extends Specification {

    def "create a blank document"() {
        given:
        def document = new NewDocument()
        expect:
        document.content == null
    }


    def "create document with test content"() {  // 以test1 为模板创建document
        given:
        def factory = new DocumentFactoryFilePathImpl()
        def document = factory.createByTemplate(SpockSpec.class.classLoader.getResource("test.txt").path)
        document.content = document.content.replaceAll("hello", "嗨")
        def originDocument = factory.creatDocument(SpockSpec.class.classLoader.getResource("test.txt").path)
        expect:
        document.content != originDocument.content

    }

    def "create document with test context from DataBase"() {
        given:
        TemplateDAO dao = Mock()
        dao.getTemplateByName(_) >> { String templateName ->
            NewDocument document=new NewDocument()
            document.content=templateName
            return document
        }
        def factory = new DocumentFactoryTemplateImpl(dao)
        def document = factory.createByTemplate("hello liukaili!")
        expect:
        document.content == "hello liukaili!"
    }

    def "clone document"(){
        given:
        def factory = new DocumentFactoryFilePathImpl()
        def document = factory.createByTemplate(SpockSpec.class.classLoader.getResource("test.txt").path)
        def cloneDocument=document.clone() as NewDocument
        expect:
        document!=cloneDocument
    }


    def "add char AA in document index last"(){

        given:
        TemplateDAO dao = Mock()
        dao.getTemplateByName(_) >> { String templateName ->
            NewDocument document=new NewDocument()
            document.content=templateName
            return document
        }
        def factory = new DocumentFactoryTemplateImpl(dao)
        def document=factory.createByTemplate("hello")
        document.contentAppend("AA")

        expect:
        document.content=="helloAA"

    }


}
