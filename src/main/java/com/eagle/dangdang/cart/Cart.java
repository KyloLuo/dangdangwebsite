package com.eagle.dangdang.cart;

import java.util.ArrayList;
import java.util.List;

import com.eagle.dangdang.order.entity.OrderLine;
import com.eagle.dangdang.product.entity.Product;

/*购物车的实体类*/
public class Cart {

	private List<OrderLine> items = new ArrayList<OrderLine>(0);// 有效的列表项
	private List<OrderLine> deletedItems = new ArrayList<OrderLine>(0);// 被删除的列表项

	public Cart() {
		super();
	}

	// 添加商品
	public void addProduct(Product product, int num) {
		boolean flag = false;
		if (items.size() == 0) {
			// 开启一条新的列表项
			OrderLine newOrderLine = new OrderLine();
			newOrderLine.setProduct(product);
			newOrderLine.setProductNum(num);
			newOrderLine.setAmount(product.getDangPrice() * num);
			items.add(newOrderLine);
		} else {
			for (int i = 0; i < items.size(); i++) {
				OrderLine line = items.get(i);
				if (line.getProduct().equals(product)) {// 该商品某个列表中已经存在
					// 该商品的数量加num,并计算下该烈的价格
					line.setProductNum(line.getProductNum() + num);
					line.setAmount(line.getAmount()
							+ line.getProduct().getDangPrice() * num);
					flag = true;
					break;
				}

			}
			if (!flag) {
				// 开启一条新的列表项
				OrderLine newOrderLine = new OrderLine();
				newOrderLine.setProduct(product);
				newOrderLine.setProductNum(num);
				newOrderLine.setAmount(product.getDangPrice() * num);
				items.add(newOrderLine);
			}
		}
	}

	// 数量修改(前提肯定是在已经存在于购物车中的商品)
	public void changeNum(long productId, int num) {
		for (int i = 0; i < items.size(); i++) {
			OrderLine line = items.get(i);
			if (line.getProduct().getId() == productId) {
				line.setProductNum(num);
				line.setAmount(line.getProduct().getDangPrice() * num);
				break;
			}
		}
	}

	// 删除列表(注意：根据这列的产品id删除，不是根据OrserLine的id删除)
	public void deleteLine(long productId) {
		for (int i = 0; i < items.size(); i++) {
			OrderLine line = items.get(i);
			if (line.getProduct().getId() == productId) {
				deletedItems.add(line);
				items.remove(i);
				break;
			}
		}
	}

	// 恢复列表
	public void restore(long productId) {
		for (int i = 0; i < items.size(); i++) {
			OrderLine line = deletedItems.get(i);
			if (line.getProduct().getId() == productId) {
				items.add(line);
				deletedItems.remove(i);
				break;
			}
		}
	}

	// 清空购物车
	public void empty() {
		items = new ArrayList<OrderLine>(0);
		deletedItems = new ArrayList<OrderLine>(0);
	}

	// 结算
	public double cost() {
		double sum = 0.0;
		for (int i = 0; i < items.size(); i++) {
			sum += items.get(i).getAmount();
		}
		return sum;
	}

	public List<OrderLine> getItems() {
		return items;
	}

	public void setItems(List<OrderLine> items) {
		this.items = items;
	}

	public List<OrderLine> getDeletedItems() {
		return deletedItems;
	}

	public void setDeletedItems(List<OrderLine> deletedItems) {
		this.deletedItems = deletedItems;
	}

	@Override
	public String toString() {
		return "Cart [items=" + items + ", deletedItems=" + deletedItems + "]";
	}

}
