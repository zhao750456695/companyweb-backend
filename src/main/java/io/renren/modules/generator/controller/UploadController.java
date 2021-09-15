/**
 * projectName: renren-fast
 * fileName: UploadController.java
 * packageName: io.renren.modules.generator.controller
 * date: 2021-04-18 7:22
 * copyright(c) 2017-2020 xxx公司
 */
package io.renren.modules.generator.controller;

import io.renren.modules.generator.service.GoodsService;
import io.renren.modules.oss.cloud.AliyunCloudStorageService;
import io.renren.modules.oss.cloud.CloudStorageConfig;
import io.renren.modules.oss.cloud.OSSFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

@RequestMapping("/upload")
@RestController
public class UploadController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @ResponseBody
    @RequestMapping("/uploadImage")
    public String upload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("cat") int cat) throws IOException {
        //String fileName = file.getOriginalFilename();
       log.info("++++++++++++++++++++++++++++++++++++++++++++++++");

        String fname = multipartFile.getName();
        log.info(fname);
        log.info(multipartFile.getBytes().toString());
        String url = "";
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String date2=sdf.format(date);
            if (cat == 0) {
                url = OSSFactory.build().upload(new ByteArrayInputStream(multipartFile.getBytes()), "chunjiang/goods/list/" + date2 + "/" + multipartFile.getOriginalFilename());
            } else if(cat == 1) {
                url = OSSFactory.build().upload(new ByteArrayInputStream(multipartFile.getBytes()), "chunjiang/goods/head/" + date2 + "/" + multipartFile.getOriginalFilename());
            } else if(cat == 2){
                url = OSSFactory.build().upload(new ByteArrayInputStream(multipartFile.getBytes()), "chunjiang/goods/detail/" + date2 + "/" + multipartFile.getOriginalFilename());
            } else if(cat == 3){
                url = OSSFactory.build().upload(new ByteArrayInputStream(multipartFile.getBytes()), "chunjiang/" + date2 + "/" + multipartFile.getOriginalFilename());
            } else if(cat == 6){
                url = OSSFactory.build().upload(new ByteArrayInputStream(multipartFile.getBytes()), "chunjiang/tech/" + date2 + "/" + multipartFile.getOriginalFilename());
            } else if(cat == 7){
                url = OSSFactory.build().upload(new ByteArrayInputStream(multipartFile.getBytes()), "chunjiang/news/" + date2 + "/" + multipartFile.getOriginalFilename());
            }
            log.info(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

       log.info(multipartFile.getOriginalFilename());
        log.info(".....................................");
        return url;
    }
}
