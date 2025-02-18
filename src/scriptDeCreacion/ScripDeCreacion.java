package scriptDeCreacion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;


//dni pago esta mal referenciado conta
public class ScripDeCreacion {

	//variables estaticas para uso general
	private static String inicio="INSERT INTO ",inicio2=" (", medio=") values (",fin=");";
	private static String[] dni={};
	private static String[] dniInquilino={};
	private static String[] dni3={};
	private static String[] domicilios={};
	private static String[] oficinas={};
	private static int[] localidadesVivienda={};
	private static String[] idInmoviliaria={};
	private static int[] cantidadOficinas={};
	private static int[] numeroViviendas={};
	private static String[][] DtContrato={{}};

	private static String[] localidad={"Valladolid","Barcelona","Valencia","Vezdemarban","Alcalá de Henares", "Aínsa", "Albarracín", "Cangas de Onís", "Comillas","Cuenca", "Frigiliana", "Laguardia", "Olite", "Potes","Ronda", "Santillana del Mar", "Trujillo", "Úbeda", "Zafra", "Bilbao", "Sevilla", "Granada", "Salamanca", "Toledo", "Burgos", "León", "Zaragoza", "Málaga", "Murcia", "Pamplona", "Logroño", "Santander", "Cádiz", "Huelva", "Almería", "San Sebastián", "Gijón", "Oviedo"};
	//private static String[] provincias = {"Álava", "Albacete", "Alicante", "Almería", "Asturias","Ávila", "Badajoz", "Baleares", "Barcelona", "Burgos","Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real","Córdoba", "Cuenca", "Gerona", "Granada", "Guadalajara","Guipúzcoa", "Huelva", "Huesca", "Jaén", "La Coruña","La Rioja", "Las Palmas", "León", "Lérida", "Lugo","Madrid", "Málaga", "Murcia", "Navarra", "Orense","Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia","Sevilla", "Soria", "Tarragona", "Teruel", "Toledo","Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza"};
	private static String[] direccion1={"Calle","Avenida","Paseo","Plaza","Bulevard",};
	private static String[] direccion2={"Adrián", "Beatriz", "Carlos", "Daniela", "Elena","Francisco", "Gabriela", "Hugo", "Isabel", "Javier","Karla", "Luis", "Marta", "Nicolás", "Macedonia","Pablo", "Raquel", "Samuel", "Teresa", "Víctor","Alicia", "Gavilla", "Clara", "Diego", "Eva","Félix", "Gloria", "Héctor", "Irene", "Joaquín","Juan", "María", "Pedro", "Ana", "Luis", "Lucía", "José", "Carmen", "David", "Laura","Carlos", "Elena", "Javier", "Sofía", "Pablo", "Marta", "Sergio", "Sara", "Andrés", "Julia","Jorge", "Beatriz", "Alberto", "Isabel", "Rubén", "Patricia", "Fernando", "Raquel", "Miguel", "Nuria","Antonio", "Rosa", "Manuel", "Cristina", "Alejandro", "Teresa", "Adrián", "Inés", "Francisco", "Verónica","Iván", "Lorena", "Roberto", "Natalia", "Álvaro", "Mónica", "Diego", "Paula", "Rafael", "Irene","Marcos", "Silvia", "Vicente", "Alicia", "Eduardo", "Noelia", "Jesús", "Eva", "Samuel", "Belén","Ángel", "Clara", "Hugo", "Sandra", "Óscar", "Rocío", "Raúl", "Carla", "Gabriel", "Bárbara","Enrique", "Olga", "Felipe", "Nerea", "Guillermo", "Ariadna", "Gonzalo", "Rebeca", "Jaime", "Daniela","Ramón", "Ángela", "Martín", "Victoria", "Emilio", "Esther", "Agustín", "Ainhoa", "Tomás", "Iris","Mario", "Claudia", "Julio", "Aitana", "Alfredo", "Miriam", "Alonso", "Diana", "Ignacio", "Paloma","José Luis", "Aina", "Raimundo", "Cristina", "Benito", "Ana Isabel", "Miguel Ángel", "Pilar", "Sebastián", "Elvira","Armando", "Fátima", "Teodoro", "Sofía", "Rodrigo", "Carolina", "Alberto", "Patricia", "Santiago", "María Jesús","Vicente", "Verónica", "Héctor", "Adela", "Bernardo", "Estíbaliz", "Leonardo", "Alicia", "Gaspar", "Elisa","Ernesto", "Miriam", "Esteban", "Encarnación", "Norberto", "Rita", "Guadalupe", "Carmen", "Baltasar", "Cristina","Eduardo", "Francisca", "Fermín", "Marina", "Herminio", "Dolores", "Arturo", "Aurora", "Maximiliano", "Montserrat","Braulio", "Rocío", "Eustaquio", "María José", "Salvador", "Eva", "Herminia", "Lucía", "Marcelino", "Teresa","Demetrio", "Natalia", "Máximo", "Noemí", "Eleuterio", "Isabel", "Anastasio", "Rosario", "Claudio", "Amparo","Damián", "Virginia", "Pascual", "María Ángeles", "Eligio", "María Carmen", "Florencio", "Consuelo", "Mariano", "Águeda","Ovidio", "Pilar", "Benjamín", "Isidra", "Modesto", "Maribel", "Rigoberto", "Valentina", "Alfonso", "Nieves","Serafín", "Blanca", "Alejo", "Julia", "Silvestre", "Manuela", "Sabino", "Juliana", "Octavio", "Gema","Leandro", "María Teresa", "Florentino", "Ana María", "Restituto", "Jesusa", "Cipriano", "Concepción", "Jacobo", "Mercedes","Epifanio", "Gracia", "Clemente", "Gregoria", "Rufo", "Araceli", "Teobaldo", "María Dolores", "Calixto", "Isabel","Sinesio", "Trinidad", "Higinio", "Purificación", "Justino", "Amelia", "Rosendo", "María Cristina", "Germán", "María Luisa","Tristán", "María del Carmen", "Bruno", "Josefa", "Edelmiro", "María Magdalena", "Teódulo", "María Pilar", "Amador", "Vicenta","Valeriano", "Alejandra", "Adán", "María Asunción", "Bartolomé", "María Milagros", "Filemón", "María Eugenia", "Hipólito", "María Antonia","Ciriaco", "Ángeles", "Humberto", "Rosalía", "Patricio", "María Rosa", "Artemio", "María Elena", "Abelardo", "Concha","Joaquín", "Margarita", "Remigio", "Eulalia", "Leocadio", "Paula", "Aurelio", "María de los Ángeles", "Segundo", "Mari Luz","Isidro", "María Fernanda", "Efrén", "María de los Reyes", "Casimiro", "María Mercedes", "Sabina", "Josefa María", "Jerónimo", "Consolación","Fortunato", "María Inmaculada", "Ulises", "María de la Concepción", "Ladislao", "María Soledad", "Prisciliano", "Dolores María", "Wenceslao", "María Isabel","Roque", "María del Rocío", "Valentín", "Inmaculada Concepción", "Aniceto", "María del Rosario", "Leopoldo", "María Ángeles", "Aureliano", "María del Carmen","Moisés", "María de la Paz", "Venancio", "María de los Ángeles", "Hilario", "María de la Consolación", "Osmundo", "María de las Nieves", "Tiburcio", "María Soledad","Sixto", "María del Pilar", "Porfirio", "María de la Luz", "Plácido", "María de las Mercedes", "Filemón", "María de la Paloma", "Macario", "María del Rosario","Urbano", "María del Mar", "Nicomedes", "María del Pilar", "Zenón", "María de la Asunción", "Gumersindo", "María de la O", "Dionisio", "María de los Ángeles","Faustino", "María de la Cabeza", "Timoteo", "María del Milagro", "Teófilo", "María de Lourdes", "Hermes", "María del Carmen", "Sixto", "María de la Encarnación","Ovidio", "María del Amor", "Irineo", "María del Amor Hermoso", "Efrén", "María del Buen Consejo", "Remigio", "María del Consuelo", "Silvestre", "María de las Mercedes","Teodoro", "María de la Gracia", "Tarsicio", "María de los Desamparados", "Avelino", "María del Mar", "Emeterio", "María de la Gloria", "Crispín", "María del Pilar","Cosme", "María del Carmen", "Dámaso", "María de las Angustias", "Protasio", "María del Rosario", "Rómulo", "María del Camino", "Emiliano", "María de la Concepción","Rogelio", "María de los Desamparados", "Jano", "María del Consuelo", "Tadeo", "María de la Visitación", "Próspero", "María de la Consolación", "Nereo", "María del Valle","Maximiliano", "María del Milagro", "Anacleto", "María del Refugio", "Timoteo", "María del Rosario", "Policarpo", "María del Buen Consejo", "Venancio", "María del Carmen","Eleuterio", "María de la Merced", "Eugenio", "María de los Ángeles", "Emeterio", "María del Pilar", "Ermenegildo", "María del Rosario", "Hipólito", "María del Carmen","Metodio", "María del Pilar", "Eligio", "María de la Consolación", "Longinos", "María de las Mercedes", "Róm"};
	private static String[] apellidos = {"García", "Martínez", "López", "Sánchez", "Pérez", "González", "Rodríguez", "Fernández", "Gómez", "Ruiz","Hernández", "Jiménez", "Díaz", "Moreno", "Muñoz", "Álvarez", "Romero", "Alonso", "Gutiérrez", "Navarro","Torres", "Domínguez", "Vázquez", "Ramos", "Gil", "Ramírez", "Serrano", "Blanco", "Molina", "Morales","Suárez", "Ortega", "Delgado", "Castro", "Ortiz", "Rubio", "Marín", "Sanz", "Iglesias", "Núñez","Medina", "Garrido", "Cruz", "Calvo", "Gallego", "Vidal", "León", "Reyes", "Herrera", "Peña","Cabrera", "Flores", "Campos", "Vega", "Fuentes", "Carrasco", "Diez", "Caballero", "Nieto", "Aguilar"};
	private static HashMap<String, String> provinciaLocalidad = new HashMap<>();
	private static HashMap<String, String> localidadCodigoPostal = new HashMap<>();
	private static HashMap<String, Integer> localidadHabitantes = new HashMap<>();



