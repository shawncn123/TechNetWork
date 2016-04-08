package com.shenxf.ssh.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javassist.expr.Instanceof;

import org.apache.struts2.ServletActionContext;

public class FileOperationService {

	/*
	 * 功能： 罗列指定文件夹下的文件
	 */

	/**
	 * 
	 * 获取目录下所有文件
	 * 
	 * @param realpath
	 * @param files
	 * @return
	 */
	public static List<File> getFiles(String realpath, List<File> files) {

		File realFile = new File(realpath);
		if (realFile.isDirectory()) {
			File[] subfiles = realFile.listFiles();
			for (File file : subfiles) {
				if (file.isDirectory()) {
					getFiles(file.getAbsolutePath(), files);
				} else {
					files.add(file);
				}
			}
		}
		return files;
	}

	/**
	 * 获取目录下所有文件(按时间排序)
	 * 
	 * @param path
	 * @return
	 */
	public static List<File> getFileSort(String path) {

		List<File> list = getFiles(path, new ArrayList<File>());

		if (list != null && list.size() > 0) {

			Collections.sort(list, new Comparator<File>() {
				public int compare(File file, File newFile) {
					if (file.lastModified() < newFile.lastModified()) {
						return 1;
					} else if (file.lastModified() == newFile.lastModified()) {
						return 0;
					} else {
						return -1;
					}

				}
			});

		}

		return list;
	}

	public String[] listFile(String filePath) {

		List<File> list = getFileSort(filePath);
		
		String[] fileNames = new String[list.size()];
		
		System.out.println(list.size());
		
		for(int i=0; i<list.size();i++){
			if (list.get(i).getName() != null) {
				String s1=list.get(i).getName();
				System.out.println(s1);
				fileNames[i] = s1 + "";
			}else{
				fileNames[i] = "";
			}
		}
		return fileNames;
	}
	// 未排序的方法
	// public String[] listFile(String filePath) {
	// //List<String> listfilenames = null;
	// File dir = new File(filePath);
	// System.out.println("使用list方法获取所有文件名");
	// String[] fileNames = dir.list();
	// for (int i = 0; i < fileNames.length; i++) {
	// System.out.println(fileNames[i] + ";");
	// //listfilenames.add(fileNames[i]);
	// }
	// System.out.println(" ");
	// System.out.println("使用listFiles方法获取所有文件对象");
	// File[] files = dir.listFiles();
	// for (int i = 0; i < files.length; i++) {
	// if (files[i].isDirectory())
	// System.out.print("目录:" + files[i].getName() + " ");
	// else if (files[i].isFile())
	// System.out.print(" 文件:" + files[i].getName() + " ");
	// }
	// return fileNames;
	// }

}
