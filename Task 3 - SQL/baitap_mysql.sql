2. Yêu cầu cơ bản
Viết các câu lệnh SQL để tạo dữ liệu test + các câu lệnh SQL để giải quyết các bài toán sau =>
output gồm 2 file .sql: 1 file tạo dữ liệu test, 1 file chứa các câu lệnh query cho các yêu cầu bài
TO.
1. Hãy cho biết có những khách hàng nào lại chính là đối tác cung cấp hàng của công ty
(tức là có cùng tên giao dịch).

SELECT makhachhang, kh.tencongty, ncc.tengiaodich FROM khachhang kh JOIN nhacungcap ncc ON kh.tengiaodich = ncc.tengiaodich;
SELECT * FROM khachhang WHERE tengiaodich IN (SELECT tengiaodich FROM nhacungcap)

2. Những đơn đặt hàng nào yêu cầu giao hàng ngay tại cty đặt hàng và những đơn đó là
của công ty nào?

SELECT sohoadon, kh.makhachhang,kh.tencongty, kh.diachi FROM dondathang dh JOIN khachhang kh ON dh.makhachhang = kh.makhachhang 
WHERE dh.noigiaohang = kh.diachi;

3. Những mặt hàng nào chưa từng được khách hàng đặt mua?

SELECT * FROM mathang WHERE mahang 
NOT IN (SELECT mahang FROM chitietdathang);

4. Những nhân viên nào của công ty chưa từng lập bkhachhangdondathangkhachhangất kỳ một hoá đơn đặt hàng nào?
SELECT * FROM nhanvien WHERE manhanvien 
NOT IN (SELECT manhanvien FROM dondathang);

5. Trong năm 2003, những mặt hàng nào chỉ được đặt mua đúng một lần

SELECT c.mahang, d.sohoadon, d.ngaydathang FROM chitietdathang c JOIN dondathang d ON c.sohoadon=d.sohoadon 
WHERE YEAR(d.ngaydathang)='2003' 
GROUP BY mahang 
HAVING COUNT(*) = 1;

6. Hãy cho biết mỗi một khách hàng đã phải bỏ ra bao nhiêu tiền để đặt mua hàng của
công ty?

SELECT kh.makhachhang, SUM(ct.soluong*ct.giaban) FROM khachhang kh JOIN dondathang dh ON kh.makhachhang=dh.makhachhang	
															JOIN chitietdathang ct ON ct.sohoadon =  dh.sohoadon
															GROUP BY kh.makhachhang;
7. Mỗi một nhân viên của công ty đã lập bao nhiêu đơn đặt hàng (nếu nhân viên chưa hề
lập một hoá đơn nào thì cho kết quả là 0)

SELECT nv.manhanvien, COUNT(dh.manhanvien) AS sodondathang FROM nhanvien nv LEFT JOIN dondathang dh 
ON nv.manhanvien = dh.manhanvien GROUP BY nv.manhanvien

8. Cho biết tổng số tiền hàng mà cửa hàng thu được trong mỗi tháng của năm 2003 (thời
được gian tính theo ngày đặt hàng).

SELECT MONTH(ngaydathang) AS thang, SUM(c.soluong*c.giaban) AS doanhthu FROM chitietdathang c JOIN dondathang d ON c.sohoadon=d.sohoadon
WHERE YEAR(ngaydathang) = '2003'
GROUP BY MONTH(ngaydathang)

9. Hãy cho biết tổng số lượng hàng của mỗi mặt hàng mà cty đã có (tổng số lượng hàng
hiện có và đã bán).

select mahang,sum(soluong) as soluong
from(
    SELECT mahang,soluong
    from mathang
    union all
    SELECT mahang,soluong
    from chitietdathang
) t
group by mahang

10. Nhân viên nào của cty bán được số lượng hàng nhiều nhất và số lượng hàng bán được
của nhân viên này là bao nhiêu?

SELECT manhanvien, SUM(ct.soluong) AS soluong FROM dondathang dh 
JOIN chitietdathang ct ON dh.sohoadon=ct.sohoadon 
GROUP BY dh.manhanvien 
order BY soluong DESC
LIMIT 1

11. Mỗi một đơn đặt hàng đặt mua những mặt hàng nào và tổng số tiền mà mỗi đơn đặt
hàng phải trả là bao nhiêu?

12. Hãy cho biết mỗi một loại hàng bao gồm những mặt hàng nào, tổng số lượng hàng của
mỗi loại và tổng số lượng của tất cả các mặt hàng hiện có trong công ty là bao nhiêu?

SELECT * FROM mathang
WHERE maloaihang =1

