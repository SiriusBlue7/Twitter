package twitter;
import java.util.Date;

public class Message{
  private int id;
  private int userId;
  private String text;
  private int respuesta;
  private int retweet;
  private String shortName;
  private String longName;
  private java.util.Date fecha;


  public int getId(){
    return id;
  }

  public int getUserId(){
    return userId;
  }

  public String getText(){
    return text;
  }

  public int getRespuesta(){
    return respuesta;
  }

  public int getRetweet(){
    return retweet;
  }

  public String getShortName(){
    return shortName;
  }

  public String getLongName(){
    return longName;
  }

  public java.util.Date getDate(){
    return fecha;
  }

  public void setId(int id){
    this.id = id;
  }

  public void setUserId(int id){
    this.userId = id;
  }
  public void setText(String text){
    this.text = text;
  }

  public void setRespuesta(int respuesta){
    this.respuesta = respuesta;
  }

  public void setRetweet(int retweet){
    this.retweet = retweet;
  }

  public void setShortName(String name){
    this.shortName = name;
  }

  public void setLongName(String name){
    this.longName = name;
  }

  public void setDate(java.util.Date fecha){
    this.fecha = fecha;
  }

}
