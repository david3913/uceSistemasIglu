package com.daxer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Pelis implements Serializable {

	public Pelis() {
		for (int i = 0; i < 10; i++) {

			Peli p = new Peli();
			pelis.add(p);
		}
	}

	private List<Peli> pelis = new ArrayList<Peli>();

	public void llenar() {

	}

	public List<Peli> getPelis() {
		return pelis;
	}

	public void setPelis(List<Peli> pelis) {
		this.pelis = pelis;
	}

}