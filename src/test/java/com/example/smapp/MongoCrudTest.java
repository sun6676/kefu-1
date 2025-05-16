package com.example.smapp;

import com.example.smapp.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest
public class MongoCrudTest {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void testInsert(){
        ChatMessages chatMessages= new ChatMessages();
        chatMessages.setContent("聊天记录");
        mongoTemplate.insert(chatMessages);
    }
    @Test
    public void testFindById(){
        ChatMessages chatMessages= mongoTemplate.findById("681d9fbeb4bd1c075a4f1423",ChatMessages.class);
        System.out.println(chatMessages);
    }
    @Test
    public void testUpdate(){
        Criteria criteria= Criteria.where("_id").is("681d9fbeb4bd1c075a4f1423");
        Query query= new Query(criteria);
        Update update = new Update();
        update.set("content","新的聊天信息");
        mongoTemplate.upsert(query,update,ChatMessages.class);

    }

    @Test
    public void testDelete(){
        Criteria criteria= Criteria.where("_id").is("681d9fbeb4bd1c075a4f1423");
        Query query= new Query(criteria);
        mongoTemplate.remove(query,ChatMessages.class);

    }
}
