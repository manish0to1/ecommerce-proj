package com.shop.ecomm.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shop.ecomm.exception.CartItemException;
import com.shop.ecomm.exception.UserException;
import com.shop.ecomm.model.Cart;
import com.shop.ecomm.model.CartItem;
import com.shop.ecomm.model.Product;
import com.shop.ecomm.model.User;
import com.shop.ecomm.repository.CartItemRepository;
import com.shop.ecomm.repository.CartRepository;

@Service
public class CartItemServiceImpl implements CartItemService {

	private CartItemRepository cartItemRepository;

	private UserService userService;

	private CartRepository cartRepository;

	public CartItemServiceImpl(CartItemRepository cartItemRepository, UserService userService,
			CartRepository cartRepository) {

		this.cartItemRepository = cartItemRepository;

		this.userService = userService;

		this.cartRepository = cartRepository;

	}

	// ############## Methods ################### //
	@Override
	public CartItem createCartItem(CartItem cartItem) {

		cartItem.setQuantity(1);
		cartItem.setPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
		cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice() * cartItem.getQuantity());

		CartItem createCartItem = cartItemRepository.save(cartItem);

		return createCartItem;

	}

	@Override
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {

		CartItem item = findCartItemById(id);
		User user = userService.findUserById(item.getUserId());
		if (user.getId().equals(userId)) {
			item.setQuantity(cartItem.getQuantity());
			item.setPrice(item.getQuantity() * item.getProduct().getPrice());
			item.setDiscountedPrice(item.getProduct().getDiscountedPrice() * item.getQuantity());
		}

		return cartItemRepository.save(item);
	}

	@Override
	public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {

		CartItem cartItem = cartItemRepository.isCartItemExist(cart, product, size, userId);
		return cartItem;
	}

	@Override
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {

		CartItem cartItem = findCartItemById(cartItemId);
		User user = userService.findUserById(cartItem.getUserId());
		User reqUser = userService.findUserById(userId);

		if (user.getId().equals(reqUser.getId())) {
			cartRepository.deleteById(cartItemId);
		} else {
			throw new UserException("U can't remove another user's cart items. Mind ur own business !");
		}

	}

	@Override
	public CartItem findCartItemById(Long cartItemId) throws CartItemException {

		Optional<CartItem> opt = cartItemRepository.findById(cartItemId);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new CartItemException("Item not found with id :" + cartItemId);
		}
	}

}
