# Write your MySQL query statement below
SELECT e.name AS Employee
FROM Employee e
JOIN Employee m
ON e.ManagerId = m.Id
    AND e.salary > m.salary ;
