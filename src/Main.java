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
            boolean znaleziono = false;
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if (!znaleziono && szukaneSlowa[i].charAt(0)==plansza[j][k]){ // jesli nie znaleziono sprawdza literke
                        if (szukanieBezForow(plansza, szukaneSlowa[i], n, m, ktoraLitera+1, k, j)){
                            System.out.println(szukaneSlowa[i] + " TAK");
                            znaleziono = true;
                        }
                    }
                }
            }
            if (!znaleziono) {
                System.out.println(szukaneSlowa[i] + " NIE");
            }
        }
    }

    // poprawic sobie aby tablica byla prawidlowo zapisana (zgodnie z wejsciem) tj. zamienic kolumny z wierszami
    public static boolean szukanieBezForow(char[][] plansza, String s, int wysokosc, int szerokosc, int ktoraLitera, int x, int y) { // x,y - aktualna pozycja "kursor"
        if (ktoraLitera==s.length()){ // jesli znalezlismy wszystkie litery to znaczy ze da sie ulozyc takie slowo
            return true;
        }

        boolean wynik = false;
        if (y-1 >= 0 && s.charAt(ktoraLitera) == plansza[y-1][x]){
            wynik = szukanieBezForow(plansza, s, wysokosc, szerokosc, ktoraLitera+1, x, y-1) || wynik; // przepisujemy true jesli ktorykolwiek z nich byl true
        }
        if (y+1 <= wysokosc-1 && s.charAt(ktoraLitera) == plansza[y+1][x]){
            wynik = szukanieBezForow(plansza, s, wysokosc, szerokosc, ktoraLitera+1, x, y+1) || wynik;
        }
        if (x-1 >= 0 && s.charAt(ktoraLitera) == plansza[y][x-1]){
            wynik = szukanieBezForow(plansza, s, wysokosc, szerokosc, ktoraLitera+1, x-1, y) || wynik;
        }
        if (x+1 <= szerokosc-1 && s.charAt(ktoraLitera) == plansza[y][x+1]){
            wynik = szukanieBezForow(plansza, s, wysokosc, szerokosc, ktoraLitera+1, x+1, y) || wynik;
        }

        return wynik;
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
                } else if (ktore < s.length()-1) {
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
                }else {
                    if (y-1 >= 0 && s.charAt(ktore) == plansza[y-1][x]){
                        return true;
                    }
                    if (y+1 <= n-1 && s.charAt(ktore) == plansza[y+1][x]){
                        return true;
                    }
                    if (x-1 >= 0 && s.charAt(ktore) == plansza[y][x-1]){
                        return true;
                    }
                    if (x+1 <= m-1 && s.charAt(ktore) == plansza[y][x+1]) {
                        return true;
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



