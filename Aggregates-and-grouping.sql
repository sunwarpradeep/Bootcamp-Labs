# 1 How many supplier are there?
SELECT COUNT(*)
 FROM Suppliers;
 
 #2 sum of all the employee salaries
 SELECT SUM(Salary)
 FROM Employees;
 
 # Cheapest Item in database
 SELECT MIN(UnitPrice)
 FROM Products;
 
 #average price of items
 SELECT AVG(UnitPrice)
 FROM Products;
 
 #the expensive items 
 SELECT MAX(UnitPrice) 
 FROM Products;
 
 #6 supplierID 
SELECT SupplierID, COUNT(*) AS NumItems 
FROM Products 
GROUP BY SupplierID;

#7 CategoryID 
SELECT CategoryID, avg(unitPrice) AS Avg_Price
FROM Products
GROUP BY CategoryID;

#8 supplier that provide at least 5 items 
SELECT SupplierID, COUNT(*) AS NumItems 
FROM Products
 GROUP BY SupplierID
 HAVING COUNT(*) >= 5;
 
 #9 List 
 SELECT ProductID, ProductName, (UnitPrice * UnitsInStock) AS InventoryValue
 FROM Products
 ORDER BY InventoryValue DESC, ProductName;