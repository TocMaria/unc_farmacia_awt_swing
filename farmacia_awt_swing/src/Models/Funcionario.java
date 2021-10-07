package Models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionario extends Pessoa implements Serializable, Comparable<Object> {

	private static final long serialVersionUID = 1L;

	public static final String ARQUIVO = "C:\\Users\\User\\eclipse-workspace\\Farmacia\\Database\\Funcionario.csv";
	public static final String ARQUIVO_SERIALIZACAO = "C:\\Users\\User\\eclipse-workspace\\Farmacia\\Database\\Funcionario.obj";

	private String telefone;
	private String pis;
	private String pasep;
	private String carteiraTrabalho;
	private Double salario;


	public Funcionario(String a[]) { 
		super(a[0],a[1],a[2],a[3]); 
		this.pis=(a[4]);
		this.pasep= (a[5]);
		this.carteiraTrabalho=(a[6]);	 
		this.salario=  Double.parseDouble(a[7]);
	}

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getPasep() {
		return pasep;
	}

	public void setPasep(String pasep) {
		this.pasep = pasep;
	}

	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double string) {
		this.salario = string;
	}

	public static String getArquivo() {
		return ARQUIVO;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + getPis() + ";" + getPasep() + ";" + getCarteiraTrabalho() + ";" + getSalario()
				+ "\n";
	}

	public static List<Funcionario> lerLista() {
		File f = new File(ARQUIVO);
		FileInputStream fis;
		List<Funcionario> lstFuncionario = new ArrayList<Funcionario>();
		try {
			fis = new FileInputStream(f);
			Scanner scan = new Scanner(fis);
			while (scan.hasNext()) {
				String linha = scan.nextLine();
				String arr[] = linha.split(";");
				Funcionario func = new Funcionario(arr);
				lstFuncionario.add(func);
			}
			scan.close();
			fis.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("Caminho nao encontrado");
		} catch (IOException e) {
			System.out.println("Erro de gravacao");
		}
		return lstFuncionario;
	}
	public int compareTo(Object o) {
		Funcionario f = (Funcionario) o;		
		return this.getNome().compareTo(f.getNome());			
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
