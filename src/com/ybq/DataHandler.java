package com.ybq;
import java.util.List;


/**
 * Project Name:Spider
 * File Name:DataHandler.java
 * Package Name:
 * Date:2014-10-22����5:15:31
 * Copyright (c) 2014, boqing@staff.sina.com.cn All Rights Reserved.
 *
 */

/**
 * ClassName:DataHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014-10-22 ����5:15:31 <br/>
 * @author   ybq
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface DataHandler {
	 /**
     * ��ȡ�ĵ��е���ַ
     * 
     * @param html html�ĵ�����
     * @return
     */
    public List<String> getUrls(StringBuffer html);
    
    /**
     * ��ȡ�ĵ���ͼƬ��ַ
     * 
     * @param html html�ĵ�����
     * @return
     */
    public List<String> getImageUrls(StringBuffer html);
}
