package br.com.locadora.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.locadora.model.Cliente;
import br.com.locadora.model.Usuario;
import br.com.locadora.repository.filtros.FiltroUsuario;
import br.com.locadora.service.ClienteService;

@Controller
public class ClienteController {
	public static String CADASTRAR_CLIENTES = "/clientes/addClientes";
	
	public static String LISTAR_CLIENTES = "/clientes/clientes";
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clientes")
	public ModelAndView findAll() {		
		ModelAndView mv = new ModelAndView(LISTAR_CLIENTES);
		List<Cliente> clientes = clienteService.listar();
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	@GetMapping("/addCliente")
	public ModelAndView adicionar(Cliente cliente) {
		ModelAndView mv = new ModelAndView(CADASTRAR_CLIENTES);
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@PostMapping("/saveCliente")
	public ModelAndView save(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView(LISTAR_CLIENTES);
		clienteService.save(cliente);
		List<Cliente> clientes = clienteService.listar();
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	@GetMapping("/deleteCliente/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mvRedirect = new  ModelAndView("redirect:/clientes");
		clienteService.remove(id);
		attributes.addFlashAttribute("sucesso", "Cliente removido com sucesso!");
		return mvRedirect;
	}
	
	@GetMapping("/editClientes/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return adicionar(clienteService.search(id));
	}
}