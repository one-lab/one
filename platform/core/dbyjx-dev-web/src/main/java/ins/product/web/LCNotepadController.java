package ins.product.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import ins.product.service.facade.LCNotepadService;
import ins.prpall.proposal.model.LCNotepad;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/product")
public class LCNotepadController {
	private static final long serialVersionUID = 1L;
	
    @Autowired
	private LCNotepadService lcNotepadService;

	public void setLcNotepadService(LCNotepadService lcNotepadService) {
		this.lcNotepadService = lcNotepadService;
	}

	/**
	 * 保存记事本
	 * @return
	 */
	public Reply savaNotepad(@Param("lcNotepad") LCNotepad lcNotepad,Invocation invocation){
        LCNotepad lcNotepadTemp = lcNotepadService.savaNotepad(lcNotepad, invocation);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("lcNotepad", JSONArray.toJSON(lcNotepadTemp));
		return Replys.with(jsonObject.toString()).as(Json.class);
	}
}
