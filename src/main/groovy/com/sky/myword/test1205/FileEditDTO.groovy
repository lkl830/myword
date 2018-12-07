package com.sky.myword.test1205

class FileEditDTO {
    String fileMode='COMMAND'
    Cursor cursor=new Cursor()

    void execute(CommandDTO commandDTO) {
        if (commandDTO.commandChars){
            if (commandDTO.isEditor()){
                fileMode='EDIT'
            }else if (commandDTO.isEnd()){
                fileMode='END'
            }else {
                fileMode='COMMAND'
            }
        }

        if (commandDTO.key){
            if (commandDTO.isESC()){
                fileMode='COMMAND'
            }
        }

    }
}