	public static void main(String[] args) {

			//Cantidates

			//inmobiliarias
			int numInmo=500;
			//personas
			int trabajadores=500;
			int inquilinos=1000;
			int propietarios=1000;
			//viviendas
			int viviendas=1000;


			//Variables dependientes
			int cantidadPersonas=trabajadores+inquilinos+propietarios;

			rellenarDiccionarios();


			//llamada a los metodos
			Inmobiliaria(numInmo);//1
			infoLocalidad();//1
			persona(cantidadPersonas);//1
			oficina(numInmo);//2
			trabajador(trabajadores);//2
			Inquilino(inquilinos);//2
			propietarios(propietarios);//2
			vivienda(viviendas);//2
			infoZona();//2
			preferenciasInquilino(inquilinos);//3
			propietarioVivienda(propietarios);//3
			contrato(inquilinos);//4




			//texto de finalizacion
			System.out.println("Finalizado");
		}

	private static void rellenarDiccionarios() {
		//inicializacion de los diccionarios
		//localidad-habitantes
		localidadHabitantes.put("Aínsa", 2175);
		localidadHabitantes.put("Albarracín", 1016);
		localidadHabitantes.put("Alcalá de Henares", 195649);
		localidadHabitantes.put("Almería", 198533);
		localidadHabitantes.put("Barcelona", 1620343);
		localidadHabitantes.put("Bilbao", 345821);
		localidadHabitantes.put("Burgos", 175821);
		localidadHabitantes.put("Cádiz", 116979);
		localidadHabitantes.put("Cangas de Onís", 6623);
		localidadHabitantes.put("Comillas", 2281);
		localidadHabitantes.put("Cuenca", 54672);
		localidadHabitantes.put("Frigiliana", 3071);
		localidadHabitantes.put("Gijón", 271780);
		localidadHabitantes.put("Granada", 232462);
		localidadHabitantes.put("Huelva", 144258);
		localidadHabitantes.put("Laguardia", 1500);
		localidadHabitantes.put("León", 124303);
		localidadHabitantes.put("Logroño", 151113);
		localidadHabitantes.put("Málaga", 578460);
		localidadHabitantes.put("Murcia", 447182);
		localidadHabitantes.put("Olite", 3920);
		localidadHabitantes.put("Oviedo", 220020);
		localidadHabitantes.put("Pamplona", 201653);
		localidadHabitantes.put("Potes", 1370);
		localidadHabitantes.put("Ronda", 33677);
		localidadHabitantes.put("Salamanca", 144228);
		localidadHabitantes.put("San Sebastián", 186064);
		localidadHabitantes.put("Santander", 172656);
		localidadHabitantes.put("Santillana del Mar", 4200);
		localidadHabitantes.put("Sevilla", 688711);
		localidadHabitantes.put("Toledo", 85085);
		localidadHabitantes.put("Trujillo", 9260);
		localidadHabitantes.put("Úbeda", 34500);
		localidadHabitantes.put("Valencia", 791413);
		localidadHabitantes.put("Valladolid", 298412);
		localidadHabitantes.put("Vezdemarban", 200);
		localidadHabitantes.put("Zafra", 16700);
		localidadHabitantes.put("Zaragoza", 674997);

		//localidad-provincia
		provinciaLocalidad.put("Aínsa", "Huesca");
		provinciaLocalidad.put("Albarracín", "Teruel");
		provinciaLocalidad.put("Alcalá de Henares", "Madrid");
		provinciaLocalidad.put("Almería", "Almería");
		provinciaLocalidad.put("Barcelona", "Barcelona");
		provinciaLocalidad.put("Bilbao", "Vizcaya");
		provinciaLocalidad.put("Burgos", "Burgos");
		provinciaLocalidad.put("Cádiz", "Cádiz");
		provinciaLocalidad.put("Cangas de Onís", "Asturias");
		provinciaLocalidad.put("Comillas", "Cantabria");
		provinciaLocalidad.put("Cuenca", "Cuenca");
		provinciaLocalidad.put("Frigiliana", "Málaga");
		provinciaLocalidad.put("Gijón", "Asturias");
		provinciaLocalidad.put("Granada", "Granada");
		provinciaLocalidad.put("Huelva", "Huelva");
		provinciaLocalidad.put("Laguardia", "Álava");
		provinciaLocalidad.put("León", "León");
		provinciaLocalidad.put("Logroño", "La Rioja");
		provinciaLocalidad.put("Málaga", "Málaga");
		provinciaLocalidad.put("Murcia", "Murcia");
		provinciaLocalidad.put("Olite", "Navarra");
		provinciaLocalidad.put("Oviedo", "Asturias");
		provinciaLocalidad.put("Pamplona", "Navarra");
		provinciaLocalidad.put("Potes", "Cantabria");
		provinciaLocalidad.put("Ronda", "Málaga");
		provinciaLocalidad.put("Salamanca", "Salamanca");
		provinciaLocalidad.put("San Sebastián", "Guipúzcoa");
		provinciaLocalidad.put("Santander", "Cantabria");
		provinciaLocalidad.put("Santillana del Mar", "Cantabria");
		provinciaLocalidad.put("Sevilla", "Sevilla");
		provinciaLocalidad.put("Toledo", "Toledo");
		provinciaLocalidad.put("Trujillo", "Cáceres");
		provinciaLocalidad.put("Úbeda", "Jaén");
		provinciaLocalidad.put("Valencia", "Valencia");
		provinciaLocalidad.put("Valladolid", "Valladolid");
		provinciaLocalidad.put("Vezdemarban", "Zamora");
		provinciaLocalidad.put("Zafra", "Badajoz");
		provinciaLocalidad.put("Zaragoza", "Zaragoza");

		//localidad-codigoPostal
		localidadCodigoPostal.put("Aínsa", "22330");
		localidadCodigoPostal.put("Albarracín", "44100");
		localidadCodigoPostal.put("Alcalá de Henares", "28801");
		localidadCodigoPostal.put("Almería", "04001");
		localidadCodigoPostal.put("Barcelona", "08001");
		localidadCodigoPostal.put("Bilbao", "48001");
		localidadCodigoPostal.put("Burgos", "09001");
		localidadCodigoPostal.put("Cádiz", "11001");
		localidadCodigoPostal.put("Cangas de Onís", "33550");
		localidadCodigoPostal.put("Comillas", "39520");
		localidadCodigoPostal.put("Cuenca", "16001");
		localidadCodigoPostal.put("Frigiliana", "29788");
		localidadCodigoPostal.put("Gijón", "33201");
		localidadCodigoPostal.put("Granada", "18001");
		localidadCodigoPostal.put("Huelva", "21001");
		localidadCodigoPostal.put("Laguardia", "01300");
		localidadCodigoPostal.put("León", "24001");
		localidadCodigoPostal.put("Logroño", "26001");
		localidadCodigoPostal.put("Málaga", "29001");
		localidadCodigoPostal.put("Murcia", "30001");
		localidadCodigoPostal.put("Olite", "31390");
		localidadCodigoPostal.put("Oviedo", "33001");
		localidadCodigoPostal.put("Pamplona", "31001");
		localidadCodigoPostal.put("Potes", "39570");
		localidadCodigoPostal.put("Ronda", "29400");
		localidadCodigoPostal.put("Salamanca", "37001");
		localidadCodigoPostal.put("San Sebastián", "20001");
		localidadCodigoPostal.put("Santander", "39001");
		localidadCodigoPostal.put("Santillana del Mar", "39330");
		localidadCodigoPostal.put("Sevilla", "41001");
		localidadCodigoPostal.put("Toledo", "45001");
		localidadCodigoPostal.put("Trujillo", "10200");
		localidadCodigoPostal.put("Úbeda", "23400");
		localidadCodigoPostal.put("Valencia", "46001");
		localidadCodigoPostal.put("Valladolid", "47001");
		localidadCodigoPostal.put("Vezdemarban", "49800");
		localidadCodigoPostal.put("Zafra", "06300");
		localidadCodigoPostal.put("Zaragoza", "50001");
	}
		
