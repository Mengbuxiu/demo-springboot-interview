package com.interview.demo.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Alin
 * @desc //限制用户上传的文件类型
 * @date 2019/5/4
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {
    @RequestMapping("/to_fileUpLoad")
    public String toFileUpLoad() {
        return "file_upload";
    }

    @RequestMapping("/up")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] bytes = new byte[2];
        file.getInputStream().read(bytes, 0, 2);
        /**
         * 50 4B == PK
         * 是docx的文件头,据说有一定的性能影响，可以结合文件后缀判断 + 前端限制
         * 可以在js中先获取一下文件头几个字节传到后台验证，如果确定是正确的文件类型再传到后台
         */
        if (Integer.toHexString(bytes[0]).toUpperCase().equals("50")
                && Integer.toHexString(bytes[1]).toUpperCase().equals("4B")){
            return "ok";
        }
        return "fail";
    }
}
