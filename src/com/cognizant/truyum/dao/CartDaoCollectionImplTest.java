
package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;


public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws CartEmptyException {
		
		//testAddCartItem();
		testRemoveCartItem();
	}

	public static void testAddCartItem() throws CartEmptyException {

		CartDaoCollectionImpl cartDaoCollectionImpl = new CartDaoCollectionImpl();
		CartDao cartDao = cartDaoCollectionImpl;
		cartDao.addCartItem(1, 000004);
		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		System.out.println("MenuItem list :" + menuItemList);

	}

	public static void testGetAllCartItems() {
	
	}

	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 000004);
		try {
			
			List<MenuItem> remainingItem = cartDao.getAllCartItems(1);
			for(MenuItem menuItem : remainingItem) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println("There is no item");
			e.printStackTrace();
		}
	}

}
