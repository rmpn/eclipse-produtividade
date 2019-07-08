package br.com.caelum.empresa.modelo;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Importador {
	public List<Gasto> importa(InputStream entrada) throws ParseException {
		
		Scanner leitor = new Scanner(entrada);
		List<Gasto> gastos = new ArrayList<Gasto>();
		
		while (leitor.hasNextLine()) {
			
			String line = leitor.nextLine();
			String tipoDespesaTXT = line.substring(0, 6);
			String dataDespesaTXT = line.substring(6, 14);
			String valorDespesaTXT = line.substring(14, 23);
			String matriculaTXT = line.substring(23, 26);
			String nomeTXT = line.substring(26, 56);
			String dataNascTXT = line.substring(56);
			double valor = Double.parseDouble(valorDespesaTXT);
			int matricula = Integer.parseInt(matriculaTXT);
			
			Calendar dataNascimento = converteDataTxtParaCalendar(dataNascTXT);
			Calendar dataDespesa = converteDataTxtParaCalendar(dataDespesaTXT);
			
			Funcionario funcionario = new Funcionario(nomeTXT, matricula, dataNascimento);
			gastos.add(new Gasto(valor, tipoDespesaTXT, funcionario, dataDespesa));
		}
		leitor.close();
		return gastos;
	}

	private Calendar converteDataTxtParaCalendar(String dataTXT) throws ParseException {
		
		Calendar data = Calendar.getInstance();
		data.setTime(new SimpleDateFormat("ddMMyyyy").parse(dataTXT));
		return data;
	}
}