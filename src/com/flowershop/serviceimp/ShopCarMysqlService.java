package com.flowershop.serviceimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flowershop.bean.FlowerOrderItem;
import com.flowershop.bean.ShopCar;
import com.flowershop.bean.User;
import com.flowershop.factory.ConnectionFactory;
import com.flowershop.service.ShopCarService;

public class ShopCarMysqlService implements ShopCarService {

	private ShopCar shopcar = null;
	
	public ShopCarMysqlService() {
		shopcar = new ShopCar();
		List<FlowerOrderItem> items = new ArrayList<FlowerOrderItem>();
		shopcar.setItems(items);
	}
	
	
	
	@Override
	public void setUserId(Integer userId) {
		// TODO Auto-generated method stub
		shopcar.setUserId(userId);
	}
	

	@Override
	public User getUser(Integer userId) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.newMysqlInstance().getConnection();
		String sql = "select * from user where userId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user.setUserId(rs.getInt("userId"));
				user.setEmail(rs.getString("email"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserRole(rs.getInt("userRole"));
			}
		} catch(SQLException e) {
System.out.println("购物车时，通过用户Id获取用户信息");
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.newMysqlInstance().closedConnection(conn);
			ConnectionFactory.newMysqlInstance().closedPreparedStatement(pstmt);
		}
		return user;
	}



	@Override
	public boolean addOrderItem(FlowerOrderItem item) {
		// TODO Auto-generated method stub
		List<FlowerOrderItem> items = shopcar.getItems();
		if(items.size() == 0)
			return items.add(item);
		else {
			for(int i = 0; i < items.size(); i++) {
				if(items.get(i).getFlowerId() == item.getFlowerId()) {
					items.get(i).setFlowerCount(items.get(i).getFlowerCount()+item.getFlowerCount());
					return true;
				}
			}
			return items.add(item);
		}
	}

	@Override
	public boolean deleteOrderItem(FlowerOrderItem item) {
		// TODO Auto-generated method stub
		List<FlowerOrderItem> items = shopcar.getItems();
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getFlowerId() == item.getFlowerId()) {
				items.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateOrderItem(FlowerOrderItem item) {
		// TODO Auto-generated method stub
		List<FlowerOrderItem> items = shopcar.getItems();
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getFlowerId() == item.getFlowerId()) {
				items.get(i).setFlowerCount(item.getFlowerCount());
				items.get(i).setFlowerOrderId(item.getFlowerOrderId());
				items.get(i).setUnitPrice(item.getUnitPrice());
				return true;
			}
		}
		return false;
	}

	@Override
	public FlowerOrderItem getOrderItemInItemId(FlowerOrderItem item) {
		// TODO Auto-generated method stub
		List<FlowerOrderItem> items = shopcar.getItems();
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getItemId() == item.getItemId()) {
				return items.get(i);
			}
		}
		return null;
	}

	@Override
	public List<FlowerOrderItem> getOrderItems() {
		// TODO Auto-generated method stub
		return shopcar.getItems();
	}



	@Override
	public String getTotalPrice() {
		// TODO Auto-generated method stub
		List<FlowerOrderItem> items = shopcar.getItems();
		Double d = 0.0;
		for(int i = 0; i < items.size(); i++) {
			Double d1 = Double.valueOf(items.get(i).getUnitPrice()) * Double.valueOf(items.get(i).getFlowerCount());
			d += d1;
//System.out.println(items.get(i).getUnitPrice() + ":" + items.get(i).getFlowerCount());
		}
		String price = d.toString();
//System.out.println(price.indexOf(".")+2);
		price = price.substring(0, price.indexOf(".")+2);
		return price;
	}

}
