package com.aynna.dao;

import java.util.List;

import com.aynna.model.Configuration;

public class TestConfigurationDAO {
	public static void main(String[] args) {
		//Configuration config = new Configuration();

		ConfigurationDAO configdao = new ConfigurationDAO();
		List<Configuration> configlist = configdao.list();

		for (Configuration c : configlist) {
			System.out.println(c);
		}

	}
	
}
