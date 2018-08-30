package com.sky.myword


import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner)
@SpringBootTest
class MywordApplicationTests {

	@Autowired
	com.sky.myword.file.WordBufferedReader wordBufferedReader

	@Test
	void wordBufferedReaderTest(){
		println "WordBufferedReader begin"
		wordBufferedReader.readFile("src/test/resources/20180605.txt")
		println "WordBufferedReader end"
	}

	@Autowired
	com.sky.myword.file.WordFileReader wordFileReader

	@Test
	void wordFileReaderTest(){
		println "wordFileReader begin"
		wordFileReader.readFile("src/test/resources/20180605.txt")
		println "wordFileReader end"
	}


	@Autowired
	com.sky.myword.file.WordInputStream wordInputStream

	@Test
	void wordInputStreamTest(){
		println "wordInputStream begin"
		wordInputStream.readFile("src/test/resources/20180605.txt")
		println "wordInputStream end"
	}



	@Test
	void contextLoads() {
		println System.getProperty("user.dir")
		println MywordApplicationTests.class.getResource("/").getPath()

		File directory = new File("")
		String courseFile = directory.getCanonicalPath()
		println courseFile
		String author =directory.getAbsolutePath()
		println author
		File file = new File("out/test/resources/20180605.txt");

		println file.getAbsolutePath()
	}

}
