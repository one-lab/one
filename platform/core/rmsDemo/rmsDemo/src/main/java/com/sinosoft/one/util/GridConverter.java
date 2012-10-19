package com.sinosoft.one.rmsdemo.uiUtils;

import com.sinosoft.one.util.GridNode;
import com.thoughtworks.xstream.XStream;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.xml.stream.XMLStreamConstants;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-10-12
 * Time: 上午11:13
 * To change this template use File | Settings | File Templates.
 */
public class GridConverter implements Converter<Gridable>{


//    public String toJson(T nodes) {
//        UIable gridable = new Gridable();
//        Render gridRender = gridable.getRender();
////        Render render = o.getRender();
////        render.render();
//        JSONArray jsonArray = new JSONArray();
//        if(o == null){
//            return jsonArray.toString();
//        }
//        jsonArray.addAll((Collection) o);
//        return jsonArray.toString();
//    }
//    public static String convertGridNodeListGridString(List<GridNode> nodes) {
//
//        JSONArray jsonArray = new JSONArray();
//        if(nodes == null) {
//            return jsonArray.toString();
//        }
//        for (GridNode node : nodes){
//            JSONObject itemObject = new JSONObject();
//            JSONObject dataObject = new JSONObject();
//            dataObject.accumulate("total",node.getTotal());
//            itemObject.accumulate("cell",node.getCell());
//            itemObject.accumulate("rows",node.getRows());
//            jsonArray.add(itemObject);
//        }
//        return jsonArray.toString();
//    }
//    public static String toXml(Object o) {
//        XStream xStream = new XStream();
//        return null;
//    }

    public String toJson(Gridable gridable) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String toXml(Gridable gridable) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
