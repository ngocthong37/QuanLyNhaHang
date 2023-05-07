create or alter proc capNhatThanhToan(@trangThai bit, @maPsddv int) 
AS
BEGIN
	update PhieuSDDV
	set trangThai = @trangThai
	where maPSDDV = @maPsddv
	Return 0
END
go



create or alter proc danhSachBanDaDat
as
begin
	select pd.maPD, hoKH, tenKH, soBan, sdt, gioVao, ngayVao, maTT, ghiChu
	from PhieuDatBan pd, CTPhieuDatBan ct, KhachHang kh, Ban ban
	where pd.maPD = ct.maPD and kh.sdt = pd.maKH and ban.maBan = ct.maBan and pd.maTT = 1
end

go
create or alter proc DanhSachBanDangHoatDong
as
begin
	select * from Ban
end

go
create or alter proc danhSachBanDatHomNay(@ngayHienTai date)
as
begin
	select pd.maPD, hoKH, tenKH, soBan, sdt, gioVao, ngayVao, maTT, ghiChu
	from PhieuDatBan pd, CTPhieuDatBan ct, KhachHang kh, Ban ban
	where pd.maPD = ct.maPD and kh.sdt = pd.maKH and ban.maBan = ct.maBan and pd.maTT = 1 and pd.ngayVao = @ngayHienTai

end

go
create or alter proc datBan
@sdt nvarchar(10), @tenKH nvarchar(10), @hoKH nvarchar(100)
as
begin
	insert into KhachHang(sdt, tenKH, hoKH)
	values(@sdt, @tenKH, @hoKH)

end
go

create or alter proc RS_DANH_SACH_MON_THEO_PSDDV @mapsddv int
as
begin
	Select DV.tenDV as 'ten dich vu', DV.donGia as 'don gia', CTPhieuSDDV.soLuong as 'so luong', CTPhieuSDDV.maPSDDV, Ban.maBan, Ban.soBan, DV.maLoaiDV as 'maLoaiDV', DV.maDV  
	From DichVu AS DV join (CTPhieuSDDV join (PhieuSDDV AS SD join Ban on SD.maBan = Ban.maBan) on CTPhieuSDDV.maPSDDV = SD.maPSDDV)  
	ON DV.maDV = CTPhieuSDDV.maDV
	Where SD.maPSDDV = @mapsddv and SD.trangThai = 0
end

go
create or alter proc RS_DAT_BAN_AN (@sdt varchar(10), @tenkh nvarchar(10), @hokh nvarchar(100), @ghiChu ntext, @ngayvao date, @giovao time, @maban int, @manv varchar(10), @soluong smallint)
as
begin
	DECLARE @maphieudat int
	-- Kiểm tra tồn tại khách hàng hay chưa
	IF not exists (SELECT * from KhachHang Where sdt = @sdt) 
	Begin
		-- Thêm mới một khách hàng
		insert into KhachHang (sdt, tenKH, hoKH)
		values (@sdt, @tenkh, @hokh)
		-- Kiểm tra ngày đó bàn còn trống không
		if not exists (
			Select * From PhieuDatBan AS PD, KhachHang AS KH, CTPhieuDatBan as ct, Ban
			Where PD.maKH = KH.sdt and pd.maPD = ct.maPD and ct.maBan = Ban.maBan and maTT = 1 and PD.ngayVao = @ngayvao and Ban.maBan = @maban
			)
			Begin
				-- Thêm phiếu
				insert into PhieuDatBan (ngayVao, gioVao, maNV, maTT, maKH)
				values (@ngayvao, @giovao, @manv, 1 , @sdt)
				-- Thêm chi tiết phiếu
				Select @maphieudat = PhieuDatBan.maPD from PhieuDatBan where @ngayvao = PhieuDatBan.ngayVao and @sdt = PhieuDatBan.maKH
				insert into CTPhieuDatBan(maBan, maPD, soLuongKhach, ghiChu)
				values (@maban, @maphieudat ,@soluong, @ghiChu)
			end

	end 
	else 
	begin
		-- kiểm tra xem khách đã đặt bàn trong ngày đó chưa
		if exists (
			Select * From PhieuDatBan AS PD, KhachHang AS KH, CTPhieuDatBan as ct, Ban
			Where PD.maKH = KH.sdt and pd.maPD = ct.maPD and ct.maBan = Ban.maBan and maTT = 1 and PD.ngayVao = @ngayvao and PD.maKH = @sdt
			)
			return 0
			-- Thêm phiếu đặt mới
				insert into PhieuDatBan (ngayVao, gioVao, maNV, maTT, maKH)
				values (@ngayvao, @giovao, @manv, 1 , @sdt)
				-- Thêm chi tiết phiếu
				Select @maphieudat = PhieuDatBan.maPD from PhieuDatBan where @ngayvao = PhieuDatBan.ngayVao and @sdt = PhieuDatBan.maKH
				insert into CTPhieuDatBan(maBan, maPD, soLuongKhach, ghiChu)
				values (@maban, @maphieudat ,@soluong, @ghiChu)

	end	
