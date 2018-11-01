package com.sky.myword

class DocumentFactoryFilePathImpl implements DocumentFactory{
    @Override
    NewDocument creatDocument(String path) {
        return new NewDocument(path)
    }
}
