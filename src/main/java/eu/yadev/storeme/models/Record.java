package eu.yadev.storeme.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "records")
public @Data class Record {
	private static final String TITLE_COLUMN = "title";
	private static final String BODY_COLUMN = "body";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = TITLE_COLUMN, nullable = false, unique = true)
	private String title;

	@Column(name = BODY_COLUMN, nullable = false)
	private String body;

	public Record() {}

	/**
	 * Builder-like. Setter for title.
	 *
	 * @param title string with title text
	 * @return under-constructor {@link Record} object
	 */
	public Record setTitle(final String title) {
		this.title = title;
		return this;
	}

	/**
	 * Builder-like. Setter for body.
	 *
	 * @param body string with body text
	 * @return under-constructor {@link Record} object
	 */
	public Record setBody(final String body) {
		this.body = body;
		return this;
	}

	/**
	 * Static constructor of {@link Record} object.
	 *
	 * @return {@link Record} object
	 */
	public static Record create() {
		Record recordObject = new Record();
		return recordObject;
	}

}
