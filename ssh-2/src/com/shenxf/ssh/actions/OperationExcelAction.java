package com.shenxf.ssh.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.shenxf.ssh.service.FileOperationService;
import com.shenxf.ssh.service.OperationExcelForPOI;

public class OperationExcelAction extends ActionSupport implements RequestAware{

	private static final long serialVersionUID = 1L;

	private OperationExcelForPOI operationExcelForPOI;

	public void setOperationExcelForPOI(
			OperationExcelForPOI operationExcelForPOI) {
		this.operationExcelForPOI = operationExcelForPOI;
	}

	private FileOperationService fileOperationService;

	public void setFileOperationService(
			FileOperationService fileOperationService) {
		this.fileOperationService = fileOperationService;
	}

	String uploadFilePath = ServletActionContext.getServletContext()
			.getRealPath("WEB-INF/upload");

	// private String f1 = uploadFilePath + "/rybq_data_csv.csv";
	private String f1 = uploadFilePath + "/test2.xlsx";

	/*
	 * 功能：读取文件夹下的所有文件
	 */
	public String listFile() {
		System.out.println(uploadFilePath);
		request.put("listfilenames", fileOperationService.listFile(uploadFilePath));
		return SUCCESS;

	}

	/*
	 * 实现读取excel文件的表格数据
	 */
	public void OperationFile() {

		System.out.println(f1);
		String strs = "中文测试";
		System.out.println(strs);

		try {
			String str = new String(strs.getBytes(), "UTF-8");
			// 因为strs.getBytes()在没有指定其字符集格式时，
			// 它会使用系统默认的字符集编码格式；
			// 当然如果知道系统默认的编码格式，也可以使用有指定的方式；
			// 我机器的默认编码格式"gbk"，那么strs.getBytes("gbk")就也正确输出；
			System.out.println(str);
		} catch (Exception e) {
		}

		operationExcelForPOI.impExcel(f1);

		// return SUCCESS;
	}

	/*
	 * 功能： 下载文件
	 */

	private String fileName;
	private String encodFile;

	public String getEncodFile() {
		return encodFile;
	}

	public void setEncodFile(String encodFile) {
		this.encodFile = encodFile;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream() throws UnsupportedEncodingException,
			FileNotFoundException {

		// 解解乱码
		// this.fileName = new String(this.fileName.getBytes(""),"UTF-8");
		// return
		// ServletActionContext.getServletContext().getResourceAsStream(fileName);

		// 如果下载文件名为中文，进行字符编码转换
		encodFile = java.net.URLEncoder.encode(fileName, "UTF-8");
		// ServletActionContext.getResponse().setHeader("Content-Disposition","attachment;fileName=\""+
		// encodFile + "\"");
		// 使用绝对路径 ，从该路径下载“测试.txt"文件
		// String dfile = uploadFilePath + "/" + encodFile;
		String dfile = uploadFilePath + "/" + fileName;
		System.out.println(dfile);
		InputStream inputStream = new FileInputStream(dfile);
		System.out.println(inputStream);
		return inputStream;
	}

	public String downloadFile() {
		return SUCCESS;
	}

	/*
	 * 功能： 文件上传
	 */
	private List<File> file;// 对应jsp中file标签
	private List<String> fileFileName;//
	private List<String> fileContentType;//


	
	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String uploadFile() throws IOException {

		InputStream inputStream;
		File destFile;
		OutputStream os;
		for (int i = 0; i < file.size(); i++) {
			inputStream = new FileInputStream(file.get(i));
			destFile = new File(uploadFilePath, this.getFileFileName().get(i));
			os = new FileOutputStream(destFile);
			byte[] buffer = new byte[400];
			int length = 0;
			while ((length = inputStream.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			inputStream.close();
			os.close();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("fileName", fileFileName);
		return SUCCESS;
	}

	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

}
