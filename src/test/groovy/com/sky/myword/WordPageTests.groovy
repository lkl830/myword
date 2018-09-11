package com.sky.myword

import com.sky.myword.file.Document
import com.sky.myword.file.Element
import com.sky.myword.file.MyDocument
import com.sky.myword.file.Paragraph
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner)
@SpringBootTest
class WordPageTests {


	@Autowired
	Document document

	@Autowired
	MyDocument myDocument
	@Test
	void readFileToPage(){
		List<Paragraph> paragraphs=document.read("src/test/resources/20180605.txt")
		List<Element> page=myDocument.structContext(paragraphs)
		println page.size()
	}
}
