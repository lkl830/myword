package com.sky.myword.test1205

import spock.lang.Specification

class test1210Spock extends Specification {

    /***
     *
     * vi 进入：
     * vi      打开空白文件
     * vi filename         打开已有文件或者创建新文件
     * vi +行号 filename       光标处于文件中特定的某行上
     * $ vi + filename     光标处于文件末尾
     * vi +/模式字符串 filename    光标就处于文件中第一个与指定模式串相匹配的那行上
     *
     * 涉及功能点：光标根据实际参数，重置光标位置。
     *           正则表达式 行内匹配
     *           打开文件，创建文件
     *
     * vi修改文件内容（文本修改命令）：
     * 输入i I a A o O 中的任意命令，都涉及光标的重新定位，这里的差异在于
     * i I a A 是光标在行内的重新定位
     * o O  涉及插入新行，以及行位置的重新定位
     * 涉及功能点：插入空行
     *           重置光标位置
     *
     */

    /**
     * 单元测试的前提：
     * 准备一个文本文件，里面里面有内容，测试文件名称是test1210.txt
     * 文件内容如下：
     * Part I. Spring Boot Documentation
     * This section provides a brief overview of Spring Boot reference documentation. It serves as a map for the rest of the document.
     *
     * 1. About the Documentation
     * The Spring Boot reference guide is available as
     *
     * HTML
     * PDF
     * EPUB
     * The latest copy is available at docs.spring.io/spring-boot/docs/current/reference.
     *
     * Copies of this document may be made for your own use and for distribution to others, provided that you do not charge any fee for such copies and further provided that each copy contains this Copyright Notice, whether distributed in print or electronically.
     *
     * 2. Getting Help
     * If you have trouble with Spring Boot, we would like to help.
     *
     * Try the How-to documents. They provide solutions to the most common questions.
     * Learn the Spring basics. Spring Boot builds on many other Spring projects. Check the spring.io web-site for a wealth of reference documentation. If you are starting out with Spring, try one of the guides.
     * Ask a question. We monitor stackoverflow.com for questions tagged with spring-boot.
     * Report bugs with Spring Boot at github.com/spring-projects/spring-boot/issues.
     * [Note]
     * All of Spring Boot is open source, including the documentation. If you find problems with the docs or if you want to improve them, please get involved.
     *
     * 3. First Steps
     * If you are getting started with Spring Boot or 'Spring' in general, start with the following topics:
     *
     * From scratch: Overview | Requirements | Installation
     * Tutorial: Part 1 | Part 2
     * Running your example: Part 1 | Part 2
     * 4. Working with Spring Boot
     * Ready to actually start using Spring Boot? We have you covered:
     *
     * Build systems: Maven | Gradle | Ant | Starters
     * Best practices: Code Structure | @Configuration | @EnableAutoConfiguration | Beans and Dependency Injection
     * Running your code IDE | Packaged | Maven | Gradle
     * Packaging your app: Production jars
     * Spring Boot CLI: Using the CLI
     * 5. Learning about Spring Boot Features
     * Need more details about Spring Boot’s core features? The following content is for you:
     *
     * Core Features: SpringApplication | External Configuration | Profiles | Logging
     * Web Applications: MVC | Embedded Containers
     * Working with data: SQL | NO-SQL
     * Messaging: Overview | JMS
     * Testing: Overview | Boot Applications | Utils
     * Extending: Auto-configuration | @Conditions
     * 6. Moving to Production
     * When you are ready to push your Spring Boot application to production, we have some tricks that you might like:
     *
     * Management endpoints: Overview | Customization
     * Connection options: HTTP | JMX
     * Monitoring: Metrics | Auditing | Tracing | Process
     * 7. Advanced Topics
     * Finally, we have a few topics for more advanced users:
     *
     * Spring Boot Applications Deployment: Cloud Deployment | OS Service
     * Build tool plugins: Maven | Gradle
     * Appendix: Application Properties | Auto-configuration classes | Executable Jars
     *
     * 测试用例：
     * 1. vi 打开空白文件
     * 2. vi test1210.txt 打开测试文件
     * 3. vi test1210not.txt 打开空白文件
     * 3. vi +5 test1210.txt 光标位于第五行开始位置
     * 4. vi + test1210.txt 光标位于文件末尾
     * 5. vi +/HTML test1210.txt 光标位于含HTML 那行的开始位置
     */


