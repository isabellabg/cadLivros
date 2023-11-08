package com.senai.IsabellaBorges.PrjLivro.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.senai.IsabellaBorges.PrjLivro.entities.Livro;
import com.senai.IsabellaBorges.PrjLivro.repositories.LivroRepository;

@Service
public class LivroService {
private final LivroRepository livroRepository;

	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}

	public Livro getLivroById(Long id) {
		return livroRepository.findById(id).orElse(null);
	}

	public Livro getProdutoById(long id) {
		return livroRepository.findById(id).orElse(null);
	}

	public List<Livro> getAllLivro(){
		return livroRepository.findAll();
	}

	public void deletLivro(Long id) {
		livroRepository.deleteById(id);
	}

//fazendo o update do jogo com o optional

	public Livro updateLivro(Long id, Livro novoLivro) {
	Optional<Livro> livroOptional = livroRepository.findById(id);
	    
	 if (livroOptional.isPresent()) {
	     Livro livroExistente = livroOptional.get();
	     livroExistente.setDescricao(novoLivro.getDescricao());
	     livroExistente.setisbn(novoLivro.getIsbn());
	     return livroRepository.save(livroExistente);
	 } else {
		 return null;
	 }
}
	
}
