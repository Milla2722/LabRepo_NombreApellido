package labrepo_arnoldmilla;
import java.util.*;

public class LabRepo_ArnoldMilla {
static Scanner sc = new Scanner(System.in);
static Random rand = new Random();    
    public static void main(String[] args) {
        System.out.println("1. Dungeons and Dragons");
        System.out.println("2. Laberinto");
        System.out.println("3. Salir");
        System.out.println("Ingrese una opcion [1,2,3]");
        int op = sc.nextInt();  
            while (op > 0 && op < 3){
                switch(op){
                    case 1:{
                        char seguir = 's';                                                
                        int hp;
                        int energy;
                        System.out.println("------------------D&D------------------");
                        System.out.println("Elija el personaje que quiera ser \n Mago [M]    Caballero[C]");
                        char personaje = sc.next().charAt(0);
                        System.out.println(personaje);
                                            ////Validaciones de char
                        while (personaje != 'C' && personaje != 'c' && personaje != 'M' && personaje != 'm'){
                            System.out.println("Personaje equivocado o no disponible elija otro \n Mago [M]    Caballero[C]");
                            personaje = sc.next().charAt(0);
                        }
                        if (personaje == 'm' || personaje == 'M'){
                            System.out.println("Has elegido Mago!" );
                            hp = 150;
                            energy = 230;
                            System.out.println("Puntos de vida: " + hp);
                            System.out.println("Puntos de energia: " + energy);
                            System.out.println("Ataque: 50");
                        }
                        else if (personaje == 'C' || personaje == 'c'){
                            System.out.println("Has elegido Caballero!" );
                            hp = 250;
                            energy = 50;
                            System.out.println("Puntos de vida: " + hp);
                            System.out.println("Puntos de energia: " + energy);
                            System.out.println("Ataque: 50");
                        }
                        char [][] tablero = inicializar(personaje);
                        imprimirT(tablero);
                        System.out.println("Presione 's' para seguir adelante.... ");
                        seguir = sc.next().charAt(0);
                                   ///////////////Juego
                        while (seguir == 's' || seguir == 'S'){
                           int dado = rand.nextInt(1,17);
                            System.out.println("Usted saco: " + dado);
                            tablero = movimiento(dado,tablero,personaje);
                            imprimirT(tablero);
                            System.out.println("Presione 's' para seguir adelante.... ");
                            seguir = sc.next().charAt(0);
                        }                     
                        
                    }break; 
                                        ///////fin dungeons and dragons
                    case 2:{
                        
                        System.out.println("----Maze---- \n Llegue hasta el final");
                        char maze [][] = creator();
                        char mov;
                        int w = 0;
                                
                        System.out.println("");
                        System.out.println("Ingrese H para salida de emergencia");                       
                        imprimir(maze);
                        //inicio del juego
                        while (w == 0){                           
                            if (maze [2][9] == 'C'){
                                System.out.println("Felicidades llegó al final");
                                break;
                            }
                            System.out.println("Ingrese un movimiento (w/a/s/d/h)");
                            mov = sc.next().charAt(0);
                            if(mov != 'w' && mov != 'a' && mov != 's' && mov != 'd' && mov != 'h' && mov != 'W' && mov != 'A' && mov != 'S' && mov != 'D' && mov != 'H'){
                                System.out.println("Movimiento no valido ingrese otro (w/a/s/d/h)");
                                mov = sc.next().charAt(0);
                            }
                                    
                            if (mov == 'h' || mov == 'H'){
                                System.out.println("Un helicoptero despliega una escalera sobre ti para que escapes");
                                break;
                            }
                            maze = game(maze, mov);
                            imprimir(maze);
                        }
                        System.out.println("");
                    }break;
                                        ////////fin maze runner
                }
            System.out.println("1. Dungeons and Dragons");
            System.out.println("2. Laberinto");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opcion [1,2,3]");
            op = sc.nextInt();                  
            }
    }//fin main 
    
    ////////////////funcion para inicializar el tablero y que no se vea en el main
    public static char [][] inicializar(char personaje){
        char tablero [][] = {{personaje,'♥','-','♥','-','-','♥','-','-','♥'},
                             {'-','▲','-','-','-','-','-','-','▲','-'},
                             {'-','♥','▲','♥','-','-','♥','▲','-','-'},
                             {'-','-','-','▲','-','-','▲','-','-','-'},
                             {'-','♥','-','♥','▲','▲','♥','-','-','♥'},
                             {'-','-','-','-','▲','▲','-','-','-','-'},
                             {'-','♥','-','♥','-','-','♥','-','-','♥'},
                             {'-','-','▲','-','-','-','-','▲','-','-'},
                             {'-','♥','-','♥','-','-','♥','-','▲','♥'},
                             {'▲','-','-','-','-','-','-','-','-','-'}};
        return tablero;
    }
    
