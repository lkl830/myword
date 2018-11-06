package com.sky.myword

/***
 * //默认文件第一行开始位置坐标为 0，0 。 向右为X 增长方向，向下为Y 增长方向
 */
class Cursor {

    int x //光标横位置
    int y //光标纵位置

    Cursor remove(String direction) {
        def tempx=x
        if (direction=="left"){
             tempx=x-1
        }

        if (direction=="right"){
            tempx=x+1
        }

        if (tempx<0){
            x=0
        }else{
            x=tempx
        }

        def tempy=y
        if (direction=="up"){
            tempy=y-1
        }

        if (direction=="down"){
            tempy=y+1
        }

        if (tempy<0){
            y=0
        }else{
            y=tempy
        }
        return this
    }
}
