package NumeroRomano.NumerosRomanos;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConversorRomano
{
	private Map<String, Integer> mapaRomanosArabicos;
	
	public Integer converter(String numeroRomano) {
		
		Integer numeroArabico = null;
		iniciarTabelaDeConversao();
		
		if(numeroRomano != null && !numeroRomano.isEmpty() && validarNumerosRomanos(numeroRomano) ){
			numeroRomano = numeroRomano.toUpperCase();
			numeroArabico = mapaRomanosArabicos.get(numeroRomano);

			if(numeroArabico == null){
				numeroArabico = 0;
				
				int i = 0;
				
				while (i < numeroRomano.length()) {
			          
		             char letraRomano = numeroRomano.charAt(i);
		             String stringLetraRomano = letraRomano + "";
		             
		             if(mapaRomanosArabicos.containsKey(stringLetraRomano)) {
			             int numeroAtual = mapaRomanosArabicos.get(stringLetraRomano); 
			             i++; 
			             
			             if (i == numeroRomano.length()) {
			                
			            	 numeroArabico += numeroAtual;
			             }
			             else {
			            	 char letraProximoRomano = numeroRomano.charAt(i); 
			            	 String proximoRomano = letraProximoRomano + "";
			            	 
			                int numeroProximo = mapaRomanosArabicos.get(proximoRomano);
			                if (numeroProximo > numeroAtual) {
			                	numeroArabico += (numeroProximo - numeroAtual);
			                	i++;
			                }
			                else {
			                	numeroArabico += numeroAtual;
			                }
			             }
		             } 
		          }   
			}
			
			return numeroArabico;
		}
		return numeroArabico;
	}

	private void iniciarTabelaDeConversao() {
		mapaRomanosArabicos = new HashMap<String, Integer>();
		mapaRomanosArabicos.put("I", 1);
		mapaRomanosArabicos.put("II", 2);
		mapaRomanosArabicos.put("III", 3);
		mapaRomanosArabicos.put("IV", 4);
		mapaRomanosArabicos.put("V", 5);
		mapaRomanosArabicos.put("VI", 6);
		mapaRomanosArabicos.put("VII", 7);
		mapaRomanosArabicos.put("VIII", 8);
		mapaRomanosArabicos.put("IX", 9);
		mapaRomanosArabicos.put("X", 10);
		mapaRomanosArabicos.put("L", 50);
		mapaRomanosArabicos.put("C", 100);
		mapaRomanosArabicos.put("D", 500);
		mapaRomanosArabicos.put("M", 1000);
		
	}

	private boolean validarNumerosRomanos(String romano) {
		boolean resultado = false;
		
		romano = romano.toUpperCase();
		
		/*A pedido do professor, a notaÃ§Ã£o do nÃºmero 4000 foi mudada para MMMM, pois nÃ£o Ã© possivel comparar a notaÃ§Ã£o 
		original romana.*/
		
		Pattern pattern = Pattern.compile("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
		Matcher matcher = pattern.matcher(romano);
		boolean regexValido = matcher.matches();
		
		if(regexValido){
			resultado = true;
		}
		
		return resultado;
	}
}


