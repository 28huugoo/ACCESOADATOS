/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebahugo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("xml.xml"));
        
        //al ejecutar el código, nos damos cuenta de que no nos esta leyendo bien el archivo xml, y eso es porque los ids deben de ir entre comillas.
        //al volverlo a ejecutar nos damos cuenta de nuevo de que tiene otro error, y es que el camaras_web del final, no estaba bien cerrado, ya que le faltaba la barra "/"
        //soluciono estos errores a mano en el xml para así poder comprobar el funcionamiento de nuestro programa
        //también me he dado cuenta que hay un espacio antes de el último comentario así que lo he eliminado, auqneu no es importante ya que podría funcionar igual.
        
        FileWriter escribir = new FileWriter("documento.txt");
        BufferedWriter bw = new BufferedWriter(escribir);

        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();

        escribir.write("Lo ÚLTIMO de los " + root.getNodeName());
        escribir.append("\n\n===========================\n\n");

        System.out.println("Lo ÚLTIMO de los " + root.getNodeName());
        NodeList nList = document.getElementsByTagName("camara");
        System.out.println("");
        System.out.println("===========================");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println("");
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("");
                Element eElement = (Element) node;
                
                //Primero lo hago con souts para comprobar su correcto funcionamiento y que está todo en orden
                //Una vez comprobado que funciona correctamente, usaremos el fileWriter
                
                escribir.append("\nProducto id : ¡¡" + eElement.getAttribute("id"));
                escribir.append("\nModelo : ¡¡" + eElement.getElementsByTagName("modelo").item(0).getTextContent());
                escribir.append("\nMarca : ¡¡" + eElement.getElementsByTagName("marca").item(0).getTextContent());
                escribir.append("\nAltura : #" + eElement.getElementsByTagName("altura").item(0).getTextContent());
                escribir.append("\nAnchura : @" + eElement.getElementsByTagName("anchura").item(0).getTextContent());
                escribir.append("\nProfundidad : #" + eElement.getElementsByTagName("profundidad").item(0).getTextContent());
                escribir.append("\nPeso : @" + eElement.getElementsByTagName("peso").item(0).getTextContent());
                escribir.append("\nMegapixeles : #" + eElement.getElementsByTagName("megapixeles").item(0).getTextContent());
                escribir.append("\nComentarios : \n\n***************************\n\n" + eElement.getElementsByTagName("comentarios").item(0).getTextContent() + "\n");

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
        escribir.append("…..\n\n");
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println("");
        escribir.append("+++++++++++++++++++++++++++\n\n");
        System.out.println("FIN DEL DOCUMENTO XML");
        escribir.append("FIN DEL DOCUMENTO XML");
        bw.close();
        escribir.close();
    }

}
