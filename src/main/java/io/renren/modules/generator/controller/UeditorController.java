/**
 * projectName: renren-fast
 * fileName: UeditorController.java
 * packageName: io.renren.modules.generator.controller
 * date: 2021-04-23 11:45
 * copyright(c) 2017-2020 xxx公司
 */
package io.renren.modules.generator.controller;

import com.baidu.ueditor.ActionEnter;
import com.baidu.ueditor.upload.IStorageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("ueditor")
public class UeditorController {
    @Autowired
    private IStorageManager uploader;

    @RequestMapping("/upload")
    public void upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/html");

        String rootPath = request.getServletContext().getRealPath("/");
        response.getWriter().write(new ActionEnter(uploader, request, rootPath).exec());
    }
}