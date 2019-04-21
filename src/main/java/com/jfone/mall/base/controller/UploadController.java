package com.jfone.mall.base.controller;

import com.jfone.mall.base.common.BaseResponse;
import com.jfone.mall.base.entity.work.resp.UploadResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Controller
@Api(tags="上传图片")  //swagger分类标题注解
@RequestMapping(value="/upload")
public class UploadController {
    @ApiOperation(value="上传图片", notes="")
    @RequestMapping(value="image",method = RequestMethod.POST)
    @ResponseBody
    public UploadResp upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request, ModelMap model) {
        UploadResp uploadResp = new UploadResp();
        System.out.println("上传图片");
        /* 获取上传文件的后缀 */
        String suffix = multipartFile.getOriginalFilename().substring (multipartFile.getOriginalFilename().lastIndexOf("."));
        /* 保存文件名称 */
        String logImageName = UUID.randomUUID().toString()+ suffix;
        /* 构建图片保存的目录 */
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
        String logoPathDir = "/images"+ dateformat.format(System.currentTimeMillis());
        /* 返回相对路径给客户端 */
        uploadResp.setName(logoPathDir+"/"+logImageName);
        System.out.println("uploadResp"+uploadResp);
        /* 得到图片保存目录的真实路径 */
        //String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);
        //String logoRealPathDir = "D:/eclipse-workspace/qf_1806_1_1/qf_1806_1_1_web/src/main/webapp/images
        // "+logoPathDir;
        String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);

        System.out.println("logoRealPathDir"+logoRealPathDir);
        /**根据真实路径创建目录**/
        File logoSaveFile = new File(logoRealPathDir);
        if(!logoSaveFile.exists()) logoSaveFile.mkdirs();

        //构建文件名称
        //String logImageName = multipartFile.getOriginalFilename();
        /**拼成完整的文件保存路径加文件**/
        /*File.separator在Windows下的路径分隔符（\）*/

        //String fileName=
        String fileName = logoRealPathDir + File.separator + logImageName;
        System.out.println("fileName"+fileName);
        try {
            File file = new File(fileName);
            multipartFile.transferTo(file);
        }
        catch (IllegalStateException e)
        {
            e.printStackTrace(); }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return uploadResp;


    }

    @ApiOperation(value="删除图片", notes="")
    @RequestMapping(value="delete",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse Delete (@RequestBody UploadResp uploadResp, HttpServletRequest request){
        //UploadResp uploadResp = new UploadResp();
        //String Name = name.name;
        //String logoRealPathDir = request.getSession().getServletContext().getRealPath(name);
        //System.out.println("logoRealPathDir1"+logoRealPathDir);
        String dName=uploadResp.getName();
        String Dname = dName.substring(1);
        System.out.println("Dname"+Dname);
        /*System.out.println(this.getClass().getResource("/"));*/
        //System.out.println(request.getServletContext().getRealPath("/"));
        String TargetDir = request.getServletContext().getRealPath("/");
        String DelPicturePath = TargetDir+Dname;
        System.out.println(DelPicturePath);

        //从目录中删除图片
        int state = 0;
        File f = new File(DelPicturePath);
        if(f.delete()){
            System.out.println("删除成功");
            state = 1;
        }else{
            System.out.println("删除失败");
        }

        return new BaseResponse(state);
    }
}

