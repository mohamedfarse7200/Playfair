package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    static char matrix[][] = new char[5][5];
    public static String format(String plan)
    {
        StringBuilder temp = new StringBuilder();
        for (int i=0;i<plan.length();i++)
        {
            if(plan.charAt(i)=='j')
            {
                temp.append('i');
            }
            else
            {
                temp.append(plan.charAt(i));
            }

        }
        for (int i=0;i<plan.length();i+=2)
        {
            if(temp.charAt(i)==temp.charAt(i+1))
            {
                temp.insert(i+1, 'x');
            }
        }
        plan=temp.toString();
        if(plan.length()%2!=0)
        {
            plan+='x';
        }
        return plan;
    }
    public static String [] dividetopairs(String plan)
    {
        String x[]=new String [plan.length()/2];
        int c=0;
        for(int i=0;i<plan.length()/2;i++)
        {
            x[i]=plan.substring(c,c+2);
            c+=2;
        }
        return x;
    }


    public static char[][] matrix(String key)
    {

        String alphabet = "abcdefghiklmnopqrstuvwxyz";
        String key_adj = key + alphabet;
        if (key_adj.contains("j"))
        {
            key_adj = key_adj.replace("j", "i");
        }
        char [] c=key_adj.toCharArray();
        ArrayList<Character> adjust = new ArrayList<Character>();
        for (Character x : c)
        {
            if(!adjust.contains(x))
            {
                adjust.add(x);
            }

        }
        int k=0;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                matrix[i][j]=adjust.get(k);
                k++;

            }

        }
        return matrix ;
    }
    public static int[] getDiminsions(char letter) {

        int[] key = new int[2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == letter) {
                    key[0] = i;
                    key[1] = j;
                    break;
                }
            }
        }
        return key;
    }
    public static String EncryptionWithPlayfair(String plan)
    {

        String cipher = new String();
        String ftext = format(plan);
        String a[] = dividetopairs(ftext);
        char one,two;
        int part1[] = new int[2];
        int part2[] = new int[2];
        for (int i = 0; i < a.length; i++)
        {
            one = a[i].charAt(0);
            two = a[i].charAt(1);
            part1 = getDiminsions(one);
            part2 = getDiminsions(two);
            if (part1[0] == part2[0]) {
                if (part1[1] < 4) {
                    part1[1]++;
                } else {
                    part1[1] = 0;
                }

                if (part2[1] < 4) {
                    part2[1]++;
                } else {
                    part2[1] = 0;
                }
            } else if (part1[1] == part2[1]) {
                if (part1[0] < 4) {
                    part1[0]++;
                } else {
                    part1[0] = 0;
                }

                if (part2[0] < 4) {
                    part2[0]++;
                } else {
                    part2[0] = 0;
                }
            } else {
                int swap = part1[1];
                part1[1] = part2[1];
                part2[1] = swap;
            }

            cipher += ""+matrix[part1[0]][part1[1]] + matrix[part2[0]][part2[1]];

        }
        return cipher;
    }








    public static String encerpt(String plan,int key)
    {
        String x="";
        char y;
        for (int i = 0; i < plan.length(); i++)
        {
            y=plan.charAt(i);
            if (y >= 65 && y <= 90)
            {
                x+=(char) ((y + key - 65) % 26 + 65);
            }
            else if (y >= 97 && y <= 122)
            {
                x+=(char) ((y + key - 97) % 26 + 97);
            }
        }
        return x;

    }
    public static String dencerpt(String plan,int key)
    {
        String x="";
        char y;
        for (int i = 0; i < plan.length(); i++)
        {
            y=plan.charAt(i);

            if (y >= 65 && y <= 90)
            {
                x += (char) ((y - key - 65 + 26) % 26 + 65);
            }
            else if (y >= 97 && y <= 122)
            {
                x += (char) ((y - key - 97 + 26) % 26 + 97);
            }
        }
        return x;

    }

}