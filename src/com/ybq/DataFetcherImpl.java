package com.ybq;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Project Name:Spider
 * File Name:DataFetcherImpl.java
 * Package Name:
 * Date:2014-10-22下午5:14:21
 * Copyright (c) 2014, boqing@staff.sina.com.cn All Rights Reserved.
 *
 */

/**
 * ClassName:DataFetcherImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014-10-22 下午5:14:21 <br/>
 * @author   ybq
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class DataFetcherImpl implements DataFetcher {
	@Override
    public File fecthFile(String httpUrl, String fileSavePath)
            throws MalformedURLException, IOException {

        File file = new File(fileSavePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        // 打开输入流
        BufferedInputStream in = new BufferedInputStream(
                getInputStream(httpUrl));

        // 打开输出流
        FileOutputStream out = new FileOutputStream(file);

        byte[] buff = new byte[1];
        // 读取数据
        while (in.read(buff) > 0) {
            out.write(buff);
        }

        out.flush();
        out.close();
        in.close();
        return file;
    }

    @Override
    public StringBuffer fetchHtml(String httpUrl) throws MalformedURLException,
            IOException {

        StringBuffer data = new StringBuffer();

        String currentLine;

        // 打开输入流
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                getInputStream(httpUrl), "GBK"));

        // 读取数据
        while ((currentLine = reader.readLine()) != null) {
            data.append(currentLine);
        }
        reader.close();

        return data;
    }

    /**
     * 获取数据流
     * @param httpUrl
     * @return
     * @throws IOException
     */
    private InputStream getInputStream(String httpUrl) throws IOException {
        // 网页Url
        URL url = new URL(httpUrl);
        URLConnection uc = url.openConnection();
        uc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        return uc.getInputStream();
    }

}
