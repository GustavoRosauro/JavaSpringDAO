package com.example.JavaComDAO;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.colaborador.model.Colaborador;
import com.coloborador.dao.ColaboradorDAO;

@Controller
public class mainController {

	 private ColaboradorDAO _colaboradorDAO;
	  
	  public mainController() {
		  _colaboradorDAO = new ColaboradorDAO();
	  }
	@GetMapping("/index")
	public String index() {
		return "colaborador";
	}
	@GetMapping("/add")
	public String add(@RequestParam(required = false) String id) {
		return "adicionar";
	}
	@GetMapping("/colaboradores")
	public @ResponseBody List<Colaborador> teste() throws SQLException {
		return _colaboradorDAO.retornaColaboradores();
	}
	@PostMapping("/novoColaborador")
	public @ResponseBody void inserirColaborador(@Valid	@RequestBody Colaborador colaborador) throws SQLException {
		_colaboradorDAO.inserirNovoColaborador(colaborador);
	}
	@DeleteMapping("/removeColaborador/{id}")
	public @ResponseBody void removerColaborador(@Valid @PathVariable Integer id) throws SQLException {
		_colaboradorDAO.deletarColaborador(id);
	}
	@GetMapping("/colaborador/{id}")
	public @ResponseBody Colaborador retornaColaborador(@Valid @PathVariable Integer id) throws SQLException {
		return _colaboradorDAO.retornaColaborador(id);
	}
	@PutMapping("alterar/{id}")
	public @ResponseBody void alteraColaborador(@Valid @RequestBody Colaborador colaborador) throws SQLException{
		_colaboradorDAO.alterarColaborador(colaborador);
	}
}
