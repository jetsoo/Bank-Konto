import java.util.Scanner;


public class Program {
	
	public static void income(Konto konto1, int amountIncome)
	{
		konto1.setBalance(konto1.getBalance() + amountIncome);
	}
	
	public static void withdraw(Konto konto1, int withDrawal) 
	{
		konto1.setBalance(konto1.getBalance() - withDrawal);
	}
	
	public static void moveMoney(Konto kontoWithdraw, Konto kontoIncome) 
	{
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Geben sie den Betrag zum verschieben ein");
		int eingabeMove = scan2.nextInt();
		kontoIncome.setBalance(kontoIncome.getBalance() + eingabeMove);
		kontoWithdraw.setBalance(kontoWithdraw.getBalance() - eingabeMove);
		System.out.println("Neuer Kontostand von " + kontoWithdraw.getAccountName() + " beträgt " + kontoWithdraw.getBalance() + "€");
		System.out.println("Neuer Kontostand von " + kontoIncome.getAccountName() + " beträgt " + kontoIncome.getBalance() + "€");
	}
	
	public static void passwordEingabe() 
	{
		System.out.println("Geben Sie Ihr Passwort ein");
	}
	
	public static void passwordFalsch()
	{
		System.out.println("Falsches Passwort");
	}
	
	public static void checkKontostand(Konto konto1) 
	{
		System.out.println("Ihr KontoStand beträgt " + konto1.getBalance() +"€");
	}
	
	public static void karteGesperrt()
	{
		System.out.println("Zuviele versuche, Ihre Karte wurde gesperrt");
	}

	public static void main(String[] args) {
		
		Konto sven = new Konto("Sven Melo", 1000, 4960);
		Konto jimmy = new Konto("Jimmy Begood", 1000, 5893);
		Konto johnny = new Konto("Johnny Begood", 500, 1735);
		Konto burns = new Konto("Burns Star", 1500, 5728);
		Konto[] kontoListe = {sven, jimmy, johnny, burns};
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Wählen Sie Ihr Konto:");
		System.out.println("1 Sven  2 Jimmy  3 Johnny  4 Burns");
		int kontoNr = scan.nextInt();
		kontoNr -= 1;
		
		System.out.println("Wählen Sie eine funktion:");
		System.out.println("1 Abhebung  2 Einzahlung  3 Kontostand  4 Kontobewegungen");
		int eingabe = scan.nextInt();
		
		switch(eingabe) 
		{
			case 1: int passwordVersuche = 0;		//withdrawal
					while(passwordVersuche < 3) 
					{
						passwordEingabe();
						int eingabePassword = scan.nextInt();
						if(eingabePassword == kontoListe[kontoNr].getPassword()) 
						{
							System.out.println("Geben sie den Betrag zur Abhebung ein");
							int eingabeBetrag = scan.nextInt();
							withdraw(kontoListe[kontoNr], eingabeBetrag);
							System.out.println("Ihr Betrag wurde ausgegeben ");
							checkKontostand(kontoListe[kontoNr]);break;
						}
						if(eingabePassword != kontoListe[kontoNr].getPassword())
						{
							passwordFalsch();
							passwordVersuche++;
						}
					}
					if(passwordVersuche < 3) 
					{
						break;
					}
					karteGesperrt();
					break;
			
			case 2: System.out.println("Stecken Sie Ihren Einzahlungsbetrag in die Vorrichtung dafür");			//income
					int eingabeEinzahlung = scan.nextInt();
					income(kontoListe[kontoNr], eingabeEinzahlung);
					checkKontostand(kontoListe[kontoNr]);
					break;
			
			case 3: int passwordVersuche2 = 0;		// kontostand
					while(passwordVersuche2 < 3) 
					{
						passwordEingabe();
						int eingabePassword2 = scan.nextInt();
						if(eingabePassword2 == kontoListe[kontoNr].getPassword()) 
						{
							checkKontostand(kontoListe[kontoNr]);
							break;
						}
						if(eingabePassword2 != kontoListe[kontoNr].getPassword())
						{
							passwordFalsch();
							passwordVersuche2++;
						}
					}
					if(passwordVersuche2 < 3)
					{
						break;
					}
					karteGesperrt();
					break;
			
			case 4: System.out.println("Wählen Sie das Konto zur Abhebung, danach zur Einzahlung");  //movemoney
					System.out.println("Abhebungskonto:  1 Sven  2 Jimmy  3 Johnny  4 Burns");
					int eingabeAbhebung = scan.nextInt();
					eingabeAbhebung -= 1;
					int passwordVersuche3 = 0;
					while(passwordVersuche3 < 3) 
					{ 
						passwordEingabe();
						int eingabePassword3 = scan.nextInt();
					
						if(eingabePassword3 == kontoListe[eingabeAbhebung].getPassword()) 
						{
						
							System.out.println("Einzahlungskonto:  1 Sven  2 Jimmy  3 Johnny  4 Burns");
							int eingabeEinzahlung2 = scan.nextInt();
							eingabeEinzahlung2 -= 1;
							int passwordVersuche4 = 0;
							while(passwordVersuche4 < 3)
							{
								passwordEingabe();
								int eingabePassword4 = scan.nextInt();
						
								if(eingabePassword4 == kontoListe[eingabeEinzahlung2].getPassword()) 
								{
							
									moveMoney(kontoListe[eingabeAbhebung], kontoListe[eingabeEinzahlung2]);
									break;
								}
								if(eingabePassword4 != kontoListe[eingabeEinzahlung2].getPassword())
								{
									passwordFalsch();
									passwordVersuche4++;
								}
							}
							if(passwordVersuche4 < 3)
							{
								break;
							}
							karteGesperrt();
							break;
						}
			
						if(eingabePassword3 != kontoListe[eingabeAbhebung].getPassword())
						{
							passwordFalsch();
							passwordVersuche3++;
						}	
					}
					if(passwordVersuche3 < 3)
					{
						break;
					}
					karteGesperrt();
					break;
		}
		System.out.println("Vielen Dank für ihr Vetrauen");
	}

}
