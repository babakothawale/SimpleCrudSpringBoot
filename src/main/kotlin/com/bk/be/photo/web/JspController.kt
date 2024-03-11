package com.bk.be.photo.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class JspController {
    @RequestMapping("home")
    fun home(): String {
        System.out.println("Home request")
        return "home"
    }
}