package webspringmvc.Service.User;

import org.springframework.stereotype.Service;

import webspringmvc.DTO.PaginateDTO;

@Service
public interface IPaginateService {
	public PaginateDTO GetInfoPaginate(int totalData, int limit, int currentPage);
}
