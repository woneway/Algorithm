package kmp;

import java.util.Random;

public class KMP {
    public static void main(String[] args) {
        String source = randomStr(200000000);
        String pattern = randomStr(5);

        int startIndex = 0;
        Long startTime = System.currentTimeMillis();
        int index1 = indexOf(source, pattern, startIndex);
        System.out.println(System.currentTimeMillis() - startTime);


        startTime = System.currentTimeMillis();
        int index2 = kmp(source, pattern, startIndex);
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        int index3 = kmpBetter(source, pattern, startIndex);
        System.out.println(System.currentTimeMillis() - startTime);


        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
        if (index1 != -1) {
            System.out.println(source.substring(index1, pattern.length() + index1));
            System.out.println(source.substring(index1, pattern.length() + index1).equals(pattern));
        }
    }


    public static String randomStr(int length) {
        String source = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < length) {
            builder.append(source.charAt(random.nextInt(26)));
            i++;
        }
        return builder.toString();
    }

    public static int indexOf(String source, String pattern, int startIndex) {
        int i = startIndex, j = 0;
        while (i < source.length() && j < pattern.length()) {
            if (source.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == pattern.length()) return i - j;
        return -1;
    }

    public static int kmp(String source, String pattern, int startIndex) {
        int i = startIndex, j = 0;
        int[] next = getNext(pattern);
        while (i < source.length() && j < pattern.length()) {
            if (j == -1 || source.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pattern.length()) return i - j;
        return -1;
    }

    private static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < pattern.length() - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }


    public static int kmpBetter(String source, String pattern, int startIndex) {
        int i = startIndex, j = 0;
        int[] next = getNextBetter(pattern);
        while (i < source.length() && j < pattern.length()) {
            if (j == -1 || source.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pattern.length()) return i - j;
        return -1;
    }

    private static int[] getNextBetter(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < pattern.length() - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
                if (pattern.charAt(i) != pattern.charAt(j)) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }
            } else {
                j = next[j];
            }
        }
        return next;
    }

}
