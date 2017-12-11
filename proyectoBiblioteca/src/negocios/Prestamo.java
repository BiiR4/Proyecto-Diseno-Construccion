/**
 * Prestamo.
 * 
 * Implementa el registro de un nuevo prestamo.
 * 
 * @author Mario López García
 * @version 1.1
 * @since Diciembre 1, 2017
 * 
 */
package negocios;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import bd.OperacionesPrestamo;

public class Prestamo {
  private int idPrestamo;
  private Date fecha;
  private Date fechaPrestamo;
  private Date fechaDevolucion;
  private float deuda;
  private List<MaterialBibliografico> materialBibliografico;
  private List<UsuarioSistema> usuariosSistema;
  private List<UsuarioBiblioteca> usuariosBiblioteca;


  private static OperacionesPrestamo operacionesPrestamo;

  /**
   * Constructor
   * 
   * @param deuda recibe la fecha que se realiza el prestamo.
   * @param fechaPrestamo recibe la fecha en que se realiza el prestamo.
   * @param fechaDevolucion recibe la fecha en la que se devuelve el material bibliográfico.
   * @param d un material bibliográfico a prestar.
   * @param materialBibliografico2 es el usuario que presta el material bibliográfico.
   * @param usuariosSistema2 usuario a quien será prestado el documento.
   */

  private Prestamo(int idPrestamo, Date fecha, Date fechaPrestamo, Date fechaDevolucion,
      float deuda, List<MaterialBibliografico> materialBibliografico,
      List<UsuarioSistema> usuariosSistema, List<UsuarioBiblioteca> usuariosBiblioteca) {
    super();
    this.idPrestamo = idPrestamo;
    this.fecha = fecha;
    this.fechaPrestamo = fechaPrestamo;
    this.fechaDevolucion = fechaDevolucion;
    this.deuda = deuda;
    this.materialBibliografico = materialBibliografico;
    this.usuariosSistema = usuariosSistema;
    this.usuariosBiblioteca = usuariosBiblioteca;
  }


  public int getIdPrestamo() {
    return idPrestamo;
  }

  public void setIdPrestamo(int idPrestamo) {
    this.idPrestamo = idPrestamo;
  }

  public Date getFechaPrestamo() {
    return fechaPrestamo;
  }

  public void setFechaPrestamo(Date fechaPrestamo) {
    this.fechaPrestamo = fechaPrestamo;
  }

  public Date getFechaDevolucion() {
    return fechaDevolucion;
  }

  public void setFechaDevolucion(Date fechaDevolucion) {
    this.fechaDevolucion = fechaDevolucion;
  }

  public float getDeuda() {
    return deuda;
  }

  public void setDeuda(float deuda) {
    this.deuda = deuda;
  }

  public List<MaterialBibliografico> getMaterialBibliografico() {
    return materialBibliografico;
  }

  public void setMaterialBibliografico(List<MaterialBibliografico> materialBibliografico) {
    this.materialBibliografico = materialBibliografico;
  }

  public List<UsuarioSistema> getUsuariosSistema() {
    return usuariosSistema;
  }

  public void setUsuariosSistema(List<UsuarioSistema> usuariosSistema) {
    this.usuariosSistema = usuariosSistema;
  }

  public List<UsuarioBiblioteca> getUsuariosBiblioteca() {
    return usuariosBiblioteca;
  }

  public void setUsuariosBiblioteca(List<UsuarioBiblioteca> usuariosBiblioteca) {
    this.usuariosBiblioteca = usuariosBiblioteca;
  }

  public static OperacionesPrestamo getOperacionesPrestamo() {
    return operacionesPrestamo;
  }

  public static void setOperacionesPrestamo(OperacionesPrestamo operacionesPrestamo) {
    Prestamo.operacionesPrestamo = operacionesPrestamo;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public static Date sacarFechaDevolucion(Date fechaPrestamo, int dias) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(fechaPrestamo);
    calendar.add(Calendar.DAY_OF_YEAR, dias);
    return calendar.getTime();
  }


  /**
   * Registra un nuevo prestamo que se guarda en la base de datos.
   * 
   * @param materialBibliografico es el objeto principal a prestar.
   * @param usuariosSistema persona que presta el material bibliografico.
   * @param usuariosBiblioteca persona a quien va dirigido el prestamo.
   * @return el prestamo realizado
   */

  public Prestamo registrarPrestamo(Prestamo prestamo) {
    Date fechaActual = new Date();
    Date fechaPrestamo = new Date();
    Prestamo prestamoResultante = new Prestamo(idPrestamo, fechaActual, fechaPrestamo,
        Prestamo.sacarFechaDevolucion(fechaPrestamo, 7), deuda, materialBibliografico,
        usuariosSistema, usuariosBiblioteca);
    Prestamo.operacionesPrestamo.registrarPrestamo(prestamoResultante);
    return prestamoResultante;
  }

}
