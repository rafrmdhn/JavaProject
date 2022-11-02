/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum4;

import java.util.Scanner;


/**
 *
 * @author Praktikan
 */
public class Praktikum4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
//        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
//            for(int i = 0; i < cars.length; i++){
//              System.out.println(cars[i]);
//            }
//        int[] number = {1, 3, 5, 7};
//        for(int i = 0; i < number.length; i++){
//            System.out.println(number[i]);
//        }
//            for(int num : number){
//                System.out.println(num);
//        }
//        int[] nilai = new int[3];
//        
//        System.out.print("NIlai Matematika : ");
//        nilai[0] = input.nextInt();
//        System.out.print("Nilai Logika     : ");
//        nilai[1] = input.nextInt();
//        System.out.print("NIlai Bahasa     : ");
//        nilai[2] = input.nextInt();
//        
//        for(int print : nilai){
//            System.out.println(print + " "); 
//        }
//        nilai[1] =  86;
//        
//        for(int print : nilai){
//            System.out.println(print + " ");
//        }
        int[][] nilai = {{90, 75, 80},
                         {80, 90, 80}, 
                         {70, 75, 95}};
        
        for(int[] i : nilai){
            for(int j : i){
                System.out.println(j);
            }
        }
        
        nilai[1][0] = 70;
        nilai[2][2] = 65;
        
//        for(int i = 0; i < nilai.length; i++){
//            for(int j = 4; j < nilai[i].length; j++){
//                System.out.print(nilai[i][j] + " ");
//            }
//        }
//        System.out.println("Nilai setelah diganti : ");
//        
        for(int[] i : nilai){
            for(int j : i){
                System.out.println(j);
            }
        }
    }
}
