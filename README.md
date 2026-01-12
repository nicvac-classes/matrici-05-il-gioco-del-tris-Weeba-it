[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=22195423)
|Attenzione|
|----------|
|Per leggere correttamente questo documento, click destro su README.md e selezionare Open Preview.|

# Il gioco del Tris
Implementiamo il gioco del tris, utilizzando una matrice per la memorizzazione dei dati.

## Il problema
Lo scopo di questo problema è implementare il gioco del Tris (o Tic Tac Toe) utilizzando una matrice bidimensionale. Il gioco del Tris è un classico gioco da tavolo per due giocatori, dove uno utilizza "X" e l'altro "O", alternandosi per segnare le caselle di una griglia 3x3. Il giocatore che riesce a ottenere tre segni allineati in orizzontale, verticale o diagonale vince il gioco.


Il gioco finale apparirà come segue:
```
Giocatore X, inserisci la tua mossa (riga e colonna):
2
2

Griglia di gioco:
-  -  -
-  X  -
-  -  -

Giocatore O, inserisci la tua mossa (riga e colonna):
1
1

Griglia di gioco:
O  -  -
-  X  -
-  -  -

ecc...

Griglia di gioco:
O  -  X
O  X  -
O  X  O
Giocatore O ha vinto!

```

## L’analisi e la strategia risolutiva
* Creare una matrice bidimensionale 3x3 che rappresenti la griglia di gioco del Tris.
* Alternare tra i giocatori "X" e "O" per ogni mossa.
* Chiedere ai giocatori di inserire le loro mosse indicando la riga e la colonna desiderate (nell'intervallo da 1 a 3).
* Verificare la validità di ogni mossa, assicurandosi che la casella selezionata sia vuota.
* Aggiornare e visualizzare la griglia di gioco con la mossa del giocatore.
* Controllare se uno dei giocatori ha vinto (ottenendo tre segni allineati) o se la griglia è piena (pareggio).

Avremo bisogno delle seguenti funzioni:
* *azzeraGriglia*: Azzera la griglia di gioco inserendo la stringa "-" in tutte le celle.
* *inserisciInGriglia*: Inserisce il simbolo X oppure O nella grigla di gioco. Se la mossa non è valida (la pedina è già presente o le coordinate fuori la griglia) allora ritorno falso.
* *controllaVincita*: Controlla se nella griglia c'è una vincita.
* *contaCaselleLibere*: Per controllare se c'è un pareggio controlleremo se non ci sono più caselle disponibili.
* Nella funzione principale faremo giocare a turno i due giocatori finchè non si verificherà un pareggio o una vincita.

## Implementazione della soluzione

Nel file *Esercizio.java*, completa il contenuto della funzione *azzeraGriglia*, che inserisce il simbolo "-" in tutte le celle della griglia di gioco.

La funzione deve avere i seguenti parametri:
* Parametro di input/output: matrice G da riempire con "-".
* Parametri di input: righe e colonne, che rappresentano di quante righe e colonne è composta la matrice.
* Parametri di output: nessuno.

<hr/>
<details>
  <summary>Solo dopo aver svolto l'esercizio, apri qui per vedere la soluzione</summary>

```Java
    static void azzeraGriglia(String[][] G, int righe, int colonne) {
        for (int i=0; i<=righe-1; i=i+1) {
            for (int j=0; j<=colonne-1; j=j+1) {
                G[i][j] = "-";
            }
        } 
    }
```
</details>
<hr/>

Nel file *Esercizio.java*, completa il contenuto della funzione *inserisciInGriglia*, che Inserisce il simbolo "X" oppure "O" nella grigla di gioco in riga i e colonna j.
Se la mossa non è valida (pedina già presente o le coordinate sono fuori la griglia) allora ritorno falso. 

La funzione deve avere i seguenti parametri:
* Parametro di input/output: matrice G che rappresenta la griglia di gioco.
* Parametri di input: i e j, che rappresentano le coordinate in cui inserire la pedina nella griglia. Il loro valore può essere 1, 2 o 3 perchè la matrice è 3x3.
* Parametri di input: s, che rappresenta la pedina da inserire. Può essere "X" oppure "O".
* Parametri di output: vero se è possibile inserire la pedina in griglia. Falso altrimenti.

<hr/>
<details>
  <summary>Solo dopo aver svolto l'esercizio, apri qui per vedere la soluzione</summary>

```Java
static boolean inserisciInGriglia( String[][] G, int i, int j, String s) {
    boolean mossaCorretta = false;
    //controllo se le coordinate possono essere accettate.
    //Il giocatore usa le coordinate come [1..3]. Nella matrice usiamo [0..2]
    // quindi sistemo le coordinate
    i = i-1;
    j = j-1;
    boolean coordinateCorrette = ( 0<=i && i<=2 && 0<=j && j<=2 ) ;
    //controllo se la casella è disponibile
    if (coordinateCorrette ) {
        if ( G[i][j].equals("-") ) {
            mossaCorretta = true;
        }
    }  
    //Piazzo la pedina se la mossa è consentita
    if (mossaCorretta) {
        G[i][j] = s;
    }
    
    return mossaCorretta;  
}
```
</details>
<hr/>

Nel file *Esercizio.java*, completa il contenuto della funzione *controllaVincita*, che controlla se nella griglia c'è una vincita per X o per O. Una pedina vince se è allineata su una delle tre righe o su una delle tre colonne oppure su una delle due diagonali. 

La funzione deve avere i seguenti parametri:
* Parametro di input: matrice G che rappresenta la griglia di gioco.
* Parametro di input: s, che rappresenta la pedina di cui controllare la vincita. Può essere "X" oppure "O".
* Parametri di output: vero se s ha vinto. Falso altrimenti.

<hr/>
<details>
  <summary>Solo dopo aver svolto l'esercizio, apri qui per vedere la soluzione</summary>

```Java
static boolean controllaVincita(String[][] G, String s) {
    boolean vince = false;
    //Controllo la prima riga
    if ( G[0][0].equals(s) && G[0][1].equals(s) && G[0][2].equals(s) ) {
        vince = true;
    }
    //Controllo la seconda riga
    if ( !(vince) && G[1][0].equals(s) && G[1][1].equals(s) && G[1][2].equals(s) ) {
        vince = true;
    }
    //Controllo la terza riga
    if ( !(vince) && G[2][0].equals(s) && G[2][1].equals(s) && G[2][2].equals(s) ) {
        vince = true;
    }
    //Controllo la prima colonna
    if ( !(vince) && G[0][0].equals(s) && G[1][0].equals(s) && G[2][0].equals(s) ) {
        vince = true;
    }
    //Controllo la seconda colonna
    if ( !(vince) && G[0][1].equals(s) && G[1][1].equals(s) && G[2][1].equals(s) ) {
        vince = true;
    }
    //Controllo la terza colonna
    if ( !(vince) && G[0][2].equals(s) && G[1][2].equals(s) && G[2][2].equals(s) ) {
        vince = true;
    }
    //Controllo la prima diagonale
    if ( !(vince) && G[0][0].equals(s) && G[1][1].equals(s) && G[2][2].equals(s) ) {
        vince = true;
    }
    //Controllo la seconda diagonale
    if ( !(vince) && G[0][2].equals(s) && G[1][1].equals(s) && G[2][0].equals(s) ) {
        vince = true;
    }
    return vince;
}
```
</details>
<hr/>

La soluzione mostrata per controllare la vincita è la più semplice, ma può essere scritta in modo compatto.
Riscrivere la funzione in modo compatto.
<hr/>
<details>
  <summary>Solo dopo aver svolto l'esercizio, apri qui per vedere la soluzione</summary>

```Java
static boolean controllaVincita(String[][] G, String s) {
    //Controllo le righe e le colonne
    for (int i = 0; i < 3; i++) {
        if ((s.equals(G[i][0]) && s.equals(G[i][1]) && s.equals(G[i][2])) ||
            (s.equals(G[0][i]) && s.equals(G[1][i]) && s.equals(G[2][i])))   {
            return true;
        }
    }
    //Controllo le diagonali
    if ((s.equals(G[0][0]) && s.equals(G[1][1]) && s.equals(G[2][2])) ||
        (s.equals(G[0][2]) && s.equals(G[1][1]) && s.equals(G[2][0])))    {
        return true;
    }
}
```
</details>
<hr/>


Nel file *Esercizio.java*, completa il contenuto della funzione *contaCaselleLibere*, che conta quante caselle libere ci sono ancora. Se non ci sono caselle libere si avrà un pareggio.

La funzione deve avere i seguenti parametri:
* Parametro di input: matrice G che rappresenta la griglia di gioco.
* Parametri di output: quante caselle sono marcate come libere, cioè "-".

<hr/>
<details>
  <summary>Solo dopo aver svolto l'esercizio, apri qui per vedere la soluzione</summary>

```Java
static int contaCaselleLibere(String[][] G) {
    int count=0;
    for (int i=0; i<=2; i=i+1) {
        for (int j=0; j<=2; j=j+1) {
            if ( G[i][j].equals("-") ) {
                count = count + 1;
            }
        }
    } 
    return count;
}
```
</details>
<hr/>

Avendo tutte le funzioni a disposizione, è possibile ora scrivere la funzione *main*.

In *main()*, dichiarare la griglia di gioco 3x3, azzerare la matrice usando la funzione scritta in precedenza e visualizzarla con l'istruzione *UtilsMatrice.visualizza(matrice);*<br/>

<hr/>
<details>
  <summary>Solo dopo aver svolto l'esercizio, apri qui per vedere la soluzione</summary>

```Java
public static void main(String args[]) {
    //Creare una matrice 3x3 che rappresenti la griglia di gioco del Tris.
    String[][] griglia = new String[3][3];
    azzeraGriglia(griglia,3,3);
    //Mostro la griglia vuota
    
    System.out.println("Griglia di gioco:");
    UtilsMatrice.visualizza(griglia);
}
```
</details>
<hr/>

Chiedere al giocatore X di inserire le coordinate della sua pedina. Invocare la funzione *inserisciInGriglia* sia per inserire la pedina sulla grigia che per controllare che la mossa sia valida.<br/>
Se la mossa non è valida bisogna far ripetere l'inserimento delle coordinate.
Mostrare la griglia dopo aver piazzato la pedina del giocatore.

<hr/>
<details>
  <summary>Solo dopo aver svolto l'esercizio, apri qui per vedere la soluzione</summary>

```Java
public static void main(String args[]) {
    
    ... 

    //variabile per il giocatore corrente
    String s = "X";

    //Leggo la mossa del giocatore. Ciclo sulla richiesta finchè non inserisce una mossa valida.
    boolean mossaCorretta;
    int mossaI, mossaJ;
    do {
        System.out.println("Giocatore "+s+", inserisci la tua mossa (riga e colonna [1-3]):");
        mossaI = Integer.parseInt(input.nextLine());
        mossaJ = Integer.parseInt(input.nextLine());

        mossaCorretta = inserisciInGriglia(griglia, mossaI, mossaJ, s);
    
    } while( !(mossaCorretta) );

    //Mostro la griglia corrente
    System.out.println("Griglia di gioco:");
    UtilsMatrice.visualizza(griglia);
}
```
</details>
<hr/>

Controllare se nella griglia c'è una vincita per il giocatore X. Controllare la vincita invocando la funzione *controllaVincita*.
Controllare se c'è stato un pareggio, cioè se non ci sono caselle libere e X non ha vinto. Per contare le caselle disponibili invocare la funzione *contaCaselleLibere*.

<hr/>
<details>
  <summary>Solo dopo aver svolto l'esercizio, apri qui per vedere la soluzione</summary>

```Java
public static void main(String args[]) {
    ... 
    boolean haiVinto = controllaVincita(griglia, s);
    if (haiVinto) {
        System.out.println(s + " VINCE! ");
    }
    
    int caselleLibere = contaCaselleLibere(griglia);
    boolean pareggio = !(haiVinto) && (caselleLibere == 0);
    if ( pareggio ) {
        System.out.println(" PAREGGIO! ");
    }
}
```
</details>
<hr/>

Cambiare giocatore da X a O e mettere tutto in un loop finchè non si verifica una vincita o una perdita.

<hr/>
<details>
  <summary>Solo dopo aver svolto l'esercizio, apri qui per vedere la soluzione</summary>

```Java
public static void main(String args[]) {
  ... 
  String s = "X";

  //Ciclo finchè non ottengo una vincita
  boolean haiVinto = false;
  boolean pareggio = false;
  do {

      //QUI VA LA GIOCATA E IL CONTOLLO DI VINCITA O PAREGGIO, APPENA MOSTRATI
      ...

      //Cambia giocatore per il turno successivo
      if ( s.equals("X") ) {
          s = "O";
      } else {
          s = "X";
      }
  
      //Gioca ancora se non si è nè vinto nè pareggiato
  } while ( !(haiVinto) && !(pareggio) );
```
</details>
<hr/>

La funzione completa di main è quindi la seguente:
<hr/>
<details>
  <summary>Apri qui per vedere la soluzione</summary>

```Java
public static void main(String args[]) {
  //Creare una matrice 3x3 che rappresenti la griglia di gioco del Tris.
  String[][] griglia = new String[3][3];
  azzeraGriglia(griglia,3,3);

  //Mostro la griglia vuota
  System.out.println("Griglia di gioco:");
  UtilsMatrice.visualizza(griglia);

  //variabile per il giocatore corrente
  String s = "X";

  //Ciclo finchè non ottengo una vincita
  boolean haiVinto = false;
  boolean pareggio = false;
  do {

      //Leggo la mossa del giocatore. Ciclo sulla richiesta finchè non inserisce una mossa valida.
      boolean mossaCorretta;
      int mossaI, mossaJ;
      do {
          System.out.println("Giocatore "+s+", inserisci la tua mossa (riga e colonna [1-3]):");
          mossaI = Integer.parseInt(input.nextLine());
          mossaJ = Integer.parseInt(input.nextLine());
          mossaCorretta = inserisciInGriglia(griglia, mossaI, mossaJ, s);
      } while( !(mossaCorretta) );

      //Mostro la griglia corrente
      System.out.println("Griglia di gioco:");
      UtilsMatrice.visualizza(griglia);

      haiVinto = controllaVincita(griglia, s);
      if (haiVinto) {
          System.out.println(s + " VINCE! ");
      }
      
      int caselleLibere = contaCaselleLibere(griglia);
      pareggio = !(haiVinto) && (caselleLibere == 0);
      if ( pareggio ) {
          System.out.println(" PAREGGIO! ");
      }

      //Cambia giocatore per il turno successivo
      if ( s.equals("X") ) {
          s = "O";
      } else {
          s = "X";
      }

      //Gioca ancora se non si è nè vinto nè pareggiato
  } while ( !(haiVinto) && !(pareggio) );
  
}
```
</details>
<hr/>

Eseguire il programma per controllare che l'output sia analogo al seguente:
```
Griglia di gioco:
[- - -]
[- - -]
[- - -]

Giocatore X, inserisci la tua mossa (riga e colonna [1-3]):
1
1

Griglia di gioco:
[X - -]
[- - -]
[- - -]

Giocatore O, inserisci la tua mossa (riga e colonna [1-3]):
2
2

Griglia di gioco:
[X - -]
[- O -]
[- - -]

...

Giocatore X, inserisci la tua mossa (riga e colonna [1-3]):
3
2

Griglia di gioco:
[X - O]
[O O -]
[X X X]

X VINCE! 
```
