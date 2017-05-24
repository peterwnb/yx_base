package com.farsunset.cim.api.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.farsunset.cim.model.Friend;
import com.farsunset.cim.push.SystemMessagePusher;
import com.farsunset.cim.sdk.server.constant.CIMConstant;
import com.farsunset.cim.sdk.server.model.Message;
import com.farsunset.cim.sdk.server.session.CIMSession;
import com.farsunset.cim.sdk.server.session.DefaultSessionManager;
import com.farsunset.cim.util.Constants;
import com.farsunset.cim.util.ContextHolder;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户模块，包括获取用户信息，好友列表，头像等等
 * @author lenovo
 *
 */
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = -3123529560279939517L;
	
	/**
	 * 获取在线用户列表
	 * @throws IOException
	 */
	public void list() throws IOException {

		String account = ServletActionContext.getRequest().getParameter("account");
		Message msg = new Message();
		msg.setAction(CIMConstant.MessageAction.ACTION_999);// 强行下线消息类型
		msg.setReceiver(account);
		
		List<CIMSession> sessionList = ((DefaultSessionManager) ContextHolder.getBean("CIMSessionManager")).queryAll();

		// 向客户端 发送消息
		ContextHolder.getBean(SystemMessagePusher.class).push(msg);
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		//JSON在传递过程中是普通字符串形式传递的，这里简单拼接一个做测试
		List<Friend> fList = new ArrayList<>();
		int t =1;
		for(CIMSession c : sessionList){
			Friend i = new Friend();
			i.setAccount(c.getAccount());
			i.setChannel(c.getChannel());
			i.setHost(c.getHost());
			i.setStatus(c.getStatus());
			i.setGender(t%2);
			i.setAvatar(Constants.UserAvatar.AVATAR_LIST[new Random().nextInt(4)]);
			fList.add(i);
		}
		Gson goson = new Gson();
		String json = goson.toJson(fList);
		System.out.println(json);
		out.println(json);
		out.flush();
		out.close();
	}

}
