package DailyAdviceChat;

import java.io.*;

import java.net.*;

public class DailyAdviceServer {
    String adviceList[] = {"Ешьте меньшими порциями", "Купите облегающие джинсы. Нет, они не сделают вас полнее",
            "Два слова: не годится", "Будьте честны хотябы сегодня. Скажите своему начальнику все, что вы *на самом деле* о нем думаете.",
            "Возможно, вам стоит подобрать другую прическу."};

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242); // сервер отслеживает клиенсткие запросы на порту 4242

            while (true) {
                Socket socket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
