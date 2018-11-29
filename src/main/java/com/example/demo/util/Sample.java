package com.example.demo.util;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;

import java.util.HashMap;

public class Sample {
	//设置APPID/AK/SK
	public static final String APP_ID = "14979764";
	public static final String API_KEY = "zDWG6zuiPisyheGWSnTdaUSi";
	public static final String SECRET_KEY = "4jcEjRC0pK2GhYGXmGj4cqm571Z4YIvP";

	public static void main(String[] args) {
		// 初始化一个AipImageClassifyClient
		AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);

		// 可选：设置代理服务器地址, http和socket二选一，或者均不设置
		//client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
		//client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

		// 可选：设置log4j日志输出格式，若不设置，则使用默认配置
		// 也可以直接通过jvm启动参数设置此环境变量
		//System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
		/*
		// 调用接口
		String path = "F:/Speech/bc.jpg";
		//JSONObject res = client.objectDetect(path, new HashMap<String, String>());
		JSONObject res = client.advancedGeneral(path, new HashMap<String, String>());
		System.out.println(res.toString(2));
		*/
		new Sample().dishDetect(client);
	}


	public void sample(AipImageClassify client) {
		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<>(100);
		options.put("baike_num", "5");

		// 参数为本地路径
		String image = "F:/Speech/tz.jpg";
		JSONObject res = client.advancedGeneral(image, options);
		System.out.println(res.toString(2));

		/*// 参数为二进制数组
		byte[] file = readFile("test.jpg");
		res = client.advancedGeneral(file, options);
		System.out.println(res.toString(2));*/
	}
	public void dishDetect(AipImageClassify client) {
		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("top_num", "3");
		options.put("filter_threshold", "0.7");
		options.put("baike_num", "5");


		// 参数为本地路径
		String image = "F:/Speech/f.jpg";
		JSONObject res = client.dishDetect(image, options);
		System.out.println(res.toString(2));

		/*// 参数为二进制数组
		byte[] file = readFile("test.jpg");
		res = client.dishDetect(file, options);
		System.out.println(res.toString(2));*/
	}
}