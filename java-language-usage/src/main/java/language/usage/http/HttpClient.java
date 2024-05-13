//package language.usage.http;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import language.usage.common.util.RetryUtil;
//import org.apache.http.HttpEntity;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.methods.HttpRequestBase;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//
//import java.nio.charset.Charset;
//import java.util.*;
//import java.util.Map.Entry;
//
//public class HttpClient {
//
//    private static final String SCHEDULER_URL = "http://localhost:8080";
//
//    private static final int CONNECT_TIMEOUT = 3000;
//    private static final int CONNECTION_REQUEST_TIMEOUT = 3000;
//    private static final int SOCKET_TIMEOUT = 5000;
//
//    public static final String METHOD_NAME_GET = "GET";
//    public static final String METHOD_NAME_POST = "POST";
//
//    public static final String CHARSET_UTF8 = "utf-8";
//    public static final String URL_PATH_SPLIT= "/";
//
//    public static final String HEADER_KEY_CONTENT_TYPE = "Content-Type";
//    public static final String CONTENT_TYPE_VALUE_APPLICATION_JSON = "application/json; charset="+CHARSET_UTF8;
//
//    public static final String STATUS_OK_STR = "ok";
//
//    public static final int STATUS_OK = 200;
//    public static final int RETRY_TIMES = 2;
//    public static final long RETRY_INTEVAL_TIME = 100L;
//
//
//    public static void main(String[] args) {
//        String apiPath = "/task/3/update";
//        Map<String, Object> params = new HashMap<String, Object>(){{
//            put("role", "role");
//        }};
//
//        String result = callApi(METHOD_NAME_POST, apiPath, params);
//
//        System.out.println("----------");
//        System.out.println(result);
//    }
//
//    private static String callApi(String method, String path, Map<String, Object> params) {
//        String url = (SCHEDULER_URL.endsWith(URL_PATH_SPLIT) ? SCHEDULER_URL : SCHEDULER_URL + "/") + path;
//        Map<String, String> headers = new HashMap<String, String>(){{
//            put(HEADER_KEY_CONTENT_TYPE, CONTENT_TYPE_VALUE_APPLICATION_JSON);
//        }};
//        String result = "";
//        try {
//            result = RetryUtil.retry(() -> httpRequest(method, url, params, headers, CHARSET_UTF8), Optional.empty()
//                , new Exception("call api failed after retry " + RETRY_TIMES + " times, url: " + url, null)
//                , RETRY_TIMES, RETRY_INTEVAL_TIME);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        return result;
//    }
//
//    private static String httpRequest(String method, String url, Map<String, Object> params,
//            Map<String, String> headers, String charset) throws Exception {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        CloseableHttpResponse response = null;
//        String result = "";
//        try {
//            //trim url
//            url = url.trim();
//
//            // build request
//            HttpRequestBase httpRequest = null;
//            if (method.equals(METHOD_NAME_POST)) {
//                HttpPost httpPost = new HttpPost(url);
//
//                if (params != null && !params.isEmpty()) {
//                    if (headers != null && CONTENT_TYPE_VALUE_APPLICATION_JSON.equals(headers.get(HEADER_KEY_CONTENT_TYPE))) {
//                        String jsonString = new JSONObject(params).toJSONString();
//                        httpPost.setEntity(new StringEntity(jsonString, Charset.forName(charset)));
//                    } else {
//                        List<NameValuePair> args = new ArrayList<>();
//                        for (Entry<String, Object> entry : params.entrySet()) {
//                            args.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
//                        }
//                        httpPost.setEntity(new UrlEncodedFormEntity(args, Charset.forName(charset)));
//                    }
//                }
//
//                httpRequest = httpPost;
//            } else {
//                if (params != null && !params.isEmpty()) {
//                    url = url.endsWith("?") ? url : url + "?";
//                    StringBuilder requestUrl = new StringBuilder(url);
//                    for (Entry<String, Object> entry : params.entrySet()) {
//                        requestUrl.append(entry.getKey()).append("=").append(entry.getValue().toString()).append("&");
//                    }
//                    url = requestUrl.deleteCharAt(requestUrl.length() - 1).toString();
//                }
//
//                httpRequest = new HttpGet(url);
//            }
//
//            // set request config
//            httpRequest.setConfig(
//                RequestConfig.custom()
//                .setConnectTimeout(CONNECT_TIMEOUT)
//                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
//                .setSocketTimeout(SOCKET_TIMEOUT)
//                .build()
//            );
//
//            // add headers
//            if (headers != null && !headers.isEmpty()) {
//                for (Entry<String, String> entry : headers.entrySet()) {
//                    httpRequest.addHeader(entry.getKey(), entry.getValue());
//                }
//            }
//
//            // execute request
//            response = httpClient.execute(httpRequest);
//
//            // get response result
//            int statusCode = response.getStatusLine().getStatusCode();
//            if (statusCode == STATUS_OK) {
//                result = EntityUtils.toString(response.getEntity(), charset);
//            } else {
//                String message = "get response result error, status: " + statusCode + ", response: ";
//                HttpEntity entity = response.getEntity();
//                if (entity != null) {
//                    message += EntityUtils.toString(entity, charset);
//                }
//                throw new Exception(message, null);
//            }
//        } catch (Exception e) {
//            throw new Exception("httpRequest exception: "+ e.toString());
//        }finally {
//            try{
//                httpClient.close();
//            } catch (Exception e){
//                System.out.println("Close httpClient exception:" + e.toString());
//            }
//        }
//
//        return result;
//    }
//}
