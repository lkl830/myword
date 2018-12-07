package com.sky.myword.test1205

interface Command {

    CommandDTO commandByChar(char[] chars)

    CommandDTO commandByKey(String key)
}