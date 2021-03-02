package com.spring.cons;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class GlobalParams {
	
    @Value("${ssh.master.user}")
    private String sshMasterUser;
    
    @Value("${ssh.master.pwd}")
    private String sshMasterPwd;
    
    @Value("${ip.all}")
    private String ipAll;
    
    @Value("${ip.ivr}")
    private String ipIvr;
    
    @Value("${ip.no.need.check.java.process}")
    private String ipNoNeedCheckJavaProcess;
    
    
    @Value("${ip.user.name}")
    private String ipUserName;
    
    @Value("${ip.user.pwd}")
    private String ipUserPwd;
    
    @Value("${mount.count.of.callCenter}")
    private int mountCountOfCallCenter;
    
    @Value("${max.top.size}")
    private int maxTopSize;
    
    @Value("${max.cpu}")
    private int maxCpu;
    
    
    @Value("${max.swap}")
    private int maxSwap;
    
    
    @Value("${special.java.process}")
    private String specialProcessCpu;
    
    @Value("${max.process.cpu}")
    private int maxProcessCpu;
    
    @Value("${max.inode}")
    private int maxInode;
    
    @Value("${max.disc}")
    private int maxDisc;
    
    @Value("${max.tail.size}")
    private int maxTailSize;
    
    @Value("${max.thread}")
    private int maxThread;
    
    @Value("${max.connection}")
    private int maxConnection;
    
    @Value("${max.port}")
    private int maxPort;
    
    @Value("${Appstore.expiration.time}")
    private String appstoreExpirationTime;
    
    @Value("${WeChat.Official.Accounts.expiration.time}")
    private String weChatOfficialAccountsExpirationTime;
    
    @Value("${expiration.tip.date}")
    private int expirationTipDate;
    
    
    @Value("${expiration.tip.continue.days}")
    private int expirationTipContinueDays;
    
    @Value("${ignore.df}")
    private String ignoreDfList;
    
    @Value("${max.process.count}")
    private int maxProcessCount;
    
    @Value("${mes.send.test.url}")
    private String mesSendUrl;
    
    @Value("${url.connect.check}")
    private boolean urlConnectCheck;
    
    @Value("${zip.Image}")
    private boolean zipImage; 
   
    @Value("${mount.file.root}")
    private String mountfileRoot; 
    
    @Value("${diskUsage.file.root}")
    private String diskUsagefileRoot; 
    
    @Value("${retmsg.file}")
    private String retmsgfile; 
    
    @Value("${result.save.root}")
    private String resultSaveRoot;
    
    @Value("${start.server.flag}")
    private String startServerFlag;
    
   
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    
    



}
