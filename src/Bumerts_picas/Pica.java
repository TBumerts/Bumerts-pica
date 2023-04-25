package Bumerts_picas;

import javax.swing.JOptionPane;

public class Pica {
double skaits;
public double cena;
public int diametrs;
public String piedeva;
public String tips;
public String garsa;
public String dzeramais;
public Pica(String picaTips,String picasGarsa,String picasPiedeva,int picasDiametrs,String dzeramais,double picasCena) {
	this.tips = picaTips;
	this.garsa = picasGarsa;
	this.piedeva = picasPiedeva;
	this.diametrs = picasDiametrs;
	this.cena = picasCena;
	this.dzeramais = dzeramais;
}
public String nomanitTipu(String jaunsTips) {
	tips = jaunsTips;
	return tips;
}
public String nomainitPiedevas(String jaunaPiedeva) {
	piedeva = jaunaPiedeva;
	return piedeva;
}
public String nomainitGarsu(String jaunaGarsa) {
	garsa = jaunaGarsa;
	return garsa;
}
public int nomainitcm(int jaunsDiametrs) {
	diametrs = jaunsDiametrs;
	return diametrs;
}
public double jaunaCena(double jaunaCena) {
	cena = jaunaCena;
	return cena;
}
public String jaunsDzeramais(String jaunsDzeramais){
	dzeramais = jaunsDzeramais;
	return dzeramais;
}
public double noteiktCenu() {
	return cena;
}
public void izvadit() {
	JOptionPane.showMessageDialog(null,"Klienta picas veids "+tips+"\n"
			+ "Picas garša "+garsa+"\n"
			+ "Picas piedeva "+piedeva+"\n"
			+ "Picas diametrs "+diametrs);
}
}
