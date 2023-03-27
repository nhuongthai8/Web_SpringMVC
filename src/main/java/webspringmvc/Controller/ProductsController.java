package webspringmvc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import webspringmvc.DTO.PaginateDTO;
import webspringmvc.Service.User.LspServiceImpl;
import webspringmvc.Service.User.PaginateServiceImpl;
import webspringmvc.Service.User.ProductServiceImpl;

@Controller
public class ProductsController extends BaseController {
	@Autowired
	private LspServiceImpl lspService;
	@Autowired
	private PaginateServiceImpl paginateService;
	@Autowired
	private ProductServiceImpl productService;

	// =================================================================//

	@RequestMapping("/sanpham")
	public ModelAndView SanPham() {
		_mvShare.addObject("allsanpham", _homeService.GetDataAllSanpham());
		_mvShare.setViewName("user/sanpham");
		return _mvShare;
	}

	// =================================================================//
	//lấy sản phẩm theo id loại sản phẩm
	
	int totalSpOnPage = 9;

	@RequestMapping("/sanphamtheoloai/{id}")
	public ModelAndView SanPhamTheoLoai(@PathVariable String id) {
		_mvShare.setViewName("user/sanpham/sanphamtheoloai");
		int totalData = lspService.GetDataSanphamTLid(Integer.parseInt(id)).size();
		PaginateDTO paginateInfo = paginateService.GetInfoPaginate(totalData, totalSpOnPage, 1);
		_mvShare.addObject("idlsp", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("sptlpaginate",
				lspService.GetDataSanphamTLpaginate(Integer.parseInt(id), paginateInfo.getStart(), totalSpOnPage));
		return _mvShare;
	}

	@RequestMapping("/sanphamtheoloai/{id}/{currentPage}")
	public ModelAndView SanPhamTheoLoai(@PathVariable String id, @PathVariable Integer currentPage) {
		_mvShare.setViewName("user/sanpham/sanphamtheoloai");
		int totalData = lspService.GetDataSanphamTLid(Integer.parseInt(id)).size();
		PaginateDTO paginateInfo = paginateService.GetInfoPaginate(totalData, totalSpOnPage, currentPage);
		_mvShare.addObject("idlsp", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("sptlpaginate",
				lspService.GetDataSanphamTLpaginate(Integer.parseInt(id), paginateInfo.getStart(), totalSpOnPage));
		return _mvShare;
	}
	
	//=================================================================//
	//lấy sản phẩm theo id nhà cung cấp
	
	
	
	//=================================================================//
	
	@RequestMapping("/chitietsp/{id}")
	public ModelAndView ChitietSP(@PathVariable int id) {
		_mvShare.addObject("allsanpham", productService.GetSPid(id));
		int idCate = productService.GetSPid(id).getId_lsp();
		_mvShare.addObject("allsanphamrelated", productService.GetDataSanphamTLLienQuan(idCate));
		_mvShare.setViewName("user/sanpham/chitietsp"); 
		return _mvShare;
	}
	
	
}
