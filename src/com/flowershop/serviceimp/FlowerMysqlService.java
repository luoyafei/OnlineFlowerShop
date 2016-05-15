package com.flowershop.serviceimp;

import java.util.List;

import com.flowershop.bean.Flower;
import com.flowershop.dao.FlowerDao;
import com.flowershop.factory.DaoFactory;
import com.flowershop.service.FlowerService;

public class FlowerMysqlService implements FlowerService {

	private FlowerDao fd;
	public FlowerMysqlService() {
		fd = DaoFactory.createFlowerDao();
	}
	
	@Override
	public Flower getFlowerInId(Integer flowerId) {
		// TODO Auto-generated method stub
		return fd.getFlowerInId(flowerId);
	}

	@Override
	public boolean insertFlower(Flower flower) {
		// TODO Auto-generated method stub
		return fd.insertFlower(flower);
	}

	@Override
	public boolean deleteFlower(Flower flower) {
		// TODO Auto-generated method stub
		return fd.deleteFlower(flower);
	}

	@Override
	public boolean updateFlower(Flower flower) {
		// TODO Auto-generated method stub
		return fd.updateFlower(flower);
	}

	@Override
	public List<Flower> getFlowers(Integer start, Integer length, Integer flowerCategary) {
		// TODO Auto-generated method stub
		return fd.getFlowers(start, length, flowerCategary);
	}

}
