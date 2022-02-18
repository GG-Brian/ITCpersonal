package models;

import play.*;
import play.db.jpa.*;
import java.io.File;
import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Informacion extends Model{

	public boolean familiaNumerosa;
	public boolean discapacidad;
	public File dicapacidadPdf;
	public File rentaPdf;
	public File familiaNumerosaPdf;
	public String estudios;
	
}
