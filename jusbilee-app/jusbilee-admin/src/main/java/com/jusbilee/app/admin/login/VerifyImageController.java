/**
 * zhandc 2016年8月3日
 */
package com.jusbilee.app.admin.login;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jusbilee.app.admin.login.service.VerifyImage;

/**
 * @author zhandc 2016年8月3日
 *
 */

@Controller
@RequestMapping("/login")
public class VerifyImageController{
	
	private static final String VERIFY_CODE = "verifyCode_sesion";
	
	@RequestMapping("/getImage")
    public  void getImage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		VerifyImage verifyImage = new VerifyImage();
		String code = verifyImage.ramdomCodes();
		BufferedImage image = verifyImage.getImage(code);
		
		
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());// 将内存中的图片通过流动形式输出到客户端
			
			session.removeAttribute(VERIFY_CODE);
			session.setAttribute(VERIFY_CODE, code.toUpperCase());
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return ok(verifyCode);
    }

	
}
