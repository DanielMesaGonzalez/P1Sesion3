package sesion3;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{
	
	private String nombre;
	private String direccion;
	private String email;
	
	public UsuarioDTO(String nombre, String email, String direccion) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.direccion = direccion;
	}
	
	
	public UsuarioDTO() {
		nombre="";
		email="";
		direccion="";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//-------------- Método para comprobar si el usuario es administrador  ----------------
	
	public boolean checkAdmin(String usuario2, String passwd) {
		// TODO Auto-generated method stub
		if(usuario2.equalsIgnoreCase("admin") && passwd.equalsIgnoreCase("1234")) {
		return true;
		}
		
		else {return false;}

	}
}