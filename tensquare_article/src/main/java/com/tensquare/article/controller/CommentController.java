package com.tensquare.article.controller;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.CommentService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    //查询所有
    @GetMapping()
    public Result findAll(){
        List<Comment> list = commentService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",list);
    }

    //根据id查询
    @GetMapping("/{id}")
    public Result findById(@PathVariable String id){
        Comment comment = commentService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",comment);
    }

    //新增
    @PostMapping
    public Result save(@RequestBody Comment comment) {
        commentService.save(comment);
        return new Result(true, StatusCode.OK, "新增成功");
    }

    //修改
    @PutMapping("{id}")
    public Result update(@PathVariable String id,
                         @RequestBody Comment comment) {
        comment.set_id(id);
        commentService.update(comment);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    //删除
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable String id) {
        commentService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

}
