/*Есть список поездов, представленный с виде XML. Вывести на экран информацию о тех поездах, которые
отправляются сегодня с 15:00 до 19:00.*/
package net.ukr.ne_declar;

import javax.xml.bind.*;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        Table table = new Table();
        Train firstTrain = new Train(3, "Kyiv", "L'viv", "21:02:2016", "15:45");
        Train secondTrain = new Train(4, "Odessa", "Kharkiv", "12:12:2016", "12:40");
        Train thirdTrain = new Train(5, "L'viv", "Moscow", "12:12:2016", "21:23");
        table.addTrain(firstTrain);
        table.addTrain(secondTrain);
        table.addTrain(thirdTrain);


        try {
            File file = new File("src\\net\\ukr\\ne_declar\\Table.xml");
            JAXBContext jaxb = JAXBContext.newInstance(Table.class);
            Marshaller m = jaxb.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            m.marshal(table, file);
            m.marshal(table, System.out);//вывод всех поездов
            System.out.println("______________________");
            for (Train train : table.getList()) {
                if (isAtTime(train)) {
                    System.out.println("Trains from 15.00 to 19.00 \n" + train);// вывод поездов по времени с 15.00 до 19.00
                }
            }


        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    public static boolean isAtTime(Train train) {
        boolean b = false;
        String s[] = train.getTime().split(":");
        int start = Integer.parseInt(s[0]);
        if (start >= 15 && start <= 18) {
            b = true;
        }
        return b;
    }
}
