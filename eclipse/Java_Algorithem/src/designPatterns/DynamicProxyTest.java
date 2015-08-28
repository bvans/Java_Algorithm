package designPatterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

	public static void main(String[] args) {
		DynamicProxy proxy = new DynamicProxy();
		IHello hello = (IHello) proxy.bind(new Hello());
		hello.sayHello();
	}
}

interface IHello {
	void sayHello();
}

class Hello implements IHello {
	@Override
	public void sayHello() {
		System.out.println("hello world");
	}
}

// 将一个实例与一个动态代理类绑定,得到一个接口,
class DynamicProxy implements InvocationHandler {
	Object originalObj;

	Object bind(Object originalObj) {
		this.originalObj = originalObj;

		return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),
				originalObj.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("welcome");
		return method.invoke(originalObj, args);

	}

}