package com.RMS;

import javax.swing.*;
import java.awt.*;

public class Main{

    static String allele1 = JOptionPane.showInputDialog("Enter your father's allele : ");
    static String allele2 = JOptionPane.showInputDialog("Enter your mother's allele : ");

    static char hapAllele1 = allele1.charAt(0);
    static char hapAllele2 = allele1.charAt(1);
    static char hapAllele3 = allele2.charAt(0);
    static char hapAllele4 = allele2.charAt(1);

    static String depAllele1 = hapAllele3 + String.valueOf(hapAllele1);
    static String depAllele2= hapAllele3 + String.valueOf(hapAllele2);
    static String depAllele3 = hapAllele1 + String.valueOf(hapAllele4);
    static String depAllele4 = hapAllele4 + String.valueOf(hapAllele2);

    public static void checkDominance(){
        if(Character.isUpperCase(hapAllele3)){
            depAllele1 = hapAllele3 + String.valueOf(hapAllele1);
        }
        else{
            depAllele1 = hapAllele1 + String.valueOf(hapAllele3);
            depAllele2 = hapAllele2 + String.valueOf(hapAllele3);
            depAllele4 = hapAllele2 + String.valueOf(hapAllele4);
        }
    }
    static JFrame frame;
    static JTextField textField;
    static JTextField textField1;
    public static void main(String[] args) {

            checkDominance();

            String[][] data = {
                    {"Alleles", String.valueOf(hapAllele1), String.valueOf(hapAllele2)},
                    {String.valueOf(hapAllele3), depAllele1, depAllele2},
                    {String.valueOf(hapAllele4), depAllele3, depAllele4}
            };

            String[] columnName = {"", "", ""};
            JTable table = new JTable(data, columnName);
            table.setFont(new Font("Serif", Font.BOLD, 14));
            table.setBorder(BorderFactory.createLoweredBevelBorder());
            table.setBackground(Color.RED);
            table.setForeground(Color.white);

            textField = new JTextField();
            textField.setBounds(0, 50, 500, 50);
            textField.setBackground(Color.GREEN);
            textField.setForeground(Color.white);
            textField.setBorder(BorderFactory.createLoweredBevelBorder());

            textField1 = new JTextField();
            textField1.setBounds(0, 100, 500, 50);
            textField1.setBackground(Color.BLUE);
            textField1.setForeground(Color.white);
            textField1.setBorder(BorderFactory.createLoweredBevelBorder());

            frame = new JFrame();
            frame.add(textField);
            frame.add(textField1);
            frame.add(new JScrollPane(table));
            frame.setTitle("Punnet Square");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 180);
            frame.setVisible(true);
            frame.setResizable(false);

            statResults();

    }
        public static void statResults(){
            if (Character.isUpperCase(hapAllele1) && Character.isUpperCase(hapAllele2) && Character.isLowerCase(hapAllele3) && Character.isLowerCase(hapAllele4)){
                textField.setText("  The probability of the child expressing the dominant allele is 100% ");
                textField1.setText(" 100% being heterozygous ");
            }
            if (Character.isUpperCase(hapAllele1) && Character.isUpperCase(hapAllele3)) {
                textField.setText("  The probability of the child expressing the dominant allele is 75% ");
                textField1.setText(" 50% being heterozygous and 25% being homozygous recessive ");
            }
            if (Character.isUpperCase(hapAllele1) && Character.isUpperCase(hapAllele3) && Character.isUpperCase(hapAllele2) && Character.isUpperCase(hapAllele4)) {
                textField.setText("  The probability of the child expressing the dominant allele is 100% ");
                textField1.setText(" 100% being homozygous ");
            }
            if (Character.isUpperCase(hapAllele1) && Character.isLowerCase(hapAllele3) && Character.isLowerCase(hapAllele2) && Character.isLowerCase(hapAllele4)) {
                textField.setText("  The probability of the child expressing the dominant allele is 50% ");
                textField1.setText(" 50% being heterozygous and 50% being homozygous recessive ");
            }
            if (Character.isLowerCase(hapAllele1) && Character.isUpperCase(hapAllele3)) {
                textField.setText("  The probability of the child expressing the dominant allele is 50% ");
                textField1.setText(" 50% being heterozygous and 50% being homozygous recessive ");
            }
        }
}