package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class pers2 {
    public static void main(String[] args) throws Exception  {
        Scanner scanner=new Scanner(System.in);
        String daoClassName=scanner.nextLine();
        Class cDao=Class.forName(daoClassName);
        IDao dao= (IDao) cDao.getConstructor().newInstance();

//MetierImpl metier==new MetierImpl();
        System.out.print("Donner la classe de les couche Métier:");
        String metierClassname=scanner.nextLine();
        Class cMetier=Class.forName(metierClassname);
        IMetier metier=(IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

        //metier.setDoo(doo);
        Method setDao=cMetier.getDeclaredMethod("setDao",IDao.class);
        setDao.invoke(metier,dao);
        System.out.println("RES="+metier.calcul());



    }
}
