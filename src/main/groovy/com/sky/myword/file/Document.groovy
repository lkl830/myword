package com.sky.myword.file

interface Document {
    /***
     * 读取文件内容
     * @param path
     * @return
     */
    List<String> readFile(String path)


    /***
     * 读取文件 段落结构
     * @param filepath
     * @return
     */
    List<Paragraph> read(String filepath)
}
