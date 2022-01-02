package com.jnsdev.venda.venda;

import com.jnsdev.venda.boleto.Boleta;
import com.jnsdev.venda.notafiscal.NFe;

import java.lang.reflect.InvocationTargetException;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 17:07
 */
public class Venda {

    private NFe nFe;

    private Boleta boleta;

    public Venda(ModuloVendaFactory moduloVendaFactory) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.nFe = moduloVendaFactory.criarNFe();
        this.boleta = moduloVendaFactory.criarBoleta();
    }

    public void realizar(Produto produto) {
        System.out.println("Realizando uma venda");
        double imposto = nFe.calculaImposto(produto);
        nFe.gerar(produto, imposto);
        boleta.emitir(produto, imposto);
    }

    // Método utilizado para o teste unitário
    public double getImposto(Produto produto) {
        double imposto = nFe.calculaImposto(produto);
        return imposto;
    }

    public double getImpostoTotal(Produto produto) {
        double imposto = getImposto(produto) * produto.getQuantidade();
        return imposto;
    }

}
