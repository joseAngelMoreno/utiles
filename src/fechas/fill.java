package fechas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

	public class fill {
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			char j;
			
			String cadena, cadenaN = "", cadenaL = "", cadenaAux = "";
			try {
				cadena = br.readLine();
				for (int i = 0; i < cadena.length(); i++) {
					j = cadena.charAt(i);

					if (i == 4)
						break;
					cadenaN = cadenaN + j;
				}

				for (int i = 4; i < cadena.length(); i++) {
					j = cadena.charAt(i);
					cadenaL = cadenaL + j;
				}
				int n = Integer.parseInt(cadenaN);
				n = n + 1;
				if (n == 10000) {
					cadenaN = "0000";
					for (int i = 0; i < cadenaL.length(); i++) {
						j = cadenaL.charAt(i);
						if (i != 2) {
							cadenaAux = cadenaAux + j;
						} else {
							if (cadenaL.charAt(2) == 'z') {
								j = 'b';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'b') {
								j = 'c';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'c') {
								j = 'd';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'd') {
								j = 'f';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'f') {
								j = 'g';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'g') {
								j = 'h';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'h') {
								j = 'j';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'j') {
								j = 'k';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'k') {
								j = 'l';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'l') {
								j = 'm';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'm') {
								j = 'n';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'n') {
								j = 'p';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'p') {
								j = 'q';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'q') {
								j = 'r';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'r') {
								j = 's';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 's') {
								j = 't';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 't') {
								j = 'v';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'v') {
								j = 'w';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'w') {
								j = 'x';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'x') {
								j = 'y';
								cadenaAux = cadenaAux + j;
								break;
							} else if (cadenaL.charAt(2) == 'y') {
								j = 'z';
								cadenaAux = cadenaAux + j;
								break;
							}
						}

					}
				} else {
					cadenaN = "";
					cadenaN = cadenaN + n;
				}
				cadenaL = cadenaAux;
				cadena = cadenaN + cadenaL;
			
				System.out.println("Proceso Hijo"+cadena);
				System.exit(0);
				br.close();

			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
