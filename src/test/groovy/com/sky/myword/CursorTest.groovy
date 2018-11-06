package com.sky.myword

import spock.lang.Specification

class CursorTest extends Specification {

    def "move cursor:right"() {
        given:
        def cursor = new Cursor()
        cursor.remove("right")
        expect:
        cursor.x == 1
        cursor.y == 0
    }


    def "test move cursor:x"(){
        given:
        def cursor = new Cursor()
        expect:
        a==cursor.remove(b).x
        where:
        a   |       b
        0   |  "left"
        1   | "right"
        0   |    "up"
        0   |  "down"

    }


    def "test move cursor:y"(){
        given:
        def cursor = new Cursor()
        expect:
        a==cursor.remove(b).y
        where:
        a   |       b
        0   |  "left"
        0   | "right"
        0   |    "up"
        1   |  "down"

    }
}
