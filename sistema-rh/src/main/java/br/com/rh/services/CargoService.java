package br.com.rh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rh.data.vo.cargo.CargoVO;
import br.com.rh.mapper.DozerMapper;
import br.com.rh.model.Cargo;
import br.com.rh.repositorys.CargoRepository;

@Service
public class CargoService { 

	@Autowired
	private CargoRepository cargoRepository;
	
	
	public List<CargoVO> listAll() {
		return DozerMapper.parseListObjects(cargoRepository.findAll(), CargoVO.class);
	}
	
	
	public CargoVO creat(Cargo cargo) {
		return DozerMapper.parseObject(cargoRepository.save(cargo), CargoVO.class);
	}
	
	
	public CargoVO findById(Long id) {
		var vo = cargoRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado")); 
		return DozerMapper.parseObject(vo, CargoVO.class);
	}
	
	public CargoVO update(Cargo cargo) {
		var entity = cargoRepository.findById(cargo.getId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado para atualização"));
		entity.setNome(cargo.getNome());
		entity.setDescricao(cargo.getDescricao());
		return DozerMapper.parseObject(cargoRepository.save(entity), CargoVO.class);
	}
	

	public void delete(Long id) {
		cargoRepository.deleteById(id);
	}
	
	
}
