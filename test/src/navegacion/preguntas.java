package navegacion;


public class preguntas {
	
	String[] preguntas = {
			"pregunta 1", "pregunta 2", "pregunta 3",
			"pregunta 4", "pregunta 5"
	  };
  
	public String getPregunta(int posicion) {
		return preguntas[posicion];
	}

}