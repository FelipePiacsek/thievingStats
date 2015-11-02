package br.com.puc.tcc.csp;

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
		switch (mes) {
		case JANUARY:
			diasNoMes = 31;
			break;
		case FEBRUARY:
			if (anoBissexto(ano)) {
				diasNoMes = 29;
			} else {
				diasNoMes = 28;
			}
			break;
		case MARCH:
			diasNoMes = 31;
			break;
		case APRIL:
			diasNoMes = 30;
			break;
		case MAY:
			diasNoMes = 31;
			break;
		case JUNE:
			diasNoMes = 30;
			break;
		case JULY:
			diasNoMes = 31;
			break;
		case AUGUST:
			diasNoMes = 31;
			break;
		case SEPTEMBER:
			diasNoMes = 30;
			break;
		case OCTOBER:
			diasNoMes = 31;
			break;
		case NOVEMBER:
			diasNoMes = 30;
			break;
		case DECEMBER:
			diasNoMes = 31;
			break;
		default:
			throw new RuntimeException("Fim dos tempos!");
		}
		return diasNoMes;
	}

	public static boolean anoBissexto(int ano) {
		return ((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0)));
	}

}
