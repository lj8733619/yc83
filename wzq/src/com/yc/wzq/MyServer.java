package com.yc.wzq;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class MyServer {
    public ArrayList list=new ArrayList();
    
    public static boolean gameover=true;

    public static void main(String[] args) throws IOException  {
       ChessBroad chessBroad=new ChessBroad();
       ServerSocket server = new ServerSocket(8000);
       Socket client= server.accept();
       System.out.println("连接成功");
       InetAddress address=client.getInetAddress();
       System.out.println(address.getHostAddress());

       InputStream in= client.getInputStream();
       OutputStream ou=client.getOutputStream();
       Scanner sc=new Scanner(System.in);
       while(true){
           if(ChessBroad.broad[0][0]==null){
               ChessBroad.init();
               ChessBroad.draw();
           }
           System.out.println("请输入坐标:x,y");
           String send=sc.next();
           while(true){
               if(!MyGame.list.contains(send)){
                   MyGame.list.add(send);
                   break;
               }else{
                   System.out.println("已存在旗子");
                   send=sc.next();
               }
           }

           ou.write(send.getBytes());
           MyGame.list.add(send);
           ChessBroad.iswhite=false;
           String []ss=send.split(",");
           int x=new Integer(ss[0]);
           int y=new Integer(ss[1]);
           ChessBroad.broad[x][y]=ChessBroad.iswhite ? "○":"●";
           System.out.println(chessBroad.iswhite);
           ChessBroad.draw();
           if(!MyGame.isover(x, y)){
              break;
           }
           System.out.println("等待对方落子");
           byte []buf=new byte[1024];
           int len =in.read(buf);
           String receive=new String(buf,0,len);
           System.out.println("白棋坐标："+receive);
           ChessBroad.iswhite=true;
           MyGame.list.add(receive);
           ss=receive.split(",");
           x=new Integer(ss[0]);
           y=new Integer(ss[1]);
           ChessBroad.broad[x][y]=ChessBroad.iswhite ? "○":"●";
           ChessBroad.draw();
           gameover=MyGame.isover(x, y);

       }

   }
}