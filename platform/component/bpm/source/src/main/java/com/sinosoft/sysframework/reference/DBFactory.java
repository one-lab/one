package com.sinosoft.sysframework.reference;

import com.sinosoft.sysframework.common.util.FileUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DBFactory
{
    private static Map map = Collections.synchronizedMap(new HashMap());
    private static boolean init = false;
    private static final File CONFIG_FILE = FileUtils.getUniqueFile(DBFactory.class, ".config");

  private static long lastModified = 0L;
   private static File localConfigFile;

  public static synchronized void configure(String fileName)
    throws Exception
  {
    if (!init)
      reconfigure(fileName);
  }

  public static synchronized void reconfigure(String fileName)
    throws Exception
  {
    try
    {
      localConfigFile = new File(fileName);
      lastModified = localConfigFile.lastModified();
      FileUtils.write(fileName, CONFIG_FILE);
      configure(new FileInputStream(fileName));
      System.out.println("Success load DBManager configuration at \"" + fileName + "\".");

      init = true;
    } catch (Exception e) {
      System.out.println("Fail load DBManager configuration at \"" + fileName + "\".");

      throw e;
    }
  }

  private static synchronized void configure(File file)
    throws Exception
  {
    configure(new FileInputStream(file));
  }

  private static synchronized void configure(InputStream inputStream)
    throws Exception
  {
    BufferedInputStream is = new BufferedInputStream(inputStream);

    map.clear();
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    Document document = builder.parse(is);

    is.close();

    NodeList datasourceDefines = document.getElementsByTagName("datasource-define");

    for (int i = 0; i < datasourceDefines.getLength(); i++)
      if (datasourceDefines.item(i).getNodeType() == 1)
      {
        String name = getChildNodeValue(datasourceDefines.item(i), "name");
        String jndiname = getChildNodeValue(datasourceDefines.item(i), "jndiname");

        String dbToServerEncodeCharset = getChildNodeValue(datasourceDefines.item(i), "db-to-server-encode-charset");

        String dbToServerDecodeCharset = getChildNodeValue(datasourceDefines.item(i), "db-to-server-decode-charset");

        boolean needConvertFromDbToServer = Boolean.valueOf(getChildNodeValue(datasourceDefines.item(i), "need-convert-from-db-to-server")).booleanValue();

        String serverToDbEncodeCharset = getChildNodeValue(datasourceDefines.item(i), "server-to-db-encode-charset");

        String serverToDbDecodeCharset = getChildNodeValue(datasourceDefines.item(i), "server-to-db-decode-charset");

        boolean needConvertFromServerToDb = Boolean.valueOf(getChildNodeValue(datasourceDefines.item(i), "need-convert-from-server-to-db")).booleanValue();

        DBDataSource dbDataSource = new DBDataSource(name, jndiname, dbToServerEncodeCharset, dbToServerDecodeCharset, needConvertFromDbToServer, serverToDbEncodeCharset, serverToDbDecodeCharset, needConvertFromServerToDb);

        map.put(name, dbDataSource);
      }
  }

  private DBFactory()
  {
  }

  public static void registDB(DBDataSource dbDataSource)
  {
    map.put(dbDataSource.getName(), dbDataSource);
  }

  public static void removeDB(String name)
  {
    map.remove(name);
  }

  public static DBDataSource getDB(String name)
  {
    try
    {
      if (!init) {
        String fileName = FileUtils.read(CONFIG_FILE);
        if (new File(fileName).exists()) {
          reconfigure(fileName);
        }
      }
      else if (lastModified < localConfigFile.lastModified()) {
        reconfigure(localConfigFile.getAbsolutePath());
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    if (!map.containsKey(name)) {
      System.err.println("**** DBDataSource " + name + " has not registed!");

      throw new IllegalArgumentException("**** DBDataSource " + name + " has not registed!");
    }

    return (DBDataSource)map.get(name);
  }

  public static void clear()
  {
    map.clear();
  }

  private static String getChildNodeValue(Node currentNode, String tagName) {
    String value = "";
    NodeList nodeList = currentNode.getChildNodes();
    Node node = null;
    for (int i = 0; i < nodeList.getLength(); i++) {
      node = nodeList.item(i);
      if (node.getNodeName().equals(tagName)) {
        if (node.getFirstChild() == null) break;
        value = node.getFirstChild().getNodeValue();
        value = value == null ? "" : value.trim(); break;
      }

    }

    return value;
  }

  public static boolean isInit()
  {
    return init;
  }
}

/* Location:           /Volumes/LACIE/develop/mvn_repo/com/sinosoft/sysframework/1.0/sysframework-1.0.jar
 * Qualified Name:     com.sinosoft.sysframework.reference.DBFactory
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */