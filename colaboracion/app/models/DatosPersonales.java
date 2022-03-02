package models;

import play.*;
import play.db.jpa.*;
import java.io.File;
import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class DatosPersonales extends Model{
	
	String nombre;
	String apellido1;
	String apellido2;
	String dni;
	String correo;
	int tlf;

}
