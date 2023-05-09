package com.peterjxl.controller;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception{
        System.out.println("fileUpload1");
        
        // 使用fileUpload组件完成文件上传
        // 上传的位置
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println("realPath: " + realPath);
        // 判断路径是否存在
        File file = new File(realPath);
        if (! file.exists()) {
            // 创建该文件夹
            file.mkdirs();
        }

        // 解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 解析request
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items){
            // 进行判断，当前item对象是否是上传文件项，如果不是则说明是表单内容
            if (item.isFormField()){
                // 是表单项
            }else {
                // 是上传文件项
                // 获取上传文件的名称
                String name = item.getName();
                String uuid = UUID.randomUUID().toString().replace("-", "");// 防止文件名重复，这里我们将减号替换为空字符串
                name = uuid + "_" + name;
                // 完成文件上传
                item.write(new File(realPath, name));
                // 删除临时文件。当文件小于10kb，则文件是在内存中的；如果大于10kb，会有一个临时文件。
                item.delete();
            }
        }

        return "success";
    }



    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws IOException {

        System.out.println("fileUpload2");


        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println("realPath: " + realPath);
        File file = new File(realPath);
        if (! file.exists()) {
            // 创建该文件夹
            file.mkdirs();
        }


        String originalFilename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");// 防止文件名重复，这里我们将减号替换为空字符串
        originalFilename = uuid + "_" + originalFilename;
        upload.transferTo(new File(realPath, originalFilename));
        return "success";
    }
}
