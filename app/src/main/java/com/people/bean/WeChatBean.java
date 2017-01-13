package com.people.bean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2017/1/13.
 */
public class WeChatBean {


    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-01-12","title":"千万别拔剑啊姑娘，你会害死鬼怪大叔的！！","description":"果壳网","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/icZklJrRfHgBMPVw4lUj2RE2jhBA8fKVbrAX3wHVTAGiburwSVJibaCfMOA2QnWaIpwpA3NibSHLvribOJcibbgsa6LA/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/JK3ebL0QrSoa7H6cxI3SIg"},{"ctime":"2017-01-12","title":"从17万本书中挑出的40本好书","description":"warfalcon","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/wNByw5VpECgoBWKk33ZLKzibPUwOqg90qTWKf2v4cuYkeIx7DmUzaTvWymzcNHdqnz3mh3kmibSRxxKXQBIU3DQw/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/rFZfEDCwoUUXq6S-e02Rqg"},{"ctime":"2017-01-12","title":"收视打败《新闻联播》的国产剧，不看太可惜","description":"电影铺子","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/3N8gA4Fjgv7powj9DKPd7VdZ62rib74nP1vVDRSx0UM3CySkFRV3BS0MTTc3R5ZWBmPKt4Tnibh5uL6FTPUU7x6Q/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/dIkh-hmZu_ebJm8leE9h0g"},{"ctime":"2017-01-12","title":"如果你还年轻，如何思考未来？这是我看到的最佳建议，没有之一","description":"插坐学院","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/noz2jw2hPlUH3FKPDDJ2XsjzXWO9pqdqSFHmO8qTsUBHBbqNPWpPjXb8OmztsyXXdic8Z0N97uGcxKenIic9pgCw/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/7osMlAP9yxYMlZI5Z8eaQw"},{"ctime":"2017-01-12","title":"腾讯年会不雅照片流出，相关人员已被处分！","description":"互联网新鲜事","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/7rGQr7yPGJq35G1fkHsY77fXJlumpZIdVoQXSoqHCu5jRANxOgg3ob7iaP4ia4TMJttEAvNHsI9AuvfRjJWiblWHQ/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/hYUFG7q_paKVImhcf-Z4mQ"},{"ctime":"2017-01-12","title":"每逢新年「过三关」！你准备好了吗？","description":"活法儿","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/fpcvIhMQKB89gIq9CAq5ly8ZlhFvugJffv9hj2mHdtV6Varicqxzo4ov2LuHDDibSbE0Kw3y3L5E7ZiaGBsGJfnWA/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/NKa22zr46MNf6oMYF0-Dhw"},{"ctime":"2017-01-12","title":"这款VR 追踪器，国外媒体都在传","description":"月光博客","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/EFslqW2FxBOBJkEuBFySHxvMbGuhrhiaUM7G3rjVVxqqrf3IZ50GPiarutuNyy9zSTPhN1EdrlVcJWuQhPFQGfrw/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/ZZpdh2opgdhU85K1T6N1DA"},{"ctime":"2017-01-12","title":"为什么创业者和投资人都觉得委屈？","description":"科技50","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/L1J18UvsdP0DJZ83f5n6CTeu1hacvI41mofgSBuibctHiacJDE53PP9YibvYJqL34fzUCTK8XmHaDUAM0NlFiahRaw/640?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/VxufVov__iSSt0lXWhOKuQ"},{"ctime":"2017-01-12","title":"人类有了新款远房亲戚！云南发现新种长臂猿","description":"果壳网","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/icZklJrRfHgBMPVw4lUj2RE2jhBA8fKVbvlV5EmiaJXicUBQbtmCfyz6Cth94NumxFsdDiafGDRqhanPvz922Hz6Ug/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/lCsFVmbOlVbv6FThuWY5aw"},{"ctime":"2017-01-12","title":"开房不用前台登记，刷脸入住酒店真的来了！","description":"腾讯","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/jhgibzXKDS2UxWR4tAsDakTSmOl9hsrBRQWHialmXqUFEO2BJq23atODbsX8cacuwsmBT3hsuxic1K3V7O3y5Ce4A/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/0YJirFMHbvxr3Y1i_-w5AA"},{"ctime":"2017-01-12","title":"清华学霸18年没离开五道口，40岁不谈女朋友，减压方式竟是靠加班！","description":"腾讯开放平台","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/G90fHajFFtiazN7IGSj40xynh3xcJ1k3M9etQvcia1LD8uiaxCskNQH8GLtqvwxdwTicD8oxabibrwCdicvOrbIxbDxA/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/w5c28YdtShtB1tsAf3FAIg"},{"ctime":"2017-01-12","title":"阿司匹林：有病治病，无病强身？","description":"丁香医生","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/Pvr3FasqXd4PLdaZaLbmX8IZY2b338s5ID8TLKwZqhibySiabrVKkVEkicrAzUvKxrsOaEmyhYk8tBk2szja1CksA/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/39zJKTb1unHXA9eDF5HHdQ"},{"ctime":"2017-01-12","title":"一个直播网红一个敏感词大V一个广告文案，他们的诗你都背过","description":"朕说","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/6tESGUacf90bmF7OdTqM7YTkLjteOQthBUOK4nSAc7e9vDdkHyNSD57yPLW2wh6GUHZFvawuodWw6XjfGLiaEHw/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/UkaFp_G5YeWHpfr6ZtVf7g"},{"ctime":"2017-01-12","title":"你有资格认命吗","description":"新世相","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/5ROs96OaibIn1BOcicFoIUlibZuf95ybpZwV0HwFSw3IqAqtef8ibCn9haw4w2Mk9ic27yib9dPXzILUEDqTqqPm09cw/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/H44Vf4L47oIm21fA84MGwQ"},{"ctime":"2017-01-12","title":"非要劝酒，你不喝他还不高兴？这种人还能不能做朋友啦！","description":"果壳网","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/icZklJrRfHgDVVYRDsLA7BOicecF5nvXvz0wNwAGSibOQM3rnE3jhndQrqWCDWjAAQHZtBiazsHwiclkyCano6D21Ww/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/EIDGoSr-AfTaN_CKZJcp5g"},{"ctime":"2017-01-11","title":"罗玉凤：求祝福，求鼓励","description":"我就是凤姐","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/LXUzxjZKhjpacnDo8Hspsq77Fgbf4h4Ceww6zicaQLlNY9Oh49LhKO0I6ybvyTLWaeOPb0ozyACZxqQ6C6Rh8eA/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/gNZV-TSdVM96O4Mdln5KHQ"},{"ctime":"2017-01-10","title":"我为什么憎恨心灵鸡汤？","description":"快站服务","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/oibWjKibwj6b6PibnTyia2RxKKZ7gk8JQyWFbAroahVHNwiabFmlsAwGjsqPYc4qEKcuaLBEwI9icN2AqCwNAhODhawQ/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/lIslHWsBHiv49J5CtWSAdA"},{"ctime":"2017-01-10","title":"川普会见马云态度大变，称要一起做件了不起的大事！","description":"互联网新鲜事","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/7rGQr7yPGJoUqopVfkXFlLRI16TGLRiaUzGsJzyV4MHxrnmL48biaNjQGhzO0Ho8XZic66eU5D0m3gdH5xZMicps2Q/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/IESqpqeXTcD0EKFMDgA0Dg"},{"ctime":"2017-01-10","title":"打脸梅姨，真相：川普从未嘲笑残疾记者","description":"丁辰灵","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/nC7NY1lbn4UgCFKQiawk4iapekX0YsCcaVKMsop2ga9PhdzENKZUtuTSHmdIkELvuf09PsZGgGSQthiaG8sxBWgicA/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/_azkz9qcKf1WYdlDCMLVXQ"},{"ctime":"2017-01-10","title":"支付宝，你就不能好好做个钱包吗？","description":"槽边往事","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/Ia6gU9JNtkq9H5fnfTIZVrwc18C2N38jr42Y2nNOv8j0Z2o2ibgyvYDGjaHtiaj3IOgptffiadFjJpjD1RRkpLwWw/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/ntXvCzr6PzcjyZy__gHvLQ"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2017-01-12
     * title : 千万别拔剑啊姑娘，你会害死鬼怪大叔的！！
     * description : 果壳网
     * picUrl : http://mmbiz.qpic.cn/mmbiz_png/icZklJrRfHgBMPVw4lUj2RE2jhBA8fKVbrAX3wHVTAGiburwSVJibaCfMOA2QnWaIpwpA3NibSHLvribOJcibbgsa6LA/0?wx_fmt=png
     * url : http://mp.weixin.qq.com/s/JK3ebL0QrSoa7H6cxI3SIg
     */

    private List<NewslistBean> newslist;

    public static WeChatBean objectFromData(String str) {

        return new Gson().fromJson(str, WeChatBean.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public static NewslistBean objectFromData(String str) {

            return new Gson().fromJson(str, NewslistBean.class);
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
