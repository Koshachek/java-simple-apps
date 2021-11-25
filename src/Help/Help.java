package Help;

import java.io.*;

public class Help {
    String helpfile;

    Help(String fname){
        helpfile = fname;
    }

    //отобразить справочную информацию по указанной теме
    boolean helpon(String what){
        int ch;
        String topic, info;

        //Открыть справочный файл
        try(BufferedReader helpRdr = new BufferedReader(new FileReader(helpfile))) {
            do {
                //читать символы до тех пор, пок ане встретится символ #
                ch = helpRdr.read();
                //проверить, совпадают ли темы
                if(ch == '#'){
                    topic = helpRdr.readLine();
                    if(what.compareTo(topic) == 0){ //найти тему
                        do {
                            info = helpRdr.readLine();
                            if(info != null){
                                System.out.println(info);
                            }
                        }while ((info != null) && (info.compareTo("")!=0));

                        return true;
                    }
                }
            }while(ch != -1);
        }catch (IOException exc){
            System.out.println("Ошибка при доступе к файлу справки");
            return false;
        }

        return false; //тема не найдена
    }

    //получить тему справки
    String getSelection(){
        String topic = "";

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Укажите тему справки:");
        try {
            topic = br.readLine();
        }catch (IOException exc){
            System.out.println("Ошибка при чтении с консоли");
        }

        return topic;
    }
}
