package com.xuyh.nms.modules.sys.web;

import com.xuyh.nms.modules.sys.dao.DataMapper;
import com.xuyh.nms.modules.sys.dao.UserMapper;
import com.xuyh.nms.modules.sys.entity.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DataMapper dataMapper;

    @ApiOperation(value="登录系统", notes="shiro权限登录")
    @RequestMapping(value = "/login/login",method = RequestMethod.POST)
    public Admin login(@RequestBody Data data) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(data.getUsername(),data.getPassword());
        subject.login(usernamePasswordToken);
        logger.info("username:"+data.getUsername());
        logger.info("password:"+data.getPassword());
        logger.info("登录请求");
        Admin admin = new Admin();
        admin.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        admin.setRole("admin");
        admin.setIntroduction("我是超级管理员1");
        admin.setName("Super Admin");
        admin.setToken("admin");
        return admin;
    }

    @ApiOperation(value="获取用户信息", notes="获取用户信息")
    @RequestMapping(value = "/user/info",method = RequestMethod.POST)
    public Admin userInfo(){
        logger.info("获取信息请求");
        Admin admin1 = new Admin();
        admin1.setAvatar("http://img.zcool.cn/community/016a67572594346ac7253812faee75.gif");
        admin1.setRole("admin");
        admin1.setIntroduction("我是超级管理员2");
        admin1.setName("Xuyh");
        admin1.setToken("admin");
        return admin1;
    }

    @ApiOperation(value="登出系统", notes="登出系统")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/login/logout",method = RequestMethod.POST)
    public String logOut(){
        logger.info("登出系统");
//        List<Datas> list = dataMapper.findData();
        User user =  userMapper.findUserByName("admin");
        logger.info("user:"+user);
//        logger.info("list:"+list);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
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

    @ApiOperation(value="获取订单", notes="根据id来获取订单")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/api/findOrder",method = RequestMethod.POST)
    public List<Datas> findOrder(){
//        List<Datas> list = new ArrayList<>();
//        Datas datas = new Datas();
//        datas.setId(1);
//        datas.setName("xuyh");
//        datas.setDate(new Date());
//        datas.setAddress("qweihdishdi");
//        datas.setZip("11111111");
//        Datas datas1 = new Datas();
//        datas1.setId(2);
//        datas1.setName("yhj");
//        datas1.setDate(new Date());
//        datas1.setAddress("qqqqqqqqqqqqq");
//        datas1.setZip("2222222222222");
//        list.add(datas);
//        list.add(datas1);
        List<Datas> list = dataMapper.findData();
        return list;
    }

    @ApiOperation(value="登录", notes="登录")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String, Object> map) {
        logger.info("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");

        logger.info("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                logger.info("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                logger.info("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                logger.info("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                logger.info("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理.
        return "/login";
    }
}
