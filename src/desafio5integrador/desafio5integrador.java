package desafio5integrador;

import java.util.Scanner;

import java.io.*;

public class desafio5integrador {
	/*
	 * El desafío consiste en almacenar los datos de 3 jugadores de fútbol. Para
	 * ello: Declarar arrays estáticos POR FUERA DE PUBLIC STATIC VOID MAIN
	 * correspondientes para name, apelli, y número de camiseta. Recordar que
	 * son tres jugadores. Generá la función "public static void ingresarDatos()".
	 * Dentro de ella, generá el código para ingresar los datos del punto anterior.
	 * Armá otra función "public static void agregarJugador()". En ella, preguntar
	 * al usuario si desea agregar los datos de UN jugador suplentente. Si la respuesta
	 * es "si" ( ejemplo: respuestaAgregar.equals("si") ), hay que agregar los datos
	 * de este nuevo jugador (name, apelli, posición y número de camiseta). Si
	 * la respuesta es "no" (ejemplo: respuestaAgregar.equals("no") ) , continuar
	 * normalmente con el programa. Si no, si la respuesta es cualquier otra,
	 * indicarle que se equivocó de respuesta. La respuesta debe ser "si" o "no", no
	 * puede ser "s" o "n", o sea, usá Strings para determinar la respuesta. NO
	 * comparar respuesta "if respuesta == si", mas bien usar el método
	 * "  if respuesta.equals("si") " . Por otro lado, no te olvides de usar el
	 * método toLowerCase() o toUpperCase() para convertir la respuesta a minúsculas
	 * o mayúscuas. CONSEJO PARA ESTE PUNTO: recordá que en Java NO se permite
	 * agregar elementos a un array ya definido. Es decir, si se definió un array de
	 * 3 elementos, se pueden actualizar, pero no se puede agregar un cuarto
	 * elemento. Lo que se puede hacer, es crear un nuevo array con 4 elementos,
	 * copiar el array anterior, y agregar el nuevo elemento. De ser necesario,
	 * buscá información en Google o ChatGPT para agregar datos en otro array nuevo.
	 * GENERAR LOS NUEVOS ARRAYS POR FUERA DE PUBLIC STATIC VOID MAIN, Y GENERARLOS
	 * COMO "STATIC". Por si el usuario ingresó incorrectamente la respuesta a si
	 * quiere agregar un jugador, dentro de la función anterior ( agregarJugador()
	 * ), envolvé todo el código en un while que analice si la respuesta ingresada
	 * es correcta. CUIDADO: si llamaste a la respuesta del usuario
	 * "respuestaAgregarJugador" (por ejemplo), NO podés usarla para el while. La
	 * podrías llamar "respuestaAgregarJugadorIncorrecta". Pensá que, en los casos
	 * donde haya colocado "si" o "no", respuestaAgregarJugadorIncorrecta va a
	 * convertirse en un valor "falso". En cambio, si colocó otra respuesta,
	 * respuestaAgregarJugadorIncorrecta será verdadero (porque puso una respuesta
	 * incorrecta). Armá una función llamada analizarDatosTresJugadores(). Dentro de
	 * esta función, mostrá en pantalla los datos ingresados. Preguntar si están
	 * bien los datos. Si los datos sin correctos, el programa debe continuar
	 * normalmente. Si no lo son, preguntarle al usuario qué numero de camiseta de
	 * jugador quiere modificar. Si el numero de camiseta es igual a alguno de los
	 * números de camiseta ingresado, modificar name, apelli y número de ESE
	 * jugador. Mostrá nuevamente en pantalla los datos ingresados. Si los volvió a
	 * ingresar mal, simplemente indicale que vuelva a comenzar el programa (por
	 * salame). Al igual que en la función agregarJugador(), envolvé todo en un
	 * while por si ingresó una respuesta incorrecta. Volvé a la función
	 * agregarJugador(). Dentro del caso donde la respuesta fue "no" (o sea, que no
	 * agregó jugador), invocá al final de todo a la función
	 * analizarDatosTresJugadores(). Esto servirá para analizar datos en este caso
	 * donde NO se agregó un jugador, por ende, el número de jugadores sigue siendo
	 * 3. Después de llamar a la función analizarDatosTresJugadores(), no te olvides
	 * de bajar la bandera de respuestaAgregarIncorrecta a false. Armá una función
	 * llamada analizarDatosCuatroJugadores(). Para armarla, podés copiar el
	 * contenido de analizarDatosTresJugadores(), pero cambiando el name de los
	 * arrays por los nuevos arrays que agregar los datos del nuevo jugador. Volvé a
	 * la función agregarJugador(). Dentro del caso donde la respuesta fue "si" (o
	 * sea, que si agregó jugador), invocá al final de todo a la función
	 * analizarDatosCuatroJugadores(). Esto servirá para analizar datos en este caso
	 * donde SI se agregó un jugador, por ende, el número de jugadores ahora es de
	 * 4. Después de llamar a la función analizarDatosTresJugadores(), no te olvides
	 * de bajar la bandera de respuestaAgregarIncorrecta a false. No te olvides de
	 * llamar a las funciones ingresarDatos() y agregarJugador() dentro de
	 * "public static void main". Las funciones de analizar datos NO las invocamos
	 * en el método principal, ya que son llamadar dentro de la función
	 * agregarJugador().
	 */

