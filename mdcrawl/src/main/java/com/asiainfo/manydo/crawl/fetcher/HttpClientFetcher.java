package com.asiainfo.manydo.crawl.fetcher;

//import com.asiainfo.beijingyidongcrawler.spring.SpringManage;
import com.asiainfo.manydo.crawl.spring.SpringManage;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

@Slf4j
public class HttpClientFetcher implements Fetcher{


    public HttpClientFactory httpClientFactory = SpringManage.getBean(HttpClientFactory.class);
    public HttpClientFetcher() {
    }
//    /**
//     * 携带头信息下载网络图片
//     * @param url 图片url
//     * @param formatName 文件格式名称
//     * @param localFile 下载到本地文件
//     * @param headers http协议交互中header信息，如Cookie
//     * @return 下载是否成功
//     */
//    public static boolean downloadImageWithHeaders(String imageUrl, String formatName, File localFile, Map<String, String> headers) {
//        boolean isSuccess = false;
//        InputStream stream = null;
//        try {
//            URL url = new URL(imageUrl);
//            URLConnection conn = url.openConnection();
//            if (headers != null && !headers.isEmpty()) {
//                //设置头信息
//                for (Map.Entry<String, String> entry : headers.entrySet()) {
//                    conn.setRequestProperty(entry.getKey(), entry.getValue());
//                }
//            }
//            conn.setDoInput(true);
//            stream = conn.getInputStream();
//            BufferedImage bufferedImg = ImageIO.read(stream);
//            if (bufferedImg != null) {
//                isSuccess = ImageIO.write(bufferedImg, formatName, localFile);
//            } else {
//                throw new RuntimeException("图片[" + imageUrl + "]下载失败");
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (stream != null) {
//                try {
//                    stream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return isSuccess;
//    }

/*
* 访问房天下网站
*
* 访问网页、创建文件
读取文件内容 存储文件内容 到 reStr
删除文件
* */
    public String sendGetRequestOfFangTianXia(String urlStr){
        String reStr = "";
        String shpath = "curl \""+urlStr+"\" -H \"referer: https://xian.esf.fang.com/\" --compressed >> page/curl.txt";
        String[] cmd = new String[]{"sh","-c",shpath};
        String fName ="./page/curl.txt";

        Process ps = null;
//        删除文件
        shpath = "rm -rf page/*";
        cmd[2] = shpath;
        try {
            ps = Runtime.getRuntime().exec(cmd);
            ps.waitFor();
        } catch (Exception e) {
            log.error("",e);
        }
//        访问网页、创建文件
        try {
            ps = Runtime.getRuntime().exec(cmd);
            ps.waitFor();
        } catch (Exception e) {
            log.error("",e);
        }
//        读取文件内容 存储文件内容 到 reStr
        try {
            reStr = readFileGBK(fName);
        }catch (Exception e){
            log.error("",e);
        }


        return reStr;
    }
    private static String readFileGBK(String file) throws IOException {
        File f = new File(file);
        InputStreamReader read = new InputStreamReader(new FileInputStream(f),
                "GBK");
        BufferedReader reader = new BufferedReader(read);
        String line;
        String s = "";
        while ((line = reader.readLine()) != null) {
            s = s+line;
        }
        return s;
    }

/*
* 最后没有使用
* */
/*

    public String testCurl(String urlStr) throws java.lang.Exception {
        URL url = new URL(urlStr);

        URLConnection conn = url.openConnection();//获得UrlConnection 连接对象
        conn.setRequestProperty("referer","https://xian.esf.fang.com/house/i32/");
        conn.setDoInput(true);
        InputStream is = conn.getInputStream();//获得输入流
//        log.info(" conn.getContentEncoding() ");
//        获取编码格式
        log.info(conn.getContentEncoding());


        BufferedReader br = new BufferedReader(new InputStreamReader(is,"gb2312"));//buffered表示缓冲类


        StringBuffer reStr = new StringBuffer();
        String str;
        while (null != (str = br.readLine())) {
            reStr.append("\r\n").append(str);
//            String out = new String(str.getBytes());
            reStr.append("\r\n").append(str);
//            System.out.println(str);
        }
        br.close();
        return reStr.toString();
//        return "";
    }
*/


    public String sendGetRequestOfBaiDu(String urlStr) throws Exception {
        URL url = new URL(urlStr);

        URLConnection conn = url.openConnection();//获得UrlConnection 连接对象
        InputStream is = conn.getInputStream();//获得输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"gb2312"));//buffered表示缓冲类
        StringBuffer reStr = new StringBuffer();
        String str;
        while (null != (str = br.readLine())) {
            reStr.append("\r\n").append(str);
//            String out = new String(str.getBytes());
//            System.out.println(str);
        }
        br.close();
        return reStr.toString();
    }


    public String sendGetRequest(String url) {
        try {
            int time = new Random().nextInt(10);//随机休眠几秒
            Thread.sleep(1000l * time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            return httpClientFactory.sendGetRequest(url);
    }



//    通过url get 访问 网页  返回  String
//@Override
//public String sendGetRequest(String url) {
//    try {
//        int time = new Random().nextInt(10);//随机休眠几秒
//        Thread.sleep(1000l * time);
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
//
//
//    CloseableHttpClient httpClient = HttpClients.createDefault();
////        代理对象
////    现场代理
////        HttpHost proxy = new HttpHost("proxy.bmcc.com.cn", 18765, "http");
////    开发代理
//    HttpHost proxy = new HttpHost("proxy.asiainfo.com", 8080, "http");
//    //配置对象
//    RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
//    //创建请求方法的实例， 并指定请求url
//    HttpGet httpget=new HttpGet(url);
//    String content = new String();
//    //使用配置
//    try {
//        httpget.setConfig(config);
//        CloseableHttpResponse response = httpClient.execute(httpget);
//        HttpEntity entity = response.getEntity();
//        content = EntityUtils.toString(entity, "utf-8");
////        System.out.println(content);
//        httpClient.close();
//    }catch (Exception e){
//        log.info(" 访问网页出错 ： ",e);
//    }
//    return content;
//}




}
