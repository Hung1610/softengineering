package bo;

import java.util.ArrayList;

import bean.KyNangBean;
import bean.KyNangNhanVienBean;
import bean.NhanVienBean;
import dao.KyNangNhanVienDao;
import dao.NhanVienDao;
import dao.ThongTinKyNangDao;

public class KyNangNhanVienBo {
	public ArrayList<KyNangNhanVienBean> ds = new ArrayList<KyNangNhanVienBean>();
	KyNangNhanVienDao kndao = new KyNangNhanVienDao();
	NhanVienDao nvDao = new NhanVienDao();
	ThongTinKyNangDao knDao = new ThongTinKyNangDao();
	public ArrayList<KyNangNhanVienBean> getListSkill() throws Exception
	{
		
		ds = kndao.getListSkill();
		return ds;
	}
	public int themKyNangNhanVien(String manv,String makn,String motakhac) throws Exception{
		for(KyNangNhanVienBean k : kndao.getListSkill()) {
			if(k.getMaNV().equals(manv) == true && k.getMaKyNang().equals(makn)==true)
				return 0;
		}
		kndao.themKyNangNhanVien(manv, makn, motakhac);
		return 1;
	}
	public String getTenNhanVien(String ma) throws Exception
	{
		ArrayList<NhanVienBean> dsNhanVien = nvDao.getNhanVien();
		for(NhanVienBean nv : dsNhanVien)
		{
			if(nv.getMaNhanVien().equals(ma))
			{
				return nv.getTenNhanVien();
			}
		}
		return null;
	}
	public String getTenKyNang(String ma) throws Exception
	{
		ArrayList<KyNangBean> dsKyNang = knDao.getKyNang();
		for(KyNangBean kn : dsKyNang)
		{
			if(kn.getMaKyNang().equals(ma))
			{
				return kn.getTenKyNang();
			}
		}
		return null;
	}
}