	static String ruta = "C:\\Users\\Alumno.A02-M07\\Documents\\desafio 5\\mi_archivo.txt";

	static File file = new File(ruta);
	static FileWriter fw;

	static BufferedWriter bw;

	static String[] name = new String[4];
	static String[] apelli = new String[4];
	static int[] NumCami = new int[4];

	static String[] namesuplente = new String[4];
	static String[] apellisuplente = new String[4];
	static int[] NumCamisuplente = new int[4];

	static int numVuelta, numCamiseta, decimodif;
	static String desicionPlayer;
	static boolean decis = false;

	public static void main(String[] args) {
		ingresarDatos();

		decis = false;
		analizarDatosTresJugadores();
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			try {

				if (!file.exists()) {
					System.out.println("archivo no encontrado para los suplententes");
				}

				for (int i = 0; i < 3; i++) {
					// Escribir en el archivo una linea que contiene el name y el apelli
					bw.write("name: " + name[i] + ", apelli: " + apelli[i] + ", camiseta: "
							+ NumCami[i]);
					bw.newLine();
				}

				

				System.out.println("Archivo creado con exito.");
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {

				FileReader archivo = new FileReader("C:\\Users\\Alumno.A02-M07\\Documents\\desafio 5\\mi_archivo.txt");
				BufferedReader lector = new BufferedReader(archivo);

				String linea;

				while ((linea = lector.readLine()) != null) {

					System.out.println(linea);
				}

				lector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (desicionPlayer.equals("yes")) {
				try {

					for (int i = 0; i < 3; i++) {
						
						if(namesuplente[i] != null || NumCamisuplente[i] != 0 || apellisuplente[i] != null){
						// Escribir en el archivo una linea que contiene el name y el apelli
						bw.write("name del suplentente: " + namesuplente[i] + ", apelli del suplentente: " + apellisuplente[i]
								+ ", camiseta del suplentente: " + NumCamisuplente[i]);
						bw.newLine();
						}
					}


					System.out.println("Archivo creado con exito.");
				} catch (Exception e) {

					e.printStackTrace();
				}
				try {

					FileReader archivo = new FileReader("C:\\Users\\Alumno.A02-M07\\Documents\\desafio 5\\mi_archivo.txt");
					BufferedReader lector = new BufferedReader(archivo);

					String linea;

					while ((linea = lector.readLine()) != null) {

						System.out.println(linea);
					}

					lector.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void analizarDatosTresJugadores() {
		Scanner entrada = new Scanner(System.in);
		while (decis == false) {
			for (int i = 0; i <= 3; i++) {
				if (name[i] != null) {
					System.out.println("name " + (i + 1) + ": " + name[i]);
					System.out.println("apelli " + (i + 1) + ": " + apelli[i]);
					System.out.println("numero " + (i + 1) + ": " + NumCami[i]);
					System.out.println();

				}
			}
			for (int i = 0; i <= 3; i++) {
				if (namesuplente[i] != null) {
					System.out.println("name " + (i + 1) + ": " + namesuplente[i]);
					System.out.println("apelli " + (i + 1) + ": " + apellisuplente[i]);
					System.out.println("numero " + (i + 1) + ": " + NumCamisuplente[i]);
					System.out.println();

				}
			}

			System.out.println("¿los datos son correctos yes/no");
			desicionPlayer = entrada.next().toLowerCase();

			if (desicionPlayer.equals("yes")) {
				decis = true;
			}
			if (desicionPlayer.equals("no")) {
				decis = false;
				System.out.println("¿cual es el numero de jugador que desea modificar?");
				numCamiseta = entrada.nextInt();

				System.out.println("\t¿cual es el campo que desea modificar?\n1.name\n2.apelli");
				decimodif = entrada.nextInt();

				switch (decimodif) {

				case 1:
					for (int i = 0; i <= 3; i++) {
						if (numCamiseta == NumCami[i]) {

							System.out.println("¿cual es el name por el cual va a modificar el anterior?");
							name[i] = entrada.next();

						}
					}

					break;
				case 2:
					for (int i = 0; i <= 3; i++) {
						if (numCamiseta == NumCami[i]) {

							System.out.println("¿cual es el apelli por el cual va a modificar el anterior?");
							apelli[i] = entrada.next();

						}
					}
					break;
				case 3:
					for (int i = 0; i <= 3; i++) {
						if (numCamiseta == NumCami[i]) {

							System.out.println("¿cual es el numero por el cual va a modificar el anterior?");
							NumCami[i] = entrada.nextInt();

						}
					}
					break;
				default:
					System.out.println("no es una opcion correcta. intentelo de nuevo");
					decis = false;
				}

			}
			if (!desicionPlayer.equals("no") && !desicionPlayer.equals("yes")) {
				System.out.println("no es una opcion correcta. recuerde responder con \"yes\" o \"no\"");
			}
		}
	}

	public static void ingresarDatos() {

		Scanner entrada = new Scanner(System.in);
		for (int i = 0; i <= 2; i++) {
			numVuelta = i;
			nomPlayer();
			ApePlayer();
			NumCamiseta();

		}

		for (int i = 0; i <= 2; i++) {
			numVuelta = i;
			decis = false;
			while (!decis) {
				System.out.println("¿desea agregar un suplentente al jugador " + (i + 1) + "? yes/no");
				desicionPlayer = entrada.next().toLowerCase();

				if (desicionPlayer.equals("yes")) {
					decis = true;
					AddPlayer();
				}
				if (desicionPlayer.equals("no")) {
					decis = true;
				}
				if (!desicionPlayer.equals("no") && !desicionPlayer.equals("yes")) {
					System.out.println("no es una opcion correcta. recuerde responder con \"yes\" o \"no\"");
				}
			}

		}
	}

	public static void AddPlayer() {

		nomPlayersuplentente();
		ApePlayersuplentente();
		NumCamisetasuplentente();

	}

	public static void nomPlayer() {
		Scanner entrada = new Scanner(System.in);

		System.out.println("¿Cual es el name del jugador " + (numVuelta + 1) + "?");
		name[numVuelta] = entrada.next();

	}

	public static void ApePlayer() {
		Scanner entrada = new Scanner(System.in);

		System.out.println("¿Cual es el apelli del jugador " + (numVuelta + 1) + "?");
		apelli[numVuelta] = entrada.next();

	}

	public static void NumCamiseta() {
		Scanner entrada = new Scanner(System.in);

		System.out.println("¿Cual es el su numero de camiseta de jugador " + (numVuelta + 1) + "?");
		NumCami[numVuelta] = entrada.nextInt();

	}

	public static void nomPlayersuplentente() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("¿Cual es el name del suplentente del jugador " + (numVuelta + 1) + "?");
		namesuplente[numVuelta] = entrada.next();

	}

	public static void ApePlayersuplentente() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("¿Cual es el apelli del suplentente del jugador " + (numVuelta + 1) + "?");
		apellisuplente[numVuelta] = entrada.next();
	}

	public static void NumCamisetasuplentente() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("¿Cual es el su numero de camiseta del suplentente del jugador " + (numVuelta + 1) + "?");
		NumCamisuplente[numVuelta] = entrada.nextInt();

	}
}
