-- The following queries utilize the "dvdstore" database.

--SELECT *
--FROM payment
--JOIN customer ON payment.customer_id = customer.customer_id
--WHERE payment_id = 16666;


-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
select title from film_actor
join film on film_actor.film_id = film.film_id
where actor_id = '44';


-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
-- (30 rows)
select title from film_actor
join film on film_actor.film_id = film.film_id
where actor_id = '135';



-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
select title from film_actor
join film on film_actor.film_id = film.film_id
where actor_id in ('143', '35');

-- 4. All of the the ‘Documentary’ films
-- (68 rows)
select title from film_category
join film on film_category.film_id = film.film_id
where category_id in ('6');


-- 5. All of the ‘Comedy’ films
-- (58 rows)
select title from film_category
join film on film_category.film_id = film.film_id
where category_id in ('5');

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
select title from film_category
join film on film_category.film_id = film.film_id
where category_id in ('3') and film.rating = 'G';


-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
select title from film_category
join film on film_category.film_id = film.film_id
where category_id in ('8') and film.rating = 'G' and film.length < 120;


-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
select * 
from film_actor
join film on film_actor.film_id = film.film_id
where actor_id in ('103') and film.rating = 'G';


-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
select title from film_category
join film on film_category.film_id = film.film_id
where category_id in ('14') and film.release_year = '2006';



-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
select * from film_category
join film on film_category.film_id = film.film_id
join film_actor on film_actor.film_id = film.film_id
where category_id in ('1') and film_actor.actor_id='44';



-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
select address, city, district, country
from store
join address on store.address_id = address.address_id
join city on city.city_id = address.city_id
join country on city.country_id = country.country_id;

-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)

select  store.store_id, address, concat(first_name, ' ', last_name) as name
from store
join address on store.address_id = address.address_id
join staff on staff.staff_id = store.manager_staff_id;

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)
--name, count(customer.customer_id)

select first_name, last_name, count(customer.customer_id) 
from customer
join rental on customer.customer_id = rental.customer_id
group by customer.customer_id
order by count desc
limit 10;


-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)
select * from payment;

select concat(first_name, ' ', last_name) as name, sum(amount)--first_name, last_name, count(customer.customer_id) 
from customer
join payment on customer.customer_id = payment.customer_id
--join rental on customer.customer_id = rental.customer_id
--join payment on rental.customer_id = payment.payment_id
group by customer.customer_id
order by sum desc
limit 10;



-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that an employee may work at multiple stores.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)

-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)

-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)

-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)

-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)

-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)
