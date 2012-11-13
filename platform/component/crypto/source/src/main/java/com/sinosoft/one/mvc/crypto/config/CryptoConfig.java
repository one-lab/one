package com.sinosoft.one.mvc.crypto.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: Morgan
 * Date: 12-11-6
 * Time: 下午7:05
 */

public class CryptoConfig {

	private static CryptoConfig instance = new CryptoConfig();

	public static final String CRYPTO_KEY_ATTR_NAME = "crypto_key_attr_name";

	public static final String UNCRYPTO_ATTR_NAMES="crypto_plugin_uncrypto_attr_names";

	public static final String CRUPTO_ATTR_NAMES="crypto_attributies_names";
//	public static final String IS_AJAX_CRYPTO = "$$isAjaxCrypto$$";

	private Map<String, List<Crypto>> cryptoMap = new ConcurrentHashMap<String, List<Crypto>>();

	private Map<String, UnCrypto> uncryptoMap = new ConcurrentHashMap<String, UnCrypto>();

	private Map<String, CryptoMatchResult> quichMatchMap = new ConcurrentHashMap<String, CryptoMatchResult>();

	public static CryptoConfig getInstance() {
		return instance;
	}

	public CryptoMatchResult quickMatch(String url) {
		return quichMatchMap.get(url);
	}

	public void addCrypto(String url,List<Crypto> cryptos) {
		cryptoMap.put(url, cryptos);
		quichMatchMap.put(url,CryptoMatchResult.CRYPTO_MATCH_RESULT);
	}
	public void addCrypto(String url,Crypto crypto) {
		List<Crypto> cryptos = cryptoMap.get(url);
		if(cryptos == null)
			cryptos = new ArrayList<Crypto>();
		cryptos.add(crypto);
		cryptoMap.put(url, cryptos);
		quichMatchMap.put(url,CryptoMatchResult.CRYPTO_MATCH_RESULT);
	}

	public void addUnCrypto(String url, UnCrypto unCrypto) {
		uncryptoMap.put(url, unCrypto);
		quichMatchMap.put(url,CryptoMatchResult.UNCRYPTO_MATCH_RESULT);
	}

	public void deleteUnCrypto(String url) {
		uncryptoMap.remove(url);
		quichMatchMap.remove(url);
	}
	public void deleteCrypto(String url) {
		cryptoMap.remove(url);
		quichMatchMap.remove(url);
	}

	public Map<String, List<Crypto>> getCryptoMap() {
		return cryptoMap;
	}

	public Map<String, UnCrypto> getUncryptoMap() {
		return uncryptoMap;
	}
}
