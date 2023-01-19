package br.com.paulo.escola.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.paulo.escola.model.entity.Aluno;
import br.com.paulo.escola.model.entity.Professor;
import br.com.paulo.escola.model.enun.Materia;
import br.com.paulo.escola.model.repository.AlunoRepo;
import br.com.paulo.escola.model.repository.ProfRepo;

@Controller
@RequestMapping(path = "/Escola/Alunos")
public class AlunoControler {
	
	@Autowired
	private AlunoRepo repo;
	
	@Autowired
	private ProfRepo profRepo;
	
	@GetMapping(path = "/AdicionarAluno")
	public String newPro(Model model) {
		List<Professor> profs = profRepo.findAll();
		model.addAttribute("profs", profs);
		return "NovoAluno";
	}
	
	@PostMapping(path = "/anew")
	public String nnew(Aluno aluno) {
		repo.save(aluno);
		System.out.println("Aluno salvo!!!!!");
		return "redirect:/Escola/Alunos/TodosAlunos";
	}
	
	@GetMapping(path = "/TodosAlunos")
	public String lista(Model model) {
		List<Aluno> list = repo.findAll();
		model.addAttribute("Lista", list);
		return "ListaAlunos";
	}
	
	@GetMapping(path = "/deletarAluno/{id}")
	public String deletar(@PathVariable Integer id) {
		repo.deleteById(id);
		return "redirect:/Escola/Alunos/TodosAlunos";
	}
	
	@GetMapping(path = "/EditarAluno/{id}")
	public String viewEdit(@PathVariable Integer id, Model model) {
		Optional<Aluno> aluno = repo.findById(id);
		model.addAttribute("aluno", aluno);
		return "EditarAluno";
	}
	
	@PostMapping(path = "/saveEditAluno/{id}")
	public String salvar(@PathVariable Integer id, @Validated Aluno aluno ) {
		repo.save(aluno);
		return "redirect:/Escola/Alunos/TodosAlunos";
	}
	
}
