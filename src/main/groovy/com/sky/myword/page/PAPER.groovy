package com.sky.myword.page

enum PAPER {

    A4(300,500),K16(300,500),K32(250,300)

    /**
     * 纸张宽度
     */
    int width

    /**
     * 纸张高度
     */
    int height

    PAPER(int width, int height) {
        this.width = width
        this.height = height
    }
}

enum Direction{
    TRANSVERSE, //横向
    VERTICAL //纵向
}