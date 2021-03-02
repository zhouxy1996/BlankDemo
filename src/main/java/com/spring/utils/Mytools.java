package com.spring.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class Mytools {

	public static boolean existPointKey(String dfIngureList, String key) {
		if (dfIngureList == null || dfIngureList.length() <= 0) {
			return false;
		}
		JSONObject jsonObject = JSONObject.parseObject(dfIngureList);
		Object object = jsonObject.get(key);
		if (object != null) {
			return true;
		}
		return false;

	}

	public static List<String> readFile(String fileDir) throws IOException {
		List<String> list = new ArrayList<>();
		File file = new File(fileDir);
		FileReader fr = null;
		BufferedReader reader = null;
		try {
			fr = new FileReader(file);
			reader = new BufferedReader(fr);

			String str = reader.readLine();
			while (str != null && !"".equals(str)) {
				list.add(str);
				str = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			// 当抛出多个异常时，子异常当在父异常前抛出。
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (fr != null) {
				fr.close();
			}
		}
		return list;
	}

	public static String getPastDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(today);
		return result;
	}

	public static String replaceSpace(String[] arr) {
		if (arr == null || arr.length <= 0) {
			return null;
		}
		String ret = "";
		for (String line : arr) {
			ret = ret + line.replace(" ", "");
		}
		return ret;
	}

	/**
	 * 生成.json格式文件
	 */
	public static boolean createJsonFile(String jsonString, String filePath, String fileName) {
		// 标记文件生成是否成功
		boolean flag = true;

		// 拼接文件完整路径
		String fullPath = filePath + File.separator + fileName + ".json";

		// 生成json格式文件
		try {
			// 保证创建一个新文件
			File file = new File(fullPath);
			if (!file.getParentFile().exists()) { // 如果父目录不存在，创建父目录
				file.getParentFile().mkdirs();
			}
			/*
			 * if (file.exists()) { // 如果已存在,删除旧文件 file.delete(); }
			 */
			file.createNewFile();

			if (jsonString.indexOf("'") != -1) {
				// 将单引号转义一下，因为JSON串中的字符串类型可以单引号引起来的
				jsonString = jsonString.replaceAll("'", "\\'");
			}
			if (jsonString.indexOf("\"") != -1) {
				// 将双引号转义一下，因为JSON串中的字符串类型可以单引号引起来的
				jsonString = jsonString.replaceAll("\"", "\\\"");
			}

			if (jsonString.indexOf("\r\n") != -1) {
				// 将回车换行转换一下，因为JSON串中字符串不能出现显式的回车换行
				jsonString = jsonString.replaceAll("\r\n", "\\u000d\\u000a");
			}
			if (jsonString.indexOf("\n") != -1) {
				// 将换行转换一下，因为JSON串中字符串不能出现显式的换行
				jsonString = jsonString.replaceAll("\n", "\\u000a");
			}

			// 格式化json字符串
			// jsonString = JsonFormatTool.formatJson(jsonString);

			// 将格式化后的字符串写入文件
			Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
			write.write(jsonString);
			write.flush();
			write.close();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}

		// 返回是否成功的标记
		return flag;
	}

	/**
	 * 
	 *
	 * Description: 把结果写到文件中，文件存在则删除
	 * 
	 * @author zxy
	 * @date 2020年11月11日
	 *
	 */
	public static void writeToFile(List<String> lines, String filePath) {
		if (lines == null || lines.size() <= 0) {
			return;
		}
		try {
			BufferedWriter output = null;
			File file = new File(filePath);
			// 文件存在，则删除
			if (file.exists()) {
				file.delete();
			}
			// 创建空文件
			file.createNewFile();

			try {
				output = new BufferedWriter(new FileWriter(file, true));
				for (String line : lines) {
					output.write(line + "\r\n");
				}
			} finally {// true,则追加写入text文本
				try {
					if (output != null) {
						output.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
