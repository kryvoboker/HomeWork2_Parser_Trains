package ru.live.kamaz_cs;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("trains.xml");

            NewTrains nt = new NewTrains();
            nt.addTrain();

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.parse(xmlFile);

            Element root = document.getDocumentElement();
            System.out.println("Корневой каталог: " + root.getNodeName());
            System.out.println("----------------------");

            NodeList nodeList = root.getChildNodes();


            for (int i = 0; i < nodeList.getLength(); i += 1) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    int timeFrom = new String("15:00").hashCode();
                    int timeTo = new String("19:00").hashCode();
                    int dateToday = new String("19.12.2020").hashCode();
                    int date = element.getElementsByTagName("date").item(0).getChildNodes().item(0).getNodeValue().hashCode();
                    int timeTrain = element.getElementsByTagName("departure").item(0).getChildNodes().item(0).getNodeValue().hashCode();

                    if (timeTrain >= timeFrom && timeTrain <= timeTo && date == dateToday) {
                        System.out.println("Trains from 15:00 to 19:00:");

                        System.out.println("From: " + element.getElementsByTagName("from").item(0)
                                .getChildNodes().item(0).getNodeValue());

                        System.out.println("To: " + element.getElementsByTagName("to").item(0)
                                .getChildNodes().item(0).getNodeValue());

                        System.out.println("Time: " + element.getElementsByTagName("departure").item(0)
                                .getChildNodes().item(0).getNodeValue());

                        System.out.println("----------------------");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}