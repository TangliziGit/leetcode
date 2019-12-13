# Write your MySQL query statement below
select name as Customers
    from Customers c
    where not exists(
        select *
        from Orders o
        where o.CustomerId = c.Id
    )
