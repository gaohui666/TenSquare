package com.tensquare.article.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import com.tensquare.entity.PageResult;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //查询所有
    @GetMapping
    public Result findAll(){
        List list = articleService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",list);
    }

    //根据id查询
    @GetMapping("/{id}")
    public Result findById(@PathVariable String id ){
        Article article = articleService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",article);
    }

    //添加文章
    @PostMapping
    public Result add(@RequestBody Article article){
        articleService.add(article);
        return new Result(true,StatusCode.OK,"添加成功");
    }


    //修改文章
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, @RequestBody Article article){
        article.setId(id);
        articleService.update(article);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    //删除文章
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable String id ){
        articleService.deleteById(id);
        return new Result(true, StatusCode.OK,"删除成功");
    }

    //分页查询
    @PostMapping("/search/{page}/{size}")
    public Result findByPage(@PathVariable Integer page,
                             @PathVariable Integer size,
                             @RequestBody Map<String,Object> map
                             ){
        //根据分页条件查询
        Page<Article> pageData = articleService.findByPage(page,size,map);
        //封装分页返回对象
        PageResult<Article> pageResult = new PageResult<Article>(pageData.getTotal(),pageData.getSize());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    //测试公共异常
    //......
    @GetMapping("/exception")
    public Result test() throws Exception {
        throw new Exception("测试统一异常处理");
    }
}
