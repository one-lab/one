package ins.product.web;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import ins.framework.web.Struts2Action;
import ins.product.service.facade.LCNotepadService;
import ins.prpall.proposal.model.LCNotepad;

public class LCNotepadAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	private LCNotepad lcNotepad;
	private LCNotepadService lcNotepadService;
	
	public LCNotepadService getLcNotepadService() {
		return lcNotepadService;
	}
	public void setLcNotepadService(LCNotepadService lcNotepadService) {
		this.lcNotepadService = lcNotepadService;
	}
	public LCNotepad getLcNotepad() {
		return lcNotepad;
	}
	public void setLcNotepad(LCNotepad lcNotepad) {
		this.lcNotepad = lcNotepad;
	}
	/**
	 * 保存记事本
	 * @return
	 */
	public String savaNotepad(){
		lcNotepad = lcNotepadService.savaNotepad(lcNotepad);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("lcNotepad", JSONArray.fromObject(lcNotepad));
		renderHtml(jsonObject.toString());
		return NONE;
	}
}
