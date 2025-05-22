package language.usage.clazz;


class Parent {
	static int staticValue = 0;

	public void updateStaticValue(int value) {
		staticValue = value;
	}
}

class Child extends Parent {
}

public class StaticVariable {
	public static void main(String[] args) {
		Parent parent = new Parent();
		Child child = new Child();

		// 修改父类的静态属性
		Parent.staticValue = 5;
		System.out.println("Parent staticValue: " + Parent.staticValue); // 输出 5
		System.out.println("Child staticValue: " + Child.staticValue);   // 仍然输出 5

		// 修改子类的静态属性
		Child.staticValue = 10;
		System.out.println("Parent staticValue: " + parent.staticValue); // 输出 10
		System.out.println("Child staticValue: " + parent.staticValue);   // 输出 10

		// 修改父类的静态属性
		parent.updateStaticValue(15);
		System.out.println("Parent staticValue: " + parent.staticValue); // 输出 15
		System.out.println("Child staticValue: " + parent.staticValue);   // 仍然输出 15

		// 通过方法修改子类的静态属性
		parent.updateStaticValue(20);
		System.out.println("Parent staticValue: " + parent.staticValue); // 输出 20
		System.out.println("Child staticValue: " + parent.staticValue);   // 输出 20
	}
}