package Controller.States;

import Controller.ControllerMediator;
import Controller.Controllers.SkillsController;
import Controller.SavingLoading.GameLoader;
import Model.Entity.Inventory;
import Model.Entity.Role.Role;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class SkillsState implements ControllerState {

    ControllerMediator controllerMediator;
    SkillsController skillsController;

    Map<Integer, Runnable> keyBinding = new HashMap();

    public SkillsState(GameLoader gameLoader, ControllerMediator controllerMediator){
        this.controllerMediator = controllerMediator;
        this.skillsController = new SkillsController(gameLoader);
    }

    @Override
    public void process(KeyEvent keyEvent) {
        keyBinding.get(keyEvent).run();
    }


    @Override
    public void loadKeyBindings() {
        File entityKeyBindings = new File("resources/KeyBindings/skills");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(entityKeyBindings);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Bind");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    switch (eElement.getAttribute("type")){
                        case "openMenu":
                            keyBinding.put(Integer.parseInt(eElement.
                                    getElementsByTagName("key").
                                    item(0).
                                    getTextContent()), () -> openMenu());
                            break;
                        case "openEquipment":
                            keyBinding.put(Integer.parseInt(eElement.
                                    getElementsByTagName("key").
                                    item(0).
                                    getTextContent()), () -> openEquipment());
                            break;
                        case "openInventory":
                            keyBinding.put(Integer.parseInt(eElement.
                                    getElementsByTagName("key").
                                    item(0).
                                    getTextContent()), () -> exitInventory());
                            break;
                        case "exitSkills":
                            keyBinding.put(Integer.parseInt(eElement.
                                    getElementsByTagName("key").
                                    item(0).
                                    getTextContent()), () -> openSkills());
                            break;
                        case "increaseCurrent":
                            keyBinding.put(Integer.parseInt(eElement.
                                    getElementsByTagName("key").
                                    item(0).
                                    getTextContent()), () -> increaseCurrent());
                            break;
                        case "scrollLeft":
                            keyBinding.put(Integer.parseInt(eElement.
                                    getElementsByTagName("key").
                                    item(0).
                                    getTextContent()), () -> scrollLeft());
                            break;
                        case "scrollRight":
                            keyBinding.put(Integer.parseInt(eElement.
                                    getElementsByTagName("key").
                                    item(0).
                                    getTextContent()), () -> scrollRight());
                            break;
                        case "scrollUp":
                            keyBinding.put(Integer.parseInt(eElement.
                                    getElementsByTagName("key").
                                    item(0).
                                    getTextContent()), () -> scrollUp());
                            break;
                        case "scrollDown":
                            keyBinding.put(Integer.parseInt(eElement.
                                    getElementsByTagName("key").
                                    item(0).
                                    getTextContent()), () -> scrollDown());
                            break;
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void openMenu() {

    }

    private void openEquipment() {

    }

    private void exitInventory() {

    }

    private void openSkills() {

    }

    private void increaseCurrent() {

    }

    private void scrollLeft() {

    }

    private void scrollRight() {

    }

    private void scrollUp() {

    }

    private void scrollDown() {

    }

}
