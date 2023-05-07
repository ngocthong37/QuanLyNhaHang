Create database QuanLyNhaHang
Go

use QuanLyNhaHang
GO

-- Tao bang nhan vien
create table NhanVien(
	maNV varchar(10),
	tenNV nvarchar(10) not null,
	hoNV nvarchar(100) not null,
	sdt varchar(10) not null,
	diaChi nvarchar(255),
	trangThai bit not null,
	matKhau varchar(50) not null,
	maVaiTro smallint,
	Primary key(maNV)
)
GO
-- tao bang vai tro
create table VaiTro(
	maVaiTro smallint identity(1,1),
	tenVaiTro nvarchar(50),
	Primary key (maVaiTro)
)
GO
-- Tao bang nguoi quan ly
create table NguoiQL(
	maNQL varchar(10),
	ngayBDQL date not null,
	trangThai bit not null
	Primary key(maNQL)
)
GO
-- Tao bang ban
create table Ban (
	maBan int identity(1,1),
	soBan varchar(10) not null unique, 
	-- Rang buoc suc chua phai lon hon 0 va be hon 100
	Check (sucChua > 0 and sucCHua < 100),
	sucChua smallint,
	-- Rang buoc trang thai cua ban
	-- 1 : ban trong
	-- 2: giu cho
	-- 3: dang phuc vu
	-- 4: bao tri
	trangThai smallint Check(trangThai >= 1 and trangThai <= 4)
	Primary key(maBan)
)
GO
-- Tao bang trang thai cho phieu dat
create table TrangThai (
	maTT int identity(1,1),
	tenTT nvarchar(100) not null unique,
	Primary key(maTT)
)
GO
-- Tao bang phieu dat
create table PhieuDatBan(
	maPD int identity(1,1),
	ngayVao date,
	gioVao time,
	maNV varchar(10),
	maTT int,
	maKH varchar(10),
	Primary key(maPD)
)
GO
-- Tao bang chi tiet phieu dat
create table CTPhieuDatBan(
	maCTPDB int identity(1,1),
	maBan int,
	maPD int,
	soLuongKhach smallint,
	ghiChu ntext,
	Primary key(maCTPDB)
)
GO
-- Tao bang phieu an
create table PhieuSDDV(
	maPSDDV int identity(1,1),
	ngayVao date,
	gioVao time,
	-- Phieu an co hai trang thai
	-- 0: chua thanh toan
	-- 1: da thanh toan
	trangThai bit not null,
	maNV varchar(10),
	maBan int,
	Primary key(maPSDDV)
)
GO
-- Tao bang chi tiet phieu an
create table CTPhieuSDDV(
	maCTPSDDV int identity(1,1),
	maDV int,
	maPSDDV int,
	soLuong int default 1,
	Primary key(maCTPSDDV)
)
GO
-- Tao bang mon an
create table DichVu(
	maDV int identity(1,1),
	tenDV nvarchar (255) not null,
	donGia bigint not null,
	trangThai bit not null,
	maLoaiDV int,
	Primary key (maDV)
)
GO
-- Tao bang loai mon an
create table LoaiDV (
	maLoaiDV int identity(1,1),
	tenLoaiDV nvarchar(100) not null unique,
	Primary key(maLoaiDV)
)
GO
-- Tao bang hoa don
create table HoaDon(
	maHoaDon int identity(1,1),
	tongTienDV bigint,
	tongTienKM bigint default 0,
	ngayRa date,
	gioRa time,
	maNV varchar(10),
	maPSDDV int,
	Primary key (maHoaDon)
)
GO
-- Tinh thanh tien cho hoa don
Alter table HoaDon
Add thanhTien AS (tongTienDV + tongTienKM)
Go
-- Tao bang khuyen mai
create table KhuyenMai(
	maKM int identity(1,1),
	tenKM varchar(255),
	ngayBD date,
	ngayKT date,
	mucGiam int,
	Primary key(maKM)
)
GO
-- Tao bang chi tiet khuyen mai
create table CTKhuyenMai(
	maCTKM int identity(1,1),
	maKM int,
	maDV int,
	Primary key (maCTKM)
)
GO
-- Tao bang khach hang
create table KhachHang(
	sdt varchar(10),
	tenKH nvarchar(10) not null,
	hoKH nvarchar (100),
	diaChi nvarchar(255),
	Primary key(sdt)
)
GO
-- Tao khoa ngoai
-- Khoa ngoai cho bang phieu dat ban
ALTER TABLE PhieuDatBan
	ADD CONSTRAINT PK_RS_1 
	Foreign key (maNV) 
	references NhanVien
	ON DELETE SET NULL;
	GO
