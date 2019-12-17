package com.tensquare.article.controller;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.CommentService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping()
    public Result findAll(){
        List<Comment> list = commentService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",list);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable String id){
        Comment comment = commentService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",comment);
    }


}
