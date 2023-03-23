package webspringmvc.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webspringmvc.DAO.BillsDAO;
import webspringmvc.DTO.CartDTO;
import webspringmvc.Entities.BillDetails;
import webspringmvc.Entities.Bills;

@Service
public class BillServiceImpl implements IBillsService{

	@Autowired
	private BillsDAO billsDAO;
	
	@Override
	public int AddBills(Bills bill) {
		return billsDAO.AddBills(bill);	
	}

	@Override
	public void AddBillsDetail(HashMap<Integer, CartDTO> carts) {
		int idBills = billsDAO.GetIDLastBills();
		for(Map.Entry<Integer,CartDTO> itemCart : carts.entrySet()) {
			BillDetails billdetails = new BillDetails();
			billdetails.setId_sp(itemCart.getValue().getSanpham().getId());
			billdetails.setId_bills(idBills);
			billdetails.setQuanty(itemCart.getValue().getSoluong());
			billdetails.setTotal(itemCart.getValue().getTongGia());
			billsDAO.AddBillsDetail(billdetails);
		}
		
	}

}
