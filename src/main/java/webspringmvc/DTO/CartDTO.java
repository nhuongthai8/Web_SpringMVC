package webspringmvc.DTO;

public class CartDTO {
	private int soluong;
	private double tongGia;
	private	SanphamDTO sanpham;
	
	
	public CartDTO() {
	}
	public CartDTO(int soluong, double tongGia, SanphamDTO sanpham) {
		this.soluong = soluong;
		this.tongGia = tongGia;
		this.sanpham = sanpham;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public double getTongGia() {
		return tongGia;
	}
	public void setTongGia(double tongGia) {
		this.tongGia = tongGia;
	}
	public SanphamDTO getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanphamDTO sanpham) {
		this.sanpham = sanpham;
	}
	
}
