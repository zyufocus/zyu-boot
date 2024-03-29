package zyu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zyu.service.IUserService;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private IUserService iUserService;

    @RequestMapping("/hello")
    public Object sayHello() {
        logger.debug("这是一个hello日志");
        return "hello";
    }

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/login")
    public String login(String username, String passwd) {
        boolean login = iUserService.login(username, passwd);
        if (login) {
            return "登陆成功";
        } else {
            return "登陆失败";
        }
    }

    @RequestMapping("/register")
    public String register(String username, String passwd) {
        boolean login = iUserService.register(username, passwd);
        if (login) {
            return "注册成功";
        } else {
            return "注册失败";
        }
    }

    @Transactional
    @RequestMapping("/batchAdd")
    public String batchAdd(String username,String passwd) {
        iUserService.batchAdd(username, passwd);
        return "成功";
    }
}