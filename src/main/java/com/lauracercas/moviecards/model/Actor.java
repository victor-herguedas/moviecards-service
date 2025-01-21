/**
 * Autora: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 * Cambios: José R. Hilera (2024) para eliminar la parte cliente de la aplicación original
 */

package com.lauracercas.moviecards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	private String country;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadDate;

	@ManyToMany(mappedBy = "actors")
	@JsonIgnoreProperties("actors") // Añadido
	private List<Movie> movies;

	public Actor() {
	}

	public Actor(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Movie> getMovies() {
		return this.movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
		final Actor actor = (Actor) o;
		return Objects.equals(this.id, actor.id) && Objects.equals(this.name, actor.name)
				&& Objects.equals(this.birthDate, actor.birthDate) && Objects.equals(this.country, actor.country);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.birthDate, this.country);
	}
}