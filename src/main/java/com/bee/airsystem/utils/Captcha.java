package com.bee.airsystem.utils;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author Bee
 * <p>验证码生成工具类</p>
 */
public class Captcha {

    private Random mRandom = new Random();

    /**
     * 随机字体字体
     */
    private String[] mFont = {"宋体", "楷体", "黑体", "微软雅黑", "仿宋"};
    /**
     * 验证码文本
     */
    private String mCaptchaText = "";
    /**
     * 验证码图形宽度
     */
    private int mImgWidth;
    /**
     * 验证码图形高度
     */
    private int mImgHeight;

    public String getCaptchaText() {
        return mCaptchaText.toLowerCase();
    }

    public Captcha(int imgWidth, int imgHeight) {
        this.mImgWidth = imgWidth;
        this.mImgHeight = imgHeight;
    }

    /**
     * 获取随机字符
     *
     * @param length 长度
     * @return 随机结果
     */
    public String getRandomChars(int length) {
        int maxLength = 20;
        if (length < 1 || length > maxLength) {
            length = 4;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String mCodes = "qwertyuipasdfghjklxcvbnm1234567890QWERTYUPASDFGHJKLZXCVBNM";
            sb.append(mCodes.charAt(mRandom.nextInt(mCodes.length())));
        }
        return sb.toString();
    }

    /**
     * 绘制干扰线
     *
     * @param g     图形
     * @param level 干扰线等级
     */
    public void drawInterferingLind(Graphics g, int level) {
        for (int i = 0; i < level; i++) {
            int x = mRandom.nextInt(mImgWidth);
            int y = mRandom.nextInt(mImgHeight);
            int x1 = mRandom.nextInt(mImgWidth);
            int y1 = mRandom.nextInt(mImgHeight);
            g.setColor(getRandomColor());
            g.drawLine(x, y, x1, y1);
        }
    }

    /**
     * 获取随机颜色
     *
     * @return 返回随机颜色
     */
    private Color getRandomColor() {
        return new Color(mRandom.nextInt(255), mRandom.nextInt(255), mRandom.nextInt(255));
    }

    /**
     * 获取随机颜色 深色系列 用于文本显示
     *
     * @return 返回文本颜色
     */
    private Color getDarkColor() {
        return new Color(mRandom.nextInt(115), mRandom.nextInt(115), mRandom.nextInt(115));
    }

    /**
     * 获取 BufferedImage
     *
     * @return BufferedImage
     */
    private BufferedImage getImg() {
        //创建一个BufferedImage对象
        BufferedImage img = new BufferedImage(mImgWidth, mImgHeight, BufferedImage.TYPE_INT_BGR);
        Graphics g = img.getGraphics();
        //绘制背景
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
        return img;
    }

    /**
     * 绘制验证码文本
     *
     * @param g          画板
     * @param textLength 验证码长度
     */
    private void drawCaptchaText(Graphics g, int textLength) {
        //获取文本
        String randomChars = getRandomChars(textLength);
        mCaptchaText = randomChars;
        //设置文本颜色
        g.setColor(getDarkColor());
        for (int i = 0; i < textLength; i++) {
            //设置随机字体风格
            Font font = getRandomFontStyle();
            /*
            首尾2个字符不进行旋转 如果旋转 可能会只出现半个字符 另一半旋转到边缘去了
             */
            if (!(i == 0 || i == textLength - 1)) {
                //设置随机旋转角度  在 -35~35°区间
                double angle = Math.toRadians(mRandom.nextInt(70) - 35);
                //创建一个2D可旋转字体对象
                AffineTransform affineTransform = new AffineTransform();
                //设置旋转角度
                affineTransform.rotate(angle);
                //替换Font
                font = font.deriveFont(affineTransform);
            }
            g.setFont(font);
            //设置x的坐标 将布局空间分配个字符串加上一点随机偏移量
            int x = mImgWidth / textLength * i + mRandom.nextInt(mImgWidth / 4 / 2);
            //设置y的坐标 在绘制文本以文本底变为y的坐标 设置一个最低高度 以免文本太靠上消失
            int y = mRandom.nextInt(mImgHeight - font.getSize()) + font.getSize();
            g.drawString(String.valueOf(randomChars.charAt(i)), x, y);
        }
    }

    /**
     * 随机字体风格
     *
     * @return 返回随机字体风格
     */
    private Font getRandomFontStyle() {
        //随机字体名称

        String fontName = mFont[mRandom.nextInt(mFont.length)];
        //随机字体大小 初始值为最小26 最大36
        int fontSize = mRandom.nextInt(10) + 35;
        //给出2/3的概率设为字体加粗
        int fontStyle = mRandom.nextInt(3) == 1 ? Font.BOLD : Font.PLAIN;
        return new Font(fontName, fontStyle, fontSize);
    }

    /**
     * 获取验证码图片
     *
     * @return 返回验证码图片
     */
    public BufferedImage getCaptchaImage(int length) {
        BufferedImage img = getImg();
        //获取图形
        Graphics g = img.getGraphics();
        //绘制干扰线 及干扰线等级
        drawInterferingLind(g, 15);
        //绘制文本 及文本个数
        drawCaptchaText(g, length);
        return img;
    }


}
