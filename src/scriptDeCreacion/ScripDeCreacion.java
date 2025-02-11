package scriptDeCreacion;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Arrays;
import java.util.Random;

public class ScripDeCreacion {

	public static void main(String[] args) {
		principal();

		/*
		 * import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // Número entero aleatorio
        int numeroAleatorio = random.nextInt();
        System.out.println("Número entero aleatorio: " + numeroAleatorio);

        // Número entero aleatorio en el rango 0-99
        int numeroAleatorioRango = random.nextInt(100);
        System.out.println("Número entero aleatorio en el rango 0-99: " + numeroAleatorioRango);

        // Número decimal aleatorio entre 0.0 y 1.0
        double numeroAleatorioDecimal = random.nextDouble();
        System.out.println("Número decimal aleatorio entre 0.0 y 1.0: " + numeroAleatorioDecimal);

        // Número decimal aleatorio en el rango 0.0-10.0
        double numeroAleatorioRangoDecimal = 10.0 * random.nextDouble();
        System.out.println("Número decimal aleatorio en el rango 0.0-10.0: " + numeroAleatorioRangoDecimal);
    }
		 */
	}
	public static void generadorId() {
		
		int[] id = new int[200];
		int numero = 0;
		
		for (int i = 0 ; i<id.length ; i++) {
			
			Arrays.copyOf(id, id.length+1);
			
			id[id.length-1] = numero;
			numero++;
		
		}
	}

	public static String generarDni(){
		DecimalFormat formato = DecimalFormat.	


	}

	public static void Inmoviliaria(){
		Random random=new Random();

		String[] nombreInmoviliaria = {};
		String[] categorias = {"Regional","Nacional","Provincial","Internacional"};
		String paisSede = "España";
		/*nº oficinas */ 


	}






	public static void principal() {
		
		//Inmoviliaria
		String[] nombreInmoviliaria = {};
		String[] categorias = {"Regional","Nacional","Provincial","Internacional"};
		String paisSede = "España";
		/*nº oficinas */ 

		//oficina
		String[] direccion1={"Calle","Avenida","Paseo","Plaza","Bulevard",};
		String[] direccion2={"Adrián", "Beatriz", "Carlos", "Daniela", "Elena","Francisco", "Gabriela", "Hugo", "Isabel", "Javier","Karla", "Luis", "Marta", "Nicolás", "Macedonia","Pablo", "Raquel", "Samuel", "Teresa", "Víctor","Alicia", "Gavilla", "Clara", "Diego", "Eva","Félix", "Gloria", "Héctor", "Irene", "Joaquín"};
		/* cp generar 5 numeros */
		String[] localidad={"Valladolid","Barcelona","Valencia","Vezdemarban","Alcalá de Henares", "Aínsa", "Albarracín", "Cangas de Onís", "Comillas","Cuenca", "Frigiliana", "Laguardia", "Olite", "Potes","Ronda", "Santillana del Mar", "Trujillo", "Úbeda", "Zafra"};
		String[] provincias = {"Álava", "Albacete", "Alicante", "Almería", "Asturias","Ávila", "Badajoz", "Baleares", "Barcelona", "Burgos","Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real","Córdoba", "Cuenca", "Gerona", "Granada", "Guadalajara","Guipúzcoa", "Huelva", "Huesca", "Jaén", "La Coruña","La Rioja", "Las Palmas", "León", "Lérida", "Lugo","Madrid", "Málaga", "Murcia", "Navarra", "Orense","Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia","Sevilla", "Soria", "Tarragona", "Teruel", "Toledo","Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza"};

		//Persona
		/*generar 8 num y 1 char */
		/*utilizar direccion 2 */
		/* urar provincia y localidad */
		/*DNI generar 9 numerosw */


		
		
		
	}
	
}
