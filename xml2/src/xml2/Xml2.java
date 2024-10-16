/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package xml2;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author FP
 */
public class Xml2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("xml.xml"));
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList nList = document.getElementsByTagName("Producto");
        System.out.println("");
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println("");
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("");
                Element eElement = (Element) node;
                System.out.println("Producto id : " + eElement.getAttribute("id"));
                System.out.println("Nombre : " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("Material : " + eElement.getElementsByTagName("material").item(0).getTextContent());
                System.out.println("Peso : " + eElement.getElementsByTagName("peso").item(0).getTextContent());
                System.out.println("Pie : " + eElement.getElementsByTagName("pie").item(0).getTextContent());
                System.out.println("Distancia : " + eElement.getElementsByTagName("distancia").item(0).getTextContent());
                System.out.println("Altura : " + eElement.getElementsByTagName("altura").item(0).getTextContent());
                System.out.println("Base : " + eElement.getElementsByTagName("base").item(0).getTextContent());
                System.out.println("Asiento : " + eElement.getElementsByTagName("asiento").item(0).getTextContent());
                System.out.println("Acabado : " + eElement.getElementsByTagName("acabado").item(0).getTextContent());
                System.out.println("Reposapies : " + eElement.getElementsByTagName("reposapies").item(0).getTextContent());
                System.out.println("Giro : " + eElement.getElementsByTagName("giro").item(0).getTextContent());
                System.out.println("Proteccion : " + eElement.getElementsByTagName("proteccion").item(0).getTextContent());
                System.out.println("Base y Pie : " + eElement.getElementsByTagName("baseypie").item(0).getTextContent());
                System.out.print(";;");
            }

        }
        System.out.print(";;");
        System.out.println("");

    }
}
