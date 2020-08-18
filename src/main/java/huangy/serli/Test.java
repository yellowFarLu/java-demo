package huangy.serli;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huangy on 2019-05-09
 */
public class Test {

    public static void main(String[] args) {
        String origin  = "geneplus;bjqxwh;bjzyjk123;xinrun;szavnit;scxd99;zs7057071;loveo2team;boyan2018;hzsqdz;jmhcam;ihengyou888;sddzyygs;60080;bjwtjykjyx;fzgytsm;ylj100;fs;xidai888;577631;sdzswl;gmwlkj;anyjia;bjlyzy;fjhxbx;hyqc88;qfnykj;wxcz888;jsxg99;ericksonchina;jnstsm;tymj888;dgjinshi;eglass;282489;whxrskj;sharrow;dgalevo;gzxfy8;aimmax;522688;mly2016;riswein;542662;liegehi888;hnyasheng;hongyun888;547465;596856;552456;zhangtao108;ncycymy;jiaruiyang;shsxdt;boweiwedding;xuexibao;joeyex;keruyun;exacloud;anjie120;cqpppkj;lztywhcm;bjsj2018;sccx4008037102;mrj888;kuaiyidianti;xuanjia;lrhealth;zjtqc8;hsnyyx;zhouyou;hzshujie;wxsdjc;nbyhsl;happyfarmbj;pacspazg;szrd2018;fxxkjs;pmcore;cq_zfwl;wxforever;yt05352151812;573755;fstest1214;tjgfklyl;xlm168;changeway;djsy2018;sxrcny;dlrgzs;hywh186;421080;msc001;259335;rsyjkkj;539307;gzaoin;626285;nnjy2018;fktest;489068;shygwl;633005;kelafangjin;strontech;fktest087;158833;shmndjk;549620;422204;hztccdn;jstmxags;hongyingwuye;sheqiyongyi;";
        String now = "geneplus;bjqxwh;bjzyjk123;xinrun;szavnit;scxd99;zs7057071;loveo2team;boyan2018;jmhcam;ihengyou888;sddzyygs;60080;bjwtjykjyx;fzgytsm;ylj100;xidai888;577631;sdzswl;gmwlkj;anyjia;bjlyzy;fjhxbx;hyqc88;qfnykj;wxcz888;jsxg99;ericksonchina;jnstsm;tymj888;dgjinshi;eglass;282489;whxrskj;sharrow;dgalevo;gzxfy8;aimmax;mly2016;liegehi888;hnyasheng;hongyun888;547465;596856;zhangtao108;ncycymy;jiaruiyang;shsxdt;boweiwedding;xuexibao;keruyun;exacloud;anjie120;cqpppkj;lztywhcm;bjsj2018;sccx4008037102;mrj888;kuaiyidianti;xuanjia;lrhealth;zjtqc8;hsnyyx;zhouyou;hzshujie;wxsdjc;nbyhsl;happyfarmbj;pacspazg;szrd2018;fxxkjs;pmcore;cq_zfwl;wxforever;yt05352151812;573755;fstest1214;tjgfklyl;xlm168;changeway;sxrcny;dlrgzs;hywh186;msc001;rsyjkkj;539307;gzaoin;626285;489068;shygwl;633005;kelafangjin;strontech;158833;shmndjk;549620;422204;hztccdn;jstmxags;hongyingwuye;sheqiyongyi;";

        String[] originArr = origin.split(";");
        String[] nowArr = now.split(";");

        List<String> originList = new ArrayList<>();
        Collections.addAll(originList, originArr);

        List<String> nowList = new ArrayList<>();
        Collections.addAll(nowList, nowArr);

        originList.removeAll(nowList);

        System.out.println(originList);
    }

}
