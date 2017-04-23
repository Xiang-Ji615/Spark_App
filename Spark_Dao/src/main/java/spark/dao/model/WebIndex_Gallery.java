package main.java.spark.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "webindex_gallery")
public class WebIndex_Gallery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	int id;


	@Column(name = "gallery_name")
	String galleryName;

	@Column(name = "project_text")
	String projectText;

	@Column(name = "project_name")
	String projectName;
	
	

}
