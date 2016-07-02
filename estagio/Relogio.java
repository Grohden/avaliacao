import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * Autor: Gabriel Rohden
 * Nota: geralmente escrevo os meus codigos e comentarios em ingles,
 * porem não há nescessidade neste caso.
 */
public class Relogio {
	/* Constantes para ajuda nos calculos 
	 * Usei byte pois aloca 8 bits, e isso ja é o bastante visto que
	 * o numero maximo de 8 bits é 255.
	 *
	 * 360 graus divididos em 12 horas = 30 graus/hora 
	 */
	private static final byte anguloPorHora=30; 
	/*
	 * Aparentemente a descriçao da prova esta errada
	 * Quando o horario for 00:15 o angulo dos ponteiros sera 90 graus
	 * com 00:59 minutos teriamos um angulo de 177 graus no caso acima. (nao considerando movimento do pnteiro das horas em relaçao aos minutos)
	 * Caso seja assim, entao o "circulo(??)" teria so 180 graus, e o calculo
	 * do anguloPorHora seria  180/12.
	 * O calculo da variavel abaixo deveria ser feito como 360 graus / 60 minutos
	 * Nao sei se foi proposital, entao deixarei o correto.
	 */
	private static final byte anguloPorMinuto=6; 

	
	/**
	 * Retorna o angulo entre os ponteiros (não sendo nescessariamente o angulo convexo)
	 * dos minutos e das horas do horário local em graus.
	 *
	 * @param  horario calendario gregoriano contendo a hora e minuto a ser calculado.
	 * @return angulo formado pelos dois ponteiros do relogio
	 */
	public long retornaAnguloRelogio(GregorianCalendar horario){
		Calendar calendario = Calendar.getInstance(horario.getTimeZone());
		
		int horas=calendario.get(Calendar.HOUR);
		int minutos=calendario.get(Calendar.MINUTE);

		/*
		 * Caso fosse nescessario calcular o exato angulo 
		 * levando os minutos em consideraçao para o calculo
		 * adicionando a linha abaixo no respectivo calculo das horas resolve. 
		 * +((minutos*anguloPorHora)/60);
		 */
		float anguloPonteiroHoras=(anguloPorHora*horas); 
		float anguloPonteiroMinutos=anguloPorMinuto*minutos;
		
		long anguloEntreOsPonteiros=(long) Math.abs(anguloPonteiroMinutos-anguloPonteiroHoras);		
		return anguloEntreOsPonteiros;
	}
}