ALTER TABLE PhieuDatBan
	ADD CONSTRAINT PK_RS_2 
	Foreign key (maTT) 
	references TrangThai;
	GO
ALTER TABLE PhieuDatBan
	ADD CONSTRAINT PK_RS_3 
	Foreign key (maKH) 
	references KhachHang;
	GO
-- Khoa ngoai cho CTPhieuDat
Alter table CTPhieuDatBan
	add constraint PK_RS_4
	foreign key (maBan)
	references Ban
	Go
ALTER TABLE CTPhieuDatBan
	ADD CONSTRAINT PK_RS_5 
	Foreign key (maPD) 
	references PhieuDatBan;
	GO
-- Khoa ngoai cho bang su dung dich vu
ALTER TABLE PhieuSDDV
	ADD CONSTRAINT PK_RS_6
	Foreign key (maNV) 
	references NhanVien;
	GO
-- Tao khoa ngoai cho bang chi tiet phieu su dung dich vu
ALTER TABLE CTPhieuSDDV
	ADD CONSTRAINT PK_RS_7
	Foreign key (maDV) 
	references DichVu;
	GO
ALTER TABLE CTPhieuSDDV
	ADD CONSTRAINT PK_RS_8
	Foreign key (maPSDDV) 
	references PhieuSDDV;
	GO
-- Tao khoa ngoai cho hoa don
ALTER TABLE HoaDon
	ADD CONSTRAINT PK_RS_9
	Foreign key (maNV) 
	references NhanVien;
	GO
ALTER TABLE HoaDon
	ADD CONSTRAINT PK_RS_10
	Foreign key (maPSDDV) 
	references PhieuSDDV;
	GO
-- Tao khoa ngoai cho bang chi tiet khuyen mai
ALTER TABLE CTKhuyenMai
	ADD CONSTRAINT PK_RS_11
	Foreign key (maKM) 
	references KhuyenMai;
	GO
ALTER TABLE CTKhuyenMai
	ADD CONSTRAINT PK_RS_12
	Foreign key (maDV) 
	references DichVu;
	GO
-- Tao khoa ngoai cho bang nhan vien
Alter table NhanVien
	Add constraint PK_RS_13
	Foreign key(maVaiTro)
	references VaiTro;
	Go
-- Tao khoa ngoai cho bang dich vu
Alter table DichVu
	Add constraint PK_RS_14
	Foreign key	(maLoaiDV)
	references LoaiDV;
	Go
-- Tao khoa ngoai cho bang nguoi quan ly
Alter table NguoiQL
	Add constraint PK_RS_15
	Foreign key (maNQL)
	references NhanVien
	Go
-- Bo sung: Them khoa ngoai cho su dung dich vu
Alter table PhieuSDDV
	Add constraint PK_RS_16
	Foreign key	(maBan)
	references Ban
	Go
-- Them du lieu cho cac bang
-- Vai tro
insert into vaiTro (tenVaiTro)
Values (N'Quản lý'),
	(N'Nhân viên')
Go
-- Nhan Vien
insert into NhanVien (maNV, tenNV, hoNV, sdt, diaChi, trangThai, matKhau, maVaiTro)
Values 
	('NV001', N'Thông', N'Nguyễn Ngọc', '0123456783', N'Vinh', 1, '1', 1),
	('NV002', N'Tiến', N'Nguyễn Đình', '0914655446', N'Quảng Trị', 1, '1', 2),
	('NV003', N'Toản', N'Nguyễn Quốc', '0342123323', N'DakLak', 1, '1', 2)
