package Entities;

public class Login{

	private String idUsuario;
	private String nombre;
	private String apellido;
	private String fecReg;
	private String email;
	private String cargo;
	private String disciplina;

	public Login(String id, String nombre, String apellido, String fecReg, String email, String cargo, String disciplina) {
		super();
		this.idUsuario = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecReg = fecReg;
		this.email = email;
		this.cargo = cargo;
		this.disciplina = disciplina;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFecReg() {
		return fecReg;
	}

	public void setFecReg(String fecReg) {
		this.fecReg = fecReg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	
	
}
