package com.sky.myword.test1205

class FileEditDTO {
    FileMode fileMode
    Cursor cursor
    List<String> content

    FileEditDTO() {
        this.fileMode=FileMode.COMMAND
        this.cursor=new Cursor()
        this.content=['']
    }

    FileEditDTO(File file) {
        this.fileMode=FileMode.COMMAND
        this.cursor=new Cursor()
        this.content=file.readLines()
    }

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

    def setCursorPosition(int x, int y) {
        this.cursor.setX(x)
        this.cursor.setY(y)

    }

    def cursorToEnd() {
        setCursorPosition(this.content.last().length(),this.content.size()-1)
    }

    def setCursorToRegStart(String str) {
        for (int i = 0; i <this.content.size(); i++) {
            if (this.content.get(i).matches(str)){
                setCursorPosition(0,i)
                break
            }

        }

    }
}
