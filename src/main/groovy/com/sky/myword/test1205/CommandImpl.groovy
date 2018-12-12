package com.sky.myword.test1205

class CommandImpl implements Command {


    @Override
    CommandDTO commandByChar(char[] chars) {
        return new CommandDTO(chars)
    }

    @Override
    CommandDTO commandByKey(String key) {
        return new CommandDTO(key)
    }
}
