package com.geek.yx.core;

import javax.servlet.ServletContextEvent;

import com.geek.yx.common.core.listener.ServerListener;

public class SnsServerListener extends ServerListener {
	/**
	 * 复写父类的initilalize方法
	 */
	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {

		// 获取Spring context 上下文方法
		// WebApplicationContext context =
		// ContextLoader.getCurrentWebApplicationContext();
		logger.info("=================================");
		logger.info("系统[{}]启动完成!!!", contextEvent.getServletContext().getServletContextName());
		logger.info("=================================");
		// super.contextInitialized(contextEvent);
	}
}