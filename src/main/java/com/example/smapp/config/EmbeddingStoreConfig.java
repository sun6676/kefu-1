package com.example.smapp.config;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.pinecone.PineconeEmbeddingStore;
import dev.langchain4j.store.embedding.pinecone.PineconeServerlessIndexConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddingStoreConfig {
    @Autowired
    private EmbeddingModel embeddingModel;

    @Bean
    public EmbeddingStore<TextSegment>embeddingstore(){
    //创建向量存储
        String apiKey = "pcsk_6LWLX4_7p5XEsxo6nbkUurUkoMLjXoUz6UYs4skTw2UoFxMqQmbboXyJenYUjHL3ZqVJyb";
        EmbeddingStore<TextSegment> embeddingStore = PineconeEmbeddingStore.builder()
                .apiKey(apiKey)
                .index("index")//如果指定的索引不存在，将创建一个新的索引
                .nameSpace("my-namespace")
                .createIndex(PineconeServerlessIndexConfig.builder()
                        .cloud("AWS")//指定索引部署在 AWS 云服务上。
                        .region("us-east-1")//指定索引所在的 AWS 区域为 us-east-1。
                        .dimension(embeddingModel.dimension())//指定索引的向量维度，该维度与 embeddedModel 生成的向量维度相同。
                        .build())
                .build();
        return embeddingStore;
    }
}
