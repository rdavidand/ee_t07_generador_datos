package generador;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;
import com.csvreader.CsvWriter;
public class Generador {
    static ArrayList<String> nombres= new ArrayList<String>();
    static ArrayList<String> apellidos= new ArrayList<String>();
    static ArrayList<Persona>personas= new ArrayList<Persona>();
   public void llenarN(String archivo){
     try{
       FileReader fr= new FileReader(archivo);
       BufferedReader bw= new BufferedReader(fr);
       String linea;
       while((linea=bw.readLine())!=null){
        nombres.add(linea);
       }
     }
     catch(Exception e){
       System.out.println("Error");
     }
   }
   public void llenarA(String archivo){
   try{
       FileReader fr= new FileReader(archivo);
       BufferedReader bw= new BufferedReader(fr);
       String linea;
       while((linea=bw.readLine())!=null){
        apellidos.add(linea);
       }
     }
     catch(Exception e){
       System.out.println("Error");
     }
   }
   
   public void generar(){
     int nom=(int)(Math.random()*199+1);
     int ap=(int)(Math.random()*85+1);
     String nombre=nombres.get(nom);
     String apellido=apellidos.get(ap);
      int t1=(int)(Math.random()*999+1);
      int t2=(int)(Math.random()*999+1);
      int t3=(int)(Math.random()*99+1);
      String telefono;
      telefono=Integer.toString(t1)+"-"+Integer.toString(t2)+"-"+Integer.toString(t3);
      int edad=(int)(Math.random()*80+12);
      String dominio[]={"@hotmail.com","@yahoo.com","@gmail.com","@live.com","@outlook.com","@Aol.com","@apple.com"};
      String c1=nombre;
      String c2=apellido;
      String [] d1=c1.split("");
      String [] d2=c2.split("");
      int d3=2016-edad;
      String d4=Integer.toString(d3);
      int dom=(int)(Math.random()*7+0);
      String domin=dominio[dom];
      String email=d1[0]+d1[1]+d1[2]+"_"+d2[0]+d2[1]+"-"+d4+domin;
      Persona personita= new Persona(nombre,apellido,edad,telefono,email);
      personas.add(personita);
      System.out.println("Nombre: "+nombre+" "+apellido+"      Telefono:"+telefono+"      Edad:"+edad+" años"+"     Correo:"+email);
       
   }
   
   public void guarda(){
    String outputFile="Archivos.csv";
     boolean alreadyExists= new File(outputFile).exists();
     if(alreadyExists){
      File Archivos= new File(outputFile);
      Archivos.delete();
     }
      try{
          CsvWriter csvOutput =new CsvWriter(new FileWriter(outputFile,true),',');
          csvOutput.write("Nombre");
          csvOutput.write("Apellido");
          csvOutput.write("Edad");
          csvOutput.write("Correo");
          csvOutput.endRecord();
          for(Persona per:personas){
             csvOutput.write(per.getNombre());
             csvOutput.write(per.getApellido());
             csvOutput.write(Integer.toString(per.getEdad()));
             csvOutput.write(per.getEmail());
             csvOutput.endRecord();
          }
        csvOutput.close();          
      }
      catch(Exception e){
       System.out.println("Error al guardar");
      }
   }
   
   public static void main(String[] args) {
   Generador ta= new Generador();
   ta.llenarN("nombres.txt");
   ta.llenarA("apellidos.txt");
   int numero=Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos deseas generar"));
    for(int i=0;i<numero;i++){
     ta.generar();
    }
    ta.guarda();
   }
    
}
