import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by liuwenxiu on 2018/2/28.
 */

//DOM解析 xml 文件

public class DOMTest {
    public static void main(String args[]){
        //创建一个DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document document = db.parse("books.xml");
            NodeList bookList = document.getElementsByTagName("book");
            System.out.println("一共有"+bookList.getLength()+"本书");
            for(int i = 0 ; i<bookList.getLength();i++){
                System.out.println("下面开始遍历第"+(i+1)+"书的内容");
                Node book = bookList.item(i);
                NamedNodeMap attrs = book.getAttributes();
                System.out.println("第"+(i+1)+"本书有"+attrs.getLength()+"个属性");
                //遍历book的属性
                for (int j = 0; j < attrs.getLength(); j++) {
                    //通过item(index)方法获取book节点的某一个属性
                    Node attr = attrs.item(j);
                    //获取属性名
                    System.out.print("属性名：" + attr.getNodeName());
                    //获取属性值
                    System.out.println("--属性值" + attr.getNodeValue());
                }
                //解析book节点的子节点
                NodeList childNodes = book.getChildNodes();
                //遍历childNodes获取每个节点的节点名和节点值
                System.out.println("第" + (i+1) + "本书共有" +
                        childNodes.getLength() + "个子节点");
                for (int k = 0; k < childNodes.getLength(); k++) {
                    //区分出text类型的node以及element类型的node
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        //获取了element类型节点的节点名
                        System.out.print("第" + (k + 1) + "个节点的节点名："
                                + childNodes.item(k).getNodeName());
                        //获取了element类型节点的节点值
                        System.out.println("--节点值是：" + childNodes.item(k).getFirstChild().getNodeValue());
                        //System.out.println("--节点值是：" + childNodes.item(k).getTextContent());
                    }
                }

            }
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }catch (SAXException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
