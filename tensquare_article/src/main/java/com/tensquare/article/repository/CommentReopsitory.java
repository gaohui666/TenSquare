package com.tensquare.article.repository;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentReopsitory extends MongoRepository<Comment,String> {
}
