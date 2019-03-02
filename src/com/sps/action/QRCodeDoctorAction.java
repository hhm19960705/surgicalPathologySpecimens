package com.sps.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.mail.internet.InternetAddress;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sps.util.QRUtil;
/**
 * 验证码Action
 *
 */
@SuppressWarnings("serial")
public class QRCodeDoctorAction extends ActionSupport{
	public String execute() throws Exception{
		InetAddress localHost = InetAddress.getLocalHost() ;
		String hostAddress = localHost.getHostAddress() ;
		String url ="http://"+hostAddress+":8080/surgicalPathologySpecimens/history_detailsUI.action?id=" + ServletActionContext.getRequest().getParameter("id");
		QRUtil.createQrCode(ServletActionContext.getResponse().getOutputStream(), url, 1800, "JPEG")  ;
		return NONE;
	}
	/**
	 * 取其某一范围的color
	 * 
	 * @param fc
	 *            int 范围参数1
	 * @param bc
	 *            int 范围参数2
	 * @return Color
	 */
	private Color getRandColor(int fc, int bc) {
		// 取其随机颜色
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
 
}

