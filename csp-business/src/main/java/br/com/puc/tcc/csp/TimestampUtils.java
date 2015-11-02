package br.com.puc.tcc.csp;

import static java.time.Month.APRIL;
import static java.time.Month.AUGUST;
import static java.time.Month.DECEMBER;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;
import static java.time.Month.JULY;
import static java.time.Month.JUNE;
import static java.time.Month.MARCH;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Month;

public class TimestampUtils {

	public static Timestamp primeiroDiaMesPassado() {
		int ano = LocalDate.now().getYear();
		Month mesPassado = LocalDate.now().getMonth().minus(1);
		int primeiroDia = 1;
		
		LocalDate localDate = LocalDate.of(ano, mesPassado, primeiroDia);
		return Timestamp.valueOf(localDate.atStartOfDay());
	}

	public static Timestamp ultimoDiaMesPassado() {
		int ano = LocalDate.now().getYear();
		Month mesPassado = LocalDate.now().getMonth().minus(1);
		int ultimoDiaDoMes = diasNoMes(ano, mesPassado);

		LocalDate localDate = LocalDate.of(ano, mesPassado, ultimoDiaDoMes);
		return Timestamp.valueOf(localDate.atStartOfDay());
	}

	public static int diasNoMes(int ano, Month mes) {
		int diasNoMes = 0;
		
		if(mes.equals(JANUARY) || mes.equals(MARCH) || mes.equals(MAY) || mes.equals(JULY) 
		|| mes.equals(AUGUST) || mes.equals(Month.OCTOBER) || mes.equals(DECEMBER)){
			diasNoMes = 31;
		}else if(mes.equals(APRIL) || mes.equals(JUNE) || mes.equals(Month.SEPTEMBER) || mes.equals(NOVEMBER)){
			diasNoMes = 30;
		}else if(mes.equals(FEBRUARY)){
			if (anoBissexto(ano)) {
				diasNoMes = 29;
			} else {
				diasNoMes = 28;
			}
		}else{
			throw new RuntimeException("Fim dos tempos!");
		}
		
		return diasNoMes;
	}

	public static boolean anoBissexto(int ano) {
		return ((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0)));
	}

}
