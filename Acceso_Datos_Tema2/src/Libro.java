
import java.io.Serializable;
import java.util.Arrays;

public class Libro implements Serializable{
	
	private String nombre = null, editor = null, titulo = null, anyo = null;
	private int paginas = 0 ;

	public Libro() {
	}

	public Libro(String nombre,String editor,String titulo, int paginas, String anyo) {
		this.nombre = nombre;
		this.editor = editor;
		this.titulo = titulo;
		this.paginas = paginas;
		this.anyo = anyo;
	}

	public String getAnyo() {
		return anyo;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String n) {
		nombre = n;
	}
	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String toString() {
		String datos = "Titulo " + titulo + " Anyo: " + anyo + " Nombre: " + nombre 
				+ " y Editor: " + editor + " Paginas: " + paginas;
		return datos;
	}
}
