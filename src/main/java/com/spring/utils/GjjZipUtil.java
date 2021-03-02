package com.spring.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 定制化压缩文件
 * @author Y01154
 *
 */
public class GjjZipUtil {
	private static final  Logger logger = LoggerFactory.getLogger(GjjZipUtil.class);
/**
 * 
 * @param inputFileName 待压缩文件夹路径
 * @param zipFileName 压缩文件夹名称全路径
 * @param base 指定压缩包内第一层的名称
 * @throws Exception 
 */
  protected static void zip(String inputFileName, String zipFileName,String base)
    throws Exception
  {
    zip(zipFileName, new File(inputFileName), base);
  }
  /**
   * 
   * @param inputFileName 待压缩文件夹路径
   * @param zipFileName 压缩文件夹名称全路径
   * @param base 指定压缩包内第一层的名称
   * @throws Exception 
   */
  protected static void zip(String zipFileName, File inputFile, String base) throws Exception {
	  OutputStream fo=null;
	  ZipOutputStream out = null;
	  try{
		  fo=new FileOutputStream(zipFileName);
		  out = new ZipOutputStream(new FileOutputStream(zipFileName));
		  zip(out, inputFile, base);
	 }finally{
		 closeIO(out,fo);
	 }
  }

  private static void zip(ZipOutputStream out, File f, String base) throws Exception {
    if (f.isDirectory()) {
      File[] fl = f.listFiles();
      out.putNextEntry(new ZipEntry(base + "/"));
      for (int i = 0; i < fl.length; i++){
        zip(out, fl[i], base +"/"+ fl[i].getName());
      }
    }else {
      out.putNextEntry(new ZipEntry(base));
      FileInputStream in =null;// 
      try{
	      int b=0;
	      in= new FileInputStream(f);
	      byte[] line=new byte[2048];
	      while ((b = in.read(line,0,line.length)) != -1)
	      {
	        out.write(line,0,b);
	      }
	      out.flush();
      }finally{
    	  closeIO(in);
      }
    }
  }
  

	/**
	 * 解压压缩包(专用),会去掉第一层的目录，重新命名
	 * @param zipAddress
	 * @param unZipAddress
	 * @return zipDirectoryName 附件文件夹名称（附件）
	 */
	public static void unZip(String zipAddress,String unZipAddress){
		InputStream is = null;
		FileOutputStream fos = null;
		ZipFile zipFile = null;
		try {
			File file = new File(zipAddress);
			zipFile = new ZipFile(file);
			Enumeration<? extends ZipEntry> e = zipFile.entries();
			while(e.hasMoreElements()) {
				ZipEntry zipEntry =  e.nextElement();
//				 System.out.println("解压:"+zipEntry.getName());
			     String filePath=zipEntry.getName().replace("\\", "/");
				 int index=filePath.indexOf("/");
				 if(index>-1){//第一层的目录去掉，此处专用
					filePath=filePath.substring(index+1);
				 }
				 try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				 if(!zipEntry.isDirectory()){
//					 System.out.println(unZipAddress + filePath);
					File f = new File(unZipAddress + filePath);
					if(!f.getParentFile().exists()){
						if(!f.getParentFile().mkdirs()){
							System.out.println("创建文件出错:"+f.getAbsolutePath());
							continue;
						}
					}
					is = zipFile.getInputStream(zipEntry);
					fos = new FileOutputStream(f);
					int length = 0;
					byte[] b = new byte[1024];
					while((length=is.read(b, 0, 1024))!=-1) {
						fos.write(b, 0, length);
					}
					fos.flush();
					fos.close();
					is.close();
				}else{
					if(filePath.length()>0){
						File f = new File(unZipAddress + filePath);
						if(!f.exists()){
							if(!f.mkdirs()){
								System.out.println("创建文件夹失败！"+f.getAbsolutePath());
								
							}
						}
					}
				}
			}
		} catch (IOException e) {
			System.out.println("解压文件发生错误："+e.getMessage());
		}finally {
			closeIO(fos,is,zipFile);
		}
		
	}
	private static void closeIO(Closeable ...ios){
		if(ios!=null)
		for(Closeable io:ios){
			if(io!=null){
				try {
					io.close();
				} catch (Exception e) {
					logger.error("关闭流出错："+e.getMessage(),e);
				}
			}
		}
	}

}

