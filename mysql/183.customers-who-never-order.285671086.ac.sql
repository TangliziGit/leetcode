# Write your MySQL query statement below
select name as Customers
    from Customers c
    where c.Id not in (
        select CustomerId
        from Orders
    )
