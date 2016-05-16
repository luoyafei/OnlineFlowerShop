package com.flowershop.servlet.AdminOperate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.flowershop.bean.Flower;
import com.flowershop.factory.ServiceFactory;

/**
 * Servlet implementation class UploadDeal
 */
@WebServlet("/UploadDeal")
@MultipartConfig
public class UploadDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadDeal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String flowerCategary = request.getParameter("flowerCategary");
		String flowerPicture = String.valueOf(System.currentTimeMillis()) + ".jpg";
		
		Flower flower = new Flower();
		
		flower.setFlowerDescribe(description);
		flower.setFlowePrice(price);
		flower.setFlowerCategary(flowerCategary);
		flower.setFlowerPicture(flowerPicture);
		
		boolean flag = ServiceFactory.createFlowerService().insertFlower(flower);
		
		if(flag) {
			Part part = request.getPart("file");
			if(uploadPicture(part, flowerPicture)) {
System.out.println("上传图片成功！");
			} else {
System.out.println("上传图片出现错误！上传图片失败！");
			}
			response.sendRedirect("/OnlineFlowerShop/pages/amdinUpload/adminUploadFlower.jsp?flag=0");
			return;
		} else {
			response.sendRedirect("/OnlineFlowerShop/pages/amdinUpload/adminUploadFlower.jsp?flag=1");
			return;
		}
		
	}
	
	private boolean uploadPicture(Part part, String flowerPicture) {
		boolean flag = true;
		InputStream  is = null;
		OutputStream os = null;
		try {
			is = part.getInputStream();
			os = new FileOutputStream(new File("G:\\OnlineFlowerShopIMG\\" + flowerPicture));
			
			byte[] bytes = new byte[1024];
			
			int i = is.read(bytes);
			while(i != -1) {
				os.write(bytes, 0, i);
				i = is.read(bytes);
			}
			
		} catch (IOException e) {
			flag = false;
System.out.println("上传花朵图片出现异常！");
			e.printStackTrace();
		} finally {
			try {
				os.flush();
				os.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
