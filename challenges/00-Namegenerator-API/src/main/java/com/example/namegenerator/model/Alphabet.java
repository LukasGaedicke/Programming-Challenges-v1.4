package com.example.namegenerator.model;

import java.util.Random;

public class Alphabet {
	private char alphabet[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	private char vowel[] = { 'a', 'e', 'i', 'o', 'u' };

	private char consonants[] = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v',
			'w', 'x', 'y', 'z' };

	private char connectives []= { 'h', 'l', 'r', 's'}; 
	
	public char getRandomLetter() {
		int nbRandom = new Random().nextInt(alphabet.length);
		return alphabet[nbRandom];
	}

	public char getRandomVowel() {
		int nbRandom = new Random().nextInt(vowel.length);
		return vowel[nbRandom];
	}

	public char getRandomConnectives() {
		int nbRandom = new Random().nextInt(connectives.length);
		return connectives[nbRandom];
	}
	
	public char getRandomConsonants() {
		int nbRandom = new Random().nextInt(consonants.length);
		return consonants[nbRandom];
	}

	public boolean isVogal(Character letter) {
		for (char string : vowel) {
			if (letter.equals(string)) {
				return true;
			}
		}
		return false;
	}
}
