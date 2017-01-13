package com.people.bean;

import java.util.List;

import bw.com.likqlibrary.bean.ResponseBean;

/**
 * Created by Administrator on 2017/1/6.
 */
public class NewsBean extends ResponseBean {

    /**
     * date : 20161230
     * stories : [{"images":["http://pic1.zhimg.com/0657e7b67b5fa45af69b36b9f8eb81c8.jpg"],"type":0,"id":9098132,"ga_prefix":"123020","title":"选择困难症晚期，该怎么拯救自己？"},{"images":["http://pic1.zhimg.com/74168c3d1dc42158affdb2e33a014064.jpg"],"type":0,"id":9101251,"ga_prefix":"123020","title":"刷了这么多年美剧英语也没变好，肯定是「看错了」"},{"images":["http://pic1.zhimg.com/f580a08af11a56f39f8114b609f2cb5c.jpg"],"type":0,"id":9109903,"ga_prefix":"123018","title":"在台湾，同性婚姻法案通过了初审"},{"images":["http://pic1.zhimg.com/7ad7378eb08739b9bfbad06920039ccc.jpg"],"type":0,"id":9086239,"ga_prefix":"123016","title":"用了一点计算机技能，整个生活都不一样了"},{"images":["http://pic1.zhimg.com/d4301947117d5f8f1cb9b47b27f35588.jpg"],"type":0,"id":9103513,"ga_prefix":"123015","title":"跳槽前，想好这 3 个问题"},{"images":["http://pic1.zhimg.com/40e42971c222a8a02ec508d9daac2620.jpg"],"type":0,"id":9109113,"ga_prefix":"123014","title":"中国埃博拉疫苗研究获得重大突破，但是还不能下定论"},{"images":["http://pic1.zhimg.com/4997a1f56128d0b45a21ddc430baa1bc.jpg"],"type":0,"id":9109102,"ga_prefix":"123013","title":"哪些思维方式是你刻意训练过的？"},{"images":["http://pic4.zhimg.com/7173dc18bffda3acc555a49a3f7af9c7.jpg"],"type":0,"id":9107792,"ga_prefix":"123012","title":"大误 · 我很欣赏你，不如我把女儿嫁给你？"},{"title":"想为《魔兽世界》里牺牲的兔子们默哀三秒","ga_prefix":"123011","images":["http://pic4.zhimg.com/78dcb7e2f546823df87ddcf6e21fcb37.jpg"],"multipic":true,"type":0,"id":9108424},{"images":["http://pic1.zhimg.com/099efceb17f9ea7d52dcc61ebe82e880.jpg"],"type":0,"id":9088824,"ga_prefix":"123010","title":"不习惯直系领导的管理风格，应该怎么办？"},{"images":["http://pic4.zhimg.com/90acad2b4705405f5f14c5d77f02239f.jpg"],"type":0,"id":9107334,"ga_prefix":"123009","title":"有哪些大牛在自己相关领域被打脸的故事？"},{"images":["http://pic3.zhimg.com/b8c62ca71fb016116db5e294fa8aa326.jpg"],"type":0,"id":8678472,"ga_prefix":"123008","title":"孩子说话爱用叠词，因为他们比我们想象的要聪明多了"},{"images":["http://pic1.zhimg.com/d4fdc01009ed51588b2f702e2ca23db8.jpg"],"type":0,"id":9108309,"ga_prefix":"123007","title":"这个百变的原生木材家具，却常常被我们浪费"},{"images":["http://pic3.zhimg.com/f32511a9a89ee288f49b8ea0e2b121ba.jpg"],"type":0,"id":9108380,"ga_prefix":"123007","title":"微信小程序和网页版程序的区别在哪里？"},{"images":["http://pic2.zhimg.com/9b71f6843759543390fb4b9843480079.jpg"],"type":0,"id":9108397,"ga_prefix":"123007","title":"2016 年度盘点 · 你被哪一波商业潮流影响了？"},{"images":["http://pic2.zhimg.com/ba40280ffbff7068cd33b717886f347d.jpg"],"type":0,"id":9106695,"ga_prefix":"123006","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic3.zhimg.com/23eb54d7d0328dce39ae908f52587736.jpg","type":0,"id":9109903,"ga_prefix":"123018","title":"在台湾，同性婚姻法案通过了初审"},{"image":"http://pic2.zhimg.com/0a7ea9c1e56ba8937959d791124d26cd.jpg","type":0,"id":9108424,"ga_prefix":"123011","title":"想为《魔兽世界》里牺牲的兔子们默哀三秒"},{"image":"http://pic1.zhimg.com/051d54d521840485725dc9588fb1d63c.jpg","type":0,"id":9108397,"ga_prefix":"123007","title":"2016 年度盘点 · 你被哪一波商业潮流影响了？"},{"image":"http://pic2.zhimg.com/f388ad82ffe062736aeb3ada3a981129.jpg","type":0,"id":9108380,"ga_prefix":"123007","title":"微信小程序和网页版程序的区别在哪里？"},{"image":"http://pic2.zhimg.com/1c5fca7f9f79287e91ed260cbd143d21.jpg","type":0,"id":9107334,"ga_prefix":"123009","title":"有哪些大牛在自己相关领域被打脸的故事？"}]
     */

    public String date;

    @Override
    public String toString() {
        return "RibaoBean{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", top_stories=" + top_stories +
                '}';
    }

    public List<StoriesBean> stories;
    public List<TopStoriesBean> top_stories;

    public static class StoriesBean {
        /**
         * images : ["http://pic1.zhimg.com/0657e7b67b5fa45af69b36b9f8eb81c8.jpg"]
         * type : 0
         * id : 9098132
         * ga_prefix : 123020
         * title : 选择困难症晚期，该怎么拯救自己？
         * multipic : true
         */

        public int type;
        public int id;
        public String ga_prefix;

        @Override
        public String toString() {
            return "StoriesBean{" +
                    "type=" + type +
                    ", id=" + id +
                    ", ga_prefix='" + ga_prefix + '\'' +
                    ", title='" + title + '\'' +
                    ", multipic=" + multipic +
                    ", images=" + images +
                    '}';
        }

        public String title;
        public boolean multipic;
        public List<String> images;
    }

    public static class TopStoriesBean {
        /**
         * image : http://pic3.zhimg.com/23eb54d7d0328dce39ae908f52587736.jpg
         * type : 0
         * id : 9109903
         * ga_prefix : 123018
         * title : 在台湾，同性婚姻法案通过了初审
         */

        public String image;

        @Override
        public String toString() {
            return "TopStoriesBean{" +
                    "image='" + image + '\'' +
                    ", type=" + type +
                    ", id=" + id +
                    ", ga_prefix='" + ga_prefix + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }

        public int type;
        public int id;
        public String ga_prefix;
        public String title;
    }

}

