package designPatterns;

public class DecoratorPattern {
	public static void main(String[] args) {
		Man man = new Man();
		ManDecoratorA manDecorator1 = new ManDecoratorA();
		ManDecoratorB manDecorator2 = new ManDecoratorB();
		
		manDecorator1.setPerson(man);
		manDecorator2.setPerson(man);
		
		manDecorator1.eat();
		manDecorator2.eat();
		
	}
}

/**
 * 组件接口
 */
interface Person {
	void eat();
}

/**
 * 具体的组件
 */
class Man implements Person {
	@Override
	public void eat() {
		System.out.println("Man eat");
	}
}

/**
 * 抽象装饰者
 */
abstract class Decorator implements Person {
	protected Person person;

	public void setPerson(Person person) {
		this.person = person;
	}

	public void eat() {
		person.eat();
	}
}

/**
 *具体装饰者A
 */
class ManDecoratorA extends Decorator {
	@Override
	public void eat() {
		super.eat();
		reEat();
		System.out.println("ManDecoratorA 类");
	}

	public void reEat() {
		System.out.println("再吃一顿饭");
	}
}

/**
 * 具体装饰者B
 */
class ManDecoratorB extends Decorator {
	@Override
	public void eat() {
		super.eat();
		System.out.println("========");
		System.out.println("ManDecoratorB 类");
	}
}


