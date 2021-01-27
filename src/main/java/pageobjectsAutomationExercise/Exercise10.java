package pageobjectsAutomationExercise;

import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Exercise10 {
    private WebDriver driver;

    public Exercise10(WebDriver driver){this.driver = driver;}

    public void ParseFileExercise() throws ParserConfigurationException, IOException, SAXException {
      File xmlFile = new File ("\\Users\\J168XFO\\Documents\\Java learning\\Exercise10.xml");

      //Create instance for document builder factory
      //DBF is a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents.

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            NodeList longNameList = doc.getElementsByTagName("LongName");
            Node tag = longNameList.item(1);
            if (tag.getNodeType()==Node.ELEMENT_NODE){
                //Element longTag = (Element)tag;
                String longNameTag = ((Element) tag).getAttribute("LongName");
            }
            System.out.println(longNameList);
        } catch (ParserConfigurationException | IOException | SAXException e){
            e.printStackTrace();
        }
    }

}
