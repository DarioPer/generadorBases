package scriptDeCreacion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class ScripDeCreacion {

	//variables estaticas para uso general
	private static String inicio="INSERT INTO equipo (", medio=") values (",fin=");";
	private static String[] dni={};
	private static String[] idInmoviliaria={};
	private static int[] cantidadOficinas={};
	private static int[] numeroViviendas={};

	private static String[] localidad={"Valladolid","Barcelona","Valencia","Vezdemarban","Alcalá de Henares", "Aínsa", "Albarracín", "Cangas de Onís", "Comillas","Cuenca", "Frigiliana", "Laguardia", "Olite", "Potes","Ronda", "Santillana del Mar", "Trujillo", "Úbeda", "Zafra"};
	//private static String[] provincias = {"Álava", "Albacete", "Alicante", "Almería", "Asturias","Ávila", "Badajoz", "Baleares", "Barcelona", "Burgos","Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real","Córdoba", "Cuenca", "Gerona", "Granada", "Guadalajara","Guipúzcoa", "Huelva", "Huesca", "Jaén", "La Coruña","La Rioja", "Las Palmas", "León", "Lérida", "Lugo","Madrid", "Málaga", "Murcia", "Navarra", "Orense","Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia","Sevilla", "Soria", "Tarragona", "Teruel", "Toledo","Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza"};
	private static String[] direccion1={"Calle","Avenida","Paseo","Plaza","Bulevard",};
	private static String[] direccion2={"Adrián", "Beatriz", "Carlos", "Daniela", "Elena","Francisco", "Gabriela", "Hugo", "Isabel", "Javier","Karla", "Luis", "Marta", "Nicolás", "Macedonia","Pablo", "Raquel", "Samuel", "Teresa", "Víctor","Alicia", "Gavilla", "Clara", "Diego", "Eva","Félix", "Gloria", "Héctor", "Irene", "Joaquín"};
	private static String[] apellidos = {"García", "Martínez", "López", "Sánchez", "Pérez", "González", "Rodríguez", "Fernández", "Gómez", "Ruiz","Hernández", "Jiménez", "Díaz", "Moreno", "Muñoz", "Álvarez", "Romero", "Alonso", "Gutiérrez", "Navarro","Torres", "Domínguez", "Vázquez", "Ramos", "Gil", "Ramírez", "Serrano", "Blanco", "Molina", "Morales","Suárez", "Ortega", "Delgado", "Castro", "Ortiz", "Rubio", "Marín", "Sanz", "Iglesias", "Núñez","Medina", "Garrido", "Cruz", "Calvo", "Gallego", "Vidal", "León", "Reyes", "Herrera", "Peña","Cabrera", "Flores", "Campos", "Vega", "Fuentes", "Carrasco", "Diez", "Caballero", "Nieto", "Aguilar"};
	




	public static void main(String[] args) {

			//Cantidates

			//inmobiliarias
			int numInmo=500;
			//personas
			int trabajadores=500;
			int inquilinos=1000;
			int propietarios=1000;


			//Variables dependientes
			int cantidadPersonas=trabajadores+inquilinos+propietarios;


			//llamada a los metodos
			Inmobiliaria(numInmo);
			oficina(numInmo);
			persona(cantidadPersonas);
			trabajador(trabajadores);
			Inquilino(inquilinos);
			propietarios(propietarios);



			//texto de finalizacion
			System.err.println("Finalizado");
		}
			
	
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
			
	
		public static void guardarDatos(String texto){
			try(BufferedWriter escritor=new BufferedWriter(new FileWriter("Poblador.sql",true))) {
				escritor.write(texto);
				escritor.flush();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		//clase que genera un DNI
		public static String generarDni(){
			DecimalFormat formato =new DecimalFormat("00000000");	
			Random random=new Random();
	
			int numero=random.nextInt(1,99999999);
			char letra=(char)random.nextInt(65,91);
			String salida="'"+formato.format(numero)+letra+"'";
			return salida;
		}
		//clase que crea la tabla inmobiliaria
		public static void Inmobiliaria(int numeroLineas){
			Random random=new Random();
	
			String[] Inmobiliarias = {
				"Global Realty", "Casa Bella", "Prime Properties", "Urban Nest", "Elite Estates",
				"Dream Homes", "Prestige Realty", "Horizon Homes", "Luxe Living", "Royal Realty",
				"Green Acres", "Blue Sky Realty", "Golden Gate Properties", "Silver Lining Realty", "Emerald Estates",
				"Diamond Realty", "Sapphire Homes", "Crystal Clear Realty", "Sunset Realty", "Sunrise Estates",
				"Ocean View Realty", "Mountain Peak Properties", "Riverfront Realty", "Lakeside Estates", "Cityscape Realty",
				"Suburban Homes", "Country Living Realty", "Urban Oasis", "Metro Realty", "Skyline Properties",
				"Landmark Realty", "Heritage Homes", "Classic Realty", "Modern Living", "Trendy Estates",
				"Chic Realty", "Elegant Homes", "Stylish Realty", "Cozy Nest Realty", "Family First Realty",
				"Community Realty", "Neighborhood Homes", "Friendly Realty", "Trustworthy Estates", "Reliable Realty",
				"Secure Homes", "Safe Haven Realty", "Comfort Realty", "Serenity Estates", "Peaceful Living Realty",
				"Urban Abodes", "Vista Realty", "Pinnacle Properties", "Opulent Estates", "Vintage Realty",
				"Majestic Homes", "Supreme Realty", "NextGen Realty", "Infinite Homes", "Bright Future Realty",
				"Urban Dreams", "Epic Realty", "Heavenly Homes", "Ultimate Realty", "Premium Properties",
				"Solid Foundations", "Zenith Realty", "Elysian Estates", "Infinite Realty", "Dreamland Homes",
				"Eternal Realty", "Bliss Homes", "Terra Firma Realty", "New Age Realty", "Veritas Realty",
				"Pure Realty", "Luminous Realty", "Vanguard Properties", "Serene Estates", "Harmonic Homes",
				"First Class Realty", "City Dreams", "Green Haven Realty", "Comfort Homes", "Gem Realty",
				"Affinity Realty", "Zen Homes", "Sky High Realty", "Crown Realty", "Essence Estates",
				"Aspire Realty", "Empire Realty", "Fortune Homes", "Infinite Possibilities Realty", "Legacy Realty",
				"Monarch Homes", "Enchanted Realty", "Brightside Realty", "Crescent Realty", "Cosmos Realty",
				"Radiant Realty", "Aurora Estates", "Prosperity Realty", "Valiant Homes", "Ace Realty",
				"Pillar Realty", "Apex Realty", "Nexus Realty", "Heritage Estates", "Noble Realty",
				"Harmony Realty", "Beacon Realty", "Pathway Realty", "Ambition Realty", "Civic Realty",
				"True Realty", "Victory Realty", "Generations Realty", "Perfection Realty", "Infinity Realty",
				"Elevation Realty", "Destiny Realty", "Aspiration Realty", "Sunlight Realty", "Dawn Realty",
				"Prospect Realty", "Distinctive Realty", "Core Realty", "Unity Realty", "Virtue Realty",
				"Sincere Realty", "Horizon Realty", "Divine Realty", "Dreamscape Realty", "Panorama Realty",
				"Symphony Realty", "Grace Realty", "Trust Realty", "Noble Estates", "Landmark Estates",
				"Prospect Estates", "Optimum Realty", "Foundation Realty", "Generous Realty", "Dynamic Realty",
				"Reflect Realty", "Humble Realty", "Premier Realty", "Legacy Estates", "Pioneer Realty",
				"Distinct Realty", "Genuine Realty", "Ascend Realty", "Remarkable Realty", "Ambitious Realty",
				"Realty Vision", "Serendipity Realty", "Prestige Estates", "Valued Realty", "Innovative Realty",
				"Realty One", "Golden Realty", "Infinite Estates", "Elevate Realty", "Clarity Realty",
				"Wealth Realty", "Momentum Realty", "Tranquil Realty", "Evolution Realty", "Empower Realty",
				"Legendary Realty", "Prime Realty", "Reliance Realty", "Catalyst Realty", "Realty Elite",
				"Horizon Estates", "Achieve Realty", "Realty Excellence", "Realty Prosper", "Integrity Realty",
				"Epic Estates", "Realty Inspired", "Apex Estates", "Unity Estates", "Symbiotic Realty",
				"Creative Realty", "Dynamic Estates", "Empower Estates", "Radiant Homes", "Revolution Realty",
				"Glory Realty", "Elite Homes", "Realty Prime", "Serenity Homes", "Royal Estates",
				"Resilient Realty", "Dream Estates", "Victory Estates", "Marvel Realty", "Infinity Estates",
				"Aspirations Realty", "Destined Realty", "Hopes Realty", "Optimistic Realty", "Uplift Realty",
				"Vision Realty", "Potential Realty", "Bright Realty", "Future Realty", "Prospect Estates",
				"Trustworthy Realty", "Reliable Estates", "Genuine Estates", "True Vision Realty", "Honest Realty",
				"Integrity Estates", "Noble Homes", "Horizon Homes", "Beyond Realty", "Pinnacle Estates",
				"Optimal Realty", "Dreams Realty", "Serenity Estates", "Legacy Homes", "Ambition Estates",
				"Achievers Realty", "Innovators Realty", "Success Realty", "Thriving Realty", "Triumph Realty",
				"Excellence Realty", "Peak Realty", "Prestige Realty", "Prime Estates", "Inspire Realty",
				"Bliss Estates", "Bright Horizon Realty", "Perfection Homes", "Eminent Realty", "Grand Realty",
				"Majestic Estates", "Realty Pinnacle", "Superior Realty", "Royalty Realty", "First Class Homes",
				"Benchmark Realty", "Diamond Realty", "Realty Champions", "Luxury Estates", "Premier Estates",
				"Elite Estates", "Kingdom Realty", "Crown Homes", "Supreme Estates", "Sovereign Realty",
				"Infinite Realty", "Prosper Realty", "Merit Realty", "Legendary Estates", "Infinity Homes",
				"Visionary Realty", "Distinguished Realty", "Dynamic Homes", "Ambition Homes", "Radiant Estates",
				"Realty Horizon", "Success Estates", "Innovation Realty", "Elevate Homes", "Ascension Realty",
				"Glory Estates", "Ultimate Realty", "Fortune Realty", "Prosperity Estates", "Realty Vanguard",
				"Heritage Realty", "Noble Vision Realty", "Dynamic Estates", "Premier Realty", "Elite Estates",
				"Apex Realty", "Crescent Realty", "Unity Realty", "Victory Estates", "Golden Realty",
				"Dream Realty", "Prestige Estates", "Inspire Homes", "Epic Realty", "Supreme Homes",
				"Realty Vision", "Foundation Estates", "Optimum Homes", "Serene Realty", "Noble Realty",
				"Pathway Realty", "Prospect Homes", "Honest Estates", "Vanguard Estates", "Realty Excellence",
				"Infinite Homes", "Potential Estates", "Catalyst Realty", "True Realty", "Bliss Realty",
				"Dream Estates", "Epic Vision Realty", "Victory Realty", "Prosper Homes", "Radiant Realty",
				"Sunrise Realty", "Sunset Realty", "Elevation Homes", "Innovative Estates", "Elite Realty",
				"Horizon Vision Realty", "Pure Realty", "Elegant Estates", "Realty Ascend", "Symphony Estates",
				"Zen Realty", "Ace Realty", "Affinity Estates", "Vision Estates", "Genuine Homes",
				"Dynamic Vision Realty", "Potential Realty", "Ascend Estates", "Momentum Realty", "Radiance Realty",
				"Trust Estates", "True Vision Realty", "Infinite Vision Realty", "Realty Ambition", "Serendipity Estates",
				"Pinnacle Realty", "Golden Estates", "Realty Legacy", "Noble Ventures Realty", "Dynamic Vision Realty",
				"Bright Future Estates", "Infinite Horizon Realty", "Victory Homes", "Realty Supreme", "Prime Vision Realty",
				"Innovative Vision Realty", "Prestige Homes", "Visionary Estates", "Elevate Vision Realty", "Legacy Realty",
				"Dynamic Vision Estates", "Prime Homes", "Innovative Ventures Realty", "Inspire Vision Realty", "Horizon Ventures Realty",
				"Victory Vision Realty", "Radiant Vision Realty", "Optimal Vision Realty", "Innovation Vision Realty", "Serene Vision Realty",
				"Premier Vision Realty", "Heritage Vision Realty", "Infinite Potential Realty", "Infinity Vision Estates", "Elite Vision Realty",
				"First Class Vision Realty", "Optimal Vision Estates", "Crescent Vision Realty", "Victory Ventures Realty", "Epic Vision Homes",
				"Legacy Vision Estates", "Legendary Vision Realty", "Aspire Vision Realty", "Ambition Vision Realty", "Noble Vision Estates",
				"Vision Ventures Realty", "Dynamic Potential Realty", "Success Vision Realty", "Pathway Vision Realty", "Symphony Vision Realty",
				"Unity Vision Realty", "Realty Prime Vision", "Vision Infinity Realty", "Elevation Vision Estates", "Crescent Vision Estates",
				"Optimal Ventures Realty", "Aspire Ventures Realty", "Brightside Vision Realty", "Serendipity Vision Realty", "Premier Homes",
				"Trustworthy Vision Realty", "Epic Potential Realty", "Inspire Potential Realty", "Prospect Vision Realty", "Heritage Potential Realty",
				"Radiant Potential Realty", "Dynamic Potential Estates", "Victory Potential Realty", "Noble Potential Estates", "Elite Potential"};
			String[] categorias = {"Regional","Nacional","Provincial","Internacional"};
			String paisSede = "España";
			/*nº oficinas */ 
			String salida="";
			int n0ficinas=0;
			for (int i = 0; i < numeroLineas; i++) {
				n0ficinas=random.nextInt(1,10);
				salida+=inicio+"idInmoviliaria,nombreComercial,categoria,nOficinas,paisSede"+medio+(i+1)+",'"+Inmobiliarias[random.nextInt(0,400)]+"',"+categorias[random.nextInt(4)]+","+n0ficinas+","+paisSede+fin+"\n";
				
				idInmoviliaria=Arrays.copyOf(idInmoviliaria, idInmoviliaria.length+1);
				idInmoviliaria[i]=i+"";
				cantidadOficinas=Arrays.copyOf(cantidadOficinas, cantidadOficinas.length+1);
				cantidadOficinas[i]=n0ficinas;
		}
		guardarDatos(salida);
		salida="";
	}
	//clase que crea la tabla oficina
	public static void oficina(int numeroLineas){
		//localidad-provincia
		HashMap<String, String> provinciaLocalidad = new HashMap<>();
        provinciaLocalidad.put("Valladolid", "Valladolid");
        provinciaLocalidad.put("Barcelona", "Barcelona");
        provinciaLocalidad.put("Valencia", "Valencia");
        provinciaLocalidad.put("Vezdemarban", "Valladolid");
        provinciaLocalidad.put("Alcalá de Henares", "Madrid");
        provinciaLocalidad.put("Aínsa", "Huesca");
        provinciaLocalidad.put("Albarracín", "Teruel");
        provinciaLocalidad.put("Cangas de Onís", "Asturias");
        provinciaLocalidad.put("Comillas", "Cantabria");
        provinciaLocalidad.put("Cuenca", "Cuenca");
        provinciaLocalidad.put("Frigiliana", "Málaga");
        provinciaLocalidad.put("Laguardia", "Álava");
        provinciaLocalidad.put("Olite", "Navarra");
        provinciaLocalidad.put("Potes", "Cantabria");
        provinciaLocalidad.put("Ronda", "Málaga");
        provinciaLocalidad.put("Santillana del Mar", "Cantabria");
        provinciaLocalidad.put("Trujillo", "Cáceres");
        provinciaLocalidad.put("Úbeda", "Jaén");
        provinciaLocalidad.put("Zafra", "Badajoz");
		//localidas-cp
		HashMap<String, String> localidadCodigoPostal = new HashMap<>();
        localidadCodigoPostal.put("Valladolid", "47001");
        localidadCodigoPostal.put("Barcelona", "08001");
        localidadCodigoPostal.put("Valencia", "46001");
        localidadCodigoPostal.put("Vezdemarban", "49800");
        localidadCodigoPostal.put("Alcalá de Henares", "28801");
        localidadCodigoPostal.put("Aínsa", "22330");
        localidadCodigoPostal.put("Albarracín", "44100");
        localidadCodigoPostal.put("Cangas de Onís", "33550");
        localidadCodigoPostal.put("Comillas", "39520");
        localidadCodigoPostal.put("Cuenca", "16001");
        localidadCodigoPostal.put("Frigiliana", "29788");
        localidadCodigoPostal.put("Laguardia", "01300");
        localidadCodigoPostal.put("Olite", "31390");
        localidadCodigoPostal.put("Potes", "39570");
        localidadCodigoPostal.put("Ronda", "29400");
        localidadCodigoPostal.put("Santillana del Mar", "39330");
        localidadCodigoPostal.put("Trujillo", "10200");
        localidadCodigoPostal.put("Úbeda", "23400");
        localidadCodigoPostal.put("Zafra", "06300");


		//Creacion
		
		String salida="";
		Random random=new Random();
		String loc="";

		for (int i = 0; i < numeroLineas; i++) {
			for (int j = 0; j < cantidadOficinas[i]; j++) {

				loc=localidad[random.nextInt(19)];

				salida+=inicio+"idInmoviliaria,idOficina,direccion,cp,localidad,provincia"+medio+(i+1)+","+(j+1)+",'"+direccion1[random.nextInt(5)]+" "+direccion2[random.nextInt(30)]+"',"+localidadCodigoPostal.get(loc)+",'"+loc+"','"+provinciaLocalidad.get(loc)+"',"+fin+"\n";
			}
			
		}
		guardarDatos(salida);
		salida="";
	}

	//clase que crea la tabla persona
	public static void persona(int numeroLinesa){

		Random random=new Random();

		String salida="";
		String dnii="";
		
		for (int i = 0; i < numeroLinesa; i++) {

			dnii=generarDni();
			dni=Arrays.copyOf(dni, dni.length+1);
			dni[i]=dnii;
			salida+=inicio+"dni,nombre,apellidos,telefono"+medio+dnii+",'"+direccion2[random.nextInt(30)]+"','"+apellidos[random.nextInt(60)]+"','"+random.nextInt(100000000,999999999)+"'"+fin+"\n";
		}
		guardarDatos(salida);
		salida="";

	}

	//clase que crea la tabla trabajador
	public static void trabajador(int numeroLineas){
		Random random=new Random();
		LocalDate fechaBaja;
		LocalDate fechaAlta;

		String[] tipoContrato = {"PorHoras","Fijo","Temporal","FijoDiscontinuo","PorCondicionesDeLaProduccion"};
		String salida="";
		for (int i = numeroLineas; i > 0; i--) {
			fechaAlta=LocalDate.of(random.nextInt(2000,2021), random.nextInt(1,13), random.nextInt(1,29));
			fechaBaja=LocalDate.of(random.nextInt(2000,2035), random.nextInt(1,13), random.nextInt(1,29));
			if (fechaBaja.isAfter(fechaAlta)) {
				salida+=inicio+"dni,tipoContrato,fechaBaja,salarioBrutoAnual"+medio+dni[dni.length-1]+",'"+fechaAlta.toString()+"','"+tipoContrato[random.nextInt(5)]+"','"+fechaBaja.toString()+"',"+random.nextInt(24500,255000)+fin+"\n";
				dni=Arrays.copyOf(dni, dni.length-1);
			}

		}
		guardarDatos(salida);
		salida="";
	}

	//clase que crea la tabla inquilino
	public static void Inquilino(int numeroLineas){
		Random random=new Random();
		String[] tipoInquilino={"'Particular'","'Empresa'"};
		String[] buscaOfertas={"'Si'","'No'"};

		String salida="";
		for (int i = numeroLineas; i > 0; i--) {

			salida+=inicio+"dni,tipoInquilino,buscaOfertas"+medio+dni[dni.length-1]+","+tipoInquilino[random.nextInt(2)]+","+buscaOfertas[random.nextInt(2)]+fin+"\n";
			dni=Arrays.copyOf(dni, dni.length-1);
		}
		guardarDatos(salida);
		salida="";
	}

	//clase que crea la tabla propietario
	public static void propietarios(int numeroLineas){
		Random random=new Random();
		String[] tipoCliente={"'Particular'","'Empresa'"};
		int nViviendas=0;
		String salida="";
		for (int i = numeroLineas; i > 0; i--) {

			numeroViviendas=Arrays.copyOf(numeroViviendas, numeroViviendas.length+1);
			nViviendas=random.nextInt(1,10);
			numeroViviendas[numeroViviendas.length-1]=nViviendas;

			salida+=inicio+"dni,tipoCliente,nViviendas"+medio+dni[dni.length-1]+","+tipoCliente[random.nextInt(2)]+","+nViviendas+fin+"\n";
			dni=Arrays.copyOf(dni, dni.length-1);
		}
		guardarDatos(salida);
		salida="";
	}
}