    ////////////////////funcion para movimiento del personaje por la matriz
    public static char[][] movimiento (int dado,char tablero[][], char personaje){
        int dado1;
        int dado2 = 0;
        
        if (dado > 9){
            dado1 = dado - 9;
            dado2 = dado - dado1;
        }
        else{
            dado1 = dado;
        }
            
        
        for (int cont = 0; cont < 10; cont++) {
            for (int contador = 0; contador < 10; contador++) {
                if (tablero [cont][contador] == personaje){
                    tablero[cont][dado1] = personaje;
                    break;
                }
            }
            if (dado > 9){
                tablero [cont + 1][dado2] = personaje;
                break;
            }    
        }        
        return tablero;
    }
    
    //////////////////////funcion para crear el laberinto con for tambien se puede hacer como el que está arriba
    public static char [][] creator(){
        char matriz [][] = new char [8][10];
        
            for (int cont = 0; cont < matriz.length; cont++) {
                for (int contador = 0; contador < matriz[cont].length; contador++) {
                    matriz[cont][contador] = '#';
                    switch (cont){
                        case 1:{
                            if(contador == 3 || contador == 4 || contador == 5 || contador == 8){
                                matriz[cont][contador] = ' ';
                            }
                            if (contador == 1){
                                matriz[cont][contador] = 'C';
                            }
                        }break;
                        // linea 2    
                        case 2:{
                            if (contador == 1 || contador == 3 || contador == 7 || contador == 8 || contador == 9){
                                matriz[cont][contador] = ' ';
                            }
                        }break;
                        // linea 3 
                        case 3:{
                            if (contador == 1 || contador == 3 || contador == 4 || contador == 5 || contador == 7){
                                matriz[cont][contador] = ' ';
                            }
                        }break;
                        // linea 4 
                        case 4:{
                            if(contador == 1 || contador == 2 || contador == 3 || contador == 5 || contador == 7 || contador == 8){
                                matriz[cont][contador] = ' ';
                            }
                        }break;
                        // linea 5 
                        case 5:{
                            if (contador == 1 || contador == 3 || contador == 5 || contador == 8){
                                matriz[cont][contador] = ' ';
                            }
                        }break;
                        // linea 6
                        case 6:{
                            if(contador == 1 || contador == 3 || contador == 5 || contador == 6 || contador == 7 || contador == 8){
                                matriz[cont][contador] = ' ';
                            }                       
                        }break; 
                        // linea 7 
                    }         
                }
            }
        return matriz;
    } 
    
    //funcion para laberinto
    public static char [][] game (char maze [][],char mov){
        int tnoc = 0;
        for (int cont = 0; cont < maze.length; cont++) {
            for (int contador = 0; contador < maze[cont].length; contador++) {
                if (maze [cont][contador] == 'C'){
                    maze [cont][contador] = ' ';
                    //movimiento para arriba
                    if (mov == 'w' || mov == 'W'){
                        if(maze [cont - 1][contador] != '#'){
                            maze [cont - 1][contador] = 'C';
                        }
                        else{
                            System.out.println("No puede moverse sobre un numeral");
                            maze [cont][contador] = 'C';
                        }
                    }
                    //movimiento a la izquierda
                    else if (mov == 'a' || mov == 'A'){
                        if(maze [cont][contador - 1] != '#'){
                            maze [cont][contador - 1] = 'C';
                        }
                        else{
                            System.out.println("No puede moverse sobre un numeral");
                            maze [cont][contador] = 'C';
                        }
                        
                    }
                    //movimiento para abajo
                    else if (mov == 's' || mov == 'S'){
                        if(maze [cont + 1][contador] != '#'){
                            maze [cont + 1][contador] = 'C';
                        }
                        else{
                            System.out.println("No puede moverse sobre un numeral");
                            maze [cont][contador] = 'C';
                        }                        
                    }
                    //movimiendo a la derecha
                    else if (mov == 'd' || mov == 'D'){
                        if(maze [cont][contador + 1] != '#'){
                            maze [cont][contador + 1] = 'C';
                        }
                        else{
                            System.out.println("No puede moverse sobre un numeral");
                            maze [cont][contador] = 'C';
                        }
                    }
                tnoc ++;
                break;    
                }
            }
            if (tnoc != 0){
                break;
            }
        }
        return maze;
    }  
    
    ///////////////////funcion para imprimir tablero
    public static void imprimirT (char[][] tablero){
        for (int cont = 0; cont < tablero.length; cont++) {
            for (int contador = 0; contador < tablero[cont].length; contador++) {
                System.out.print(tablero[cont][contador]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    
    ///////////funcion para imprimir matrices sin diseño
    public static void imprimir (char [][] maze){
        for (int cont = 0; cont < maze.length; cont++) {
            for (int contador = 0; contador < maze[cont].length; contador++) {
                System.out.print(maze[cont][contador]);
            }
            System.out.println("");
        }
    }
}
