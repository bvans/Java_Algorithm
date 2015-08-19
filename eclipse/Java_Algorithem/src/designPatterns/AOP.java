package designPatterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AOP {
	public static void main(String[] args) {
		StudentInfoService studentInfo = (StudentInfoService) AOPFacotry
				.getAOPProxyObject("designPatterns.StudentInfoServiceImpl");
		studentInfo.findInfo("阿飞");
		String s;
	}
}

/**
 * 业务接口
 */
interface StudentInfoService {
	void findInfo(String studentName);
}

/**
 * 业务实现类
 */
class StudentInfoServiceImpl implements StudentInfoService {

	@Override
	public void findInfo(String studentName) {
		System.out.println("您目前输入的名字是:" + studentName);
	}

}

/**
 * 处理拦截目的的类
 */
class MyHandler implements InvocationHandler {
	private Object proxyObj;

	public Object bind(Object obj) {
		this.proxyObj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		System.out.println("日志:调用了" + method.getName() + "方法");
		result = method.invoke(proxyObj, args);
		return result;
	}

}

/**
 * 我们实现一个工厂，为了方便我们使用该拦截类
 */
class AOPFacotry {
	private static Object getClassInstance(String clzName) {
		Object obj = null;
		try {
			Class clazz = Class.forName(clzName);
			obj = clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static Object getAOPProxyObject(String clzName) {
		Object proxy = null;
		MyHandler handler = new MyHandler();
		Object obj = getClassInstance(clzName);
		if (obj != null) {
			proxy = handler.bind(obj);
		} else {
			System.out.println("cannot get the proxyObj");
		}

		return proxy;
	}
}
