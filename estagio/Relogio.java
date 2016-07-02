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
	 */
	private static final byte anguloPorHora=30; /*360 graus divididos em 12 horas = 30 graus/hora*/
	private static final byte anguloPorMinuto=3; /*15 graus a cada 5 minutos, 3 graus a cada 1 minuto.*/

	
	/**
	 * Retorna o angulo entre os ponteiros (não sendo nescessariamenteo angulo convexo)
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
