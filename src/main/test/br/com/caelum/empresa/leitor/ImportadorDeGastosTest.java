package br.com.caelum.empresa.leitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.jupiter.api.Test;

import br.com.caelum.empresa.modelo.Gasto;

class ImportadorDeGastosTest {

	@Test
	void deveRetornarUmaListaVaziaSeArquivoPassadoForVazio() throws ParseException {

		ByteArrayInputStream input = new ByteArrayInputStream(new byte[0]);
		ImportadorDeGastos importador = new ImportadorDeGastos();
		Collection<Gasto> gastos = importador.importa(input);

		assertTrue("A lista não está vazia!", gastos.isEmpty());

	}

	@Test
	void deveRetornarUmGastoSeArquivoPassadoForCorreto() throws ParseException {

		String conteudo = "CARTAO01012011000010000123Jose da Silva                 22071983\r\n";
		ByteArrayInputStream input = new ByteArrayInputStream(conteudo.getBytes());
		ImportadorDeGastos importador = new ImportadorDeGastos();
		Collection<Gasto> gastos = importador.importa(input);

		assertEquals("Deveria retornar um elemento!", 1, gastos.size());

	}

}
