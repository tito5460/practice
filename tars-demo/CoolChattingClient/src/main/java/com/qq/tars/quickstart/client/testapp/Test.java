package com.qq.tars.quickstart.client.testapp;

import com.qq.tars.client.Communicator;
import com.qq.tars.client.CommunicatorConfig;
import com.qq.tars.client.CommunicatorFactory;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		t.fn1();
	}

	public void fn1() {

		HelloPrx proxy = this.createProxy(9);
		try {
			String ret = proxy.hello(1000, "客户端");
			System.out.println(ret);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}finally {
			System.exit(0);
		}
		

		// // 异步调用
		// proxy.async_hello(new HelloPrxCallback() {
		//
		// @Override
		// public void callback_expired() {
		// }
		//
		// @Override
		// public void callback_exception(Throwable ex) {
		// }
		//
		// @Override
		// public void callback_hello(String ret) {
		// System.out.println(ret);
		// }
		// }, 1000, "客户端 async");

		// try {
		// Thread.sleep(5 * 1000L);
		// System.exit(2);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	private HelloPrx createProxy(int type) {
		CommunicatorConfig cfg = new CommunicatorConfig();
		cfg.setSyncInvokeTimeout(300 * 1000);
		if (type == 1) {
			cfg.setLocator("tars.tarsregistry.QueryObj@tcp -h 192.168.0.148 -p 7777 -t 60000");
			// 构建通信器
			Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
			// 通过通信器，生成代理对象.
			return communicator.stringToProxy(HelloPrx.class, "CoolChattingApp.CoolChattingServer.CoolChattingObj");
		} else if (type == 2) {
			// 构建通信器
			Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
			// 通过通信器，生成代理对象.
			return communicator.stringToProxy(HelloPrx.class,
					"tars.tarsregistry.QueryObj@tcp -h 192.168.0.148 -p 7777 -t 60000");
		} else if (type == 3) {
			cfg.setLocator("CoolChattingApp.CoolChattingServer.CoolChattingObj@tcp -h 192.168.0.148 -p 7777 -t 60000");
			// 构建通信器
			Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
			// 通过通信器，生成代理对象.
			return communicator.stringToProxy(HelloPrx.class, "CoolChattingApp.CoolChattingServer.CoolChattingObj");
		} else {
			// 构建通信器
			Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
			// 通过通信器，生成代理对象.
			return communicator.stringToProxy(HelloPrx.class,
					"CoolChattingApp.CoolChattingServer.CoolChattingObj@tcp -h 192.168.0.148 -p 7777 -t 60000");
		}
	}

}
