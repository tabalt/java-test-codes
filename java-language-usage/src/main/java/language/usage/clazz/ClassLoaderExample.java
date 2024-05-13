package language.usage.clazz;

import com.google.common.cache.CacheBuilder;

public class ClassLoaderExample {
	public static void main(String[] args) {
		Class<?> clazz = CacheBuilder.class; // 要打印的类

		ClassLoader classLoader = clazz.getClassLoader();
		String classLocation = classLoader.getResource(clazz.getName().replace('.', '/') + ".class").toString();

		System.out.println("Class is loaded by: " + classLoader);
		System.out.println("Class location: " + classLocation);
	}
}