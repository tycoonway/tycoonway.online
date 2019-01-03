package com.gltv.bigwig.utils;

import java.io.IOException;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;


import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Wallet;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.http.HttpService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

@SuppressWarnings("rawtypes")
public class WalletUtil {
	private static Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/"));//ropsten
	
	public final static ObjectMapper mapper = new ObjectMapper(); 
	
	public static Web3j getWeb3jInstance() {
		return web3j;
	}
	
    public static BigInteger getNonce(Web3j web3j,String address) throws InterruptedException, ExecutionException {
    	EthGetTransactionCount ethGetTransactionCount;
		ethGetTransactionCount = web3j.ethGetTransactionCount(
				address, DefaultBlockParameterName.LATEST).sendAsync().get();
    	return ethGetTransactionCount.getTransactionCount();
    }
    
	public static final String getKeystoreStr(String password) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, CipherException, JsonProcessingException{
		return new ObjectMapper()
				.writeValueAsString(Wallet
						.createStandard(password,
								Keys.createEcKeyPair()));
	}
	
	
	public static String doPost(String url, List<NameValuePair> params) {  
        String result = null;  
        HttpPost post = null;  
        try {
        	CloseableHttpClient httpclient = HttpClients.createDefault();  
            post = new HttpPost(url);  
            post.setHeader("Accept", "application/json; charset=UTF-8");  
            post.setEntity(new UrlEncodedFormEntity(params,Consts.UTF_8));  
            HttpResponse response = httpclient.execute(post);  
            result = EntityUtils.toString(response.getEntity(), "UTF-8");  
            return result;  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if(post != null) {  
                post.releaseConnection();  
            }  
        }  
        return null;  
    }
	
	public static String PrefixHexToDec(String Str) {
		return String.valueOf(Long.parseLong(Str.substring(2),16));
	}
}