13. Thống kê xem trong năm 2003, mỗi một mặt hàng trong mỗi tháng và trong cả năm bán
được với số lượng bao nhiêu.

SELECT ct.mahang, SUM(soluong) AS soluong FROM dondathang dh JOIN chitietdathang ct ON dh.sohoadon=ct.sohoadon
WHERE YEAR(ngaydathang)='2003'
GROUP BY mahang


14. Cập nhật lại giá trị NGAYCHUYENHANG của những bản ghi có giá trị
NGAYCHUYENHANG chưa xác định (NULL) trong bảng DONDATHANG bằng với giá
trị của trường NGAYDATHANG.

UPDATE dondathang 
SET ngaychuyenhang=ngaydathang
WHERE ngaychuyenhang IS NULL

15. Cập nhật giá trị của trường NOIGIAOHANG trong bảng DONDATHANG bằng địa chỉ
của khách hàng đối với những đơn đặt hàng chưa xác định được nơi giao hàng (có giá
trị trường NOIGIAOHANG bằng NULL)
UPDATE dondathang dh
LEFT JOIN khachhang kh ON dh.makhachhang=kh.makhachhang
SET dh.noigiaohang=kh.diachi
WHERE dh.noigiaohang IS null

16. Cập nhật lại dữ liệu trong bảng KHACHHANG sao cho nếu tên công ty và tên giao dịch
của khách hàng trùng với tên công ty và tên giao dịch của một nhà cung cấp nào đó thì
địa chỉ, điện thoại, fax và email phải giống nhau.

UPDATE khachhang kh, nhacungcap ncc
SET kh.diachi=ncc.diachi, kh.dienthoai=ncc.dienthoai,kh.fax=ncc.fax,kh.email=ncc.email
WHERE kh.tencongty=ncc.tencongty AND kh.tengiaodich=ncc.tengiaodich

17. Tăng lương lên gấp rưỡi cho những nhân viên bán được số lượng hàng nhiều hơn 100
trong năm 2003

SELECT dh.manhanvien, ((nv.luongcoban+nv.phucap)+nv.luongcoban*0.5) AS luong150, SUM(ct.soluong) AS soluonghangban FROM dondathang dh 
JOIN chitietdathang ct ON dh.sohoadon=ct.sohoadon
JOIN nhanvien nv ON dh.manhanvien = nv.manhanvien 
WHERE YEAR(dh.ngaydathang)='2003'
GROUP BY dh.manhanvien 
HAVING soluonghangban > 100

18. Tăng phụ cấp lên bằng 50% lương cho những nhân viên bán được hàng nhiều nhất.

SELECT nv.manhanvien, ((nv.luongcoban+nv.phucap)+nv.phucap*0.5) AS phucap150, COUNT(dh.manhanvien) AS sodondathang FROM nhanvien nv LEFT JOIN dondathang dh 
ON nv.manhanvien = dh.manhanvien GROUP BY nv.manhanvien
ORDER BY sodondathang DESC
LIMIT 1

19. Giảm 25% lương của những nhân viên trong năm 2003 ko lập được bất kỳ đơn đặt
hàng nào

SELECT nv.manhanvien, (nv.luongcoban+nv.phucap) AS luong, ((nv.luongcoban+nv.phucap)-nv.luongcoban*0.25) AS luongGiam25, COUNT(dh.manhanvien) AS sodondathang FROM nhanvien nv LEFT JOIN dondathang dh 
ON nv.manhanvien = dh.manhanvien 
GROUP BY nv.manhanvien 
HAVING  COUNT(dh.manhanvien) = 0

20. Giả sử trong bảng DONDATHANG có them trường SOTIEN cho biết số tiền mà khách
hàng phải trả trong mỗi dơnđặt hàng. Hãy tính giá trị cho trường này.

SELECT dh.sohoadon, SUM(ct.soluong*ct.giaban) AS SOTIEN FROM dondathang dh 
left JOIN chitietdathang ct ON dh.sohoadon=ct.sohoadon 
GROUP BY dh.sohoadon

21. Xoá khỏi bảng MATHANG những mặt hàng có số lượng bằng 0 và không được đặt mua
trong bất kỳ đơn đặt hàng nào.
DELETE FROM mathang WHERE soluong=0 AND mahang NOT IN (SELECT mahang FROM chitietdathang)

