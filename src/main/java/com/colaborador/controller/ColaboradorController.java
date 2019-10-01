package com.colaborador.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.colaborador.model.Colaborador;
import com.coloborador.dao.ColaboradorDAO;

@Controller
public class ColaboradorController {
	
  private ColaboradorDAO _colaboradorDAO;
  
  public ColaboradorController() {
	  _colaboradorDAO = new ColaboradorDAO();
  }
@GetMapping("/colaboradores")
public @ResponseBody List<Colaborador> RetornaColaboradores() throws SQLException{
	return _colaboradorDAO.retornaColaboradores();
}
}
