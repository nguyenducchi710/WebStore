USE  master
GO
CREATE DATABASE Assignment;
GO
USE Assignment;
GO

-- Tạo bảng Sản phẩm
CREATE TABLE Products (
    ID INT PRIMARY KEY,
    ProductName NVARCHAR(255),
    Description NVARCHAR(255),
    Price DECIMAL(10, 2),
    Gender NVARCHAR(255),
    ProductType NVARCHAR(255),
    Size NVARCHAR(255)
);
GO

-- Tạo bảng Người dùng (thay đổi tên từ Customers)
CREATE TABLE tbUser (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    CustomerName NVARCHAR(255),
    Address NVARCHAR(255) DEFAULT 'HoChiMinh City, Vietnam',
    Phone NVARCHAR(255),
    Email NVARCHAR(255),
    Username NVARCHAR(255),
    Password NVARCHAR(255),
    Role VARCHAR(2) NOT NULL DEFAULT 'US',
    RegistrationDate DATETIME DEFAULT GETDATE()
);
GO

-- Tạo bảng Đơn đặt hàng
CREATE TABLE Orders (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    TotalAmount DECIMAL(10, 2),
    Status VARCHAR(50),
    CustomerID INT,
	OrderDate DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (CustomerID) REFERENCES tbUser(ID)
);
GO

-- Tạo bảng Chi tiết đơn hàng
CREATE TABLE OrderDetails (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    OrderID INT,
    ProductID INT,
    Quantity INT,
    FOREIGN KEY (OrderID) REFERENCES Orders(ID),
    FOREIGN KEY (ProductID) REFERENCES Products(ID)
);
GO

INSERT INTO [dbo].[Products]([ID],[ProductName],[Price],[Gender],[ProductType],[Size])
VALUES  (001, N'Áo thun đen', 20, N'Nam', N'Áo thun', N'XXL'),
		(002, N'Áo thun đen', 20, N'Nữ', N'Áo thun', N'M'),
		(003, N'Áo sơ mi đen', 30, N'Nam', N'Áo sơ mi', N'XL'),
		(004, N'Áo sơ mi trắng', 25, N'Nữ', N'Áo sơ mi', N'M'),
		(005, N'Quần jean dài', 75, N'Nữ', N'Quần jean', N'32'),
		(006, N'Quần jean ngắn', 55, N'Nữ', N'Quần jean', N'32'),
		(007, N'Quần jean dài', 75, N'Nam', N'Quần jean', N'35'),
		(008, N'Quần jean đen', 75, N'Nam', N'Quần jean', N'35'),
		(009, N'Quần jean ngắn', 55, N'Nam', N'Quần jean', N'35'),
		(010, N'Bikini đen', 175, N'Nữ', N'Đồ bơi', N'M'),
		(011, N'Quần bơi đen', 100, N'Nam', N'Đồ bơi', N'XXL'),
		(012, N'Quần bơi đen', 75, N'Nam', N'Đồ bơi', N'XL'),
		(013, N'Đồ thể thao', 175, N'Nữ', N'Sport', N'M'),
		(014, N'Đồ thể thao', 175, N'Nam', N'Sport', N'XXL'),
		(015, N'Đồ thể thao', 175, N'Unisex', N'Sport', N'XXL'),
		(016, N'Găng tay chống nắng', 30, N'Unisex', N'Găng tay', N'M');

GO

INSERT INTO [dbo].[tbUser]([CustomerName],[Email],[Username],[Password],[Role])
VALUES  (N'Nguyễn Jan',N'nguyenjan@gmail.com',N'nguyenjan','12345','AD'),
		(N'Nguyễn Văn A',N'nguyenvana@gmail.com',N'user1','12345','US'),
		(N'Nguyễn Văn B',N'nguyenvanb@gmail.com',N'user2','12345','US');



--#UserDAO
--getUser
SELECT [ID],[CustomerName],[Address],[Phone],[Email],[Username],[Password],[Role],[RegistrationDate]
FROM [dbo].[tbUser]
WHERE [Username] like ?
--registerUser
INSERT INTO [dbo].[tbUser]([CustomerName],[Address],[Phone],[Email],[Username],[Password])
VALUES (?,?,?,?,?);
--searchUser
SELECT [ID],[CustomerName],[Address],[Phone],[Email],[Username],[Password],[Role],[RegistrationDate]
FROM [dbo].[tbUser]
WHERE [Username] like %?%
--getAllUser
SELECT [ID],[CustomerName],[Address],[Phone],[Email],[Username],[Password],[Role],[RegistrationDate]
FROM [dbo].[tbUser]
--deleteUser
DELETE FROM tbUser
WHERE ID = ?;

--#ProductDAO
--getAllProduct
SELECT [ID],[ProductName],[Description],[Price],[Gender],[ProductType],[Size]
FROM [dbo].[Products]
--searchProduct
SELECT [ID],[ProductName],[Description],[Price],[Gender],[ProductType],[Size]
FROM Products
WHERE ProductName LIKE %?% OR ProductType LIKE %?%;
--getProductByID
SELECT [ID],[ProductName],[Description],[Price],[Gender],[ProductType],[Size]
FROM [dbo].[Products]
WHERE [ID] = ?
--deleteProduct
DELETE FROM [dbo].[Products]
WHERE ID = ?;
--updateProduct
UPDATE Products
SET
    ProductName = ?,
    Description = ?,
    Price = ?,
    Gender = ?,
    ProductType = ?,
    Size = ?
WHERE ID = ?;

--#OrderDAO
--saveOrder
INSERT INTO [dbo].[Orders]([TotalAmount],[Status],[CustomerID])
VALUES (?,'Paid',?);

SELECT MAX([ID]) as 'orderid'
FROM [dbo].[Orders]

INSERT INTO [dbo].[OrderDetails]([OrderID],[ProductID],[Quantity])
VALUES (?,?,?);
