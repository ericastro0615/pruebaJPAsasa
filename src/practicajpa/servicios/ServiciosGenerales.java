 
package practicajpa.servicios;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import practicajpa.DAO.AlumnoRepositorio;
import practicajpa.DAO.CursoRepositorio;
import practicajpa.DAO.ProfesorRepositorio;
import practicajpa.entidades.Curso;
import practicajpa.entidades.Profesor;
import practicajpa.enumerados.DiaDeLaSemana;


public class ServiciosGenerales {
    
    private AlumnoRepositorio alumnoRepositorio;
    private ProfesorRepositorio profesorRepositorio;
    private CursoRepositorio cursoRepositorio;
    private Scanner sc = new Scanner (System.in);
    
    public ServiciosGenerales() {
        alumnoRepositorio = new AlumnoRepositorio();
        cursoRepositorio = new CursoRepositorio();
        profesorRepositorio = new ProfesorRepositorio();
                
    }
    
    
    public void cargarBase () {
        Curso curso1= new Curso();
        curso1.setNombreCurso("Java JPA");
        curso1.setDia(DiaDeLaSemana.MIERCOLES);
        curso1.setHoraInicio(crearHora(14, 30));
        curso1.setHoraFin(crearHora(16,30));
    }
    
    
    private Date crearHora(int horas, int minutos){
        LocalTime hora = LocalTime.of(horas, minutos);
        Date fecha = Date.from(hora.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());
        return fecha;    
    }
    
    
    public void consultas () {
        List <Curso> cursos = cursoRepositorio.listarCursos();
        System.out.println("Lista de cursos disponibles: ");
        for (Curso curso : cursos) {
            System.out.println(curso.toString() + "\n");
        }
        
        
        System.out.println("Lista de cursos, por nombre");
        String nombre = sc.nextLine();
        Curso curAbuscar = cursoRepositorio.buscarPorNombre(nombre);
        System.out.println(curAbuscar + "\n\n\n");
        
        
        List <Profesor> profesores = profesorRepositorio.listarProfesores();
         
        System.out.println("Lista de todos los profesores: (namedQuery) ");
        for (Profesor profesore : profesores) {
            System.out.println(profesore.toString() + "\n" );
        }
         
        System.out.println("\n\n\n");
        
        System.out.println("Cantidad de alumnos inscriptos (native query)");
        System.out.println(alumnoRepositorio.cantidadAlumnos());
    }
}