		//clase que guarda los datos en un archivo
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

		//metodo que genera el domicilio
		public static String generarDomicilio(){
			Random random=new Random();
			String salida="'"+direccion1[random.nextInt(5)]+" "+direccion2[random.nextInt(400)]+" numero "+random.nextInt(1,500)+"'";
			return salida;
		}

		//metodos que generan las tablas//
		//clase que crea la tabla inmobiliaria
		public static void Inmobiliaria(int numeroLineas){
			Random random=new Random();
	
			String[] Inmobiliarias = {"Global Realty", "Casa Bella", "Prime Properties", "Urban Nest", "Elite Estates","Dream Homes", "Prestige Realty", "Horizon Homes", "Luxe Living", "Royal Realty","Green Acres", "Blue Sky Realty", "Golden Gate Properties", "Silver Lining Realty", "Emerald Estates","Diamond Realty", "Sapphire Homes", "Crystal Clear Realty", "Sunset Realty", "Sunrise Estates","Ocean View Realty", "Mountain Peak Properties", "Riverfront Realty", "Lakeside Estates", "Cityscape Realty","Suburban Homes", "Country Living Realty", "Urban Oasis", "Metro Realty", "Skyline Properties","Landmark Realty", "Heritage Homes", "Classic Realty", "Modern Living", "Trendy Estates","Chic Realty", "Elegant Homes", "Stylish Realty", "Cozy Nest Realty", "Family First Realty","Community Realty", "Neighborhood Homes", "Friendly Realty", "Trustworthy Estates", "Reliable Realty","Secure Homes", "Safe Haven Realty", "Comfort Realty", "Serenity Estates", "Peaceful Living Realty","Urban Abodes", "Vista Realty", "Pinnacle Properties", "Opulent Estates", "Vintage Realty","Majestic Homes", "Supreme Realty", "NextGen Realty", "Infinite Homes", "Bright Future Realty","Urban Dreams", "Epic Realty", "Heavenly Homes", "Ultimate Realty", "Premium Properties","Solid Foundations", "Zenith Realty", "Elysian Estates", "Infinite Realty", "Dreamland Homes","Eternal Realty", "Bliss Homes", "Terra Firma Realty", "New Age Realty", "Veritas Realty","Pure Realty", "Luminous Realty", "Vanguard Properties", "Serene Estates", "Harmonic Homes","First Class Realty", "City Dreams", "Green Haven Realty", "Comfort Homes", "Gem Realty","Affinity Realty", "Zen Homes", "Sky High Realty", "Crown Realty", "Essence Estates","Aspire Realty", "Empire Realty", "Fortune Homes", "Infinite Possibilities Realty", "Legacy Realty","Monarch Homes", "Enchanted Realty", "Brightside Realty", "Crescent Realty", "Cosmos Realty","Radiant Realty", "Aurora Estates", "Prosperity Realty", "Valiant Homes", "Ace Realty","Pillar Realty", "Apex Realty", "Nexus Realty", "Heritage Estates", "Noble Realty","Harmony Realty", "Beacon Realty", "Pathway Realty", "Ambition Realty", "Civic Realty","True Realty", "Victory Realty", "Generations Realty", "Perfection Realty", "Infinity Realty","Elevation Realty", "Destiny Realty", "Aspiration Realty", "Sunlight Realty", "Dawn Realty","Prospect Realty", "Distinctive Realty", "Core Realty", "Unity Realty", "Virtue Realty","Sincere Realty", "Horizon Realty", "Divine Realty", "Dreamscape Realty", "Panorama Realty","Symphony Realty", "Grace Realty", "Trust Realty", "Noble Estates", "Landmark Estates","Prospect Estates", "Optimum Realty", "Foundation Realty", "Generous Realty", "Dynamic Realty","Reflect Realty", "Humble Realty", "Premier Realty", "Legacy Estates", "Pioneer Realty","Distinct Realty", "Genuine Realty", "Ascend Realty", "Remarkable Realty", "Ambitious Realty","Realty Vision", "Serendipity Realty", "Prestige Estates", "Valued Realty", "Innovative Realty","Realty One", "Golden Realty", "Infinite Estates", "Elevate Realty", "Clarity Realty","Wealth Realty", "Momentum Realty", "Tranquil Realty", "Evolution Realty", "Empower Realty","Legendary Realty", "Prime Realty", "Reliance Realty", "Catalyst Realty", "Realty Elite","Horizon Estates", "Achieve Realty", "Realty Excellence", "Realty Prosper", "Integrity Realty","Epic Estates", "Realty Inspired", "Apex Estates", "Unity Estates", "Symbiotic Realty","Creative Realty", "Dynamic Estates", "Empower Estates", "Radiant Homes", "Revolution Realty","Glory Realty", "Elite Homes", "Realty Prime", "Serenity Homes", "Royal Estates","Resilient Realty", "Dream Estates", "Victory Estates", "Marvel Realty", "Infinity Estates","Aspirations Realty", "Destined Realty", "Hopes Realty", "Optimistic Realty", "Uplift Realty","Vision Realty", "Potential Realty", "Bright Realty", "Future Realty", "Prospect Estates","Trustworthy Realty", "Reliable Estates", "Genuine Estates", "True Vision Realty", "Honest Realty","Integrity Estates", "Noble Homes", "Horizon Homes", "Beyond Realty", "Pinnacle Estates","Optimal Realty", "Dreams Realty", "Serenity Estates", "Legacy Homes", "Ambition Estates","Achievers Realty", "Innovators Realty", "Success Realty", "Thriving Realty", "Triumph Realty","Excellence Realty", "Peak Realty", "Prestige Realty", "Prime Estates", "Inspire Realty","Bliss Estates", "Bright Horizon Realty", "Perfection Homes", "Eminent Realty", "Grand Realty","Majestic Estates", "Realty Pinnacle", "Superior Realty", "Royalty Realty", "First Class Homes","Benchmark Realty", "Diamond Realty", "Realty Champions", "Luxury Estates", "Premier Estates","Elite Estates", "Kingdom Realty", "Crown Homes", "Supreme Estates", "Sovereign Realty","Infinite Realty", "Prosper Realty", "Merit Realty", "Legendary Estates", "Infinity Homes","Visionary Realty", "Distinguished Realty", "Dynamic Homes", "Ambition Homes", "Radiant Estates","Realty Horizon", "Success Estates", "Innovation Realty", "Elevate Homes", "Ascension Realty","Glory Estates", "Ultimate Realty", "Fortune Realty", "Prosperity Estates", "Realty Vanguard","Heritage Realty", "Noble Vision Realty", "Dynamic Estates", "Premier Realty", "Elite Estates","Apex Realty", "Crescent Realty", "Unity Realty", "Victory Estates", "Golden Realty","Dream Realty", "Prestige Estates", "Inspire Homes", "Epic Realty", "Supreme Homes","Realty Vision", "Foundation Estates", "Optimum Homes", "Serene Realty", "Noble Realty","Pathway Realty", "Prospect Homes", "Honest Estates", "Vanguard Estates", "Realty Excellence","Infinite Homes", "Potential Estates", "Catalyst Realty", "True Realty", "Bliss Realty","Dream Estates", "Epic Vision Realty", "Victory Realty", "Prosper Homes", "Radiant Realty","Sunrise Realty", "Sunset Realty", "Elevation Homes", "Innovative Estates", "Elite Realty","Horizon Vision Realty", "Pure Realty", "Elegant Estates", "Realty Ascend", "Symphony Estates","Zen Realty", "Ace Realty", "Affinity Estates", "Vision Estates", "Genuine Homes","Dynamic Vision Realty", "Potential Realty", "Ascend Estates", "Momentum Realty", "Radiance Realty","Trust Estates", "True Vision Realty", "Infinite Vision Realty", "Realty Ambition", "Serendipity Estates","Pinnacle Realty", "Golden Estates", "Realty Legacy", "Noble Ventures Realty", "Dynamic Vision Realty","Bright Future Estates", "Infinite Horizon Realty", "Victory Homes", "Realty Supreme", "Prime Vision Realty","Innovative Vision Realty", "Prestige Homes", "Visionary Estates", "Elevate Vision Realty", "Legacy Realty","Dynamic Vision Estates", "Prime Homes", "Innovative Ventures Realty", "Inspire Vision Realty", "Horizon Ventures Realty","Victory Vision Realty", "Radiant Vision Realty", "Optimal Vision Realty", "Innovation Vision Realty", "Serene Vision Realty","Premier Vision Realty", "Heritage Vision Realty", "Infinite Potential Realty", "Infinity Vision Estates", "Elite Vision Realty","First Class Vision Realty", "Optimal Vision Estates", "Crescent Vision Realty", "Victory Ventures Realty", "Epic Vision Homes","Legacy Vision Estates", "Legendary Vision Realty", "Aspire Vision Realty", "Ambition Vision Realty", "Noble Vision Estates","Vision Ventures Realty", "Dynamic Potential Realty", "Success Vision Realty", "Pathway Vision Realty", "Symphony Vision Realty","Unity Vision Realty", "Realty Prime Vision", "Vision Infinity Realty", "Elevation Vision Estates", "Crescent Vision Estates","Optimal Ventures Realty", "Aspire Ventures Realty", "Brightside Vision Realty", "Serendipity Vision Realty", "Premier Homes","Trustworthy Vision Realty", "Epic Potential Realty", "Inspire Potential Realty", "Prospect Vision Realty", "Heritage Potential Realty","Radiant Potential Realty", "Dynamic Potential Estates", "Victory Potential Realty", "Noble Potential Estates", "Elite Potential"};
			String[] categorias = {"'Regional'","'Nacional'","'Provincial'","'Internacional'"};
			String paisSede = "'España'";
			/*nº oficinas */ 
			String salida="";
			int n0ficinas=0;
			for (int i = 0; i < numeroLineas; i++) {
				n0ficinas=random.nextInt(1,10);
				salida+=inicio+"inmoviliaria"+inicio2+"idInmoviliaria,nombreComercial,categoria,nOficinas,paisSede"+medio+(i+1)+",'"+Inmobiliarias[random.nextInt(0,400)]+"',"+categorias[random.nextInt(4)]+","+n0ficinas+","+paisSede+fin+"\n";
				
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
        


		//Creacion
		
		String salida="";
		Random random=new Random();
		String loc="";

		for (int i = 0; i < numeroLineas; i++) {
			for (int j = 0; j < cantidadOficinas[i]; j++) {

				loc=localidad[random.nextInt(19)];

				salida+=inicio+"oficina"+inicio2+"idInmoviliaria,idOficina,direccion,cp,localidad,provincia"+medio+(i+1)+","+(j+1)+",'"+direccion1[random.nextInt(5)]+" "+direccion2[random.nextInt(30)]+"',"+localidadCodigoPostal.get(loc)+",'"+loc+"','"+provinciaLocalidad.get(loc)+"'"+fin+"\n";
				oficinas=Arrays.copyOf(oficinas, oficinas.length+1);
				oficinas[oficinas.length-1]=(i+1)+","+(j+1);
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
			salida+=inicio+"persona"+inicio2+"dni,nombre,apellidos,telefono"+medio+dnii+",'"+direccion2[random.nextInt(30)]+"','"+apellidos[random.nextInt(60)]+"','"+random.nextInt(100000000,999999999)+"'"+fin+"\n";
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
				salida+=inicio+"trabajador"+inicio2+"dni,fechaAlta,tipoContrato,fechaBaja,salarioBrutoAnual"+medio+dni[dni.length-1]+",'"+fechaAlta.toString()+"','"+tipoContrato[random.nextInt(5)]+"','"+fechaBaja.toString()+"',"+random.nextInt(24500,255000)+fin+"\n";
				dni=Arrays.copyOf(dni, dni.length-1);

			}else{
				i++;
			}

		}
		guardarDatos(salida);
		salida="";
	}

	//clase que crea la tabla inquilino
	public static void Inquilino(int numeroLineas) {
    Random random = new Random();
    String[] tipoInquilino = {"'Particular'", "'Empresa'"};
    String[] buscaOfertas = {"True", "False"};

    String salida = "";
    for (int i = numeroLineas; i > 0; i--) {
        if (dni.length > 0) {
            dniInquilino = Arrays.copyOf(dniInquilino, dniInquilino.length + 1);
            dniInquilino[dniInquilino.length - 1] = dni[dni.length - 1];
            salida += inicio + "inquilino" + inicio2 + "dni,tipoInquilino,buscaOfertas" + medio + dni[dni.length - 1] + "," + tipoInquilino[random.nextInt(2)] + "," + buscaOfertas[random.nextInt(2)] + fin + "\n";
            dni = Arrays.copyOf(dni, dni.length - 1);
        }
    }
	System.out.println("dniInc "+dniInquilino.length);
    guardarDatos(salida);
    salida = "";
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

			dni3 = Arrays.copyOf(dni3, dni3.length + 1);
			dni3[dni3.length - 1] = dni[dni.length - 1];

			salida+=inicio+"propietario"+inicio2+"dni,tipoCliente,nViviendas"+medio+dni[dni.length-1]+","+tipoCliente[random.nextInt(2)]+","+nViviendas+fin+"\n";
			dni=Arrays.copyOf(dni, dni.length-1);
		}
		guardarDatos(salida);
		salida="";
	}

