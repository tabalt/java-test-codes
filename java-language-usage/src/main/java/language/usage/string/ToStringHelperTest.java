package language.usage.string;

import com.alibaba.fastjson.JSONObject;

import static com.google.common.base.MoreObjects.toStringHelper;

public class ToStringHelperTest {

    public static void main(String[] args) {

        NodeInfo nodeInfo = new NodeInfo();
        nodeInfo.setJdbcUrl("127.0.0.1:3001");
        nodeInfo.setApiUrl("127.0.0.1:3002");

        System.out.println(nodeInfo.toString());

        JSONObject jsonObject = JSONObject.parseObject(nodeInfo.toString());
        System.out.println(jsonObject.getString(NodeInfo.JDBC_URL));
        System.out.println(jsonObject.getString(NodeInfo.API_URL));
    }

    public static class NodeInfo {
        public static final String JDBC_URL = "jdbcUrl";
        public static final String API_URL = "apiUrl";

        String jdbcUrl;
        String apiUrl;

        public String getJdbcUrl() {
            return jdbcUrl;
        }

        public void setJdbcUrl(String jdbcUrl) {
            this.jdbcUrl = jdbcUrl;
        }

        public String getApiUrl() {
            return apiUrl;
        }

        public void setApiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
        }

        @Override
        public String toString() {
            return toStringHelper(this)
                    .add(JDBC_URL, jdbcUrl)
                    .add(API_URL, apiUrl)
                    .toString();
        }
    }
}
