package com.bnpp.kata.developemetbooks.service;

import java.util.ArrayList;
import java.util.List;

import com.bnpp.kata.developemetbooks.constant.CalculateBooksConstant;
import com.bnpp.kata.developemetbooks.model.BookApiRequest;

public class CalculateBooksPriceService {

	public double calculateBooksPrice(List<BookApiRequest> bookApiRequestList) {
		double calculatedPrice = 0d;
		if (bookApiRequestList.size() == 1) {
			BookApiRequest bookApiRequest = bookApiRequestList.get(0);
			calculatedPrice = CalculateBooksConstant.PRICE * bookApiRequest.getQuantity();
		} else if (bookApiRequestList.size() == 2) {
			double basePrice = bookApiRequestList.size() * CalculateBooksConstant.PRICE;
			double discountedPriceForSet = basePrice - ((basePrice * 5) / CalculateBooksConstant.PERCENTAGE);
			calculatedPrice += discountedPriceForSet;
		} else if (bookApiRequestList.size() == 3) {
			double basePrice = bookApiRequestList.size() * CalculateBooksConstant.PRICE;
			double discountedPriceForSet = basePrice - ((basePrice * 10) / CalculateBooksConstant.PERCENTAGE);
			calculatedPrice += discountedPriceForSet;
		} else if (bookApiRequestList.size() == 4) {
			double basePrice = bookApiRequestList.size() * CalculateBooksConstant.PRICE;
			double discountedPriceForSet = basePrice - ((basePrice * 20) / CalculateBooksConstant.PERCENTAGE);
			calculatedPrice += discountedPriceForSet;
		} else if (bookApiRequestList.size() == 5) {
			double basePrice = bookApiRequestList.size() * CalculateBooksConstant.PRICE;
			double discountedPriceForSet = basePrice - ((basePrice * 25) / CalculateBooksConstant.PERCENTAGE);
			calculatedPrice += discountedPriceForSet;
		}
		return calculatedPrice;

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

}
