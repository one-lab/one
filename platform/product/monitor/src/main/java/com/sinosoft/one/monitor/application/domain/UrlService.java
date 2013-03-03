package com.sinosoft.one.monitor.application.domain;

import com.sinosoft.one.monitor.application.model.BizScenario;
import com.sinosoft.one.monitor.application.model.Url;
import com.sinosoft.one.monitor.application.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zfb
 * Date: 13-2-27
 * Time: 下午8:28
 * To change this template use File | Settings | File Templates.
 */
@Component
@Transactional(readOnly = true)
public class UrlService {

    @Autowired
    UrlRepository urlRepository;

    /**
     * 新增一个URL.
     */
    @Transactional(readOnly = false)
    public void saveUrl(Url url) {
        urlRepository.save(url);
    }

    /**
     * 删除一个URL.
     */
    @Transactional(readOnly = false)
    public void deleteUrl(Url url) {
        urlRepository.delete(url);
    }

    /**
     * 删除一个URL，通过URL的id.
     */
    @Transactional(readOnly = false)
    public void deleteUrl(String id) {
        urlRepository.delete(id);
    }

    /**
     * 查询一个URL，通过URL的id.
     */
    public Url findUrl(String id) {
        Url url = urlRepository.findOne(id);
        return url;
    }

    /**
     * 查询一个URL，通过URL的地址.
     */
    public Url findUrlByUrlAddress(String urlAddress) {
        Url url = urlRepository.findByUrl(urlAddress);
        return url;
    }

    /**
     * 查询所有的URL.
     */
    public List<Url> findAllUrl() {
        List<Url> urls = (List<Url>) urlRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
        return urls;
    }

    /**
     * 得到所有的URL的地址.
     */
    public List<String> findAllUrlAddresses(List<Url> urls) {
        List<String> urlAddresses = new ArrayList<String>();
        if (urls != null) {
            for (Url url : urls) {
                if (url != null) {
                    urlAddresses.add(url.getUrl());
                }
            }
            return urlAddresses;
        }
        return null;
    }
    /**
     * 得到业务场景下所有的URL的地址.
     */
    public List<Url> findAllUrlsOfBizScenario(BizScenario bizScenario){
        return urlRepository.selectUrlsOfBizScenarioByIds(bizScenario.getId());
    }
}
