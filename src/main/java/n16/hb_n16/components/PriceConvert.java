package n16.hb_n16.components;

import java.text.DecimalFormat;

public class PriceConvert {
    public String chuyenMoney(double money){
        DecimalFormat df = new DecimalFormat("#,##0.0");
        String s = df.format(money);
        return s;
    }
}
