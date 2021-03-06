package pl.lodz.zzpj;

import pl.lodz.Client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App {

    public static void main(String[] args) {
        Client client = new Client("A", "B", 18);
        System.out.println(client);

        String filePath = "config.properties";
        Properties properties = new Properties();

        try (InputStream resourceAsStream = App.class.getClassLoader().getResourceAsStream(filePath)) {
            properties.load(resourceAsStream);
            properties.forEach((k, v) -> System.out.println(k + ":" + v));
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }
    }
}
