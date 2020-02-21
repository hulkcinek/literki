import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int licznik =0;
        int ktoraLitera = 0;
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
            if (szukanie(plansza, szukaneSlowa[i], n, m, ktoraLitera, 0, 0)){
                System.out.println(szukaneSlowa[i] + " TAK");
            }else {
                System.out.println(szukaneSlowa[i] + "NIE");
            }
        }
    }

    /*
    Do zastosowania rekurencja (aby obsluzyc np. wystepowanie tej samej literki u gory i na prawo

     */
    public static boolean szukanie(char[][] plansza, String s, int n, int m, int ktore, int x, int y) {
        for (int i = 0; i < n; i++) { // czy te petle (obie) sa potrzebne? jak je zmienic? czy trzeba?
            for (int j = 0; j < m; j++) {
                if (ktore == 0) {
                    if (s.charAt(0) == plansza[i][j]) {
                        x = j;
                        y = i;
                        ktore++;
                        szukanie(plansza, s, n, m, ktore, x, y);
                    } else if (i == n - 1 && j == m - 1) {
                        return false;
                    }
                } else {
                    if (y-1 >= 0 && s.charAt(ktore) == plansza[y-1][x]){
                        szukanie(plansza, s, n, m, ktore+1, x, y-1);
                    }
                    if (y+1 <= n-1 && s.charAt(ktore) == plansza[y+1][x]){
                        szukanie(plansza, s, n, m, ktore+1, x, y+1);
                    }
                    if (x-1 >= 0 && s.charAt(ktore) == plansza[y][x-1]){
                        szukanie(plansza, s, n, m, ktore+1, x-1, y);
                    }
                    if (x+1 <= m-1 && s.charAt(ktore) == plansza[y][x+1]){
                        szukanie(plansza, s, n, m, ktore+1, x+1, y);
                    }





//                        if (ktore == s.length() - 1 && plansza[y - 1][x] == s.charAt(a)) {
//                            return true;
//                        } else if (ktore == s.length() - 1 && plansza[y + 1][x] == s.charAt(a)) {
//                            return true;
//                        } else if (ktore == s.length() - 1 && plansza[y][x - 1] == s.charAt(a)) {
//                            return true;
//                        } else if (ktore == s.length() - 1 && plansza[y][x + 1] == s.charAt(a)) {
//                            return true;//
//                        } else if (plansza[y - 1][x] == s.charAt(a)) {
//                            y -= 1;
//                        } else if (plansza[y + 1][x] == s.charAt(a)) {
//                            y += 1;
//                        } else if (plansza[y][x - 1] == s.charAt(a)) {
//                            x -= 1;
//                        } else if (plansza[y][x + 1] == s.charAt(a)) {
//                            x += 1;
                }
            }
        }
        return false;
    }
//    public static boolean szukanie(char[][] plansza, String s, int n, int m) {
//        int x = 0;
//        int y = 0;
//        for (int a = 0; a < s.length(); a++) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (a == 0){
//                        if (s.charAt(a)==plansza[i][j]){
//                            x = j;
//                            y = i;
//                        }else if (i == n-1 && j == m-1){
//                            return false;
//                        }
//                    }else {
//
//                        if(a == s.length()-1 && plansza[y-1][x] == s.charAt(a)){
//                            return true;
//                        }else if(a == s.length()-1 && plansza[y+1][x]==s.charAt(a)){
//                            return true;
//                        }else if(a == s.length()-1 && plansza[y][x-1]==s.charAt(a)){
//                            return true;
//                        }else if(a == s.length()-1 && plansza[y][x+1]==s.charAt(a)){
//                            return true;//
//                        }else if(plansza[y-1][x]==s.charAt(a)){
//                            y -= 1;
//                        }else if(plansza[y+1][x]==s.charAt(a)){
//                            y += 1;
//                        }else if(plansza[y][x-1]==s.charAt(a)){
//                            x -= 1;
//                        }else if(plansza[y][x+1]==s.charAt(a)){
//                            x += 1;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }

    public static void wypisz(char[][] plansza, int m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(plansza[j][i]);
            }
            System.out.println();
        }
    }
}



