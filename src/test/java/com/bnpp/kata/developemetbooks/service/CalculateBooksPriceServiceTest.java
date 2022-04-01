package com.bnpp.kata.developemetbooks.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.bnpp.kata.developemetbooks.model.BookApiRequest;

public class CalculateBooksPriceServiceTest {
	private BookApiRequest bookApiRequest;
	private CalculateBooksPriceService calculateBooksPriceService;
	private List<BookApiRequest> bookApiRequestList;

	private void setShoppingCart(int bookId, int quantity) {
		bookApiRequest = new BookApiRequest();
		bookApiRequest.setBookId(bookId);
		bookApiRequest.setQuantity(quantity);
	}

	@Before
	public void init() {
		calculateBooksPriceService = new CalculateBooksPriceService();
	}

	@Test
	public void calculatePriceShouldReturnFiftyWhenUserBuysOneBook() {
		bookApiRequestList = new ArrayList<>();
		setShoppingCart(1, 1);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(50d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestList));
	}

	@Test
	public void calculatePriceShouldReturn100WhenUserBuysTwoBook() {
		bookApiRequestList = new ArrayList<>();
		setShoppingCart(1, 2);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(100d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestList));
	}

	@Test
	public void calculatePriceShouldReturn95WhenUserBuysTwoDifferentBook() {
		bookApiRequestList = new ArrayList<>();
		setShoppingCart(1, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(2, 1);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(95d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestList));

	}

	@Test
	public void calculatePriceShouldReturn135WhenUserBuysThreeDifferentBook() {
		bookApiRequestList = new ArrayList<>();
		setShoppingCart(1, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(2, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(3, 1);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(135d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestList));

	}

	@Test
	public void calculatePriceShouldReturn160WhenUserBuysFourDifferentBook() {
		bookApiRequestList = new ArrayList<>();
		setShoppingCart(1, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(2, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(3, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(4, 1);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(160d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestList));
	}

	@Test
	public void calculatePriceShouldReturn187WhenUserBuysFiveDifferentBook() {
		bookApiRequestList = new ArrayList<>();
		setShoppingCart(1, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(2, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(3, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(4, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(5, 1);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(187.5d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestList));
	}

	@Test
	public void calculateTotalNumberOfBookInTheCart() {
		bookApiRequestList = new ArrayList<>();
		setShoppingCart(1, 2);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(2, 2);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(3, 2);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(4, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(5, 1);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(8, calculateBooksPriceService.getBookIdList(bookApiRequestList).size());
	}

	@Test
	public void probabilityOfBookCombination() {
		bookApiRequestList = new ArrayList<>();
		setShoppingCart(1, 2);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(2, 2);
		bookApiRequestList.add(bookApiRequest);

		List<Integer> numbrerOfbooks = calculateBooksPriceService.getBookIdList(bookApiRequestList);

		Assertions.assertEquals(2, calculateBooksPriceService.getDefaultBooksCombination(numbrerOfbooks).size());
	}
	
	@Test
	public void calculatePriceWhenUsingDifferentCombination() {
		bookApiRequestList = new ArrayList<>();
		setShoppingCart(1, 2);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(2, 2);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(3, 2);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(4, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(5, 1);
		bookApiRequestList.add(bookApiRequest);
	
		List<Integer> numbrerOfbooks = calculateBooksPriceService.getBookIdList(bookApiRequestList);
		List<List<Integer>> booksCombination =calculateBooksPriceService.getDefaultBooksCombination(numbrerOfbooks);
		
		Assertions.assertEquals(322.5d, calculateBooksPriceService.getBooksPrice(booksCombination));
	}
	
	

}
