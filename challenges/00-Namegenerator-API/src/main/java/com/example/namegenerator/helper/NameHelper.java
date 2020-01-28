package com.example.namegenerator.helper;

public class NameHelper {
	public char lastChar(String name) {
		int lenghtName = name.length();
		return name.charAt(lenghtName - 1);
	}
}
