package net.ukr.ne_declar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "trains")
    public class Table {

    private ArrayList<Train> list = new ArrayList<>();

    public ArrayList<Train> getList() {
        return list;
    }
    @XmlElement(name="train")
    public void setList(ArrayList<Train> list) {
        this.list = list;
    }

    public void addTrain(Train t){
        list.add(t);

    }
    public void removeTrain(Train t){
        if(list.contains(t)){
            list.remove(t);
        }
        else System.out.println("There is no such train in the list");
    }
}
