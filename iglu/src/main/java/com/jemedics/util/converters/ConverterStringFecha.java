package com.jemedics.util.converters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.jemedics.util.converters.ConverterStringFecha")
public class ConverterStringFecha implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		
		System.out.println("1 " + value);
		String HTTP = "http://";
		StringBuilder url = new StringBuilder();

	
		return HTTP;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		DateFormat formato = new SimpleDateFormat("yyyyMMdd");
		String strFecha = value.toString();
		Date fechaDate = null;

		try {
			fechaDate = formato.parse(strFecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println(fechaDate.toString());

		DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
		strFecha= fecha.format(fechaDate);
		

		//System.out.println("2 " + value.toString());
		String res = "prueba converter";
		// return value.toString();
		return strFecha;

	}
}
