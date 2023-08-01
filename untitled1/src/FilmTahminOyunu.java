import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FilmTahminOyunu {

    static Scanner scanner = new Scanner(System.in);

    static List<String> filmler = new ArrayList<>(Arrays.asList("JOKER", "BATMAN", "SUPERMAN", "THOR", "IRONMAN"));



    public static void main(String[] args) {

        System.out.println("Oyuna hoşgeldiniz");
        System.out.println("1 ile "+filmler.size() +" arasında bır sayı giriniz");
        int sayi = scanner.nextInt();

        filmGetir(filmler,sayi-1);

    }

    public static void filmGetir(List<String> film, int index ){

        StringBuilder tahminEdilecekFilm = new StringBuilder(FilmTahminOyunu.filmler.get(index).replaceAll("\\w","-"));
        System.out.println(tahminEdilecekFilm);
        System.out.println(film.get(index).length()+" harfli film sectiniz "+ 2*film.get(index).length()+" kadar hakkınız var");

        char harf = ' ';
        int tahminSayısı=0;
        int dogruTahmınSayısı=0;
        String str="";

        do {

            System.out.println("Yanlıs tahmın sayısı : "+(tahminSayısı-dogruTahmınSayısı) + "/"+2*film.get(index).length()+ "\ntahmın ettıgınız harfı gırınız : ");
            harf=scanner.next().toUpperCase().charAt(0);
            str+=harf;
            if(!tahminEdilecekFilm.toString().contains(str)){

                tahminSayısı++;

            }
            if(tahminEdilecekFilm.toString().contains(str)){

                System.out.println("Harf zaten acıldı ");

            }

            for (int i=0; i<tahminEdilecekFilm.length();i++) {

                if(film.get(index).charAt(i)==harf){

                    if(!tahminEdilecekFilm.toString().contains(film.get(index).substring(i , i+1))){
                        dogruTahmınSayısı++;
                    }
                tahminEdilecekFilm.setCharAt(i,harf);
                }

            }


            if(tahminEdilecekFilm.toString().equals(film.get(index))) {
                System.out.println("Tebrikler kazandınız");

                System.out.println("Tahmin ettiginiz film : " + tahminEdilecekFilm);
                break;
            }

            System.out.println(tahminEdilecekFilm);

        }while((dogruTahmınSayısı-tahminSayısı) !=  2*film.get(index).length());{

            if((tahminSayısı-dogruTahmınSayısı) == 2-film.get(index).length()){

                System.out.println("Yanlıs tahmın sayısı :" + (tahminSayısı-dogruTahmınSayısı));
                System.out.println("GAME OVER FİLM : "+ film.get(index));

            }

        }

    }
}
