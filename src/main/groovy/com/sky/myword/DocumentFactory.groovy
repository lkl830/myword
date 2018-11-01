package com.sky.myword

interface DocumentFactory {
    NewDocument creatDocument(String path)

    NewDocument createByTemplate(String templatePath)
}
