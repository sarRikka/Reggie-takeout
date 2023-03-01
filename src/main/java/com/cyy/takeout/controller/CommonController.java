package com.cyy.takeout.controller;

import com.cyy.takeout.common.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/common")
public class CommonController {
    
    @Value("${takeOut.path}")
    String mypath;
    
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file)
    {
        
        String originName=file.getOriginalFilename();
        String substring = originName.substring(originName.lastIndexOf("."));
        String filename= UUID.randomUUID()+"_"+substring;
        File dir=new File(mypath);
        
        if(!dir.exists())
        {
            dir.mkdirs();
        }

        try {
            file.transferTo(new File(mypath+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(filename);
    }
    
    @GetMapping("download")
    public void download(String name, HttpServletResponse httpServletResponse)
    {
        try {
            //输入流读取文件
            FileInputStream fileInputStream= new FileInputStream(new File(mypath+name));
            //输出流，通过输出流将文件写回浏览器
            ServletOutputStream outputStream = httpServletResponse.getOutputStream();

            httpServletResponse.setContentType("image/jpeg");
            
            int len;
            byte[] bytes=new byte[1024];
            
            while((len=fileInputStream.read(bytes))!=-1)
            {
                outputStream.write(bytes);
                outputStream.flush();
            }
            
            outputStream.close();
            fileInputStream.close();
            
        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    
}
