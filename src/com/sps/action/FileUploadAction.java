package com.sps.action;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Controller
@ParentPackage("json-default")
public class FileUploadAction extends ActionSupport {
	// 上传的文件
	private File videoUpload;
	private File musicUpload;
	private File imageUpload;
	// 上传的文件后缀名
	private String videoUploadFileName;
	private String musicUploadFileName;
	private String imageUploadFileName;
 
	public File getVideoUpload() {
		return videoUpload;
	}
 
	public void setVideoUpload(File videoUpload) {
		this.videoUpload = videoUpload;
	}
 
	public File getMusicUpload() {
		return musicUpload;
	}
 
	public void setMusicUpload(File musicUpload) {
		this.musicUpload = musicUpload;
	}
 
	public File getImageUpload() {
		return imageUpload;
	}
 
	public void setImageUpload(File imageUpload) {
		this.imageUpload = imageUpload;
	}
 
	public String getVideoUploadFileName() {
		return videoUploadFileName;
	}
 
	public void setVideoUploadFileName(String videoUploadFileName) {
		this.videoUploadFileName = videoUploadFileName;
	}
 
	public String getMusicUploadFileName() {
		return musicUploadFileName;
	}
 
	public void setMusicUploadFileName(String musicUploadFileName) {
		this.musicUploadFileName = musicUploadFileName;
	}
 
	public String getImageUploadFileName() {
		return imageUploadFileName;
	}
 
	public void setImageUploadFileName(String imageUploadFileName) {
		this.imageUploadFileName = imageUploadFileName;
	}
 
	/**
	 * 多文件上传
	 * 
	 * @return
	 */
	@Action(value = "uploadAction", results = { @Result(name = "success", type = "json") })
	public String uploadAction() {
		// 定义接受文件的数组
		File[] files = new File[3];
		String[] fileNames = new String[3];
 
		// 定义缓存数组
		byte[] buf = new byte[1024];
 
		// 给数组赋值
		files[0] = videoUpload;
		files[1] = musicUpload;
		files[2] = imageUpload;
		fileNames[0] = videoUploadFileName;
		fileNames[1] = musicUploadFileName;
		fileNames[2] = imageUploadFileName;
 
		// 定义上传文件的新文件名数组
		String[] newName = new String[3];
		// 后缀名数组
		String[] exName = new String[3];
 
		String path = "";
		try {
			for (int i = 0; i < files.length; i++) {
				// 用输入流获取文件的内容信息
				FileInputStream fis = new FileInputStream(files[i]);
				// 获取源文件的后缀名
				exName[i] = FilenameUtils.getExtension(fileNames[i]);
				// 生成新的文件名
				newName[i] = System.currentTimeMillis() + "." + exName[i];
 
				if (exName[i].equals("mp4")) {// 后缀名为mp4格式的视频文件保存路径
					path = ServletActionContext.getServletContext().getRealPath("/upload/video/");
				} else if (exName[i].equals("mp3")) {
					path = ServletActionContext.getServletContext().getRealPath("/upload/music/");
				} else {
					path = ServletActionContext.getServletContext().getRealPath("/upload/image/");
				}
				System.out.println("上传文件的全路径：" + path);
				// 完成新文件的创建
				File file = new File(path);
 
				// 如果文件夹不存在则进行创建
				if (!file.exists()) {
					file.mkdirs();
				}
 
				// 用输出流把文件写到新的路径下
				FileOutputStream fos = new FileOutputStream(path + File.separator + newName[i]);
				System.out.println("文件重新保存的路径:" + path + File.separator + newName[i]);
				// 使用缓冲读取信息并完成文件的保存工作
				int length = fis.read(buf);
				while (length > 0) {// 只要文件还没读完就将文件保存到新的路径下
					fos.write(buf, 0, length);
					length = fis.read(buf);
				}
				// 关闭相应的资源
				fis.close();
				fos.flush();
				fos.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("上传失败!");
 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("上传失败!");
		}
 
		return SUCCESS;
	}
 
}
