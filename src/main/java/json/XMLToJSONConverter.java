
package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

public class XMLToJSONConverter {

    private static ObjectMapper objectMapper = new ObjectMapper();

    // Método para converter um objeto para JSON
    public static String objectToJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para converter JSON de volta para um objeto
    public static <T> T jsonToObject(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        RouteParser routeParser = new RouteParser(
                "C:\\Users\\Leonardo Monteiro\\Downloads\\Servidor\\map\\map.rou.xml");
        ArrayList<Route> rotasParaExecutar = routeParser.getRoutes();
        System.out.println(rotasParaExecutar.get(1));
        System.out.println("");
        System.out.println("");
        System.out.println(objectToJson(rotasParaExecutar.get(1)));
        System.out.println("");
        System.out.println("");
        System.out.println(jsonToObject(objectToJson(rotasParaExecutar.get(1)), Route.class));
        System.out.println("Lógica finalizada");
    }
}