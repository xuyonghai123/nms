package com.xuyh.nms.modules.sys.web;

import com.xuyh.nms.modules.sys.dao.UserMapper;
import com.xuyh.nms.modules.sys.entity.Admin;
import com.xuyh.nms.modules.sys.entity.Article;
import com.xuyh.nms.modules.sys.entity.Data;
import com.xuyh.nms.modules.sys.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:9527")
@RestController
public class LogController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/login/login",method = RequestMethod.POST)
    public Admin login(@RequestBody Data data){
//        System.out.println("username:"+username);
        System.out.println("username:"+data.getUsername());
        System.out.println("password:"+data.getPassword());
        System.out.println("登录请求");
        Admin admin = new Admin();
        admin.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        admin.setRole("admin");
        admin.setIntroduction("我是超级管理员1");
        admin.setName("Super Admin");
        admin.setToken("admin");
        return admin;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @RequestMapping(value = "/user/info",method = RequestMethod.GET)
    public Admin userInfo(){
        System.out.println("获取信息请求");
        Admin admin1 = new Admin();
        admin1.setAvatar("http://img.zcool.cn/community/016a67572594346ac7253812faee75.gif");
        admin1.setRole("admin");
        admin1.setIntroduction("我是超级管理员2");
        admin1.setName("Xuyh");
        admin1.setToken("admin");
        return admin1;
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/login/logout",method = RequestMethod.POST)
    public String logOut(){
        System.out.println("登出系统");
        User user =  userMapper.findUserByName("admin");
        System.out.println("user:"+user);
        return "success";
    }

    @RequestMapping(value = "/article/list",method = RequestMethod.GET)
    public List<Article> getArticle(){
        List<Article> articles = new LinkedList<>();
        for (int i = 0; i <10 ; i++) {
            Article article = new Article();
            article.setAuditor("12312312312313");
            article.setAuthor("xuyh");
            article.setDisplay_time("123");
            article.setForecast("123123123");
            article.setId(i);
            article.setImportance("123123");
            article.setPageviews("123123");
            article.setStatus("1");
            article.setTimestamp(new Date());
            article.setTitle("sahdiahsdiad");
            article.setType("123123123");
            articles.add(article);
        }
        return articles;
    }
}
