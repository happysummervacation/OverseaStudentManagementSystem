package com.osms.action;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.osms.globle.Constants;


public class CodeAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String codeNumbers="";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("执行CodeAction方法");
		//图片类型
		response.setContentType("image/gif");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		BufferedImage image=new BufferedImage(Constants.IMAGE_WIDTH,Constants.IMAGE_HEIGHT,BufferedImage.TYPE_INT_BGR);
		
		//获取绘制对象
		Graphics2D g=(Graphics2D) image.getGraphics();
		//绘制图片背景颜色
		g.setColor(createRandomColor(200,300));
		//填充
		g.fillRect(0, 0, Constants.IMAGE_WIDTH, Constants.IMAGE_HEIGHT);
		
		//绘制字符
		for(int i=0;i<4;i++)
		{
			drawString(g, i);
		}
		
		//绘制干扰线
		drawNoiseLine(g, 5);
		
		//存储验证码
		saveCodeInSession(request);
		
		this.codeNumbers="";
		//输出
		ServletOutputStream sos=response.getOutputStream();
		ImageIO.write(image, "GIF", sos);
		sos.close();
	}
	
	/**
	 * 绘制图片背景颜色
	 * @param bcf 最小值
	 * @param bcl 最大值
	 * @return color
	 */
	private Color createRandomColor(int bcf, int bcl)
	{
		boolean flag=true;
		int r=0,g=0,b=0;
		while(flag)
		{
			r=bcf+new Random().nextInt(bcl-bcf);
			g=bcf+new Random().nextInt(bcl-bcf);
			b=bcf+new Random().nextInt(bcl-bcf);
			if((r>=0&&r<=255)&&(g>=0&&g<=255)&&(b>=0&&b<=255))
			{
				flag=false;
			}
		}
		return new Color(r,g,b);
	}


	/**
	 * 绘制字符
	 * @param g 图层
	 * @param i 第i位字符
	 */
	private void drawString(Graphics2D g,int i)
	{
		int j=new Random().nextInt(Constants.IMAGE_CHAR.length());
		String codeNumber=Constants.IMAGE_CHAR.substring(j, j+1);
		g.setColor(Constants.color[new Random().nextInt(Constants.color.length)]);
		g.setFont(Constants.codeFont[new Random().nextInt(Constants.color.length)]);
		g.drawString(codeNumber, 15*i+20, 30);
		this.codeNumbers+=codeNumber;
	}
	
	/**
	 * 绘制干扰线
	 * @param g 图层
	 * @param NoiseLineNumbers 数量
	 */
	private void drawNoiseLine(Graphics2D g,int NoiseLineNumbers) 
	{
		for(int i=0;i<NoiseLineNumbers;i++)
		{
			int x1=(int) (1+(Math.random()*120));
			int y1=(int) (1+(Math.random()*40));
			int x2=(int) (1+(Math.random()*120));
			int y2=(int) (1+(Math.random()*40));
			g.setStroke(new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL));
			g.drawLine(x1, y1, x2, y2);
		}
	}

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}
	
	/**
	 * 保存验证码字符串
	 * @param request
	 */
	private void saveCodeInSession(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		// 将之前的验证码移除，把新的验证码内容保存进session中
		session.setAttribute(Constants.CHECK_NUMBER_NAME, codeNumbers);
	}
}
