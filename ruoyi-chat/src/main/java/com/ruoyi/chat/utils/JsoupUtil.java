package com.ruoyi.chat.utils;

import com.ruoyi.common.domain.ChatMessage;
import com.ruoyi.common.utils.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Safelist;
import org.jsoup.select.Elements;

import java.util.Map;

/**
 * Xss过滤工具
 */
public class JsoupUtil {

	protected JsoupUtil(){

	}

	/**
	 * 使用自带的 basicWithImages 白名单
	 * 允许的便签有a,b,blockquote,br,cite,code,dd,dl,dt,em,i,li,ol,p,pre,q,small,span,
	 * strike,strong,sub,sup,u,ul,img
	 * 以及a标签的href,img标签的src,align,alt,height,width,title属性
	 */
	private static final Safelist whitelist = Safelist.none();
	/**
	 * 配置过滤化参数,不对代码进行格式化
	 */
	private static final Document.OutputSettings outputSettings = new Document.OutputSettings().prettyPrint(false);

	static {
		/*
		 * 富文本编辑时一些样式是使用style来进行实现的 比如红色字体 style="color:red;" 所以需要给所有标签添加style属性
		 */
		whitelist.addAttributes(":all", "style");
	}

	public static String clean(String content) {
		return Jsoup.clean(content, "", whitelist, outputSettings);
	}

	public static String clean(String content, Safelist whitelist) {
		return Jsoup.clean(content, "", whitelist, outputSettings);
	}

	public static ChatMessage cleanMessageData(ChatMessage chatMessage) {
		if(StringUtils.isNotBlank(chatMessage.getMessage())){
			chatMessage.setMessage(chatMessage.getMessage().replace("&nbsp;"," "));
		}
		formatMessage(chatMessage);
		Map<String, Object> map = BeanMapUtil.beanToMapObjet(chatMessage);
		for (Map.Entry<String, Object> en : map.entrySet()) {
			if(en.getValue() instanceof String){
				map.put(en.getKey(),JsoupUtil.clean(en.getValue().toString()));
			}
		}
		chatMessage = BeanMapUtil.mapToBean(map, chatMessage);
		if(StringUtils.isNotBlank(chatMessage.getMessage())){
			chatMessage.setMessage(chatMessage.getMessage().replace("\"",""));
			chatMessage.setMessage(chatMessage.getMessage().replace("\'",""));
		}
		return chatMessage;
	}
	private static void formatMessage(ChatMessage chatMessage){
		if (chatMessage != null && StringUtils.isNotBlank(chatMessage.getMessage())){
			Document document = Jsoup.parse(chatMessage.getMessage());
			Elements imgElements = document.select("img");
			StringBuilder str = new StringBuilder();
			for (Element img : imgElements) {
				str.append(img.attr("src")).append(",");
			}
			if (str.length()>0){
				chatMessage.setImagesMsg(str.deleteCharAt(str.lastIndexOf(",")).toString());

			}
		}
	}

}
