package com.qq.tars.quickstart.server.testapp.impl;


import com.qq.tars.quickstart.server.testapp.HelloServant;

import java.net.URL;

public class HelloServantImpl implements HelloServant {

    public String hello(int no, String name) {
    	String str = "aaa";
    	System.out.println(str);
        return String.format("hello, this is server! no=%s, name=%s, time=%s", no, name, System.currentTimeMillis());
    }
    
    
    public static void main(String[] args) {
    	HelloServantImpl impl = new HelloServantImpl();
    	impl.fn3();
	}
    
    public void fn1() {
    	String str1 = getClass().getResource("/").getPath();
    	//String str2 = getClass().getClassLoader().getResource("/").getPath();
    	System.out.println(str1);
    	//System.out.println(str2);
    }

    public void fn2(){
			        ClassLoader classLoader = HelloServantImpl.class.getClassLoader();
			        System.out.println(classLoader);

			        ClassLoader classLoader1 = classLoader.getParent();
			        System.out.println(classLoader1);

			        ClassLoader classLoader2 = classLoader1.getParent();
			         System.out.println(classLoader2);

	}

	public void fn3(){
        URL u1 = HelloServantImpl.class.getResource("");
        System.out.println(u1);
        URL u2 = HelloServantImpl.class.getClassLoader().getResource("");
        System.out.println(u2);
        URL u3 = HelloServantImpl.class.getClass().getResource("");
        System.out.println(u3);

    }
}
