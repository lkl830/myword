package com.sky.myword.test1205

import spock.lang.Specification

class test1205Spock extends Specification {
    /**
     * 1. 根据输入的命令vi，打开一个新的文件，文件处于命令模式，光标位于开始位置。
     * 2. 在1的基础上，输入i I a A o O 中的任意命令，文本处于编辑状态，可输入字符。
     * 3. 在1的基础上，输入其他非 i I a A o O : 的命令，文件扔处于命令模式
     * 4. 在1的基础上，输入: 命令，可进入末行模式，可输入末行命令
     * 5. 在文件处于编辑模式的状态下，输入ESC，可转换至命令模式。
     * 6. 在文件处于末行模式的状态下，输入ESC，可转换至命令模式。
     */

    FileEditDTO fileEditDTO

    Command command

    CommandDTO esc


    def setup() {
        command = new CommandImpl()

        FileOperate fileOperate = new FileOperateImpl()
        CommandDTO commandDTO = command.commandByChar(['v', 'i'] as char[])
        fileEditDTO = fileOperate.create(commandDTO)

        esc=command.commandByKey('esc')
    }

    def cleanup() {
        fileEditDTO = null
        command = null
    }

    /**
     *      * 1. 根据输入的命令vi，打开一个新的文件，文件处于命令模式，光标位于开始位置。
     * @return
     */
    def '传入 vi 命令，打开新文件'() {
        expect:
        fileEditDTO.fileMode == 'COMMAND'
        fileEditDTO.cursor.x == 0
        fileEditDTO.cursor.y == 0

    }

    /**
     *      * 2. 在1的基础上，输入i I a A o O 中的任意命令，文本处于编辑状态，可输入字符。
     */
    def '输入i ，文本处于编辑状态'() {
        given:
        def commandDTO=command.commandByChar(['i'] as char[])
        fileEditDTO.execute(commandDTO)
        expect:
        fileEditDTO.fileMode=='EDIT'
    }

    /**
     *      * 3. 在1的基础上，输入其他非 i I a A o O : 的命令，文件扔处于命令模式
     */
    def '输入b ，文本处于命令模式'() {
        given:
        def commandDTO=command.commandByChar(['b'] as char[])
        fileEditDTO.execute(commandDTO)
        expect:
        fileEditDTO.fileMode=='COMMAND'
    }

    /**
     *      * 4. 在1的基础上，输入: 命令，可进入末行模式，可输入末行命令
     */
    def '输入: ,文本进入末行模式'(){
        given:
        def commandDTO=command.commandByChar([':'] as char[])
        fileEditDTO.execute(commandDTO)
        expect:
        fileEditDTO.fileMode=='END'
    }

    /**
     *      * 5. 在文件处于编辑模式的状态下，输入ESC，可转换至命令模式。
     */
    def 'test 5'(){
        given:
        def commandDTO=command.commandByChar(['i'] as char[])
        fileEditDTO.execute(commandDTO)
        fileEditDTO.execute(esc)
        expect:
        fileEditDTO.fileMode=='COMMAND'
    }

    /**
     *      * 6. 在文件处于末行模式的状态下，输入ESC，可转换至命令模式。
     */
    def 'test 6'(){
        given:
        def commandDTO=command.commandByChar([':'] as char[])
        fileEditDTO.execute(commandDTO)
        fileEditDTO.execute(esc)
        expect:
        fileEditDTO.fileMode=='COMMAND'

    }


}
