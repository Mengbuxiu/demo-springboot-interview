package com.interview.demo.GenerateXMLTest;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SaxXML {
    public static void main(String[] args) {

        // 调用sax生成xml方法
        try {
            createSAX(new File("E:\\sax.xml"));
        } catch (SAXException | TransformerConfigurationException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void createSAX(File file) throws SAXException, TransformerConfigurationException, FileNotFoundException {
        // 创建sax转换工厂
        SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();

        // 创建TransformerHandler
        TransformerHandler handler = factory.newTransformerHandler();

        // 创建handler转换器
        Transformer transformer = handler.getTransformer();
        // 缩进
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        // 字符集
        transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

        // 创建Result连接到xml文件
        Result result = new StreamResult(new FileOutputStream(file));
        handler.setResult(result);

        //------------------------正文开始-------------------------------

        // 创建属性, addAttribute(String uri, String localName, String qName, String type, String value)
        AttributesImpl attr = new AttributesImpl();

        // 打开doc对象
        handler.startDocument();

        // (xmlns,未知, node, property)
        //根节点--root
        handler.startElement(null, null, "root", attr);

        // 每次创建节点前，先清空属性，放置一些属性错误
        attr.clear();
        // 设置属性
        attr.addAttribute(null, null, "attr", null, "one");
        // 第一子节点--person
        //(xmlns,未知,node,property)
        handler.startElement(null, null, "person", attr);

        attr.clear();
        attr.addAttribute(null, null, "attr", null, "one");
        // 第一子节点的第一子节点--people
        //(xmlns,未知,node,property)
        handler.startElement(null, null, "people", attr);
        handler.characters("插入的数据".toCharArray(), 0, 5);
        handler.endElement(null, null, "people");

//            attr.clear();
//            attr.addAttribute("", "", "attr", "", "two");
//            // 第一个子节点的第二个子节点people
//            handler.startElement("", "", "people", attr);
//            handler.characters("one child people two".toCharArray(), 0, 14);
//            handler.endElement("", "", "people");

        handler.endElement(null, null, "person");

//            // 每次创建节点前，先清空属性，放置一些属性错误
//            attr.clear();
//            // 设置属性
//            attr.addAttribute("", "", "attr", "", "two");
//            // 根节点第二个子节点person
//            handler.startElement("", "", "person", attr);
//
//            attr.clear();
//            attr.addAttribute("", "", "attr", "", "one");
//            // 第二个子节点的第一个子节点people
//            handler.startElement("", "", "people", attr);
//            handler.characters("two child people one".toCharArray(), 0, 14);
//            handler.endElement("", "", "people");
//
//            attr.clear();
//            attr.addAttribute("", "", "attr", "", "two");
//            // 第二个子节点的第二个子节点people
//            handler.startElement("", "", "people", attr);
//            handler.characters("two child people two".toCharArray(), 0, 14);
//            handler.endElement("", "", "people");
//
//            handler.endElement("", "", "person");
//
//            // 结束hanlder.endElement("", "", 元素名)

        handler.endElement(null, null, "root");

        // 关闭doc对象
        handler.endDocument();
        System.out.println("SAX CreateSAX success!");

    }

}
