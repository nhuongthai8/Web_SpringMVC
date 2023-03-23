package webspringmvc.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import webspringmvc.DTO.CartDTO;
import webspringmvc.Entities.Bills;

@Service
public interface IBillsService {
	public int AddBills(Bills bill);
	public void AddBillsDetail(HashMap<Integer, CartDTO> carts);
}
