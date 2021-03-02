package com.spring.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.entity.ExecuteResult;
import com.spring.entity.ServerStatus;
import com.spring.service.CheckServerStatusServiceImpl;
import com.spring.utils.GjjZipUtil;
import com.spring.utils.SSH2Client;

import org.apache.lucene.util.RamUsageEstimator;
@Controller
@RequestMapping("/checkAll")
public class CheckAllServerController {

	@Autowired
	private CheckServerStatusServiceImpl checkServerStatusServiceImpl;
	// localhost/checkAll/zip
	// localhost:8889/checkAll/zip

	@RequestMapping(value = "/zip")
	@ResponseBody
	public void Check() throws IOException, InterruptedException {
		checkServerStatusServiceImpl.Check();
		
	}
//	localhost/checkAll/openfile?num=1
	@RequestMapping(value = "/openfile")
	@ResponseBody
	public void openfile(String num) throws IOException, InterruptedException {
		this.read("/C:/Users/zxy/Desktop/tmp/"+num+".txt");
		
	}
	
	
	private static void read(String file) {
		System.out.println(file);
		// 创建字符流对象，并根据已创建的字节流对象创建字符流对象
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader raf = null;
		
		try {
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			raf = new BufferedReader(isr);
			
			String s = null;
			
			// 读取文件内容，并将其打印
			while((s = raf.readLine()) != null) {
				
			
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				raf.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	/**
	 * 
	 *
	 * Description: localhost/checkAll/sizeOfObject?size=10
	 * @author zxy
	 * @date 2020年12月3日
	 *
	 */
	@RequestMapping(value = "/sizeOfObject")
	@ResponseBody
	public String SizeOfObject(int siz) throws IOException, InterruptedException {
		
        //计算指定对象及其引用树上的所有对象的综合大小，返回可读的结果，如：2KB,1024000000
        if(siz <=0 ){
        	siz =10;
        }
        System.out.println(RamUsageEstimator.humanSizeOf(new byte[siz]));
       
        return "OK";
	}
	
	
	@RequestMapping(value = "/connectssh")
	@ResponseBody
	public String connectssh(String ip) throws IOException, InterruptedException {
		for (int j=1;j<=200;j++){
			for (int i=1;i<=30;i++){
				System.out.println(i*j);
				checkServerStatusServiceImpl.connectssh(ip);
			}
			Thread.currentThread().sleep(1000);
		}
       
        return "OK";
	}
	
	


}
