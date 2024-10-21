package XML;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Principal {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory
                = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder
                = factory.newDocumentBuilder();
        Document document = builder.parse(
                new File("archivo.xml"));
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList nList = document.
                getElementsByTagName("channel");
        Node nodo;
        NodeList nList2 = document.
                getElementsByTagName("channel");
        Node nodo2;
        System.out.println("===========EXAMEN HUGO >-< DAMIAN ==============");
        System.out.println("");
        NodeList nListEnterito = document.
                getElementsByTagName("item");
        System.out.println("");
        Node nodoEnterito;
        System.out.println("- > COMIENZA EL PROCESAMIENTO DE TODO EL DOCUMENTO < -");
        System.out.println("");
        for (int i = 0; i < nList.getLength(); i++) {
            nodo = nList.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                //Cogemos de arriba el link y el lenguaje
                System.out.println("Su link es: " + elemento.
                        getElementsByTagName("link").
                        item(0).getTextContent());
                System.out.println("Su lengua es: " + elemento.
                        getElementsByTagName("language").
                        item(0).getTextContent());
                
                System.out.println("Fecha de publicación: " + elemento.
                        getElementsByTagName("pubDate").
                        item(0).getTextContent());
                for (int j = 0; j < nListEnterito.getLength(); j++) {
                    nodoEnterito = nList.item(i);
                    if (nodoEnterito.getNodeType() == Node.ELEMENT_NODE) {
                        Element elementoMedia = (Element) nodoEnterito;
                        System.out.println("Texto en media: " + elementoMedia.
                                getElementsByTagName("media:text").
                                item(j).getTextContent());
                        System.out.println("");
                        System.out.println("===================");
                    }
                }
            }

            //Ahora con pubDate que se encuentra dentro de item, más abajo
            /*for (int k = 0; k < nList2.getLength(); k++) {
                nodo2 = nList.item(k);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento2 = (Element) nodo;

                }
            }
             */
        }
    }
}
