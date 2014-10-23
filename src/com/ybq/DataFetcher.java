package com.ybq;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Project Name:Spider
 * File Name:DataFetcher.java
 * Package Name:
 * Date:2014-10-22下午5:13:19
 * Copyright (c) 2014, boqing@staff.sina.com.cn All Rights Reserved.
 *
 */

/**
 * ClassName:DataFetcher <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014-10-22 下午5:13:19 <br/>
 * @author   ybq
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface DataFetcher {
    
    /**
     * 抓取网页
     * 
     * @param htmlUrl 网页地址
     * @return 
     * @throws IOException 
     * @throws MalformedURLException 
     */
    public StringBuffer fetchHtml(String httpUrl) throws MalformedURLException, IOException;
    
    /**
     * 抓取文件
     * 
     * @param fileUrl 文件地址
     * @param fileSavePath 文件保存地址
     * @return
     * @throws IOException 
     * @throws MalformedURLException 
     */
    public File fecthFile(String httpUrl,String fileSavePath) throws MalformedURLException, IOException;
} 