	//clase que crea la tabla preferenciasInquilino
	public static void preferenciasInquilino(int numeroLineas){

		Random random=new Random();
		String salida="";
		int loc=0;
		for (int i = numeroLineas; i > 0; i--) {
			loc=random.nextInt(19);
			salida+=inicio+"preferenciasInquilino"+inicio2+"dni,localidad,provincia,metrosMinimo,metrosMaximo,nBanos,garaje,precioMaximo"+medio+dniInquilino[dniInquilino.length-1]+",'"+localidad[loc]+"','"+provinciaLocalidad.get(localidad[loc])+"',"+random.nextInt(20,80)+","+random.nextInt(90,200)+","+random.nextInt(1,4)+","+(random.nextInt(0,2)==1?"True":"False")+","+random.nextInt(700,2000)+fin+"\n";
			
			dni=Arrays.copyOf(dni, dni.length+1);
			dni[dni.length-1]=dniInquilino[dniInquilino.length-1];
			
			dniInquilino = Arrays.copyOf(dniInquilino, dniInquilino.length - 1);
		}
		guardarDatos(salida);
	}

	//clase que crea la tabla infoLocalidad
	public static void infoLocalidad(){

		Random random=new Random();
		String salida="";

		for (int i = 0; i < localidad.length; i++) {
			salida+=inicio+"infoLocalidad"+inicio2+"localidad,provincia,nHabitantes,precioMedioAlquiler"+medio+"'"+localidad[i]+"','"+provinciaLocalidad.get(localidad[i])+"',"+localidadHabitantes.get(localidad[i])+","+random.nextInt(1000,30000)+fin+"\n";
		}
		guardarDatos(salida);
	}

