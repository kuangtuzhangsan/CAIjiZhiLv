public class tempTest {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcadaertyui"));
    }
    // chatgpt
    /**
     * 使用两个指针，分别表示滑动窗口的起始位置和结束位置。初始时，两个指针都指向字符串的开头。
     * 移动右指针，直到找到重复字符或者到达字符串末尾。
     * 更新最长子串的长度。
     * 移动左指针，缩小窗口，直到窗口中再次没有重复字符。
     * 重复步骤2到步骤4，直到右指针到达字符串末尾。
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[256]; // 用于存储字符的最后出现位置

        for (int right = 0, left = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            left = Math.max(charIndex[currentChar], left);
            System.out.println(charIndex[currentChar]);
            System.out.println(left);
            System.out.println(right);

            // 更新最长子串的长度
            maxLength = Math.max(maxLength, right - left + 1);
            System.out.println("长度"+maxLength);

            // 记录字符的最后出现位置
            charIndex[currentChar] = right + 1;

            // 输出charIndex数组
            System.out.print("charIndex: ");
            for (int i = 0; i < charIndex.length; i++) {
                System.out.print(charIndex[i] + " ");
            }
            System.out.println();
        }

        return maxLength;
    }
}
