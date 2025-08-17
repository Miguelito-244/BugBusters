package br.edu.ifpb.academico.EmpregadoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpb.academico.entity.Empregado;
import br.edu.ifpb.academico.service.EmpregadoService;

@Controller
@RequestMapping("/empregado")
public class EmpregadoController {

	@Autowired
	protected EmpregadoService empregadoService;
	
	@GetMapping("form")
	public String home(Model model) {
		model.addAttribute("empregado", new Empregado());
		return "cadastarEmpregado";
	}
	
	@PostMapping("save")
	public String saveEmpregado(@ModelAttribute Empregado empregado, Model model) {
		if (empregadoService.existsByEmail(empregado.getEmail())) {
			model.addAttribute("mensagemErro", "Empregado com email " + empregado.getEmail() + " já cadastrado.");
			return "cadastarEmpregado";
		}
		else{
			empregadoService.save(empregado);
		}
		model.addAttribute("mensagemSucesso", "Empregado com email " + empregado.getEmail() + " cadastrado com sucesso!");
		return "cadastarEmpregado";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmpregado(@PathVariable Long id, Model model) {
		Empregado empregado = empregadoService.findById(id);
		model.addAttribute("empregado", empregado);
		return "editarEmpregado";
	}
	
	@GetMapping("list")
	public String listEmpregados(Model model) {
		model.addAttribute("empregados", empregadoService.findAll());
		return "listarEmpregados";
	}
	
	@PostMapping("/edit")
	public String updateEmpregado(@ModelAttribute Empregado empregado, Model model) {
		if ((!empregadoService.findById(empregado.getId()).getEmail().equals(empregado.getEmail())) && empregadoService.existsByEmail(empregado.getEmail())) {
			model.addAttribute("mensagemErro", "Empregado com email " + empregado.getEmail() + " já cadastrado.");
			return listEmpregados(model);
		}
		else{
			empregadoService.save(empregado);
		}
		model.addAttribute("mensagemSucesso", "Empregado com email " + empregado.getEmail() + " atualizado com sucesso!");
		return listEmpregados(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmpregado(@PathVariable Long id, Model model) {
		Empregado empregado = empregadoService.findById(id);
		empregadoService.deleteById(id);
		model.addAttribute("mensagemSucesso", "Empregado do email: " + empregado.getEmail() + " deletado com sucesso!");
		return listEmpregados(model);
	}
}
