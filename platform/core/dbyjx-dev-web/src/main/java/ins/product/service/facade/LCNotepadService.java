package ins.product.service.facade;

import com.sinosoft.one.mvc.web.Invocation;
import ins.prpall.proposal.model.LCNotepad;

public interface LCNotepadService {

	LCNotepad savaNotepad(LCNotepad lcNotepad, Invocation invocation);

}
