package com.tensquare.article.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    public List findAll() {
        return articleDao.selectList(null);
    }

    public Article findById(String id) {
        return articleDao.selectById(id);
    }

    public void add(Article article) {
        article.setId(idWorker.nextId() + "");

        article.setVisits(0);
        article.setThumbup(0);
        article.setComment(0);

        articleDao.insert(article);
    }

    public void update(Article article) {
        //根据主键id修改
        articleDao.updateById(article);

        //根据条件修改
        //创建条件对象
        EntityWrapper<Article> wrapper = new EntityWrapper<>();
        //设置条件
        wrapper.eq("id",article.getId());
        articleDao.update(article,wrapper);
    }

    //删除
    public void deleteById(String id) {
        articleDao.deleteById(id);
    }

    //分页
    public Page<Article> findByPage(Integer page, Integer size, Map<String, Object> map) {
        //设置查询条件
        EntityWrapper<Article> wrapper = new EntityWrapper<>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            //相当于动态sql，第一个参数是否把后面的条件加入到查询条件中
            wrapper.eq(map.get(key) != null,key,map.get(key));
        }
        //设置分页参数
        Page<Article> pageData = new Page<>(page,size);

        //执行查询
        //第一个是分页参数，第二个是查询条件
        List<Article> list = articleDao.selectPage(pageData, wrapper);
        pageData.setRecords(list);

        //返回
        return pageData;
    }
}
