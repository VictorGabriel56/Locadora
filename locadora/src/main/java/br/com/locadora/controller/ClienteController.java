package br.com.locadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.locadora.model.Cliente;
import br.com.locadora.model.Usuario;
import br.com.locadora.repository.filtros.FiltroUsuario;
import br.com.locadora.service.ClienteService;
import br.com.locadora.service.GrupoService;

@Controller
public class ClienteController {

	
	public static String CADASTRAR_CLIENTES = "/clientes/addClientes";
	
	public static String LISTAR_CLIENTES = "/clientes/clientes";

	@Autowired
	private ClienteService clienteServer;
	
	@Autowired
	private GrupoService grupoService;
	
	@GetMapping("/clientes")
	public ModelAndView findAll(@ModelAttribute("filtro") FiltroUsuario filtro) {		
		ModelAndView mv = new ModelAndView(LISTAR_CLIENTES);
		List<Cliente> clientes = (List<Cliente>) this.clienteServer.findOne(filtro);
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Cliente clientes) {
		ModelAndView mv = new ModelAndView(CADASTRAR_CLIENTES);
		mv.addObject("cliente", clientes);
		mv.addObject("grupos", this.grupoService.listAll());
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(usuarioServer.findOne(id));
	}
}
