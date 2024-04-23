package br.com.rh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rh.data.vo.departamento.DepartamentoVO;
import br.com.rh.mapper.DozerMapper;
import br.com.rh.model.Departamento;
import br.com.rh.repositorys.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public List<DepartamentoVO> listAll(){
		return DozerMapper.parseListObjects(departamentoRepository.findAll(), DepartamentoVO.class);
			    
	}
	
	
	public DepartamentoVO create(Departamento departamento) {
		return DozerMapper.parseObject(departamentoRepository.save(departamento), DepartamentoVO.class); 
	}
	
	
	public DepartamentoVO findById(Long id) {
		Departamento vo = departamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Departamento não encontrados"));		
		return DozerMapper.parseObject(vo, DepartamentoVO.class);
	}
	
	
	public DepartamentoVO update(Departamento departamento) {
		
		Departamento entity = departamentoRepository.findById(departamento.getId()).orElseThrow(() -> new RuntimeException("Departamento não encontrados"));
		entity.setFuncionarios(departamento.getFuncionarios());
		entity.setNome(departamento.getNome());
		entity.setResponsavel(departamento.getResponsavel());
		return DozerMapper.parseObject(departamentoRepository.save(entity), DepartamentoVO.class);
	}
	
	
	public void delete(Long id) {
		departamentoRepository.deleteById(id);
	}
	
}
