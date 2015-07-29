package com.daxer;

public class Peli {

	
	private int id;
	private String titulo="3";
	private String html="<div class='work'>" + "<div class='peli'>"
			+ "<a href='index1.xhtml'>"
			+ "<img src='../resources/img/work1.jpg' class='media' alt=''/>"
			+ "<div class='caption'>" + "<div class='work_title'>" + "<h1>"
			+ "numero " + 1 + "</h1>" + "</div></div></a></div>"
			+ "<div class='tit'>" + "	Titulo de la pelicula<br /> genero"
			+ "</div></div>";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	
	
}
