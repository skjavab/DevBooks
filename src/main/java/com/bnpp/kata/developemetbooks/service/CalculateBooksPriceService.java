package com.bnpp.kata.developemetbooks.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bnpp.kata.developemetbooks.model.BookApiRequest;
import com.bnpp.kata.developemetbooks.model.DiscountEnum;

public class CalculateBooksPriceService {
	private int maxDiscountSet;

	public double calculateBooksPrice(List<BookApiRequest> bookApiRequestList) {
	maxDiscountSet = bookApiRequestList.size();
	Collections.sort(bookApiRequestList, Collections.reverseOrder());
	List<Integer> inputBookIds = getBookIdList(bookApiRequestList);
	List<List<Integer>> defaultCombinationSets = getDefaultBooksCombination(inputBookIds);

	
	double totalPriceNormalSets = getBooksPrice(defaultCombinationSets);
	
	return totalPriceNormalSets;
	
	}

	public List<Integer> getBookIdList(List<BookApiRequest> bookInputList) {
		List<Integer> extractedList = new ArrayList<>();
		for (BookApiRequest bookApiRequest : bookInputList) {
			addBookId(extractedList, bookApiRequest);
		}
		return extractedList;
	}

	private List<Integer> addBookId(List<Integer> extractedList, BookApiRequest bookApiRequest) {
		if (bookApiRequest.getQuantity() == null) {
			extractedList.add(bookApiRequest.getBookId());
		} else {
			for (int i = 0; i < bookApiRequest.getQuantity(); i++) {
				extractedList.add(bookApiRequest.getBookId());
			}
		}
		return extractedList;
	}

	public List<List<Integer>> getDefaultBooksCombination(List<Integer> bookList) {
		List<List<Integer>> bookListSets = new ArrayList<>();
		List<Integer> initList = new ArrayList<>();
		bookListSets.add(initList);

		for (Integer bookId : bookList) {
			boolean bookAddedToExistingSet = addBookToExistingSet(bookListSets, bookId);
			if (!bookAddedToExistingSet) {
				addBookToNewSet(bookListSets, bookId);
			}
		}
		return bookListSets;
	}

	private boolean addBookToExistingSet(List<List<Integer>> bookListSets, Integer bookId) {
		boolean bookAddedToExistingSet = false;
		for (List<Integer> list : bookListSets) {
			if (!list.contains(bookId)) {
				list.add(bookId);
				bookAddedToExistingSet = true;
				break;
			}
		}
		return bookAddedToExistingSet;
	}

	private void addBookToNewSet(List<List<Integer>> bookListSets, Integer bookId) {
		List<Integer> newSet = new ArrayList<>();
		newSet.add(bookId);
		bookListSets.add(newSet);
	}
	
	public double getBooksPrice(List<List<Integer>> bookListSets) {
		double totalPrice = 0d;
		for (List<Integer> bookIds : bookListSets) {
			Double discountForSet = DiscountEnum.getDiscounts().get(bookIds.size());
			totalPrice += calculateDiscountedPrice(bookIds, discountForSet);
		}
		return totalPrice;
	}

	private double calculateDiscountedPrice(List<Integer> set, double discountForSet) {
		double calculatedPrice = 0d;
		double basePrice = set.size() * 50;
		double discountedPriceForSet = basePrice - ((basePrice * discountForSet) / 100.0);
		calculatedPrice += discountedPriceForSet;
		return calculatedPrice;
	}
	

}
