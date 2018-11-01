package com.sky.myword

class DocumentFactoryTemplateImpl implements DocumentFactory{


    TemplateDAO templateDAO

    DocumentFactoryTemplateImpl(TemplateDAO templateDAO) {
        this.templateDAO = templateDAO
    }

    @Override
    NewDocument creatDocument(String path) {
        return null
    }

    @Override
    NewDocument createByTemplate(String templateName) {
        return templateDAO.getTemplateByName(templateName)
    }
}
