package webspringmvc.Entities;

public class BillDetails {
	private int id;
	private int id_sp;
	private int id_bills;
	private double Quanty;
	private double Total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_sp() {
		return id_sp;
	}
	public void setId_sp(int id_sp) {
		this.id_sp = id_sp;
	}
	public int getId_bills() {
		return id_bills;
	}
	public void setId_bills(int id_bills) {
		this.id_bills = id_bills;
	}
	public double getQuanty() {
		return Quanty;
	}
	public void setQuanty(double quanty) {
		Quanty = quanty;
	}
	public double getTotal() {
		return Total;
	}
	public void setTotal(double total) {
		Total = total;
	}
	public BillDetails() {
		super();
	}
	
	
	
}
