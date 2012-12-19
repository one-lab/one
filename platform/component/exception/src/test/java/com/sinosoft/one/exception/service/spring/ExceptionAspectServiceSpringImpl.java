package com.sinosoft.one.exception.service.spring;

import com.sinosoft.one.exception.ExceptionGrade;
import com.sinosoft.one.exception.GeProposalBusinessException;
import com.sinosoft.one.exception.service.facade.ExceptionAspectService;

public class ExceptionAspectServiceSpringImpl implements ExceptionAspectService {

    public void ExceptionThrow() {
        System.out.println("---------ExceptionThrow----------");
        try {
            int j = 1;
            int i = j / 0;

        } catch (Exception e) {
            e.printStackTrace();
//			System.out.println("msg="+);

            throw GeProposalBusinessException.newInstanceMsg("投保异常-除法异常", e,
                    ExceptionGrade.MORESERIOUS);
        }
    }
}
