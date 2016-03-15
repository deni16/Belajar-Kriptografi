/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subtitutioncipher;

/**
 *
 * @author NFI-ACER
 */
public class SubtitutionCipher {

    public static final char[] abjad = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int key = 7576;
        String password = "MELISSA ARISANTY";
        String encrypt = getEncryptPassword(password, key);
        String decrypt = getDecryptPassword(encrypt, key);

        System.out.println("Password : " + password);
        System.out.println("Encrypt : " + encrypt);
        System.out.println("Decrypt : " + decrypt);
    }

    public static String getEncryptPassword(String password, int key) {
        char[] passwordArray = password.toCharArray();
        String encryptPassword = "";
        int posisi = 0;
        for (char charPasswd : passwordArray) {
            if (charPasswd != ' ') {
                posisi = Integer.valueOf(new String(abjad).indexOf(charPasswd));
                /**
                 * cara cek nilai 1'1 tapi berat posisi = posisi + key; posisi =
                 * isGreaterThan26(posisi);
                 */
                posisi = posisi + (key % 26);
                if (posisi > 26) {
                    posisi = posisi - 26;
                }

                encryptPassword += abjad[posisi];

            } else {
                encryptPassword += " ";
            }
        }
        return encryptPassword;
    }

    public static String getDecryptPassword(String encryptPassword, int key) {
        char[] passwordArray = encryptPassword.toCharArray();
        String decryptPassword = "";
        int posisi = 0;
        for (char charPasswd : passwordArray) {

            if (charPasswd != ' ') {
                posisi = Integer.valueOf(new String(abjad).indexOf(charPasswd));
                /**
                 * cara cek nilai 1'1 tapi berat posisi = posisi - key; posisi =
                 * isSmallerThan26(posisi);
                 */
                posisi = posisi - (key % 26);
                if (posisi < 0) {
                    posisi = 26 + posisi;
                }
                decryptPassword += abjad[posisi];
            } else {
                decryptPassword += " ";
            }
        }

        return decryptPassword;
    }

    /**
     * N = 13 Abjad = 26 Key = 50 13 + 50 = 63 63 - 26 = 37 jika 37 > 26 : 37 -
     * 26 Atau N + (Key % 26)
     */
    public static int isGreaterThan26(int posisi) {
        Boolean greaterThan = (posisi > 26) ? Boolean.TRUE : Boolean.FALSE;
        while (greaterThan.equals(Boolean.TRUE)) {
            posisi = posisi - 26;
            if (posisi > 26) {
                isGreaterThan26(posisi);
            } else {
                greaterThan = Boolean.FALSE;
            }
        }
        return posisi;
    }

    public static int isSmallerThan26(int posisi) {
        Boolean smallerThan = (posisi < 26) ? Boolean.TRUE : Boolean.FALSE;
        while (smallerThan.equals(Boolean.TRUE)) {
            posisi = 26 + posisi;
            if (posisi < 0) {
                isSmallerThan26(posisi);
            } else {
                smallerThan = Boolean.FALSE;
            }
        }
        return posisi;
    }

}
