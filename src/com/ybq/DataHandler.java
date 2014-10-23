package com.ybq;
import java.util.List;


/**
 * Project Name:Spider
 * File Name:DataHandler.java
 * Package Name:
 * Date:2014-10-22下午5:15:31
 * Copyright (c) 2014, boqing@staff.sina.com.cn All Rights Reserved.
 *
 */

/**
 * ClassName:DataHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014-10-22 下午5:15:31 <br/>
 * @author   ybq
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface DataHandler {
	 /**
     * 获取文档中的网址
     * 
     * @param html html文档内容
     * @return
     */
    public List<String> getUrls(StringBuffer html);
    
    /**
     * 获取文档中图片地址
     * 
     * @param html html文档内容
     * @return
     */
    public List<String> getImageUrls(StringBuffer html);
}
