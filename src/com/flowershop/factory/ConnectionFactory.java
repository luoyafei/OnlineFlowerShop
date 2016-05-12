package com.flowershop.factory;

import com.flowershop.db.ConnectionAdapter;
import com.flowershop.dbimp.MysqlConnectionFactory;

public class ConnectionFactory {

	public static ConnectionAdapter newMysqlInstance() {
		return new MysqlConnectionFactory();
	}
}
