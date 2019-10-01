package com.example.JavaComDAO;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String add() {
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
}
