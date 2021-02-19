package com.techelevator.log;

import java.util.List;

public interface LogDao {

	void save(Log log);
	List<Log> getAllLogEntries();
	
}
