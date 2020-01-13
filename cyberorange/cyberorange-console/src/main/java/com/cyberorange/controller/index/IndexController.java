package com.cyberorange.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class IndexController {
    /**
     * 跳转首页
     */
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String toIndex() {
        return "index.html";
    }

    /**
     * 跳转个人资料卡
     * @return
     */
    @RequestMapping(value = "/card.html", method = RequestMethod.GET)
    public String toCard(Model model) {
        
        return "card.html";
    }
}
