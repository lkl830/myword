package com.sky.myword.test1205

class CommandDTO {
    char[] commandChars
    String key

    boolean isEditor() {
        return ['a', 'A', 'i', 'I', 'o', 'O'].any { it == commandChars[commandChars.length - 1] }
    }

    boolean isEnd() {
        return commandChars[commandChars.length-1]==':'
    }

    boolean isESC() {
        return key=='esc'
    }
}
