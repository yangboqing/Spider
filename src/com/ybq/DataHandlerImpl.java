package com.ybq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Project Name:Spider
 * File Name:DataHandlerImpl.java
 * Package Name:
 * Date:2014-10-22����5:16:25
 * Copyright (c) 2014, boqing@staff.sina.com.cn All Rights Reserved.
 *
 */

/**
 * ClassName:DataHandlerImpl <br/>
 * Function: TODO ���ݴ���ʵ����. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014-10-22 ����5:16:25 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class DataHandlerImpl implements DataHandler {
	@Override
	public List<String> getImageUrls(StringBuffer html) {

		List<String> result = new ArrayList<String>();

		// ���ַ�������Ϊhtml�ĵ�
		Document doc = Jsoup.parse(html.toString());

		// ��ȡimg��ǩ
		Elements es = doc.getElementsByTag("img");

		// ��ȡûһ��img��ǩsrc�����ݣ�Ҳ����ͼƬ��ַ
		for (Iterator<Element> i = es.iterator(); i.hasNext();) {
			Element e = i.next();
			String r = e.attr("src");
			if (RegexUtil.validateSting(r, "http://.+//.(jpg|jpeg|png)")) {
				result.add(r);
			}
		}

		return result;
	}

	@Override
	public List<String> getUrls(StringBuffer html) {
		List<String> result = new ArrayList<String>();

		// ���ַ�������Ϊhtml�ĵ�
		Document doc = Jsoup.parse(html.toString());

		// ��ȡa��ǩ
		Elements es = doc.getElementsByTag("a");

		// ��ȡûһ��a��ǩsrc�����ݣ�Ҳ������ַ
		for (Iterator<Element> i = es.iterator(); i.hasNext();) {
			Element e = i.next();
			String r = e.attr("href");
			if (RegexUtil.validateSting(r, "[a-zA-z]+://[^//s]*")) {
				result.add(r);
			}
		}

		return result;
	}

}
