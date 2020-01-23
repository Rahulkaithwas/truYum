
package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class CardDaoCollectionImpl implements CartDao {

	private static HashMap<Long, Cart> userCarts;

	public CardDaoCollectionImpl() {

		if (userCarts == null) {
			userCarts = new HashMap<Long, Cart>();
			try {
			MenuItem menuItem = new MenuItem(000002, "Cake", 80.00f, true,
					DateUtil.convertToDate("11/12/2019"), "Main Course", false);
			List<MenuItem> menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(menuItem);
			
			Cart cart = new Cart(menuItemList,80.0);
			Long user = new Long(1);
			userCarts.put(user, cart);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			

		}
		

	}

	
	@Override
	public void addCartItem(long userid, long menuItemId) {
		// TODO Auto-generated method stub
		List<MenuItem> menuItemList;
		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();
		MenuItemDao menuItemDao = menuItemDaoCollectionImpl;
		//menuItemDao.getMenuItem(menuItemId);
		Long userId = new Long(userid);
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			Cart cart = userCarts.get(userId);
			menuItemList = cart.getMenuItemList();
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			double total = 0;
			for(MenuItem menuitem:menuItemList) {
			
				total = total + menuitem.getPrice();
				
			}
			cart.setTotal(total);
			userCarts.put(userId, cart);

		} else {
			menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(menuItem);

			Cart cart = new Cart(menuItemList, menuItem.getPrice());
			userCarts.put(userId, cart);

		}

	}

	
	@Override
	public List<MenuItem> getAllCartItems(long userid)
			throws CartEmptyException {

		Cart cart = userCarts.get(new Long(userid));
		List<MenuItem> menuItemList = cart.getMenuItemList();
		if (menuItemList == null || menuItemList.size() == 0) {
			throw new CartEmptyException("Cart is empty");
		}
		double total = 0.0;
		for (MenuItem menuItem : menuItemList) {
			total = total + menuItem.getPrice();

		}
		cart.setTotal(total);

		// TODO Auto-generated method stub
		return menuItemList;
	}

	
	@Override
	public void removeCartItem(long userId, long menuitemid) {
		// TODO Auto-generated method stub

	}

}