end
go
create or alter proc RS_THEM_MON_AN_CHO_KHACH @mapsddv int, @madichvu int, @soluong int
as
begin
	IF exists (Select * from CTPhieuSDDV where CTPhieuSDDV.maDV = @madichvu and CTPhieuSDDV.maPSDDV = @mapsddv)
		Begin
			Update CTPhieuSDDV
			Set soLuong = @soluong
			where CTPhieuSDDV.maDV = @madichvu and CTPhieuSDDV.maPSDDV = @mapsddv
			Return 0
		End
	Insert into CTPhieuSDDV (maPSDDV, maDV, soLuong)
	Values (@mapsddv, @madichvu, @soluong)
end
go
create or alter proc ThemPhieuDichVu (@ngayVao date, @gioVao time, @trangThai int, @maNV varchar(10),  @maBan int) 
as
	insert into PhieuSDDV (ngayVao, gioVao, trangThai, maNV, maBan)
	values(@ngayVao, @gioVao, @trangThai, @maNV, @maBan)

go

create or alter proc LayHoaDonTrongKhoangTG (@year int, @monthStart int, @monthEnd int, @maNV varchar(10), @maQuyen int)
as
begin
	if @maQuyen = 1
		begin
			 Select * from HoaDon 
				where YEAR(HoaDon.ngayRa) = @year
				and MONTH(HoaDon.ngayRa) >= @monthStart
				and MONTH(HoaDon.ngayRa) <= @monthEnd
		end
	if @maQuyen <> 1
		 Select * from HoaDon 
				where YEAR(HoaDon.ngayRa) = @year
				and MONTH(HoaDon.ngayRa) >= @monthStart
				and MONTH(HoaDon.ngayRa) <= @monthEnd
				and HoaDon.maNV = @maNV
end
go

create or alter proc RS_DANH_SACH_MON_THEO_PSDDV_DA_THANH_TOAN @mapsddv int
as
begin
	Select DV.tenDV as 'ten dich vu', DV.donGia as 'don gia', CTPhieuSDDV.soLuong as 'so luong', CTPhieuSDDV.maPSDDV, Ban.maBan, Ban.soBan, DV.maLoaiDV as 'maLoaiDV', DV.maDV  
	From DichVu AS DV join (CTPhieuSDDV join (PhieuSDDV AS SD join Ban on SD.maBan = Ban.maBan) on CTPhieuSDDV.maPSDDV = SD.maPSDDV)  
	ON DV.maDV = CTPhieuSDDV.maDV
	Where SD.maPSDDV = @mapsddv and SD.trangThai = 1
end
go


create or alter proc xoaPhieuDV(@maPSDDV int)
as 
begin
		
	delete from CTPhieuSDDV
	where CTPhieuSDDV.maPSDDV = @maPSDDV

	delete from PhieuSDDV
	where PhieuSDDV.maPSDDV = @maPSDDV
end
go

create or alter proc danhSachPhieuTheoNgay(@ngayVao date)
as
begin
	
	SELECT PhieuSDDV.maPSDDV, PhieuSDDV.ngayVao, PhieuSDDV.gioVao, trangThaiPhieu = PhieuSDDV.trangThai, Ban.maBan, Ban.soBan, Ban.trangThai, Ban.sucChua 
	from PhieuSDDV, Ban 
	Where PhieuSDDV.maBan = Ban.maBan and PhieuSDDV.trangThai = 0 and ngayVao = @ngayVao
end
go

create or alter proc capNhatTrangThaiBanDat(@maTT int, @maKH varchar(10), @maPD int)
as
begin
	update PhieuDatBan
	set maTT = @maTT
	where maKH = @maKH and maPD = @maPD
	return 0
end
go

create or alter proc capNhatThongTinDatHang(@sdtCu varchar(10), @sdtMoi varchar(10), @tenkh nvarchar(10), @hokh nvarchar(100), @ghiChu ntext, @ngayvao date, @giovao time, @maban int, @soluong smallint, @ngayVaoCu date, @maphieudat int)
as 
begin

	
	if (@sdtMoi = @sdtCu) 
		begin
			Update KhachHang set hoKH = @hoKH, tenKH = @tenKH where KhachHang.sdt = @sdtCu
			Update PhieuDatBan set ngayVao = @ngayvao, gioVao = @giovao where PhieuDatBan.maKH = @sdtCu and PhieuDatBan.maPD = @maphieudat
			Update CTPhieuDatBan set ghiChu = @ghiChu, maBan = @maban where CTPhieuDatBan.maPD = @maphieudat
			print @maphieudat
			print 'bang so'
		end
	else if exists(
		select * from KhachHang where KhachHang.sdt = @sdtMoi
	)
		begin
			return 0
		end
	else 
		begin
			print 'Thay doi sdt cu'
			Update KhachHang set hoKH = @hoKH, tenKH = @tenKH, sdt = @sdtMoi where KhachHang.sdt = @sdtCu
			Update PhieuDatBan set ngayVao = @ngayvao, gioVao = @giovao where PhieuDatBan.maKH = @sdtCu and PhieuDatBan.maPD = @maphieudat
			Update CTPhieuDatBan set ghiChu = @ghiChu , maBan = @maban where CTPhieuDatBan.maPD = @maphieudat
		end	
end
go

create or alter proc LayHoaDonTheoNam (@year int)
as
begin
		Select * from HoaDon
			where @year = YEAR(HoaDon.ngayRa)
end
go
