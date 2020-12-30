package serviceimpl;

import dao.IAdminDao;
import dao.impl.Admindao;
import entity.Admin;
import services.IAdminService;

public class AdminService implements IAdminService {

	public Admin findByNameAndPdw(Admin admin) {
		IAdminDao adminDao=new Admindao();
		
		return adminDao.findByNameAndPwd(admin);
	}

	 

}