    def setupSpec() {
        File testFile = new File('src/test/resources/test1210.txt')
        testFile.write('''Part I. Spring Boot Documentation
This section provides a brief overview of Spring Boot reference documentation. It serves as a map for the rest of the document.

1. About the Documentation
The Spring Boot reference guide is available as

HTML
PDF
EPUB
The latest copy is available at docs.spring.io/spring-boot/docs/current/reference.

Copies of this document may be made for your own use and for distribution to others, provided that you do not charge any fee for such copies and further provided that each copy contains this Copyright Notice, whether distributed in print or electronically.

2. Getting Help
If you have trouble with Spring Boot, we would like to help.

Try the How-to documents. They provide solutions to the most common questions.
Learn the Spring basics. Spring Boot builds on many other Spring projects. Check the spring.io web-site for a wealth of reference documentation. If you are starting out with Spring, try one of the guides.
Ask a question. We monitor stackoverflow.com for questions tagged with spring-boot.
Report bugs with Spring Boot at github.com/spring-projects/spring-boot/issues.
[Note]
All of Spring Boot is open source, including the documentation. If you find problems with the docs or if you want to improve them, please get involved.

3. First Steps
If you are getting started with Spring Boot or 'Spring' in general, start with the following topics:

From scratch: Overview | Requirements | Installation
Tutorial: Part 1 | Part 2
Running your example: Part 1 | Part 2
4. Working with Spring Boot
Ready to actually start using Spring Boot? We have you covered:

Build systems: Maven | Gradle | Ant | Starters
Best practices: Code Structure | @Configuration | @EnableAutoConfiguration | Beans and Dependency Injection
Running your code IDE | Packaged | Maven | Gradle
Packaging your app: Production jars
Spring Boot CLI: Using the CLI
5. Learning about Spring Boot Features
Need more details about Spring Boot’s core features? The following content is for you:

Core Features: SpringApplication | External Configuration | Profiles | Logging
Web Applications: MVC | Embedded Containers
Working with data: SQL | NO-SQL
Messaging: Overview | JMS
Testing: Overview | Boot Applications | Utils
Extending: Auto-configuration | @Conditions
6. Moving to Production
When you are ready to push your Spring Boot application to production, we have some tricks that you might like:

Management endpoints: Overview | Customization
Connection options: HTTP | JMX
Monitoring: Metrics | Auditing | Tracing | Process
7. Advanced Topics
Finally, we have a few topics for more advanced users:

Spring Boot Applications Deployment: Cloud Deployment | OS Service
Build tool plugins: Maven | Gradle
Appendix: Application Properties | Auto-configuration classes | Executable Jars
aa''')
    }

    def cleanupSpec() {
        File testFile = new File("src/test/resources/test1210.txt")
        testFile.deleteOnExit()

    }


    FileOperate fileOperate

    Command command

    CommandDTO esc


    def setup() {
        command = new CommandImpl()
        fileOperate = new FileOperateImpl()
        esc = command.commandByKey('esc')
    }

    def cleanup() {
        fileOperate = null
        command = null
        esc = null
    }

    /**
     * vi 打开空白文件
     */
    def '传入 vi 命令，打开新文件'() {
        given:
        CommandDTO commandDTO = command.commandByChar(['v', 'i'] as char[])
        FileEditDTO fileEditDTO = fileOperate.create(commandDTO)
        expect:
        fileEditDTO.fileMode == FileMode.COMMAND
        fileEditDTO.cursor.x == 0
        fileEditDTO.cursor.y == 0
        fileEditDTO.content.size() == 1
    }

    /**
     * vi test1210.txt 打开测试文件
     */

    def 'open test1210.txt'() {
        given:
        CommandDTO commandDTO = command.commandByChar(['v', 'i', ' ', 't', 'e', 's', 't', '1', '2', '1', '0', '.', 't', 'x', 't'] as char[])
        FileEditDTO fileEditDTO = fileOperate.create(commandDTO)
        expect:
        fileEditDTO.fileMode == FileMode.COMMAND
        fileEditDTO.cursor.x == 0
        fileEditDTO.cursor.y == 0
        fileEditDTO.content.size() > 1

    }

    /**
     * vi test1210not.txt 打开空白文件
     */
    def 'open non-existent file test1210not.txt'() {
        given:
        CommandDTO commandDTO = command.commandByChar(['v', 'i', ' ', 't', 'e', 's', 't', '1', '2', '1', '0', 'n', 'o', 't', '.', 't', 'x', 't'] as char[])
        FileEditDTO fileEditDTO = fileOperate.create(commandDTO)
        expect:
        fileEditDTO.fileMode == FileMode.COMMAND
        fileEditDTO.cursor.x == 0
        fileEditDTO.cursor.y == 0
        fileEditDTO.content.size() == 1
    }

    /**
     * vi +5 test1210.txt 光标位于第五行开始位置
     */
    def 'vi +5 test1210.txt'() {
        given:
        CommandDTO commandDTO = command.commandByChar(['v', 'i', ' ', '+', '5', ' ', 't', 'e', 's', 't', '1', '2', '1', '0', '.', 't', 'x', 't'] as char[])
        FileEditDTO fileEditDTO = fileOperate.create(commandDTO)
        expect:
        fileEditDTO.fileMode == FileMode.COMMAND
        fileEditDTO.cursor.x == 0
        fileEditDTO.cursor.y == 4

    }

    /**
     * vi + test1210.txt 光标位于文件末尾
     */

    def 'vi + test1210.txt'() {
        given:
        CommandDTO commandDTO = command.commandByChar(['v', 'i', ' ', '+', ' ', 't', 'e', 's', 't', '1', '2', '1', '0', '.', 't', 'x', 't'] as char[])
        FileEditDTO fileEditDTO = fileOperate.create(commandDTO)
        expect:
        fileEditDTO.fileMode == FileMode.COMMAND
        fileEditDTO.cursor.x == 2

    }

    /**
     * vi +/HTML test1210.txt 光标位于含HTML 那行的开始位置
     */

    def 'vi +/HTML test1210.txt'() {
        given:
        CommandDTO commandDTO = command.commandByChar(['v', 'i', ' ', '+', '/', 'H', 'T', 'M', 'L', ' ', 't', 'e', 's', 't', '1', '2', '1', '0', '.', 't', 'x', 't'] as char[])
        FileEditDTO fileEditDTO = fileOperate.create(commandDTO)
        expect:
        fileEditDTO.fileMode == FileMode.COMMAND
        fileEditDTO.cursor.x == 0
        fileEditDTO.cursor.y == 6

    }

}
