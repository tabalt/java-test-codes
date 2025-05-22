package algorithm.str;

public class ReverseWordsInSentence {

	public static void main(String[] args) {
		String sentence = "Hello World This Is Java";
		String reversedSentence = reverseWords(sentence);
		System.out.println(reversedSentence);
	}

	public static String reverseWords(String sentence) {
		StringBuilder reversed = new StringBuilder();
		StringBuilder word = new StringBuilder();

		// 遍历句子的每个字符
		for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);

			// 如果当前字符是空格，表示一个单词结束
			if (c == ' ') {
				// 先加上当前单词再加上空格
				if (word.length() > 0) {
					reversed.insert(0, " " + word.toString());
//					reversed.insert(0, word.toString() + " ");
					word.setLength(0); // 清空当前单词
				}
			} else {
				word.append(c); // 继续构建当前单词
			}
		}

		// 添加最后一个单词（如果存在）
		if (word.length() > 0) {
			reversed.insert(0, word.toString());
		}

		return reversed.toString().trim(); // 去掉最后的空格
//		return reversed.toString(); // 去掉最后的空格
	}
}