3. Yêu cầu nâng cao
1. Tạo thủ tục lưu trữ để thông qua thủ tục này có thể bổ sung thêm một bản ghi mới cho
bảng MATHANG (thủ tục phải thực hiện kiểm tra tính hợp lệ của dữ liệu cần bổ sung:
không trùng khoá chính và đảm bảo toàn vẹn tham chiếu)
DELIMITER $$
CREATE PROCEDURE proc_insert(IN imahang VARCHAR(10), 
										IN itenhang VARCHAR(50), 
										IN imacongty VARCHAR(10), 
										IN imaloaihang INT(11),
										IN isoluong INT(11), 
										IN idonvitinh VARCHAR(20), 
										IN igiahang DECIMAL(10,0),
										OUT message VARCHAR(50))
BEGIN

	DECLARE pk_mahang varchar(50) DEFAULT null;
	DECLARE fk_macongty varchar(50) DEFAULT null;
	DECLARE fk_maloaihang int(50) DEFAULT -1;
	SELECT mahang INTO pk_mahang FROM mathang WHERE mahang=imahang;
	SELECT macongty INTO fk_macongty FROM nhacungcap WHERE macongty=imacongty;
	SELECT maloaihang INTO fk_maloaihang FROM loaihang WHERE maloaihang=imaloaihang;
   
   IF(pk_mahang IS NOT NULL) THEN
   	SET message = "Ma hang da ton tai";
   ELSEIF(fk_macongty IS NULL) THEN
   	SET message = "Ma cong ty khong ton tai";
   ELSEIF(fk_maloaihang <=0) THEN
   	SET message = "Ma loai hang khong ton tai";
   ELSE
   	INSERT INTO mathang VALUES (imahang, itenhang, imacongty, imaloaihang, isoluong, idonvitinh, igiahang);
   	SET message = "Insert thanh cong";
   END if;
END; $$
DELIMITER ;

CALL proc_insert('34', 'insert with proc','1',1,10,'tập',100000, @message);
SELECT @message AS notice;

2. Tạo thủ tục lưu trữ có chức năng thống kê tổng số lượng hàng bán được của một mặt
hàng có mã bất kỳ (mã mặt hàng cần thống kê là tham số của thủ tục).

DELIMITER $$
CREATE PROCEDURE proc_cau2(IN imahang VARCHAR(10))
BEGIN
	SELECT mahang, SUM(soluong) AS tongsoban FROM chitietdathang WHERE mahang=imahang;
END; $$
DELIMITER ;

CALL proc_cau2('2');

3. Viết trigger cho bảng CHITIETDATHANG theo yêu cầu sau:
 Khi một bản ghi mới được bổ sung vào bảng này thì giảm số lượng hàng hiện có nếu
số lượng hàng hiện có lớn hơn hoặc bằng số lượng hàng được bán ra. Ngược lại thì
huỷ bỏ thao tác bổ sung.
 Khi cập nhật lại số lượng hàng được bán, kiểm tra số lượng hàng được cập nhật lại có
phù hợp hay không (số lượng hàng bán ra không được vượt quá số lượng hàng hiện
có và không được nhỏ hơn 1). Nếu dữ liệu hợp lệ thì giảm (hoặc tăng) số lượng hàng
hiện có trong công ty, ngược lại thì huỷ bỏ thao tác cập nhật.

DELIMITER $$
CREATE TRIGGER trigger_cau3_insert
BEFORE INSERT ON chitietdathang
FOR EACH ROW
BEGIN 
	DECLARE hanghienco INT;
	SELECT soluong INTO hanghienco FROM mathang WHERE mahang = NEW.mahang;
	
	if(NEW.soluong < hanghienco AND NEW.soluong >=1) THEN
		UPDATE mathang
		SET soluong = hanghienco-NEW.soluong
		WHERE mahang = NEW.mahang;
	ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'So luong hang ban ra khong phu hop';
	END if;
END; $$
DELIMITER ;

INSERT INTO chitietdathang VALUES (3,'2',12000,2,30);

SELECT * from chitietdathang;
SELECT * FROM mathang;

4. Viết trigger cho bảng CHITIETDATHANG để sao cho chỉ chấp nhận giá hàng bán ra
phải nhỏ hơn hoặc bằng giá gốc (giá của mặt hàng trong bảng mathang)

DELIMITER $$
CREATE TRIGGER trigger_cau4
BEFORE INSERT ON chitietdathang
FOR EACH ROW
BEGIN
	DECLARE root_cost INT;
	SELECT giahang INTO root_cost FROM mathang WHERE mahang = NEW.mahang;
	IF(NEW.GIABAN <=0) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Gia ban phai lon hon 0';
	ELSEIF(NEW.giaban > root_cost) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Gia ban ra khong phu hop';
	END if;
END; $$
DELIMITER ;


