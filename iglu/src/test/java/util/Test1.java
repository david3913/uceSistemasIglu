package util;

import com.iglu.util.Email;

public class Test1 {
	// static FechaSql a = new FechaSql();
	// static Password b = new Password();
	// static Email mailC;
	// static Email mailS;


	public static void main(String[] args) {
		 Email enviar = new Email("miempresa123@hotmail.com", "daxer123",
				 "a_david55@hotmail.com", "IGLU - Registro", "Su usuario es: ");
		 enviar.sendMail();
		// EmpresaDaoImpl a = new EmpresaDaoImpl();
		// a.empH();
		// Empresa b= new Empresa();
		// b.setMail("asa@asda.com");
		// a.create(b);
		// f.fechaActualDate);
		// Edad e = new Edad();
		// Date a = Date.valueOf("2012-08-0");
		// e.edadMeses(e.calculaEdad(a));
		

	}
}
