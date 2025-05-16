package com.example.smapp.config;


import com.example.smapp.store.MongoChatMemoryStore;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SunMoAgentConfig {

    @Autowired
    private MongoChatMemoryStore mongoChatMemoryStore;
    @Autowired
    private EmbeddingStore embeddingStore;
    @Autowired
    private EmbeddingModel embeddingModel;
    @Bean
    public ChatMemoryProvider chatMemoryProviderSunMo(){
        return memoryId ->
            MessageWindowChatMemory.builder()
                    .id(memoryId)
                    .maxMessages(10)
                    .chatMemoryStore(mongoChatMemoryStore)
                    .build();

    }

    /*@Bean
    ContentRetriever contentRetrieverSunMo() {
        // 1. 加载多个文档（支持 txt/pdf/docx 等格式）
        List<Document> documents = Arrays.asList(
                FileSystemDocumentLoader.loadDocument(Paths.get("C:/Users/Administrator/IdeaProjects/医院信息.md")),
                FileSystemDocumentLoader.loadDocument(Paths.get("C:/Users/Administrator/IdeaProjects/科室信息.md")),
                FileSystemDocumentLoader.loadDocument(Paths.get("C:/Users/Administrator/IdeaProjects/神经内科.md"))
        );

        // 2. 使用内存向量存储（生产环境建议改用 Redis/Pinecone/Weaviate）
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();

        // 3. 构建并执行文档处理流水线（自动完成：解析->分割->向量化->存储）
        EmbeddingStoreIngestor.ingest(documents, embeddingStore);

        // 4. 创建内容检索器（可配置相似度阈值、返回结果数等）
        return EmbeddingStoreContentRetriever.builder()
                .embeddingStore(embeddingStore)
                .maxResults(5)                // 默认返回前5个最相关片段
                .minScore(0.7)                // 相似度阈值（0-1，越高越严格）
                .build();
    }*/

    @Bean
    ContentRetriever contentRetrieverSunMoPincone(){
// 创建一个 EmbeddingStoreContentRetriever 对象，用于从嵌入存储中检索内容
        return EmbeddingStoreContentRetriever
                .builder()
//设置用于生成嵌入向量的嵌入模型
                .embeddingModel(embeddingModel)
//指定要使用的嵌入存储
                .embeddingStore(embeddingStore)
//设置最大检索结果数量，这里表示最多返回1条匹配结果
                .maxResults(1)
//设置最小得分阈值，只有得分大于等于0.8的结果才会被返回
                .minScore(0.8)
//构建最终的 EmbeddingStoreContentRetriever 实例
                .build();
    }
}
