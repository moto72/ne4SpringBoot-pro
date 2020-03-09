package com.nuoyun.pro.string;

import java.util.Scanner;

import org.junit.Test;

public class StringTest {
	private Scanner scanner;
	private static Scanner scanner2;

	@Test
	public void test() {
		scanner = new Scanner(System.in);
		System.err.println("请输入str1");
		String str1 = scanner.nextLine();
		System.err.println("请输入str2");
		String str2 = scanner.nextLine();
		System.err.println("str1 == str2 :" + (str1 == str2));
		System.err.println("str1 equals str2 :" + (str1.equals(str2)));
	}
	
	@Test
	public void test1() {
		String str1 = "我在eclipse里面使用jdk1.8 192 和 openjdk 11 里面执行程序 == 也是 false ，即便只有一个字符。";
		String str2 = "我在eclipse里面使用jdk1.8 192 和 openjdk 11 "+"里面执行程序 == 也是 false ，即便只有一个字符。";
		System.err.println("str1  == str2 :"+(str1==str2));
	}
	

	public static void main(String[] args) {
		scanner2 = new Scanner(System.in);
		System.err.println("请输入str1");
		String str1 = scanner2.nextLine();
		System.err.println("请输入str2");
		String str2 = scanner2.nextLine();
		System.err.println("str1 == str2 :" + (str1 == str2));
		System.err.println("str1 equals str2 :" + (str1.equals(str2)));
	}
}
