package ru.live.kamaz_cs;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class NewTrains {

    public void addTrain() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        String file = "trains.xml";
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter FROM");
        String from = sc.nextLine();
        System.out.println("Enter TO");
        String to = sc.nextLine();
        System.out.println("Enter DATE");
        String date = sc.nextLine();
        System.out.println("Enter DEPARTURE");
        String departure = sc.nextLine();

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(file);

        Node staff = doc.getElementsByTagName("trains").item(0);
        Element trainOne = doc.createElement("train");
        staff.appendChild(trainOne);
        trainOne.setAttribute("id", "none");

        Element fromOne = doc.createElement("from");
        fromOne.appendChild(doc.createTextNode(from));
        trainOne.appendChild(fromOne);

        Element toOne = doc.createElement("to");
        toOne.appendChild(doc.createTextNode(to));
        trainOne.appendChild(toOne);

        Element dateOne = doc.createElement("date");
        dateOne.appendChild(doc.createTextNode(date));
        trainOne.appendChild(dateOne);

        Element departureOne = doc.createElement("departure");
        departureOne.appendChild(doc.createTextNode(departure));
        trainOne.appendChild(departureOne);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(file));
        transformer.transform(source, result);

    }

}
