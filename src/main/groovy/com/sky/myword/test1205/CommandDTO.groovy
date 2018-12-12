package com.sky.myword.test1205

class CommandDTO {
    char[] commandChars
    String key

    CommandDTO(char[] commandChars) {
        this.commandChars = commandChars
    }

    CommandDTO(String key) {
        this.key = key
    }

    boolean isEditor() {
        return ['a', 'A', 'i', 'I', 'o', 'O'].any { it as char == commandChars[commandChars.length - 1] }
    }

    boolean isEnd() {
        return commandChars[commandChars.length - 1] == ':' as char
    }

    boolean isESC() {
        return key == 'esc'
    }

    boolean isDelete() {
        return key == 'delete'
    }

    //换行
    boolean isEnter(){
        return key =='enter'
    }

    boolean isCreate() {
        return commandChars.toString().startsWith('vi')
    }

    boolean isBlankFile() {
        if (isCreate()){
            return commandChars.toString().split(' ').length==1
        }else {
            throw new RuntimeException()
        }
    }

    boolean hasFileName() {
        if (isCreate()){
            return commandChars.toString().split(' ').length>1
        }else {
            throw new RuntimeException()
        }
    }

    String getFileName() {
        if (hasFileName()){
            return commandChars.toString().split(' ').last()
        }
    }

    boolean isPosition() {
        if (isCreate()){
            return commandChars.toString().split(' ').length>2
        }
    }

    String getPositionParam() {
        if (isPosition()){
            return commandChars.toString().split(' ')[1]
        }
    }
}
