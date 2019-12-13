# Write your MySQL query statement below
select e.name as Employee
    from Employee e, Employee e1
    where e.ManagerId = e1.id
        and e.salary > e1.salary
