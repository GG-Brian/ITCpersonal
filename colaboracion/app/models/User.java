package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

import play.data.validation.*;

@Entity
public class User extends Model {

    @Required
    @MinSize(8)
    @MaxSize(255)
    public String nombre;

    @Required
    @MaxSize(255)
    public String firma;

    public User(String nombre, String password){
        this.nombre = nombre;
        this.firma = password;
    }

    public static User connect(String nombre, String password) {
        return find("byNombreAndFirma", nombre, password).first();
    }

}