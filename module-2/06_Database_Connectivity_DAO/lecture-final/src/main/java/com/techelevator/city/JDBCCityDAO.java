package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/*
 * The DAO Implementation class implements the DAO Interface and provides
 * implementation for each defined method.  
 * 
 * For a JDBC Implementation Class each method will contain the SQL, calls to the
 * database, and converting the results into Java data types (DAO Data Class or other data types as needed)
 */
public class JDBCCityDAO implements CityDAO {

	/*
	 * Private jdbcTemplate member variable to be used by the class for database access
	 */
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * The constructor for a JDBC Implementation class should accept a DataSource and
	 * use it to instantiate the JdbcTemplate member variable.
	 */
	public JDBCCityDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(City newCity) {
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";
		// INSERT methods should always set the id in the Data Object passed to it.  Since it 
		// is a reference the calling method will then have access to the id after this method
		// completes.
		newCity.setId(getNextCityId());
		jdbcTemplate.update(sqlInsertCity, newCity.getId(),
										  newCity.getName(),
										  newCity.getCountryCode(),
										  newCity.getDistrict(),
										  newCity.getPopulation());
	}
	
	@Override
	public City findCityById(long id) {
		City theCity = null;
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);
		if(results.next()) {
			theCity = mapRowToCity(results);
		}
		return theCity;
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		ArrayList<City> cities = new ArrayList<>();
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population "+
										   "FROM city "+
										   "WHERE countrycode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);
		while(results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		}
		return cities;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(City city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Private method to allow the other methods to get the next available generated id
	 * from the sequence.  This is only needed if SELECT nextVal() is being used to get the id.
	 */
	private long getNextCityId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}

	/*
	 * Private method that takes a SqlRowSet that has already had its cursor position set
	 * to the next row using the next() method and maps it to the DAO Data Object.  This allows
	 * for the other methods to use this for the repeated work.  NOTE: All rows used in this mapping 
	 * method MUST be included in the return of the SELECT of the methods using it.
	 */
	private City mapRowToCity(SqlRowSet results) {
		City theCity;
		theCity = new City();
		theCity.setId(results.getLong("id"));
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity;
	}
}
