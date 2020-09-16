package com.yc.wzq;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class MyClient {
    public static boolean gameover=true;
    public static void main(String[] args) throws IOException {
        ChessBroad chessBroad=new ChessBroad();
        Socket socket = new Socket("127.0.0.1", 8000);
        OutputStream ou=socket.getOutputStream();
        InputStream in =socket.getInputStream();
        Scanner scanner=new Scanner(System.in);
        while(true){
            if(ChessBroad.broad[0][0]==null){
                ChessBroad.init();
                ChessBroad.draw();
            }

            System.out.println("等待对方落子");
            byte[] buf=new byte[1024];
            int len=in.read(buf);
            String creceive=new String(buf,0,len);
            System.out.println("获得黑棋坐标："+creceive);
            ChessBroad.iswhite=false;
            MyGame.list.add(creceive);
            String []ss=creceive.split(",");
            int x=new Integer(ss[0]);
            int y=new Integer(ss[1]);
            ChessBroad.broad[x][y]=ChessBroad.iswhite ? "○":"●";
            ChessBroad.draw();
            if(!MyGame.isover(x, y)){
                break;
            }


            System.out.println("请输入坐标:x,y");
            String line= scanner.next();
            while(true){
                if(!MyGame.list.contains(line)){
                    MyGame.list.add(line);
                    break;
                }else{
                    System.out.println("已存在旗子");
                    line=scanner.next();
                }
            }
            ou.write(line.getBytes());
            MyGame.list.add(line);
            ChessBroad.iswhite=true;
            ss=line.split(",");
            x=new Integer(ss[0]);
            y=new Integer(ss[1]);
            ChessBroad.broad[x][y]=ChessBroad.iswhite ? "○":"●";
            ChessBroad.draw();
            gameover=MyGame.isover(x, y);


        }

    }

}