GO
-- Nguoi quan ly
insert into nguoiQL (maNQL, ngayBDQL, trangThai)
Values ('NV001', '20221101', 1)
Go
--Trang thai phieu dat
insert into TrangThai (tenTT)
Values
		(N'phiếu chỉ đặt'),
		(N'phiếu đã checkin'),
		(N'phiếu đã checkout'),
		(N'phiếu huỷ')
Go
-- Ban an
insert into Ban (soBan, sucChua, trangThai)
Values
	('1', 5, 1),
	('2', 4, 1),
	('3', 3, 1),
	('4', 6, 1),
	('5', 8, 1),
	('6', 10, 1),
	('7', 10, 1),
	('8', 2, 1),
	('9', 3, 1),
	('10', 4, 1),
	('11', 5, 1),
	('12', 4, 1),
	('13', 3, 1),
	('14', 6, 1),
	('15', 8, 1),
	('16', 10, 1),
	('17', 10, 1),
	('18', 2, 1),
	('19', 3, 1),
	('20', 4, 1),
	('21', 5, 1),
	('22', 4, 1),
	('23', 3, 1),
	('24', 6, 1),
	('25', 8, 1)
Go
-- khach hang
insert into KhachHang(tenKH, hoKH, sdt, diaChi)
Values
	(N'Tiên', N'Nguyễn', '1231234431', N'Vinh'),
	(N'Ngọc', N'Phạm', '1312421312', N'HN'),
	(N'Ánh', N'Dương', '0124123233', N'Huế'),
	(N'Vinh', N'Trần', '1294812123', N'TP.HCM'),
	(N'Lương', N'Lê văn', '1231412444', N'SS')
GO
-- Phieu dat ban
insert into PhieuDatBan(ngayVao, gioVao, maNV, maTT, maKH)
Values 
	('20221130','17:30','NV002',3,'1231234431'),
	('20221129','18:30','NV002',4,'1312421312'),
	('20221103','20:00','NV003',1,'0124123233'),
	('20221104','18:00','NV002',1,'1294812123'),
	('20221105','16:00','NV002',1,'1231412444')
GO
-- Chi tiet phieu dat ban
insert into CTPhieuDatBan (maBan, maPD, soLuongKhach)
Values (1, 1, 4),
	(2, 2, 5),
	(3, 3, 6),
	(4, 4, 3),
	(5, 5, 4)
GO
-- Loai Dich vu
insert into LoaiDV(tenLoaiDV)
Values (N'Món ăn'),
	(N'Đồ uống'),
	(N'Tiện ích')
-- Dich Vu
insert into DichVu(tenDV, donGia, trangThai, maLoaiDV)
Values	(N'Cá lóc um chua', 80000,1, 1),
	(N'Ếch xào sả ớt',90000 , 1, 1),
	(N'Đậu phụ chiên', 40000, 1, 1),
	(N'Tiger', 18000, 1, 2),
	(N'Bắp dê né', 100000, 1, 1),
	(N'Khăn ướt', 2000, 1, 3)
Go
-- Phieu su dung dich vu
insert into PhieuSDDV(ngayVao, gioVao, maNV, trangThai, maBan)
Values ('20221130', '17:30', 'NV003', 1, 1),
		('20221101', '18:00', 'NV003', 1, 2)
GO
-- Chi tiet phieu su dung dich vu
insert into CTPhieuSDDV(maDV, maPSDDV, soLuong)
 Values (1,1,2),
	(2,1,1),
	(4,1,24),
	(5,1,1),
	(1,2,1),
	(2,2,2),
	(3,2,3)
GO
-- Hoa don
insert into HoaDon(tongTienDV, ngayRa, gioRa, maNV, maPSDDV)
Values (782000, '20221031', '20:30', 'NV001', 1)

insert into HoaDon(tongTienDV, ngayRa, gioRa, maNV, maPSDDV)
Values (380000, '20221101', '20:00', 'NV002', 2)