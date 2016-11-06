package net.ukr.ne_declar;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@XmlRootElement(name="train")
public class Train {
    private  int id ;
    private String from;
    private String to;
    private String date;
    private String time ;
    public Train() {}
    public Train(int id, String from, String to, String date, String time) {
       this.id = id;
        this.from = from;
        this.to = to;
        this.date = isItTrue(date);
        this.time = isItTrue(time);
    }
    public int getId() {
        return id;
    }
@XmlAttribute
    public void setId(int id) {
        this.id = id;
    }
    public String getFrom() {
        return from;
    }
    @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    @XmlElement
    public void setTo(String to) {
        this.to = to;
    }
    public String getDate() {
        return date;
    }
    @XmlElement
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    @XmlElement
    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
    private String isItTrue(String s){
        String s1 = s;
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("kk:mm");
        try {
           Date date = sdf.parse(s1);
            System.out.println(date);
        } catch (ParseException e) {
            try {
              Date date = sdf1.parse(s1);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
        return s1;
    }
}
