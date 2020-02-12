import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int licznik =0;
        char[][] plansza = new char[n][m];
        String ciag = new String();
        for (int i = 0; i <= n; i++) {
            ciag += s.nextLine();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                plansza[j][i] = ciag.charAt(licznik);
                licznik++;
            }
        }
        int liczba = s.nextInt();
        String[] szukaneSlowa = new String[liczba];
        for (int i = 0; i < liczba; i++) {
            szukaneSlowa[i] = s.next();
        }
        for (int i = 0; i < szukaneSlowa.length; i++) {
            if (szukanie(plansza, szukaneSlowa[i], n, m)){
                System.out.println("TAK");
            }else {
                System.out.println("NIE");
            }
        }
    }

    /*
    Do zastosowania rekurencja (aby obsluzyc np. wystepowanie tej samej literki u gory i na prawo

     */
    public static boolean szukanie(char[][] plansza, String s, int n, int m) {
        int x = 0;
        int y = 0;
        for (int a = 0; a < s.length(); a++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a == 0){
                        if (s.charAt(a)==plansza[i][j]){
                            x = j;
                            y = i;
                        }else if (i == n-1 && j == m-1){
                            return false;
                        }
                    }else {

                        if(a == s.length()-1 && plansza[y-1][x] == s.charAt(a)){
                            return true;
                        }else if(a == s.length()-1 && plansza[y+1][x]==s.charAt(a)){
                            return true;
                        }else if(a == s.length()-1 && plansza[y][x-1]==s.charAt(a)){
                            return true;
                        }else if(a == s.length()-1 && plansza[y][x+1]==s.charAt(a)){
                            return true;//
                        }else if(plansza[y-1][x]==s.charAt(a)){
                            y -= 1;
                        }else if(plansza[y+1][x]==s.charAt(a)){
                            y += 1;
                        }else if(plansza[y][x-1]==s.charAt(a)){
                            x -= 1;
                        }else if(plansza[y][x+1]==s.charAt(a)){
                            x += 1;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void wypisz(char[][] plansza, int m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(plansza[j][i]);
            }
            System.out.println();
        }
    }
}



