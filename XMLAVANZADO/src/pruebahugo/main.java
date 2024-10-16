/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebahugo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("empleados.xml"));
        ArrayList<Empleado> ArrayEmpleados = new ArrayList<>();
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        System.out.println("Lo ÚLTIMO de los " + root.getNodeName());
        NodeList nList = document.getElementsByTagName("empleado");
        System.out.println("");
        System.out.println("===========================");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println("");
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("");
                Element eElement = (Element) node;
                
                System.out.println("Producto id : ¡¡" + eElement.getAttribute("id"));
                System.out.println("Modelo : ¡¡" + eElement.getElementsByTagName("modelo").item(0).getTextContent());
                System.out.println("Marca : ¡¡" + eElement.getElementsByTagName("marca").item(0).getTextContent());
                System.out.println("Altura : #" + eElement.getElementsByTagName("altura").item(0).getTextContent());
                System.out.println("Anchura : @" + eElement.getElementsByTagName("anchura").item(0).getTextContent());
                System.out.println("Profundidad : #" + eElement.getElementsByTagName("profundidad").item(0).getTextContent());
                System.out.println("Peso : @" + eElement.getElementsByTagName("peso").item(0).getTextContent());
                System.out.println("Megapixeles : #" + eElement.getElementsByTagName("megapixeles").item(0).getTextContent());
                System.out.println("Comentarios : \n\n***************************\n\n" + eElement.getElementsByTagName("comentarios").item(0).getTextContent());

            }
        }
        System.out.println("");
        System.out.println("…..");
        System.out.println("");
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println("");
        System.out.println("FIN DEL DOCUMENTO XML");
    }
}
