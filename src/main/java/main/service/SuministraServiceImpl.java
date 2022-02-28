package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.ISuministraDao;
import main.dto.Suministra;

@Service
public class SuministraServiceImpl implements ISuministraService{
	
	@Autowired
	ISuministraDao iSuministraDao;

	@Override
	public List<Suministra> listarSuministra() {
		// TODO Auto-generated method stub
		return iSuministraDao.findAll();
	}

	@Override
	public Suministra guardarSuministra(Suministra suministra) {
		// TODO Auto-generated method stub
		return iSuministraDao.save(suministra);
	}

	@Override
	public Suministra suministraXID(Long id) {
		// TODO Auto-generated method stub
		return iSuministraDao.findById(id).get();
	}

	@Override
	public Suministra actualizarSuministra(Suministra suministra) {
		// TODO Auto-generated method stub
		return iSuministraDao.save(suministra);
	}

	@Override
	public void eliminarSuministra(Long id) {
		// TODO Auto-generated method stub
		iSuministraDao.deleteById(id);
	}

}
