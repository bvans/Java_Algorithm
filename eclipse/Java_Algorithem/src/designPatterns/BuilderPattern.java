package designPatterns;

public class BuilderPattern {

	public static void main(String[] args) {
		HumanDirector director = new HumanDirector();
		Human man = director.buildHuman(new ManBuilder());
		System.out.println(man.getBody());
		System.out.println(man.getHead());
	}

}

/**
 * 具体的产品
 */
class Human {
	private String head;
	private String body;

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}

/**
 * 特定的产品
 */
class Mans extends Human {

}

/**
 * 建造者接口
 */
interface HumanBuilder {
	void buildHead();

	void buildBody();

	Human buildHuman();
}

/**
 * 建造者实现类, 通过传入一个特定的产品建造器来构建.
 */
class ManBuilder implements HumanBuilder {
	Human human;

	ManBuilder() {
		human = new Human();
	}

	@Override
	public Human buildHuman() {
		return human;
	}

	@Override
	public void buildHead() {
		human.setBody("男人的头部");
	}

	@Override
	public void buildBody() {
		human.setHead("男人的身体");
	}

}

/**
 * 建造者的主管
 */
class HumanDirector {
	public Human buildHuman(HumanBuilder builder) {
		builder.buildBody();
		builder.buildHead();
		return builder.buildHuman();
	}
}