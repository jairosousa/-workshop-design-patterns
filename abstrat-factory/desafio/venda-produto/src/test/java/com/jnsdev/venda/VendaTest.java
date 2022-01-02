package com.jnsdev.venda;

import com.jnsdev.venda.venda.Produto;
import com.jnsdev.venda.venda.Venda;
import com.jnsdev.venda.venda.loja.LojaFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 17:13
 */
public class VendaTest {

    private Venda venda;

    private Produto produto;

    @Before
    public void start() {
        produto = new Produto();
        produto.setNome("Geladeira");
        produto.setQuantidade(2);
        produto.setValorUnitario(new BigDecimal("1000"));
    }

    @Test
    public void deveGerarVendaEmitirNotaSPeBoletoBB() throws ClassNotFoundException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        LojaFactory factory = new LojaFactory("sp", "bb");
        venda = new Venda(factory);

        venda.realizar(produto);

        Assert.assertEquals(new BigDecimal("2600").doubleValue(),produto.getValorTotal(venda.getImposto(produto)),0.0001);
        Assert.assertEquals(new BigDecimal("600").doubleValue(),venda.getImpostoTotal(produto),0.0001);

    }

    @Test
    public void deveGerarVendaEmitirNotaMGeBoletoCef() throws ClassNotFoundException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        LojaFactory factory = new LojaFactory("mg", "cef");
        venda = new Venda(factory);

        venda.realizar(produto);
        Assert.assertEquals(new BigDecimal("2300").doubleValue(),produto.getValorTotal(venda.getImposto(produto)),0.0001);
        Assert.assertEquals(new BigDecimal("300").doubleValue(),venda.getImpostoTotal(produto),0.0001);

    }
}
