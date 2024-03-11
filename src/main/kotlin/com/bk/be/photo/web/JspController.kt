package com.bk.be.photo.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView


@Controller
class JspController {
    @RequestMapping("home")
    fun home(@RequestParam("name") paramName: String): ModelAndView {
        System.out.println("Home request")
        val mv = ModelAndView()
        mv.addObject("name", paramName)
        mv.viewName = "home"
        return mv
    }
}