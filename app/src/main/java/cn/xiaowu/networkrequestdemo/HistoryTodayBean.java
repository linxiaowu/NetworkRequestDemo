package cn.xiaowu.networkrequestdemo;

import java.util.List;

/**
 * Created by linxiaowu on 2016/11/9.
 * 历史今日Bean
 */
public class HistoryTodayBean {


    /**
     * total : 10
     * result : [{"year":1997,"month":1,"day":2,"title":"科菲·安南正式就任联合国秘书长","type":1},{"year":1992,"month":1,"day":2,"title":"我国与乌兹别克斯坦建交","type":1},{"year":1992,"month":1,"day":2,"title":"加利就任第六届联合国秘书长","type":1},{"year":1980,"month":1,"day":2,"title":"我国与厄瓜多尔建交","type":1},{"year":1977,"month":1,"day":2,"title":"洛阳黄河公路大桥建成通车","type":1},{"year":1966,"month":1,"day":2,"title":"《人民日报》介绍大庆人建设经验","type":1},{"year":1963,"month":1,"day":2,"title":"第一次断臂再植成功","type":1},{"year":1952,"month":1,"day":2,"title":"罗盛教抢救朝鲜儿童异国献身","type":1},{"year":1923,"month":1,"day":2,"title":"《中国国民党党纲》公布","type":1},{"year":1875,"month":1,"day":2,"title":"爱国民主人士沈钧儒诞辰","type":1}]
     * error_code : 0
     * reason : Succes
     */

    private int total;
    private int error_code;
    private String reason;
    private List<ResultEntity> result;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public static class ResultEntity {
        /**
         * year : 1997
         * month : 1
         * day : 2
         * title : 科菲·安南正式就任联合国秘书长
         * type : 1
         */

        private int year;
        private int month;
        private int day;
        private String title;
        private int type;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
