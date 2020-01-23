
package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;


public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws CartEmptyException {
		
		testAddCartItem();

	}

	static void testAddCartItem() throws CartEmptyException {

		CartDaoCollectionImpl cartDaoCollectionImpl = new CartDaoCollectionImpl();
		CartDao cartDao = cartDaoCollectionImpl;
		cartDao.addCartItem(1, 000004);
		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		System.out.println("MenuItem list :" + menuItemList);

	}

	void testGetAllCartItems() {

	}

	void testRemoveCartItem() {

	}

}
