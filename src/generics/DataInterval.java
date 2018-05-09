package generics;

import sun.util.resources.LocaleData;

/**
 * Created by zhoutailiang on 2018/5/8.
 */
public class DataInterval extends Pair<LocaleData> {
    @Override
    public void setSecond(LocaleData second) {
        super.setSecond(second);
    }

    @Override
    public LocaleData getSecond() {
        return super.getSecond();
    }
}
