package com.zhonghui.framework.websocket;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;


@Component
@ServerEndpoint("/websocket/{userId}")
public class MessageController {

    //与某个客户端的连接会话，需要用来发送数据
    private Session session;

    //concurrent线程安全set,存放每个客户端对应的websocket对象
    private static CopyOnWriteArraySet<MessageController> messageControllers = new CopyOnWriteArraySet<>();

    //存储session池
    private static Map<String,Session> sessionPool = new HashMap<String,Session>();

    /**
     * 链接成功调用
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "userId")String userId){
        try{
            //session获取
            this.session = session;
            //静态存储的websocket长链接集合中，添加本次调用成功所创建的这个实体
            messageControllers.add(this);
            //session缓存池添加用户的用户ID和对应的session
            sessionPool.put(userId,session);
            //将用户加入链接和当前连接数的消息广播给当前所有已连接的用户
            sendAllMessage("【" + userId +"】加入链接，当前连接数：" + messageControllers.size());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 链接关闭调用
     */
    @OnClose
    public void onClose(){
        try{
            //已连接的对象列表中移除当前调用此关闭方法的对象
            messageControllers.remove(this);
            //将用户断开链接和链接总数信息推送给现在还链接着的用户
            System.out.println("用户断开链接,当前链接总数为：" + messageControllers.size());
        }catch (Exception e){

        }
    }

    /**
     * 收到客户端消息
     */
    @OnMessage
    public void onMessage(String message){
        //收到客户端消息后可以根据实际需求做一些处理操作，也可以直接返回，到页面进行处理
        //广播给群中现在处理已连接状态的所有用户
        JSONObject messageObject = JSONObject.parseObject(message);
        String userId = (String)messageObject.get("userId");
        String websocketMessage = (String)messageObject.get("message");

        sendOneMessage(userId,websocketMessage);

    }

    /**
     * 发送错误处理
     */
    @OnError
    public void onError(Session session,Throwable error){
        //输出错误信息
        System.out.println("【发送错误】：" + error.getMessage());
        error.printStackTrace();
    }

    /**
     * 广播(全体)消息
     */
    public void sendAllMessage(String message){
        //遍历当前所有已连接的用户，循环发送
        for(MessageController messageController : messageControllers){
            try{
                //session处于打开状态，则发送消息
                if(messageController.session.isOpen()){
                    //最好是使用这个getAsyncRemote，另一个（getBasicRemote）在多个线程同时进行时容易报错，这两个是异步和同步的区别
                    messageController.session.getAsyncRemote().sendText(message);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 单点消息
     */
    public void sendOneMessage(String userId,String message){
        //根据userId获取到对应的session
        Session session = sessionPool.get(userId);
        //这个session不为空并且还在开放状态
        if(session != null && session.isOpen()){
            try{
                //将消息单独推送到这个userId对应的session里
                session.getAsyncRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 多点消息（多选发给一部分人）
     */
    public void sendManyMessage(String[] userIds,String message){
        //遍历参数中的用户id数组，进行多个推送，介于单个和广播（全体）之间的部分发送
        for(String userId:userIds){
            Session session = sessionPool.get(userId);
            if(session != null && session.isOpen()){
                try{
                    session.getAsyncRemote().sendText(message);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

}