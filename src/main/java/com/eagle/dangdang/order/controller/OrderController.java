package com.eagle.dangdang.order.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eagle.dangdang.cart.Cart;
import com.eagle.dangdang.order.entity.Order;
import com.eagle.dangdang.order.service.OrderService;
import com.eagle.dangdang.user.entity.ReceiveAddress;
import com.eagle.dangdang.user.entity.User;
import com.eagle.dangdang.user.service.ReceiveAddressService;
import com.eagle.dangdang.user.service.UserService;

@Controller
@RequestMapping(value = "/order")
@SuppressWarnings("unchecked")
public class OrderController {

	@Resource
	private OrderService orderService;

	@Resource
	private UserService userService;

	@Resource
	private ReceiveAddressService receiveAddressService;

	/* 生成订单骤: 1.确认订单 > 2.填写送货地址 > 3.订单成功 */

	// 跳转到订单确认页面,将购物车中的信息提取出来
	@RequestMapping(value = "/orderInfo", method = RequestMethod.GET)
	public String orderInfo(HttpSession session) {
		// 1.获取当前用户的信息(从session中获取),购物车信息
		User user = (User) session.getAttribute("currentUser");
		Cart cart = (Cart) session.getAttribute("currentCart");

		// 2.初始化一个订单
		Order order = new Order();
		order.setOrderDesc(false);
		order.setOrderTime(new Date());
		order.setStatus("未付款");
		order.setUser(user);
		order.setOrderLines(new HashSet(cart.getItems()));
		order.setTotalPrice(cart.cost());

		// 3.将订单信息存入session
		session.setAttribute("currentOrder", order);

		return "order/order_info";// 确认订单信息的页面
	}

	// 跳转到填写收货地址的页面（获取用户的以前填写过的收货地址）
	@RequestMapping(value = "/addressForm", method = RequestMethod.GET)
	public String addressForm(HttpSession session) {
		// 取出用户信息，获得用户之前填写过的收货地址信息
		User user = (User) session.getAttribute("currentUser");
		List<ReceiveAddress> addresses = userService.getAddresses(user.getId());
		session.setAttribute("user_receive_address", addresses);// 也暂存在session中
		return "order/address_form";
	}

	// @RequestMapping(value="/test")
	// public String test(){
	// System.out.println("neng fangwen");
	// return "/order/address_form";
	// }

	// 获得用户的收货地址!!!!!!注意参数传递问题
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public @ResponseBody String createOrder(@RequestBody ReceiveAddress address, HttpSession session) {
		// 用户的收货地址和以前的收货地址进行比较，未存在的话进行更新用户收货地址的操作
		List<ReceiveAddress> addresses = (List<ReceiveAddress>) session
				.getAttribute("user_receive_address");
		Order order = (Order) session.getAttribute("currentOrder");// 获得初始化过的订单
		if (addresses.contains(address)) {// 如果是用户使用的以前的收货地址
			order.setAddress(address);
		} else {
			// 先持久化收货地址address对象，再返回id
			address = receiveAddressService.saveAddress(address);
			User user = order.getUser();
			user.getAddress().add(address);
			userService.updateUser(user);
			order.setAddress(address);
		}

		orderService.createOrder(order);
		return "success";
	}

	
	//跳转到最后订单成功界面
		@RequestMapping(value = "/success", method = RequestMethod.POST)
		public String skip(){
			System.out.println("daowola");
			return "order/order_ok";
		}
	
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ReceiveAddressService getReceiveAddressService() {
		return receiveAddressService;
	}

	public void setReceiveAddressService(
			ReceiveAddressService receiveAddressService) {
		this.receiveAddressService = receiveAddressService;
	}

}