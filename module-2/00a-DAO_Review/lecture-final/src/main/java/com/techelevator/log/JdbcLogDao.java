package com.techelevator.log;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcLogDao implements LogDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcLogDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void save(Log log) {
		String sql = "INSERT INTO log (id, action, beginning_balance, ending_balance, entry_date) VALUES (DEFAULT, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, log.getAction(), log.getBeginningBalance(), log.getEndingBalance(), log.getEntryDate());
	}

	@Override
	public List<Log> getAllLogEntries() {
		List<Log> entries = new ArrayList<Log>();
		String sql = "SELECT id, action, beginning_balance, ending_balance, entry_date FROM log";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		
		while (rows.next()) {
			entries.add( mapRowToLog( rows) );
		}
		
		return entries;
	}
	
	private Log getLogById(int id) {
		Log log = null;
		String sql = "SELECT id, action, beginning_balance, ending_balance, entry_date FROM log WHERE id = ?";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, id);
		
		while (rows.next()) {
			log = mapRowToLog( rows);
		}
		
		return log;
	}
	
	private Log mapRowToLog(SqlRowSet row) {
		Log log = new Log();
		log.setId( row.getLong("id") );
		
		String actionFromSql = row.getString("action");;
		
		log.setAction( actionFromSql );
		log.setBeginningBalance( row.getDouble("beginning_balance"));
		log.setEndingBalance( row.getDouble("ending_balance"));
		if (row.getDate("entry_date") != null) {
			log.setEntryDate( row.getDate("entry_date").toLocalDate() );
		}
		
		return log;
	}
	

}
