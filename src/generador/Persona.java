package generador;

public class Persona {
  String nombre;
  int edad;
  String telefono;
  String email;
  String apellido;
  public Persona(String nombre,String apellido,int edad,String telefono,String email){
    this.nombre=nombre;
    this.apellido=apellido;
    this.edad=edad;
    this.telefono=telefono;
    this.email=email;
  }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
}
