package com.liyi.web;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/9 23:22  星期三
 */
public class ImgCodeServlet extends HttpServlet {
    public final static String SESSION_IMG_CODE = "SESSION_IMG_CODE";
    private String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private int length = 4;
    private Random r = new Random();
    private boolean randomLocation = true;
    @Override
    public void init(){
        ServletConfig config = getServletConfig();
        String str1 = config.getInitParameter("str");
        if(str1!=null){
            this.str = str1;
        }
        String length = config.getInitParameter("length");
        if(length!=null){
            this.length = Integer.parseInt(length);
        }
    }
    //生成验证码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.拿到当前session
        HttpSession session = req.getSession();
        //2.在后台生成验证码 文本信息
        String code = createCode(length);
        //3.把验证码 存储到session当中
        session.setAttribute(SESSION_IMG_CODE,code);
        //4。 可以调用 运营商接口 发送短信把验证码发出去
        //  生成验证码图片  或者后台打印一下
        System.out.println("当前会话"+session.getId()+" 生成的验证码 = "+code);
        //生成验证码图片  实际上就是文件下载
        //在内存里面创建一张图片
        BufferedImage bi = new BufferedImage(100, 30, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bi.getGraphics();//画笔
        //绘制背景
        graphics.setColor(new Color(128, 128, 128));//灰色
        graphics.fillRect(0,0,100,30);

        //写文字
        int fsize=24;//字体大小为图片高度的80%
        int fx=0;
        int fy=fsize;
        graphics.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,fsize));



        //写字符
       for(int i=0;i<code.length();i++) {
           fy = randomLocation ? (int) ((Math.random() * 0.3 + 0.6) * 30) : fy;//每个字符高低是否随机
           graphics.setColor(Color.red);
           graphics.drawString(code.charAt(i) + "", fx, fy);
           fx += (100 / code.length()) * (Math.random() * 0.3 + 0.8); //依据宽度浮动
       }
       graphics.dispose();
        //得到了一张图片
        //服务器告诉浏览器 这是图片 直接显示出来
        resp.setContentType("image/png");
        //resp.setHeader("Content-Disposition","inline;");

        //将图片返回给浏览器
        ImageIO.write(bi , "png" , resp.getOutputStream());



    }

    //生成后端用的真实验证码
    private String createCode(int n){
        char[] chars = str.toCharArray();
        String res = "";
        for (int i = 0; i < n; i++) {
            res += chars[r.nextInt(str.length())];
        }
        return res;
    }




}
