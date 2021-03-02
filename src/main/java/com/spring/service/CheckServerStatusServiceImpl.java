package com.spring.service;


import java.io.IOException;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.spring.entity.ExecuteResult;
import com.spring.utils.GjjZipUtil;
import com.spring.utils.SSH2Client;


@Service
public class CheckServerStatusServiceImpl {


	private static String OS = System.getProperty("os.name").toLowerCase();
	
	@Async
	public void Check() throws IOException, InterruptedException {
		System.out.println(Thread.currentThread().getName());
		if(OS.contains("windows")){
			GjjZipUtil.unZip("C:/rcxj/tmp/logs.zip", "C:/rcxj/tmp/logs/");
		}else{
			GjjZipUtil.unZip("/home/admin/tmp/logs1.zip", "/home/admin/tmpfiles/");
			
		}
	}
	
	
@Async
public void connectssh(String ip) throws IOException, InterruptedException {
		
		ExecuteResult e = new ExecuteResult();
		
		String user = "admin";
		String pwd = "123";
		SSH2Client client = null;
		System.out.println("connect "+ip);
		e.setIp(ip);
		e.setDesc("");
		try {
			client = new SSH2Client(e.getIp(), user, pwd);
			boolean conn = client.isConn();
			if (conn) {
				

			} else {
				e.setCustnote("ssh 连接" + ip + "失败," + client.getFailedMsg());

			}

		} catch (Exception exception) {
			exception.printStackTrace();
			e.setCustnote("连接" + ip + "成功，执行命令失败," + client.getFailedMsg() + "," + exception.getMessage());

		} finally {
			if (client != null) {
				client.close();
			}
		}
		
       
	}
	

}
