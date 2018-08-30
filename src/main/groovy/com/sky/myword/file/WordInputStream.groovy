package com.sky.myword.file

import org.springframework.stereotype.Service

@Service
class WordInputStream implements Document{
    @Override
    String readFile(String path) {

        byte[] tempbytes = new byte[100]
        int byteread = 0
        InputStream inputStream=new  FileInputStream(new File(path))

        while ((byteread = inputStream.read(tempbytes)) != -1){
//            println tempbytes
            System.out.write(tempbytes, 0, byteread);//好方法，第一个参数是数组，第二个参数是开始位置，第三个参数是长度
            }
        inputStream.close()
        return null
    }
}
