package pres;

import dao.IDao;
import metier.IMetier;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class pers22 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Donner la classe de lma couche DAD:");
        String daoClassName=scanner.nextLine();
        Class cDao=Class.forName(daoClassName);
        IDao dao= (IDao) cDao.getConstructor().newInstance();

//MetierImpl metier==new MetierImpl();
        System.out.print("Donner la classe de les couche Métier:");
        String metierClassname=scanner.nextLine();
        Class cMetier=Class.forName(metierClassname);
        IMetier metier=(IMetier) cMetier.getConstructor().newInstance();

        //metier.setDoo(doo);
        Method setDao=cMetier.getDeclaredMethod("setDao",IDao.class);
        setDao.invoke(metier,dao);
        System.out.println(("RES="+metier.calcul()));
    }
}
