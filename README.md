# TicketReservation_ASHISHJAIN_20JULY


## features 1 User Authentication
- User can login into the system using their credentials.
- Get the JWT token and access rest of the API's with Token.
- Access personalized features for viewing reservation.

## features 2 Searching For Buses
- Search for buses based on arrival and departure or any one filter or withot filter also
- View Available Bus Route and their schedule

## features 3 Viewing Seat availability
- View available seat for specific bus and route

## features 4 Seat Reservation
- select seat and reserve seat.
- reservation are saved under the user profile.

DB 

User Table 
============================================================

 id |                           password                           | user_name | 
----+--------------------------------------------------------------+-----------+
  1 | $2a$10$dOsE78GXpfOYW6cC7hJz/OWQs7U8xSlgroHGjK.jrakonTV5/9P7e | aj@123    | 
  2 | $2a$10$nVmR4BsJjU5e0Ge6hpoM0OfBJUj20MeU6/At8sP4TbR3Lzs.SZvf. | aj@124    | 
  3 | $2a$10$CkcnwsDCHJ/rSG4t22qT4eV34sogMP49HOyXPW1oCCESkb1N2gZB6 | xyz       | 

  
ROute 
================================================================
busticketdb=# select * from route;
 id | arrival |    date    | departure | bus_id 
----+---------+------------+-----------+--------
  1 | Delhi   | 2024-07-15 | Gurgaon   |      1
  2 | Gurgaon | 2024-07-16 | Noida     |      1
  3 | Gurgaon | 2024-07-16 | Noida     |      2
  4 | Gurgaon | 2024-07-16 | Noida     |      3

Bus
==============================================================
busticketdb=# select * from bus;
 id | bus_number 
----+------------
  1 | HR26U123
  2 | HR26U127
  3 | HR26U126

  Seat 
  ============================================================
  busticketdb=# select * from seat;
 id | is_available | seat_number | bus_id | route_route_id 
----+--------------+-------------+--------+----------------
  1 | t            | 12          |      1 |              1
  2 | t            | 13          |      1 |              1
  3 | t            | 14          |      1 |              1
  4 | t            | 15          |      1 |              1
  5 | t            | 16          |      1 |              1
  9 | t            | 18          |      3 |              2


 Reservation 
 ===============================================================

 busticketdb=# select * from reservation;
 id | reservation_time | route_id | seat_id | user_id | route_route_id 
----+------------------+----------+---------+---------+----------------
  1 |  2024-07-20      |        1 |      12 |       6 |              1
