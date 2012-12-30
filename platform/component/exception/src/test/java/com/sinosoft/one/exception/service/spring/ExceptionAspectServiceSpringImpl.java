package com.sinosoft.one.exception.service.spring;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.GeProposalBusinessException;
import com.sinosoft.one.exception.service.facade.ExceptionAspectService;
import com.sinosoft.one.exception.userexception.ExceptionBuilder;
import org.springframework.stereotype.Service;

@Service
public class ExceptionAspectServiceSpringImpl implements ExceptionAspectService {

    public void ExceptionThrow() {
        System.out.println("---------ExceptionThrow----------");
        try {
            int j = 1;
            int i = j / 0;

        } catch (Exception e) {
            e.printStackTrace();
            throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceMsg("投保异常-除法异常", e,
                    ExceptionLevel.MORESERIOUS);
        }
    }
}
