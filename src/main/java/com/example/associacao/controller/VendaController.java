package com.example.associacao.controller;

import com.example.associacao.model.entity.ItemVenda;
import com.example.associacao.model.entity.Produto;
import com.example.associacao.model.entity.Venda;
import com.example.associacao.model.respository.ProdutoRepository;
import com.example.associacao.model.respository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@Scope("request")
@RequestMapping("venda")
public class VendaController {

    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    Venda venda;


    @GetMapping("/additem")
    public ModelAndView additem(ItemVenda itemVenda) {
        //System.out.println("IDDDD:"+ itemVenda.getProduto().getId());

        Produto p = produtoRepository.findById(itemVenda.getProduto().getId()).get();
        itemVenda.setProduto(p);
        venda.getItensVenda().add(itemVenda);
        return  new ModelAndView("/venda/carrinho");
    }

    @GetMapping("/clear")
    public ModelAndView clear(){
        venda.getItensVenda().clear();
        return new ModelAndView("redirect:/venda/carrinho");
    }

    @GetMapping("/remove/{index}")
    public ModelAndView remove(@PathVariable("index") int index){
        venda.getItensVenda().remove(index);
        System.out.println("Tamanho: " + venda.getItensVenda().size());
        return new ModelAndView("redirect:/venda/carrinho");
    }

    @GetMapping ("carrinho")
    public ModelAndView carrinho(){
        return new ModelAndView("/venda/carrinho");
    }
}