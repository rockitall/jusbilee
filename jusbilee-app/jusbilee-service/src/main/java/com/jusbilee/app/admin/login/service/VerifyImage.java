package com.jusbilee.app.admin.login.service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


/**
 * Created by zhandc on 2016/8/3.
 */
public class VerifyImage {

    private int width = 80;// 图片宽
    private int height = 20;// 图片高
    private int lineSize = 10;// 干扰线数量
    private int stringNum = 5;// 随机产生字符数量
    private Random random = new Random();

    /**
     * 验证码的字符集
     */
    private static final char[] codes = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9'};

    /**
     * 随机生成指定字符个数的字符串
     *
     * @param _width 字符个数
     * @return 随机字符串
     */
    public String ramdomCodes() {
        int width = stringNum <= 0 ? 4 : stringNum;
        char[] ret = new char[width];
        Random ran = new Random();
        int length = codes.length;
        for (int i = 0; i < width; i++) {
            int intValue = ran.nextInt(length) % length;
            ret[i] = codes[intValue];
        }
        return new String(ret);
    }

    public BufferedImage getImage(String code) {
        // BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();// 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
        g.fillRect(0, 0, width, height);

        g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
        g.setColor(getRandColor(110, 133));
        // 绘制干扰线
        for (int i = 0; i <= lineSize; i++) {
            drowLine(g);
        }
        // 绘制随机字符
        drowString(g, code);
        g.dispose();
        return image;
    }


    /*
     * 绘制字符串
     */
    private void drowString(Graphics g, String randomString) {
        char[] strings = randomString.toCharArray();
        for (int i = 0; i < strings.length; i++) {
            g.setFont(getFont());
            g.setColor(new Color(random.nextInt(101), random.nextInt(111), random
                    .nextInt(121)));
            g.translate(random.nextInt(3), random.nextInt(3));
            g.drawString(String.valueOf(strings[i]), 13 * i, 16);
        }

    }


    /*
     * 获得字体
     */
    private Font getFont() {
        return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
    }

    /*
     * 获得颜色
     */
    private Color getRandColor(int fc, int bc) {
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    /*
     * 绘制干扰线
     */
    private void drowLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }


}
