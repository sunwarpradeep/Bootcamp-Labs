
SELECT productID,  productName, UnitPrice
FROM Products;

SELECT productID, productName, unitPrice
FROM Products
ORDER BY unitPrice;

SELECT ProductID, ProductName, UnitPrice
FROM products
WHERE unitPrice <=7.50;

SELECT ProductID, ProductName, UnitPrice
FROM Products
WHERE UnitsInStock >= 100
ORDER BY UnitPrice DESC, ProductName ASC;

SELECT productID, ProductName
FROM Products
WHERE unitsInStock = 0 AND UnitsOnOrder > 0
ORDER BY ProductName ASC;

SELECT * 
FROM Categories;

SELECT ProductID, ProductName, UnitPrice
FROM Products
WHERE CategoryID = (SELECT CategoryID FROM Categories WHERE categoryName = 'seafood');

SELECT firstName, lastName
FROM employees;

SELECT firstName, lastName, Title
FROM Employees
WHERE Title Like '%Manager%';

SELECT firstName, lastName, Salary
FROM employees
WHERE salary BETWEEN 2000 AND 2500;

SELECT *
FROM suppliers;

SELECT p.ProductID, p.ProductName, s.SupplierName
FROM Products p
JOIN Suppliers s ON p.SupplierID = s.SupplierID;

