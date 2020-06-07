package com.bee.airsystem.controller;

import com.bee.airsystem.utils.Captcha;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author 12579
 */
@WebServlet("/captcha")
public class CaptchaController extends HttpServlet {

    private final static int IMG_WIDTH = 100;
    private final static int IMG_HEIGHT = 50;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Captcha c = new Captcha(IMG_WIDTH, IMG_HEIGHT);
        BufferedImage img = c.getCaptchaImage(4);
        String captchaText = c.getCaptchaText();
        System.out.println("验证码：" + captchaText);

        req.getSession().setAttribute("code", captchaText);

        ServletOutputStream os = resp.getOutputStream();

        ImageIO.write(img, "JPEG", os);

        try {
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            os.flush();
            os.close();
        }

    }


}