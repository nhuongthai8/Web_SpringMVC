package webspringmvc.DTO;

public class SanphamDTO {
	private int id;
	private int id_lsp;
	private int id_npp;
	private String TenSP;
	private String HinhSP;
	private double GiaSP;
	private String NoiDung;
	private int highlight;
	public SanphamDTO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_lsp() {
		return id_lsp;
	}
	public void setId_lsp(int id_lsp) {
		this.id_lsp = id_lsp;
	}
	public int getId_npp() {
		return id_npp;
	}
	public void setId_npp(int id_npp) {
		this.id_npp = id_npp;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public String getHinhSP() {
		return HinhSP;
	}
	public void setHinhSP(String hinhSP) {
		HinhSP = hinhSP;
	}
	public double getGiaSP() {
		return GiaSP;
	}
	public void setGiaSP(double giaSP) {
		GiaSP = giaSP;
	}
	public String getNoiDung() {
		return NoiDung;
	}
	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}
	public int getHighlight() {
		return highlight;
	}
	public void setHighlight(int highlight) {
		this.highlight = highlight;
	}
	
}
