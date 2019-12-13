# Write your MySQL query statement below
select p.firstname, p.lastname, a.city, a.state 
    from Person p left join Address a
    on p.personid = a.personid
