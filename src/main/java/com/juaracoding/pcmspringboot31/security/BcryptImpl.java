package com.juaracoding.pcmspringboot31.security;

import java.util.function.Function;

public class BcryptImpl {

    private static final BcryptCustom bcrypt = new BcryptCustom(11);

    /** untuk
     * mengacak teks asli nya
     * @param password
     * @return
     */
    public static String hash(String password) {
        return bcrypt.hash(password);
    }

    public static boolean verifyAndUpdateHash(String password,
                                              String hash,
                                              Function<String, Boolean> updateFunc) {
        return bcrypt.verifyAndUpdateHash(password, hash, updateFunc);
    }

    /**
     * ini untuk membandingkan
     * teks asli dengan hash nya
     * @param password
     * @param hash
     * @return
     */
    public static boolean verifyHash(String password , String hash)
    {
        return bcrypt.verifyHash(password,hash);
    }
    public static void main(String[] args) {
        //Paul@123
        //Login : usrname = ari.321 , password = Paul@123
        //ari.321Paul@123
        System.out.println(hash("ari.321Ari@123"));//imutable
        System.out.println(verifyHash("121314","$2a$11$TBHtMb0FBb0MQ4hwgL8lqOn396mxPiQr3xy7XmPsIirLmqTUUEKGm"));
        System.out.println(verifyHash("paul123","$2a$11$h/TQXqKdlsLowqDRStSFLOjSfmApP91M4uD/.I5Gjnfm09qdKtolO"));
        System.out.println(verifyHash("paul123","$2a$11$mlvIAKRT9IKonDZgAS0CEuDwWtTdcERZAygZTPDWwQV.bJHLrmvIi"));
        System.out.println(verifyHash("ari.321Paul@123","$2a$11$PLbUoQf2cTyEeGfCyZkEdOWSGELg5x/kwKIXTKzqDhYbQRZqYZ1xe"));
        // $2a$11$PLbUoQf2cTyEeGfCyZkEdOWSGELg5x/kwKIXTKzqDhYbQRZqYZ1xe --> paul.123Paul@123
    }
}