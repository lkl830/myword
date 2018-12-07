package com.sky.myword.test1205

class CommandImpl implements Command{
    CommandDTO commandByChar(char[] chars) {
        new CommandDTO(
                commandChars:chars
        )
    }


    CommandDTO commandByKey(String key) {
        new CommandDTO(
                key:key
        )
    }
}
