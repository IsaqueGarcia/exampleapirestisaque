package com.produtos.ApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.ApiRest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	//Tipo de retorno produto
	Produto findById(long id);
	
}
