package com.java.book.java_network_programing._7._2;

import lombok.SneakyThrows;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Alin
 * @desc // 用URLConnection 下载web页面
 * @date 2020/4/12
 */
public class SourceViewer2 {
    @SneakyThrows
    public static void main(String[] args) {
        String encoding = "ISO-8859-1";
        if (args.length > 0) {
            final URL url = new URL(args[0]);
            final URLConnection uc = url.openConnection();
            final String contentType = uc.getContentType();
            final int encodingStart = contentType.indexOf("charset=");
            if (encodingStart != -1) {
                encoding = contentType.substring(encodingStart + 8);
            }
            try (InputStream raw = uc.getInputStream()) {
                final BufferedInputStream buffer = new BufferedInputStream(raw);
                final InputStreamReader reader = new InputStreamReader(buffer, encoding);
                int c;
                while ((c = reader.read()) != -1) {
                    System.out.print((char) c);
                }
                reader.close();
            }
        }
    }
}
