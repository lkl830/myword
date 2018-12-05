package com.sky.myword.test1125

/***
 * //默认文件第一行开始位置坐标为 0，0 。 向右为X 增长方向，向下为Y 增长方向
 */
class CursorV2 {

    int x //光标横位置
    int y //光标纵位置

   void moveRight(){
       this.x += 1
    }

    void moveDown() {
        this.y+=1
    }

    void moveLeft() {
        this.x -= 1
        if (this.x<0){
            this.x=0
        }
    }
}
