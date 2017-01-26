package com.aynna.dao;

import java.util.List;

import com.aynna.model.Configuration;

public class TestConfigurationDAO {
	public static void main(String[] args) {
		// Configuration config = new Configuration();
		// config.setId(1);
		// config.setItemLimit(5);
		// config.setNumberOfSeats(10);

		ConfigurationDAO configdao = new ConfigurationDAO();
		// configdao.save(config);
		// configdao.delete(2);
		// configdao.updateItemLimit(config);
		// configdao.updateNumberOfSeats(config);
		List<Configuration> configlist = configdao.list();

		for (Configuration c : configlist) {
			System.out.println(c);
		}

	}
}
