package br.com.caelum.empresa;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import br.com.caelum.empresa.modelo.Gasto;
import br.com.caelum.empresa.leitor.Importador;

public class TestaImportador {

	public static void main(String[] args) throws UnsupportedEncodingException, ParseException {
//		String conteudo = "CARTAO01012011000010000123Jose da Silva                22071983\r\n"
//				+ "CARTAO01012011000010000123Jose da Silva                22071983\r\n"
//				+ "CARTAO01012011000010000123Jose da Silva                22071983\r\n";
//		
		
		String conteudo = 
                "CARTAO01012011000010000123Jose da Silva                 22071983\r\n" +
                "CARTAO01012011000010000123Jose da Silva                 22071983\r\n" +
                "CARTAO01012011000010000123Jose da Silva                 22071983\r\n";

		Importador importador = new Importador();

		Collection<Gasto> list = importador.importa(new ByteArrayInputStream(conteudo.getBytes("UTF-8")));


		
		for (Gasto gasto : list) {
//			System.out.println(gasto.getTipo());
//			System.out.println(gasto.getValor());
//			System.out.println(gasto.getFuncionario().getNome().trim());
			System.out.println(gasto);
		}
	}
}
