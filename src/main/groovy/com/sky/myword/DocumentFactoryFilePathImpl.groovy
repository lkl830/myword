package com.sky.myword

class DocumentFactoryFilePathImpl implements DocumentFactory{
    @Override
    NewDocument creatDocument(String path) {
        return new NewDocument(path)
    }

    @Override
    NewDocument createByTemplate(String templatePath) {
        NewDocument document=creatDocument(templatePath)
        return copyDocument(document)
    }

    NewDocument copyDocument(NewDocument newDocument) {
        if (newDocument){
            NewDocument document=new NewDocument()
            document.content=newDocument.content

            //后续添加其他的属性，这里都需要补齐，是有问题的。 应该换其他的策略和生成

            return document
        }

        return null
    }
}
