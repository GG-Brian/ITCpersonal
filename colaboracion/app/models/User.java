package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

import play.data.validation.*;
/*
import java.security.SecureRandom;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
*/
import org.mindrot.jbcrypt.BCrypt;


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
        this.firma = hasher(password);
//        this.firma = hashPassword(password);
    }

    private String getFirma(){
        return this.firma;
    }

    public static User connect(String nombre, String password) {
        /*boolean correctPass = false;
        String hashedPass = "";
        List<User> foundUsers = find("byNombre", nombre).fetch();
        for (User user : foundUsers) {
            String pass = user.getFirma();
            if (hashCheck(password, pass)){
                correctPass = true;
                hashedPass = pass;
                break;
            }
        }
        if (correctPass){*/
            return find("byNombreAndFirma", nombre, password).first();
        // }
        // return null;

    }

//    @PrePersist
    private String hasher(String password){
        System.out.println("Estoy aqui");
        String hashedPass = BCrypt.hashpw(password, BCrypt.gensalt(12));
        return Base64.getEncoder().encodeToString(hashedPass.getBytes());
    }

    private static boolean hashCheck(String password, String hashedPassword) {
        String unhashablePass = new String(Base64.getDecoder().decode(hashedPassword));
        return BCrypt.checkpw(password, unhashablePass);
    }

// https://stackoverflow.com/questions/18262425/how-to-hash-password-in-play-framework-maybe-with-bcrypt
/*    private String hashPassword(String password) {
        byte salt[] = new byte[16];
        SecureRandom randomizer = new SecureRandom();
        randomizer.nextBytes(salt);
        
        byte[] hash = pbkdf2(password, salt, 10000);
        String salt64 = Base64.getEncoder().encodeToString(salt);
        String hash64 = Base64.getEncoder().encodeToString(hash);

        return 10000 + ":" + hash64 + ":" + salt64;
    }

    private byte[] pbkdf2(String password, byte salt[], int iterations) {
//      ERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR  SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2HmacSHA512");
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, iterations, 256);
        keyFactory.generateSecret(keySpec).getEncoded();
    }

    private boolean checkPassword(String password, String passHashed) {
        passHashed.split(":") match {
            case Array(it, hash64, salt64) if it.forall(_.isDigit) =>
                String hash = Base64.getDecoder().decode(hash64);
                String salt = Base64.getDecoder().decode(salt64);

                Array[byte] calculatedHash = pbkdf2(password, salt, it.toInt);
                boolean same = calculatedHash.sameElements(hash);
            case other => Console.log("Bad boi pass hash");
        }
    }
*/
}