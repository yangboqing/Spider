package com.ybq;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Project Name:Spider
 * File Name:DataFetcher.java
 * Package Name:
 * Date:2014-10-22����5:13:19
 * Copyright (c) 2014, boqing@staff.sina.com.cn All Rights Reserved.
 *
 */

/**
 * ClassName:DataFetcher <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014-10-22 ����5:13:19 <br/>
 * @author   ybq
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface DataFetcher {
    
    /**
     * ץȡ��ҳ
     * 
     * @param htmlUrl ��ҳ��ַ
     * @return 
     * @throws IOException 
     * @throws MalformedURLException 
     */
    public StringBuffer fetchHtml(String httpUrl) throws MalformedURLException, IOException;
    
    /**
     * ץȡ�ļ�
     * 
     * @param fileUrl �ļ���ַ
     * @param fileSavePath �ļ������ַ
     * @return
     * @throws IOException 
     * @throws MalformedURLException 
     */
    public File fecthFile(String httpUrl,String fileSavePath) throws MalformedURLException, IOException;
} 

