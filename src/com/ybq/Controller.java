package com.ybq;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Project Name:Spider
 * File Name:Controller.java
 * Package Name:
 * Date:2014-10-22����5:20:46
 * Copyright (c) 2014, boqing@staff.sina.com.cn All Rights Reserved.
 *
 */

/**
 * ClassName:Controller <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014-10-22 ����5:20:46 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface Controller {
	 /**
     * ����ͼƬץȡ
     * @param pageUrl ҪץȡͼƬ����ҳ��ַ
     * @return
     * @throws IOException 
     * @throws MalformedURLException 
     */
    public List<File> fetchImages(String pageUrl,String imgSaveDir) throws MalformedURLException, IOException;

}
