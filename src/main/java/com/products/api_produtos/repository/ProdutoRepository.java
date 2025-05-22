package com.products.api_produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.products.api_produtos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>  {

} 
