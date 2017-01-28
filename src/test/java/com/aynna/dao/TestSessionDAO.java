package com.aynna.dao;

import java.time.LocalTime;
import java.util.List;

import com.aynna.model.Session;

public class TestSessionDAO {
	public static void main(String[] args) {
//		Session session = new Session();
//		String startStr = "10:10:12";
//		String endStr = "11:30:00";
//		LocalTime start, end;
//		start = LocalTime.parse(startStr);
//		end = LocalTime.parse(endStr);

//		session.setId(3);
//		session.setName("Brunch");
//		session.setStart(start);
//		session.setEnd(end);

		SessionDAO sessionDao = new SessionDAO();
//		sessionDao.save(session);
//		sessionDao.delete(1);
//		sessionDao.updateSessionName(session);
//		sessionDao.updateSessionStart(session);
//		sessionDao.updateSessionEnd(session);
		List<Session> sessions = sessionDao.list();

		for (Session c : sessions) {
			System.out.println(c);
		}

	}
}
