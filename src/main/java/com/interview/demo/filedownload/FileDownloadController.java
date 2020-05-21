package com.interview.demo.filedownload;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;

/**
 * @author Alin
 * @desc 下载图片
 * @date 2019/5/4
 */
@Controller
@RequestMapping("/file")
public class FileDownloadController {
    @RequestMapping("/down")
    public void upload(HttpServletResponse rs) {
        rs.reset();
        rs.setHeader("Content-disposition", "attachment; filename=test.jpg");
        rs.encodeRedirectURL("UTF-8");
        rs.setContentType("application/octet-stream");
        final ServletOutputStream out;
        try {
            out = rs.getOutputStream();
            final BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\king_zl\\Pictures\\Saved Pictures\\3.jpg")));
            byte[] buff = new byte[bis.available()];
            bis.read(buff);
            out.write(buff);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
