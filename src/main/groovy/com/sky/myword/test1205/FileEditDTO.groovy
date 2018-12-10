package com.sky.myword.test1205

class FileEditDTO {
    FileMode fileMode=FileMode.COMMAND
    Cursor cursor=new Cursor()

    void execute(CommandDTO commandDTO) {
        if (commandDTO.commandChars){
            if (commandDTO.isEditor()){
                fileMode=FileMode.EDIT
            }else if (commandDTO.isEnd()){
                fileMode=FileMode.END
            }else {
                fileMode=FileMode.COMMAND
            }
        }

        if (commandDTO.key){
            if (commandDTO.isESC()){
                fileMode=FileMode.COMMAND
            }
        }

    }
}
