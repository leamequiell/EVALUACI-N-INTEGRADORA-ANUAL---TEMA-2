package desafio5integrador;

import java.util.Scanner;

import java.io.*;

public class desafio5integrador {
	/*
	 * El desaf�o consiste en almacenar los datos de 3 jugadores de f�tbol. Para
	 * ello: Declarar arrays est�ticos POR FUERA DE PUBLIC STATIC VOID MAIN
	 * correspondientes para name, apelli, y n�mero de camiseta. Recordar que
	 * son tres jugadores. Gener� la funci�n "public static void ingresarDatos()".
	 * Dentro de ella, gener� el c�digo para ingresar los datos del punto anterior.
	 * Arm� otra funci�n "public static void agregarJugador()". En ella, preguntar
	 * al usuario si desea agregar los datos de UN jugador suplentente. Si la respuesta
	 * es "si" ( ejemplo: respuestaAgregar.equals("si") ), hay que agregar los datos
	 * de este nuevo jugador (name, apelli, posici�n y n�mero de camiseta). Si
	 * la respuesta es "no" (ejemplo: respuestaAgregar.equals("no") ) , continuar
	 * normalmente con el programa. Si no, si la respuesta es cualquier otra,
	 * indicarle que se equivoc� de respuesta. La respuesta debe ser "si" o "no", no
	 * puede ser "s" o "n", o sea, us� Strings para determinar la respuesta. NO
	 * comparar respuesta "if respuesta == si", mas bien usar el m�todo
	 * "  if respuesta.equals("si") " . Por otro lado, no te olvides de usar el
	 * m�todo toLowerCase() o toUpperCase() para convertir la respuesta a min�sculas
	 * o may�scuas. CONSEJO PARA ESTE PUNTO: record� que en Java NO se permite
	 * agregar elementos a un array ya definido. Es decir, si se defini� un array de
	 * 3 elementos, se pueden actualizar, pero no se puede agregar un cuarto
	 * elemento. Lo que se puede hacer, es crear un nuevo array con 4 elementos,
	 * copiar el array anterior, y agregar el nuevo elemento. De ser necesario,
	 * busc� informaci�n en Google o ChatGPT para agregar datos en otro array nuevo.
	 * GENERAR LOS NUEVOS ARRAYS POR FUERA DE PUBLIC STATIC VOID MAIN, Y GENERARLOS
	 * COMO "STATIC". Por si el usuario ingres� incorrectamente la respuesta a si
	 * quiere agregar un jugador, dentro de la funci�n anterior ( agregarJugador()
	 * ), envolv� todo el c�digo en un while que analice si la respuesta ingresada
	 * es correcta. CUIDADO: si llamaste a la respuesta del usuario
	 * "respuestaAgregarJugador" (por ejemplo), NO pod�s usarla para el while. La
	 * podr�as llamar "respuestaAgregarJugadorIncorrecta". Pens� que, en los casos
	 * donde haya colocado "si" o "no", respuestaAgregarJugadorIncorrecta va a
	 * convertirse en un valor "falso". En cambio, si coloc� otra respuesta,
	 * respuestaAgregarJugadorIncorrecta ser� verdadero (porque puso una respuesta
	 * incorrecta). Arm� una funci�n llamada analizarDatosTresJugadores(). Dentro de
	 * esta funci�n, mostr� en pantalla los datos ingresados. Preguntar si est�n
	 * bien los datos. Si los datos sin correctos, el programa debe continuar
	 * normalmente. Si no lo son, preguntarle al usuario qu� numero de camiseta de
	 * jugador quiere modificar. Si el numero de camiseta es igual a alguno de los
	 * n�meros de camiseta ingresado, modificar name, apelli y n�mero de ESE
	 * jugador. Mostr� nuevamente en pantalla los datos ingresados. Si los volvi� a
	 * ingresar mal, simplemente indicale que vuelva a comenzar el programa (por
	 * salame). Al igual que en la funci�n agregarJugador(), envolv� todo en un
	 * while por si ingres� una respuesta incorrecta. Volv� a la funci�n
	 * agregarJugador(). Dentro del caso donde la respuesta fue "no" (o sea, que no
	 * agreg� jugador), invoc� al final de todo a la funci�n
	 * analizarDatosTresJugadores(). Esto servir� para analizar datos en este caso
	 * donde NO se agreg� un jugador, por ende, el n�mero de jugadores sigue siendo
	 * 3. Despu�s de llamar a la funci�n analizarDatosTresJugadores(), no te olvides
	 * de bajar la bandera de respuestaAgregarIncorrecta a false. Arm� una funci�n
	 * llamada analizarDatosCuatroJugadores(). Para armarla, pod�s copiar el
	 * contenido de analizarDatosTresJugadores(), pero cambiando el name de los
	 * arrays por los nuevos arrays que agregar los datos del nuevo jugador. Volv� a
	 * la funci�n agregarJugador(). Dentro del caso donde la respuesta fue "si" (o
	 * sea, que si agreg� jugador), invoc� al final de todo a la funci�n
	 * analizarDatosCuatroJugadores(). Esto servir� para analizar datos en este caso
	 * donde SI se agreg� un jugador, por ende, el n�mero de jugadores ahora es de
	 * 4. Despu�s de llamar a la funci�n analizarDatosTresJugadores(), no te olvides
	 * de bajar la bandera de respuestaAgregarIncorrecta a false. No te olvides de
	 * llamar a las funciones ingresarDatos() y agregarJugador() dentro de
	 * "public static void main". Las funciones de analizar datos NO las invocamos
	 * en el m�todo principal, ya que son llamadar dentro de la funci�n
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

			System.out.println("�los datos son correctos yes/no");
			desicionPlayer = entrada.next().toLowerCase();

			if (desicionPlayer.equals("yes")) {
				decis = true;
			}
			if (desicionPlayer.equals("no")) {
				decis = false;
				System.out.println("�cual es el numero de jugador que desea modificar?");
				numCamiseta = entrada.nextInt();

				System.out.println("\t�cual es el campo que desea modificar?\n1.name\n2.apelli");
				decimodif = entrada.nextInt();

				switch (decimodif) {

				case 1:
					for (int i = 0; i <= 3; i++) {
						if (numCamiseta == NumCami[i]) {

							System.out.println("�cual es el name por el cual va a modificar el anterior?");
							name[i] = entrada.next();

						}
					}

					break;
				case 2:
					for (int i = 0; i <= 3; i++) {
						if (numCamiseta == NumCami[i]) {

							System.out.println("�cual es el apelli por el cual va a modificar el anterior?");
							apelli[i] = entrada.next();

						}
					}
					break;
				case 3:
					for (int i = 0; i <= 3; i++) {
						if (numCamiseta == NumCami[i]) {

							System.out.println("�cual es el numero por el cual va a modificar el anterior?");
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
				System.out.println("�desea agregar un suplentente al jugador " + (i + 1) + "? yes/no");
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

		System.out.println("�Cual es el name del jugador " + (numVuelta + 1) + "?");
		name[numVuelta] = entrada.next();

	}

	public static void ApePlayer() {
		Scanner entrada = new Scanner(System.in);

		System.out.println("�Cual es el apelli del jugador " + (numVuelta + 1) + "?");
		apelli[numVuelta] = entrada.next();

	}

	public static void NumCamiseta() {
		Scanner entrada = new Scanner(System.in);

		System.out.println("�Cual es el su numero de camiseta de jugador " + (numVuelta + 1) + "?");
		NumCami[numVuelta] = entrada.nextInt();

	}

	public static void nomPlayersuplentente() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("�Cual es el name del suplentente del jugador " + (numVuelta + 1) + "?");
		namesuplente[numVuelta] = entrada.next();

	}

	public static void ApePlayersuplentente() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("�Cual es el apelli del suplentente del jugador " + (numVuelta + 1) + "?");
		apellisuplente[numVuelta] = entrada.next();
	}

	public static void NumCamisetasuplentente() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("�Cual es el su numero de camiseta del suplentente del jugador " + (numVuelta + 1) + "?");
		NumCamisuplente[numVuelta] = entrada.nextInt();

	}
}