	//clase que crea la tabla vivienda
	public static void vivienda(int numeroLineas){

		Random random=new Random();
		String salida="";
		LocalDate fechaReforma;
		for (int i = numeroLineas; i > 0; i--) {
			fechaReforma=LocalDate.of(random.nextInt(1990,2021), random.nextInt(1,13), random.nextInt(1,29));
			domicilios=Arrays.copyOf(domicilios, domicilios.length+1);
			domicilios[domicilios.length-1]=generarDomicilio();
			localidadesVivienda=Arrays.copyOf(localidadesVivienda, localidadesVivienda.length+1);
			localidadesVivienda[localidadesVivienda.length-1]=random.nextInt(19);

			salida+=inicio+"vivienda"+inicio2+"domicilio,localidad,provincia,cp,metrosConstruidos,metrosUtiles,ascensor,nHabitaciones,nBanos,tipoVentanas,tipoSuelo,ultimaReforma,precioMes,plazasGaraje,alquilado,metrosTerraza,trastero"+medio+domicilios[domicilios.length-1]+",'"+localidad[localidadesVivienda[localidadesVivienda.length-1]]+"','"+provinciaLocalidad.get(localidad[localidadesVivienda[localidadesVivienda.length-1]])+"',"+localidadCodigoPostal.get(localidad[random.nextInt(19)])+","+random.nextInt(50,200)+","+random.nextInt(40,150)+","+(random.nextInt(0,2)==1?"True":"False")+","+random.nextInt(1,6)+","+random.nextInt(1,4)+",'"+(random.nextInt(0,2)==1?"Aluminio":"PVC")+"','"+(random.nextInt(0,2)==1?"Parquet":"Gres")+"','"+fechaReforma.toString()+"',"+random.nextInt(300,2000)+","+random.nextInt(0,3)+","+(random.nextInt(0,2)==1?"True":"False")+","+random.nextInt(0,50)+","+(random.nextInt(0,2)==1?"True":"False")+fin+"\n";
		}
		guardarDatos(salida);

	}

