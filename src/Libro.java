
import java.io.Serializable;

public class Libro implements Serializable{
	
	private String nombre = null, editor = null, titulo = null, anyo = null;
	private int paginas = 0 ;

	public Libro() {
	}

	public Libro(String n,String e,String t, int p, String a) {
		nombre = n;
		editor = e;
		titulo = t;
		paginas = p;
		anyo = a;
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

	public void print() {
		System.out.println( "Titulo " + titulo + " Anyo: " + anyo + " Nombre: " + nombre + " y Editor: " + editor + " Paginas: " + paginas );
	}
}
