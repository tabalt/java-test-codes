package language.usage.clazz;

import java.lang.reflect.Method;

public class ClassMethodsExample {
	public static void main(String[] args) {
		Class<?> clazz = String.class; // 要打印方法的类

		Method[] methods = clazz.getDeclaredMethods();

		System.out.println("Methods of class " + clazz.getName() + ":");
		for (Method method : methods) {
			System.out.println(method.toString());
		}

		String methodsString = "Methods of class " + clazz.getName() + ":\n";
		for (Method method : methods) {
			String methodName = method.toString();
			if (methodName != null && methodName.contains("getIsDeterministic")) {
				methodsString += methodName + "\n";
			}
		}
		System.out.println(methodsString);
	}
}