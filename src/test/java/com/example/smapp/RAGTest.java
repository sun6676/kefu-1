package com.example.smapp;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import org.junit.jupiter.api.Test;




public class RAGTest {
    @Test
    public void testReadDocument(){
        Document document = FileSystemDocumentLoader.loadDocument("C:/Users/Administrator/IdeaProjects/测试.txt");
        System.out.println(document.text());
    }
}