	//clase que crea la tabla propietarioVivienda
	public static void propietarioVivienda(int numeroLineas){

		Random random=new Random();
		String salida="";
		for (int i = 0; i < numeroLineas; i++) {
			salida+=inicio+"propietarioVivienda"+inicio2+"dni,domicilio,localidad,provincia,porcentaje"+medio+dni3[dni3.length-(i+1)]+","+domicilios[domicilios.length-(i+1)]+",'"+localidad[localidadesVivienda[localidadesVivienda.length-(i+1)]]+"','"+provinciaLocalidad.get(localidad[localidadesVivienda[localidadesVivienda.length-(i+1)]])+"',"+random.nextInt(1,101)+fin+"\n";
			
		}
		guardarDatos(salida);
		salida="";

	}

	//clase que crea la tabla contrato
	public static void contrato(int numeroLineas){

		Random random=new Random();
		String salida="";
		LocalDate fechaInicio;
		LocalDate fechaFin;
		String oficina="";
		for (int i = numeroLineas; i > 0; i--) {
			fechaInicio=LocalDate.of(random.nextInt(2000,2021), random.nextInt(1,13), random.nextInt(1,29));
			fechaFin=LocalDate.of(random.nextInt(2000,2021), random.nextInt(1,13), random.nextInt(1,29));
			if (fechaFin.isAfter(fechaInicio)) {

				oficina=oficinas[random.nextInt(oficinas.length)];

				salida+=inicio+"contrato"+inicio2+"dniInquilino,domicilio,localidad,provincia,fechaFirma,duracion,fechaFin,estadoInicialCasa,estadoFinalCasa,fianza,fianzaDevuelta,oficina,inmoviliaria"+medio+dni[dni.length-1]+","+domicilios[domicilios.length-1]+",'"+localidad[localidadesVivienda[localidadesVivienda.length-1]]+"','"+provinciaLocalidad.get(localidad[localidadesVivienda[localidadesVivienda.length-1]])+"','"+fechaInicio.toString()+"',"+random.nextInt(1,37)+",'"+fechaFin.toString()+"','"+(random.nextInt(0,2)==1?"Bueno":"Malo")+"','"+(random.nextInt(0,2)==1?"Bueno":"Malo")+"',"+random.nextInt(100,1000)+","+(random.nextInt(0,2)==1?1:0)+","+oficina+fin+"\n";

				DtContrato=Arrays.copyOf(DtContrato, DtContrato.length+1);
				DtContrato[DtContrato.length-1]=new String[2];
				DtContrato[DtContrato.length-1][0]=dni[dni.length-1]+","+domicilios[domicilios.length-1]+",'"+localidad[localidadesVivienda[localidadesVivienda.length-1]]+"','"+provinciaLocalidad.get(localidad[localidadesVivienda[localidadesVivienda.length-1]])+"'";	
				DtContrato[DtContrato.length-1][1]=fechaInicio.toString();
				
				dni=Arrays.copyOf(dni, dni.length-1);
				domicilios=Arrays.copyOf(domicilios, domicilios.length-1);
				localidadesVivienda=Arrays.copyOf(localidadesVivienda, localidadesVivienda.length-1);
			}else{
				i++;
			}
		}
		//fechaFirma,dni,domicilio,localidad.
		guardarDatos(salida);
		salida="";
		pago(numeroLineas);
	}

