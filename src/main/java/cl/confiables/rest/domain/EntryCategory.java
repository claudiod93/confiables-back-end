/**
 * 
 */
package cl.confiables.rest.domain;

import java.io.Serializable;

import cl.confiables.repository.domain.Categoria;

/**
 * @author claudioantonio Class only entry data update Datos Laborales, add
 *         category by id dl
 *
 */
public class EntryCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Categoria categoria;

	public EntryCategory() {
		// TODO Auto-generated constructor stub
	}

	public EntryCategory(Long id, Categoria categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public Categoria getCategoria() {
		return categoria;
	}
}