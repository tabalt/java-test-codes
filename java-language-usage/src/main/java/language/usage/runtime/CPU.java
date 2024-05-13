package language.usage.runtime;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;

public class CPU {

	public static void main(String[] args) {
		System.out.println("Runtime availableProcessors: " + Runtime.getRuntime().availableProcessors());
	}

}
