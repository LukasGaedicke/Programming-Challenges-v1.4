package com.example.namegenerator.service;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.namegenerator.helper.NameHelper;
import com.example.namegenerator.model.Alphabet;
import com.example.namegenerator.model.Name;

@Service
public class NameService {

	private Alphabet alphabet;
	private NameHelper nameHelper;

	public List<Name> generateName(int quantidade) {

		List<Name> listOfNames = new ArrayList();

		for (int i = 0; i < quantidade; i++) {
			listOfNames.add(new Name(createName()));
		}

		return listOfNames;
	}

	private String createName() {
		alphabet = new Alphabet();
		nameHelper = new NameHelper();
		String auxName = "";
		int nameLength = new Random().nextInt(5) + 4;

		for (int j = 0; j < nameLength; j++) {
			if (auxName.length() == 0) {
				auxName = auxName + alphabet.getRandomLetter();
				if (new Random().nextInt(3) == 2) {
					auxName = auxName + alphabet.getRandomConnectives();
					nameLength--;
				}
			} else {
				if (alphabet.isVogal(nameHelper.lastChar(auxName))) {
					auxName = auxName + alphabet.getRandomConsonants();
				} else {
					auxName = auxName + alphabet.getRandomVowel();
				}
			}
		}
		return auxName;
	}

}
