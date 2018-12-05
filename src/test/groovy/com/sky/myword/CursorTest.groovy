package com.sky.myword

import com.sky.myword.test1116.Cursor
import spock.lang.Specification

class CursorTest extends Specification {

    def "move cursor:right"() {
        given:
        def cursor = new Cursor()
        cursor.move("right")
        expect:
        cursor.x == 1
        cursor.y == 0
    }


    def "test move cursor:x"() {
        given:
        def cursor = new Cursor()
        expect:
        a == cursor.move(b).x
        where:
        a | b
        0 | "left"
        1 | "right"
        0 | "up"
        0 | "down"

    }


    def "test move cursor:y"() {
        given:
        def cursor = new Cursor()
        expect:
        a == cursor.move(b).y
        where:
        a | b
        0 | "left"
        0 | "right"
        0 | "up"
        1 | "down"

    }


    def "test (5,1) 移动到 （3，2）"() {

        given:
        def cursor = new Cursor(x: 5, y: 1)
        cursor.move('down')
        cursor.move('left')
        cursor.move('left')

        expect:
        cursor.x == 3
        cursor.y == 2
    }
}
