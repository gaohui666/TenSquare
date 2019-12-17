package com.tensquare.article.service;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.repository.CommentReopsitory;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentReopsitory commentReopsitory;

    @Autowired
    private IdWorker idWorker;

    public List<Comment> findAll() {
        List<Comment> list = commentReopsitory.findAll();
        return list;

    }

    public Comment findById(String id) {
        Comment comment = commentReopsitory.findById(id).get();
        return comment;
    }

    public void save(Comment comment) {
        String id = idWorker.nextId() + "";
        comment.set_id(id);

        //初始化数据
        comment.setPublishdate(new Date());
        comment.setThumbup(0);

        commentReopsitory.save(comment);
    }

    public void update(Comment comment) {
        commentReopsitory.save(comment);
    }

    public void deleteById(String id) {
        commentReopsitory.deleteById(id);
    }
}
