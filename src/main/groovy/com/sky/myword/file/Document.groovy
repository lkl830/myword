package com.sky.myword.file

interface Document {

    /***
     *
     * @param filepath
     * @return
     */
    List<Page> readFileToPage(String filepath)

    /***
     * 段落分行
     * @param paragraph
     * @return
     */
    List<Line> splitLine(Paragraph paragraph)

    /***
     * 读取文件段落
     * @param filepath
     * @return
     */
    List<Paragraph> read(String filepath)

    /***
     * 读取文件内容
     * @param path
     * @return
     */
    List<String> readFile(String path)
}