	//clase que crea la tabla pago
	public static void pago(int numeroLineas){

		Random random=new Random();
		String salida="";
		LocalDate fechaPrevistaPago;
		LocalDate fechaRealPago;
		int periodoPago=0;
		for (int i = numeroLineas; i > 0; i--) {

			periodoPago=random.nextInt(1,13);
			fechaPrevistaPago=LocalDate.parse(DtContrato[DtContrato.length-1][1]);
			fechaRealPago=fechaPrevistaPago.plusDays(random.nextInt(periodoPago*28));

			salida+=inicio+"pago"+inicio2+"dni,domicilio,localidad,provincia,cantidad,fechaPrevistaPago,fechaRealPago,periodoPago"+medio+DtContrato[DtContrato.length-1][0]+","+random.nextInt(100,2000)+",'"+fechaPrevistaPago+"','"+fechaRealPago+"',"+periodoPago+fin+"\n";
			DtContrato=Arrays.copyOf(DtContrato, DtContrato.length-1);
		}
		guardarDatos(salida);
		salida="";
	}

	//clase que crea la tabla infoZona
	public static void infoZona(){

		Random random=new Random();
		String salida="";
		for (int i = 0; i < localidad.length; i++) {
			salida+=inicio+"infoZona"+inicio2+"cp,localidad,provincia,nViviendasAlquiler,precioMedioMetroCuadrado"+medio+localidadCodigoPostal.get(localidad[i])+",'"+localidad[i]+"','"+provinciaLocalidad.get(localidad[i])+"',"+random.nextInt(100,1000)+","+random.nextInt(10,300)+fin+"\n";
		}
		guardarDatos(salida);
		salida="";
	}
}
