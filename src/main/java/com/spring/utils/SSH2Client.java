package com.spring.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.trilead.ssh2.Connection;
import com.trilead.ssh2.Session;
import com.trilead.ssh2.StreamGobbler;

public class SSH2Client {
	private final String DEFAULTCHART = "UTF-8";
	private final int MAX_LIST_SIZE = 1000;
	private Connection conn = null;
	private boolean isConn = false;
	private Session session = null;
	private String ip;
	private String userName;
	private String userPwd;
	private String failedMsg = "";

	public SSH2Client(String ip, String userName, String userPwd) {
		this.ip = ip;
		this.userName = userName;
		this.userPwd = userPwd;
		login();
	}

	public String getIp() {
		return ip;
	}

	private void login() {
		System.out.println("Connecting to server " + ip + ":" + userName + "/" + userPwd + "  ......");
		try {
			conn = new Connection(ip);
			conn.connect();// 连接
			isConn = conn.authenticateWithPassword(userName, userPwd);// 认证
			if (isConn) {
				System.out.println(" ");
				System.out.println(">>>>>>>>>>>>>>>>>>>>>> " + ip);
			} else {
				failedMsg = "Connecting to " + ip + " fail. password error";
				System.out.println("Connecting to " + ip + " fail. password error");
				
			}
		} catch (IOException e) {
			failedMsg = "Connecting to " + ip + " fail." + e.getMessage();
			System.out.println("Connecting to " + ip + " fail." + e.getMessage());
			throwEx(e);
		}
	}

	private List<String> processStdout(InputStream in, String charset, int maxline) {
		InputStream stdout = new StreamGobbler(in);
		List<String> list = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(stdout, charset));
			String line = null;
			int line_count = 0;
			while ((line = br.readLine()) != null && line_count++ < maxline) {
				if (line.trim().length() > 0) {
					list.add(line);
				}
			}
		} catch (UnsupportedEncodingException e) {
			throwEx(e);
		} catch (IOException e) {
			throwEx(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					throwEx(e);
				}
			}
		}
		return list;
	}

	public List<String> execute(String cmd) {
		return execute(cmd, MAX_LIST_SIZE);
	}

	public List<String> execute(String cmd, int maxline) {
		List<String> list = new ArrayList<String>();

		try {
			if (isConn && conn != null) {
				session = conn.openSession();
				session.execCommand(cmd);// 执行命令
				System.out.println("exec command : "+cmd);
				list = processStdout(session.getStdout(), DEFAULTCHART, maxline);
				if (list.size() == 0) {
					System.out.println("getStdout is empty,ip:" + conn.getHostname() + ",command：" + cmd);
					list = processStdout(session.getStderr(), DEFAULTCHART, maxline);
				} else {
					@SuppressWarnings("unused")
					String cmdstr = null;
					if (cmd.startsWith("top")) {
						cmdstr = "top";
					} else if (cmd.startsWith("tail") || cmd.startsWith("df")) {
						cmdstr = cmd;
					}
					
				}
				session.close();
			} else {
				System.out.println(conn.getHostname() + " not connect,execute fail.");
			}
		} catch (IOException e) {
			System.out.println("execute command fail,ip:" + conn.getHostname() + ",command[ " + cmd + "  ],message:"
					+ e.getMessage());
			close();
			throwEx(e);
		}
		return list;
	}

	public void close() {
		if (session != null)
			session.close();
		if (conn != null)
			conn.close();
	}

	public void throwEx(Exception e) {
		System.out.println("system error happened." + e.getMessage());

	}

	public boolean isConn() {
		return this.isConn;
	}

	public String toString() {
		return "SSH2Client [isConn=" + isConn + ", ip=" + ip + ", userName=" + userName + ", userPwd=" + userPwd + "]";
	}

	public String getFailedMsg() {
		return failedMsg;
	}

	public void setFailedMsg(String failedMsg) {
		this.failedMsg = failedMsg;
	}
	

	
}
