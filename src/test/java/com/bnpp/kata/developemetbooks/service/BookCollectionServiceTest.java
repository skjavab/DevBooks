package com.bnpp.kata.developemetbooks.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BookCollectionServiceTest {
	private BookCollectionService bookCollectionService = new BookCollectionService();

	@Test
	public void getAllBooksShouldReturnFiveBooks() {
		Assertions.assertEquals(5, bookCollectionService.getAllBooks().size());
	}
}
