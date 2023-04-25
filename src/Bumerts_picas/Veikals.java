package Bumerts_picas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Veikals {
		static Klienta_dati[] klientuNaksana(Klienta_dati[] masivs) {
			int cm;
			double cena=0;
			double piegadesCena;
			for(int i=0; i<masivs.length; i++) {
			String vards =  JOptionPane.showInputDialog("Klienta vārds");
			String uzvards =  JOptionPane.showInputDialog("Klienta uzvārds");
			String telefons =  JOptionPane.showInputDialog("Klienta telefona numurs");
			String Adrese =  JOptionPane.showInputDialog("Klienta adrese");
			String sutaMajas = JOptionPane.showInputDialog("Vai klients sūta mājas | Ja vai ne|");
			int skaits;
			sutaMajas = sutaMajas.toLowerCase();
			if(sutaMajas.equals("ja")) {
				piegadesCena = 2.99;
			}else {
				piegadesCena = 0;
			}
			String[] Forma = {"kvadrats", "apals", "ovals"};
			String tips = (String) JOptionPane.showInputDialog(null, "Kādu kontūru picai dosi?"
					+ "\nKvadrats - 0.70, Apals - 0.50, Ovals - 0.80", "Izvēlies kontūru",
			                    JOptionPane.DEFAULT_OPTION, null, Forma, Forma[0]);
			if (tips.equals("kvadrats")) {
			    cena = cena + 0.70;
			} else if (tips.equals("apals")) {
			    cena = cena + 0.65;
			} else if (tips.equals("ovals")) {
			    cena = cena + 0.80;
			}
			String[] piedevas = {"kecups", "sipoli","majoneze", "loki"};
			String piedeva = (String) JOptionPane.showInputDialog(null, "Kādas piedevas picai velies?"
					+ "\nkecups - 0.22, sipoli - 0.52,majoneze - 0.14, loki - 0.15", "Izvēlies piedevas",
                    JOptionPane.DEFAULT_OPTION, null, piedevas, piedevas[0]);
			if(piedeva.equals("kecups")) {
				cena = cena+0.22;
			}else if(piedeva.equals("majoneze")) {
				cena = cena+0.14;
			}else if(piedeva.equals("sipoli")) {
				cena = cena+0.52;
			}else if(piedeva.equals("loki")){
				cena = cena+0.15;
			}
			String[] garsas = {"siers", "gala", "senes","salati"};
			String garsa = (String) JOptionPane.showInputDialog(null, "Kādu garšu picai velies?"
					+ "\nsiers - 0.42, gala - 0.95, senes - 1.42, salati - 0.50", "Izvēlies garšu",
                    JOptionPane.DEFAULT_OPTION, null, garsas, garsas[0]);
			if(garsa.equals("siers")) {
				cena = cena+0.42;
			}else if(garsa.equals("gala")) {
				cena = cena+0.95;
			}else if(garsa.equals("senes")) {
				cena = cena+1.42;
			}else if(garsa.equals("salati")){
				cena = cena+0.50;
			}
			String[] dzerieni = {"Kola", "Fanta","Sula"};
			String dzeramais = (String) JOptionPane.showInputDialog(null, "Kādu dzerienu pie picas velies?"
					+ "\nKola - 1.22, Fanta - 1.14, Sula - 0.52", "Izvēlies dzeramo",
                    JOptionPane.DEFAULT_OPTION, null, dzerieni, dzerieni[0]);
			dzeramais = dzeramais.toLowerCase();
			if(dzeramais.equals("Kola")) {
				cena = cena+1.22;
			}else if(dzeramais.equals("Fanta")) {
				cena = cena+1.14;
			}else if(dzeramais.equals("Sula")) {
				cena = cena+0.52;
			}
			int cm1;
			do {
			Object[] izmeri = {10,20,30,40,50};
			cm1 = (Integer) JOptionPane.showInputDialog(null, "Kādu izmeru picai velies?"
					+ "\n10cm - 0.70, 20cm - 1.00, 30cm - 1.70, 40cm - 2.00, 50cm - 2.70", "Izvēlies izmeru",
                    JOptionPane.DEFAULT_OPTION, null, izmeri, izmeri[0]);
			cm = cm1;
			if(cm==10) {
				cena = cena+0.70;
			}else if(cm==20) {
				cena = cena+1.00;
			}else if(cm==30) {
				cena = cena+1.70;
			}else if(cm==40) {
				cena = cena+2.00;
			}else if(cm==50) {
				cena = cena+2.70;
			}
			skaits = Integer.parseInt(JOptionPane.showInputDialog("Cik picas klients tādas pašas sūtīs?"));	
			}while(cm<10 || cm>50);
			cena = norekinasanas(cena,skaits,piegadesCena);
			masivs[i] = new Klienta_dati(vards,uzvards,telefons,Adrese,tips,garsa,piedeva,cm,dzeramais,cena);
			masivs[i].izvaditCenu();
			cena = 0;
			JOptionPane.showMessageDialog(null, "Klients saglabāts", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
			return masivs;
		}
		public static double norekinasanas(double cena, int skaits, double piegade) {
			cena = (cena*skaits);
			cena = cena+piegade;
			cena = Math.round(cena*100.0)/100.0;
			return cena;
		}
	public static void nolasit() {
		String txt,str="";
		try{
			FileReader fr = new FileReader("pica.txt");
			BufferedReader lasa = new BufferedReader(fr);
			while((txt = lasa.readLine()) !=null){
				str += txt+"\n";
			}
			lasa.close();
			JOptionPane.showMessageDialog(null, str, "Informācija",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Kļūda nolasot faila, ","Kļūda",JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void saglabat(Klienta_dati[] masivs) {
		try{
			FileWriter fw = new FileWriter("pica.txt", true);
			PrintWriter raksta = new PrintWriter(fw);
			
			for(int i=0; i<masivs.length; i++){
				masivs[i].saglabatFaila();
			}
			raksta.println("_________________________________");
			raksta.close();
			JOptionPane.showMessageDialog(null, "Informācija par klientas picu un cenu saglabāts failā", "Info", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Kļūda  ierakstot faila, ","Kļūda ",JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void main(String[] args) {
		JFrame fr = new JFrame();
		Klienta_dati[] klientuMasivs = null;
		int skaits;
		String izvele;
		do {
			String[] darbibas = {"klienta picas pasutisana", "citu picu pasutisana","izvadit","saglabat datus faila","nolasit datus no faila","stop"};
			izvele = (String) JOptionPane.showInputDialog(null, "Kādu darbibu izvelies?"
					+ "\nKlientu pica, Citu picu pasutisana, Izvadit, Saglabat datus faila, Nolasit datus no faila, stop", "Izvēlies dzeramo",
                    JOptionPane.DEFAULT_OPTION, null, darbibas, darbibas[0]);
			izvele = izvele.toLowerCase();
			switch(izvele) {
			case "klienta picas pasutisana":
				try {
					skaits = Integer.parseInt(JOptionPane.showInputDialog("Klientu skaits, kuri vēlas picu"));
					klientuMasivs = new Klienta_dati[skaits];
					klientuMasivs = klientuNaksana(klientuMasivs);
					}catch(Exception e) {
						JOptionPane.showMessageDialog(fr, "Darbība nepastāv!", "Kļūda!",JOptionPane.ERROR_MESSAGE); 
					}
			break;
			case "citu picu pasutisana":
				boolean atrasts = false;
				String klientaVards = JOptionPane.showInputDialog("Ievadi Pirceja vārdu, kurš vēlas pasutit atsevišķu picu: ");
				for(int i=0; i<klientuMasivs.length; i++) {
					if(klientaVards.equalsIgnoreCase(klientuMasivs[i].noteiktVardu())){
						atrasts = true;
						double cena=0;
						int cm;
						String sutaMajas = JOptionPane.showInputDialog("Vai klients sūta mājas | Jā vai nē|");
						double piegadesCena;
						sutaMajas = sutaMajas.toLowerCase();
						if(sutaMajas.equals("ja")) {
							piegadesCena = 2.99;
						}else {
							piegadesCena = 0;
						}
						String[] Forma = {"kvadrats", "apals", "ovals"};
						String tips = (String) JOptionPane.showInputDialog(null, "Kādu kontūru picai dosi?"
								+ "\nKvadrats - 0.70, Apals - 0.50, Ovals - 0.80", "Izvēlies kontūru",
						                    JOptionPane.DEFAULT_OPTION, null, Forma, Forma[0]);
						if (tips.equals("kvadrats")) {
						    cena = cena + 0.70;
						} else if (tips.equals("apals")) {
						    cena = cena + 0.65;
						} else if (tips.equals("ovals")) {
						    cena = cena + 0.80;
						}
						klientuMasivs[i].nomanitTipu(tips);
						String[] garsas = {"siers", "gala", "senes","salati"};
						String garsa = (String) JOptionPane.showInputDialog(null, "Kādu garšu picai velies?"
								+ "\nsiers - 0.42, gala - 0.95, senes - 1.42, salati - 0.50", "Izvēlies garšu",
			                    JOptionPane.DEFAULT_OPTION, null, garsas, garsas[0]);
						if(garsa.equals("siers")) {
							cena = cena+0.42;
						}else if(garsa.equals("gala")) {
							cena = cena+0.95;
						}else if(garsa.equals("senes")) {
							cena = cena+1.42;
						}else if(garsa.equals("salati")){
							cena = cena+0.50;
						}
						klientuMasivs[i].nomainitGarsu(garsa);
						String[] piedevas = {"kecups", "sipoli","majoneze", "loki"};
						String piedeva = (String) JOptionPane.showInputDialog(null, "Kādas piedevas picai velies?"
								+ "\nkecups - 0.22, sipoli - 0.52,majoneze - 0.14, loki - 0.15", "Izvēlies piedevas",
			                    JOptionPane.DEFAULT_OPTION, null, piedevas, piedevas[0]);
						if(piedeva.equals("kecups")) {
							cena = cena+0.22;
						}else if(piedeva.equals("majoneze")) {
							cena = cena+0.14;
						}else if(piedeva.equals("sipoli")) {
							cena = cena+0.52;
						}else if(piedeva.equals("loki")){
							cena = cena+0.15;
						}
						klientuMasivs[i].nomainitPiedevas(piedeva);
						String[] dzerieni = {"Kola", "Fanta","Sula"};
						String dzeramais = (String) JOptionPane.showInputDialog(null, "Kādu dzerienu pie picas velies?"
								+ "\nKola - 1.22, Fanta - 1.14, Sula - 0.52", "Izvēlies dzeramo",
			                    JOptionPane.DEFAULT_OPTION, null, dzerieni, dzerieni[0]);
						dzeramais = dzeramais.toLowerCase();
						if(dzeramais.equals("Kola")) {
							cena = cena+1.22;
						}else if(dzeramais.equals("Fanta")) {
							cena = cena+1.14;
						}else if(dzeramais.equals("Sula")) {
							cena = cena+0.52;
						}
						klientuMasivs[i].jaunsDzeramais(dzeramais);
						int cm1;
						do {
						Object[] izmeri = {10,20,30,40,50};
						cm1 = (Integer) JOptionPane.showInputDialog(null, "Kādu izmeru picai velies?"
								+ "\n10cm - 0.70, 20cm - 1.00, 30cm - 1.70, 40cm - 2.00, 50cm - 2.70", "Izvēlies izmeru",
			                    JOptionPane.DEFAULT_OPTION, null, izmeri, izmeri[0]);
						cm = cm1;
						if(cm==10) {
							cena = cena+0.70;
						}else if(cm==20) {
							cena = cena+1.00;
						}else if(cm==30) {
							cena = cena+1.70;
						}else if(cm==40) {
							cena = cena+2.00;
						}else if(cm==50) {
							cena = cena+2.70;
						}
						klientuMasivs[i].nomainitcm(cm);
						skaits = Integer.parseInt(JOptionPane.showInputDialog("Cik picas klients tādas pašas sūtīs?"));	
						}while(cm<10 || cm>50);
							
						cena = norekinasanas(cena,skaits,piegadesCena);
						klientuMasivs[i].jaunaCena(cena);
						klientuMasivs[i].izvaditCenu();
						}
					}
				if(atrasts == false) {
					JOptionPane.showMessageDialog(fr, "Tādu klientu nevar atrast", "Brīdinājums",JOptionPane.WARNING_MESSAGE);
				}
				break;
			case "izvadit":
				 atrasts = false;
				klientaVards = JOptionPane.showInputDialog("Ievadi Klienta vārdu: ");
				for(int i=0; i<klientuMasivs.length; i++) {
					if(klientaVards.equalsIgnoreCase(klientuMasivs[i].noteiktVardu())){
						atrasts = true;
						klientuMasivs[i].izvadit();
						}
					}
				if(atrasts == false) {
					JOptionPane.showMessageDialog(fr, "Tādu klientu nevar atrast", "Brīdinājums",JOptionPane.WARNING_MESSAGE);
				}
				break;
			case "saglabat datus faila":
				atrasts = false;
				klientaVards = JOptionPane.showInputDialog("Ievadi Klienta vārdu: ");
				for(int i=0; i<klientuMasivs.length; i++) {
					if(klientaVards.equalsIgnoreCase(klientuMasivs[i].noteiktVardu())){
						atrasts = true;
						klientuMasivs[i].saglabatFaila();
					}
				}
				if(atrasts == false) {
					JOptionPane.showMessageDialog(fr, "Tādu klientu nevar atrast", "Brīdinājums",JOptionPane.WARNING_MESSAGE);
				}
				break;
			case "nolasit datus no faila":
				nolasit();
				break;	
			case "stop": JOptionPane.showMessageDialog(fr, "Programma apturēta!", "Brīdinājums",JOptionPane.WARNING_MESSAGE); break;
			default: JOptionPane.showMessageDialog(fr, "Darbība nepastāv!", "Kļūme",JOptionPane.ERROR_MESSAGE); 
			}
		}while(!izvele.equals("stop"));
	}
}
