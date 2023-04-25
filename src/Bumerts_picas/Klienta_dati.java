package Bumerts_picas;

import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Klienta_dati extends Pica {
	//Atributi
public String vards;
public String uzvards;
public String telefons;
public String Adrese;
double majasPiegadesCena;
//Konstruktors
public Klienta_dati(String pasutitajaVards, String pasutitajaUzvards, String pasutitajaTelefons, String pasutitajaAdrese, String picaTips, String picasGarsa, String picaPiedeva, int picascm, String dzeramais, double picasCena) {
	super(picaTips, picasGarsa, picaPiedeva, picascm,  dzeramais, picasCena);
	this.vards = pasutitajaVards;
	this.uzvards = pasutitajaUzvards;
	this.telefons = pasutitajaTelefons;
	this.Adrese = pasutitajaAdrese;
}
public String noteiktVardu() {
	return vards;
}
public void izvadit() {
	JOptionPane.showMessageDialog(null, "Klienta vārds "+vards+"\n"
			+ "Klienta uzvārds "+uzvards+"\n"
			+ "Klienta telefona numurs "+telefons+"\n"
			+ "Klienta adrese "+Adrese+"\n"
			+ "Klienta picas tips "+tips+"\n"
			+ "Picas garša "+garsa+"\n"
			+ "Picas piedeva "+piedeva+"\n"
			+ "Picas diametrs "+diametrs+"\n"
			+ "Dzeramais "+dzeramais+" euro\n"
			+ "Picas cena ir "+cena+" eur");
}
public void izvaditCenu() {
	JOptionPane.showMessageDialog(null,"Reķins "+vards+"cena: "+cena);
}
public void saglabatFaila() {
	try{
		FileWriter fw = new FileWriter("pica.txt", true);
		PrintWriter raksta = new PrintWriter(fw);
		raksta.print("\nKlienta vārds "+vards+" \n"
				+ "Klienta uzvārds "+uzvards+" \n"
				+ "Klienta telefona numurs "+telefons+" \n"
				+ "Klienta adrese "+Adrese+" \n"
				+ "Klienta picas tips "+tips+" \n"
				+ "Picas garša "+garsa+" \n"
				+ "Picas piedeva "+piedeva+" \n"
				+ "Picas diametrs "+diametrs+" \n"
				+ "Dzeramais "+dzeramais+" euro\n"
				+ "Picas cena "+cena+" euro\n");
		raksta.println("_________________________________");
		raksta.close();
		JOptionPane.showMessageDialog(null, "Informācija par klientas picu un cenu saglabāts failā", "Info", JOptionPane.INFORMATION_MESSAGE);
	}catch(Exception e){
		JOptionPane.showMessageDialog(null, "Kļūda  ierakstot faila, ","Kļūda ",JOptionPane.ERROR_MESSAGE);
	}
}
}
