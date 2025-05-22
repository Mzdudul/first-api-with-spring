package com.products.api_produtos.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.products.api_produtos.exceptions.RecursoNaoEncontradoException;
import com.products.api_produtos.model.Produto;
import com.products.api_produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos(){
       return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID "+id+" não encontrado"));
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id){

        if(!produtoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com ID "+id+"não encontrado");
        }
        produtoRepository.deleteById(id);
    }
}
