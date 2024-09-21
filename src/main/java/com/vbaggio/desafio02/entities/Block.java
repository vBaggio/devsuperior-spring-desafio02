package com.vbaggio.desafio02.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_block")
public class Block {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant beginning;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant ending;
	
	@ManyToOne
	@JoinColumn(name = "activity_id")
	private Activity activity;

	public Block() {

	}

	public Block(Integer id, Instant beginning, Instant ending, Activity activity) {
		super();
		this.id = id;
		this.beginning = beginning;
		this.ending = ending;
		this.activity = activity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getBeginning() {
		return beginning;
	}

	public void setBegin(Instant beginning) {
		this.beginning = beginning;
	}

	public Instant getEnding() {
		return ending;
	}

	public void setEnd(Instant ending) {
		this.ending = ending;
	}
	
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Block other = (Block) obj;
		return Objects.equals(id, other.id);
	}

}
