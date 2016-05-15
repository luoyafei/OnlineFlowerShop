package com.flowershop.dao;

import java.util.List;

import com.flowershop.bean.Flower;

public interface FlowerDao {
	public Flower getFlowerInId(Integer flowerId);
	public boolean insertFlower(Flower flower);
	public boolean deleteFlower(Flower flower);
	public boolean updateFlower(Flower flower);
	public List<Flower> getFlowers(Integer start, Integer length, Integer flowerCategary);
}
