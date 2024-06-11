package com.ruoyi.chat.socket;

import  org.java_websocket.client.WebSocketClient;
import  org.java_websocket.handshake.ServerHandshake;
import  java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: jason
 * @Date: 7/6/2024 15:37
 * @Description:
 */
public  class  MyWebSocketClient  extends  WebSocketClient  {

    public  MyWebSocketClient(URI  serverUri)  {
        super(serverUri);
    }

    @Override
    public  void  onOpen(ServerHandshake  data)  {
        System.out.println("WebSocket连接已打开。");
    }

    @Override
    public  void  onMessage(String  message)  {
        System.out.println("收到消息:  "  +  message);
    }

    @Override
    public  void  onClose(int  code,  String  reason,  boolean  remote)  {
        System.out.println("WebSocket连接已关闭。");
    }

    @Override
    public  void  onError(Exception  ex)  {
        System.err.println("WebSocket连接发生错误："  +  ex.getMessage());
    }
    public  static  void  main(String[]  args)  throws URISyntaxException {
        URI  uri  =  new  URI("ws://localhost:8080/chat/im");
        MyWebSocketClient  myWebSocketClient  =  new  MyWebSocketClient(uri);
        myWebSocketClient.connect();
        //  启动定时检查
    }

}