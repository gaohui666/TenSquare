package com.tensquare.article.service;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.repository.CommentReopsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentReopsitory commentReopsitory;

    public List<Comment> findAll() {
        List<Comment> list = commentReopsitory.findAll();
        return list;

    }

    public Comment findById(String id) {
        Comment comment = commentReopsitory.findById(id).get();
        return comment;
    }

    public void update(Comment comment) {
        commentReopsitory.save(comment);
    }

    public void deleteById(String id) {
        commentReopsitory.deleteById(id);
    }
}
