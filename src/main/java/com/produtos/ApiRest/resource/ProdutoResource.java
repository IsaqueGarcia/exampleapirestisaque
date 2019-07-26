package com.produtos.ApiRest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.ApiRest.models.Produto;
import com.produtos.ApiRest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//Adicionando o endpoint /api
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtorepository;
	
	//URI
	//Metodo requisitado pelo endpoint produtos.
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produto> listaProdutos(){
		return produtorepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Retorna um produto unico")
	public Produto produtoUnico(@PathVariable(value="id") long id) {
		return produtorepository.findById(id);
	}
	
	@PostMapping("/produtos")
	@ApiOperation(value="Salva um produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtorepository.save(produto);
	}
	
	@ApiOperation(value="Deleta um produto")
	@DeleteMapping("/produtos")
	public void deletaProduto(@RequestBody Produto produto) {
		produtorepository.delete(produto);
	}
	
	@PutMapping("/produtos")
	@ApiOperation(value="Atualiza um produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtorepository.save(produto);
	}
	
	
	
	
}
